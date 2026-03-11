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

public class NoChat implements Chat {
    @Override
    public String getPrefix(Player p) {
        return "";
    }

    @Override
    public String getSuffix(Player p) {
        return "";
    }
}

