package com.suleimandev.bedwars2026.upgrades.menu;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.api.upgrades.MenuContent;
import com.suleimandev.bedwars2026.upgrades.UpgradesManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
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

public class MenuSeparator implements MenuContent {

    private ItemStack displayItem;
    private String name;
    private List<String> playerCommands = new ArrayList<>(), consoleCommands = new ArrayList<>();

    /**
     * Create a separator.
     *
     * @param displayItem display item.
     */
    public MenuSeparator(String name, ItemStack displayItem) {
        if (name == null) return;
        this.displayItem = BukkitBedPlugin.nms.addCustomData(displayItem, "MCONT_" + name);
        this.name = name;
        Language.saveIfNotExists(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + name.replace("separator-", ""), "&cName not set");
        Language.saveIfNotExists(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + name.replace("separator-", ""), Collections.singletonList("&cLore not set"));

        if (UpgradesManager.getConfiguration().getYml().getStringList(name + ".on-click.player") != null) {
            playerCommands.addAll(UpgradesManager.getConfiguration().getYml().getStringList(name + ".on-click.player"));
        }
        if (UpgradesManager.getConfiguration().getYml().getStringList(name + ".on-click.console") != null) {
            consoleCommands.addAll(UpgradesManager.getConfiguration().getYml().getStringList(name + ".on-click.console"));
        }
    }

    @Override
    public ItemStack getDisplayItem(Player player, ITeam team) {
        ItemStack i = new ItemStack(displayItem);
        ItemMeta im = i.getItemMeta();
        if (im != null) {
            im.setDisplayName(Language.getMsg(player, Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + name.replace("separator-", "")));
            im.setLore(Language.getList(player, Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + name.replace("separator-", "")));
            im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            i.setItemMeta(im);
        }
        return i;
    }

    @Override
    public void onClick(Player player, ClickType clickType, ITeam team) {
        for (String cmd : playerCommands) {
            if (cmd.trim().isEmpty()) continue;
            Bukkit.dispatchCommand(player, cmd.replace("{playername}", player.getName()).replace("{player}", player.getDisplayName()).replace("{team}", team == null ? "null" : team.getDisplayName(Language.getPlayerLanguage(player))));
        }
        for (String cmd : consoleCommands) {
            if (cmd.trim().isEmpty()) continue;
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("{playername}", player.getName()).replace("{player}", player.getDisplayName()).replace("{team}", team == null ? "null" : team.getDisplayName(Language.getPlayerLanguage(player))));
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

