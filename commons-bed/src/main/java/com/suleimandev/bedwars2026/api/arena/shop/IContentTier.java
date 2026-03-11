package com.suleimandev.bedwars2026.api.arena.shop;

import org.bukkit.Material;
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

public interface IContentTier {

    /**
     * Get tier price
     */
    int getPrice();

    /**
     * Get tier currency.
     * {@link Material#AIR} for vault.
     */
    Material getCurrency();


    /**
     * Set tier currency.
     * {@link Material#AIR} for vault.
     */
    void setCurrency(Material currency);

    /**
     * Set tier price.
     */
    void setPrice(int price);

    /**
     * Set tier preview item.
     */
    void setItemStack(ItemStack itemStack);

    /**
     * Set list of items that you receive on buy.
     */
    void setBuyItemsList(List<IBuyItem> buyItemsList);

    /**
     * Get item stack with name and lore in player's language
     */
    ItemStack getItemStack();
    /**
     * Get tier level
     */
    int getValue();

    /**
     * Get items
     */
    List<IBuyItem> getBuyItemsList();
}

