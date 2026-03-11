package com.suleimandev.bedwars2026.sidebar;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.events.player.*;
import com.suleimandev.bedwars2026.api.server.ServerType;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ScoreboardListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerDamage(@NotNull EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        final Player player = (Player) e.getEntity();
        final IArena arena = Arena.getArenaByPlayer(player);

        if (arena == null) {
            return;
        }

        int health = (int) Math.ceil((player.getHealth() - e.getFinalDamage()));
        MatchSidebarService.getInstance().refreshHealth(arena, player, health);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onRegain(@NotNull EntityRegainHealthEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        final Player player = (Player) e.getEntity();
        final IArena arena = Arena.getArenaByPlayer(player);
        if (arena == null) {
            return;
        }

        int health = (int) Math.ceil(player.getHealth() + e.getAmount());
        MatchSidebarService.getInstance().refreshHealth(arena, player, health);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onReSpawn(@NotNull PlayerReSpawnEvent e) {
        final IArena arena = e.getArena();

        MatchSidebarService.getInstance().refreshHealth(arena, e.getPlayer(), (int) Math.ceil(e.getPlayer().getHealth()));
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void reJoin(@NotNull PlayerReJoinEvent e) {
        // re-add player to scoreboard tab list
        MatchSidebarService.getInstance().handleReJoin(e.getArena(), e.getPlayer());
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void arenaJoin(@NotNull PlayerJoinArenaEvent e) {
        // add player to scoreboard tab list
        MatchSidebarService.getInstance().handleJoin(e.getArena(), e.getPlayer(), e.isSpectator());
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void serverJoin(@NotNull PlayerJoinEvent e) {
        if (BukkitBedPlugin.getServerType() == ServerType.MULTIARENA || BukkitBedPlugin.getServerType() == ServerType.SHARED) {
            // add player to scoreboard tab list
            MatchSidebarService.getInstance().applyLobbyTab(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void arenaLeave(@NotNull PlayerLeaveArenaEvent e) {
        if (BukkitBedPlugin.getServerType() == ServerType.MULTIARENA || BukkitBedPlugin.getServerType() == ServerType.SHARED) {
            // add player to scoreboard tab list
            MatchSidebarService.getInstance().applyLobbyTab(e.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBedDestroy(@NotNull PlayerBedBreakEvent e) {
        // refresh placeholders in case placeholders refresh is disabled
        MatchSidebarService.getInstance().refreshPlaceholders(e.getArena());
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onFinalKill(@NotNull PlayerKillEvent e) {
        if (!e.getCause().isFinalKill()) {
            return;
        }
        // refresh placeholders in case placeholders refresh is disabled
        MatchSidebarService.getInstance().refreshPlaceholders(e.getArena());
    }
}

