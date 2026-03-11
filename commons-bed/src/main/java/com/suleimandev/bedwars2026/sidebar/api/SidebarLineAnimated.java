package com.suleimandev.bedwars2026.sidebar.api;

import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class SidebarLineAnimated extends SidebarLine {

    private final String[] frames;
    private int index = 0;

    public SidebarLineAnimated(@NotNull String... frames) {
        this.frames = Objects.requireNonNull(frames, "frames");
    }

    @Override
    public @NotNull String getLine() {
        if (frames.length == 0) {
            return "";
        }
        if (index < 0 || index >= frames.length) {
            index = 0;
        }
        String current = frames[index];
        return current == null ? "" : current;
    }

    @Override
    public void nextFrame() {
        if (frames.length < 2) {
            return;
        }
        index++;
        if (index >= frames.length) {
            index = 0;
        }
    }
}

