package com.suleimandev.bedwars2026.api.events.sidebar;

import com.suleimandev.bedwars2026.api.sidebar.ISidebar;
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

public class PlayerSidebarInitEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancelled = false;

    private Player player;
    private ISidebar sidebar;

    public PlayerSidebarInitEvent(Player player, ISidebar sidebar) {
        this.player = player;
        this.sidebar = sidebar;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ISidebar getSidebar() {
        return sidebar;
    }

    public void setSidebar(ISidebar sidebar) {
        this.sidebar = sidebar;
    }
}

