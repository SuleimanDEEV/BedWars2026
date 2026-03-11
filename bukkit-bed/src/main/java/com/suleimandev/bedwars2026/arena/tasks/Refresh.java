package com.suleimandev.bedwars2026.arena.tasks;

import com.suleimandev.bedwars2026.api.entity.Despawnable;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.nms;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class Refresh implements Runnable {

    @Override
    public void run() {
        for (Despawnable d : nms.getDespawnablesList().values()){
            d.refresh();
        }
    }
}

