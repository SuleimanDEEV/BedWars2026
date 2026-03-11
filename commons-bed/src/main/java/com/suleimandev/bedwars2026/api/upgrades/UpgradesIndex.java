package com.suleimandev.bedwars2026.api.upgrades;

import com.google.common.collect.ImmutableMap;
import com.suleimandev.bedwars2026.api.CommonsBedApi;
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

public interface UpgradesIndex {

    /**
     * Get menu name.
     */
    String getName();

    /**
     * Open this menu to a player.
     * Make sure to use {@link CommonsBedApi.TeamUpgradesUtil#setWatchingGUI(Player)}
     *
     * @param player target player.
     */
    void open(Player player);

    /**
     * Add content to a menu.
     *
     * @param content content instance.
     * @param slot    where to put the content in the menu.
     * @return false if te given slot is in use.
     */
    boolean addContent(MenuContent content, int slot);

    /**
     *
     * @return total amount of tiers in upgrades
     */
    int countTiers();

    ImmutableMap<Integer, MenuContent> getMenuContentBySlot();
}

