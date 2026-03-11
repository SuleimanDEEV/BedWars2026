package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup;

import com.suleimandev.bedwars2026.api.CommonsBedApi;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.server.SetupType;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.ArenaConfig;
import com.suleimandev.bedwars2026.configuration.Permissions;
import com.suleimandev.bedwars2026.configuration.Sounds;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.mainCmd;
import static com.suleimandev.bedwars2026.commands.Misc.createArmorStand;
import static com.suleimandev.bedwars2026.commands.Misc.removeArmorStand;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class SetKillDropsLoc extends SubCommand {


    public SetKillDropsLoc(ParentCommand parent, String name) {
        super(parent, name);
        setArenaSetupCommand(true);
        setPermission(Permissions.PERMISSION_SETUP_ARENA);
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        SetupSession ss = SetupSession.getSession(p.getUniqueId());
        if (ss == null) {
            //s.sendMessage(ss.getPrefix()"Ã‚Â§c Ã¢â€“Âª Ã‚Â§7You're not in a setup session!");
            return false;
        }
        ArenaConfig arena = ss.getConfig();
        if (args.length < 1) {
            String foundTeam = "";
            double distance = 100;
            if (ss.getConfig().getYml().getConfigurationSection("Team") == null) {
                p.sendMessage(ss.getPrefix() + "Please create teams first!");
                com.suleimandev.bedwars2026.BukkitBedPlugin.nms.sendTitle(p, " ", ChatColor.RED + "Please create teams first!", 5, 40, 5);
                Sounds.playSound(ConfigPath.SOUNDS_INSUFF_MONEY, p);
                return true;
            }
            for (String team : ss.getConfig().getYml().getConfigurationSection("Team").getKeys(false)) {
                if (ss.getConfig().getYml().get("Team." + team + ".Spawn") == null) continue;
                double dis = ss.getConfig().getArenaLoc("Team." + team + ".Spawn").distance(p.getLocation());
                if (dis <= ss.getConfig().getInt(ConfigPath.ARENA_ISLAND_RADIUS)) {
                    if (dis < distance) {
                        distance = dis;
                        foundTeam = team;
                    }
                }
            }
            if (!foundTeam.isEmpty()) {
                if (ss.getConfig().getYml().get("Team." + foundTeam + "." + ConfigPath.ARENA_TEAM_KILL_DROPS_LOC) != null) {
                    removeArmorStand("Kill drops", ss.getConfig().getArenaLoc("Team." + foundTeam + "." + ConfigPath.ARENA_TEAM_KILL_DROPS_LOC), null);
                }
                arena.set("Team." + foundTeam + "." + ConfigPath.ARENA_TEAM_KILL_DROPS_LOC, arena.stringLocationArenaFormat(p.getLocation()));
                String team = ss.getTeamColor(foundTeam) + foundTeam;
                p.sendMessage(ss.getPrefix() + "Kill drops set for team: " + team);
                createArmorStand(ChatColor.GOLD + "Kill drops " + team, p.getLocation(), null);
                com.suleimandev.bedwars2026.BukkitBedPlugin.nms.sendTitle(p, " ", ChatColor.GREEN + "Kill drops set for team: " + team, 5, 40, 5);
                Sounds.playSound(ConfigPath.SOUNDS_BOUGHT, p);

                if (ss.getSetupType() == SetupType.ASSISTED) {
                    Bukkit.dispatchCommand(p, getParent().getName());
                }
                return true;
            }

            p.sendMessage(ss.getPrefix() + ChatColor.RED + "Usage: /" + mainCmd + " setKillDrops <teamName>");
            return true;
        }

        String foundTeam = ss.getNearestTeam();

        if (foundTeam.isEmpty()) {
            p.sendMessage("");
            p.sendMessage(ss.getPrefix() + ChatColor.RED + "Could not find any nearby team.");
            p.spigot().sendMessage(Misc.msgHoverClick(ss.getPrefix() + "Make sure you set the team's spawn first!", ChatColor.WHITE + "Set a team spawn.", "/" + getParent().getName() + " " + getSubCommandName() + " ", ClickEvent.Action.SUGGEST_COMMAND));
            p.spigot().sendMessage(Misc.msgHoverClick(ss.getPrefix() + "Or if you set the spawn and it wasn't found automatically try using: /bw " + getSubCommandName() + " <team>", "Set kill drops location for a team.", "/" + getParent().getName() + " " + getSubCommandName() + " ", ClickEvent.Action.SUGGEST_COMMAND));
            com.suleimandev.bedwars2026.BukkitBedPlugin.nms.sendTitle(p, " ", ChatColor.RED + "Could not find any nearby team.", 5, 60, 5);
            Sounds.playSound(ConfigPath.SOUNDS_INSUFF_MONEY, p);
            return true;
        }

        if (args.length == 1) {
            if (arena.getYml().get("Team." + args[0]) != null) {
                foundTeam = args[0];
            } else {
                p.sendMessage(ss.getPrefix() + ChatColor.RED + "This team doesn't exist!");
                if (arena.getYml().get("Team") != null) {
                    p.sendMessage(ss.getPrefix() + "Available teams: ");
                    for (String team : Objects.requireNonNull(arena.getYml().getConfigurationSection("Team")).getKeys(false)) {
                        p.spigot().sendMessage(Misc.msgHoverClick(ChatColor.GOLD + " " + '*' + " " + "Kill drops " + ss.getTeamColor(team) + team + " " + ChatColor.getLastColors(ss.getPrefix()) + "(click to set)", ChatColor.WHITE + "Set Kill drops for " + ss.getTeamColor(team) + team, "/" + mainCmd + " setKillDrops " + team, ClickEvent.Action.RUN_COMMAND));
                    }
                }
                return true;
            }
        }

        arena.set("Team." + foundTeam + "." + ConfigPath.ARENA_TEAM_KILL_DROPS_LOC, arena.stringLocationArenaFormat(p.getLocation()));
        p.sendMessage(ss.getPrefix() + "Kill drops set for: " + ss.getTeamColor(foundTeam) + foundTeam);

        if (ss.getSetupType() == SetupType.ASSISTED) {
            Bukkit.dispatchCommand(p, getParent().getName());
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return new ArrayList<>();
    }

    @Override
    public boolean canSee(CommandSender s, CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (!SetupSession.isInSetupSession(p.getUniqueId())) return false;

        return hasPermission(s);
    }
}

