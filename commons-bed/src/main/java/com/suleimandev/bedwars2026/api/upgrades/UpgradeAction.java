package com.suleimandev.bedwars2026.api.upgrades;

import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import org.bukkit.entity.Player;
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

public interface UpgradeAction {

    /**
     * Apply action to team.
     */
    @Deprecated
    default void onBuy(ITeam bwt) {
        onBuy(null, bwt);
    }

    /**
     * Apply action to team.
     *
     * @param player buyer.
     * @param bwt    team receiver.
     */
    void onBuy(@Nullable Player player, ITeam bwt);
}

