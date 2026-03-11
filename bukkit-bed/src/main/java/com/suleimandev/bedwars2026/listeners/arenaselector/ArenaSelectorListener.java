package com.suleimandev.bedwars2026.listeners.arenaselector;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.ArenaGUI;
import com.suleimandev.bedwars2026.configuration.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
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

public class ArenaSelectorListener implements Listener {

    public static final String ARENA_SELECTOR_GUI_IDENTIFIER = "arena=";

    @EventHandler
    public void onArenaSelectorClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!(player.getOpenInventory().getTopInventory().getHolder() instanceof ArenaGUI.ArenaSelectorHolder)) return;

        event.setCancelled(true);

        ItemStack item = event.getCurrentItem();
        if (item == null) return;
        if (item.getType() == Material.AIR) return;
        if (!BukkitBedPlugin.nms.isCustomBedWarsItem(item)) return;

        String data = BukkitBedPlugin.nms.getCustomData(item);
        if (data.startsWith("RUNCOMMAND")) {
            Bukkit.dispatchCommand(player, data.split("_")[1]);
        }

        if (!data.contains(ARENA_SELECTOR_GUI_IDENTIFIER)) return;

        String arenaName = data.split("=")[1];
        IArena arena = Arena.getArenaByName(arenaName);
        if (arena == null) return;
        GameState status = arena.getStatus();

        if (event.getClick() == ClickType.LEFT) {
            if ((status == GameState.waiting || status == GameState.starting) && arena.addPlayer(player, false)) {
                Sounds.playSound("join-allowed", player);
            } else {
                Sounds.playSound("join-denied", player);
                player.sendMessage(Language.getMsg(player, Messages.ARENA_JOIN_DENIED_SELECTOR));
            }
        } else if (event.getClick() == ClickType.RIGHT) {
            if (status == GameState.playing && arena.addSpectator(player, false, null)) {
                Sounds.playSound("spectate-allowed", player);
            } else {
                player.sendMessage(Language.getMsg(player, Messages.ARENA_SPECTATE_DENIED_SELECTOR));
                Sounds.playSound("spectate-denied", player);
            }
        } else {
            // Incorrect click
            return;
        }

        player.closeInventory();
    }
}

