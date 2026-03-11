package com.suleimandev.bedwars2026.language;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.events.player.PlayerLangChangeEvent;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.sidebar.MatchSidebarService;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
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

public class LangListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onLanguageChangeEvent(PlayerLangChangeEvent e) {
        if (e == null) return;
        if (e.isCancelled()) return;
        if (BukkitBedPlugin.config.getLobbyWorldName().equalsIgnoreCase(e.getPlayer().getWorld().getName())) {
            Bukkit.getScheduler().runTaskLater(BukkitBedPlugin.plugin, () -> {
                Arena.sendLobbyCommandItems(e.getPlayer());
                MatchSidebarService.getInstance().giveSidebar(e.getPlayer(), Arena.getArenaByPlayer(e.getPlayer()), false);

                // save to db
                Bukkit.getScheduler().runTaskAsynchronously(BukkitBedPlugin.plugin, ()-> BukkitBedPlugin.getRemoteDatabase().setLanguage(e.getPlayer().getUniqueId(), e.getNewLang()));
            }, 10L);
        }
    }
}

