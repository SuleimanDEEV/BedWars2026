package com.suleimandev.bedwars2026.levels.internal;

import com.suleimandev.bedwars2026.api.events.player.PlayerXpGainEvent;
import com.suleimandev.bedwars2026.api.levels.Level;
import org.bukkit.entity.Player;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class InternalLevel implements Level {

    @Override
    public String getLevel(Player p) {
        return PlayerLevel.getLevelByPlayer(p.getUniqueId()).getLevelName();
    }

    @Override
    public int getPlayerLevel(Player p) {
        return PlayerLevel.getLevelByPlayer(p.getUniqueId()).getPlayerLevel();
    }

    @Override
    public String getRequiredXpFormatted(Player p) {
        return PlayerLevel.getLevelByPlayer(p.getUniqueId()).getFormattedRequiredXp();
    }

    @Override
    public String getProgressBar(Player p) {
        return PlayerLevel.getLevelByPlayer(p.getUniqueId()).getProgress();
    }

    @Override
    public int getCurrentXp(Player p) {
        return PlayerLevel.getLevelByPlayer(p.getUniqueId()).getCurrentXp();
    }

    @Override
    public String getCurrentXpFormatted(Player p) {
        return PlayerLevel.getLevelByPlayer(p.getUniqueId()).getFormattedCurrentXp();
    }

    @Override
    public int getRequiredXp(Player p) {
        return PlayerLevel.getLevelByPlayer(p.getUniqueId()).getNextLevelCost();
    }

    @Override
    public void addXp(Player player, int xp, PlayerXpGainEvent.XpSource source) {
        PlayerLevel.getLevelByPlayer(player.getUniqueId()).addXp(xp, source);
    }

    @Override
    public void setXp(Player player, int currentXp) {
        PlayerLevel.getLevelByPlayer(player.getUniqueId()).setXp(currentXp);
    }

    @Override
    public void setLevel(Player player, int level) {
        PlayerLevel.getLevelByPlayer(player.getUniqueId()).setLevel(level);
    }
}

