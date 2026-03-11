package com.suleimandev.bedwars2026.api.events.gameplay;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import java.util.ArrayList;
import java.util.List;
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

public class GameEndEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private List<UUID> winners;
    private List<UUID> losers;
    private List<UUID> aliveWinners;
    private ITeam teamWinner;
    private IArena arena;

    /**
     * Triggered when the game ends.
     */
    public GameEndEvent(IArena arena, List<UUID> winners, List<UUID> losers, ITeam teamWinner, List<UUID> aliveWinners) {
        this.winners = new ArrayList<>(winners);
        this.arena = arena;
        this.losers = new ArrayList<>(losers);
        this.teamWinner = teamWinner;
        this.aliveWinners = new ArrayList<>(aliveWinners);
    }

    /**
     * Get a list of winners including eliminated teammates
     */
    public List<UUID> getWinners() {
        return winners;
    }

    /**
     * Get the winner team
     */
    public ITeam getTeamWinner() {
        return teamWinner;
    }

    /**
     * Get a list with people who played and didn't win.
     * This includes people who leaved the game etc.
     */
    public List<UUID> getLosers() {
        return losers;
    }

    /**
     * Get the arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Get a list of winners.
     * Teammates killed by final kill excluded.
     */
    public List<UUID> getAliveWinners() {
        return aliveWinners;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

