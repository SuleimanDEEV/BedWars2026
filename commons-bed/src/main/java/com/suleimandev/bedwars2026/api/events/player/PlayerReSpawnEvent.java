package com.suleimandev.bedwars2026.api.events.player;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
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

public class PlayerReSpawnEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private IArena arena;
    private ITeam team;

    /**
     * Called when a member is re-spawned on his island
     * This is called about 5 seconds after PlayerRespawnEvent from Bukkit
     * After the respawn countdown.
     */
    public PlayerReSpawnEvent(Player player, IArena arena, ITeam team) {
        this.player = player;
        this.arena = arena;
        this.team = team;
    }

    /**
     * Get the arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Get the player's team
     */
    public ITeam getTeam() {
        return team;
    }

    /**
     * Get the player
     */
    public Player getPlayer() {
        return player;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

