package com.suleimandev.bedwars2026.party.model;

import java.util.LinkedHashSet;
import java.util.Set;
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

public class PartyGroup {

    private UUID leader;
    private final LinkedHashSet<UUID> members = new LinkedHashSet<>();

    public PartyGroup(UUID leader) {
        this.leader = leader;
        this.members.add(leader);
    }

    public UUID getLeader() {
        return leader;
    }

    public void setLeader(UUID leader) {
        this.leader = leader;
        this.members.add(leader);
    }

    public Set<UUID> getMembers() {
        return members;
    }

    public boolean contains(UUID playerId) {
        return members.contains(playerId);
    }
}

