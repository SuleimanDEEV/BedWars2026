package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.events.gameplay.GameStateChangeEvent;
import com.suleimandev.bedwars2026.arena.Arena;
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

public class AutoscaleListener implements Listener {

    @EventHandler
    public void onPlaying(GameStateChangeEvent e) {
        if (e.getNewState() == GameState.playing && Arena.canAutoScale(e.getArena().getArenaName())) {
            if (Arena.getGamesBeforeRestart() > 1){
                new Arena(e.getArena().getArenaName(), null);
            }
        }
    }
}

