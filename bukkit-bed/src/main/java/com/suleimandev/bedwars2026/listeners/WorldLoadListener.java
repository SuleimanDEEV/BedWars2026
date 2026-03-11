package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import java.util.LinkedList;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class WorldLoadListener implements Listener {

    @EventHandler
    public void onLoad(WorldLoadEvent e) {
        for (IArena a : new LinkedList<>(Arena.getEnableQueue())) {
            if (a.getWorldName().equalsIgnoreCase(e.getWorld().getName())) {
                a.init(e.getWorld());
                return;
            }
        }
    }
}

