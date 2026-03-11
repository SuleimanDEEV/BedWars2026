package com.suleimandev.bedwars2026.upgrades.menu;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.api.upgrades.EnemyBaseEnterTrap;
import com.suleimandev.bedwars2026.api.upgrades.MenuContent;
import com.suleimandev.bedwars2026.api.upgrades.TeamUpgrade;
import com.suleimandev.bedwars2026.api.upgrades.UpgradesIndex;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.upgrades.UpgradesManager;
import com.google.common.collect.ImmutableMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import java.util.HashMap;
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

public class InternalMenu implements UpgradesIndex {

    private String name;
    private HashMap<Integer, MenuContent> menuContentBySlot = new HashMap<>();

    /**
     * Create an upgrade menu for an arena group.
     *
     * @param groupName arena group name.
     */
    public InternalMenu(String groupName) {
        this.name = groupName.toLowerCase();
        Language.saveIfNotExists(Messages.UPGRADES_MENU_GUI_NAME_PATH + groupName.toLowerCase(), "&8Upgrades & Traps");
    }

    @Override
    public void open(Player player) {
        IArena a = Arena.getArenaByPlayer(player);
        if (a == null) return;
        if (!a.isPlayer(player)) return;
        ITeam team = a.getTeam(player);
        if (team == null) return;
        if (!BukkitBedPlugin.getAPI().getArenaUtil().isPlaying(player)) return;
        Inventory inv = Bukkit.createInventory(null, 45, Language.getMsg(player, Messages.UPGRADES_MENU_GUI_NAME_PATH + name));
        for (Map.Entry<Integer, MenuContent> entry : menuContentBySlot.entrySet()) {
            inv.setItem(entry.getKey(), entry.getValue().getDisplayItem(player, team));
        }
        player.openInventory(inv);
        UpgradesManager.setWatchingUpgrades(player.getUniqueId());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean addContent(MenuContent content, int slot) {
        if (menuContentBySlot.get(slot) != null) return false;
        menuContentBySlot.put(slot, content);
        return true;
    }

    public int countTiers() {
        int count = 0;
        for (MenuContent content : menuContentBySlot.values()){
            if (content instanceof TeamUpgrade && !(content instanceof EnemyBaseEnterTrap)){
                TeamUpgrade tu = (TeamUpgrade) content;
                count+=tu.getTierCount();
            }
        }
        return count;
    }

    @Override
    public ImmutableMap<Integer, MenuContent> getMenuContentBySlot() {
        return ImmutableMap.copyOf(menuContentBySlot);
    }
}

