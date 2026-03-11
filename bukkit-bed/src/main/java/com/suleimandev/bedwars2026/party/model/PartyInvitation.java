package com.suleimandev.bedwars2026.party.model;

import java.util.UUID;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class PartyInvitation {

    private final UUID owner;
    private final UUID target;
    private final long createdAt;

    public PartyInvitation(UUID owner, UUID target, long createdAt) {
        this.owner = owner;
        this.target = target;
        this.createdAt = createdAt;
    }

    public UUID getOwner() {
        return owner;
    }

    public UUID getTarget() {
        return target;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}

