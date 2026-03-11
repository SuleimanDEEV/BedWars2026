package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.server.SetupType;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
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

public class SetWaitingSpawn extends SubCommand {

    public SetWaitingSpawn(ParentCommand parent, String name) {
        super(parent, name);
        setArenaSetupCommand(true);
        setPermission(Permissions.PERMISSION_SETUP_ARENA);
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        SetupSession ss = SetupSession.getSession(p.getUniqueId());
        if (ss == null){
            s.sendMessage("Â§c â–ª Â§7You're not in a setup session!");
            return true;
        }
        p.sendMessage("Â§6 â–ª Â§7Waiting spawn set for Â§e"+ss.getWorldName()+"Â§7!");
        ss.getConfig().saveArenaLoc("waiting.Loc", p.getLocation());
        if (ss.getSetupType() == SetupType.ASSISTED){
            Bukkit.dispatchCommand(s, BukkitBedPlugin.mainCmd+" autocreateteams");
        } else {
            Bukkit.dispatchCommand(s, BukkitBedPlugin.mainCmd);
        }
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
        if (!SetupSession.isInSetupSession(p.getUniqueId())) return false;

        return hasPermission(s);
    }
}

