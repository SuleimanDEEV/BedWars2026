package com.suleimandev.bedwars2026.api.arena.stats;

import com.suleimandev.bedwars2026.api.language.Language;
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

public interface GameStatistic<T> extends Comparable<GameStatistic<T>> {

    /**
     * Current value.
     */
    T getValue();

    /**
     * Value displayed in tops etc.
     * @param language - message receiver.
     */
    String getDisplayValue(@Nullable Language language);

    /**
     * Comparison for tops.
     * @param o the object to be compared.
     */
    int compareTo(@NotNull GameStatistic<T> o);
}

