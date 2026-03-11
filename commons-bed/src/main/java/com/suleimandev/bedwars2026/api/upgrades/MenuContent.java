package com.suleimandev.bedwars2026.api.upgrades;

import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
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

public interface MenuContent {

    /**
     * Item that represent the item in the GUI.
     *
     * @return item.
     */
    ItemStack getDisplayItem(Player player, ITeam team);

    /**
     * Manage what to do on click.
     */
    void onClick(Player player, ClickType clickType, ITeam team);

    /**
     * Get identifier.
     *
     * @return content name.
     */
    String getName();
}

