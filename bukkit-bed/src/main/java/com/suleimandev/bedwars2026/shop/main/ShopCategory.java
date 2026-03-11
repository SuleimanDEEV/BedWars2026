package com.suleimandev.bedwars2026.shop.main;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.shop.ShopCache;
import com.suleimandev.bedwars2026.shop.ShopManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.nms;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ShopCategory {

    private int slot;
    private ItemStack itemStack;
    private String itemNamePath, itemLorePath, invNamePath;
    private boolean loaded = false;
    private final List<CategoryContent> categoryContentList = new ArrayList<>();
    public static List<UUID> categoryViewers = new ArrayList<>();
    private final String name;

    /**
     * Load a shop category from the given path
     */
    public ShopCategory(String path, YamlConfiguration yml) {
        BukkitBedPlugin.debug("Loading shop category: " + path);
        this.name = path;

        if (yml.get(path + ConfigPath.SHOP_CATEGORY_ITEM_MATERIAL) == null) {
            BukkitBedPlugin.plugin.getLogger().severe("Category material not set at: " + path);
            return;
        }

        if (yml.get(path + ConfigPath.SHOP_CATEGORY_SLOT) == null) {
            BukkitBedPlugin.plugin.getLogger().severe("Category slot not set at: " + path);
            return;
        }
        slot = yml.getInt(path + ConfigPath.SHOP_CATEGORY_SLOT);

        if (slot < 1 || slot > 8) {
            BukkitBedPlugin.plugin.getLogger().severe("Slot must be n > 1 and n < 9 at: " + path);
            return;
        }

        for (ShopCategory sc : ShopManager.shop.getCategoryList()){
            if (sc.getSlot() == slot){
                BukkitBedPlugin.plugin.getLogger().severe("Slot is already in use at: " + path);
                return;
            }
        }

        itemStack = BukkitBedPlugin.nms.createItemStack(yml.getString(path + ConfigPath.SHOP_CATEGORY_ITEM_MATERIAL),
                yml.get(path + ConfigPath.SHOP_CATEGORY_ITEM_AMOUNT) == null ? 1 : yml.getInt(path + ConfigPath.SHOP_CATEGORY_ITEM_AMOUNT),
                (short) (yml.get(path + ConfigPath.SHOP_CATEGORY_ITEM_DATA) == null ? 0 : yml.getInt(path + ConfigPath.SHOP_CATEGORY_ITEM_DATA)));


        if (yml.get(path + ConfigPath.SHOP_CATEGORY_ITEM_ENCHANTED) != null) {
            if (yml.getBoolean(path + ConfigPath.SHOP_CATEGORY_ITEM_ENCHANTED)) {
                itemStack = ShopManager.enchantItem(itemStack);
            }
        }

        // potion display color based on NBT tag
        if (yml.getString(path + ".category-item.potion-display") != null && !yml.getString(path + ".category-item.potion-display").isEmpty()) {
            itemStack = nms.setTag(itemStack, "Potion", yml.getString(path + ".category-item.potion-display"));
        }
        // 1.16+ custom color
        if (yml.getString(path + ".category-item.potion-color") != null && !yml.getString(path + ".category-item.potion-color").isEmpty()) {
            itemStack = nms.setTag(itemStack, "CustomPotionColor", yml.getString(path + ".category-item.potion-color"));
        }

        if (itemStack.getItemMeta() != null) {
            itemStack.setItemMeta(ShopManager.hideItemStuff(itemStack.getItemMeta()));
        }

        itemNamePath = Messages.SHOP_CATEGORY_ITEM_NAME.replace("%category%", path);
        itemLorePath = Messages.SHOP_CATEGORY_ITEM_LORE.replace("%category%", path);
        invNamePath = Messages.SHOP_CATEGORY_INVENTORY_NAME.replace("%category%", path);
        loaded = true;

        CategoryContent cc;
        for (String s : yml.getConfigurationSection(path + "." + ConfigPath.SHOP_CATEGORY_CONTENT_PATH).getKeys(false)) {
            cc = new CategoryContent(path + ConfigPath.SHOP_CATEGORY_CONTENT_PATH + "." + s, s, path, yml, this);
            if (cc.isLoaded()) {
                categoryContentList.add(cc);
                BukkitBedPlugin.debug("Adding CategoryContent: " + s + " to Shop Category: " + path);
            }
        }
    }

    public void open(Player player, ShopIndex index, ShopCache shopCache){
        if (player.getOpenInventory().getTopInventory() == null) return;
        ShopIndex.indexViewers.remove(player.getUniqueId());

        Inventory inv = Bukkit.createInventory(null, index.getInvSize(), Language.getMsg(player, invNamePath));

        inv.setItem(index.getQuickBuyButton().getSlot(), index.getQuickBuyButton().getItemStack(player));

        for (ShopCategory sc : index.getCategoryList()) {
            inv.setItem(sc.getSlot(), sc.getItemStack(player));
        }

        index.addSeparator(player, inv);

        inv.setItem(getSlot() + 9, index.getSelectedItem(player));

        shopCache.setSelectedCategory(getSlot());

        for (CategoryContent cc : getCategoryContentList()) {
            inv.setItem(cc.getSlot(), cc.getItemStack(player, shopCache));
        }

        player.openInventory(inv);
        if (!categoryViewers.contains(player.getUniqueId())){
            categoryViewers.add(player.getUniqueId());
        }
    }

    /**
     * Get the category preview item in player's language
     */
    public ItemStack getItemStack(Player player) {
        ItemStack i = itemStack.clone();
        ItemMeta im = i.getItemMeta();
        if (im != null) {
            im.setDisplayName(Language.getMsg(player, itemNamePath));
            im.setLore(Language.getList(player, itemLorePath));
            i.setItemMeta(im);
        }
        return i;
    }

    /**
     * Check if category was loaded
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * Get category slot in shop index
     */
    public int getSlot() {
        return slot;
    }

    public List<CategoryContent> getCategoryContentList() {
        return categoryContentList;
    }

    /**Get a category content by identifier*/
    public static CategoryContent getCategoryContent(String identifier, ShopIndex shopIndex){
        for (ShopCategory sc : shopIndex.getCategoryList()){
            for (CategoryContent cc : sc.getCategoryContentList()){
                if (cc.getIdentifier().equals(identifier)) return cc;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public static List<UUID> getCategoryViewers() {
        return new ArrayList<>(categoryViewers);
    }
}

