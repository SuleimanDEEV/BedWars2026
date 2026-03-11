package com.suleimandev.bedwars2026.api.events.gameplay;

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

public class EggBridgeThrowEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private IArena arena;
    private boolean cancelled = false;

    /**
     * Called when a player throw an egg bridge and it starts building
     */
    public EggBridgeThrowEvent(Player player, IArena arena) {
        this.player = player;
        this.arena = arena;
    }

    /**
     * Get player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get arena
     */
    public IArena getArena() {
        return arena;
    }

    public boolean isCancelled() {
        return cancelled;
    }

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

