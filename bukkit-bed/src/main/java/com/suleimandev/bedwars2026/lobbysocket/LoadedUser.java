package com.suleimandev.bedwars2026.lobbysocket;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.language.Language;
import org.bukkit.Bukkit;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class LoadedUser {

    private static final long waitSeconds = BukkitBedPlugin.config.getYml().getLong(ConfigPath.GENERAL_CONFIGURATION_BUNGEE_OPTION_BWP_TIME_OUT);

    private UUID uuid;
    private String partyOwnerOrSpectateTarget = null;
    private long toleranceTime;
    private String arenaIdentifier;
    private Language language = null;

    private static final ConcurrentHashMap<UUID, LoadedUser> loaded = new ConcurrentHashMap<>();

    public LoadedUser(String uuid, String arenaIdentifier, String langIso, String partyOwnerOrSpectateTarget){
        if (Bukkit.getWorld(arenaIdentifier) == null) return;
        this.arenaIdentifier = arenaIdentifier;
        this.uuid = UUID.fromString(uuid);
        if (partyOwnerOrSpectateTarget != null){
            if (!partyOwnerOrSpectateTarget.isEmpty()) {
                this.partyOwnerOrSpectateTarget = partyOwnerOrSpectateTarget;
            }
        }
        this.toleranceTime = System.currentTimeMillis() + waitSeconds;
        Language l = Language.getLang(langIso);
        if (l != null) language = l;

        loaded.put(this.uuid, this);
    }

    public static boolean isPreLoaded(UUID uuid){
        return loaded.containsKey(uuid);
    }

    public boolean isTimedOut() {
        return System.currentTimeMillis() > this.toleranceTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getArenaIdentifier() {
        return arenaIdentifier;
    }

    public void destroy(String reason){
        BukkitBedPlugin.debug("Destroyed PreLoaded User: " + uuid + " Reason: " + reason + ". Tolerance: " + waitSeconds);
        loaded.remove(uuid);
    }

    public Language getLanguage() {
        return language;
    }

    public static LoadedUser getPreLoaded(UUID uuid){
        return loaded.get(uuid);
    }

    // if arena is started is used as staff teleport target
    public String getPartyOwnerOrSpectateTarget() {
        return partyOwnerOrSpectateTarget;
    }

    public static ConcurrentHashMap<UUID, LoadedUser> getLoaded() {
        return loaded;
    }
}

