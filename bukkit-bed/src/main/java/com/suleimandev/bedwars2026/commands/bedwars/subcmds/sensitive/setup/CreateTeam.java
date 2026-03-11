package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup;

import com.suleimandev.bedwars2026.api.CommonsBedApi;
import com.suleimandev.bedwars2026.api.arena.team.TeamColor;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.server.SetupType;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.List;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.mainCmd;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class CreateTeam extends SubCommand {

    public CreateTeam(ParentCommand parent, String name) {
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
            s.sendMessage("Â§c â–ª Â§7You're not in a setup session!");
            return true;
        }
        if (args.length < 2) {
            p.sendMessage("Â§câ–ª Â§7Usage: /" + mainCmd + " createTeam Â§o<name> Â§o<color>");
            StringBuilder colors = new StringBuilder("Â§7");
            for (TeamColor t : TeamColor.values()) {
                colors.append(t.chat()).append(t).append(ChatColor.GRAY).append(", ");
            }
            colors = new StringBuilder(colors.substring(0, colors.toString().length() - 2) + ChatColor.GRAY + ".");
            p.sendMessage("Â§6 â–ª Â§7Available colors: " + colors);
        } else {
            boolean y = true;
            for (TeamColor t : TeamColor.values()) {
                if (t.toString().equalsIgnoreCase(args[1])) {
                    y = false;
                }
            }
            if (y) {
                p.sendMessage("Â§câ–ª Â§7Invalid color!");
                StringBuilder colors = new StringBuilder("Â§7");
                for (TeamColor t : TeamColor.values()) {
                    colors.append(t.chat()).append(t).append(ChatColor.GRAY).append(", ");
                }
                colors = new StringBuilder(colors.substring(0, colors.toString().length() - 2) + ChatColor.GRAY + ".");
                p.sendMessage("Â§6 â–ª Â§7Available colors: " + colors);
            } else {
                if (ss.getConfig().getYml().get("Team." + args[0] + ".Color") != null) {
                    p.sendMessage("Â§câ–ª Â§7" + args[0] + " team already exists!");
                    return true;
                }
                ss.getConfig().set("Team." + args[0] + ".Color", args[1].toUpperCase());
                p.sendMessage("Â§6 â–ª Â§7" + TeamColor.getChatColor(args[1]) + args[0] + " Â§7created!");
                if (ss.getSetupType() == SetupType.ASSISTED) {
                    ss.getConfig().reload();
                    int teams = ss.getConfig().getYml().getConfigurationSection("Team").getKeys(false).size();
                    int max = 1;
                    if (teams == 4) {
                        max = 2;
                    }
                    ss.getConfig().set("maxInTeam", max);
                }
            }
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return null;
    }

    @Override
    public boolean canSee(CommandSender s, CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (!SetupSession.isInSetupSession(p.getUniqueId())) return false;

        return hasPermission(s);
    }
}

