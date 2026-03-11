package com.suleimandev.bedwars2026.levels.internal;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.events.player.PlayerXpGainEvent;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.configuration.LevelsConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class PerMinuteTask {

    private final int xp = LevelsConfig.levels.getInt("xp-rewards.per-minute");

    private BukkitTask task;

    /**
     * Create a new per minute xp reward.
     */
    public PerMinuteTask(Arena arena) {
        if (xp < 1){
            return;
        }
        task = Bukkit.getScheduler().runTaskTimer(BukkitBedPlugin.plugin, () -> {
            for (Player p : arena.getPlayers()) {
                PlayerLevel.getLevelByPlayer ( p.getUniqueId () ).addXp ( xp, PlayerXpGainEvent.XpSource.PER_MINUTE );
                p.sendMessage ( Language.getMsg ( p, Messages.XP_REWARD_PER_MINUTE ).replace ( "{xp}", String.valueOf ( xp ) ) );
            }
        }, 60 * 20, 60 * 20);
    }

    /**
     * Cancel task.
     */
    public void cancel() {
        if (task != null) {
            task.cancel();
        }
    }
}

