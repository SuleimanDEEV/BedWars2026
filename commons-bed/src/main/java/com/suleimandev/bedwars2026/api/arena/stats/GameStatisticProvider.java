package com.suleimandev.bedwars2026.api.arena.stats;

import com.suleimandev.bedwars2026.api.language.Language;
import org.bukkit.plugin.Plugin;
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

public interface GameStatisticProvider<T extends GameStatistic<?>> {

    /**
     * Unique statistic identifier.
     */
    String getIdentifier();

    /**
     * Plugin provider.
     * @return statistic owner.
     */
    Plugin getOwner();

    /**
     * Default value used when initializing game stats.
     */
    T getDefault();

    /**
     * Display value for undetermined values.
     * @param language desired translation.
     */
    String getVoidReplacement(@Nullable Language language);
}

