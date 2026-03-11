package com.suleimandev.bedwars2026.vip.service;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.arena.Arena;
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

public class VipFeatureService {

    private final VipFeaturesConfig config;
    private final VipPermissionResolver permissionResolver;
    private final VipJoinPriority joinPriority;
    private final VipReservedSlotPolicy reservedSlotPolicy;

    public VipFeatureService(@NotNull VipFeaturesConfig config) {
        this.config = config;
        this.permissionResolver = new VipPermissionResolver(config);
        this.joinPriority = new VipJoinPriority(config, permissionResolver);
        this.reservedSlotPolicy = new VipReservedSlotPolicy(permissionResolver, joinPriority);
    }

    public boolean isVip(@NotNull Player player) {
        return permissionResolver.isVip(player);
    }

    @NotNull
    public VipReservedSlotPolicy.Result reserveSlots(@NotNull Arena arena, @NotNull Player requester, int requestedSlots) {
        return reservedSlotPolicy.reserve(
                arena,
                requester,
                Math.max(1, requestedSlots),
                permissionResolver.canJoinFull(requester),
                permissionResolver.hasPartyPriority(requester),
                config.isKickNonVipOnFullArenaEnabled()
        );
    }

    public boolean canReserveSlots(@NotNull Arena arena, @NotNull Player requester, int requestedSlots) {
        return reserveSlots(arena, requester, requestedSlots).isAllowed();
    }

    @NotNull
    public String getDenyMessage(@NotNull VipReservedSlotPolicy.DenyReason denyReason) {
        switch (denyReason) {
            case PARTY_PRIORITY_BLOCKED:
                return config.message("party-priority-denied");
            case PRIORITY_BLOCKED:
                return config.message("priority-denied");
            case FULL:
            case NONE:
            default:
                return config.message("full-denied");
        }
    }

    @NotNull
    public String getKickedMessage() {
        return config.message("kicked-player");
    }

    public void playDeniedSound(@NotNull Player player) {
        config.playSound(player, "join-denied");
    }

    public void playAllowedSound(@NotNull Player player) {
        config.playSound(player, "join-allowed");
    }

    public void playKickedSound(@NotNull Player player) {
        config.playSound(player, "kicked-player");
    }

    public void logReservation(@NotNull String message) {
        if (config.isAdminLogEnabled()) {
            BukkitBedPlugin.plugin.getLogger().info("[VIP] " + message);
        }
    }
}

