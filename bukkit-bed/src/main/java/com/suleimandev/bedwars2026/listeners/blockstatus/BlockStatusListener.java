package com.suleimandev.bedwars2026.listeners.blockstatus;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.events.gameplay.GameStateChangeEvent;
import com.suleimandev.bedwars2026.api.events.server.ArenaEnableEvent;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
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

public class BlockStatusListener implements Listener {

    @EventHandler
    public void onArenaEnable(ArenaEnableEvent e) {
        if (e == null) return;
        updateBlock((Arena) e.getArena());
    }

    @EventHandler
    public void onStatusChange(GameStateChangeEvent e) {
        if (e == null) return;
        updateBlock((Arena) e.getArena());
    }

    /**
     * Update sign block
     */
    public static void updateBlock(Arena a) {
        if (a == null) return;
        for (Block s : a.getSigns()) {
            if (!(s.getState() instanceof Sign)) continue;
            String path = "", data = "";
            switch (a.getStatus()) {
                case waiting:
                    path = ConfigPath.SIGNS_STATUS_BLOCK_WAITING_MATERIAL;
                    data = ConfigPath.SIGNS_STATUS_BLOCK_WAITING_DATA;
                    break;
                case playing:
                    path = ConfigPath.SIGNS_STATUS_BLOCK_PLAYING_MATERIAL;
                    data = ConfigPath.SIGNS_STATUS_BLOCK_STARTING_DATA;
                    break;
                case starting:
                    path = ConfigPath.SIGNS_STATUS_BLOCK_PLAYING_MATERIAL;
                    data = ConfigPath.SIGNS_STATUS_BLOCK_PLAYING_DATA;
                    break;
                case restarting:
                    path = ConfigPath.SIGNS_STATUS_BLOCK_RESTARTING_MATERIAL;
                    data = ConfigPath.SIGNS_STATUS_BLOCK_RESTARTING_DATA;
                    break;
                default:
                    throw new IllegalStateException("Unhandled game status!");
            }
            BukkitBedPlugin.nms.setJoinSignBackground(s.getState(), Material.valueOf(BukkitBedPlugin.signs.getString(path)));
            BukkitBedPlugin.nms.setJoinSignBackgroundBlockData(s.getState(), (byte) BukkitBedPlugin.signs.getInt(data));
        }
    }
}

