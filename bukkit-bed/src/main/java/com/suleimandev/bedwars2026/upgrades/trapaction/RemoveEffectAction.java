package com.suleimandev.bedwars2026.upgrades.trapaction;

import com.suleimandev.bedwars2026.api.arena.team.ITeam;
import com.suleimandev.bedwars2026.api.upgrades.TrapAction;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
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

public class RemoveEffectAction implements TrapAction {

    private PotionEffectType potionEffectType;

    public RemoveEffectAction(PotionEffectType potionEffectType){
        this.potionEffectType = potionEffectType;
    }

    @Override
    public String getName() {
        return "remove-effect";
    }

    @Override
    public void onTrigger(@NotNull Player player, ITeam playerTeam, ITeam targetTeam) {
        player.removePotionEffect(potionEffectType);
    }
}

