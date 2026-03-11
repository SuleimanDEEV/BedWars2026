package com.suleimandev.bedwars2026.api.arena.stats;

import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Optional;
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

public interface PlayerGameStats {

    @NotNull UUID getPlayer();

    /**
     * @return player display name.
     */
    @NotNull String getDisplayPlayer();

    /**
     * @return player username.
     */
    @NotNull String getUsername();

    void registerStatistic(@NotNull String id, @NotNull GameStatistic<?> defaultValue);

    Optional<GameStatistic<?>> getStatistic(@NotNull String id);

    default Optional<GameStatistic<?>> getStatistic(@NotNull DefaultStatistics id) {
        return getStatistic(id.toString());
    }

    /**
     * List of registered statistics.
     */
    @SuppressWarnings("unused")
    List<String> getRegistered();
}

