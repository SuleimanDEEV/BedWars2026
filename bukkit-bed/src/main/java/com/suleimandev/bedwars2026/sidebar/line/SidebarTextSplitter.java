package com.suleimandev.bedwars2026.sidebar.line;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public final class SidebarTextSplitter {

    private SidebarTextSplitter() {
    }

    @NotNull
    public static SidebarLineParts split(@NotNull String text, int partLimit) {
        if (text.isEmpty()) {
            return new SidebarLineParts("", "");
        }

        String prefix = safeSubstring(text, partLimit);
        if (text.length() <= prefix.length()) {
            return new SidebarLineParts(prefix, "");
        }

        String suffix = ChatColor.getLastColors(prefix) + text.substring(prefix.length());
        suffix = safeSubstring(suffix, partLimit);
        return new SidebarLineParts(prefix, suffix);
    }

    @NotNull
    public static String truncate(@NotNull String text, int limit) {
        return safeSubstring(text, limit);
    }

    @NotNull
    private static String safeSubstring(@NotNull String text, int limit) {
        if (text.length() <= limit) {
            return text;
        }
        int end = Math.max(0, limit);
        if (end > 0 && text.charAt(end - 1) == ChatColor.COLOR_CHAR) {
            end--;
        }
        return text.substring(0, end);
    }
}

