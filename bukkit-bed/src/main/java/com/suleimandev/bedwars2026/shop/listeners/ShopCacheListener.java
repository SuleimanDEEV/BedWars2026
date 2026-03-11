package com.suleimandev.bedwars2026.shop.listeners;

import com.suleimandev.bedwars2026.api.events.player.PlayerJoinArenaEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerLeaveArenaEvent;
import com.suleimandev.bedwars2026.shop.ShopCache;
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

public class ShopCacheListener implements Listener {


    @EventHandler(priority = EventPriority.LOWEST)
    public void onArenaJoin(PlayerJoinArenaEvent e) {
        if (e.isSpectator()) return;
        ShopCache sc = ShopCache.getShopCache(e.getPlayer().getUniqueId());
        if (sc != null) {
            sc.destroy();
        }
        new ShopCache(e.getPlayer().getUniqueId());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onArenaLeave(PlayerLeaveArenaEvent e) {
        ShopCache sc = ShopCache.getShopCache(e.getPlayer().getUniqueId());
        if (sc != null) {
            sc.destroy();
        }
    }

    @EventHandler
    public void onServerLeave(PlayerQuitEvent e) {
        //if (Main.getServerType() == ServerType.BUNGEE) return;
        //don't remove immediately in case of /rejoin
        ShopCache sc = ShopCache.getShopCache(e.getPlayer().getUniqueId());
        if (sc != null) {
            sc.destroy();
        }
    }

}

