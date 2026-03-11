package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.api.arena.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import static com.suleimandev.bedwars2026.support.version.common.VersionCommon.api;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

// Prevent item swap.
public class SwapItem implements Listener {

    @EventHandler
    public void itemSwap(PlayerSwapHandItemsEvent e) {
        if (e.isCancelled()) return;
        if (api.getArenaUtil().isPlaying(e.getPlayer())) {
            if (api.getArenaUtil().getArenaByPlayer(e.getPlayer()).getStatus() != GameState.playing)
                e.setCancelled(true);
        } else if (api.getArenaUtil().isSpectating(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}

