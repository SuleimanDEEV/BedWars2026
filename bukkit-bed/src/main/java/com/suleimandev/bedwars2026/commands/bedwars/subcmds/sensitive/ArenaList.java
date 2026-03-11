package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive;

import com.suleimandev.bedwars2026.api.CommonsBedApi;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.plugin;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class ArenaList extends SubCommand {

    private static final int ARENAS_PER_PAGE = 10;

    public ArenaList(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(3);
        showInList(true);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/" + MainCommand.getInstance().getName() + " " + getSubCommandName() + ((getArenas().size() == 0) ? " Â§c(0 set)" : " Â§a(" + getArenas().size() + " set)"),
                "Â§fShow available arenas", "/" + MainCommand.getInstance().getName() + " " + getSubCommandName(), ClickEvent.Action.RUN_COMMAND));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;


        int page = 1;
        if (args.length >= 1) {
            try {
                page = Integer.parseInt(args[0]);
                if (page < 0) {
                    page = 1;
                }
            } catch (Exception ignored) {
            }
        }
        int start = (page - 1) * ARENAS_PER_PAGE;
        List<IArena> arenas = new ArrayList<>(Arena.getArenas());
        if (arenas.size() <= start){
            page = 1;
            start = 0;
        }

        p.sendMessage(color(" \n&1|| &3" + plugin.getName() + "&7 Instantiated games: \n "));

        if (arenas.isEmpty()) {
            p.sendMessage(ChatColor.RED + "No arenas to display.");
            return true;
        }

        int limit = Math.min(arenas.size(), start + ARENAS_PER_PAGE);

        arenas.subList(start, limit).forEach(arena -> {
            String gameState = arena.getDisplayStatus(Language.getPlayerLanguage(p));
            String msg = color(
                    "ID: &e" + arena.getWorldName() +
                            " &fG: &e" + arena.getDisplayGroup(p) +
                            " &fP: &e" + (arena.getPlayers().size() + arena.getSpectators().size()) +
                            " &fS: " + gameState +
                            " &fWl: &e" + (Bukkit.getWorld(arena.getWorldName()) != null)
            );


            p.sendMessage(msg);
        });

        p.sendMessage(" ");

        if (arenas.size() > ARENAS_PER_PAGE * page) {
            p.sendMessage(ChatColor.GRAY + "Type /" + ChatColor.GREEN + MainCommand.getInstance().getName() + " arenaList " + ++page + ChatColor.GRAY + " for next page.");
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return null;
    }

    @NotNull
    private java.util.List<String> getArenas() {
        ArrayList<String> arene = new ArrayList<>();
        File dir = new File(plugin.getDataFolder(), "/Arenas");
        if (dir.exists()) {
            for (File f : Objects.requireNonNull(dir.listFiles())) {
                if (f.isFile()) {
                    if (f.getName().contains(".yml")) {
                        arene.add(f.getName().replace(".yml", ""));
                    }
                }
            }
        }
        return arene;
    }

    @Override
    public boolean canSee(CommandSender s, CommonsBedApi api) {

        if (s instanceof Player) {
            Player p = (Player) s;
            if (Arena.isInArena(p)) return false;

            if (SetupSession.isInSetupSession(p.getUniqueId())) return false;
        }

        return hasPermission(s);
    }

    private static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

