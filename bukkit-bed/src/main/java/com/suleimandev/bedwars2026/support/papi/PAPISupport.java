package com.suleimandev.bedwars2026.support.papi;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.GameState;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.commands.shout.ShoutCommand;
import com.suleimandev.bedwars2026.stats.PlayerStats;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
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

public class PAPISupport extends PlaceholderExpansion {

    @NotNull
    @Override
    public String getIdentifier() {
        return "bw2026";
    }

    @NotNull
    @Override
    public String getAuthor() {
        return "SuleimanDEV";
    }

    @NotNull
    @Override
    public String getVersion() {
        return BukkitBedPlugin.plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String s) {

        /* Non-Player required placeholders */

        if (s.startsWith("arena_status_")) {
            IArena a = Arena.getArenaByName(s.replace("arena_status_", ""));
            if (a == null) {
                return player == null ? Language.getDefaultLanguage().m(Messages.ARENA_STATUS_RESTARTING_NAME) :
                        Language.getMsg(player, Messages.ARENA_STATUS_RESTARTING_NAME);
            }
            return a.getDisplayStatus(Language.getDefaultLanguage());
        }

        if (s.startsWith("arena_count_")) {
            int players = 0;

            String[] arenas = s.replace("arena_count_", "").split("\\+");
            IArena a;
            for (String arena : arenas) {
                a = Arena.getArenaByName(arena);
                if (a != null) {
                    players += a.getPlayers().size();
                }
            }

            return String.valueOf(players);
        }

        if (s.startsWith("group_count_")) {
            return String.valueOf(Arena.getPlayers(s.replace("group_count_", "")));
        }

        if (s.startsWith("arena_group_")) {
            String a = s.replace("arena_group_", "");
            IArena arena = Arena.getArenaByName(a);
            if (arena != null) {
                return arena.getGroup();
            }
            return "-";
        }

        /* Player required placeholders */
        if (player == null) return null;

        // stats placeholders
        if(s.startsWith("stats_")) {
            String targetedStat = s.replaceFirst("stats_", "");
            if(targetedStat.trim().isEmpty()) {
                return null;
            }
            PlayerStats stats = BukkitBedPlugin.getStatsManager().getUnsafe(player.getUniqueId());
            if(stats == null) {
                return null;
            }
            switch (targetedStat) {
                case "firstplay":
                    Instant firstPlay = stats.getFirstPlay();
                    return new SimpleDateFormat(getMsg(player, Messages.FORMATTING_STATS_DATE_FORMAT)).format(firstPlay != null ? Timestamp.from(firstPlay) : null);
                case "lastplay":
                    Instant lastPlay = stats.getLastPlay();
                    return new SimpleDateFormat(getMsg(player, Messages.FORMATTING_STATS_DATE_FORMAT)).format(lastPlay != null ? Timestamp.from(lastPlay) : null);
                case "total_kills":
                    return String.valueOf(stats.getTotalKills());
                case "kills":
                    return String.valueOf(stats.getKills());
                case "wins":
                    return String.valueOf(stats.getWins());
                case "finalkills":
                    return String.valueOf(stats.getFinalKills());
                case "deaths":
                    return String.valueOf(stats.getDeaths());
                case "losses":
                    return String.valueOf(stats.getLosses());
                case "finaldeaths":
                    return String.valueOf(stats.getFinalDeaths());
                case "bedsdestroyed":
                    return String.valueOf(stats.getBedsDestroyed());
                case "gamesplayed":
                    return String.valueOf(stats.getGamesPlayed());
            }
        }

        // other placeholders
        String response = "";
        IArena a = Arena.getArenaByPlayer(player);
        switch (s) {
            case "current_online":
                response = String.valueOf(Arena.getArenaByPlayer().size());
                break;
            case "current_arenas":
                response = String.valueOf(Arena.getArenas().size());
                break;
            case "current_playing":
                if (a != null) {
                    response = String.valueOf(a.getPlayers().size());
                }
                break;
            case "player_team_color":
                if (a != null && a.isPlayer(player) && a.getStatus() == GameState.playing) {
                    ITeam team = a.getTeam(player);
                    if (team != null) {
                        response += String.valueOf(team.getColor().chat());
                    }
                }
                break;
            case "player_team":
                if (a != null) {
                    if (ShoutCommand.isShout(player)) {
                        response += Language.getMsg(player, Messages.FORMAT_PAPI_PLAYER_TEAM_SHOUT);
                    }
                    if (a.isPlayer(player)) {
                        if (a.getStatus() == GameState.playing) {
                            ITeam bwt = a.getTeam(player);
                            if (bwt != null) {
                                response += Language.getMsg(player, Messages.FORMAT_PAPI_PLAYER_TEAM_TEAM).replace("{TeamName}",
                                        bwt.getDisplayName(Language.getPlayerLanguage(player))).replace("{TeamColor}", String.valueOf(bwt.getColor().chat()));
                            }
                        }
                    } else {
                        response += Language.getMsg(player, Messages.FORMAT_PAPI_PLAYER_TEAM_SPECTATOR);
                    }
                }
                break;
            case "player_level":
                response = BukkitBedPlugin.getLevelSupport().getLevel(player);
                break;
            case "player_level_raw":
                response = String.valueOf(BukkitBedPlugin.getLevelSupport().getPlayerLevel(player));
                break;
            case "player_progress":
                response = BukkitBedPlugin.getLevelSupport().getProgressBar(player);
                break;
            case "player_xp_formatted":
                response = BukkitBedPlugin.getLevelSupport().getCurrentXpFormatted(player);
                break;
            case "player_xp":
                response = String.valueOf(BukkitBedPlugin.getLevelSupport().getCurrentXp(player));
                break;
            case "player_rerq_xp_formatted":
                response = BukkitBedPlugin.getLevelSupport().getRequiredXpFormatted(player);
                break;
            case "player_rerq_xp":
                response = String.valueOf(BukkitBedPlugin.getLevelSupport().getRequiredXp(player));
                break;
            case "player_status":
                if(a != null) {
                    switch (a.getStatus()) {
                        case waiting:
                        case starting:
                            response = "WAITING";
                            break;
                        case playing:
                            if(a.isPlayer(player)) {
                                response = "PLAYING";
                            } else if(a.isSpectator(player)) {
                                response = "SPECTATING";
                            } else {
                                response = "IN_GAME_BUT_NOT"; // this shouldnt happen
                            }
                            break;
                        case restarting:
                            response = "RESTARTING";
                            break;
                    }
                } else {
                    response = "NONE";
                }
                break;
            case "current_arena_group":
                if (a != null) {
                    response = a.getGroup();
                }
                break;
            case "elapsed_time":
                if (a != null) {
                    Instant startTime = a.getStartTime();
                    if (null != startTime){
                        Duration time = Duration.ofMillis(Instant.now().minusMillis(startTime.toEpochMilli()).toEpochMilli());
                        long totalSeconds = time.getSeconds();
                        long hours = totalSeconds / 3600;
                        long minutes = (totalSeconds % 3600) / 60;
                        long seconds = totalSeconds % 60;
                        if (time.toHours() == 0){
                            response = String.format("%02d:%02d", totalSeconds / 60, seconds);
                        } else {
                            response = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                        }
                    } else response = "";
                }
                break;
        }
        return response;
    }
}

