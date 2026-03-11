package com.suleimandev.bedwars2026.api.arena.shop;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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

public interface ICategoryContent {

    /**
     * Get content slot in category
     */
    int getSlot();

    /**
     * Get content preview item in player's language
     */
    ItemStack getItemStack(Player player);

    /**
     * Check if a player has this cc to quick buy
     */
    boolean hasQuick(Player player);

    /**
     * Check if is permanent content.
     */
    boolean isPermanent();

    /**
     * Check if is downgradable.
     */
    boolean isDowngradable();

    /**
     * Get category identifier.
     */
    String getIdentifier();

    /**
     * Get content tiers.
     */
    List<IContentTier> getContentTiers();
}

