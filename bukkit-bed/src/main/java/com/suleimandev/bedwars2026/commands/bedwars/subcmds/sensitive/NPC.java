package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.Permissions;
import com.suleimandev.bedwars2026.support.citizens.JoinNPC;
import com.google.common.base.Joiner;
import net.citizensnpcs.api.CitizensAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.mainCmd;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class NPC extends SubCommand {

    //main usage
    private final List<BaseComponent> MAIN_USAGE = Arrays.asList(Misc.msgHoverClick("Â§f\nÂ§câ–ª Â§7Usage: Â§e/" + mainCmd + " " + getSubCommandName() + " add", "Â§fUse this command to create a join NPC.\nÂ§fClick to see the syntax.", "/"+getParent().getName()+" "+getSubCommandName()+" add", ClickEvent.Action.RUN_COMMAND),
            Misc.msgHoverClick("Â§câ–ª Â§7Usage: Â§e/" + mainCmd + " " + getSubCommandName() + " remove", "Â§fStay in front of a NPC in order to remove it.", "/"+getParent().getName()+" "+getSubCommandName()+" remove", ClickEvent.Action.SUGGEST_COMMAND));
    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    private final List<BaseComponent> ADD_USAGE = Arrays.asList(Misc.msgHoverClick("f\nÂ§câ–ª Â§7Usage: Â§eÂ§o/" + getParent().getName() + " " + getSubCommandName() + " add <skin> <arenaGroup> <Â§7line1Â§9\\nÂ§7line2Â§e>\nÂ§7You can use Â§e{players} Â§7for the players count in this arena Â§7group.", "Click to use.", "/"+getParent().getName()+" "+getSubCommandName()+" add", ClickEvent.Action.SUGGEST_COMMAND));

    public NPC(ParentCommand parent, String name) {
        super(parent, name);
        showInList(true);
        setPriority(12);
        setPermission(Permissions.PERMISSION_NPC);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " " + getSubCommandName() + "         Â§8   - Â§ecreate a join NPC", "Â§fCreate a join NPC  \nÂ§fClick for more details.",
                "/" + getParent().getName() + " " + getSubCommandName(), ClickEvent.Action.RUN_COMMAND));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        if (!JoinNPC.isCitizensSupport()) return false;
        Player p = (Player) s;
        if (args.length < 1) {
            for (BaseComponent bc : MAIN_USAGE){
                p.spigot().sendMessage(bc);
            }
            return true;
        }
        if (args[0].equalsIgnoreCase("add")) {
            if (args.length < 4) {
                for (BaseComponent bc : ADD_USAGE){
                    p.spigot().sendMessage(bc);
                }
                return true;
            }

            List<String> npcs;
            if (BukkitBedPlugin.config.getYml().get(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE) != null) {
                npcs = BukkitBedPlugin.config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE);
            } else {
                npcs = new ArrayList<>();
            }
            String name = Joiner.on(" ").join(args).replace(args[0] + " " + args[1] + " " + args[2] + " ", "");
            net.citizensnpcs.api.npc.NPC npc = JoinNPC.spawnNPC(p.getLocation(), name, args[2], args[1], null);
            assert npc != null;
            npcs.add(BukkitBedPlugin.config.stringLocationConfigFormat(p.getLocation()) + "," + args[1] + "," + name + "," + args[2] + "," + npc.getId());
            String NPC_SET = "Â§aÂ§câ–ª Â§bNPC: %name% Â§bwas set!";
            p.sendMessage(NPC_SET.replace("%name%", name.replace("&", "Â§").replace("\\\\n", " ")));
            p.sendMessage("Â§aÂ§câ–ª Â§bTarget groups: " + ChatColor.GOLD + args[2]);
            BukkitBedPlugin.config.set(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE, npcs);

        } else if (args[0].equalsIgnoreCase("remove")) {

            List<Entity> e = p.getNearbyEntities(4, 4, 4);
            String NO_NPCS = "Â§câ–ª Â§bThere isn't any NPC nearby.";
            if (e.isEmpty()) {
                p.sendMessage(NO_NPCS);
                return true;
            }
            if (BukkitBedPlugin.config.getYml().get(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE) == null) {
                String NO_SET = "Â§câ–ª Â§bThere isn't any NPC set yet!";
                p.sendMessage(NO_SET);
                return true;
            }
            net.citizensnpcs.api.npc.NPC npc = getTarget(p);
            if (npc == null) {
                p.sendMessage(NO_NPCS);
                return true;
            }
            List<String> locations = BukkitBedPlugin.config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE);
            for (Integer id : JoinNPC.npcs.keySet()) {
                if (id == npc.getId()) {
                    for (String loc : BukkitBedPlugin.config.getYml().getStringList(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE)) {
                        if (loc.split(",")[4].equalsIgnoreCase(String.valueOf(npc.getId()))) {
                            locations.remove(loc);
                        }
                    }
                }
            }
            JoinNPC.npcs.remove(npc.getId());
            for (Entity e2 : npc.getEntity().getNearbyEntities(0, 3, 0)) {
                if (e2.getType() == EntityType.ARMOR_STAND) {
                    e2.remove();
                }
            }
            BukkitBedPlugin.config.set(ConfigPath.GENERAL_CONFIGURATION_NPC_LOC_STORAGE, locations);
            npc.destroy();
            String NPC_REMOVED = "Â§câ–ª Â§bThe target NPC was removed!";
            p.sendMessage(NPC_REMOVED);
        } else {
            for (BaseComponent bc : MAIN_USAGE){
                p.spigot().sendMessage(bc);
            }
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return Arrays.asList("remove", "add");
    }


    /**
     * Create an armor-stand hologram
     */
    @NotNull
    public static ArmorStand createArmorStand(Location loc) {
        ArmorStand a = loc.getWorld().spawn(loc, ArmorStand.class);
        a.setGravity(false);
        a.setVisible(false);
        a.setCustomNameVisible(false);
        a.setMarker(true);
        return a;
    }

    /**
     * Get target NPC
     */
    @Nullable
    @SuppressWarnings("WeakerAccess")
    public static net.citizensnpcs.api.npc.NPC getTarget(Player player) {

        BlockIterator iterator = new BlockIterator(player.getWorld(), player.getLocation().toVector(), player.getEyeLocation().getDirection(), 0, 100);
        while (iterator.hasNext()) {
            Block item = iterator.next();
            for (Entity entity : player.getNearbyEntities(100, 100, 100)) {
                int acc = 2;
                for (int x = -acc; x < acc; x++) {
                    for (int z = -acc; z < acc; z++) {
                        for (int y = -acc; y < acc; y++) {
                            if (entity.getLocation().getBlock().getRelative(x, y, z).equals(item)) {
                                if (entity.hasMetadata("NPC")) {
                                    net.citizensnpcs.api.npc.NPC npc = CitizensAPI.getNPCRegistry().getNPC(entity);
                                    if (npc != null) return npc;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean canSee(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (Arena.isInArena(p)) return false;

        if (SetupSession.isInSetupSession(p.getUniqueId())) return false;
        return hasPermission(s);
    }
}

