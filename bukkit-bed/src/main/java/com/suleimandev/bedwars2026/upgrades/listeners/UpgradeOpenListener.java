package com.suleimandev.bedwars2026.upgrades.listeners;

import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.upgrades.UpgradesManager;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class UpgradeOpenListener implements Listener {

    @EventHandler
    public void onUpgradesOpen(PlayerInteractAtEntityEvent e){
        IArena a = Arena.getArenaByPlayer(e.getPlayer());
        if (a == null) return;
        if(!a.getStatus().equals(GameState.playing)) return;
        Location l = e.getRightClicked().getLocation();
        for (ITeam t : a.getTeams()) {
            Location l2 = t.getTeamUpgrades();
            if (l.getBlockX() == l2.getBlockX() && l.getBlockY() == l2.getBlockY() && l.getBlockZ() == l2.getBlockZ()) {
                e.setCancelled(true);
                if (a.isPlayer(e.getPlayer())) {
                    UpgradesManager.getMenuForArena(a).open(e.getPlayer());
                }
            }
        }
    }
}

