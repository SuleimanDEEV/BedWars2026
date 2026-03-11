package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.configuration.Sounds;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class EnderPearlLanded implements Listener {

    @EventHandler
    public void onPearlHit(ProjectileHitEvent e){

        if (!(e.getEntity() instanceof EnderPearl)) return;
        if (!(e.getEntity().getShooter() instanceof Player)) return;

        Player player = (Player) e.getEntity().getShooter();
        IArena iArena = Arena.getArenaByPlayer(player);

        if (!Arena.isInArena(player) || iArena.isSpectator(player)) return;

        Sounds.playSound("ender-pearl-landed", iArena.getPlayers());
    }
}

