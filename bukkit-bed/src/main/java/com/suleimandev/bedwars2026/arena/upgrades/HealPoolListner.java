package com.suleimandev.bedwars2026.arena.upgrades;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.events.gameplay.GameEndEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerLeaveArenaEvent;
import com.suleimandev.bedwars2026.api.events.server.ArenaDisableEvent;
import com.suleimandev.bedwars2026.api.events.team.TeamEliminatedEvent;
import com.suleimandev.bedwars2026.api.events.upgrades.UpgradeBuyEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class HealPoolListner implements Listener {
    @EventHandler
    public void onTeamUpgrade(UpgradeBuyEvent e){
        if (e.getTeamUpgrade().getName().contains("heal-pool")){
            IArena a = e.getArena();
            if (a == null) return;
            ITeam bwt = a.getTeam(e.getPlayer());
            if (bwt == null) return;
            if (!HealPoolTask.exists(a, bwt)){
                new HealPoolTask(bwt);
            }
        }
    }

    @EventHandler
    public void onDisable(ArenaDisableEvent e){
        HealPoolTask.removeForArena(e.getWorldName());
    }

    @EventHandler
    public void onEnd(GameEndEvent e) {
        HealPoolTask.removeForArena(e.getArena());
    }

    @EventHandler
    public void teamDead(TeamEliminatedEvent e)
    {
        HealPoolTask.removeForTeam(e.getTeam());
    }

    @EventHandler
    public void LastLeave(PlayerLeaveArenaEvent event){
        if (event.getArena().getPlayers().isEmpty())
            HealPoolTask.removeForArena(event.getArena());
    }
}

