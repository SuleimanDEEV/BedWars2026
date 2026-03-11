package com.suleimandev.bedwars2026.api.events.server;

import com.suleimandev.bedwars2026.api.arena.IArena;
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

public class ArenaEnableEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private IArena arena;

    /**
     * Called when an arena is enabled successfully. It's called after a restart as well.
     */
    public ArenaEnableEvent(IArena a) {
        this.arena = a;
    }

    /**
     * Get the arena
     */
    public IArena getArena() {
        return arena;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

