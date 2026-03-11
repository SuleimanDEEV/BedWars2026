package com.suleimandev.bedwars2026.popuptower;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.team.TeamColor;
import com.suleimandev.bedwars2026.api.region.Region;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class NewPlaceBlock {
    public NewPlaceBlock(Block b, String xyz, TeamColor color, Player p, boolean ladder, int ladderdata) {
        int x = Integer.parseInt(xyz.split(", ")[0]);
        int y = Integer.parseInt(xyz.split(", ")[1]);
        int z = Integer.parseInt(xyz.split(", ")[2]);
        if (b.getRelative(x, y, z).getType().equals(Material.AIR)) {
            for (Region r : Arena.getArenaByPlayer(p).getRegionsList())
                if (r.isInRegion(b.getRelative(x, y, z).getLocation()))
                    return;

            if (!ladder)
                BukkitBedPlugin.nms.placeTowerBlocks(b, Arena.getArenaByPlayer(p), color, x, y, z);
            else
                BukkitBedPlugin.nms.placeLadder(b, x, y, z, Arena.getArenaByPlayer(p), ladderdata);
        }

    }
}

