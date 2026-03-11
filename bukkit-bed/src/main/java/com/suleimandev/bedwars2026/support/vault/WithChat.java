package com.suleimandev.bedwars2026.support.vault;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class WithChat implements Chat {

    private static net.milkbowl.vault.chat.Chat chat;

    @Override
    public String getPrefix(Player p) {
        return ChatColor.translateAlternateColorCodes('&', chat.getPlayerPrefix(p));
    }

    @Override
    public String getSuffix(Player p) {
        return ChatColor.translateAlternateColorCodes('&', chat.getPlayerSuffix(p));
    }

    public static void setChat(net.milkbowl.vault.chat.Chat chat) {
        WithChat.chat = chat;
    }
}

