package com.suleimandev.bedwars2026.vip.config;

import com.suleimandev.bedwars2026.api.configuration.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
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

public class VipFeaturesConfig extends ConfigManager {

    public VipFeaturesConfig(@NotNull Plugin plugin) {
        super(plugin, "vip-features", plugin.getDataFolder().getPath());

        YamlConfiguration yml = getYml();
        yml.options().header("BEDWARS 2026 VIP settings\nDeveloper: SuleimanDEV");

        yml.addDefault("join-full-enabled", true);
        yml.addDefault("required-permission", "bw.vip.joinfull");
        yml.addDefault("kick-non-vip-on-full-starting-arena", true);
        yml.addDefault("exempt-permissions", Arrays.asList("bw.vip.bypasslimits", "bw.*"));
        yml.addDefault("priority-order", Arrays.asList("bw.vip.bypasslimits", "bw.vip.joinfull", "bw.vip"));
        yml.addDefault("party-priority-rules.enabled", true);
        yml.addDefault("party-priority-rules.required-permission", "bw.vip.partypriority");
        yml.addDefault("admin-log-enabled", false);

        yml.addDefault("messages.full-denied", "&8[&6VIP&8] &cThis arena is full.");
        yml.addDefault("messages.priority-denied", "&8[&6VIP&8] &cThis arena is already full of players with equal or higher priority.");
        yml.addDefault("messages.party-priority-denied", "&8[&6VIP&8] &cYour party does not have permission to use VIP priority as a group.");
        yml.addDefault("messages.kicked-player", "&8[&6VIP&8] &cYour slot was reserved for a higher priority player.");

        addDefaultSound(yml, "sounds.join-allowed", "UI_BUTTON_CLICK");
        addDefaultSound(yml, "sounds.join-denied", "ENTITY_VILLAGER_NO");
        addDefaultSound(yml, "sounds.kicked-player", "ENTITY_VILLAGER_NO");

        yml.options().copyDefaults(true);
        save();
    }

    public boolean isJoinFullEnabled() {
        return getBoolean("join-full-enabled");
    }

    public boolean isKickNonVipOnFullArenaEnabled() {
        return getBoolean("kick-non-vip-on-full-starting-arena");
    }

    public boolean isAdminLogEnabled() {
        return getBoolean("admin-log-enabled");
    }

    public boolean isPartyPriorityEnabled() {
        return getBoolean("party-priority-rules.enabled");
    }

    @NotNull
    public String getRequiredPermission() {
        return getString("required-permission");
    }

    @NotNull
    public String getPartyPriorityPermission() {
        return getString("party-priority-rules.required-permission");
    }

    @NotNull
    public List<String> getExemptPermissions() {
        return getYml().getStringList("exempt-permissions");
    }

    @NotNull
    public List<String> getPriorityOrder() {
        return getYml().getStringList("priority-order");
    }

    @NotNull
    public String message(@NotNull String path) {
        return ChatColor.translateAlternateColorCodes('&', getString("messages." + path));
    }

    public void playSound(@NotNull Player player, @NotNull String path) {
        String soundName = getString("sounds." + path + ".sound");
        if (soundName == null || soundName.equalsIgnoreCase("none")) {
            return;
        }
        try {
            Sound sound = Sound.valueOf(soundName);
            float volume = (float) getDouble("sounds." + path + ".volume");
            float pitch = (float) getDouble("sounds." + path + ".pitch");
            player.playSound(player.getLocation(), sound, volume, pitch);
        } catch (IllegalArgumentException ignored) {
        }
    }

    private void addDefaultSound(@NotNull YamlConfiguration yml, @NotNull String path, @NotNull String sound) {
        yml.addDefault(path + ".sound", sound);
        yml.addDefault(path + ".volume", 1.0D);
        yml.addDefault(path + ".pitch", 1.0D);
    }
}

