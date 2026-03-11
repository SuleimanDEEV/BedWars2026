package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import com.suleimandev.bedwars2026.configuration.Permissions;
import net.md_5.bungee.api.chat.ClickEvent;
import org.apache.commons.io.FileUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.plugin;
import static com.suleimandev.bedwars2026.arena.Arena.getArenaByName;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class DelArena extends SubCommand {

    private static HashMap<Player, Long> delArenaConfirm = new HashMap<>();

    public DelArena(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(4);
        showInList(true);
        setPermission(Permissions.PERMISSION_DEL_ARENA);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/" + MainCommand.getInstance().getName() + " "+getSubCommandName()+" Â§6<worldName>", "Â§fDelete a map and its configuration.",
                "/" + MainCommand.getInstance().getName() + " "+getSubCommandName(), ClickEvent.Action.SUGGEST_COMMAND));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (!MainCommand.isLobbySet(p)) return true;
        if (args.length != 1) {
            p.sendMessage("Â§câ–ª Â§7Usage: Â§o/" + MainCommand.getInstance().getName() + " delArena <mapName>");
            return true;
        }
        if (!BukkitBedPlugin.getAPI().getRestoreAdapter().isWorld(args[0])) {
            p.sendMessage("Â§câ–ª Â§7" + args[0] + " doesn't exist as a world folder!");
            return true;
        }
        if (getArenaByName(args[0]) != null) {
            p.sendMessage("Â§câ–ª Â§7Please disable it first!");
            return true;
        }
        File ac = new File(plugin.getDataFolder(), "/Arenas/" + args[0]+ ".yml");
        if (!ac.exists()) {
            p.sendMessage("Â§câ–ª Â§7This arena doesn't exist!");
            return true;
        }
        if (delArenaConfirm.containsKey(p)) {
            if (System.currentTimeMillis() - 2000 <= delArenaConfirm.get(p)) {
                BukkitBedPlugin.getAPI().getRestoreAdapter().deleteWorld(args[0]);
                FileUtils.deleteQuietly(ac);
                p.sendMessage("Â§câ–ª Â§7" + args[0] + " was deleted!");
                return true;
            }
            p.sendMessage("Â§6 â–ª Â§7Type again to confirm.");
            delArenaConfirm.replace(p, System.currentTimeMillis());
        } else {
            p.sendMessage("Â§6 â–ª Â§7Type again to confirm.");
            delArenaConfirm.put(p, System.currentTimeMillis());
        }
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

