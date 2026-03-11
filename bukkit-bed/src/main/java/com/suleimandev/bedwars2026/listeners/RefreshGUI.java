package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.api.events.gameplay.GameStateChangeEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerJoinArenaEvent;
import com.suleimandev.bedwars2026.api.events.player.PlayerLeaveArenaEvent;
import com.suleimandev.bedwars2026.api.events.server.ArenaDisableEvent;
import com.suleimandev.bedwars2026.api.events.server.ArenaEnableEvent;
import com.suleimandev.bedwars2026.arena.ArenaGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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

public class RefreshGUI implements Listener {

    @EventHandler
    public void onGameStateChange(GameStateChangeEvent e){
        if (e == null) return;
        int size = e.getArena().getPlayers().size();
        for (Player p : Bukkit.getOnlinePlayers()){
            ArenaGUI.refreshInv(p, e.getArena(), size);
        }
    }

    @EventHandler
    public void onPlayerJoinArena(PlayerJoinArenaEvent e){
        if (e == null) return;
        int size = e.getArena().getPlayers().size();
        if (!e.isSpectator()){
            size++;
        }
        for (Player p : Bukkit.getOnlinePlayers()){
            ArenaGUI.refreshInv(p, e.getArena(), size);
        }
    }

    @EventHandler
    public void onPlayerLeaveArena(PlayerLeaveArenaEvent e){
        if (e == null) return;
        int size = e.getArena().getPlayers().size();
        if (!e.isSpectator()){
            size--;
        }
        for (Player p : Bukkit.getOnlinePlayers()){
            ArenaGUI.refreshInv(p, e.getArena(), size);
        }
    }

    @EventHandler
    public void onArenaEnable(ArenaEnableEvent e){
        if (e == null) return;
        for (Player p : Bukkit.getOnlinePlayers()){
            ArenaGUI.refreshInv(p, e.getArena(), 0);
        }
    }

    @EventHandler
    public void onArenaDisable(ArenaDisableEvent e){
        for (Player p : Bukkit.getOnlinePlayers()){
            ArenaGUI.refreshInv(p, null, 0);
        }
    }
}

