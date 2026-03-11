package com.suleimandev.bedwars2026.shop.main;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.shop.IBuyItem;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.language.Language;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
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

public class BuyCommand implements IBuyItem {

    private final List<String> asPlayer = new ArrayList<>();
    private final List<String> asConsole = new ArrayList<>();
    private final String upgradeIdentifier;


    public BuyCommand(String path, YamlConfiguration yml, String upgradeIdentifier) {
        BukkitBedPlugin.debug("Loading BuyCommand: " + path);
        this.upgradeIdentifier = upgradeIdentifier;
        for (String cmd : yml.getStringList(path + ".as-console")) {
            if (cmd.startsWith("/")) {
                cmd = cmd.replaceFirst("/", "");
            }
            asConsole.add(cmd);
        }
        for (String cmd : yml.getStringList(path + ".as-player")) {
            if (!cmd.startsWith("/")) {
                cmd = "/" + cmd;
            }
            asPlayer.add(cmd);
        }
    }

    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public void give(Player player, IArena arena) {
        BukkitBedPlugin.debug("Giving BuyCMD: " + getUpgradeIdentifier() + " to: " + player.getName());
        String playerName = player.getName();
        String playerUUID = player.getUniqueId().toString();
        ITeam team = arena.getTeam(player);
        String teamName = team == null ? "null" : team.getName();
        String teamDisplay = team == null ? "null" : team.getDisplayName(Language.getPlayerLanguage(player));
        String teamColor = team == null ? ChatColor.WHITE.toString() : team.getColor().chat().toString();
        String arenaIdentifier = arena.getArenaName();
        String arenaWorld = arena.getWorldName();
        String arenaDisplay = arena.getDisplayName();
        String arenaGroup = arena.getGroup();
        for (String playerCmd : asPlayer) {
            player.chat(playerCmd.replace("{player}", playerName)
                    .replace("{player_uuid}", playerUUID)
                    .replace("{team}", teamName).replace("{team_display}", teamDisplay)
                    .replace("{team_color}", teamColor).replace("{arena}", arenaIdentifier)
                    .replace("{arena_world}", arenaWorld).replace("{arena_display}", arenaDisplay)
                    .replace("{arena_group}", arenaGroup));
        }
        for (String consoleCmd : asConsole) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), consoleCmd
                    .replace("{player}", playerName).replace("{player_uuid}", playerUUID)
                    .replace("{team}", teamName).replace("{team_display}", teamDisplay)
                    .replace("{team_color}", teamColor).replace("{arena}", arenaIdentifier)
                    .replace("{arena_world}", arenaWorld).replace("{arena_display}", arenaDisplay)
                    .replace("{arena_group}", arenaGroup));
        }
    }

    @Override
    public String getUpgradeIdentifier() {
        return upgradeIdentifier;
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }

    @Override
    public void setItemStack(ItemStack itemStack) {

    }

    @Override
    public boolean isAutoEquip() {
        return false;
    }

    @Override
    public void setAutoEquip(boolean autoEquip) {

    }

    @Override
    public boolean isPermanent() {
        return false;
    }

    @Override
    public void setPermanent(boolean permanent) {

    }

    @Override
    public boolean isUnbreakable() {
        return false;
    }

    @Override
    public void setUnbreakable(boolean unbreakable) {
    }
}

