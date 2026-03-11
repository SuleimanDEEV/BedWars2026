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
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.List;
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

public class SetupArena extends SubCommand {

    public SetupArena(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(2);
        setDisplayInfo(Misc.msgHoverClick("Ã‚Â§6 Ã¢â€“Âª Ã‚Â§7/" + MainCommand.getInstance().getName() + " setupArena Ã‚Â§6<worldName>", "Ã‚Â§fCreate or edit an arena.\n'_'*'-'*'s name.",
                "/" + MainCommand.getInstance().getName() + " setupArena ", ClickEvent.Action.SUGGEST_COMMAND));
        showInList(true);
        setPermission(Permissions.PERMISSION_SETUP_ARENA);
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (!MainCommand.isLobbySet(p)) return true;
        if (args.length != 1) {
            p.sendMessage("Ã‚Â§cÃ¢â€“Âª Ã‚Â§7Usage: Ã‚Â§o/" + getParent().getName() + " " + getSubCommandName() + " <mapName>");
            return true;
        }
        if (!args[0].equals(args[0].toLowerCase())) {
            p.sendMessage("Ã‚Â§cÃ¢â€“Âª Ã‚Â§c" + args[0] + ChatColor.GRAY + " mustn't contain capital letters! Rename your folder to: " + ChatColor.GREEN + args[0].toLowerCase());
            return true;
        }
        if (args[0].contains("+")) {
            p.sendMessage("Ã‚Â§cÃ¢â€“Âª Ã‚Â§7" + args[0] + " mustn't contain this symbol: " + ChatColor.RED + "+");
            return true;
        }
        //if (!BukkitBedPlugin.getAPI().getRestoreAdapter().isWorld(args[0])) {
        //    p.sendMessage("Ã‚Â§cÃ¢â€“Âª Ã‚Â§7" + args[0] + " doesn't exist!");
        //    return true;
        //}
        if (getArenaByName(args[0]) != null && !BukkitBedPlugin.autoscale) {
            p.sendMessage("Ã‚Â§cÃ¢â€“Âª Ã‚Â§7Please disable it first!");
            return true;
        }
        if (SetupSession.isInSetupSession(p.getUniqueId())) {
            p.sendMessage("Ã‚Â§c Ã¢â€“Âª Ã‚Â§7You're already in a setup session!");
            return true;
        }
        new SetupSession(p, args[0]);
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return BukkitBedPlugin.getAPI().getRestoreAdapter().getWorldsList();
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

