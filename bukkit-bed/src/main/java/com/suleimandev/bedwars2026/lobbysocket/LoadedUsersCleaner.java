package com.suleimandev.bedwars2026.lobbysocket;

import com.suleimandev.bedwars2026.support.preloadedparty.PreLoadedParty;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import java.util.LinkedList;
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

public class LoadedUsersCleaner implements Runnable {

    private final List<LoadedUser> toRemove = new LinkedList<>();

    @Override
    public void run() {
        for (LoadedUser lu : LoadedUser.getLoaded().values()) {
            if (lu.isTimedOut()) {
                toRemove.add(lu);
            }
        }
        if (!toRemove.isEmpty()) {
            toRemove.forEach(c -> {
                OfflinePlayer op = Bukkit.getOfflinePlayer(c.getUuid());
                if (op != null && op.getName() != null) {
                    PreLoadedParty plp = PreLoadedParty.getPartyByOwner(op.getName());
                    if (plp != null) {
                        plp.clean();
                    }
                }
                c.destroy("Removed by cleaner task.");
            });
            toRemove.clear();
        }
    }
}

