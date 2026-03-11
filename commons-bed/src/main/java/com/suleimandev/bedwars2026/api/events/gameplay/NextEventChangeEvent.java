package com.suleimandev.bedwars2026.api.events.gameplay;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.NextEvent;
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

public class NextEventChangeEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private IArena arena;
    private NextEvent newEvent, oldEvent;

    public NextEventChangeEvent(IArena arena, NextEvent newEvent, NextEvent oldEvent) {
        this.arena = arena;
        this.oldEvent = oldEvent;
        this.newEvent = newEvent;
    }

    /**
     * Get the arena where happened.
     *
     * @return the arena where happened.
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Get the event that is coming.
     *
     * @return upcoming event.
     */
    public NextEvent getNewEvent() {
        return newEvent;
    }

    /**
     * Get the event that happened in this moment.
     *
     * @return the event that just happened.
     */
    public NextEvent getOldEvent() {
        return oldEvent;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

