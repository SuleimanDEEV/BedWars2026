package com.suleimandev.bedwars2026.commands.bedwars.subcmds.regular;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.server.ServerType;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class CmdLeave extends SubCommand {

    private static HashMap<UUID, Long> delay = new HashMap<>();

    public CmdLeave(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(20);
        showInList(false);
        setDisplayInfo(MainCommand.createTC("Â§6 â–ª Â§7/"+ MainCommand.getInstance().getName()+" leave", "/"+getParent().getName()+" "+getSubCommandName(), "Â§fLeave an arena."));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;

        if (cancel(p.getUniqueId())) return true;
        update(p.getUniqueId());
        IArena a = Arena.getArenaByPlayer(p);

        Misc.moveToLobbyOrKick(p, a, a != null && a.isSpectator(p.getUniqueId()));
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

        if (BukkitBedPlugin.getServerType() == ServerType.SHARED && !Arena.isInArena(p)) return false;

        if (SetupSession.isInSetupSession(p.getUniqueId())) return false;
        return hasPermission(s);
    }

    private static boolean cancel(UUID player){
        return delay.getOrDefault(player, 0L) > System.currentTimeMillis();
    }

    private static void update(UUID player){
        if (delay.containsKey(player)){
            delay.replace(player, System.currentTimeMillis() + 2500L);
            return;
        }
        delay.put(player, System.currentTimeMillis() + 2500L);
    }
}

