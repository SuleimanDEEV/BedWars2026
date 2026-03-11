package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ChunkLoad implements Listener {

    @EventHandler
    public void onChunkLoadEvent(ChunkLoadEvent e){
        if (e == null) return;
        if (e.getChunk() == null) return;
        if (e.getChunk().getEntities() == null) return;
        Bukkit.getScheduler().runTaskAsynchronously(BukkitBedPlugin.plugin, ()-> {
            for (Entity entity : e.getChunk().getEntities()){
                if (entity instanceof ArmorStand){
                    if (entity.hasMetadata("bw2026-setup")){
                        Bukkit.getScheduler().runTask(BukkitBedPlugin.plugin, entity::remove);
                        continue;
                    }
                    if (!((ArmorStand)entity).isVisible()){
                        if (((ArmorStand)entity).isMarker()){
                            //if (!entity.hasGravity()){
                            if (entity.isCustomNameVisible()){
                                if (ChatColor.stripColor(entity.getCustomName()).contains(" SET") || ChatColor.stripColor(entity.getCustomName()).contains(" set")){
                                    Bukkit.getScheduler().runTask(BukkitBedPlugin.plugin, entity::remove);
                                }
                            }
                            //}
                        }
                    }
                }
            }
        });
    }
}

