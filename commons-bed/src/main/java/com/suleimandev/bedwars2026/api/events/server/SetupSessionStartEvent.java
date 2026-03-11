package com.suleimandev.bedwars2026.api.events.server;

import com.suleimandev.bedwars2026.api.server.ISetupSession;
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

public class SetupSessionStartEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private ISetupSession setupSession;

    /**
     * Called when the owner started setting up a new arena.
     */
    public SetupSessionStartEvent(ISetupSession setupSession) {
        this.setupSession = setupSession;
    }

    /**
     * Get setup session.
     */
    public ISetupSession getSetupSession() {
        return setupSession;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

