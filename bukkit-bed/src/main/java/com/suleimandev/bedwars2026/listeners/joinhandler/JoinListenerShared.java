package com.suleimandev.bedwars2026.listeners.joinhandler;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.sidebar.MatchSidebarService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.mainCmd;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.plugin;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class JoinListenerShared implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        final Player p = e.getPlayer();

        JoinHandlerCommon.displayCustomerDetails(p);

        // Show commands if player is op and there is no set arenas
        if (p.isOp()) {
            if (Arena.getArenas().isEmpty()) {
                p.performCommand(mainCmd);
            }
        }

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            // Hide new player to players and spectators, and vice versa
            for (Player inArena : Arena.getArenaByPlayer().keySet()){
                if (inArena.equals(p)) continue;
                BukkitBedPlugin.nms.spigotHidePlayer(p, inArena);
                BukkitBedPlugin.nms.spigotHidePlayer(inArena, p);
            }
        }, 14L);

        // Give scoreboard
        if (e.getPlayer().getWorld().getName().equalsIgnoreCase(BukkitBedPlugin.getLobbyWorld())) {
            MatchSidebarService.getInstance().giveSidebar(e.getPlayer(), null, true);
        }
    }
}


