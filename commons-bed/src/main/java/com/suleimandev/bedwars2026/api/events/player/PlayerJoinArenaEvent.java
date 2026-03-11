package com.suleimandev.bedwars2026.api.events.player;

import com.suleimandev.bedwars2026.api.arena.IArena;
import org.bukkit.entity.Player;
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

public class PlayerJoinArenaEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private boolean spectator;
    private boolean cancelled = false;
    private IArena arena;

    /**
     * This event is called when a player joins the arena as a player or spectator.
     * The event is not triggered for players who died and become spectators. Listen the kill event for this.
     */
    public PlayerJoinArenaEvent(IArena arena, Player p, boolean spectator) {
        this.arena = arena;
        this.player = p;
        this.spectator = spectator;
    }

    /**
     * Get arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Get player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Check if the player has joined as spectator
     */
    public boolean isSpectator() {
        return spectator;
    }

    /**
     * Check if event was cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Cancel event
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

