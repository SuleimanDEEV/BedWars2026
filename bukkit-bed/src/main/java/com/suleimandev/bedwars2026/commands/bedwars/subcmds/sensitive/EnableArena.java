package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import com.suleimandev.bedwars2026.configuration.Permissions;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
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

public class EnableArena extends SubCommand {

    public EnableArena(ParentCommand parent, String name) {
        super(parent, name);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " "+getSubCommandName()+" Â§6<worldName>","Â§fEnable an arena.",
                "/" + getParent().getName() + " "+getSubCommandName()+ " ", ClickEvent.Action.SUGGEST_COMMAND));
        showInList(true);
        setPriority(5);
        setPermission(Permissions.PERMISSION_ARENA_ENABLE);
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (!MainCommand.isLobbySet(p)) return true;
        if (args.length != 1) {
            p.sendMessage("Â§câ–ª Â§7Usage: Â§o/" + getParent().getName() + " enableRotation <mapName>");
            return true;
        }
        if (!BukkitBedPlugin.getAPI().getRestoreAdapter().isWorld(args[0])) {
            p.sendMessage("Â§câ–ª Â§7" + args[0] + " doesn't exist!");
            return true;
        }

        for (IArena mm : Arena.getEnableQueue()){
            if (mm.getArenaName().equalsIgnoreCase(args[0])){
                p.sendMessage("Â§câ–ª Â§7This arena is already in the enable queue!");
                return true;
            }
        }

        IArena aa = Arena.getArenaByName(args[0]);
        if (aa != null) {
            p.sendMessage("Â§câ–ª Â§7This arena is already enabled!");
            return true;
        }
        p.sendMessage("Â§6 â–ª Â§7Enabling arena...");
        new Arena(args[0], p);
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        List<String> tab = new ArrayList<>();
        File dir = new File(plugin.getDataFolder(), "/Arenas");
        if (dir.exists()) {
            File[] fls = dir.listFiles();
            for (File fl : Objects.requireNonNull(fls)) {
                if (fl.isFile()) {
                    if (fl.getName().contains(".yml")) {
                        tab.add(fl.getName().replace(".yml", ""));
                    }
                }
            }
        }
        return tab;
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

