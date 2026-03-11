package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.api.CommonsBedApi;
import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.events.player.PlayerGeneratorCollectEvent;
import com.suleimandev.bedwars2026.api.server.ServerType;
import com.suleimandev.bedwars2026.support.version.common.VersionCommon;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class PlayerDropPick_1_11Minus implements Listener {

    private static CommonsBedApi api;

    // Why is it unused????????
    public PlayerDropPick_1_11Minus(CommonsBedApi bedWars){
        api = bedWars;
    }

    /* This Class is used for versions from 1.8.8 to 1.11 included */

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        if (api.getServerType() == ServerType.MULTIARENA) {
            //noinspection ConstantConditions
            if (e.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase(api.getLobbyWorld())) {
                e.setCancelled(true);
                return;
            }
        }

        IArena a = api.getArenaUtil().getArenaByPlayer(e.getPlayer());
        if (a == null) return;

        if (!a.isPlayer(e.getPlayer())) {
            e.setCancelled(true);
            return;
        }

        if (a.getStatus() != GameState.playing) {
            e.setCancelled(true);
            return;
        }

        if (a.getRespawnSessions().containsKey(e.getPlayer())) {
            e.setCancelled(true);
            return;
        }

        if (e.getItem().getItemStack().getType() == Material.ARROW){
            e.getItem().setItemStack(api.getVersionSupport().createItemStack(e.getItem().getItemStack().getType().toString(), e.getItem().getItemStack().getAmount(), (short) 0));
            return;
        }

        if (VersionCommon.api.getVersionSupport().isBed(e.getItem().getItemStack().getType())) {
            e.setCancelled(true);
            e.getItem().remove();
        } else if (e.getItem().getItemStack().hasItemMeta()) {
            //noinspection ConstantConditions
            if (e.getItem().getItemStack().getItemMeta().hasDisplayName()) {
                if (e.getItem().getItemStack().getItemMeta().getDisplayName().contains("custom")) {
                    Material material = e.getItem().getItemStack().getType();
                    ItemMeta itemMeta = new ItemStack(material).getItemMeta();

                    //Call ore pick up event

                    if (!api.getAFKUtil().isPlayerAFK(e.getPlayer())){
                        PlayerGeneratorCollectEvent event = new PlayerGeneratorCollectEvent(e.getPlayer(), e.getItem(), a);
                        Bukkit.getPluginManager().callEvent(event);
                        if (event.isCancelled()){
                            e.setCancelled(true);
                        } else {
                            e.getItem().getItemStack().setItemMeta(itemMeta);
                        }
                    }
                    else {  //Cancel Event if play is afk
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (api.getServerType() == ServerType.MULTIARENA) {
            //noinspection ConstantConditions
            if (e.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase(api.getLobbyWorld())) {
                e.setCancelled(true);
                return;
            }
        }
        IArena a = api.getArenaUtil().getArenaByPlayer(e.getPlayer());
        if (a == null) return;

        if (!a.isPlayer(e.getPlayer())) {
            e.setCancelled(true);
            return;
        }

        if (a.getStatus() != GameState.playing) {
            e.setCancelled(true);
        } else {
            ItemStack i = e.getItemDrop().getItemStack();
            if (i.getType() == Material.COMPASS) {
                e.setCancelled(true);
                return;
            }
        }

        if (a.getRespawnSessions().containsKey(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}

