package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.events.player.PlayerXpGainEvent;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.LevelsConfig;
import com.suleimandev.bedwars2026.configuration.Permissions;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.List;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class Level extends SubCommand {

    public Level(ParentCommand parent, String name) {
        super(parent, name);
        setPermission(Permissions.PERMISSION_LEVEL);
        setPriority(10);
        showInList(true);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName() + " Â§8      - Â§eclick for details", "Â§fManage a player level.",
                "/" + getParent().getName() + " " + getSubCommandName(), ClickEvent.Action.RUN_COMMAND));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (args.length == 0) {
            sendSubCommands(s, BukkitBedPlugin.getAPI());
            return true;
        }
        if (args[0].equalsIgnoreCase("setlevel")) {
            if (args.length != 3) {
                s.sendMessage(ChatColor.GOLD + " â–ª " + ChatColor.GRAY + "Usage: /bw level setLevel Â§o<player> <level>");
                return true;
            }
            Player pl = Bukkit.getPlayer(args[1]);
            if (pl == null) {
                s.sendMessage(ChatColor.RED + " â–ª " + ChatColor.GRAY + "Player not found!");
                return true;
            }

            int level;

            try {
                level = Integer.parseInt(args[2]);
            } catch (Exception e) {
                s.sendMessage(ChatColor.RED + "Level must be an integer!");
                return true;
            }

            BukkitBedPlugin.getAPI().getLevelsUtil().setLevel(pl, level);

            int nextLevelCost =  LevelsConfig.levels.getYml().get("levels." + level + ".rankup-cost") == null ?
                    LevelsConfig.levels.getInt("levels.others.rankup-cost") : LevelsConfig.levels.getInt("levels." + level + ".rankup-cost");

            String levelName = LevelsConfig.levels.getYml().get("levels." + level + ".name") == null ?
                    LevelsConfig.levels.getYml().getString("levels.others.name") : LevelsConfig.levels.getYml().getString("levels." + level + ".name");


            BukkitBedPlugin.plugin.getServer().getScheduler().runTaskAsynchronously(BukkitBedPlugin.plugin, () -> {
                BukkitBedPlugin.getRemoteDatabase().setLevelData(pl.getUniqueId(), level, 0, levelName, nextLevelCost);
                s.sendMessage(ChatColor.GOLD + " â–ª " + ChatColor.GRAY + pl.getName() + " level was set to: " + args[2]);
                s.sendMessage(ChatColor.GOLD + " â–ª " + ChatColor.GRAY + "The player may need to rejoin to see it updated.");
            });
        } else if (args[0].equalsIgnoreCase("givexp")) {
            if (args.length != 3) {
                s.sendMessage(ChatColor.GOLD + " â–ª " + ChatColor.GRAY + "Usage: /bw level giveXp Â§o<player> <amount>");
                return true;
            }
            Player pl = Bukkit.getPlayer(args[1]);
            if (pl == null) {
                s.sendMessage(ChatColor.RED + " â–ª " + ChatColor.GRAY + "Player not found!");
                return true;
            }

            int amount;

            try {
                amount = Integer.parseInt(args[2]);
            } catch (Exception e) {
                s.sendMessage(ChatColor.RED + "Amount must be an integer!");
                return true;
            }

            BukkitBedPlugin.getAPI().getLevelsUtil().addXp(pl, amount, PlayerXpGainEvent.XpSource.OTHER);

            BukkitBedPlugin.plugin.getServer().getScheduler().runTaskAsynchronously(BukkitBedPlugin.plugin, () -> {
                Object[] data = BukkitBedPlugin.getRemoteDatabase().getLevelData(pl.getUniqueId());
                BukkitBedPlugin.getRemoteDatabase().setLevelData(pl.getUniqueId(), (Integer) data[0], ((Integer)data[1]) + amount, (String) data[2], (Integer)data[3]);
                s.sendMessage(ChatColor.GOLD + " â–ª " + ChatColor.GRAY + args[2] + " xp was given to: " + pl.getName());
                s.sendMessage(ChatColor.GOLD + " â–ª " + ChatColor.GRAY + "The player may need to rejoin to see it updated.");
            });
        } else {
            sendSubCommands(s, BukkitBedPlugin.getAPI());
        }
        return true;
    }

    private void sendSubCommands(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof Player) {
            Player p = (Player) s;
            p.spigot().sendMessage(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName() + " setLevel Â§o<player> <level>",
                    "Set a player level.", "/" + getParent().getName() + " " + getSubCommandName() + " setLevel",
                    ClickEvent.Action.SUGGEST_COMMAND));
            p.spigot().sendMessage(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName() + " giveXp Â§o<player> <amount>",
                    "Give Xp to a player.", "/" + getParent().getName() + " " + getSubCommandName() + " giveXp",
                    ClickEvent.Action.SUGGEST_COMMAND));
        } else {
            s.sendMessage(ChatColor.GOLD + "bw level setLevel <player> <level>");
            s.sendMessage(ChatColor.GOLD + "bw level giveXp <player> <amount>");
        }
    }

    @Override
    public List<String> getTabComplete() {
        return null;
    }

    @Override
    public boolean canSee(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (Arena.isInArena(p)) return false;

        if (SetupSession.isInSetupSession(p.getUniqueId())) return false;
        return hasPermission(s);
    }
}

