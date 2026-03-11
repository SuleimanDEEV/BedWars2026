package com.suleimandev.bedwars2026.sidebar.version;

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

public class ModernSidebarVersionAdapter implements SidebarVersionAdapter {

    private final Method headerFooterMethod;

    public ModernSidebarVersionAdapter(@NotNull Method headerFooterMethod) {
        this.headerFooterMethod = headerFooterMethod;
    }

    @Override
    public void sendHeaderFooter(@NotNull Player player, @NotNull String header, @NotNull String footer) {
        try {
            headerFooterMethod.invoke(player, header, footer);
        } catch (ReflectiveOperationException ignored) {
        }
    }

    @Override
    public int getTeamTextLimit() {
        return 64;
    }

    @Override
    public int getTitleLimit() {
        return 128;
    }
}

