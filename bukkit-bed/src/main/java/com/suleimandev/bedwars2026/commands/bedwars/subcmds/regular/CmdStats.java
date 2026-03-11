package com.suleimandev.bedwars2026.commands.bedwars.subcmds.regular;

import com.suleimandev.bedwars2026.api.CommonsBedApi;
import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
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

public class CmdStats extends SubCommand {

    public CmdStats(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(16);
        showInList(false);
        setDisplayInfo(MainCommand.createTC("Â§6 â–ª Â§7/"+ MainCommand.getInstance().getName()+" "+getSubCommandName(), "/"+getParent().getName()+" "+getSubCommandName(), "Â§fOpens the stats GUI."));
    }

    private static ConcurrentHashMap<UUID, Long> statsCoolDown = new ConcurrentHashMap<>();

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        IArena a = Arena.getArenaByPlayer(p);
        if (a != null){
            if (!(a.getStatus() == GameState.starting || a.getStatus() == GameState.waiting)){
                if (!a.isSpectator(p)){
                    return false;
                }
            }
        }
        if (statsCoolDown.containsKey(p.getUniqueId())){
            if (System.currentTimeMillis() - 3000 >= statsCoolDown.get(p.getUniqueId())) {
                statsCoolDown.replace(p.getUniqueId(), System.currentTimeMillis());
            } else {
                //wait 3 seconds
                return true;
            }
        } else {
            statsCoolDown.put(p.getUniqueId(), System.currentTimeMillis());
        }
        Misc.openStatsGUI(p);
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return new ArrayList<>();
    }


    @Override
    public boolean canSee(CommandSender s, CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (Arena.isInArena(p)) return false;

        if (SetupSession.isInSetupSession(p.getUniqueId())) return false;
        return hasPermission(s);
    }

    public static ConcurrentHashMap<UUID, Long> getStatsCoolDown() {
        return statsCoolDown;
    }
}

