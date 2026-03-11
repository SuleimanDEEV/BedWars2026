package com.suleimandev.bedwars2026.configuration;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigManager;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class MoneyConfig extends ConfigManager {

    public static MoneyConfig money;

    private MoneyConfig() {
        super ( BukkitBedPlugin.plugin, "rewards", BukkitBedPlugin.plugin.getDataFolder ().toString () );
    }

    /**
     * Initialize money config.
     */
    public static void init() {
        money = new MoneyConfig ();
        money.getYml ().options ().copyDefaults ( true );
        money.getYml ().addDefault ( "money-rewards.per-minute", 5 );
        money.getYml ().addDefault ( "money-rewards.per-teammate", 30 );
        money.getYml ().addDefault ( "money-rewards.game-win", 90 );
        money.getYml ().addDefault ( "money-rewards.bed-destroyed", 60 );
        money.getYml ().addDefault ( "money-rewards.final-kill", 40 );
        money.getYml ().addDefault ( "money-rewards.regular-kill", 10 );
        money.save ();
    }
}
