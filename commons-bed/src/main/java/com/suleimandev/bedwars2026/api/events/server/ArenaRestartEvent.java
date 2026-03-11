package com.suleimandev.bedwars2026.api.events.server;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ArenaRestartEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private String arena, worldName;

    /**
     * Called when an arena is restarting.
     * After the world was unloaded.
     */
    public ArenaRestartEvent(String arena, String worldName) {
        this.arena = arena;
        this.worldName = worldName;
    }

    /**
     * Get the arena name.
     */
    public String getArenaName() {
        return arena;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public String getWorldName() {
        return worldName;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

