package com.suleimandev.bedwars2026.commands.rejoin;

import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.ReJoin;
import com.suleimandev.bedwars2026.configuration.Permissions;
import com.suleimandev.bedwars2026.configuration.Sounds;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class RejoinCommand extends BukkitCommand {

    public RejoinCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender s, String st, String[] args) {
        if (s instanceof ConsoleCommandSender) {
            s.sendMessage("This command is for players!");
            return true;
        }

        Player p = (Player) s;

        if (!p.hasPermission(Permissions.PERMISSION_REJOIN)) {
            p.sendMessage(Language.getMsg(p, Messages.COMMAND_NOT_FOUND_OR_INSUFF_PERMS));
            return true;
        }

        ReJoin rj = ReJoin.getPlayer(p);

        if (rj == null) {
            p.sendMessage(Language.getMsg(p, Messages.REJOIN_NO_ARENA));
            Sounds.playSound("rejoin-denied", p);
            return true;
        }

        if (!rj.canReJoin()) {
            p.sendMessage(Language.getMsg(p, Messages.REJOIN_DENIED));
            Sounds.playSound("rejoin-denied", p);
            return true;
        }

        p.sendMessage(Language.getMsg(p, Messages.REJOIN_ALLOWED).replace("{arena}", rj.getArena().getDisplayName()));
        Sounds.playSound("rejoin-allowed", p);
        rj.reJoin(p);
        return true;
    }
}

