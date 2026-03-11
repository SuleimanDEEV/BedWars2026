package com.suleimandev.bedwars2026.api.server;

import com.suleimandev.bedwars2026.api.configuration.ConfigManager;
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

public interface ISetupSession {

    /**
     * Get used world name.
     */
    String getWorldName();

    /**
     * Get player doing the setup.
     */
    Player getPlayer();

    /**
     * Get setup type.
     */
    SetupType getSetupType();

    /**
     * Get arena config.
     */
    ConfigManager getConfig();

    /**
     * Teleport player target world.
     */
    void teleportPlayer();

    /**
     * Close setup session.
     */
    void close();
}

