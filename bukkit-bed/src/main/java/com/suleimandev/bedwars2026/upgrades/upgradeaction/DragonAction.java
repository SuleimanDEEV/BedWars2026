package com.suleimandev.bedwars2026.upgrades.upgradeaction;

import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.upgrades.UpgradeAction;
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

public class DragonAction implements UpgradeAction {

    private final int amount;

    public DragonAction(int amount){
        this.amount = amount;
    }

    @Override
    public void onBuy(@Nullable Player player, ITeam bwt) {
        bwt.setDragons(amount);
    }
}

