package com.suleimandev.bedwars2026.api.events.spectator;

import com.suleimandev.bedwars2026.api.arena.IArena;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import java.util.UUID;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class SpectatorTeleportToPlayerEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private UUID spectator, target;
    private IArena arena;
    private boolean cancelled = false;

    /**
     * Called when the spectator uses the player selector to teleport and spectate the selected player.
     */
    public SpectatorTeleportToPlayerEvent(@NotNull Player spectator, @NotNull Player target, IArena arena) {
        this.spectator = spectator.getUniqueId();
        this.target = target.getUniqueId();
        this.arena = arena;
    }

    /**
     * Get the spectator
     */
    public Player getSpectator() {
        return Bukkit.getPlayer(spectator);
    }

    /**
     * Get the arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Get the target player
     */
    public Player getTarget() {
        return Bukkit.getPlayer(target);
    }

    /**
     * Check if it is cancelled
     */
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

