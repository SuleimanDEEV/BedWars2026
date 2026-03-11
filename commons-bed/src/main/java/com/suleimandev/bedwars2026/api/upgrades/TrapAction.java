package com.suleimandev.bedwars2026.api.upgrades;

import com.suleimandev.bedwars2026.api.arena.team.ITeam;
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

public interface TrapAction {

    /**
     * @return trap identifier.
     */
    String getName();

    /**
     * Manage what happens on {@param player} enters {@param targetTeam}.
     *
     * @param player     The player who enters the targetTeam.
     * @param playerTeam Enemy player team.
     * @param targetTeam The affected team.
     */
    void onTrigger(@NotNull Player player, ITeam playerTeam, ITeam targetTeam);
}

