package com.suleimandev.bedwars2026.api.events.shop;

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

public class ShopOpenEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private final IArena arena;
    private boolean cancelled = false;

    /**
     * Triggered when the shop NPS is clicked.
     *
     * @deprecated Use {@link #ShopOpenEvent(Player, IArena)}
     */
    @Deprecated
    public ShopOpenEvent(Player player) {
        this.player = player;
        this.arena = null;
    }

    /**
     * Triggered when the shop NPS is clicked.
     */
    public ShopOpenEvent(Player player, IArena arena) {
        this.player = player;
        this.arena = arena;
    }

    public IArena getArena() {
        return arena;
    }

    /**
     * Get the player who opened the shop.
     */
    public Player getPlayer() {
        return player;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

