package com.suleimandev.bedwars2026.arena.tasks;

import com.suleimandev.bedwars2026.api.arena.generator.IGenerator;
import com.suleimandev.bedwars2026.arena.OreGenerator;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class OneTick implements Runnable {
    @Override
    public void run() {

        //OneTick generators
        for (IGenerator h : OreGenerator.getRotation()) {
            h.rotate();
        }
    }
}

