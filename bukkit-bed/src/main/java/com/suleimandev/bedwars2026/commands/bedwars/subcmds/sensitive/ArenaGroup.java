package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import com.suleimandev.bedwars2026.configuration.ArenaConfig;
import com.suleimandev.bedwars2026.configuration.Permissions;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.config;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.plugin;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ArenaGroup extends SubCommand {

    public ArenaGroup(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(8);
        showInList(true);
        setPermission(Permissions.PERMISSION_ARENA_GROUP);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName()+" Â§8- Â§eclick for details", "Â§fManage arena groups.",
                "/" + getParent().getName() + " " + getSubCommandName(), ClickEvent.Action.RUN_COMMAND));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (!MainCommand.isLobbySet(p)) return true;
        if (args.length < 2 && (args.length < 1 || !args[0].equalsIgnoreCase("list"))) {
            sendArenaGroupCmdList(p);
        } else if (args[0].equalsIgnoreCase("create")) {
            if (args[0].contains("+")) {
                p.sendMessage("Â§câ–ª Â§7" + args[0] + " mustn't contain this symbol: " + ChatColor.RED + "+");
                return true;
            }
            java.util.List<String> groups;
            if (config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS) == null) {
                groups = new ArrayList<>();
            } else {
                groups = config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS);
            }
            if (groups.contains(args[1])) {
                p.sendMessage("Â§câ–ª Â§7This group already exists!");
                return true;
            }
            groups.add(args[1]);
            config.set(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS, groups);
            p.sendMessage("Â§6 â–ª Â§7Group created!");
        } else if (args[0].equalsIgnoreCase("remove")) {
            List<String> groups;
            if (config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS) == null) {
                groups = new ArrayList<>();
            } else {
                groups = config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS);
            }
            if (!groups.contains(args[1])) {
                p.sendMessage("Â§câ–ª Â§7This group doesn't exist!");
                return true;
            }
            groups.remove(args[1]);
            config.set(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS, groups);
            p.sendMessage("Â§6 â–ª Â§7Group deleted!");
        } else if (args[0].equalsIgnoreCase("list")) {
            List<String> groups;
            if (config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS) == null) {
                groups = new ArrayList<>();
            } else {
                groups = config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS);
            }
            p.sendMessage("Â§7Available arena groups:");
            p.sendMessage("Â§6 â–ª Â§fDefault");
            for (String gs : groups) {
                p.sendMessage("Â§6 â–ª Â§f" + gs);
            }
        } else if (args[0].equalsIgnoreCase("set")) {
            if (args.length < 3) {
                sendArenaGroupCmdList(p);
                return true;
            }
            if (config.getYml().get(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS) != null) {
                if (config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS).contains(args[2])) {
                    File arena = new File(plugin.getDataFolder(), "/Arenas/" + args[1] + ".yml");
                    if (!arena.exists()) {
                        p.sendMessage("Â§câ–ª Â§7Arena " + args[1] + " doesn't exist!");
                        return true;
                    }
                    ArenaConfig cm = new ArenaConfig(BukkitBedPlugin.plugin, args[1], plugin.getDataFolder().getPath() + "/Arenas");
                    cm.set("group", args[2]);
                    if (Arena.getArenaByName(args[1]) != null) {
                        Arena.getArenaByName(args[1]).setGroup(args[2]);
                    }
                    p.sendMessage("Â§6 â–ª Â§7" + args[1] + " was added to the group: " + args[2]);
                } else {
                    p.sendMessage("Â§6 â–ª Â§7There isn't any group called: " + args[2]);
                    Bukkit.dispatchCommand(p, "/bw list");
                }
            } else {
                p.sendMessage("Â§6 â–ª Â§7There isn't any group called: " + args[2]);
                Bukkit.dispatchCommand(p, "/bw list");
            }
        } else {
            sendArenaGroupCmdList(p);
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return Arrays.asList("create", "remove", "list", "set");
    }

    private void sendArenaGroupCmdList(Player p) {
        p.spigot().sendMessage(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName() + " create Â§o<groupName>",
                "Create an arena group. More details on our wiki.", "/" + getParent().getName() + " " + getSubCommandName() + " create",
                ClickEvent.Action.SUGGEST_COMMAND));
        p.spigot().sendMessage(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName() + " list",
                "View available groups.", "/" + getParent().getName() + " " + getSubCommandName() + " list",
                ClickEvent.Action.RUN_COMMAND));
        p.spigot().sendMessage(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName() + " remove Â§o<groupName>",
                "Remove an arena group. More details on our wiki.", "/" + getParent().getName() + " " + getSubCommandName() + " remove",
                ClickEvent.Action.SUGGEST_COMMAND));
        p.spigot().sendMessage(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName() + " Â§rÂ§7set Â§o<arenaName> <groupName>",
                "Set the arena group. More details on our wiki.", "/" + getParent().getName() + " " + getSubCommandName() + " set",
                ClickEvent.Action.SUGGEST_COMMAND));
    }

    @Override
    public boolean canSee(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (Arena.isInArena(p)) return false;

        if (SetupSession.isInSetupSession(p.getUniqueId())) return false;
        return hasPermission(s);
    }
}

