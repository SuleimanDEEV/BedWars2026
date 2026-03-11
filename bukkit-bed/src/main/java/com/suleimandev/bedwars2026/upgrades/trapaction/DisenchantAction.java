package com.suleimandev.bedwars2026.upgrades.trapaction;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.upgrades.TrapAction;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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

public class DisenchantAction implements TrapAction {

    private Enchantment enchantment;
    private ApplyType type;

    public DisenchantAction(Enchantment enchantment, DisenchantAction.ApplyType type){
        this.enchantment = enchantment;
        this.type = type;
    }

    @Override
    public String getName() {
        return "disenchant-item";
    }

    @Override
    public void onTrigger(@NotNull Player player, ITeam playerTeam, ITeam targetTeam) {
        if (type == ApplyType.SWORD){
            for (ItemStack i : player.getInventory()){
                if (BukkitBedPlugin.nms.isSword(i)){
                    i.removeEnchantment(enchantment);
                }
                player.updateInventory();
            }
        } else if (type == ApplyType.ARMOR){
            for (ItemStack i : player.getInventory()){
                if (BukkitBedPlugin.nms.isArmor(i)){
                    i.removeEnchantment(enchantment);
                }
                player.updateInventory();
            }
            for (ItemStack i : player.getInventory().getArmorContents()){
                if (BukkitBedPlugin.nms.isArmor(i)){
                    i.removeEnchantment(enchantment);
                }
                player.updateInventory();
            }
        } else if (type == ApplyType.BOW){
            for (ItemStack i : player.getInventory()){
                if (BukkitBedPlugin.nms.isBow(i)){
                    i.removeEnchantment(enchantment);
                }
                player.updateInventory();
            }
        }
    }

    public enum ApplyType {
        SWORD,
        ARMOR,
        BOW,
    }
}

