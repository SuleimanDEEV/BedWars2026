package com.suleimandev.bedwars2026.listeners.chat;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.plugin;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ChatAFK implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent event) {
        Arena.afkCheck.remove(event.getPlayer().getUniqueId());
        if (BukkitBedPlugin.getAPI().getAFKUtil().isPlayerAFK(event.getPlayer())) {
            // go sync
            Bukkit.getScheduler().runTask(plugin, () ->
                    BukkitBedPlugin.getAPI().getAFKUtil().setPlayerAFK(event.getPlayer(), false)
            );
        }
    }
}

