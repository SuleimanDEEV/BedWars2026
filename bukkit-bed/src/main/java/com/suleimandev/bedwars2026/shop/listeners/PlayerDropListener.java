package com.suleimandev.bedwars2026.shop.listeners;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
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

public class PlayerDropListener implements Listener {

    @EventHandler
    //Prevent from dropping permanent items
    public void onDrop(PlayerDropItemEvent e) {
        IArena a = Arena.getArenaByPlayer(e.getPlayer());
        if (a == null) return;
        String identifier = BukkitBedPlugin.nms.getShopUpgradeIdentifier(e.getItemDrop().getItemStack());
        if (identifier == null) return;
        if (identifier.isEmpty() || identifier.equals(" ")) return;
        if (identifier.equals("null")) return;
        e.setCancelled(true);
    }

    @EventHandler
    //Prevent from moving items in chests
    public void onClose(InventoryCloseEvent e) {
        if (!(e instanceof Player)) return;
        IArena a = Arena.getArenaByPlayer((Player) e.getPlayer());
        if (a == null) return;
        String identifier;
        for (ItemStack i : e.getInventory()) {
            if (i == null) continue;
            if (i.getType() == Material.AIR) continue;
            identifier = BukkitBedPlugin.nms.getShopUpgradeIdentifier(i);
            if (identifier.isEmpty() || identifier.equals(" ")) return;
        }
    }
}

