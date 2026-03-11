package com.suleimandev.bedwars2026.listeners.joinhandler;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.ReJoin;
import com.suleimandev.bedwars2026.sidebar.MatchSidebarService;
import com.suleimandev.bedwars2026.support.paper.TeleportManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.*;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class JoinListenerMultiArena implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        final Player p = e.getPlayer();
        p.getInventory().setArmorContents(null);

        JoinHandlerCommon.displayCustomerDetails(p);

        // Show commands if player is op and there is no set arenas
        if (p.isOp()) {
            if (Arena.getArenas().isEmpty()) {
                p.performCommand(mainCmd);
            }
        }

        ReJoin reJoin = ReJoin.getPlayer(p);

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            // Hide new player to players and spectators, and vice versa
            // Players from lobby will remain visible
            for (Player online : Bukkit.getOnlinePlayers()){
                if (Arena.isInArena(online)) {
                    BukkitBedPlugin.nms.spigotHidePlayer(online, p);
                    BukkitBedPlugin.nms.spigotHidePlayer(p, online);
                } else {
                    BukkitBedPlugin.nms.spigotShowPlayer(online, p);
                    BukkitBedPlugin.nms.spigotShowPlayer(p, online);
                }
            }

            // To prevent invisibility issues handle ReJoin after sending invisibility packets
            if (reJoin != null) {
                if (reJoin.canReJoin()) {
                    reJoin.reJoin(p);
                    return;
                }
                reJoin.destroy(false);
            }
        }, 14L);

        if (reJoin != null && reJoin.canReJoin()) return;

        // Teleport to lobby location
        Location lobbyLocation = config.getConfigLoc("lobbyLoc");
        if (lobbyLocation != null && lobbyLocation.getWorld() != null) {
            TeleportManager.teleport(p, lobbyLocation);
        }

        // Send items
        Arena.sendLobbyCommandItems(p);

        MatchSidebarService.getInstance().giveSidebar(p, null, true);

        p.setHealthScale(p.getMaxHealth());
        p.setExp(0);
        p.setHealthScale(20);
        p.setFoodLevel(20);
    }
}


