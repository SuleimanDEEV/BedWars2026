package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.server.SetupType;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.Permissions;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.Arrays;
import java.util.List;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.config;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class SetType extends SubCommand {

    public SetType(ParentCommand parent, String name) {
        super(parent, name);
        setArenaSetupCommand(true);
        setPermission(Permissions.PERMISSION_SETUP_ARENA);
    }

    private static final List<String> available = Arrays.asList("Solo", "Doubles", "3v3v3v3", "4v4v4v4");

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        SetupSession ss = SetupSession.getSession(p.getUniqueId());
        if (ss == null) {
            s.sendMessage("Â§c â–ª Â§7You're not in a setup session!");
            return true;
        }
        if (args.length == 0) {
            sendUsage(p);
        } else {
            if (!available.contains(args[0])) {
                sendUsage(p);
                return true;
            }
            List<String> groups = BukkitBedPlugin.config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS);
            String input = args[0].substring(0, 1).toUpperCase() + args[0].substring(1).toLowerCase();
            if (!groups.contains(input)) {
                groups.add(input);
                BukkitBedPlugin.config.set(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS, groups);
            }
            if (input.equals("Solo")) {
                ss.getConfig().set("maxInTeam", 1);
            } else if (input.equalsIgnoreCase("Doubles")) {
                ss.getConfig().set("maxInTeam", 2);
            } else if (input.equalsIgnoreCase("3v3v3v3")) {
                ss.getConfig().set("maxInTeam", 3);
            } else if (input.equalsIgnoreCase("4v4v4v4")) {
                ss.getConfig().set("maxInTeam", 4);
            }
            ss.getConfig().set("group", input);
            p.sendMessage("Â§6 â–ª Â§7Arena group changed to: Â§d" + input);
            if (ss.getSetupType() == SetupType.ASSISTED) {
                Bukkit.dispatchCommand(p, getParent().getName());
            }
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        List<String> groups = BukkitBedPlugin.config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS);
        available.forEach(available -> {
            if (!groups.contains(available)) {
                groups.add(available);
            }
        });
        return config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS);
    }

    private void sendUsage(Player p) {
        p.sendMessage("Â§9 â–ª Â§7Usage: " + getParent().getName() + " " + getSubCommandName() + " <type>");
        p.sendMessage("Â§9Available types: ");
        for (String st : available) {
            p.spigot().sendMessage(Misc.msgHoverClick("Â§1 â–ª Â§e" + st + " Â§7(click to set)", "Â§dClick to make the arena " + st, "/" + getParent().getName() + " " + getSubCommandName() + " " + st, ClickEvent.Action.RUN_COMMAND));
        }
    }

    @Override
    public boolean canSee(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (!SetupSession.isInSetupSession(p.getUniqueId())) return false;

        return hasPermission(s);
    }
}

