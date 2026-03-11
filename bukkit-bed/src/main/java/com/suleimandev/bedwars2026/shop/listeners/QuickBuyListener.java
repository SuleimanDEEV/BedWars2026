package com.suleimandev.bedwars2026.shop.listeners;

import com.suleimandev.bedwars2026.api.events.player.PlayerJoinArenaEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerReJoinEvent;
import com.suleimandev.bedwars2026.shop.quickbuy.PlayerQuickBuyCache;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class QuickBuyListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onArenaJoin(PlayerJoinArenaEvent e){
        if (e == null) return;
        if (e.isSpectator()) return;
        PlayerQuickBuyCache cache = PlayerQuickBuyCache.getQuickBuyCache(e.getPlayer().getUniqueId());
        if (cache != null) {
            cache.destroy();
        }
        new PlayerQuickBuyCache(e.getPlayer());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onArenaJoin(PlayerReJoinEvent e){
        if (e == null) return;
        PlayerQuickBuyCache cache = PlayerQuickBuyCache.getQuickBuyCache(e.getPlayer().getUniqueId());
        if (cache != null) {
            cache.destroy();
        }
        new PlayerQuickBuyCache(e.getPlayer());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onQuit(PlayerQuitEvent e){
        if (e == null) return;
        PlayerQuickBuyCache cache = PlayerQuickBuyCache.getQuickBuyCache(e.getPlayer().getUniqueId());
        if (cache == null) return;
        cache.destroy();
    }
}

