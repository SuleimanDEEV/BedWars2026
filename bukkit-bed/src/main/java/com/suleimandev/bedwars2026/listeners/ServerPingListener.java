package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.arena.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ServerPingListener implements Listener {
    @EventHandler
    public void onPing(ServerListPingEvent e){
        if (!Arena.getArenas().isEmpty()){
            IArena a = Arena.getArenas().get(0);
            if (a != null){
                e.setMaxPlayers(a.getMaxPlayers());
                e.setMotd(a.getDisplayStatus(Language.getDefaultLanguage()));
            }
        }
    }
}

