package com.suleimandev.bedwars2026.vip.service;

import com.suleimandev.bedwars2026.configuration.Permissions;
import com.suleimandev.bedwars2026.vip.config.VipFeaturesConfig;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class VipPermissionResolver {

    private final VipFeaturesConfig config;

    public VipPermissionResolver(@NotNull VipFeaturesConfig config) {
        this.config = config;
    }

    public boolean isVip(@NotNull Player player) {
        return player.hasPermission(Permissions.PERMISSION_ALL)
                || player.hasPermission(Permissions.PERMISSION_VIP)
                || player.hasPermission(config.getRequiredPermission())
                || player.hasPermission("bw.vip.bypasslimits")
                || player.hasPermission(config.getPartyPriorityPermission());
    }

    public boolean canJoinFull(@NotNull Player player) {
        return config.isJoinFullEnabled() && (player.hasPermission(config.getRequiredPermission()) || hasBypassLimits(player));
    }

    public boolean hasBypassLimits(@NotNull Player player) {
        return player.hasPermission("bw.vip.bypasslimits") || player.hasPermission(Permissions.PERMISSION_ALL);
    }

    public boolean hasPartyPriority(@NotNull Player player) {
        return hasBypassLimits(player) || player.hasPermission(config.getPartyPriorityPermission());
    }

    public boolean isExempt(@NotNull Player player) {
        if (hasBypassLimits(player)) {
            return true;
        }
        for (String permission : config.getExemptPermissions()) {
            if (player.hasPermission(permission)) {
                return true;
            }
        }
        return false;
    }
}

