package com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive;

import com.suleimandev.bedwars2026.api.CommonsBedApi;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.Misc;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import com.suleimandev.bedwars2026.configuration.Permissions;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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

public class Reload extends SubCommand {

    public Reload(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(11);
        showInList(true);
        setPermission(Permissions.PERMISSION_RELOAD);
        setDisplayInfo(Misc.msgHoverClick("Â§6 â–ª Â§7/" + getParent().getName() + " "+getSubCommandName()+"       Â§8 - Â§ereload messages",
                "Â§fReload messages.\nÂ§cNot recommended!", "/"+ getParent().getName() + " "+getSubCommandName(), ClickEvent.Action.RUN_COMMAND));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof Player) {
            if (!MainCommand.isLobbySet((Player) s)) return true;
        } else {
            if (!MainCommand.isLobbySet(null)) return true;
        }
        for (Language l : Language.getLanguages()){
            l.reload();
            s.sendMessage("Â§6 â–ª Â§7"+l.getLangName()+" reloaded!");
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        return null;
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
}

