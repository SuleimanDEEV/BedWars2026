package com.suleimandev.bedwars2026.sidebar.api;

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

public final class TabHeaderFooter {

    private final List<SidebarLine> header;
    private final List<SidebarLine> footer;
    private final Collection<PlaceholderProvider> placeholders;

    public TabHeaderFooter(@NotNull List<SidebarLine> header,
                           @NotNull List<SidebarLine> footer,
                           @NotNull Collection<PlaceholderProvider> placeholders) {
        this.header = Collections.unmodifiableList(new ArrayList<>(header));
        this.footer = Collections.unmodifiableList(new ArrayList<>(footer));
        this.placeholders = Collections.unmodifiableCollection(new ArrayList<>(placeholders));
    }

    @NotNull
    public List<SidebarLine> getHeader() {
        return header;
    }

    @NotNull
    public List<SidebarLine> getFooter() {
        return footer;
    }

    @NotNull
    public Collection<PlaceholderProvider> getPlaceholders() {
        return placeholders;
    }

    public void nextFrame() {
        header.forEach(SidebarLine::nextFrame);
        footer.forEach(SidebarLine::nextFrame);
    }
}

