package com.suleimandev.bedwars2026.api.region;

import org.bukkit.Location;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public interface Region {

    /**
     * Check if location is in region.
     */
    boolean isInRegion(Location location);

    /**
     * Check if is a protected region.
     */
    boolean isProtected();
}

