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

public class WithEconomy implements Economy {

    private static net.milkbowl.vault.economy.Economy economy;

    @Override
    public boolean isEconomy() {
        return true;
    }

    @Override
    public double getMoney(Player p) {
        return economy.getBalance(p);
    }

    @Override
    public void giveMoney(Player p, double money) {
        economy.depositPlayer (p, money);
    }

    @Override
    public void buyAction(Player p, double cost) {
        economy.bankWithdraw(p.getName(), cost);
    }

    public static void setEconomy(net.milkbowl.vault.economy.Economy economy) {
        WithEconomy.economy = economy;
    }
}

