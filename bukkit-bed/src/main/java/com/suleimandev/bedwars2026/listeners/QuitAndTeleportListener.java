package com.suleimandev.bedwars2026.listeners;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.server.ServerType;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.LastHit;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.arena.team.BedWarsTeam;
import com.suleimandev.bedwars2026.commands.bedwars.subcmds.regular.CmdStats;
import com.suleimandev.bedwars2026.sidebar.MatchSidebarService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import java.util.UUID;
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

public class QuitAndTeleportListener implements Listener {

    @EventHandler
    public void onLeave(@NotNull PlayerQuitEvent e) {
        Player p = e.getPlayer();
        // Remove from arena
        IArena a = Arena.getArenaByPlayer(p);
        if (a != null) {
            if (a.isPlayer(p)) {
                a.removePlayer(p, true);
            } else if (a.isSpectator(p)) {
                a.removeSpectator(p, true);
            }
        }

        //Save preferred language
        if (Language.getLangByPlayer().containsKey(p.getUniqueId())) {
            final UUID u = p.getUniqueId();
            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                String iso = Language.getLangByPlayer().get(p.getUniqueId()).getIso();
                if (Language.isLanguageExist(iso)) {
                    if (BukkitBedPlugin.config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_DISABLED_LANGUAGES).contains(iso))
                        iso = Language.getDefaultLanguage().getIso();
                    BukkitBedPlugin.getRemoteDatabase().setLanguage(u, iso);
                }
                Language.getLangByPlayer().remove(p.getUniqueId());
            });
        }

        if (getServerType() != ServerType.SHARED) {
            e.setQuitMessage(null);
        }
        // Manage internal parties
        if (getParty().isInternal()) {
            if (getParty().hasParty(p)) {
                getParty().removeFromParty(p);
            }
        }
        // Check if was doing a setup and remove the session
        SetupSession ss = SetupSession.getSession(p.getUniqueId());
        if (ss != null) {
            ss.cancel();
        }

        MatchSidebarService.getInstance().remove(e.getPlayer());

        BedWarsTeam.reSpawnInvulnerability.remove(e.getPlayer().getUniqueId());

        LastHit lh = LastHit.getLastHit(p);
        if (lh != null) {
            lh.remove();
        }

        CmdStats.getStatsCoolDown().remove(e.getPlayer().getUniqueId());
    }

    /**
     * Handle players teleported outside.
     */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onWorldChange(@NotNull PlayerChangedWorldEvent e) {

        // if player was teleported outside arena
        IArena arena = Arena.getArenaByPlayer(e.getPlayer());

        if (null == arena) {
            return;
        }

        if (e.getPlayer().getWorld().getName().equals(arena.getWorldName())) {
            return;
        }

        if (arena.isPlayer(e.getPlayer())) {
            // it will teleport you to the lobby world or cached location
            arena.removePlayer(e.getPlayer(), false);
        }

        if (arena.isSpectator(e.getPlayer())) {
            // it will teleport you to the lobby world or cached location
            arena.removeSpectator(e.getPlayer(), false);
        }
    }
}

