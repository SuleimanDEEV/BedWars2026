package com.suleimandev.bedwars2026.commands.bedwars;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.command.SubCommand;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import com.suleimandev.bedwars2026.api.server.ServerType;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.subcmds.regular.*;
import com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.Level;
import com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.*;
import com.suleimandev.bedwars2026.commands.bedwars.subcmds.sensitive.setup.*;
import com.suleimandev.bedwars2026.support.citizens.JoinNPC;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.suleimandev.bedwars2026.BukkitBedPlugin.*;
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

public class MainCommand extends BukkitCommand implements ParentCommand {

    /* SubCommands ArenaList */
    private static List<SubCommand> subCommandList = new ArrayList<>();
    /* MainCommand instance*/
    private static MainCommand instance;
    /* Dot char */
    @SuppressWarnings("WeakerAccess")
    public static char dot = 254;

    public MainCommand(String name) {
        super(name);
        setAliases(Arrays.asList("bedwars", "bedwars2026"));
        instance = this;
        new CmdJoin(this, "join");
        new CmdLeave(this, "leave");
        new CmdLang(this, "lang");
        new CmdTeleporter(this, "teleporter");
        if (getServerType() != ServerType.BUNGEE) {
            new CmdGUI(this, "gui");
        }
        new CmdStats(this, "stats");
        new CmdStart(this, "forceStart");
        new CmdStart(this, "start");
        if (BukkitBedPlugin.getServerType() != ServerType.BUNGEE) {
            new SetLobby(this, "setLobby"); //priority 1
        }
        new SetupArena(this, "setupArena"); //priority 2
        new ArenaList(this, "arenaList"); //priority 3
        new DelArena(this, "delArena"); //priority 4
        new EnableArena(this, "enableArena"); //priority 5
        new DisableArena(this, "disableArena"); //priority 6
        new CloneArena(this, "cloneArena"); //priority 7
        new ArenaGroup(this, "arenaGroup"); //priority 8
        new Build(this, "build"); //priority 9
        new Level(this, "level");
        new Reload(this, "reload"); //priority 11
        new CmdList(this, "cmds"); //priority 20

        /* Arena setup commands (in world) */
        new AutoCreateTeams(this, "autoCreateTeams");
        new SetWaitingSpawn(this, "setWaitingSpawn");
        new SetSpectatorPos(this, "setSpectSpawn");
        new CreateTeam(this, "createTeam");
        new WaitingPos(this, "waitingPos");
        new RemoveTeam(this, "removeTeam");
        new SetMaxInTeam(this, "setMaxInTeam");
        new SetBuildHeight(this, "setMaxBuildHeight");
        new SetSpawn(this, "setSpawn");
        new SetBed(this, "setBed");
        new SetShop(this, "setShop");
        new SetUpgrade(this, "setUpgrade");
        new AddGenerator(this, "addGenerator");
        new RemoveGenerator(this, "removeGenerator");
        new SetType(this, "setType");
        new Save(this, "save");
        if (JoinNPC.isCitizensSupport() && BukkitBedPlugin.getServerType() != ServerType.BUNGEE) {
            new NPC(this, "npc");
        }
        new CmdTpStaff(this, "tp");
        new CmdUpgrades(this, "upgradesmenu");
        new SetKillDropsLoc(this, "setKillDrops");
    }

    @Override
    public boolean execute(CommandSender s, String st, String[] args) {

        if (args.length == 0) {
            /* Set op commands*/
            if ((s.isOp() || s.hasPermission(BukkitBedPlugin.mainCmd + ".*"))) {
                if (s instanceof Player) {
                    if (SetupSession.isInSetupSession(((Player) s).getUniqueId())) {
                        Bukkit.dispatchCommand(s, getName() + " cmds");
                    } else {
                        s.sendMessage("");
                        s.sendMessage("Â§8Â§l" + dot + " Â§6" + plugin.getDescription().getName() + " v" + plugin.getDescription().getVersion() + " Â§7- Â§c Admin Commands");
                        s.sendMessage("");
                        sendSubCommands((Player) s);
                    }
                } else {
                    s.sendMessage("Â§f   bw safemode Â§eenable/ disable");
                }
            } else {
                if (s instanceof ConsoleCommandSender) {
                    s.sendMessage("Â§fNo console commands available atm.");
                    return true;
                }
                /* Send player commands */
                Bukkit.dispatchCommand(s, mainCmd + " cmds");
            }
            return true;
        }

        boolean commandFound = false;
        for (SubCommand sb : getSubCommands()) {
            if (sb.getSubCommandName().equalsIgnoreCase(args[0])) {
                if (sb.hasPermission(s)) {
                    commandFound = sb.execute(Arrays.copyOfRange(args, 1, args.length), s);
                }
            }
        }

        if (!commandFound) {
            if (s instanceof Player) {
                s.sendMessage(getMsg((Player) s, Messages.COMMAND_NOT_FOUND_OR_INSUFF_PERMS));
            } else {
                s.sendMessage(Language.getDefaultLanguage().m(Messages.COMMAND_NOT_FOUND_OR_INSUFF_PERMS));
            }
        }
        return true;
    }

    public static boolean isArenaGroup(String var) {
        if (config.getYml().get("arenaGroups") != null) {
            return config.getYml().getStringList("arenaGroups").contains(var);
        }
        return var.equalsIgnoreCase("default");
    }

    public static TextComponent createTC(String text, String suggest, String shot_text) {
        TextComponent tx = new TextComponent(text);
        tx.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, suggest));
        tx.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(shot_text).create()));
        return tx;
    }

    @Override
    public void addSubCommand(SubCommand subCommand) {
        subCommandList.add(subCommand);
    }

    @Override
    public void sendSubCommands(Player p) {
        for (int i = 0; i <= 20; i++) {
            for (SubCommand sb : getSubCommands()) {
                if (sb.getPriority() == i && sb.isShow() && sb.canSee(p, BukkitBedPlugin.getAPI())) {
                    p.spigot().sendMessage(sb.getDisplayInfo());
                }
            }
        }
    }

    public List<String> tabComplete(CommandSender s, String alias, String[] args, Location location) throws IllegalArgumentException {
        if (args.length == 1) {
            List<String> sub = new ArrayList<>();
            for (SubCommand sb : getSubCommands()) {
                if (sb.canSee(s, BukkitBedPlugin.getAPI())) sub.add(sb.getSubCommandName());
            }
            return sub;
        } else if (args.length == 2) {
            if (hasSubCommand(args[0])) {
                if (getSubCommand(args[0]).canSee(s, BukkitBedPlugin.getAPI()))
                    return getSubCommand(args[0]).getTabComplete();
            }
        }
        return null;
    }


    @Override
    public List<SubCommand> getSubCommands() {
        return subCommandList;
    }

    /**
     * Get instance
     */
    public static MainCommand getInstance() {
        return instance;
    }

    /**
     * Check if lobby location is set, else send a error message to the player
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean isLobbySet(Player p) {
        if (BukkitBedPlugin.getServerType() == ServerType.BUNGEE) return true;
        if (config.getLobbyWorldName().isEmpty()) {
            if (p != null) {
                p.sendMessage("Â§câ–ª Â§7You have to set the lobby location first!");
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean hasSubCommand(String name) {
        for (SubCommand sc : getSubCommands()) {
            if (sc.getSubCommandName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get sub-command by name
     */
    @SuppressWarnings("WeakerAccess")
    public SubCommand getSubCommand(String name) {
        for (SubCommand sc : getSubCommands()) {
            if (sc.getSubCommandName().equalsIgnoreCase(name)) {
                return sc;
            }
        }
        return null;
    }

    /**
     * Get a dot symbol
     */
    public static char getDot() {
        return dot;
    }
}

