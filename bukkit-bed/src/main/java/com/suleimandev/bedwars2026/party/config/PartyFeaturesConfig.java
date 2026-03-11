package com.suleimandev.bedwars2026.party.config;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class PartyFeaturesConfig extends ConfigManager {

    public PartyFeaturesConfig(@NotNull Plugin plugin) {
        super(plugin, "party-features", plugin.getDataFolder().getPath());

        YamlConfiguration yml = getYml();
        yml.options().header("BEDWARS 2026 party settings\nDeveloper: SuleimanDEV");

        yml.addDefault("invite.cooldown-seconds", 15);
        yml.addDefault("invite.expire-seconds", 60);
        yml.addDefault("chat.toggle-enabled", true);

        yml.addDefault("messages.help", Arrays.asList(
                "&8&m------------------------",
                "&6Party Commands",
                "&e/party create &7- Create your party",
                "&e/party invite <player> &7- Invite a player",
                "&e/party accept <player> &7- Accept an invite",
                "&e/party deny <player> &7- Deny an invite",
                "&e/party leave &7- Leave your party",
                "&e/party kick <player> &7- Kick a member",
                "&e/party promote <player> &7- Promote a member",
                "&e/party chat [message] &7- Toggle or send party chat",
                "&e/party list &7- Show party info",
                "&e/party warp &7- Pull members to your arena",
                "&e/party disband &7- Disband the party",
                "&8&m------------------------"
        ));
        yml.addDefault("messages.not-in-party", "&8[&6Party&8] &cYou are not in a party.");
        yml.addDefault("messages.not-leader", "&8[&6Party&8] &cOnly the party leader can do this.");
        yml.addDefault("messages.player-not-found", "&8[&6Party&8] &cPlayer &f{player}&c was not found.");
        yml.addDefault("messages.party-created", "&8[&6Party&8] &aYour party has been created.");
        yml.addDefault("messages.invite-sent", "&8[&6Party&8] &aInvite sent to &f{player}&a.");
        yml.addDefault("messages.invite-received", "&8[&6Party&8] &f{player} &einvited you to join the party. &7Use &f/party accept {player}&7.");
        yml.addDefault("messages.invite-expired", "&8[&6Party&8] &cThe invite from &f{player}&c expired.");
        yml.addDefault("messages.invite-denied", "&8[&6Party&8] &eYou denied the invite from &f{player}&e.");
        yml.addDefault("messages.invite-denied-target", "&8[&6Party&8] &f{player} &edenied your party invite.");
        yml.addDefault("messages.invite-self", "&8[&6Party&8] &cYou cannot invite yourself.");
        yml.addDefault("messages.invite-pending", "&8[&6Party&8] &cThat player already has a pending invite from you.");
        yml.addDefault("messages.invite-cooldown", "&8[&6Party&8] &cWait &f{seconds}s &cbefore sending another invite.");
        yml.addDefault("messages.already-in-party", "&8[&6Party&8] &cYou are already in a party.");
        yml.addDefault("messages.joined", "&8[&6Party&8] &f{player} &ajoined the party.");
        yml.addDefault("messages.left", "&8[&6Party&8] &f{player} &eleft the party.");
        yml.addDefault("messages.kicked", "&8[&6Party&8] &f{player} &cwas removed from the party.");
        yml.addDefault("messages.disbanded", "&8[&6Party&8] &cThe party has been disbanded.");
        yml.addDefault("messages.promoted-self", "&8[&6Party&8] &aYou promoted &f{player} &ato leader.");
        yml.addDefault("messages.promoted-target", "&8[&6Party&8] &aYou are now the party leader.");
        yml.addDefault("messages.promoted-notify", "&8[&6Party&8] &f{player} &eis now the party leader.");
        yml.addDefault("messages.owner-transferred", "&8[&6Party&8] &f{player} &eis now the party leader.");
        yml.addDefault("messages.owner-left-disbanded", "&8[&6Party&8] &cThe leader left and the party was disbanded.");
        yml.addDefault("messages.chat-enabled", "&8[&6Party&8] &aParty chat enabled.");
        yml.addDefault("messages.chat-disabled", "&8[&6Party&8] &eParty chat disabled.");
        yml.addDefault("messages.chat-format", "&8[&6Party&8] &f{player}&7: &r{message}");
        yml.addDefault("messages.list-header", "&8[&6Party&8] &6Party Overview");
        yml.addDefault("messages.list-leader", "&7Leader: &f{player}");
        yml.addDefault("messages.list-members", "&7Members: &f{players}");
        yml.addDefault("messages.no-invite", "&8[&6Party&8] &cThere is no invite from &f{player}&c.");
        yml.addDefault("messages.cannot-kick-self", "&8[&6Party&8] &cUse &f/party leave &cor &f/party disband&c.");
        yml.addDefault("messages.not-member", "&8[&6Party&8] &f{player} &cis not in your party.");
        yml.addDefault("messages.warp-no-arena", "&8[&6Party&8] &cYou must be in a waiting or starting arena to warp your party.");
        yml.addDefault("messages.warp-result", "&8[&6Party&8] &aWarped &f{amount} &aparty members.");
        yml.addDefault("messages.warp-empty", "&8[&6Party&8] &eNo party members were eligible to warp.");

        addDefaultSound(yml, "sounds.invite-sent", BukkitBedPlugin.getForCurrentVersion("ORB_PICKUP", "ENTITY_EXPERIENCE_ORB_PICKUP", "ENTITY_EXPERIENCE_ORB_PICKUP"));
        addDefaultSound(yml, "sounds.invite-received", BukkitBedPlugin.getForCurrentVersion("NOTE_PLING", "BLOCK_NOTE_BLOCK_PLING", "BLOCK_NOTE_BLOCK_PLING"));
        addDefaultSound(yml, "sounds.joined", BukkitBedPlugin.getForCurrentVersion("LEVEL_UP", "ENTITY_PLAYER_LEVELUP", "ENTITY_PLAYER_LEVELUP"));
        addDefaultSound(yml, "sounds.left", BukkitBedPlugin.getForCurrentVersion("NOTE_BASS", "BLOCK_NOTE_BLOCK_BASS", "BLOCK_NOTE_BLOCK_BASS"));
        addDefaultSound(yml, "sounds.promoted", BukkitBedPlugin.getForCurrentVersion("LEVEL_UP", "ENTITY_PLAYER_LEVELUP", "ENTITY_PLAYER_LEVELUP"));
        addDefaultSound(yml, "sounds.disbanded", BukkitBedPlugin.getForCurrentVersion("VILLAGER_NO", "ENTITY_VILLAGER_NO", "ENTITY_VILLAGER_NO"));
        addDefaultSound(yml, "sounds.chat", BukkitBedPlugin.getForCurrentVersion("CLICK", "UI_BUTTON_CLICK", "UI_BUTTON_CLICK"));

        yml.options().copyDefaults(true);
        save();
    }

    public int getInviteCooldownSeconds() {
        return getInt("invite.cooldown-seconds");
    }

    public int getInviteExpireSeconds() {
        return getInt("invite.expire-seconds");
    }

    public boolean isChatToggleEnabled() {
        return getBoolean("chat.toggle-enabled");
    }

    @NotNull
    public String message(@NotNull String path) {
        return ChatColor.translateAlternateColorCodes('&', getString("messages." + path));
    }

    @NotNull
    public List<String> messageList(@NotNull String path) {
        return getList("messages." + path);
    }

    public void playSound(@NotNull Player player, @NotNull String path) {
        String soundName = getString("sounds." + path + ".sound");
        if (soundName == null || soundName.equalsIgnoreCase("none")) {
            return;
        }
        try {
            Sound sound = Sound.valueOf(soundName);
            float volume = (float) getDouble("sounds." + path + ".volume");
            float pitch = (float) getDouble("sounds." + path + ".pitch");
            player.playSound(player.getLocation(), sound, volume, pitch);
        } catch (IllegalArgumentException ignored) {
        }
    }

    private void addDefaultSound(@NotNull YamlConfiguration yml, @NotNull String path, @NotNull String sound) {
        yml.addDefault(path + ".sound", sound);
        yml.addDefault(path + ".volume", 1.0D);
        yml.addDefault(path + ".pitch", 1.0D);
    }
}

