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

public class PlayerLangChangeEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private boolean cancelled = false;
    private Player player;
    private String oldLang, newLang;

    /**
     * Called when a Player changes his language
     */
    public PlayerLangChangeEvent(Player p, String oldLang, String newLang) {
        this.player = p;
        this.oldLang = oldLang;
        this.newLang = newLang;
    }

    /**
     * Check if event is cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Change value
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Get Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get old Language iso
     */
    public String getOldLang() {
        return oldLang;
    }


    /**
     * Get new Language iso
     */
    public String getNewLang() {
        return newLang;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

