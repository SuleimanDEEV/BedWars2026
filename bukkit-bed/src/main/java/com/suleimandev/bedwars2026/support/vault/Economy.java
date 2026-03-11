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

public interface Economy {
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean isEconomy();
    double getMoney(Player p);
    void giveMoney(Player p, double money);
    void buyAction(Player p, double cost);
}

