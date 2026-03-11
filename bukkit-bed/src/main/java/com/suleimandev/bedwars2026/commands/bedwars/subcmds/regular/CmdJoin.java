package com.suleimandev.bedwars2026.commands.bedwars.subcmds.regular;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.Sounds;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import static com.suleimandev.bedwars2026.api.language.Language.getMsg;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class CmdJoin extends SubCommand {

    public CmdJoin(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(19);
        showInList(false);
        setDisplayInfo(MainCommand.createTC("Â§6 â–ª Â§7/"+ MainCommand.getInstance().getName()+" join Â§e<random/ arena/ groupName>",
                "/"+getParent().getName()+" "+getSubCommandName(), "Â§fJoin an arena by name or by group.\nÂ§f/bw join random - join random arena."));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (args.length < 1) {
            s.sendMessage(getMsg(p, Messages.COMMAND_JOIN_USAGE));
            return true;
        }
        if (args[0].equalsIgnoreCase("random")){
            if (!Arena.joinRandomArena(p)){
                s.sendMessage(getMsg(p, Messages.COMMAND_JOIN_NO_EMPTY_FOUND));
                Sounds.playSound("join-denied", p);
            } else {
                Sounds.playSound("join-allowed", p);
            }
            return true;
        }
        if (MainCommand.isArenaGroup(args[0]) || args[0].contains("+")) {
            if (!Arena.joinRandomFromGroup(p, args[0])) {
                s.sendMessage(getMsg(p, Messages.COMMAND_JOIN_NO_EMPTY_FOUND));
                Sounds.playSound("join-denied", p);
            } else {
                Sounds.playSound("join-allowed", p);
            }
            return true;
        } else if (Arena.getArenaByName(args[0]) != null) {
            if (Arena.getArenaByName(args[0]).addPlayer(p, false)){
                Sounds.playSound("join-allowed", p);
            } else {
                Sounds.playSound("join-denied", p);
            }
            return true;
        } else if (Arena.getArenaByIdentifier(args[0]) != null) {
            if (Arena.getArenaByIdentifier(args[0]).addPlayer(p, false)){
                Sounds.playSound("join-allowed", p);
            } else {
                Sounds.playSound("join-denied", p);
            }
            return true;
        }
        s.sendMessage(getMsg(p, Messages.COMMAND_JOIN_GROUP_OR_ARENA_NOT_FOUND).replace("{name}", args[0]));
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        List<String> tab = new ArrayList<>(BukkitBedPlugin.config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_ARENA_GROUPS));
        for (IArena arena : Arena.getArenas()){
            tab.add(arena.getArenaName());
        }
        return tab;
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

