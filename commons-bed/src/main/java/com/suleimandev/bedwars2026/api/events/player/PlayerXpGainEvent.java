package com.suleimandev.bedwars2026.api.events.player;

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

public class PlayerXpGainEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private int amount;
    private XpSource xpSource;

    /**
     * Called when a player receives new xp.
     * This only works when the internal Level System is used.
     * Developers can "inject" their own level system.
     *
     * @param player   - target player.
     * @param amount   - amount of xp.
     * @param xpSource - where did the player receive xp from.
     */
    public PlayerXpGainEvent(Player player, int amount, XpSource xpSource) {
        this.player = player;
        this.amount = amount;
        this.xpSource = xpSource;
    }

    /**
     * Get the player that have received new xp.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the amount of xp received.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Get xp source
     */
    public XpSource getXpSource() {
        return xpSource;
    }

    /**
     * Lets you know why did the player received new xp.
     */
    public enum XpSource {
        PER_MINUTE, PER_TEAMMATE, GAME_WIN, BED_DESTROYED, FINAL_KILL, REGULAR_KILL, OTHER
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

