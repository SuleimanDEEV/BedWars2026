package com.suleimandev.bedwars2026.commands.bedwars.subcmds.regular;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import com.suleimandev.bedwars2026.configuration.Permissions;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
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

public class CmdStart extends SubCommand {

    public CmdStart(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(15);
        showInList(true);
        setDisplayInfo(MainCommand.createTC("Â§6 â–ª Â§7/"+ MainCommand.getInstance().getName()+" "+getSubCommandName()+" Â§8 - Â§eforce start an arena",
                "/"+getParent().getName()+" "+getSubCommandName(), "Â§fForcestart an arena.\nÂ§fPermission: Â§c"+Permissions.PERMISSION_FORCESTART));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        IArena a = Arena.getArenaByPlayer(p);
        if (a == null){
            p.sendMessage(getMsg(p, Messages.COMMAND_FORCESTART_NOT_IN_GAME));
            return true;
        }
        if (!a.isPlayer(p)){
            p.sendMessage(getMsg(p, Messages.COMMAND_FORCESTART_NOT_IN_GAME));
            return true;
        }
        if (!(p.hasPermission(Permissions.PERMISSION_ALL) || p.hasPermission(Permissions.PERMISSION_FORCESTART))){
            p.sendMessage(getMsg(p, Messages.COMMAND_FORCESTART_NO_PERM));
            return true;
        }
        if (a.getStatus() == GameState.playing) return true;
        if (a.getStatus() == GameState.restarting) return true;
        if (a.getStartingTask() == null){
            if (args.length == 1 && args[0].equalsIgnoreCase("debug") && s.isOp()){
                a.changeStatus(GameState.starting);
                BukkitBedPlugin.debug = true;
            } else {
                return true;
            }
        }
        if (a.getStartingTask().getCountdown() < 5) return true;
        a.getStartingTask().setCountdown(5);
        p.sendMessage(getMsg(p, Messages.COMMAND_FORCESTART_SUCCESS));
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return null;
    }

    @Override
    public boolean canSee(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;

        IArena a = Arena.getArenaByPlayer(p);
        if (a != null){
            GameState status = a.getStatus();
            if (status == GameState.waiting || status == GameState.starting){
                if (!a.isPlayer(p)) return false;
            } else {
                return false;
            }
        } else {
            return false;
        }

        if (SetupSession.isInSetupSession(p.getUniqueId())) return false;

        return s.hasPermission(Permissions.PERMISSION_FORCESTART);
    }
}

