package com.suleimandev.bedwars2026.api.upgrades;

import com.suleimandev.bedwars2026.api.arena.team.ITeam;
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

public interface EnemyBaseEnterTrap {

    /**
     * Trap name msg path.
     */
    String getNameMsgPath();

    /**
     * Trap lore msg path.
     */
    String getLoreMsgPath();

    /**
     * Trap display item for man gui.
     */
    ItemStack getItemStack();

    /**
     * What to do on trigger.
     */
    void trigger(ITeam trapTeam, Player player);
}

