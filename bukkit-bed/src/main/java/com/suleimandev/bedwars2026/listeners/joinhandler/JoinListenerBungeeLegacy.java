package com.suleimandev.bedwars2026.listeners.joinhandler;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.ReJoin;
import com.suleimandev.bedwars2026.configuration.Permissions;
import com.suleimandev.bedwars2026.configuration.Sounds;
import com.suleimandev.bedwars2026.vip.service.VipReservedSlotPolicy;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.mainCmd;
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

public class JoinListenerBungeeLegacy implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onLogin(PlayerLoginEvent e) {
        final Player p = e.getPlayer();

        // Do not allow login if the arena wasn't loaded yet
        if (Arena.getArenas().isEmpty()) {
            if (!Arena.getEnableQueue().isEmpty()) {
                e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, getMsg(e.getPlayer(), Messages.ARENA_STATUS_RESTARTING_NAME));
                return;
            }
        }

        // Check if there is an arena to rejoin
        ReJoin reJoin = ReJoin.getPlayer(p);
        if (reJoin != null) {
            // If is not allowed to rejoin
            if (!(p.hasPermission(Permissions.PERMISSION_REJOIN) || reJoin.canReJoin())) {
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, Language.getDefaultLanguage().m(Messages.REJOIN_DENIED));
                reJoin.destroy(true);
            }
            // Stop here, rejoin handled. More will be handled at PlayerJoinEvent
            return;
        }

        IArena arena = Arena.getArenas().get(0);
        if (arena != null) {

            // Player logic
            if (arena.getStatus() == GameState.waiting || (arena.getStatus() == GameState.starting && arena.getStartingTask().getCountdown() > 1)) {
                // If arena is full
                if (arena.getPlayers().size() >= arena.getMaxPlayers()) {
                    VipReservedSlotPolicy.Result reservation = BukkitBedPlugin.vipFeatures.reserveSlots((Arena) arena, p, 1);
                    if (!reservation.isAllowed()) {
                        if (BukkitBedPlugin.vipFeatures.isVip(p)) {
                            e.disallow(PlayerLoginEvent.Result.KICK_FULL, BukkitBedPlugin.vipFeatures.getDenyMessage(reservation.getDenyReason()));
                        } else {
                            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, getMsg(e.getPlayer(), Messages.COMMAND_JOIN_DENIED_IS_FULL));
                        }
                    } else {
                        for (Player displaced : reservation.getDisplacedPlayers()) {
                            displaced.sendMessage(BukkitBedPlugin.vipFeatures.getKickedMessage());
                            BukkitBedPlugin.vipFeatures.playKickedSound(displaced);
                            displaced.kickPlayer(BukkitBedPlugin.vipFeatures.getKickedMessage());
                        }
                    }
                    if (!BukkitBedPlugin.vipFeatures.isVip(p) && arena.getPlayers().size() >= arena.getMaxPlayers()) {
                        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, getMsg(e.getPlayer(), Messages.COMMAND_JOIN_DENIED_IS_FULL));
                    }
                }
            } else if (arena.getStatus() == GameState.playing) {
                // Spectator logic
                if (!arena.isAllowSpectate()) {
                    e.disallow(PlayerLoginEvent.Result.KICK_OTHER, Language.getDefaultLanguage().m(Messages.COMMAND_JOIN_SPECTATOR_DENIED_MSG));
                }
            } else {
                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, Language.getDefaultLanguage().m(Messages.ARENA_STATUS_RESTARTING_NAME));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        final Player p = e.getPlayer();

        // Do not allow login if the arena wasn't loaded yet
        // I know this code is already in the login event but other plugins may allow login
        if (Arena.getArenas().isEmpty()) {
            if (!Arena.getEnableQueue().isEmpty()) {
                p.kickPlayer(getMsg(e.getPlayer(), Messages.ARENA_STATUS_RESTARTING_NAME));
                return;
            }
        }

        JoinHandlerCommon.displayCustomerDetails(p);

        if (Arena.getArenas().isEmpty()) {
            // Show setup commands if there is no arena available
            if (p.hasPermission("bw.setup")) {
                p.performCommand(mainCmd);
            }
        } else {
            IArena arena = Arena.getArenas().get(0);
            // Add player if the game is in waiting
            if (arena.getStatus() == GameState.waiting || arena.getStatus() == GameState.starting) {
                if (arena.addPlayer(p, false)) {
                    Sounds.playSound("join-allowed", p);
                } else {
                    p.kickPlayer(getMsg(p, Messages.COMMAND_JOIN_DENIED_IS_FULL));
                }
            } else {
                // Check ReJoin
                ReJoin reJoin = ReJoin.getPlayer(p);
                if (reJoin != null) {
                    if (reJoin.canReJoin()) {
                        reJoin.reJoin(p);
                        reJoin.destroy(false);
                        return;
                    } else {
                        p.sendMessage(getMsg(p, Messages.REJOIN_DENIED));
                        reJoin.destroy(true);
                    }
                }

                // Add spectator
                if (arena.addSpectator(p, false, null)) {
                    Sounds.playSound("spectate-allowed", p);
                } else {
                    p.kickPlayer(getMsg(p, Messages.COMMAND_JOIN_SPECTATOR_DENIED_MSG));
                }
            }
        }
    }
}

