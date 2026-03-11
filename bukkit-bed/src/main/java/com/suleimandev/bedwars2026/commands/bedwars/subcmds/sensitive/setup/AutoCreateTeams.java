package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.team.TeamColor;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.server.SetupType;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.Permissions;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.HashMap;
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

public class AutoCreateTeams extends SubCommand {

    public AutoCreateTeams(ParentCommand parent, String name) {
        super(parent, name);
        setArenaSetupCommand(true);
        setPermission(Permissions.PERMISSION_SETUP_ARENA);
    }

    private static HashMap<Player, Long> timeOut = new HashMap<>();
    private static HashMap<Player, List<Byte>> teamsFoundOld = new HashMap<>();
    private static HashMap<Player, List<String>> teamsFound13 = new HashMap<>();

    @SuppressWarnings("deprecation")
    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        SetupSession ss = SetupSession.getSession(p.getUniqueId());
        if (ss == null) {
            s.sendMessage("Ãƒâ€šÃ‚Â§c ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7You're not in a setup session!");
            return true;
        }
        if (ss.getSetupType() == SetupType.ASSISTED) {
            if (is13Higher()) {
                if (timeOut.containsKey(p) && timeOut.get(p) >= System.currentTimeMillis() && teamsFound13.containsKey(p)) {
                    for (String tf : teamsFound13.get(p)) {
                        Bukkit.dispatchCommand(s, BukkitBedPlugin.mainCmd + " createTeam " + TeamColor.enName(tf) + " " + TeamColor.enName(tf));
                    }
                    if (ss.getConfig().getYml().get("waiting.Pos1") == null) {
                        s.sendMessage("");
                        s.sendMessage("Ãƒâ€šÃ‚Â§6Ãƒâ€šÃ‚Â§lWAITING LOBBY REMOVAL:");
                        s.sendMessage("Ãƒâ€šÃ‚Â§fIf you'd like the lobby to disappear when the game starts,");
                        s.sendMessage("Ãƒâ€šÃ‚Â§fplease use the following commands like a world edit selection.");
                        p.spigot().sendMessage(Misc.msgHoverClick("Ãƒâ€šÃ‚Â§c ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7/" + BukkitBedPlugin.mainCmd + " waitingPos 1", "Ãƒâ€šÃ‚Â§dSet pos 1", "/" + getParent().getName() + " waitingPos 1", ClickEvent.Action.RUN_COMMAND));
                        p.spigot().sendMessage(Misc.msgHoverClick("Ãƒâ€šÃ‚Â§c ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7/" + BukkitBedPlugin.mainCmd + " waitingPos 2", "Ãƒâ€šÃ‚Â§dSet pos 2", "/" + getParent().getName() + " waitingPos 2", ClickEvent.Action.RUN_COMMAND));
                        s.sendMessage("");
                        s.sendMessage("Ãƒâ€šÃ‚Â§7This step is OPTIONAL. If you wan to skip it do Ãƒâ€šÃ‚Â§6/" + BukkitBedPlugin.mainCmd);
                    }
                    return true;
                }
                List<String> found = new ArrayList<>();
                World w = p.getWorld();
                if (ss.getConfig().getYml().get("Team") == null) {
                    p.sendMessage("Ãƒâ€šÃ‚Â§6 ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7Searching for teams. This may cause lag.");
                    for (int x = -200; x < 200; x++) {
                        for (int y = 50; y < 130; y++) {
                            for (int z = -200; z < 200; z++) {
                                Block b = new Location(w, x, y, z).getBlock();
                                if (b.getType().toString().contains("_WOOL")) {
                                    if (!found.contains(b.getType().toString())) {
                                        int count = 0;
                                        for (int x1 = -2; x1 < 2; x1++) {
                                            for (int y1 = -2; y1 < 2; y1++) {
                                                for (int z1 = -2; z1 < 2; z1++) {
                                                    Block b2 = new Location(w, x, y, z).getBlock();
                                                    if (b2.getType() == b.getType()) {
                                                        count++;
                                                    }
                                                }
                                            }
                                        }
                                        if (count >= 5) {
                                            if (!TeamColor.enName(b.getType().toString()).isEmpty()) {
                                                if (ss.getConfig().getYml().get("Team." + TeamColor.enName(b.getType().toString())) == null) {
                                                    found.add(b.getType().toString());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (found.isEmpty()) {
                    p.sendMessage("Ãƒâ€šÃ‚Â§6 ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7No new teams were found.\nÃƒâ€šÃ‚Â§6 ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7Manually create teams with: Ãƒâ€šÃ‚Â§6/" + BukkitBedPlugin.mainCmd + " createTeam");
                } else {
                    if (timeOut.containsKey(p)) {
                        p.sendMessage("Ãƒâ€šÃ‚Â§c ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7Time out. Type again to search for teams.");
                        timeOut.remove(p);
                        return true;
                    } else {
                        timeOut.put(p, System.currentTimeMillis() + 16000);
                    }
                    if (teamsFound13.containsKey(p)) {
                        teamsFound13.replace(p, found);
                    } else {
                        teamsFound13.put(p, found);
                    }
                    p.sendMessage("Ãƒâ€šÃ‚Â§6Ãƒâ€šÃ‚Â§lNEW TEAMS FOUND:");
                    for (String tf : found) {
                        String name = TeamColor.enName(tf);
                        p.sendMessage("Ãƒâ€šÃ‚Â§f ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª " + TeamColor.getChatColor(name) + name.replace("_", " "));
                    }
                    p.spigot().sendMessage(Misc.msgHoverClick("Ãƒâ€šÃ‚Â§6 ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7Ãƒâ€šÃ‚Â§lClick here to create found teams.", "Ãƒâ€šÃ‚Â§fClick to create found teams!", "/" + getParent().getName() + " " + getSubCommandName(), ClickEvent.Action.RUN_COMMAND));
                }
            } else {
                if (timeOut.containsKey(p) && timeOut.get(p) >= System.currentTimeMillis() && teamsFoundOld.containsKey(p)) {
                    for (Byte tf : teamsFoundOld.get(p)) {
                        Bukkit.dispatchCommand(s, BukkitBedPlugin.mainCmd + " createTeam " + TeamColor.enName(tf) + " " + TeamColor.enName(tf));
                    }
                    if (ss.getConfig().getYml().get("waiting.Pos1") == null) {
                        s.sendMessage("");
                        s.sendMessage("Ãƒâ€šÃ‚Â§6Ãƒâ€šÃ‚Â§lWAITING LOBBY REMOVAL:");
                        s.sendMessage("Ãƒâ€šÃ‚Â§fIf you'd like the lobby to disappear when the game starts,");
                        s.sendMessage("Ãƒâ€šÃ‚Â§fplease use the following commands like a world edit selection.");
                        p.spigot().sendMessage(Misc.msgHoverClick("Ãƒâ€šÃ‚Â§c ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7/" + BukkitBedPlugin.mainCmd + " waitingPos 1", "Ãƒâ€šÃ‚Â§dSet pos 1", "/" + getParent().getName() + " waitingPos 1", ClickEvent.Action.RUN_COMMAND));
                        p.spigot().sendMessage(Misc.msgHoverClick("Ãƒâ€šÃ‚Â§c ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7/" + BukkitBedPlugin.mainCmd + " waitingPos 2", "Ãƒâ€šÃ‚Â§dSet pos 2", "/" + getParent().getName() + " waitingPos 2", ClickEvent.Action.RUN_COMMAND));
                        s.sendMessage("");
                        s.sendMessage("Ãƒâ€šÃ‚Â§7This step is OPTIONAL. If you wan to skip it do Ãƒâ€šÃ‚Â§6/" + BukkitBedPlugin.mainCmd);
                    }
                    return true;
                }
                List<Byte> found = new ArrayList<>();
                World w = p.getWorld();
                if (ss.getConfig().getYml().get("Team") == null) {
                    p.sendMessage("Ãƒâ€šÃ‚Â§6 ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7Searching for teams. This may cause lag.");
                    for (int x = -200; x < 200; x++) {
                        for (int y = 50; y < 130; y++) {
                            for (int z = -200; z < 200; z++) {
                                Block b = new Location(w, x, y, z).getBlock();
                                if (b.getType() == Material.valueOf("WOOL")) {
                                    if (!found.contains(b.getData())) {
                                        int count = 0;
                                        for (int x1 = -2; x1 < 2; x1++) {
                                            for (int y1 = -2; y1 < 2; y1++) {
                                                for (int z1 = -2; z1 < 2; z1++) {
                                                    Block b2 = new Location(w, x, y, z).getBlock();
                                                    if (b2.getType() == b.getType()) {
                                                        if (b.getData() == b2.getData()) {
                                                            count++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (count >= 5) {
                                            if (!TeamColor.enName(b.getData()).isEmpty()) {
                                                if (ss.getConfig().getYml().get("Team." + TeamColor.enName(b.getData())) == null) {
                                                    found.add(b.getData());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (found.isEmpty()) {
                    p.sendMessage("Ãƒâ€šÃ‚Â§6 ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7No new teams were found.\nÃƒâ€šÃ‚Â§6 ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7Manually create teams with: Ãƒâ€šÃ‚Â§6/" + BukkitBedPlugin.mainCmd + " createTeam");
                } else {
                    if (timeOut.containsKey(p)) {
                        p.sendMessage("Ãƒâ€šÃ‚Â§c ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7Time out. Type again to search for teams.");
                        timeOut.remove(p);
                        return true;
                    } else {
                        timeOut.put(p, System.currentTimeMillis() + 16000);
                    }
                    if (teamsFoundOld.containsKey(p)) {
                        teamsFoundOld.replace(p, found);
                    } else {
                        teamsFoundOld.put(p, found);
                    }
                    p.sendMessage("Ãƒâ€šÃ‚Â§6Ãƒâ€šÃ‚Â§lNEW TEAMS FOUND:");
                    for (Byte tf : found) {
                        String name = TeamColor.enName(tf);
                        p.sendMessage("Ãƒâ€šÃ‚Â§f ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª " + TeamColor.getChatColor(name) + name.replace('_', ' '));
                    }
                    p.spigot().sendMessage(Misc.msgHoverClick("Ãƒâ€šÃ‚Â§6 ÃƒÂ¢Ã¢â‚¬â€œÃ‚Âª Ãƒâ€šÃ‚Â§7Ãƒâ€šÃ‚Â§lClick here to create found teams.", "Ãƒâ€šÃ‚Â§fClick to create found teams!", "/" + getParent().getName() + " " + getSubCommandName(), ClickEvent.Action.RUN_COMMAND));
                }
            }
        } else return false;
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return null;
    }

    /**
     * Check if server version is 1.13 or higher
     */
    public static boolean is13Higher() {
        return !(BukkitBedPlugin.getServerVersion().equals("v1_8_R3") || BukkitBedPlugin.getServerVersion().equals("v1_12_R1"));
    }

    @Override
    public boolean canSee(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (!SetupSession.isInSetupSession(p.getUniqueId())) return false;

        return hasPermission(s);
    }
}

