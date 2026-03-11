package com.suleimandev.bedwars2026.money.internal;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.configuration.MoneyConfig;
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

public class MoneyPerMinuteTask {

    private final int money = MoneyConfig.money.getInt("money-rewards.per-minute");

    private BukkitTask task;

    /**
     * Create a new per minute money reward.
     */
    public MoneyPerMinuteTask(Arena arena) {
        if (money < 1) {
            return;
        }
        task = Bukkit.getScheduler().runTaskTimer(BukkitBedPlugin.plugin, () -> {
            if (null == arena){
                this.cancel();
                return;
            }
            for (Player p : arena.getPlayers()) {
                BukkitBedPlugin.getEconomy().giveMoney(p, money);
                p.sendMessage(Language.getMsg(p, Messages.MONEY_REWARD_PER_MINUTE).replace("{money}", String.valueOf(money)));
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

