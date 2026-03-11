package com.suleimandev.bedwars2026.sidebar.placeholder;

import com.suleimandev.bedwars2026.sidebar.api.PlaceholderProvider;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public final class PlaceholderResolver {

    private PlaceholderResolver() {
    }

    @NotNull
    public static String resolve(@NotNull String input, @NotNull Collection<PlaceholderProvider> placeholders) {
        String result = input;
        for (PlaceholderProvider placeholderProvider : placeholders) {
            result = result.replace(placeholderProvider.getPlaceholder(), placeholderProvider.resolve());
        }
        return result;
    }
}

