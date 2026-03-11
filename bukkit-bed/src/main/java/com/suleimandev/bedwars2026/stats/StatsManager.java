package com.suleimandev.bedwars2026.stats;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class StatsManager {

    private final Map<UUID, PlayerStats> stats = new ConcurrentHashMap<>();

    public StatsManager() {
        registerListeners();
    }

    public void remove(UUID uuid) {
        stats.remove(uuid);
    }

    public void put(UUID uuid, PlayerStats playerStats) {
        stats.put(uuid, playerStats);
    }

    @NotNull
    public PlayerStats get(UUID uuid) {
        PlayerStats playerStats = stats.get(uuid);
        if (playerStats == null) {
            throw new IllegalStateException("Trying to get stats data of an unloaded player!");
        }
        return playerStats;
    }

    @Nullable
    public PlayerStats getUnsafe(UUID uuid) {
        return stats.get(uuid);
    }

    /**
     * Register listeners related to stats cache.
     */
    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new StatsListener(), BukkitBedPlugin.plugin);
    }
}

