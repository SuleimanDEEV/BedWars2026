package com.suleimandev.bedwars2026.shop.quickbuy;

import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.shop.ShopCache;
import com.suleimandev.bedwars2026.shop.ShopManager;
import com.suleimandev.bedwars2026.shop.main.CategoryContent;
import com.suleimandev.bedwars2026.shop.main.ShopCategory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class QuickBuyAdd {

    public static HashMap<UUID, CategoryContent> quickBuyAdds = new HashMap<>();

    public QuickBuyAdd(Player player, CategoryContent cc){
        ShopCategory.categoryViewers.remove(player.getUniqueId());
        open(player, cc);
    }

    public void open(Player player, CategoryContent cc){
        Inventory inv = Bukkit.createInventory(null, ShopManager.getShop().getInvSize(), Language.getMsg(player, Messages.SHOP_QUICK_ADD_NAME));
        PlayerQuickBuyCache cache = PlayerQuickBuyCache.getQuickBuyCache(player.getUniqueId());
        ShopCache sc = ShopCache.getShopCache(player.getUniqueId());
        if (sc == null || cache == null){
            player.closeInventory();
        }
        inv.setItem(4, cc.getItemStack(player, Objects.requireNonNull(sc)));

        Objects.requireNonNull(cache).addInInventory(inv, sc);

        player.openInventory(inv);
        quickBuyAdds.put(player.getUniqueId(), cc);
    }

    public static HashMap<UUID, CategoryContent> getQuickBuyAdds() {
        return new HashMap<>(quickBuyAdds);
    }
}

