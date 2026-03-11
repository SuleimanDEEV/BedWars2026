package com.suleimandev.bedwars2026.sidebar.tab;

import com.suleimandev.bedwars2026.sidebar.api.PlaceholderProvider;
import com.suleimandev.bedwars2026.sidebar.api.PlayerTab;
import com.suleimandev.bedwars2026.sidebar.api.SidebarLine;
import com.suleimandev.bedwars2026.sidebar.line.SidebarLineParts;
import com.suleimandev.bedwars2026.sidebar.line.SidebarTextSplitter;
import com.suleimandev.bedwars2026.sidebar.placeholder.PlaceholderResolver;
import com.suleimandev.bedwars2026.sidebar.version.SidebarVersionAdapter;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collection;
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

public class BukkitPlayerTab implements PlayerTab {

    private final String identifier;
    private final String entry;
    private final SidebarLine prefix;
    private final SidebarLine suffix;
    private final List<PlaceholderProvider> placeholders;
    private final SidebarVersionAdapter versionAdapter;
    private final Team team;

    public BukkitPlayerTab(@NotNull Scoreboard scoreboard,
                           @NotNull String identifier,
                           @NotNull String entry,
                           @NotNull SidebarLine prefix,
                           @NotNull SidebarLine suffix,
                           @NotNull Collection<PlaceholderProvider> placeholders,
                           @NotNull SidebarVersionAdapter versionAdapter) {
        this.identifier = identifier;
        this.entry = entry;
        this.prefix = prefix;
        this.suffix = suffix;
        this.placeholders = new ArrayList<>(placeholders);
        this.versionAdapter = versionAdapter;
        Team existing = scoreboard.getTeam(identifier);
        if (existing != null) {
            existing.unregister();
        }
        this.team = scoreboard.registerNewTeam(identifier);
        this.team.addEntry(entry);
        render(false);
    }

    @Override
    public @NotNull String getIdentifier() {
        return identifier;
    }

    public void render(boolean advanceFrame) {
        if (advanceFrame) {
            prefix.nextFrame();
            suffix.nextFrame();
        }

        String resolvedPrefix = PlaceholderResolver.resolve(prefix.getLine(), placeholders);
        String resolvedSuffix = PlaceholderResolver.resolve(suffix.getLine(), placeholders);

        SidebarLineParts prefixParts = SidebarTextSplitter.split(resolvedPrefix, versionAdapter.getTeamTextLimit());
        SidebarLineParts suffixParts = SidebarTextSplitter.split(resolvedSuffix, versionAdapter.getTeamTextLimit());

        team.setPrefix(prefixParts.getPrefix());
        team.setSuffix(suffixParts.getPrefix() + suffixParts.getSuffix());
    }

    @Override
    public void setNameTagVisibility(@NotNull PlayerTab.NameTagVisibility visibility) {
        switch (visibility) {
            case NEVER:
                team.setNameTagVisibility(org.bukkit.scoreboard.NameTagVisibility.NEVER);
                break;
            case HIDE_FOR_OTHER_TEAMS:
                team.setNameTagVisibility(org.bukkit.scoreboard.NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
                break;
            case HIDE_FOR_OWN_TEAM:
                team.setNameTagVisibility(org.bukkit.scoreboard.NameTagVisibility.HIDE_FOR_OWN_TEAM);
                break;
            case ALWAYS:
            default:
                team.setNameTagVisibility(org.bukkit.scoreboard.NameTagVisibility.ALWAYS);
                break;
        }
    }

    public void unregister() {
        team.unregister();
    }
}

