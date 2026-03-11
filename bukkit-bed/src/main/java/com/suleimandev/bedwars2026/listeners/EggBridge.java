package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.events.gameplay.EggBridgeThrowEvent;
import com.suleimandev.bedwars2026.api.server.ServerType;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.tasks.EggBridgeTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
public class EggBridge implements Listener {

    //Active eggBridges
    private static HashMap<Egg, EggBridgeTask> bridges = new HashMap<>();

    @EventHandler
    public void onLaunch(ProjectileLaunchEvent event) {
        if (BukkitBedPlugin.getServerType() == ServerType.MULTIARENA) {
            if (event.getEntity().getLocation().getWorld().getName().equalsIgnoreCase(BukkitBedPlugin.getLobbyWorld())) {
                event.setCancelled(true);
                return;
            }
        }
        if (event.getEntity() instanceof Egg) {
            Egg projectile = (Egg) event.getEntity();
            if (projectile.getShooter() instanceof Player) {
                Player shooter = (Player) projectile.getShooter();
                IArena arena = Arena.getArenaByPlayer(shooter);
                if (arena != null) {
                    if (arena.isPlayer(shooter)) {
                        EggBridgeThrowEvent throwEvent = new EggBridgeThrowEvent(shooter, arena);
                        Bukkit.getPluginManager().callEvent(throwEvent);
                        if (event.isCancelled()) {
                            event.setCancelled(true);
                            return;
                        }
                        bridges.put(projectile, new EggBridgeTask(shooter, projectile, arena.getTeam(shooter).getColor()));
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent e) {
        if (e.getEntity() instanceof Egg) {
            removeEgg((Egg) e.getEntity());
        }
    }

    /**
     * Remove an egg from the active eggs list
     *
     * @since BukkitBedApi 7
     */
    public static void removeEgg(Egg e) {
        if (bridges.containsKey(e)) {
            if (bridges.get(e) != null) {
                bridges.get(e).cancel();
            }
            bridges.remove(e);
        }
    }

    /**
     * Get active egg bridges.
     * Modified  in api 11
     *
     * @since BukkitBedApi 11
     */
    public static Map<Egg, EggBridgeTask> getBridges() {
        return Collections.unmodifiableMap(bridges);
    }
}

