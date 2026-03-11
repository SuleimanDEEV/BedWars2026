package com.suleimandev.bedwars2026.shop.quickbuy;

import com.suleimandev.bedwars2026.shop.ShopManager;
import com.suleimandev.bedwars2026.shop.main.CategoryContent;
import com.suleimandev.bedwars2026.shop.main.ShopCategory;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class QuickBuyElement {

    private int slot;
    private CategoryContent categoryContent;
    private boolean loaded = false;


    public QuickBuyElement(String path, int slot){
        this.categoryContent = ShopCategory.getCategoryContent(path, ShopManager.getShop());
        if (this.categoryContent != null) this.loaded = true;
        this.slot = slot;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public int getSlot() {
        return slot;
    }

    public CategoryContent getCategoryContent() {
        return categoryContent;
    }
}

