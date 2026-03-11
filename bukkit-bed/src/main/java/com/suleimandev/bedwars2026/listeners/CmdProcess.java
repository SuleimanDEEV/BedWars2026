package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.configuration.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import static com.suleimandev.bedwars2026.api.language.Language.getMsg;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class CmdProcess implements Listener {

    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent e) {

        Player p = e.getPlayer();

        if (e.getMessage().equals("/party sethome")){
            p.sendMessage(getMsg(p, Messages.COMMAND_NOT_ALLOWED_IN_GAME));
            e.setCancelled(true);
        }

        if (e.getMessage().equals("/party home")){
            p.sendMessage(getMsg(p, Messages.COMMAND_NOT_ALLOWED_IN_GAME));
            e.setCancelled(true);
        }

        if (p.hasPermission(Permissions.PERMISSION_COMMAND_BYPASS)) return;
        String[] cmd = e.getMessage().replaceFirst("/", "").split(" ");
        if (cmd.length == 0) return;
        if (Arena.isInArena(p)) {
            if (!BukkitBedPlugin.config.getList(ConfigPath.CENERAL_CONFIGURATION_ALLOWED_COMMANDS).contains(cmd[0])) {
                p.sendMessage(getMsg(p, Messages.COMMAND_NOT_ALLOWED_IN_GAME));
                e.setCancelled(true);
            }
        }
    }
}

