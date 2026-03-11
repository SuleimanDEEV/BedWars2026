package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.server.SetupType;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
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

public class SetBed extends SubCommand {

    public SetBed(ParentCommand parent, String name) {
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
        if (args.length == 0) {
            String foundTeam = ss.getNearestTeam();
            if (foundTeam.isEmpty()) {
                p.sendMessage("");
                p.sendMessage(ss.getPrefix() + ChatColor.RED + "Could not find any nearby team.");
                p.spigot().sendMessage(Misc.msgHoverClick(ss.getPrefix() + "Make sure you set the team's spawn first!", ChatColor.WHITE + "Set a team bed.", "/" + getParent().getName() + " " + getSubCommandName() + " ", ClickEvent.Action.SUGGEST_COMMAND));
                p.spigot().sendMessage(Misc.msgHoverClick(ss.getPrefix() + "Or if you set the spawn and it wasn't found automatically try using: /bw " + getSubCommandName() + " <team>", "Add a team bed.", "/" + getParent().getName() + " " + getSubCommandName() + " ", ClickEvent.Action.SUGGEST_COMMAND));
                BukkitBedPlugin.nms.sendTitle(p, " ", ChatColor.RED + "Could not find any nearby team.", 5, 60, 5);
                Sounds.playSound(ConfigPath.SOUNDS_INSUFF_MONEY, p);
                ss.displayAvailableTeams();

            } else {
                Bukkit.dispatchCommand(s, getParent().getName() + " " + getSubCommandName() + " " + foundTeam);
            }
        } else {
            if (!(BukkitBedPlugin.nms.isBed(p.getLocation().clone().add(0, -0.5, 0).getBlock().getType()) || BukkitBedPlugin.nms.isBed(p.getLocation().clone().add(0, 0.5, 0).getBlock().getType())
                    || BukkitBedPlugin.nms.isBed(p.getLocation().clone().getBlock().getType()))) {
                p.sendMessage(ss.getPrefix() + ChatColor.RED + "You must stay on a bed while using this command!");
                BukkitBedPlugin.nms.sendTitle(p, " ", ChatColor.RED + "You must stay on a bed.", 5, 40, 5);
                Sounds.playSound(ConfigPath.SOUNDS_INSUFF_MONEY, p);
                return true;
            }
            if (ss.getConfig().getYml().get("Team." + args[0]) == null) {
                p.sendMessage(ss.getPrefix() + ChatColor.RED + "This team doesn't exist!");
                if (ss.getConfig().getYml().get("Team") != null) {
                    p.sendMessage(ss.getPrefix() + "Available teams: ");
                    for (String team : Objects.requireNonNull(ss.getConfig().getYml().getConfigurationSection("Team")).getKeys(false)) {
                        p.spigot().sendMessage(Misc.msgHoverClick(ChatColor.GOLD + " " + '*' + " " + ss.getTeamColor(team) + team, ChatColor.WHITE + "Set bed for " + ss.getTeamColor(team) + team, "/" + mainCmd + " setBed " + team, ClickEvent.Action.RUN_COMMAND));
                    }
                }
            } else {
                String team = ss.getTeamColor(args[0]) + args[0];
                if (ss.getConfig().getYml().get("Team." + args[0] + ".Bed") != null) {
                    removeArmorStand("bed", ss.getConfig().getArenaLoc("Team." + args[0] + ".Bed"), null);
                }
                createArmorStand(team + " " + ChatColor.GOLD + "BED SET", p.getLocation().add(0.5, 0, 0.5), null);
                ss.getConfig().saveArenaLoc("Team." + args[0] + ".Bed", p.getLocation());
                p.sendMessage(ss.getPrefix() + "Bed set for: " + team);

                BukkitBedPlugin.nms.sendTitle(p, " ", ChatColor.GREEN + "Bed set for: " + team, 5, 40, 5);
                Sounds.playSound(ConfigPath.SOUNDS_BOUGHT, p);

                if (ss.getSetupType() == SetupType.ASSISTED) {
                    Bukkit.dispatchCommand(p, getParent().getName());
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

