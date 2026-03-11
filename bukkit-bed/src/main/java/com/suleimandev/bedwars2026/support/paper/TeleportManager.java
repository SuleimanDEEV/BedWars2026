package com.suleimandev.bedwars2026.support.paper;

import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import io.papermc.lib.PaperLib;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.config;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.isPaper;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public final class TeleportManager {

    public static void teleport(Entity entity, Location location) {
        teleportC(entity, location, PlayerTeleportEvent.TeleportCause.PLUGIN);
    }

    public static void teleportC(Entity entity, Location location, PlayerTeleportEvent.TeleportCause cause) {
        if (isPaper && config.getBoolean(ConfigPath.GENERAL_CONFIGURATION_PERFORMANCE_PAPER_FEATURES)) {
            PaperLib.teleportAsync(entity, location, cause);
            return;
        }
        entity.teleport(location, cause);
    }

}

