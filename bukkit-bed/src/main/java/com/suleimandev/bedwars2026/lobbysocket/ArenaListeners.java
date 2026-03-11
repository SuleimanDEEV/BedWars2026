package com.suleimandev.bedwars2026.lobbysocket;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.events.gameplay.GameStateChangeEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerJoinArenaEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerLeaveArenaEvent;
import com.suleimandev.bedwars2026.api.events.server.ArenaEnableEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ArenaListeners implements Listener {

    @EventHandler
    public void onPlayerJoinArena(PlayerJoinArenaEvent e) {
        if (e == null) return;
        final IArena a = e.getArena();
        Bukkit.getScheduler().runTaskAsynchronously(BukkitBedPlugin.plugin, ()-> ArenaSocket.sendMessage(ArenaSocket.formatUpdateMessage(a)));
    }

    @EventHandler
    public void onPlayerLeaveArena(PlayerLeaveArenaEvent e){
        if (e == null) return;
        final IArena a = e.getArena();
        Bukkit.getScheduler().runTaskAsynchronously(BukkitBedPlugin.plugin, ()-> ArenaSocket.sendMessage(ArenaSocket.formatUpdateMessage(a)));
    }

    @EventHandler
    public void onArenaStatusChange(GameStateChangeEvent e){
        if (e == null) return;
        final IArena a = e.getArena();
        Bukkit.getScheduler().runTaskAsynchronously(BukkitBedPlugin.plugin, ()-> ArenaSocket.sendMessage(ArenaSocket.formatUpdateMessage(a)));
    }

    @EventHandler
    public void onArenaLoad(ArenaEnableEvent e){
        if (e == null) return;
        final IArena a = e.getArena();
        Bukkit.getScheduler().runTaskAsynchronously(BukkitBedPlugin.plugin, ()-> ArenaSocket.sendMessage(ArenaSocket.formatUpdateMessage(a)));
    }
}

