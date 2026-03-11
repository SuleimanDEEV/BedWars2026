package com.suleimandev.bedwars2026.lobbysocket;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
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

public class SendTask {

    /**
     * This is used to send data to new lobby servers to improve data sync
     */
    public SendTask() {
        Bukkit.getScheduler().runTaskTimer(BukkitBedPlugin.plugin, () -> {
            List<IArena> arenas = new ArrayList<>(Arena.getArenas());
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (IArena a : arenas){
                        ArenaSocket.sendMessage(ArenaSocket.formatUpdateMessage(a));
                    }
                }
            }.runTaskAsynchronously(BukkitBedPlugin.plugin);
        }, 100L, 30L);
    }
}

