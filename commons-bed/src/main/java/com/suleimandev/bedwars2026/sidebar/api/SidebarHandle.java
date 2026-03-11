package com.suleimandev.bedwars2026.sidebar.api;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Collection;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public interface SidebarHandle {

    void add(@NotNull Player player);

    void remove(@NotNull Player player);

    void clearLines();

    void setTitle(@NotNull SidebarLine title);

    void addLine(@NotNull SidebarLine line);

    void removeTabs();

    @NotNull
    PlayerTab playerTabCreate(@NotNull String identifier,
                              @NotNull Player player,
                              @NotNull SidebarLine prefix,
                              @NotNull SidebarLine suffix,
                              @NotNull PlayerTab.PushingRule pushingRule,
                              @NotNull Collection<PlaceholderProvider> placeholders);

    void removeTab(@NotNull String identifier);

    void showPlayersHealth(@NotNull SidebarLine label, boolean displayInTab);

    void hidePlayersHealth();

    void setPlayerHealth(@NotNull Player player, int health);

    void refreshTitle();

    void refreshPlaceholders();

    void playerTabRefreshAnimation();

    void playerHealthRefreshAnimation();

    @NotNull
    Collection<PlaceholderProvider> getPlaceholders();

    void addPlaceholder(@NotNull PlaceholderProvider placeholderProvider);

    boolean removePlaceholder(@NotNull String placeholder);
}

