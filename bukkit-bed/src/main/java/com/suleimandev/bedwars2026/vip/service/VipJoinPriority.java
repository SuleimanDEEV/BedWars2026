package com.suleimandev.bedwars2026.vip.service;

import com.suleimandev.bedwars2026.vip.config.VipFeaturesConfig;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.List;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class VipJoinPriority {

    private final VipFeaturesConfig config;
    private final VipPermissionResolver permissionResolver;

    public VipJoinPriority(@NotNull VipFeaturesConfig config, @NotNull VipPermissionResolver permissionResolver) {
        this.config = config;
        this.permissionResolver = permissionResolver;
    }

    public int resolvePriority(@NotNull Player player) {
        List<String> order = config.getPriorityOrder();
        for (int index = 0; index < order.size(); index++) {
            if (player.hasPermission(order.get(index))) {
                return order.size() - index;
            }
        }
        return permissionResolver.isVip(player) ? 1 : 0;
    }
}

