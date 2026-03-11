package com.suleimandev.bedwars2026.api.events.gameplay;

import com.suleimandev.bedwars2026.api.arena.generator.IGenerator;
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

public class GeneratorUpgradeEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private IGenerator generator;

    /**
     * Called when a generator is upgraded.
     */
    public GeneratorUpgradeEvent(IGenerator generator) {
        this.generator = generator;
    }

    /**
     * Get generator
     */
    public IGenerator getGenerator() {
        return generator;
    }


    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

