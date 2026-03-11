package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class Warnings implements Listener {
    private final BukkitBedPlugin plugin;

    public Warnings(BukkitBedPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(!player.isOp()) return;

        if (Bukkit.getPluginManager().isPluginEnabled("Multiverse-Core")) {
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                player.sendMessage(ChatColor.RED + "[BEDWARS 2026] Multiverse-Core detected! Please remove it or make sure it won't touch BukkitBedPlugin maps!");
            }, 5); // run after 5 ticks to make sure its after any update spam on join
        }

        if(Bukkit.getServer().getSpawnRadius() > 0) {
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                player.sendMessage(ChatColor.RED + "[BEDWARS 2026] Your spawn-protection in server.properties is enabled. " + ChatColor.YELLOW + "This might mess with BukkitBedPlugin arenas!" + ChatColor.GRAY + " It is highly reccomend setting it to 0.");
            }, 5);
        }
    }
}

