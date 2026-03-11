package com.suleimandev.bedwars2026.metrics;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.support.citizens.JoinNPC;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.SimplePie;
import java.util.concurrent.Callable;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class MetricsManager {

    private static MetricsManager instance;

    private final Metrics metrics;

    private MetricsManager(BukkitBedPlugin plugin) {
        metrics = new Metrics(plugin, 1885);

        // base metrics
        metrics.addCustomChart(new SimplePie("server_type", () -> BukkitBedPlugin.getServerType().toString()));
        metrics.addCustomChart(new SimplePie("default_language", () -> Language.getDefaultLanguage().getIso()));
        metrics.addCustomChart(new SimplePie("auto_scale", () -> String.valueOf(BukkitBedPlugin.autoscale)));
        metrics.addCustomChart(new SimplePie("party_adapter", () -> BukkitBedPlugin.getParty().getClass().getName()));
        metrics.addCustomChart(new SimplePie("chat_adapter", () -> BukkitBedPlugin.getChatSupport().getClass().getName()));
        metrics.addCustomChart(new SimplePie("level_adapter", () -> BukkitBedPlugin.getLevelSupport().getClass().getName()));
        metrics.addCustomChart(new SimplePie("db_adapter", () -> BukkitBedPlugin.getRemoteDatabase().getClass().getName()));
        metrics.addCustomChart(new SimplePie("map_adapter", () -> BukkitBedPlugin.getAPI().getRestoreAdapter().getClass().getName()));
        metrics.addCustomChart(new SimplePie("citizens_support", () -> String.valueOf(JoinNPC.isCitizensSupport())));
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public static void appendPie(String id, Callable<String> callable) {
        if (null == instance) {
            throw new RuntimeException("Metrics manager is not initialized!");
        }
        instance.getMetrics().addCustomChart(new SimplePie(id, callable));
    }

    public static void initService(BukkitBedPlugin plugin) {
        if (null != instance) {
            return;
        }
        instance = new MetricsManager(plugin);
    }
}

