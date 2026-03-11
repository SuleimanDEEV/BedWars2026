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
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.List;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.config;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class SetLobby extends SubCommand {

    public SetLobby(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(1);
        showInList(true);
        setPermission(Permissions.PERMISSION_SETUP_ARENA);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/"+MainCommand.getInstance().getName()+" "+getSubCommandName()+ (config.getLobbyWorldName().isEmpty() ? " Â§c(not set)" : " Â§a(set)"),
                "Â§aSet the main lobby. Â§fThis is required but\nÂ§fif you are going to use the server in Â§eBUNGEE Â§fmode\nÂ§fthe lobby location will Â§enot Â§fbe used.\nÂ§eType again to replace the old spawn location.",
                "/"+getParent().getName()+" "+getSubCommandName(), ClickEvent.Action.RUN_COMMAND));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (SetupSession.isInSetupSession(p.getUniqueId())){
            p.sendMessage("Â§6 â–ª Â§4This command can't be used in arenas. It is meant for the main lobby!");
            return true;
        }
        config.saveConfigLoc("lobbyLoc", p.getLocation());
        p.sendMessage("Â§6 â–ª Â§7Lobby location set!");
        config.reload();
        BukkitBedPlugin.setLobbyWorld(p.getLocation().getWorld().getName());
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return null;
    }

    @Override
    public boolean canSee(CommandSender s, com.suleimandev.bedwars2026.api.CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (Arena.isInArena(p)) return false;

        if (SetupSession.isInSetupSession(p.getUniqueId())) return false;

        if (!BukkitBedPlugin.getLobbyWorld().isEmpty()) return false;

        return hasPermission(s);
    }
}

