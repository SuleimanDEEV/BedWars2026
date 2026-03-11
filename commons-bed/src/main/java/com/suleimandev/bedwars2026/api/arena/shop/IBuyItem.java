package com.suleimandev.bedwars2026.api.arena.shop;

import com.suleimandev.bedwars2026.api.arena.IArena;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public interface IBuyItem {

    /**
     * Check if tier is loaded
     */
    boolean isLoaded();

    /**
     * Give content to a player
     */
    void give(Player player, IArena arena);

    /**
     * Get upgrade identifier.
     * Used to remove old tier items.
     */
    String getUpgradeIdentifier();

    ItemStack getItemStack();

    void setItemStack(ItemStack itemStack);

    boolean isAutoEquip();

    void setAutoEquip(boolean autoEquip);

    boolean isPermanent();

    void setPermanent(boolean permanent);

    boolean isUnbreakable();

    void setUnbreakable(boolean permanent);
}

