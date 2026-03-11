package com.suleimandev.bedwars2026.vip.service;

import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Comparator;
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

public class VipReservedSlotPolicy {

    public enum DenyReason {
        NONE,
        FULL,
        PRIORITY_BLOCKED,
        PARTY_PRIORITY_BLOCKED
    }

    public static class Result {

        private final boolean allowed;
        private final DenyReason denyReason;
        private final List<Player> displacedPlayers;

        public Result(boolean allowed, @NotNull DenyReason denyReason, @NotNull List<Player> displacedPlayers) {
            this.allowed = allowed;
            this.denyReason = denyReason;
            this.displacedPlayers = displacedPlayers;
        }

        public boolean isAllowed() {
            return allowed;
        }

        @NotNull
        public DenyReason getDenyReason() {
            return denyReason;
        }

        @NotNull
        public List<Player> getDisplacedPlayers() {
            return displacedPlayers;
        }
    }

    private final VipPermissionResolver permissionResolver;
    private final VipJoinPriority joinPriority;

    public VipReservedSlotPolicy(@NotNull VipPermissionResolver permissionResolver, @NotNull VipJoinPriority joinPriority) {
        this.permissionResolver = permissionResolver;
        this.joinPriority = joinPriority;
    }

    @NotNull
    public Result reserve(@NotNull Arena arena,
                          @NotNull Player requester,
                          int requestedSlots,
                          boolean allowJoinFull,
                          boolean allowPartyPriority,
                          boolean allowDisplacement) {
        int freeSlots = arena.getMaxPlayers() - arena.getPlayers().size();
        if (freeSlots >= requestedSlots) {
            return new Result(true, DenyReason.NONE, new ArrayList<>());
        }

        if (!allowJoinFull) {
            return new Result(false, DenyReason.FULL, new ArrayList<>());
        }

        if (requestedSlots > 1 && !allowPartyPriority) {
            return new Result(false, DenyReason.PARTY_PRIORITY_BLOCKED, new ArrayList<>());
        }

        if (!allowDisplacement) {
            return new Result(false, DenyReason.PRIORITY_BLOCKED, new ArrayList<>());
        }

        int requesterPriority = joinPriority.resolvePriority(requester);
        int slotsNeeded = requestedSlots - freeSlots;

        List<Player> candidates = new ArrayList<>();
        for (Player inArena : arena.getPlayers()) {
            if (permissionResolver.isExempt(inArena)) {
                continue;
            }
            if (requesterPriority > joinPriority.resolvePriority(inArena)) {
                candidates.add(inArena);
            }
        }

        candidates.sort(Comparator.comparingInt(joinPriority::resolvePriority));
        if (candidates.size() < slotsNeeded) {
            return new Result(false, DenyReason.PRIORITY_BLOCKED, new ArrayList<>());
        }

        return new Result(true, DenyReason.NONE, new ArrayList<>(candidates.subList(0, slotsNeeded)));
    }
}

