package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import static com.suleimandev.bedwars2026.support.version.common.VersionCommon.api;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

@SuppressWarnings("deprecation")
public class Interact_1_13Plus implements Listener {

    @EventHandler
    //Check if player is opening an inventory
    public void onInventoryInteract(PlayerInteractEvent e) {
        //noinspection deprecation
        if (e.isCancelled()) return;
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block b = e.getClickedBlock();
        if (b == null) return;
        if (b.getWorld().getName().equals(api.getLobbyWorld()) || api.getArenaUtil().getArenaByPlayer(e.getPlayer()) != null) {
            switch (b.getType().toString()) {
                case "CHIPPED_ANVIL":
                case "DAMAGED_ANVIL":
                    if (api.getConfigs().getMainConfig().getBoolean(ConfigPath.GENERAL_CONFIGURATION_DISABLE_ANVIL)) {
                        e.setCancelled(true);
                    } else {
                        if (api.getArenaUtil().isSpectating(e.getPlayer())) e.setCancelled(true);
                    }
                    break;
            }
        }
    }
}

