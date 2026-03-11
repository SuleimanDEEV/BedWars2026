package com.suleimandev.bedwars2026.stats;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.events.gameplay.GameEndEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerBedBreakEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerKillEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerLeaveArenaEvent;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import java.time.Instant;
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

public class StatsListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onAsyncPreLoginEvent(AsyncPlayerPreLoginEvent event) {
        if (event.getLoginResult() != AsyncPlayerPreLoginEvent.Result.ALLOWED) {
            // Do nothing if login fails
            return;
        }
        PlayerStats stats = BukkitBedPlugin.getRemoteDatabase().fetchStats(event.getUniqueId());
        stats.setName(event.getName());
        BukkitBedPlugin.getStatsManager().put(event.getUniqueId(), stats);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerLoginEvent(PlayerLoginEvent event) {
        if (event.getResult() != PlayerLoginEvent.Result.ALLOWED) {
            // Prevent memory leak if login fails
            BukkitBedPlugin.getStatsManager().remove(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onBedBreak(PlayerBedBreakEvent event) {
        PlayerStats stats = BukkitBedPlugin.getStatsManager().get(event.getPlayer().getUniqueId());
        //store beds destroyed
        stats.setBedsDestroyed(stats.getBedsDestroyed() + 1);
    }

    @EventHandler
    public void onPlayerKill(PlayerKillEvent event) {
        PlayerStats victimStats = BukkitBedPlugin.getStatsManager().get(event.getVictim().getUniqueId());
        // If killer is not null and not equal to victim
        PlayerStats killerStats = !event.getVictim().equals(event.getKiller()) ?
                (event.getKiller() == null ? null : BukkitBedPlugin.getStatsManager().getUnsafe(event.getKiller().getUniqueId())) : null;

        if (event.getCause().isFinalKill()) {
            //store final deaths
            victimStats.setFinalDeaths(victimStats.getFinalDeaths() + 1);
            //store losses
            victimStats.setLosses(victimStats.getLosses() + 1);
            //store games played
            victimStats.setGamesPlayed(victimStats.getGamesPlayed() + 1);
            //store final kills
            if (killerStats != null) killerStats.setFinalKills(killerStats.getFinalKills() + 1);
        } else {
            //store deaths
            victimStats.setDeaths(victimStats.getDeaths() + 1);
            //store kills
            if (killerStats != null) killerStats.setKills(killerStats.getKills() + 1);
        }
    }

    @EventHandler
    public void onGameEnd(GameEndEvent event) {
        for (UUID uuid : event.getWinners()) {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null) continue;
            if (!player.isOnline()) continue;

            PlayerStats stats = BukkitBedPlugin.getStatsManager().get(uuid);

            // store wins even if is in another game because he assisted this team
            // the ones who abandoned are already removed from the winners list
            stats.setWins(stats.getWins() + 1);

            // store games played
            // give if he remained in this arena till the end even if was eliminated
            // for those who left games played are updated in arena leave listener
            IArena playerArena = Arena.getArenaByPlayer(player);
            if (playerArena != null && playerArena.equals(event.getArena())) {
                stats.setGamesPlayed(stats.getGamesPlayed() + 1);
            }
        }
    }

    @EventHandler
    public void onArenaLeave(@NotNull PlayerLeaveArenaEvent event) {
        final Player player = event.getPlayer();

        ITeam team = event.getArena().getExTeam(player.getUniqueId());
        if (team == null) {
            return; // The player didn't play this game
        }

        if (event.getArena().getStatus() == GameState.starting || event.getArena().getStatus() == GameState.waiting) {
            return; // Game didn't start
        }

        PlayerStats playerStats = BukkitBedPlugin.getStatsManager().getUnsafe(player.getUniqueId());
        // sometimes can be null due to scheduling delays
        if (playerStats == null) {
            return;
        }

        // Update last play and first play (if required)
        Instant now = Instant.now();
        playerStats.setLastPlay(now);
        if (playerStats.getFirstPlay() == null) {
            playerStats.setFirstPlay(now);
        }

        // 28/10/2023 this should be handled by PlayerKillEvent now. It wasn't called for pvp log out before.
        // Check quit abuse
//        if (event.getArena().getStatus() == GameState.playing) {
//            // Only if the player left the arena while the game was running
//            if (team.isBedDestroyed()) {
//                // Only if the team had the bed destroyed
//
//                // Punish player if bed is destroyed and he disconnects without getting killed
//                // if he is not in the spectators list it means he did not pass trough player kill event and he did not receive
//                // the penalty bellow.
//                if (event.getArena().isPlayer(player)) {
//                    playerStats.setFinalDeaths(playerStats.getFinalDeaths() + 1);
//                    playerStats.setLosses(playerStats.getLosses() + 1);
//                }
//
//                // Reward attacker
//                // if attacker is not null it means the victim did pvp log out
//                Player damager = event.getLastDamager();
//                ITeam killerTeam = event.getArena().getTeam(damager);
//                if (damager != null && event.getArena().isPlayer(damager) && killerTeam != null) {
//                    PlayerStats damagerStats = BukkitBedPlugin.getStatsManager().get(damager.getUniqueId());
//                    damagerStats.setFinalKills(damagerStats.getFinalKills() + 1);
//                    event.getArena().addPlayerKill(damager, true, player);
//                }
//            } else {
//                // Prevent pvp log out abuse
//                Player damager = event.getLastDamager();
//                ITeam killerTeam = event.getArena().getTeam(damager);
//
//                // killer is null if if he already received kill point.
//                // LastHit damager is set to null at PlayerDeathEvent so this part is not duplicated for sure.
//                // damager is not null if the victim disconnected during pvp only.
//                if (event.getLastDamager() != null && event.getArena().isPlayer(damager) && killerTeam != null) {
//                    // Punish player
//                    playerStats.setDeaths(playerStats.getDeaths() + 1);
//                    event.getArena().addPlayerDeath(player);
//
//                    // Reward attacker
//                    event.getArena().addPlayerKill(damager, false, player);
//                    PlayerStats damagerStats = BukkitBedPlugin.getStatsManager().get(damager.getUniqueId());
//                    damagerStats.setKills(damagerStats.getKills() + 1);
//                }
//            }
//        }

        //save or replace stats for player - run later because PlayerKillEvent is triggered after PlayerLeaveArenaEvent
        Bukkit.getScheduler().runTaskLaterAsynchronously(BukkitBedPlugin.plugin, () -> BukkitBedPlugin.getRemoteDatabase().saveStats(playerStats), 10L);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onQuit(@NotNull PlayerQuitEvent event) {
        BukkitBedPlugin.getStatsManager().remove(event.getPlayer().getUniqueId());
    }
}

