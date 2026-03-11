package com.suleimandev.bedwars2026.arena.tasks;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

public class ReJoinTask implements Runnable {

    private static final List<ReJoinTask> reJoinTasks = new ArrayList<>();

    private final IArena arena;
    private final ITeam bedWarsTeam;
    private final BukkitTask task;

    public ReJoinTask(IArena arena, ITeam bedWarsTeam) {
        this.arena = arena;
        this.bedWarsTeam = bedWarsTeam;
        task = Bukkit.getScheduler().runTaskLater(BukkitBedPlugin.plugin, this, BukkitBedPlugin.config.getInt(ConfigPath.GENERAL_CONFIGURATION_REJOIN_TIME) * 20L);
    }

    @Override
    public void run() {
        if (arena == null) {
            destroy();
            return;
        }
        if (bedWarsTeam == null) {
            destroy();
            return;
        }
        if (bedWarsTeam.getMembers() == null){
            destroy();
            return;
        }
        if (bedWarsTeam.getMembers().isEmpty()) {
            bedWarsTeam.setBedDestroyed(true);
            destroy();
        }
    }

    /**
     * Get arena
     */
    public IArena getArena() {
        return arena;
    }

    /**
     * Destroy task
     */
    public void destroy() {
        reJoinTasks.remove(this);
        task.cancel();
    }

    /**
     * Get tasks list
     */
    @NotNull
    @Contract(pure = true)
    public static Collection<ReJoinTask> getReJoinTasks() {
        return Collections.unmodifiableCollection(reJoinTasks);
    }

    public void cancel() {
        task.cancel();
    }
}

