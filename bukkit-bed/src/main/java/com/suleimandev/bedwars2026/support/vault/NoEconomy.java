package com.suleimandev.bedwars2026.support.vault;

import org.bukkit.entity.Player;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class NoEconomy implements Economy {
    @Override
    public boolean isEconomy() {
        return false;
    }

    @Override
    public double getMoney(Player p) {
        return 0;
    }

    @Override
    public void giveMoney(Player p, double money) {
        p.sendMessage("Â§cVault support missing!");
    }

    @Override
    public void buyAction(Player p, double cost) {
        p.sendMessage("Â§cVault support missing!");
    }
}

