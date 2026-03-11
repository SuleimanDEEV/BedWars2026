package com.suleimandev.bedwars2026.api.util;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class BlockRay implements Iterator<Block> {

    private final World world;
    private final Vector cursor;
    private final Vector stepDirection;
    private final double step;
    private final double maxDistance;

    private double travelledDistance;
    private Block lastReturnedBlock;
    private Block nextBlock;

    public BlockRay(World world, Vector start, Vector end, double step) {
        if (world == null || start == null || end == null) {
            throw new IllegalArgumentException("world and vectors must not be null");
        }
        if (step <= 0) {
            throw new IllegalArgumentException("step must be greater than zero");
        }

        Vector delta = end.clone().subtract(start);
        double distance = delta.length();
        if (distance <= 0) {
            throw new IllegalArgumentException("start and end must not be the same");
        }

        this.world = world;
        this.cursor = start.clone();
        this.step = step;
        this.maxDistance = distance;
        this.stepDirection = delta.normalize().multiply(step);

        this.travelledDistance = 0;
        advance();
    }

    @Override
    public boolean hasNext() {
        return nextBlock != null;
    }

    @Override
    public Block next() {
        if (nextBlock == null) {
            throw new NoSuchElementException("No more blocks in this ray.");
        }

        Block current = nextBlock;
        advance();
        return current;
    }

    private void advance() {
        nextBlock = null;

        while (travelledDistance <= maxDistance + step) {
            Block currentBlock = world.getBlockAt(
                    NumberConversions.floor(cursor.getX()),
                    NumberConversions.floor(cursor.getY()),
                    NumberConversions.floor(cursor.getZ())
            );

            cursor.add(stepDirection);
            travelledDistance += step;

            if (!isSameBlock(currentBlock, lastReturnedBlock)) {
                lastReturnedBlock = currentBlock;
                nextBlock = currentBlock;
                return;
            }
        }
    }

    private boolean isSameBlock(Block first, Block second) {
        if (first == null || second == null) {
            return first == second;
        }

        return first.getX() == second.getX()
                && first.getY() == second.getY()
                && first.getZ() == second.getZ()
                && first.getWorld().equals(second.getWorld());
    }
}
