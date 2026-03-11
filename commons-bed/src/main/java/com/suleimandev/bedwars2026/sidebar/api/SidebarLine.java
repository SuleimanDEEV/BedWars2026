package com.suleimandev.bedwars2026.sidebar.api;

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

public abstract class SidebarLine {

    @NotNull
    public abstract String getLine();

    public void nextFrame() {
    }
}

