package com.suleimandev.bedwars2026.arena.stats;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.stats.Incrementable;
import com.suleimandev.bedwars2026.api.arena.stats.GameStatistic;
import com.suleimandev.bedwars2026.api.arena.stats.GameStatisticProvider;
import com.suleimandev.bedwars2026.api.language.Language;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public abstract class GenericStatistic implements GameStatisticProvider<GenericStatistic.Value> {

    @Override
    public GenericStatistic.Value getDefault() {
        return new Value();
    }

    @Override
    public String getVoidReplacement(@Nullable Language language) {
        return "0";
    }

    @Override
    public Plugin getOwner() {
        return BukkitBedPlugin.plugin;
    }

    public static class Value implements GameStatistic<Integer>, Incrementable, Comparable<GameStatistic<Integer>> {
        private int count = 0;

        @Override
        public Integer getValue() {
            return count;
        }

        @Override
        public String getDisplayValue(Language language) {
            return String.valueOf(getValue());
        }

        @Override
        public int compareTo(@NotNull GameStatistic<Integer> o) {
            return Integer.compare(this.count, o.getValue());
        }

        @Override
        public void increment() {
            count++;
        }
    }
}

