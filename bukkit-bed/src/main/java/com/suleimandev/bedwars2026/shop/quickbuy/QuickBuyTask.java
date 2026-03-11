package com.suleimandev.bedwars2026.shop.quickbuy;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.shop.ShopManager;
import com.suleimandev.bedwars2026.shop.main.CategoryContent;
import com.suleimandev.bedwars2026.shop.main.ShopCategory;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import java.util.Map;
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

@SuppressWarnings("WeakerAccess")
public class QuickBuyTask extends BukkitRunnable {

    private UUID uuid;


    public QuickBuyTask(UUID uuid){
        this.uuid = uuid;
        this.runTaskLaterAsynchronously(BukkitBedPlugin.plugin, 20*7);
    }

    @Override
    public void run() {
        if (Bukkit.getPlayer(uuid) == null){
            cancel();
            return;
        }
        if (Bukkit.getPlayer(uuid).isOnline()){
            PlayerQuickBuyCache cache = PlayerQuickBuyCache.getQuickBuyCache(uuid);
            if (cache == null){
                cancel();
                return;
            }

            if (!BukkitBedPlugin.getRemoteDatabase().hasQuickBuy(uuid)){
                if (BukkitBedPlugin.shop.getYml().get(ConfigPath.SHOP_QUICK_DEFAULTS_PATH) != null){
                    for (String s : BukkitBedPlugin.shop.getYml().getConfigurationSection(ConfigPath.SHOP_QUICK_DEFAULTS_PATH).getKeys(false)) {
                        if (BukkitBedPlugin.shop.getYml().get(ConfigPath.SHOP_QUICK_DEFAULTS_PATH + "." + s + ".path") != null) {
                            if (BukkitBedPlugin.shop.getYml().get(ConfigPath.SHOP_QUICK_DEFAULTS_PATH + "." + s + ".slot") == null){
                                continue;
                            }

                            try {
                                Integer.valueOf(BukkitBedPlugin.shop.getYml().getString(ConfigPath.SHOP_QUICK_DEFAULTS_PATH + "." + s + ".slot"));
                            } catch (Exception ex){
                                BukkitBedPlugin.debug(BukkitBedPlugin.shop.getYml().getString(ConfigPath.SHOP_QUICK_DEFAULTS_PATH + "." + s + ".slot") + " must be an integer!");
                                continue;
                            }

                            for (ShopCategory sc : ShopManager.getShop().getCategoryList()) {
                                for (CategoryContent cc : sc.getCategoryContentList()) {
                                    if (cc.getIdentifier().equals(BukkitBedPlugin.shop.getYml().getString(ConfigPath.SHOP_QUICK_DEFAULTS_PATH + "." + s + ".path"))) {
                                        cache.setElement(Integer.parseInt(BukkitBedPlugin.shop.getYml().getString(ConfigPath.SHOP_QUICK_DEFAULTS_PATH + "." + s + ".slot")), cc);
                                    }
                                }
                            }

                        }
                    }
                }
            } else {
                // slot, identifier
                HashMap<Integer, String> items = BukkitBedPlugin.getRemoteDatabase().getQuickBuySlots(uuid, PlayerQuickBuyCache.quickSlots);
                if (items == null) return;
                if (items.isEmpty()) return;
                for (Map.Entry<Integer, String> entry : items.entrySet()) {
                    if (entry.getValue().isEmpty()) continue;
                    if (entry.getValue().equals(" ")) continue;
                    QuickBuyElement e = new QuickBuyElement(entry.getValue(), entry.getKey());
                    if (e.isLoaded()) {
                        cache.addQuickElement(e);
                    }
                }
            }
        }
    }

    @Override
    public synchronized void cancel() throws IllegalStateException {
        super.cancel();
    }
}

