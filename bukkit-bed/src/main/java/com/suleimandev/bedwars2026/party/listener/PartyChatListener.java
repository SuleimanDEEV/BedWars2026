package com.suleimandev.bedwars2026.party.listener;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.party.service.BedWarsPartyService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.jetbrains.annotations.NotNull;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class PartyChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onChat(@NotNull AsyncPlayerChatEvent event) {
        if (!(BukkitBedPlugin.getParty() instanceof BedWarsPartyService)) {
            return;
        }
        BedWarsPartyService partyService = (BedWarsPartyService) BukkitBedPlugin.getParty();
        if (!partyService.isPartyChatEnabled(event.getPlayer())) {
            return;
        }
        event.setCancelled(true);
        partyService.sendPartyChat(event.getPlayer(), event.getMessage());
    }
}

