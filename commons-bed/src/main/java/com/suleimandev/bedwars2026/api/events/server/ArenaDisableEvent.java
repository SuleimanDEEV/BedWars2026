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

public class ArenaDisableEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private String arenaName;
    private String worldName;

    /**
     * Called when an arena is disabled.
     * This is not called when you restart the server.
     */
    public ArenaDisableEvent(String arenaName, String worldName) {
        this.arenaName = arenaName;
        this.worldName = worldName;
    }

    /**
     * Get the arena name
     */
    public String getArenaName() {
        return arenaName;
    }

    public String getWorldName() {
        return worldName;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

