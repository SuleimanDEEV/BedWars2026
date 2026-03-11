package com.suleimandev.bedwars2026.sidebar.version;

import org.bukkit.entity.Player;
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

public interface SidebarVersionAdapter {

    void sendHeaderFooter(@NotNull Player player, @NotNull String header, @NotNull String footer);

    int getTeamTextLimit();

    int getTitleLimit();
}

