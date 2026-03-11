package com.suleimandev.bedwars2026.support.preloadedparty;

import com.suleimandev.bedwars2026.api.events.server.ArenaDisableEvent;
import com.suleimandev.bedwars2026.api.events.server.ArenaRestartEvent;
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

@Deprecated
public class PrePartyListener implements Listener {

    @EventHandler
    public void onDisable(ArenaDisableEvent e){
        PreLoadedParty plp = PreLoadedParty.getPartyByOwner(e.getWorldName());
        if (plp != null){
            //todo what was I doing here lmao. no sense
            PreLoadedParty.getPreLoadedParties().remove(plp);
        }
    }

    @EventHandler
    public void onRestart(ArenaRestartEvent e){
        PreLoadedParty plp = PreLoadedParty.getPartyByOwner(e.getWorldName());
        if (plp != null){
            //todo what was I doing here lmao. no sense
            PreLoadedParty.getPreLoadedParties().remove(plp);
        }
    }
}

