package com.suleimandev.bedwars2026.commands.bedwars.subcmds.regular;

import com.suleimandev.bedwars2026.api.CommonsBedApi;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.plugin;
import static com.suleimandev.bedwars2026.api.language.Language.getMsg;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class CmdLang extends SubCommand {

    public CmdLang(ParentCommand parent, String name) {
        super(parent, name);
        setPriority(18);
        showInList(false);
        setDisplayInfo(MainCommand.createTC("Â§6 â–ª Â§7/" + MainCommand.getInstance().getName() + " " + getSubCommandName(), "/" + getParent().getName() + " " + getSubCommandName(), "Â§fChange your language."));
    }

    @Override
    public boolean execute(String[] args, CommandSender s) {
        if (s instanceof ConsoleCommandSender) return false;
        Player p = (Player) s;
        if (Arena.getArenaByPlayer(p) != null) return false;
        if (args.length == 0) {
            p.sendMessage(getMsg(p, Messages.COMMAND_LANG_LIST_HEADER));
            for (Language l : Language.getLanguages()) {
                p.sendMessage(getMsg(p, Messages.COMMAND_LANG_LIST_FORMAT).replace("{iso}", l.getIso()).replace("{name}", l.getLangName()));
            }
            p.sendMessage(getMsg(p, Messages.COMMAND_LANG_USAGE));
            return true;
        } else if (Language.isLanguageExist(args[0])) {
            if (Arena.getArenaByPlayer(p) == null) {
                if (Language.setPlayerLanguage(p.getUniqueId(), args[0])) {
                    Bukkit.getScheduler().runTaskLater(plugin, () -> p.sendMessage(getMsg(p, Messages.COMMAND_LANG_SELECTED_SUCCESSFULLY)), 3L);
                } else {
                    p.sendMessage(getMsg(p, Messages.COMMAND_LANG_LIST_HEADER));
                    for (Language l : Language.getLanguages()) {
                        p.sendMessage(getMsg(p, Messages.COMMAND_LANG_LIST_FORMAT).replace("{iso}", l.getIso()).replace("{name}", l.getLangName()));
                    }
                    p.sendMessage(getMsg(p, Messages.COMMAND_LANG_USAGE));
                    return true;
                }
            } else {
                p.sendMessage(getMsg(p, Messages.COMMAND_LANG_USAGE_DENIED));
            }
        } else {
            p.sendMessage(getMsg(p, Messages.COMMAND_LANG_SELECTED_NOT_EXIST));
        }
        return true;
    }

    @Override
    public List<String> getTabComplete() {
        List<String> tab = new ArrayList<>();
        for (Language lang : Language.getLanguages()) {
            tab.add(lang.getIso());
        }
        return tab;
    }

    @Override
    public boolean canSee(CommandSender s, CommonsBedApi api) {
        if (s instanceof ConsoleCommandSender) return false;

        Player p = (Player) s;
        if (Arena.isInArena(p)) return false;

        if (SetupSession.isInSetupSession(p.getUniqueId())) return false;
        return hasPermission(s);
    }
}

