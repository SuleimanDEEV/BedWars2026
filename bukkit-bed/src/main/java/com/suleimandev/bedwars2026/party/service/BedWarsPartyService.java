package com.suleimandev.bedwars2026.party.service;

import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.party.Party;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.party.config.PartyFeaturesConfig;
import com.suleimandev.bedwars2026.party.model.PartyGroup;
import com.suleimandev.bedwars2026.party.model.PartyInvitation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class BedWarsPartyService implements Party {

    private final PartyFeaturesConfig config;
    private final Map<UUID, PartyGroup> partiesByMember = new ConcurrentHashMap<>();
    private final Map<UUID, Map<UUID, PartyInvitation>> invitesByTarget = new ConcurrentHashMap<>();
    private final Map<UUID, Long> inviteCooldowns = new ConcurrentHashMap<>();
    private final Set<UUID> partyChatEnabled = ConcurrentHashMap.newKeySet();

    public BedWarsPartyService(@NotNull PartyFeaturesConfig config) {
        this.config = config;
    }

    @Override
    public synchronized boolean hasParty(Player p) {
        return p != null && partiesByMember.containsKey(p.getUniqueId());
    }

    @Override
    public synchronized int partySize(Player p) {
        return getMembers(p).size();
    }

    @Override
    public synchronized boolean isOwner(Player p) {
        PartyGroup party = getPartyGroup(p);
        return party != null && party.getLeader().equals(p.getUniqueId());
    }

    @Override
    public synchronized List<Player> getMembers(Player owner) {
        PartyGroup party = getPartyGroup(owner);
        if (party == null) {
            return new ArrayList<>();
        }

        List<Player> result = new ArrayList<>();
        for (UUID memberId : party.getMembers()) {
            Player member = Bukkit.getPlayer(memberId);
            if (member != null && member.isOnline()) {
                result.add(member);
            }
        }
        return result;
    }

    @Override
    public synchronized void createParty(Player owner, Player... members) {
        if (owner == null) {
            return;
        }
        PartyGroup party = getOrCreateParty(owner);
        for (Player member : members) {
            if (member != null) {
                addMemberInternal(party, member);
            }
        }
        send(owner, "party-created", Collections.emptyMap());
    }

    @Override
    public synchronized void addMember(Player owner, Player member) {
        if (owner == null || member == null) {
            return;
        }
        PartyGroup party = getOrCreateParty(owner);
        addMemberInternal(party, member);
    }

    @Override
    public synchronized void removeFromParty(Player member) {
        if (member == null) {
            return;
        }
        PartyGroup party = getPartyGroup(member);
        if (party == null) {
            return;
        }

        party.getMembers().remove(member.getUniqueId());
        partiesByMember.remove(member.getUniqueId());
        partyChatEnabled.remove(member.getUniqueId());
        broadcast(party, "left", replacements("player", member.getName()));

        if (party.getMembers().isEmpty()) {
            return;
        }

        if (party.getLeader().equals(member.getUniqueId())) {
            UUID newLeader = party.getMembers().iterator().next();
            party.setLeader(newLeader);
            Player promoted = Bukkit.getPlayer(newLeader);
            if (promoted != null) {
                broadcast(party, "owner-transferred", replacements("player", promoted.getName()));
                config.playSound(promoted, "promoted");
            } else {
                dissolve(party, "owner-left-disbanded");
            }
        }
    }

    @Override
    public synchronized void disband(Player owner) {
        PartyGroup party = getPartyGroup(owner);
        if (party == null) {
            return;
        }
        dissolve(party, "disbanded");
    }

    @Override
    public synchronized boolean isMember(Player owner, Player check) {
        if (owner == null || check == null) {
            return false;
        }
        PartyGroup party = getPartyGroup(owner);
        return party != null && party.contains(check.getUniqueId());
    }

    @Override
    public synchronized void removePlayer(Player owner, Player target) {
        if (owner == null || target == null) {
            return;
        }
        PartyGroup party = getPartyGroup(owner);
        if (party == null || !party.contains(target.getUniqueId()) || target.equals(owner)) {
            return;
        }
        party.getMembers().remove(target.getUniqueId());
        partiesByMember.remove(target.getUniqueId());
        partyChatEnabled.remove(target.getUniqueId());
        broadcast(party, "kicked", replacements("player", target.getName()));
    }

    @Override
    public synchronized Player getOwner(Player member) {
        PartyGroup party = getPartyGroup(member);
        if (party == null) {
            return null;
        }
        return Bukkit.getPlayer(party.getLeader());
    }

    @Override
    public synchronized void promote(@NotNull Player owner, @NotNull Player target) {
        PartyGroup party = getPartyGroup(owner);
        if (party == null || !party.contains(target.getUniqueId())) {
            return;
        }
        party.setLeader(target.getUniqueId());
        send(owner, "promoted-self", replacements("player", target.getName()));
        send(target, "promoted-target", Collections.emptyMap());
        for (Player member : getMembers(owner)) {
            if (!member.equals(owner) && !member.equals(target)) {
                send(member, "promoted-notify", replacements("player", target.getName()));
            }
        }
        config.playSound(target, "promoted");
    }

    @Override
    public boolean isInternal() {
        return true;
    }

    public synchronized boolean invite(@NotNull Player owner, @NotNull Player target) {
        if (owner.equals(target)) {
            send(owner, "invite-self", Collections.emptyMap());
            return false;
        }
        long now = System.currentTimeMillis();
        long cooldownEnd = inviteCooldowns.getOrDefault(owner.getUniqueId(), 0L);
        if (cooldownEnd > now) {
            long seconds = Math.max(1L, (cooldownEnd - now) / 1000L);
            send(owner, "invite-cooldown", replacements("seconds", String.valueOf(seconds)));
            return false;
        }

        cleanupExpiredInvites();
        Map<UUID, PartyInvitation> invites = invitesByTarget.computeIfAbsent(target.getUniqueId(), key -> new LinkedHashMap<>());
        if (invites.containsKey(owner.getUniqueId())) {
            send(owner, "invite-pending", Collections.emptyMap());
            return false;
        }

        invites.put(owner.getUniqueId(), new PartyInvitation(owner.getUniqueId(), target.getUniqueId(), now));
        inviteCooldowns.put(owner.getUniqueId(), now + (config.getInviteCooldownSeconds() * 1000L));

        send(owner, "invite-sent", replacements("player", target.getName()));
        send(target, "invite-received", replacements("player", owner.getName()));
        config.playSound(owner, "invite-sent");
        config.playSound(target, "invite-received");
        return true;
    }

    public synchronized boolean acceptInvite(@NotNull Player target, @NotNull Player owner) {
        cleanupExpiredInvites();
        Map<UUID, PartyInvitation> invites = invitesByTarget.get(target.getUniqueId());
        if (invites == null || !invites.containsKey(owner.getUniqueId())) {
            send(target, "no-invite", replacements("player", owner.getName()));
            return false;
        }

        invites.remove(owner.getUniqueId());
        addMember(owner, target);
        broadcast(getPartyGroup(owner), "joined", replacements("player", target.getName()));
        config.playSound(target, "joined");
        return true;
    }

    public synchronized boolean denyInvite(@NotNull Player target, @NotNull Player owner) {
        cleanupExpiredInvites();
        Map<UUID, PartyInvitation> invites = invitesByTarget.get(target.getUniqueId());
        if (invites == null || invites.remove(owner.getUniqueId()) == null) {
            send(target, "no-invite", replacements("player", owner.getName()));
            return false;
        }

        send(target, "invite-denied", replacements("player", owner.getName()));
        send(owner, "invite-denied-target", replacements("player", target.getName()));
        return true;
    }

    public synchronized boolean toggleChat(@NotNull Player player) {
        if (!config.isChatToggleEnabled()) {
            return false;
        }
        boolean enabled;
        if (partyChatEnabled.contains(player.getUniqueId())) {
            partyChatEnabled.remove(player.getUniqueId());
            enabled = false;
        } else {
            partyChatEnabled.add(player.getUniqueId());
            enabled = true;
        }

        send(player, enabled ? "chat-enabled" : "chat-disabled", Collections.emptyMap());
        return enabled;
    }

    public synchronized boolean isPartyChatEnabled(@NotNull Player player) {
        return partyChatEnabled.contains(player.getUniqueId()) && hasParty(player);
    }

    public synchronized void sendPartyChat(@NotNull Player sender, @NotNull String message) {
        PartyGroup party = getPartyGroup(sender);
        if (party == null) {
            send(sender, "not-in-party", Collections.emptyMap());
            return;
        }

        Map<String, String> replacements = new LinkedHashMap<>();
        replacements.put("player", sender.getName());
        replacements.put("message", message);
        String formatted = apply(config.message("chat-format"), replacements);
        for (Player member : getMembers(sender)) {
            member.sendMessage(formatted);
            config.playSound(member, "chat");
        }
    }

    public synchronized void sendPartyInfo(@NotNull Player player) {
        PartyGroup party = getPartyGroup(player);
        if (party == null) {
            send(player, "not-in-party", Collections.emptyMap());
            return;
        }

        Player leader = Bukkit.getPlayer(party.getLeader());
        StringJoiner joiner = new StringJoiner(", ");
        for (Player member : getMembers(player)) {
            joiner.add(member.getName());
        }

        player.sendMessage(config.message("list-header"));
        player.sendMessage(apply(config.message("list-leader"), replacements("player", leader == null ? "Unknown" : leader.getName())));
        player.sendMessage(apply(config.message("list-members"), replacements("players", joiner.toString())));
    }

    public synchronized int warp(@NotNull Player owner) {
        PartyGroup party = getPartyGroup(owner);
        if (party == null) {
            send(owner, "not-in-party", Collections.emptyMap());
            return -1;
        }
        if (!isOwner(owner)) {
            send(owner, "not-leader", Collections.emptyMap());
            return -1;
        }

        IArena arena = Arena.getArenaByPlayer(owner);
        if (arena == null || (arena.getStatus() != GameState.waiting && arena.getStatus() != GameState.starting)) {
            send(owner, "warp-no-arena", Collections.emptyMap());
            return -1;
        }

        int moved = 0;
        for (Player member : getMembers(owner)) {
            if (member.equals(owner)) {
                continue;
            }
            IArena currentArena = Arena.getArenaByPlayer(member);
            if (currentArena != null && currentArena.isSpectator(member)) {
                currentArena.removeSpectator(member, false);
            } else if (currentArena != null && !currentArena.equals(arena)) {
                continue;
            }

            if (arena.addPlayer(member, true)) {
                moved++;
            }
        }
        return moved;
    }

    public synchronized void sendHelp(@NotNull Player player) {
        config.messageList("help").forEach(player::sendMessage);
    }

    @Nullable
    public synchronized Player resolvePlayer(String name) {
        Player player = Bukkit.getPlayerExact(name);
        if (player == null || !player.isOnline()) {
            return null;
        }
        return player;
    }

    public synchronized void handleOwnerArenaLeave(@NotNull Player player) {
        // Parties now persist when players switch arenas or return to lobby.
    }

    private void addMemberInternal(@NotNull PartyGroup party, @NotNull Player member) {
        PartyGroup currentParty = getPartyGroup(member);
        if (currentParty != null && currentParty != party) {
            removeFromParty(member);
        }
        party.getMembers().add(member.getUniqueId());
        partiesByMember.put(member.getUniqueId(), party);
    }

    @NotNull
    private PartyGroup getOrCreateParty(@NotNull Player owner) {
        PartyGroup existing = getPartyGroup(owner);
        if (existing != null) {
            return existing;
        }
        PartyGroup party = new PartyGroup(owner.getUniqueId());
        partiesByMember.put(owner.getUniqueId(), party);
        return party;
    }

    @Nullable
    private PartyGroup getPartyGroup(@Nullable Player player) {
        if (player == null) {
            return null;
        }
        return partiesByMember.get(player.getUniqueId());
    }

    private void dissolve(@NotNull PartyGroup party, @NotNull String messagePath) {
        for (UUID memberId : new LinkedList<>(party.getMembers())) {
            partiesByMember.remove(memberId);
            partyChatEnabled.remove(memberId);
            Player member = Bukkit.getPlayer(memberId);
            if (member != null && member.isOnline()) {
                send(member, messagePath, Collections.emptyMap());
                config.playSound(member, "disbanded");
            }
        }
        party.getMembers().clear();
    }

    private void cleanupExpiredInvites() {
        long expireAfter = config.getInviteExpireSeconds() * 1000L;
        long now = System.currentTimeMillis();
        invitesByTarget.forEach((targetId, invites) -> {
            List<UUID> expiredOwners = new ArrayList<>();
            for (PartyInvitation invitation : invites.values()) {
                if (invitation.getCreatedAt() + expireAfter <= now) {
                    expiredOwners.add(invitation.getOwner());
                    Player target = Bukkit.getPlayer(invitation.getTarget());
                    Player owner = Bukkit.getPlayer(invitation.getOwner());
                    if (target != null && owner != null) {
                        send(target, "invite-expired", replacements("player", owner.getName()));
                    }
                }
            }
            expiredOwners.forEach(invites::remove);
        });
    }

    private void broadcast(@Nullable PartyGroup party, @NotNull String messagePath, @NotNull Map<String, String> replacements) {
        if (party == null) {
            return;
        }
        for (Player member : onlineMembers(party)) {
            send(member, messagePath, replacements);
        }
    }

    @NotNull
    private Collection<Player> onlineMembers(@NotNull PartyGroup party) {
        List<Player> players = new ArrayList<>();
        for (UUID memberId : party.getMembers()) {
            Player player = Bukkit.getPlayer(memberId);
            if (player != null && player.isOnline()) {
                players.add(player);
            }
        }
        return players;
    }

    private void send(@NotNull Player player, @NotNull String messagePath, @NotNull Map<String, String> replacements) {
        player.sendMessage(apply(config.message(messagePath), replacements));
    }

    @NotNull
    private Map<String, String> replacements(@NotNull String key, @NotNull String value) {
        Map<String, String> replacements = new LinkedHashMap<>();
        replacements.put(key, value);
        return replacements;
    }

    @NotNull
    private String apply(@NotNull String input, @NotNull Map<String, String> replacements) {
        String output = input;
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            output = output.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        return output;
    }
}

