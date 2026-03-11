package com.suleimandev.bedwars2026.money.internal;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.events.gameplay.GameEndEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerBedBreakEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerKillEvent;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.configuration.MoneyConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

public class MoneyListeners implements Listener {

    /**
     * Create a new winner / loser money reward.
     */
    @EventHandler
    public void onGameEnd(GameEndEvent e) {
        for (UUID p : e.getWinners()) {
            Player player = Bukkit.getPlayer(p);
            if (player == null) continue;
            int gameWin = MoneyConfig.money.getInt("money-rewards.game-win");
            if (gameWin > 0) {
                BukkitBedPlugin.getEconomy().giveMoney(player, gameWin);
                player.sendMessage(Language.getMsg(player, Messages.MONEY_REWARD_WIN).replace("{money}", String.valueOf(gameWin)));
            }
            ITeam bwt = e.getArena().getExTeam(player.getUniqueId());
            IArena arena = e.getArena();
            if (bwt != null) {
                if (arena.getMaxInTeam() > 1) {
                    int teamMate = MoneyConfig.money.getInt("money-rewards.per-teammate");
                    if (teamMate > 0) {
                        BukkitBedPlugin.getEconomy().giveMoney(player, teamMate);
                        player.sendMessage(Language.getMsg(player, Messages.MONEY_REWARD_PER_TEAMMATE).replace("{money}", String.valueOf(teamMate)));
                    }
                }
            }
        }
        for (UUID p : e.getLosers()) {
            Player player = Bukkit.getPlayer(p);
            if (player == null) continue;
            ITeam bwt = e.getArena().getExTeam(player.getUniqueId());
            IArena arena = e.getArena();
            if (bwt != null) {
                if (arena.getMaxInTeam() > 1) {
                    int teamMate = MoneyConfig.money.getInt("money-rewards.per-teammate");
                    if (teamMate > 0) {
                        BukkitBedPlugin.getEconomy().giveMoney(player, teamMate);
                        player.sendMessage(Language.getMsg(player, Messages.MONEY_REWARD_PER_TEAMMATE).replace("{money}", String.valueOf(teamMate)));
                    }
                }
            }
        }
    }

    /**
     * Create a new bed destroyed money reward.
     */
    @EventHandler
    public void onBreakBed(PlayerBedBreakEvent e) {
        Player player = e.getPlayer ();
        if (player == null) return;
        int bedDestroy = MoneyConfig.money.getInt("money-rewards.bed-destroyed");
        if (bedDestroy > 0) {
            BukkitBedPlugin.getEconomy().giveMoney(player, bedDestroy);
            player.sendMessage(Language.getMsg(player, Messages.MONEY_REWARD_BED_DESTROYED).replace("{money}", String.valueOf(bedDestroy)));
        }
    }

    /**
     * Create a kill money reward.
     */
    @EventHandler
    public void onKill(PlayerKillEvent e) {
        Player player = e.getKiller();
        Player victim = e.getVictim();
        if (player == null || victim.equals(player)) return;
        int finalKill = MoneyConfig.money.getInt("money-rewards.final-kill");
        int regularKill = MoneyConfig.money.getInt("money-rewards.regular-kill");
        if (e.getCause().isFinalKill()) {
            if (finalKill > 0) {
                BukkitBedPlugin.getEconomy().giveMoney(player, finalKill);
                player.sendMessage(Language.getMsg(player, Messages.MONEY_REWARD_FINAL_KILL).replace("{money}", String.valueOf(finalKill)));
            }
        } else {
            if (regularKill > 0) {
                BukkitBedPlugin.getEconomy().giveMoney(player, regularKill);
                player.sendMessage(Language.getMsg(player, Messages.MONEY_REWARD_REGULAR_KILL).replace("{money}", String.valueOf(regularKill)));
            }
        }
    }
}
