package com.suleimandev.bedwars2026.sidebar.line;

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

public final class SidebarLineParts {

    private final String prefix;
    private final String suffix;

    public SidebarLineParts(@NotNull String prefix, @NotNull String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @NotNull
    public String getPrefix() {
        return prefix;
    }

    @NotNull
    public String getSuffix() {
        return suffix;
    }
}

