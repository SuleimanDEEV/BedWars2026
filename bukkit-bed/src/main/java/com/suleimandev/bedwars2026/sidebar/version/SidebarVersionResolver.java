package com.suleimandev.bedwars2026.sidebar.version;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Method;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public final class SidebarVersionResolver {

    private SidebarVersionResolver() {
    }

    @NotNull
    public static SidebarVersionAdapter resolve() {
        try {
            Method method = Player.class.getMethod("setPlayerListHeaderFooter", String.class, String.class);
            return new ModernSidebarVersionAdapter(method);
        } catch (NoSuchMethodException ignored) {
        }

        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        String[] split = packageName.split("\\.");
        String version = split[split.length - 1];
        return new LegacySidebarVersionAdapter(version);
    }
}

