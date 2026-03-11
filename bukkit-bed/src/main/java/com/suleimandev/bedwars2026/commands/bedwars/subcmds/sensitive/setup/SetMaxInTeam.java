package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup;

import com.suleimandev.bedwars2026.api.CommonsBedApi;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.configuration.Permissions;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
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

public class SetMaxInTeam extends SubCommand {

    public SetMaxInTeam(ParentCommand parent, String name) {
        super(parent, name);
        setArenaSetupCommand(true);
        setPermission(Permissions.PERMISSION_SETUP_ARENA);
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        SetupSession ss = SetupSession.getSession(p.getUniqueId());
        if (ss == null){
            s.sendMessage("Â§c â–ª Â§7You're not in a setup session!");
            return true;
        }
        if (args.length == 0) {
            p.sendMessage("Â§câ–ª Â§7Usage: /" + mainCmd + " setMaxInTeam <int>");
        } else {
            try {
                Integer.parseInt(args[0]);
            } catch (Exception ex) {
                p.sendMessage("Â§câ–ª Â§7Usage: /" + mainCmd + " setMaxInTeam <int>");
                return true;
            }
            ss.getConfig().set("maxInTeam", Integer.valueOf(args[0]));
            p.sendMessage("Â§6 â–ª Â§7Max in team set!");
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return Arrays.asList("1", "2", "4");
    }

    @Override
    public boolean canSee(CommandSender s, CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (!SetupSession.isInSetupSession(p.getUniqueId())) return false;

        return hasPermission(s);
    }
}

