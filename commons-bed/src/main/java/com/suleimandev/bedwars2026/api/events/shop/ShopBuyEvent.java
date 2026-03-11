package com.suleimandev.bedwars2026.api.events.shop;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.shop.ICategoryContent;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
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

public class ShopBuyEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Player buyer;
    private final IArena arena;
    private final ICategoryContent categoryContent;
    private boolean cancelled = false;

    /**
     * Triggered when a player buys from the shop
     *
     * @deprecated Use {@link #ShopBuyEvent(Player, IArena, ICategoryContent)}
     */
    @Deprecated
    public ShopBuyEvent(Player buyer, ICategoryContent categoryContent) {
        this.categoryContent = categoryContent;
        this.buyer = buyer;
        this.arena = null;
    }

    /**
     * Triggered when a player buys from the shop
     */
    public ShopBuyEvent(Player buyer, IArena arena, ICategoryContent categoryContent) {
        this.categoryContent = categoryContent;
        this.buyer = buyer;
        this.arena = arena;
    }

    public IArena getArena() {
        return arena;
    }

    /**
     * Get the buyer
     */
    public Player getBuyer() {
        return buyer;
    }

    /**
     * Get the shop category content bought.
     */
    public ICategoryContent getCategoryContent() {
        return categoryContent;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}

