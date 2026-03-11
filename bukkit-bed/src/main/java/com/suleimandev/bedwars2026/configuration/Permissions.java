package com.suleimandev.bedwars2026.configuration;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import org.bukkit.entity.Player;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class Permissions {
    public static final String PERMISSION_FORCESTART = BukkitBedPlugin.mainCmd+".forcestart";
    public static final String PERMISSION_ALL = BukkitBedPlugin.mainCmd+".*";
    public static final String PERMISSION_COMMAND_BYPASS = BukkitBedPlugin.mainCmd+".cmd.bypass";
    public static final String PERMISSION_SHOUT_COMMAND = BukkitBedPlugin.mainCmd+".shout";

    public static final String PERMISSION_SETUP_ARENA = BukkitBedPlugin.mainCmd+".setup";
    public static final String PERMISSION_ARENA_GROUP = BukkitBedPlugin.mainCmd+".groups";
    public static final String PERMISSION_BUILD = BukkitBedPlugin.mainCmd+".build";
    public static final String PERMISSION_CLONE = BukkitBedPlugin.mainCmd+".clone";
    public static final String PERMISSION_DEL_ARENA = BukkitBedPlugin.mainCmd+".delete";
    public static final String PERMISSION_ARENA_ENABLE = BukkitBedPlugin.mainCmd+".enableRotation";
    public static final String PERMISSION_ARENA_DISABLE = BukkitBedPlugin.mainCmd+".disable";
    public static final String PERMISSION_NPC = BukkitBedPlugin.mainCmd+".npc";
    public static final String PERMISSION_RELOAD = BukkitBedPlugin.mainCmd+".reload";
    public static final String PERMISSION_REJOIN = BukkitBedPlugin.mainCmd+".rejoin";
    public static final String PERMISSION_LEVEL = BukkitBedPlugin.mainCmd+".level";
    public static final String PERMISSION_CHAT_COLOR = BukkitBedPlugin.mainCmd+".chatcolor";
    public static final String PERMISSION_VIP = BukkitBedPlugin.mainCmd+".vip";
    public static final String PERMISSION_VIP_JOIN_FULL = BukkitBedPlugin.mainCmd+".vip.joinfull";
    public static final String PERMISSION_VIP_BYPASS_LIMITS = BukkitBedPlugin.mainCmd+".vip.bypasslimits";
    public static final String PERMISSION_VIP_PARTY_PRIORITY = BukkitBedPlugin.mainCmd+".vip.partypriority";

    /**
     * Check if player has one of the given permissions.
     */
    public static boolean hasPermission(Player player, String... permissions){
        for (String permission : permissions){
            if (player.hasPermission(permission)){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if player has all given permissions.
     */
    public static boolean hasPermissions(Player player, String... permissions){
        for (String permission : permissions){
            if (!player.hasPermission(permission)){
                return false;
            }
        }
        return true;
    }
}

