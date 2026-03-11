package com.suleimandev.bedwars2026.configuration;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.NextEvent;
import com.suleimandev.bedwars2026.api.configuration.ConfigManager;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.util.List;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.plugin;
import static com.suleimandev.bedwars2026.api.configuration.ConfigPath.*;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class Sounds {

    private static final ConfigManager sounds = new ConfigManager(plugin, "sounds", plugin.getDataFolder().getPath());

    /**
     * Load sounds configuration
     */
    private Sounds() {
    }

    public static void init() {
        YamlConfiguration yml = sounds.getYml();

        addDefSound("game-end", BukkitBedPlugin.getForCurrentVersion("AMBIENCE_THUNDER", "ENTITY_LIGHTNING_THUNDER", "ITEM_TRIDENT_THUNDER"));
        addDefSound("rejoin-denied", BukkitBedPlugin.getForCurrentVersion("VILLAGER_NO", "ENTITY_VILLAGER_NO", "ENTITY_VILLAGER_NO"));
        addDefSound("rejoin-allowed", BukkitBedPlugin.getForCurrentVersion("SLIME_WALK", "ENTITY_SLIME_JUMP", "ENTITY_SLIME_JUMP"));
        addDefSound("spectate-denied", BukkitBedPlugin.getForCurrentVersion("VILLAGER_NO", "ENTITY_VILLAGER_NO", "ENTITY_VILLAGER_NO"));
        addDefSound("spectate-allowed", BukkitBedPlugin.getForCurrentVersion("SLIME_WALK", "ENTITY_SLIME_JUMP", "ENTITY_SLIME_JUMP"));
        addDefSound("join-denied", BukkitBedPlugin.getForCurrentVersion("VILLAGER_NO", "ENTITY_VILLAGER_NO", "ENTITY_VILLAGER_NO"));
        addDefSound("join-allowed", BukkitBedPlugin.getForCurrentVersion("SLIME_WALK", "ENTITY_SLIME_JUMP", "ENTITY_SLIME_JUMP"));
        addDefSound("spectator-gui-click", BukkitBedPlugin.getForCurrentVersion("SLIME_WALK", "ENTITY_SLIME_JUMP", "ENTITY_SLIME_JUMP"));
        addDefSound(SOUNDS_COUNTDOWN_TICK, BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound(SOUNDS_COUNTDOWN_TICK_X + "5", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound(SOUNDS_COUNTDOWN_TICK_X + "4", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound(SOUNDS_COUNTDOWN_TICK_X + "3", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound(SOUNDS_COUNTDOWN_TICK_X + "2", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound(SOUNDS_COUNTDOWN_TICK_X + "1", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound(SOUND_GAME_START, BukkitBedPlugin.getForCurrentVersion("SLIME_ATTACK", "BLOCK_SLIME_FALL", "BLOCK_SLIME_BLOCK_FALL"));

        addDefSound(SOUNDS_KILL, BukkitBedPlugin.getForCurrentVersion("ORB_PICKUP", "ENTITY_EXPERIENCE_ORB_PICKUP", "ENTITY_EXPERIENCE_ORB_PICKUP"));

        addDefSound(SOUNDS_BED_DESTROY, BukkitBedPlugin.getForCurrentVersion("ENDERDRAGON_GROWL", "ENTITY_ENDERDRAGON_GROWL", "ENTITY_ENDER_DRAGON_GROWL"));
        addDefSound(SOUNDS_BED_DESTROY_OWN, BukkitBedPlugin.getForCurrentVersion("WITHER_DEATH", "ENTITY_WITHER_DEATH", "ENTITY_WITHER_DEATH"));
        addDefSound(SOUNDS_INSUFF_MONEY, BukkitBedPlugin.getForCurrentVersion("VILLAGER_NO", "ENTITY_VILLAGER_NO", "ENTITY_VILLAGER_NO"));
        addDefSound(SOUNDS_BOUGHT, BukkitBedPlugin.getForCurrentVersion("VILLAGER_YES", "ENTITY_VILLAGER_YES", "ENTITY_VILLAGER_YES"));

        addDefSound(NextEvent.BEDS_DESTROY.getSoundPath(), BukkitBedPlugin.getForCurrentVersion("ENDERDRAGON_GROWL", "ENTITY_ENDERDRAGON_GROWL", "ENTITY_ENDER_DRAGON_GROWL"));
        addDefSound(NextEvent.DIAMOND_GENERATOR_TIER_II.getSoundPath(), BukkitBedPlugin.getForCurrentVersion("LEVEL_UP", "ENTITY_PLAYER_LEVELUP", "ENTITY_PLAYER_LEVELUP"));
        addDefSound(NextEvent.DIAMOND_GENERATOR_TIER_III.getSoundPath(), BukkitBedPlugin.getForCurrentVersion("LEVEL_UP", "ENTITY_PLAYER_LEVELUP", "ENTITY_PLAYER_LEVELUP"));
        addDefSound(NextEvent.EMERALD_GENERATOR_TIER_II.getSoundPath(), BukkitBedPlugin.getForCurrentVersion("GHAST_MOAN", "ENTITY_GHAST_WARN", "ENTITY_GHAST_WARN"));
        addDefSound(NextEvent.EMERALD_GENERATOR_TIER_III.getSoundPath(), BukkitBedPlugin.getForCurrentVersion("GHAST_MOAN", "ENTITY_GHAST_WARN", "ENTITY_GHAST_WARN"));
        addDefSound(NextEvent.ENDER_DRAGON.getSoundPath(), BukkitBedPlugin.getForCurrentVersion("ENDERDRAGON_WINGS", "ENTITY_ENDERDRAGON_FLAP", "ENTITY_ENDER_DRAGON_FLAP"));

        addDefSound("player-re-spawn", BukkitBedPlugin.getForCurrentVersion("SLIME_ATTACK", "BLOCK_SLIME_FALL", "BLOCK_SLIME_BLOCK_FALL"));
        addDefSound("arena-selector-open", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound("stats-gui-open", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound("trap-sound", BukkitBedPlugin.getForCurrentVersion("ENDERMAN_TELEPORT", "ENDERMAN_TELEPORT", "ENTITY_ENDERMAN_TELEPORT"));
        addDefSound("shop-auto-equip", BukkitBedPlugin.getForCurrentVersion("HORSE_ARMOR", "ITEM_ARMOR_EQUIP_GENERIC", "ITEM_ARMOR_EQUIP_GENERIC"));
        addDefSound("egg-bridge-block", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG", "ENTITY_CHICKEN_EGG"));
        addDefSound("ender-pearl-landed", BukkitBedPlugin.getForCurrentVersion("ENDERMAN_TELEPORT", "ENTITY_ENDERMEN_TELEPORT", "ENTITY_ENDERMAN_TELEPORT"));
        addDefSound("pop-up-tower-build", BukkitBedPlugin.getForCurrentVersion("CHICKEN_EGG_POP", "ENTITY_CHICKEN_EGG","ENTITY_CHICKEN_EGG"));
        yml.options().copyDefaults(true);

        // remove old paths
        yml.set("bought", null);
        yml.set("insufficient-money", null);
        yml.set("player-kill", null);
        yml.set("countdown", null);
        sounds.save();
    }

    private static Sound getSound(String path) {
        try {
            return Sound.valueOf(sounds.getString(path + ".sound"));
        } catch (Exception ex) {
            return Sound.valueOf(BukkitBedPlugin.getForCurrentVersion("AMBIENCE_THUNDER", "ENTITY_LIGHTNING_THUNDER", "ITEM_TRIDENT_THUNDER"));
        }
    }

    public static void playSound(String path, List<Player> players) {
        if(path.equalsIgnoreCase("none")) return;
        final Sound sound = getSound(path);
        int volume = getSounds().getInt(path + ".volume");
        int pitch = getSounds().getInt(path + ".pitch");
        if (sound != null) {
            players.forEach(p -> p.playSound(p.getLocation(), sound, volume, pitch));
        }
    }

    /**
     * @return true if sound is valid and it was played.
     */
    public static boolean playSound(Sound sound, List<Player> players) {
        if (sound == null) return false;
        players.forEach(p -> p.playSound(p.getLocation(), sound, 1f, 1f));
        return true;
    }

    public static void playSound(String path, Player player) {
        final Sound sound = getSound(path);
        float volume = (float) getSounds().getYml().getDouble(path + ".volume");
        float pitch = (float) getSounds().getYml().getDouble(path + ".pitch");
        if (sound != null) player.playSound(player.getLocation(), sound, volume, pitch);
    }

    public static ConfigManager getSounds() {
        return sounds;
    }

    private static void addDefSound(String path, String value) {
        // convert old paths
        if (getSounds().getYml().get(path) != null && getSounds().getYml().get(path + ".volume") == null) {
            String temp = getSounds().getYml().getString(path);
            getSounds().getYml().set(path, null);
            getSounds().getYml().set(path + ".sound", temp);
        }
        getSounds().getYml().addDefault(path + ".sound", value);
        getSounds().getYml().addDefault(path + ".volume", 1);
        getSounds().getYml().addDefault(path + ".pitch", 1);
    }

    public static  void playsoundArea(String path, Location location, float x, float y){
        final Sound sound = getSound(path);
        if (sound != null) location.getWorld().playSound(location, sound, x, y);
    }
}

