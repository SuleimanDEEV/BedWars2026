package com.suleimandev.bedwars2026.arena;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import java.util.Random;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class VoidChunkGenerator extends ChunkGenerator {

    @Override
    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid b) {
        return this.createChunkData(world);
    }

    @Override
    public final Location getFixedSpawnLocation(World world, Random random) {
        return new Location(world, 0.0D, 64.0D, 0.0D);
    }
}

