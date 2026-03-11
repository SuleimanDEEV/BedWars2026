package com.suleimandev.bedwars2026.commands.party;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.party.service.BedWarsPartyService;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class PartyCommand extends BukkitCommand {

    public PartyCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender s, String c, String[] args) {
        if (s instanceof ConsoleCommandSender) return true;
        if (!(BukkitBedPlugin.getParty() instanceof BedWarsPartyService)) {
            return true;
        }
        BedWarsPartyService partyService = (BedWarsPartyService) BukkitBedPlugin.getParty();
        Player p = (Player) s;
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            partyService.sendHelp(p);
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "create":
                if (!partyService.hasParty(p)) {
                    partyService.createParty(p);
                } else {
                    partyService.sendPartyInfo(p);
                }
                return true;
            case "invite":
                if (args.length == 1) {
                    partyService.sendHelp(p);
                    return true;
                }
                if (partyService.hasParty(p) && !partyService.isOwner(p)) {
                    partyService.sendPartyInfo(p);
                    return true;
                }
                Player inviteTarget = partyService.resolvePlayer(args[1]);
                if (inviteTarget == null) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("player-not-found").replace("{player}", args[1]));
                    return true;
                }
                if (partyService.invite(p, inviteTarget)) {
                    TextComponent accept = new TextComponent(" ");
                    TextComponent acceptButton = new TextComponent("Â§a[Accept]");
                    acceptButton.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/party accept " + p.getName()));
                    TextComponent denyButton = new TextComponent(" Â§c[Deny]");
                    denyButton.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/party deny " + p.getName()));
                    inviteTarget.spigot().sendMessage(accept, acceptButton, denyButton);
                }
                return true;
            case "accept":
                if (args.length < 2) {
                    partyService.sendHelp(p);
                    return true;
                }
                if (partyService.hasParty(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("already-in-party"));
                    return true;
                }
                Player inviteOwner = partyService.resolvePlayer(args[1]);
                if (inviteOwner == null) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("player-not-found").replace("{player}", args[1]));
                    return true;
                }
                partyService.acceptInvite(p, inviteOwner);
                return true;
            case "deny":
                if (args.length < 2) {
                    partyService.sendHelp(p);
                    return true;
                }
                Player denyOwner = partyService.resolvePlayer(args[1]);
                if (denyOwner == null) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("player-not-found").replace("{player}", args[1]));
                    return true;
                }
                partyService.denyInvite(p, denyOwner);
                return true;
            case "leave":
                if (!partyService.hasParty(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-in-party"));
                    return true;
                }
                partyService.removeFromParty(p);
                return true;
            case "disband":
                if (!partyService.hasParty(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-in-party"));
                    return true;
                }
                if (!partyService.isOwner(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-leader"));
                    return true;
                }
                partyService.disband(p);
                return true;
            case "kick":
            case "remove":
                if (args.length == 1) {
                    partyService.sendHelp(p);
                    return true;
                }
                if (!partyService.hasParty(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-in-party"));
                    return true;
                }
                if (!partyService.isOwner(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-leader"));
                    return true;
                }
                Player removeTarget = partyService.resolvePlayer(args[1]);
                if (removeTarget == null) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("player-not-found").replace("{player}", args[1]));
                    return true;
                }
                if (removeTarget.equals(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("cannot-kick-self"));
                    return true;
                }
                if (!partyService.isMember(p, removeTarget)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-member").replace("{player}", removeTarget.getName()));
                    return true;
                }
                partyService.removePlayer(p, removeTarget);
                return true;
            case "promote":
                if (!partyService.hasParty(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-in-party"));
                    return true;
                } else if (!partyService.isOwner(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-leader"));
                    return true;
                }
                if (args.length == 1) {
                    partyService.sendHelp(p);
                    return true;
                }
                Player promoteTarget = partyService.resolvePlayer(args[1]);
                if (promoteTarget == null) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("player-not-found").replace("{player}", args[1]));
                    return true;
                }
                if (!partyService.isMember(p, promoteTarget)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-member").replace("{player}", promoteTarget.getName()));
                    return true;
                }
                partyService.promote(p, promoteTarget);
                return true;
            case "chat":
                if (!partyService.hasParty(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-in-party"));
                    return true;
                }
                if (args.length == 1 || (args.length == 2 && args[1].equalsIgnoreCase("toggle"))) {
                    partyService.toggleChat(p);
                    return true;
                }
                partyService.sendPartyChat(p, joinArgs(args, 1));
                return true;
            case "info":
            case "list":
                if (!partyService.hasParty(p)) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("not-in-party"));
                    return true;
                }
                partyService.sendPartyInfo(p);
                return true;
            case "warp":
            case "join":
                int moved = partyService.warp(p);
                if (moved > 0) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("warp-result").replace("{amount}", String.valueOf(moved)));
                } else if (moved == 0) {
                    p.sendMessage(BukkitBedPlugin.partyFeatures.message("warp-empty"));
                }
                return true;
            default:
                partyService.sendHelp(p);
                return true;
        }
    }

    @NotNull
    private String joinArgs(@NotNull String[] args, int startIndex) {
        StringBuilder builder = new StringBuilder();
        for (int i = startIndex; i < args.length; i++) {
            if (builder.length() > 0) {
                builder.append(' ');
            }
            builder.append(args[i]);
        }
        return builder.toString();
    }
}

