package com.suleimandev.bedwars2026.listeners.joinhandler;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.language.Language;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;
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

public class JoinHandlerCommon implements Listener {

    protected static void displayCustomerDetails(org.bukkit.entity.Player player) {
        // Legacy owner-only diagnostics removed in BEDWARS 2026.
    }

    @EventHandler
    public void requestLanguage(AsyncPlayerPreLoginEvent e) {
        String iso = BukkitBedPlugin.getRemoteDatabase().getLanguage(e.getUniqueId());
        Bukkit.getScheduler().runTask(plugin, () -> Language.setPlayerLanguage(e.getUniqueId(), iso));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void removeLanguage(PlayerLoginEvent e) {
        if (e.getResult() != PlayerLoginEvent.Result.ALLOWED) {
            Language.setPlayerLanguage(e.getPlayer().getUniqueId(), null);
        }
    }
}

