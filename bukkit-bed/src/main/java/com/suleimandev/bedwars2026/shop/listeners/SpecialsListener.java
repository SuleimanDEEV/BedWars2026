package com.suleimandev.bedwars2026.shop.listeners;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.events.player.PlayerBedBugSpawnEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerDreamDefenderSpawnEvent;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
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

public class SpecialsListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onSpecialInteract(PlayerInteractEvent e) {
        if (e.isCancelled()) return;
        Player p = e.getPlayer();
        ItemStack i = e.getItem();
        if (i == null) return;
        if (i.getType() == Material.AIR) return;
        IArena a = Arena.getArenaByPlayer(p);
        if (a == null) return;
        if (a.getRespawnSessions().containsKey(e.getPlayer())) return;
        if (!a.isPlayer(p)) return;
        Block b = e.getClickedBlock();
        if (b == null) return;
        Location l = b.getLocation();

        if (BukkitBedPlugin.shop.getYml().getBoolean(ConfigPath.SHOP_SPECIAL_SILVERFISH_ENABLE)) {
            if (!Misc.isProjectile(Material.valueOf(BukkitBedPlugin.shop.getYml().getString(ConfigPath.SHOP_SPECIAL_SILVERFISH_MATERIAL)))) {
                if (i.getType() == Material.valueOf(BukkitBedPlugin.shop.getYml().getString(ConfigPath.SHOP_SPECIAL_SILVERFISH_MATERIAL))
                        && nms.itemStackDataCompare(i, (short) BukkitBedPlugin.shop.getYml().getInt(ConfigPath.SHOP_SPECIAL_SILVERFISH_DATA))) {
                    e.setCancelled(true);
                    ITeam playerTeam = a.getTeam(p);
                    PlayerBedBugSpawnEvent event = new PlayerBedBugSpawnEvent(p, playerTeam, a);
                    nms.spawnSilverfish(l.add(0, 1, 0), playerTeam, BukkitBedPlugin.shop.getYml().getDouble(ConfigPath.SHOP_SPECIAL_SILVERFISH_SPEED),
                            BukkitBedPlugin.shop.getYml().getDouble(ConfigPath.SHOP_SPECIAL_SILVERFISH_HEALTH), BukkitBedPlugin.shop.getInt(ConfigPath.SHOP_SPECIAL_SILVERFISH_DESPAWN),
                            BukkitBedPlugin.shop.getYml().getDouble(ConfigPath.SHOP_SPECIAL_SILVERFISH_DAMAGE));
                    Bukkit.getPluginManager().callEvent(event);
                    if (!nms.isProjectile(i)) {
                        nms.minusAmount(p, i, 1);
                        p.updateInventory();
                    }
                }
            }
        }
        if (BukkitBedPlugin.shop.getYml().getBoolean(ConfigPath.SHOP_SPECIAL_IRON_GOLEM_ENABLE)) {
            if (!Misc.isProjectile(Material.valueOf(BukkitBedPlugin.shop.getYml().getString(ConfigPath.SHOP_SPECIAL_IRON_GOLEM_MATERIAL)))) {
                if (i.getType() == Material.valueOf(BukkitBedPlugin.shop.getYml().getString(ConfigPath.SHOP_SPECIAL_IRON_GOLEM_MATERIAL))
                        && nms.itemStackDataCompare(i, (short) BukkitBedPlugin.shop.getYml().getInt(ConfigPath.SHOP_SPECIAL_IRON_GOLEM_DATA))) {
                    e.setCancelled(true);
                    ITeam playerTeam = a.getTeam(p);
                    PlayerDreamDefenderSpawnEvent event = new PlayerDreamDefenderSpawnEvent(p, playerTeam, a);
                    nms.spawnIronGolem(l.add(0, 1, 0), playerTeam, BukkitBedPlugin.shop.getYml().getDouble(ConfigPath.SHOP_SPECIAL_IRON_GOLEM_SPEED),
                            BukkitBedPlugin.shop.getYml().getDouble(ConfigPath.SHOP_SPECIAL_IRON_GOLEM_HEALTH), BukkitBedPlugin.shop.getInt(ConfigPath.SHOP_SPECIAL_IRON_GOLEM_DESPAWN));
                    Bukkit.getPluginManager().callEvent(event);
                    if (!nms.isProjectile(i)) {
                        nms.minusAmount(p, i, 1);
                        p.updateInventory();
                    }
                }
            }
        }
    }
}

