package com.suleimandev.bedwars2026.commands.bedwars.subcmds.regular;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.upgrades.UpgradesManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
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

public class CmdUpgrades extends SubCommand {

    public CmdUpgrades(ParentCommand parent, String name) {
        super(parent, name);
        showInList(false);
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (!(s instanceof Player)) return false;
        IArena a = Arena.getArenaByPlayer((Player) s);
        if (a == null) return false;
        if (!a.isPlayer((Player) s)) return false;
        ITeam t = a.getTeam((Player) s);
        if (t.getTeamUpgrades().distance(((Player)s).getLocation()) < 4){
            UpgradesManager.getMenuForArena(a).open((Player) s);
            return true;
        }
        return false;
    }

    @Override
    public List<String> getTabComplete() {
        return new ArrayList<>();
    }
}

