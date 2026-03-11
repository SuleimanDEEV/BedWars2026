package com.suleimandev.bedwars2026.api.events.gameplay;

import com.suleimandev.bedwars2026.api.arena.GameState;
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

public class GameStateChangeEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private IArena arena;
    private GameState oldState, newState;

    /**
     * Called when the status of the game is changed. Waiting, Starting etc.
     */
    public GameStateChangeEvent(IArena a, GameState oldState, GameState newState) {
        this.arena = a;
        this.oldState = oldState;
        this.newState = newState;
    }


    public IArena getArena() {
        return arena;
    }

    public GameState getOldState() {
        return oldState;
    }

    public GameState getNewState() {
        return newState;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

