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

public interface PlayerTab {

    enum PushingRule {
        NEVER,
        PUSH_OTHER_TEAMS
    }

    enum NameTagVisibility {
        ALWAYS,
        NEVER,
        HIDE_FOR_OTHER_TEAMS,
        HIDE_FOR_OWN_TEAM
    }

    @NotNull
    String getIdentifier();

    void setNameTagVisibility(@NotNull NameTagVisibility visibility);
}

