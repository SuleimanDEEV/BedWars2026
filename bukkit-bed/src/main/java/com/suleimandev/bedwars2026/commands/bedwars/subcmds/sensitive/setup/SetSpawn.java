package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.Permissions;
import com.suleimandev.bedwars2026.support.paper.TeleportManager;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.mainCmd;
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

public class SetSpawn extends SubCommand {

    public SetSpawn(ParentCommand parent, String name) {
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
            //s.sendMessage("Ã‚Â§c Ã¢â€“Âª Ã‚Â§7You're not in a setup session!");
            return false;
        }
        if (args.length < 1) {
            p.sendMessage(ss.getPrefix() + ChatColor.RED + "Usage: /" + mainCmd + " setSpawn <team>");
            if (ss.getConfig().getYml().get("Team") != null) {
                for (String team : Objects.requireNonNull(ss.getConfig().getYml().getConfigurationSection("Team")).getKeys(false)) {
                    if (ss.getConfig().getYml().get("Team." + team + ".Spawn") == null) {
                        p.spigot().sendMessage(Misc.msgHoverClick(ss.getPrefix() + "Set spawn for: " + ss.getTeamColor(team) + team + " " + ChatColor.getLastColors(ss.getPrefix()) + "(click to set)", ChatColor.WHITE + "Set spawn for " + ss.getTeamColor(team) + team, "/" + mainCmd + " setSpawn " + team, ClickEvent.Action.RUN_COMMAND));
                    }
                }
            }
        } else {
            if (ss.getConfig().getYml().get("Team." + args[0]) == null) {
                p.sendMessage(ss.getPrefix() + ChatColor.RED + "Could not find target team: " + ChatColor.RED + args[0]);
                if (ss.getConfig().getYml().get("Team") != null) {
                    p.sendMessage(ss.getPrefix() + "Teams list: ");
                    for (String team : Objects.requireNonNull(ss.getConfig().getYml().getConfigurationSection("Team")).getKeys(false)) {
                        p.spigot().sendMessage(Misc.msgHoverClick(ChatColor.GOLD + " " + '*' + " " + ss.getTeamColor(team) + team + " " + ChatColor.getLastColors(ss.getPrefix()) + "(click to set)", ChatColor.WHITE + "Set spawn for " + ss.getTeamColor(team) + team, "/" + mainCmd + " setSpawn " + team, ClickEvent.Action.RUN_COMMAND));
                    }
                }
            } else {
                if (ss.getConfig().getYml().get("Team." + args[0] + ".Spawn") != null) {
                    removeArmorStand("spawn", ss.getConfig().getArenaLoc("Team." + args[0] + ".Spawn"), ss.getConfig().getString("Team." + args[0] + ".Spawn"));
                }
                ss.getConfig().saveArenaLoc("Team." + args[0] + ".Spawn", p.getLocation());
                String teamm = ss.getTeamColor(args[0]) + args[0];
                p.sendMessage(ChatColor.GOLD + " " + '*' + " " + "Spawn set for: " + teamm);
                com.suleimandev.bedwars2026.commands.Misc.createArmorStand(teamm + " " + ChatColor.GOLD + "SPAWN SET", p.getLocation(), ss.getConfig().stringLocationArenaFormat(p.getLocation()));
                int radius = ss.getConfig().getInt(ConfigPath.ARENA_ISLAND_RADIUS);
                Location l = p.getLocation();
                for (int x = -radius; x < radius; x++) {
                    for (int y = -radius; y < radius; y++) {
                        for (int z = -radius; z < radius; z++) {
                            Block b = l.clone().add(x, y, z).getBlock();
                            if (BukkitBedPlugin.nms.isBed(b.getType())) {
                                TeleportManager.teleport(p, b.getLocation());
                                Bukkit.dispatchCommand(p, getParent().getName() + " setBed " + args[0]);
                                return true;
                            }
                        }
                    }
                }
                if (ss.getConfig().getYml().get("Team") != null) {
                    StringBuilder remainging = new StringBuilder();
                    for (String team : Objects.requireNonNull(ss.getConfig().getYml().getConfigurationSection("Team")).getKeys(false)) {
                        if (ss.getConfig().getYml().get("Team." + team + ".Spawn") == null) {
                            remainging.append(ss.getTeamColor(team)).append(team).append(" ");
                        }
                    }
                    if (remainging.toString().length() > 0) {
                        p.sendMessage(ss.getPrefix() + "Remaining: " + remainging.toString());
                    }
                }
            }
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return new ArrayList<>();
    }

    @Override
    public boolean canSee(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (!SetupSession.isInSetupSession(p.getUniqueId())) return false;

        return hasPermission(s);
    }
}

