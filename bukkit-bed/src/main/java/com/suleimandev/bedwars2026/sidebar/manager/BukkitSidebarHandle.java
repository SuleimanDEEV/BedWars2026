package com.suleimandev.bedwars2026.sidebar.manager;

import com.suleimandev.bedwars2026.sidebar.api.PlaceholderProvider;
import com.suleimandev.bedwars2026.sidebar.api.PlayerTab;
import com.suleimandev.bedwars2026.sidebar.api.SidebarHandle;
import com.suleimandev.bedwars2026.sidebar.api.SidebarLine;
import com.suleimandev.bedwars2026.sidebar.line.SidebarLineParts;
import com.suleimandev.bedwars2026.sidebar.line.SidebarTextSplitter;
import com.suleimandev.bedwars2026.sidebar.placeholder.PlaceholderResolver;
import com.suleimandev.bedwars2026.sidebar.tab.BukkitPlayerTab;
import com.suleimandev.bedwars2026.sidebar.version.SidebarVersionAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class BukkitSidebarHandle implements SidebarHandle {

    private static final String[] LINE_ENTRIES = {
            ChatColor.BLACK.toString(),
            ChatColor.DARK_BLUE.toString(),
            ChatColor.DARK_GREEN.toString(),
            ChatColor.DARK_AQUA.toString(),
            ChatColor.DARK_RED.toString(),
            ChatColor.DARK_PURPLE.toString(),
            ChatColor.GOLD.toString(),
            ChatColor.GRAY.toString(),
            ChatColor.DARK_GRAY.toString(),
            ChatColor.BLUE.toString(),
            ChatColor.GREEN.toString(),
            ChatColor.AQUA.toString(),
            ChatColor.RED.toString(),
            ChatColor.LIGHT_PURPLE.toString(),
            ChatColor.YELLOW.toString()
    };

    private final SidebarVersionAdapter versionAdapter;
    private final Map<String, PlaceholderProvider> placeholders = new LinkedHashMap<>();
    private final List<SidebarLine> lines = new ArrayList<>();
    private final Map<Integer, Team> lineTeams = new LinkedHashMap<>();
    private final Map<String, BukkitPlayerTab> tabs = new LinkedHashMap<>();

    private SidebarLine title;
    private SidebarLine healthLabel;
    private boolean displayHealthInTab;

    private Player viewer;
    private Scoreboard scoreboard;
    private Objective sidebarObjective;
    private Objective belowNameObjective;
    private Objective playerListObjective;

    public BukkitSidebarHandle(@NotNull SidebarVersionAdapter versionAdapter,
                               @NotNull SidebarLine title,
                               @NotNull List<SidebarLine> lines,
                               @NotNull Collection<PlaceholderProvider> placeholders) {
        this.versionAdapter = versionAdapter;
        this.title = title;
        this.lines.addAll(lines);
        placeholders.forEach(provider -> this.placeholders.put(provider.getPlaceholder(), provider));
    }

    @Override
    public void add(@NotNull Player player) {
        this.viewer = player;
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.sidebarObjective = scoreboard.registerNewObjective("bw2026_sb", "dummy");
        this.sidebarObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
        renderSidebar();
        player.setScoreboard(scoreboard);
    }

    @Override
    public void remove(@NotNull Player player) {
        if (scoreboard == null) {
            return;
        }
        removeTabs();
        clearLineTeams();
        unregisterObjective(sidebarObjective);
        unregisterObjective(belowNameObjective);
        unregisterObjective(playerListObjective);
        sidebarObjective = null;
        belowNameObjective = null;
        playerListObjective = null;
        if (player.isOnline()) {
            player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
        }
        scoreboard = null;
        viewer = null;
        lines.clear();
        placeholders.clear();
    }

    @Override
    public void clearLines() {
        lines.clear();
        clearLineTeams();
        if (sidebarObjective != null) {
            LINE_ENTRIES_SET.forEach(scoreboard::resetScores);
        }
    }

    @Override
    public void setTitle(@NotNull SidebarLine title) {
        this.title = title;
        if (sidebarObjective != null) {
            sidebarObjective.setDisplayName(renderTitle());
        }
    }

    @Override
    public void addLine(@NotNull SidebarLine line) {
        lines.add(line);
        renderSidebar();
    }

    @Override
    public void removeTabs() {
        tabs.values().forEach(BukkitPlayerTab::unregister);
        tabs.clear();
    }

    @Override
    public @NotNull PlayerTab playerTabCreate(@NotNull String identifier,
                                              @NotNull Player player,
                                              @NotNull SidebarLine prefix,
                                              @NotNull SidebarLine suffix,
                                              @NotNull PlayerTab.PushingRule pushingRule,
                                              @NotNull Collection<PlaceholderProvider> placeholders) {
        BukkitPlayerTab previous = tabs.remove(identifier);
        if (previous != null) {
            previous.unregister();
        }
        BukkitPlayerTab tab = new BukkitPlayerTab(scoreboard, identifier, player.getName(), prefix, suffix, placeholders, versionAdapter);
        tabs.put(identifier, tab);
        return tab;
    }

    @Override
    public void removeTab(@NotNull String identifier) {
        BukkitPlayerTab tab = tabs.remove(identifier);
        if (tab != null) {
            tab.unregister();
        }
    }

    @Override
    public void showPlayersHealth(@NotNull SidebarLine label, boolean displayInTab) {
        this.healthLabel = label;
        this.displayHealthInTab = displayInTab;
        ensureHealthObjectives();
    }

    @Override
    public void hidePlayersHealth() {
        unregisterObjective(belowNameObjective);
        unregisterObjective(playerListObjective);
        belowNameObjective = null;
        playerListObjective = null;
        healthLabel = null;
        displayHealthInTab = false;
    }

    @Override
    public void setPlayerHealth(@NotNull Player player, int health) {
        // Health objectives use the built-in health criteria, so updates are handled by Bukkit.
    }

    @Override
    public void refreshTitle() {
        if (sidebarObjective == null || title == null) {
            return;
        }
        title.nextFrame();
        sidebarObjective.setDisplayName(renderTitle());
    }

    @Override
    public void refreshPlaceholders() {
        renderSidebar();
        tabs.values().forEach(tab -> tab.render(false));
    }

    @Override
    public void playerTabRefreshAnimation() {
        tabs.values().forEach(tab -> tab.render(true));
    }

    @Override
    public void playerHealthRefreshAnimation() {
        if (healthLabel == null) {
            return;
        }
        healthLabel.nextFrame();
        ensureHealthObjectives();
    }

    @Override
    public @NotNull Collection<PlaceholderProvider> getPlaceholders() {
        return new ArrayList<>(placeholders.values());
    }

    @Override
    public void addPlaceholder(@NotNull PlaceholderProvider placeholderProvider) {
        placeholders.put(placeholderProvider.getPlaceholder(), placeholderProvider);
    }

    @Override
    public boolean removePlaceholder(@NotNull String placeholder) {
        return placeholders.remove(placeholder) != null;
    }

    private void renderSidebar() {
        if (scoreboard == null || sidebarObjective == null) {
            return;
        }

        sidebarObjective.setDisplayName(renderTitle());
        clearLineTeams();

        int score = Math.min(lines.size(), LINE_ENTRIES.length);
        for (int i = 0; i < score; i++) {
            String entry = LINE_ENTRIES[i];
            String raw = PlaceholderResolver.resolve(lines.get(i).getLine(), placeholders.values());
            SidebarLineParts parts = SidebarTextSplitter.split(raw, versionAdapter.getTeamTextLimit());
            Team team = scoreboard.registerNewTeam("bw2026_l" + i);
            team.addEntry(entry);
            team.setPrefix(parts.getPrefix());
            team.setSuffix(parts.getSuffix());
            sidebarObjective.getScore(entry).setScore(score - i);
            lineTeams.put(i, team);
        }

        if (viewer != null && viewer.isOnline() && viewer.getScoreboard() != scoreboard) {
            viewer.setScoreboard(scoreboard);
        }
    }

    @NotNull
    private String renderTitle() {
        String resolved = title == null ? "" : PlaceholderResolver.resolve(title.getLine(), placeholders.values());
        return SidebarTextSplitter.truncate(resolved, versionAdapter.getTitleLimit());
    }

    private void ensureHealthObjectives() {
        if (scoreboard == null || healthLabel == null) {
            return;
        }

        if (belowNameObjective == null) {
            belowNameObjective = scoreboard.registerNewObjective("bw2026_hp", "health");
            belowNameObjective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        }
        belowNameObjective.setDisplayName(SidebarTextSplitter.truncate(
                PlaceholderResolver.resolve(healthLabel.getLine(), placeholders.values()),
                versionAdapter.getTitleLimit()
        ));

        if (displayHealthInTab) {
            if (playerListObjective == null) {
                playerListObjective = scoreboard.registerNewObjective("bw2026_hpt", "health");
                playerListObjective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            }
            playerListObjective.setDisplayName(belowNameObjective.getDisplayName());
        } else {
            unregisterObjective(playerListObjective);
            playerListObjective = null;
        }
    }

    private void clearLineTeams() {
        if (scoreboard == null) {
            return;
        }
        lineTeams.forEach((slot, team) -> {
            for (String entry : new ArrayList<>(team.getEntries())) {
                scoreboard.resetScores(entry);
            }
            team.unregister();
        });
        lineTeams.clear();
    }

    private void unregisterObjective(Objective objective) {
        if (objective != null) {
            objective.unregister();
        }
    }

    private static final Collection<String> LINE_ENTRIES_SET = new LinkedHashSet<>(java.util.Arrays.asList(LINE_ENTRIES));
}

