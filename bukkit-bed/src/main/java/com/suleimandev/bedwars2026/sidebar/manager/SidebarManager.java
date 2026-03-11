package com.suleimandev.bedwars2026.sidebar.manager;

import com.suleimandev.bedwars2026.sidebar.api.PlaceholderProvider;
import com.suleimandev.bedwars2026.sidebar.api.SidebarHandle;
import com.suleimandev.bedwars2026.sidebar.api.SidebarLine;
import com.suleimandev.bedwars2026.sidebar.api.TabHeaderFooter;
import com.suleimandev.bedwars2026.sidebar.placeholder.PlaceholderResolver;
import com.suleimandev.bedwars2026.sidebar.version.SidebarVersionAdapter;
import com.suleimandev.bedwars2026.sidebar.version.SidebarVersionResolver;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public final class SidebarManager {

    private static SidebarManager instance;

    private final SidebarVersionAdapter versionAdapter;

    private SidebarManager(@NotNull SidebarVersionAdapter versionAdapter) {
        this.versionAdapter = versionAdapter;
    }

    @NotNull
    public static SidebarManager init() {
        if (instance == null) {
            instance = new SidebarManager(SidebarVersionResolver.resolve());
        }
        return instance;
    }

    @NotNull
    public static SidebarManager getInstance() {
        return init();
    }

    @NotNull
    public SidebarHandle createSidebar(@NotNull SidebarLine title,
                                       @NotNull List<SidebarLine> lines,
                                       @NotNull Collection<PlaceholderProvider> placeholders) {
        return new BukkitSidebarHandle(versionAdapter, title, lines, placeholders);
    }

    public void sendHeaderFooter(@NotNull Player player, @NotNull TabHeaderFooter tabHeaderFooter) {
        String header = resolveLines(tabHeaderFooter.getHeader(), tabHeaderFooter.getPlaceholders());
        String footer = resolveLines(tabHeaderFooter.getFooter(), tabHeaderFooter.getPlaceholders());
        versionAdapter.sendHeaderFooter(player, header, footer);
        tabHeaderFooter.nextFrame();
    }

    @NotNull
    public SidebarVersionAdapter getVersionAdapter() {
        return versionAdapter;
    }

    @NotNull
    private String resolveLines(@NotNull List<SidebarLine> lines, @NotNull Collection<PlaceholderProvider> placeholders) {
        return lines.stream()
                .map(SidebarLine::getLine)
                .map(line -> PlaceholderResolver.resolve(line, placeholders))
                .collect(Collectors.joining("\n"));
    }
}

