package com.suleimandev.bedwars2026.sidebar;

import com.suleimandev.bedwars2026.sidebar.api.ScoredLine;
import com.suleimandev.bedwars2026.sidebar.api.SidebarLine;
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

public class BwSidebarLine extends SidebarLine implements ScoredLine {

    public final String content;
    public final String score;

    public BwSidebarLine(String content, @Nullable String score) {
        this.content = content;
        this.score = score == null ? "" : score;
    }
    @Override
    public String getScore() {
        return score;
    }

    @Override
    public @NotNull String getLine() {
        return content;
    }
}

