package com.suleimandev.bedwars2026.api.arena.stats;

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

@SuppressWarnings("SpellCheckingInspection")
public enum DefaultStatistics {

    KILLS("kills", true),
    KILLS_FINAL("finalKills", true),
    DEATHS("deaths", true),
    DEATHS_FINAL("finalDeaths", true),
    BEDS_DESTROYED("bedsDestroyed", true);

    private final String id;
    private final boolean incrementable;
    DefaultStatistics(String id, boolean incrementable) {
        this.id = id;
        this.incrementable = incrementable;
    }

    @Override
    public @NotNull String toString() {
        return id;
    }

    public boolean isIncrementable() {
        return incrementable;
    }
}

