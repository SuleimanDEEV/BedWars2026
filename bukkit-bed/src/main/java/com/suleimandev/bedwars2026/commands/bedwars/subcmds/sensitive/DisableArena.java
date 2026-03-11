package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.arena.GameState;
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
import java.util.ArrayList;
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

public class DisableArena extends SubCommand {

    public DisableArena(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(6);
        showInList(true);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " "+getSubCommandName()+" Â§6<worldName>", "Â§fDisable an arena.\nThis will remove the players \nÂ§ffrom the arena before disabling.",
                "/" + getParent().getName() + " "+getSubCommandName()+" ", ClickEvent.Action.SUGGEST_COMMAND));
        setPermission(Permissions.PERMISSION_ARENA_DISABLE);
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (!MainCommand.isLobbySet(p)) return true;
        if (args.length != 1) {
            p.sendMessage("Â§câ–ª Â§7Usage: Â§o/" + getParent().getName() + " "+getSubCommandName()+" <mapName>");
            return true;
        }
        if (!BukkitBedPlugin.getAPI().getRestoreAdapter().isWorld(args[0])) {
            p.sendMessage("Â§câ–ª Â§7" + args[0] + " doesn't exist!");
            return true;
        }
        IArena a = Arena.getArenaByName(args[0]);
        if (a == null) {
            p.sendMessage("Â§câ–ª Â§7This arena is disabled yet!");
            return true;
        }
        if (a.getStatus() == GameState.playing) {
            p.sendMessage("Â§6 â–ª Â§7There is a game running on this Arena, please disable after the game!");
            return true;
        }
        p.sendMessage("Â§6 â–ª Â§7Disabling arena...");
        a.disable();
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        List<String> tab = new ArrayList<>();
        for (IArena a : Arena.getArenas()){
            tab.add(a.getArenaName());
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

