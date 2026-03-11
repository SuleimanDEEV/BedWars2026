package com.suleimandev.bedwars2026.support.citizens;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.configuration.Sounds;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRemoveEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import java.util.ArrayList;
import java.util.List;
import static com.suleimandev.bedwars2026.api.language.Language.getMsg;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class CitizensListener implements Listener {

    @EventHandler
    public void removeNPC(NPCRemoveEvent e) {
        if (e == null) return;
        if (e.getNPC() == null) return;
        if (e.getNPC().getEntity() == null) return;
        List<String> locations = BukkitBedPlugin.config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE);
        boolean removed = false;
        if (JoinNPC.npcs.containsKey(e.getNPC().getId())) {
            JoinNPC.npcs.remove(e.getNPC().getId());
            removed = true;
        }
        for (String s : new ArrayList<>(locations)) {
            String[] data = s.split(",");
            if (data.length >= 10) {
                if (Misc.isNumber(data[9])) {
                    if (Integer.parseInt(data[9]) == e.getNPC().getId()) {
                        locations.remove(s);
                        removed = true;
                    }
                }
            }
        }
        for (Entity e2 : e.getNPC().getEntity().getNearbyEntities(0, 3, 0)) {
            if (e2.getType() == EntityType.ARMOR_STAND) {
                e2.remove();
            }
        }
        if (removed) BukkitBedPlugin.config.set(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE, locations);
    }

    @EventHandler
    // Citizens support
    public void onNPCInteract(PlayerInteractEntityEvent e) {
        if (!JoinNPC.isCitizensSupport()) return;
        if (e.getPlayer().isSneaking()) return;
        if (!e.getRightClicked().hasMetadata("NPC")) return;
        net.citizensnpcs.api.npc.NPC npc = CitizensAPI.getNPCRegistry().getNPC(e.getRightClicked());
        if (npc == null) return;
        if (JoinNPC.npcs.containsKey(npc.getId())) {
            if (!Arena.joinRandomFromGroup(e.getPlayer(), JoinNPC.npcs.get(npc.getId()))) {
                e.getPlayer().sendMessage(getMsg(e.getPlayer(), Messages.COMMAND_JOIN_NO_EMPTY_FOUND));
                Sounds.playSound("join-denied", e.getPlayer());
            } else {
                Sounds.playSound("join-allowed", e.getPlayer());
            }
        }
    }

}

