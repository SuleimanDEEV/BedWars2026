package com.suleimandev.bedwars2026.language;

import com.suleimandev.bedwars2026.BukkitBedPlugin;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.language.Messages;
import org.bukkit.configuration.file.YamlConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

public class Russian extends Language{

    public Russian() {
        super(BukkitBedPlugin.plugin, "ru");
        YamlConfiguration yml = getYml();
        yml.addDefault(Messages.PREFIX, "");
        yml.addDefault("name", "PÃ‘Æ’Ã‘ÂÃ‘ÂÃÂºÃÂ¸ÃÂ¹");

        // this must stay here
        // move message to new path
        if (yml.get("player-die-knocked-regular") != null && yml.get(Messages.PLAYER_DIE_KNOCKED_IN_VOID_REGULAR_KILL) == null){
            yml.set(Messages.PLAYER_DIE_KNOCKED_IN_VOID_REGULAR_KILL, yml.getString("player-die-knocked-regular"));
            yml.set("player-die-knocked-regular", null);
        }
        if (yml.get("player-die-knocked-final") != null && yml.get(Messages.PLAYER_DIE_KNOCKED_IN_VOID_FINAL_KILL) == null){
            yml.set(Messages.PLAYER_DIE_KNOCKED_IN_VOID_FINAL_KILL, yml.getString("player-die-knocked-final"));
            yml.set("player-die-knocked-final", null);
        }

        yml.options().copyDefaults(true);
        yml.addDefault(Messages.COMMAND_MAIN, Arrays.asList("", "&2Ã¢â€“Âª &7/" + mainCmd + " stats", "&2Ã¢â€“Âª &7/" + mainCmd + " join &o<ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂ°/Ã‘â€šÃÂ¸ÃÂ¿>", "&2Ã¢â€“Âª &7/" + mainCmd + " leave", "&2Ã¢â€“Âª &7/" + mainCmd + " lang", "&2Ã¢â€“Âª &7/" + mainCmd + " gui", "&2Ã¢â€“Âª &7/" + mainCmd + " start &3(vip)"));
        yml.addDefault(Messages.ARENA_JOIN_VIP_KICK, "{prefix}&cÃËœÃÂ·ÃÂ²ÃÂ¸ÃÂ½ÃÂ¸Ã‘â€šÃÂµ, ÃÂ½ÃÂ¾ ÃÂ²ÃÂ°Ã‘Â ÃÂ²Ã‘â€¹ÃÂ³ÃÂ½ÃÂ°ÃÂ»ÃÂ¸, ÃÂ¿ÃÂ¾Ã‘â€šÃÂ¾ÃÂ¼Ã‘Æ’ Ã‘â€¡Ã‘â€šÃÂ¾ ÃÂº ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂµ ÃÂ¿Ã‘â‚¬ÃÂ¸Ã‘ÂÃÂ¾ÃÂµÃÂ´ÃÂ¸ÃÂ½ÃÂ¸ÃÂ»Ã‘ÂÃ‘Â ÃÂ´ÃÂ¾ÃÂ½ÃÂ°Ã‘â€šÃÂµÃ‘â‚¬.\n&aÃÂ§Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ¸ÃÂ¼ÃÂµÃ‘â€šÃ‘Å’ ÃÂ±ÃÂ¾ÃÂ»Ã‘Å’Ã‘Ë†ÃÂµ ÃÂ²ÃÂ¾ÃÂ·ÃÂ¼ÃÂ¾ÃÂ¶ÃÂ½ÃÂ¾Ã‘ÂÃ‘â€šÃÂµÃÂ¹ - ÃÂºÃ‘Æ’ÃÂ¿ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ¾ÃÂ½ÃÂ°Ã‘â€š. &7&o(ÃÂ¶ÃÂ¼ÃÂ¸)");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_IS_FULL, "{prefix}&cÃÂ­Ã‘â€šÃÂ° ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂ° ÃÂ¿ÃÂ¾ÃÂ»ÃÂ½ÃÂ°Ã‘Â!\n&aÃÂ§Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ¸ÃÂ¼ÃÂµÃ‘â€šÃ‘Å’ ÃÂ±ÃÂ¾ÃÂ»Ã‘Å’Ã‘Ë†ÃÂµ ÃÂ²ÃÂ¾ÃÂ·ÃÂ¼ÃÂ¾ÃÂ¶ÃÂ½ÃÂ¾Ã‘ÂÃ‘â€šÃÂµÃÂ¹ - ÃÂºÃ‘Æ’ÃÂ¿ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ¾ÃÂ½ÃÂ°Ã‘â€š. &7&o(ÃÂ¶ÃÂ¼ÃÂ¸)");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_IS_FULL_OF_VIPS, "{prefix}&cÃÅ¸Ã‘â‚¬ÃÂ¸ÃÂ½ÃÂ¾Ã‘ÂÃÂ¸ÃÂ¼ ÃÂ¸ÃÂ·ÃÂ²ÃÂ¸ÃÂ½ÃÂµÃÂ½ÃÂ¸Ã‘Â, ÃÂ½ÃÂ¾ Ã‘ÂÃ‘â€šÃÂ° ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂ° ÃÂ¿ÃÂ¾ÃÂ»ÃÂ½ÃÂ°Ã‘Â.\n&cÃÅ“Ã‘â€¹ ÃÂ·ÃÂ½ÃÂ°ÃÂµÃÂ¼, Ã‘â€¡Ã‘â€šÃÂ¾ ÃÂ²Ã‘â€¹ Ã‘ÂÃÂ²ÃÂ»Ã‘ÂÃÂµÃ‘â€šÃÂµÃ‘ÂÃ‘Å’ ÃÂ´ÃÂ¾ÃÂ½ÃÂ°Ã‘â€šÃÂµÃ‘â‚¬ÃÂ¾ÃÂ¼, ÃÂ½ÃÂ¾ ÃÂ½ÃÂ° Ã‘ÂÃÂ°ÃÂ¼ÃÂ¾ÃÂ¼ ÃÂ´ÃÂµÃÂ»ÃÂµ Ã‘ÂÃ‘â€šÃÂ° ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂ° ÃÂ¿ÃÂ¾ÃÂ»ÃÂ½ÃÂ° Ã‘ÂÃÂ¾Ã‘â€šÃ‘â‚¬Ã‘Æ’ÃÂ´ÃÂ½ÃÂ¸ÃÂºÃÂ¾ÃÂ² ÃÂ¸/ÃÂ¸ÃÂ»ÃÂ¸ ÃÂ´ÃÂ¾ÃÂ½ÃÂ°Ã‘â€šÃÂµÃ‘â‚¬ÃÂ¾ÃÂ².");
        yml.addDefault(Messages.ARENA_START_COUNTDOWN_STOPPED_INSUFF_PLAYERS_CHAT, "{prefix}Ã‚Â§cÃÂÃÂµÃÂ´ÃÂ¾Ã‘ÂÃ‘â€šÃÂ°Ã‘â€šÃÂ¾Ã‘â€¡ÃÂ½ÃÂ¾ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ²! ÃÅ¾ÃÂ±Ã‘â‚¬ÃÂ°Ã‘â€šÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ¾Ã‘â€šÃ‘ÂÃ‘â€¡ÃÂµÃ‘â€š ÃÂ¾Ã‘ÂÃ‘â€šÃÂ°ÃÂ½ÃÂ¾ÃÂ²ÃÂ¸ÃÂ»Ã‘ÂÃ‘Â!");
        yml.addDefault(Messages.COMMAND_LEAVE_MSG, "{prefix}&e{player} ÃÂ²Ã‘â€¹Ã‘Ë†ÃÂµÃÂ» ÃÂ¸ÃÂ· ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘â€¹!");
        yml.addDefault(Messages.ARENA_RESTART_PLAYER_KICK, "{prefix}&eÃÂÃ‘â‚¬ÃÂµÃÂ½ÃÂ°, ÃÂ² ÃÂºÃÂ¾Ã‘â€šÃÂ¾Ã‘â‚¬ÃÂ¾ÃÂ¹ ÃÂ²Ã‘â€¹ ÃÂ±Ã‘â€¹ÃÂ»ÃÂ¸, ÃÂ¿ÃÂµÃ‘â‚¬ÃÂµÃÂ·ÃÂ°ÃÂ¿Ã‘Æ’Ã‘ÂÃÂºÃÂ°ÃÂµÃ‘â€šÃ‘ÂÃ‘Â.");
        yml.addDefault(Messages.ARENA_STATUS_PLAYING_NAME, "&cÃËœÃÂ´ÃÂµÃ‘â€š ÃËœÃÂ³Ã‘â‚¬ÃÂ°");
        yml.addDefault(Messages.ARENA_STATUS_RESTARTING_NAME, "&4ÃÅ¸ÃÂµÃ‘â‚¬ÃÂµÃÂ·ÃÂ°ÃÂ¿Ã‘Æ’Ã‘ÂÃÂº");
        yml.addDefault(Messages.ARENA_STATUS_WAITING_NAME, "&2ÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ Ã‚Â§c{full}");
        yml.addDefault(Messages.ARENA_STATUS_STARTING_NAME, "&6ÃÂÃÂ°Ã‘â€¡ÃÂ°ÃÂ»ÃÂ¾ Ã‚Â§c{full}");
        yml.addDefault(Messages.COMMAND_JOIN_GROUP_OR_ARENA_NOT_FOUND, "{prefix}&cÃÂÃÂµ Ã‘ÂÃ‘Æ’Ã‘â€°ÃÂµÃ‘ÂÃ‘â€šÃÂ²Ã‘Æ’ÃÂµÃ‘â€š ÃÂºÃÂ°ÃÂºÃÂ¾ÃÂ¹-ÃÂ»ÃÂ¸ÃÂ±ÃÂ¾ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½Ã‘â€¹ ÃÂ¸ÃÂ»ÃÂ¸ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½Ã‘â€¹: {name}");
        yml.addDefault(Messages.COMMAND_JOIN_NO_EMPTY_FOUND, "{prefix}&cÃÂ¡ÃÂµÃÂ¹Ã‘â€¡ÃÂ°Ã‘Â ÃÂ½ÃÂµÃ‘â€š ÃÂºÃÂ°ÃÂºÃÂ¾ÃÂ¹-ÃÂ»ÃÂ¸ÃÂ±ÃÂ¾ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½Ã‘â€¹ ;(");
        yml.addDefault(Messages.COMMAND_LEAVE_DENIED_NOT_IN_ARENA, "{prefix}&cÃÂ¢Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ½ÃÂ° ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂµ!");
        yml.addDefault(Messages.ARENA_GUI_INV_NAME, "&8Ãâ€ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Æ’ÃÂ¿ÃÂ½Ã‘â€¹ÃÂµ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½Ã‘â€¹");
        yml.addDefault(Messages.ARENA_GUI_ARENA_CONTENT_NAME, "&a&l{name}");
        yml.addDefault(Messages.ARENA_GUI_ARENA_CONTENT_LORE, Arrays.asList("", "&7ÃÂ¡Ã‘â€šÃÂ°Ã‘â€šÃ‘Æ’Ã‘Â: {status}", "&7ÃËœÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ²: &f{on}&7/&f{max}", "&7ÃÂ¢ÃÂ¸ÃÂ¿: &a{group}", "", "&aÃâ€ºÃÅ¡ÃÅ“ ÃÂ´ÃÂ»Ã‘Â ÃÂ²Ã‘â€¦ÃÂ¾ÃÂ´ÃÂ°.", "&eÃÅ¸ÃÅ¡ÃÅ“ ÃÂ´ÃÂ»Ã‘Â Ã‘ÂÃÂ»ÃÂµÃÂ¶ÃÂºÃÂ¸."));
        yml.addDefault(Messages.ARENA_GUI_SKIPPED_ITEM_NAME, "&r{serverIp}");
        yml.addDefault(Messages.ARENA_GUI_SKIPPED_ITEM_LORE, Collections.emptyList());
        yml.addDefault(Messages.COMMAND_LANG_LIST_HEADER, "{prefix} &2Ãâ€ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Æ’ÃÂ¿ÃÂ½Ã‘â€¹ÃÂµ Ã‘ÂÃÂ·Ã‘â€¹ÃÂºÃÂ¸:");
        yml.addDefault(Messages.COMMAND_LANG_LIST_FORMAT, "&aÃ¢â€“Âª  &7{iso} - &f{name}");
        yml.addDefault(Messages.COMMAND_LANG_USAGE, "{prefix}&7ÃËœÃ‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’ÃÂ¹Ã‘â€šÃÂµ: /lang &f&o<iso>");
        yml.addDefault(Messages.COMMAND_LANG_SELECTED_NOT_EXIST, "{prefix}&cÃÂ­Ã‘â€šÃÂ¾Ã‘â€š Ã‘ÂÃÂ·Ã‘â€¹ÃÂº ÃÂ½ÃÂµ Ã‘ÂÃ‘Æ’Ã‘â€°ÃÂµÃ‘ÂÃ‘â€šÃÂ²Ã‘Æ’ÃÂµÃ‘â€š!");
        yml.addDefault(Messages.COMMAND_LANG_SELECTED_SUCCESSFULLY, "{prefix}&aÃÂ¯ÃÂ·Ã‘â€¹ÃÂº Ã‘ÂÃÂ¼ÃÂµÃÂ½ÃÂµÃÂ½!");
        yml.addDefault(Messages.COMMAND_LANG_USAGE_DENIED, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ ÃÂ¸ÃÂ·ÃÂ¼ÃÂµÃÂ½ÃÂ¸Ã‘â€šÃ‘Å’ Ã‘ÂÃÂ·Ã‘â€¹ÃÂº ÃÂ²ÃÂ¾ ÃÂ²Ã‘â‚¬ÃÂµÃÂ¼Ã‘Â ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘â€¹.");
        yml.addDefault(Messages.COMMAND_TP_PLAYER_NOT_FOUND, "{prefix}&cÃËœÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº ÃÂ½ÃÂµ ÃÂ½ÃÂ°ÃÂ¹ÃÂ´ÃÂµÃÂ½!");
        yml.addDefault(Messages.COMMAND_TP_NOT_IN_ARENA, "{prefix}&cÃÂ­Ã‘â€šÃÂ¾Ã‘â€š ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº ÃÂ½ÃÂµ ÃÂ½ÃÂ° bedwars ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂµ!");
        yml.addDefault(Messages.COMMAND_TP_NOT_STARTED, "{prefix}&cÃËœÃÂ³Ã‘â‚¬ÃÂ° ÃÂ½ÃÂ° ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂµ, ÃÂ³ÃÂ´ÃÂµ ÃÂ½ÃÂ°Ã‘â€¦ÃÂ¾ÃÂ´ÃÂ¸Ã‘â€šÃ‘ÂÃ‘Â ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº, ÃÂµÃ‘â€°ÃÂµ ÃÂ½ÃÂµ ÃÂ½ÃÂ°Ã‘â€¡ÃÂ°ÃÂ»ÃÂ°Ã‘ÂÃ‘Å’!");
        yml.addDefault(Messages.COMMAND_TP_USAGE, "{prefix}&cUsage: /bw tp <ÃÂ½ÃÂ¸ÃÂº>");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_PARTY_TOO_BIG, "{prefix}&cÃâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂ¿ÃÂ°Ã‘â‚¬Ã‘â€šÃÂ¸Ã‘Â Ã‘ÂÃÂ»ÃÂ¸Ã‘Ë†ÃÂºÃÂ¾ÃÂ¼ ÃÂ²ÃÂµÃÂ»ÃÂ¸ÃÂºÃÂ° ÃÂ´ÃÂ»Ã‘Â Ã‘â€šÃÂ¾ÃÂ³ÃÂ¾, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ¿Ã‘â‚¬ÃÂ¸Ã‘ÂÃÂ¾ÃÂµÃÂ´ÃÂ¸ÃÂ½ÃÂ¸Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂº Ã‘ÂÃ‘â€šÃÂ¾ÃÂ¹ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂµ ÃÂºÃÂ°ÃÂº ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂµ :(");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_NOT_PARTY_LEADER, "{prefix}&cÃÂ¢ÃÂ¾ÃÂ»Ã‘Å’ÃÂºÃÂ¾ ÃÂ»ÃÂ¸ÃÂ´ÃÂµÃ‘â‚¬ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€š ÃÂ²Ã‘â€¹ÃÂ±Ã‘â‚¬ÃÂ°Ã‘â€šÃ‘Å’ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½Ã‘Æ’.");
        yml.addDefault(Messages.COMMAND_REJOIN_PLAYER_RECONNECTED, "{prefix}&7{player} &eÃÂ¿ÃÂµÃ‘â‚¬ÃÂµÃÂ¿ÃÂ¾ÃÂ´ÃÂºÃÂ»Ã‘Å½Ã‘â€¡ÃÂ¸ÃÂ»Ã‘ÂÃ‘Â!");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TIER, "&eÃÂ£Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂµÃÂ½Ã‘Å’ &c{tier}");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TYPE_DIAMOND, "&b&lÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TYPE_EMERALD, "&a&lÃÂ­ÃÂ¼ÃÂµÃ‘â‚¬ÃÂ°ÃÂ»Ã‘Å’ÃÂ´");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TIMER, "&eÃÂ¡ÃÂ¿ÃÂ°ÃÂ²ÃÂ½ Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ· &c{seconds} &eÃ‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´");
        yml.addDefault(Messages.COMMAND_JOIN_PLAYER_JOIN_MSG, "{prefix}&7{player} &eÃÂ²ÃÂ¾Ã‘Ë†ÃÂµÃÂ» ÃÂ² ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘Æ’ (&b{on}&e/&b{max}&e)!");
        yml.addDefault(Messages.COMMAND_LEAVE_MSG, "{prefix}&7{player} &eÃÂ²Ã‘â€¹Ã‘Ë†ÃÂµÃÂ» ÃÂ¸ÃÂ· ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘â€¹!");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CHAT, "{prefix}&eÃËœÃÂ³Ã‘â‚¬ÃÂ° ÃÂ½ÃÂ°Ã‘â€¡ÃÂ½ÃÂµÃ‘â€šÃ‘ÂÃ‘Â Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ· &6{time} &eÃ‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´!");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_TITLE, " ");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE, "&a{second}");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-5", "&eÃ¢ÂÂº");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-4", "&eÃ¢ÂÂ¹");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-3", "&cÃ¢ÂÂ¸");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-2", "&cÃ¢ÂÂ·");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-1", "&cÃ¢ÂÂ¶");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CANCELLED_TITLE, " ");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CANCELLED_SUB_TITLE, "&cÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ²..");
        yml.addDefault(Messages.FORMATTING_CHAT_LOBBY, "{level}{vPrefix}&7{player}{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_WAITING, "{level}{vPrefix}&7{player}{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_SHOUT, "{level}{vPrefix}&6[Ãâ€™ÃÂ¡Ãâ€¢ÃÅ“] {team} &7{player}&f{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_TEAM, "{level}{vPrefix}&f{team}&7 {player}{vSuffix} {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_SPECTATOR, "{level}{vPrefix}&7[ÃÂÃÂÃâ€˜Ãâ€ºÃÂ®Ãâ€ÃÂÃÂ¢Ãâ€¢Ãâ€ºÃÂ¬] {player}{vSuffix}: {message}");
        yml.addDefault(Messages.ARENA_STATUS_START_PLAYER_TUTORIAL, Arrays.asList("&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&f                                   &lBedWars", "",
                "&e&l Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€°ÃÂ°ÃÂ¹Ã‘â€šÃÂµ Ã‘ÂÃÂ²ÃÂ¾Ã‘Å½ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’ ÃÂ¸ Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂ°ÃÂ¹Ã‘â€šÃÂµ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸ ÃÂ²Ã‘â‚¬ÃÂ°ÃÂ³ÃÂ¾ÃÂ².",
                "&e&l      ÃÂ£ÃÂ»Ã‘Æ’Ã‘â€¡Ã‘Ë†ÃÂ°ÃÂ¹Ã‘â€šÃÂµ Ã‘ÂÃÂµÃÂ±Ã‘Â ÃÂ¸ Ã‘ÂÃÂ²ÃÂ¾Ã‘Å½ ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘Æ’, Ã‘ÂÃÂ¾ÃÂ±ÃÂ¸Ã‘â‚¬ÃÂ°Ã‘Â",
                "&e&l   Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ¾, Ãâ€”ÃÂ¾ÃÂ»ÃÂ¾Ã‘â€šÃÂ¾, ÃÂ­ÃÂ¼ÃÂµÃ‘â‚¬ÃÂ°ÃÂ»Ã‘Å’ÃÂ´Ã‘â€¹ ÃÂ¸ ÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·Ã‘â€¹ ÃÂ¸ÃÂ· ÃÂ³ÃÂµÃÂ½ÃÂµÃ‘â‚¬ÃÂ°Ã‘â€šÃÂ¾Ã‘â‚¬ÃÂ¾ÃÂ²",
                "&e&l     Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ´ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Æ’ÃÂ¿ ÃÂº ÃÂ¼ÃÂ¾Ã‘â€°ÃÂ½Ã‘â€¹ÃÂ¼ Ã‘Æ’ÃÂ»Ã‘Æ’Ã‘â€¡Ã‘Ë†ÃÂµÃÂ½ÃÂ¸Ã‘ÂÃÂ¼.", "",
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        yml.addDefault(Messages.MEANING_SHOUT, "shout");
        yml.addDefault(Messages.ARENA_STATUS_START_PLAYER_TITLE, "&aÃÅ¸ÃÅ¾Ãâ€œÃÂÃÂÃâ€ºÃËœ");

        // Start of Sidebar
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_WAITING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "",
                "&fÃÅ¡ÃÂ°Ã‘â‚¬Ã‘â€šÃÂ°: &a{map}",
                "",
                "&fÃËœÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ²: &a{on}/{max}",
                "",
                "&fÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ,&fÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ.,&fÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ..,&fÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ...",
                "",
                "&fÃÂ¢ÃÂ¸ÃÂ¿: &a{group}",
                "&fÃâ€™ÃÂµÃ‘â‚¬Ã‘ÂÃÂ¸Ã‘Â: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_WAITING_SPEC, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "&o&7Spectating",
                "&fÃÅ¡ÃÂ°Ã‘â‚¬Ã‘â€šÃÂ°: &a{map}",
                "",
                "&fÃËœÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ²: &a{on}/{max}",
                "",
                "&fÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ,&fÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ.,&fÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ..,&fÃÅ¾ÃÂ¶ÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ...",
                "",
                "&fÃÂ¢ÃÂ¸ÃÂ¿: &a{group}",
                "&fÃâ€™ÃÂµÃ‘â‚¬Ã‘ÂÃÂ¸Ã‘Â: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_STARTING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "",
                "&fÃÅ¡ÃÂ°Ã‘â‚¬Ã‘â€šÃÂ°: &a{map}",
                "",
                "&fÃËœÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ²: &a{on}/{max}",
                "",
                "&fÃÂ¡Ã‘â€šÃÂ°Ã‘â‚¬Ã‘â€š Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ· &a{time}s",
                "",
                "&fÃÂ¢ÃÂ¸ÃÂ¿: &a{group}",
                "&fÃâ€™ÃÂµÃ‘â‚¬Ã‘ÂÃÂ¸Ã‘Â: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_STARTING_SPEC, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "&o&7Spectating",
                "&fÃÅ¡ÃÂ°Ã‘â‚¬Ã‘â€šÃÂ°: &a{map}",
                "",
                "&fÃËœÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ²: &a{on}/{max}",
                "",
                "&fÃÂ¡Ã‘â€šÃÂ°Ã‘â‚¬Ã‘â€š Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ· &a{time}s",
                "",
                "&fÃÂ¢ÃÂ¸ÃÂ¿: &a{group}",
                "&fÃâ€™ÃÂµÃ‘â‚¬Ã‘ÂÃÂ¸Ã‘Â: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC_ELIMINATED, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_RESTARTING_SPEC, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&6Winner: {winnerTeamColor}{winnerTeamName} &6Ã¢Â­Â",
                "",
                "&7&lTop Kills:",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_RESTARTING_WIN1, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&6Winner: {winnerTeamColor}{winnerTeamName} &6Ã¢Â­Â",
                "",
                "&7&lTop Kills:",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_RESTARTING_WIN2, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&6Winner: {winnerTeamColor}{winnerTeamName} &6Ã¢Â­Â",
                "",
                "&7&lTop Kills:",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_RESTARTING_LOSER, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&6Winner: {winnerTeamColor}{winnerTeamName} &6Ã¢Â­Â",
                "",
                "&7&lTop Kills:",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "&f{topTeamColor}{topPlayerDisplayName}&7 - &l{topValue}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING.replaceFirst("Default", "Doubles"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC.replaceFirst("Default", "Doubles"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC_ELIMINATED.replaceFirst("Default", "Doubles"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING.replaceFirst("Default", "3v3v3v3"), Arrays.asList(
                "&e&lBED WARS",
                "&7{date}",
                "",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&fÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²: &a{kills}",
                "&fÃÂ¤ÃÂ¸ÃÂ½ÃÂ°ÃÂ»Ã‘Å’ÃÂ½Ã‘â€¹Ã‘â€¦ Ã‘Æ’ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²: &a{finalKills}",
                "&fÃÅ¡Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂµÃÂ¹ Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ¾: &a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC.replaceFirst("Default", "3v3v3v3"), Arrays.asList(
                "&e&lBED WARS",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC_ELIMINATED.replaceFirst("Default", "3v3v3v3"), Arrays.asList(
                "&e&lBED WARS",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&fÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²: &a{kills}",
                "&fÃÂ¤ÃÂ¸ÃÂ½ÃÂ°ÃÂ»Ã‘Å’ÃÂ½Ã‘â€¹Ã‘â€¦ Ã‘Æ’ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²: &a{finalKills}",
                "&fÃÅ¡Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂµÃÂ¹ Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ¾: &a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING.replaceFirst("Default", "4v4v4v4"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&fÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²: &a{kills}",
                "&fÃÂ¤ÃÂ¸ÃÂ½ÃÂ°ÃÂ»Ã‘Å’ÃÂ½Ã‘â€¹Ã‘â€¦ Ã‘Æ’ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²: &a{finalKills}",
                "&fÃÅ¡Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂµÃÂ¹ Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ¾: &a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC.replaceFirst("Default", "4v4v4v4"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC_ELIMINATED.replaceFirst("Default", "4v4v4v4"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} in &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&fÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²: &a{kills}",
                "&fÃÂ¤ÃÂ¸ÃÂ½ÃÂ°ÃÂ»Ã‘Å’ÃÂ½Ã‘â€¹Ã‘â€¦ Ã‘Æ’ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²: &a{finalKills}",
                "&fÃÅ¡Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂµÃÂ¹ Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ¾: &a{beds}",
                "",
                "&e{serverIp}")
        );
        // End of Sidebar

        // start of TAB
        // main lobby tab format
        yml.addDefault(Messages.FORMATTING_SB_TAB_LOBBY_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_LOBBY_FOOTER, java.util.Arrays.asList(
                "",
                "&fThere are {on} players on this lobby",
                "Powered by {poweredBy},&a{serverIp}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_LOBBY_PREFIX, java.util.Arrays.asList("{vPrefix}"));
        yml.addDefault(Messages.FORMATTING_SB_TAB_LOBBY_SUFFIX, java.util.Arrays.asList(" {level}"));
        // player waiting lobby
        yml.addDefault(Messages.FORMATTING_SB_TAB_WAITING_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_WAITING_FOOTER, java.util.Arrays.asList(
                "",
                "Waiting for more players,Waiting for more players.,Waiting for more players.., Waiting for more players...",
                "&f{on}&a/&f{max}",
                "",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_WAITING_PREFIX, java.util.Arrays.asList("{vPrefix}"));
        yml.addDefault(Messages.FORMATTING_SB_TAB_WAITING_SUFFIX, java.util.Arrays.asList(" {level}"));
        // spectator waiting lobby
        yml.addDefault(Messages.FORMATTING_SB_TAB_WAITING_HEADER_SPEC, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_WAITING_FOOTER_SPEC, java.util.Arrays.asList(
                "",
                "&7&oYou are spectating",
                "Waiting for more players,Waiting for more players.,Waiting for more players.., Waiting for more players...",
                "&f{on}&a/&f{max}",
                "",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_WAITING_PREFIX_SPEC, java.util.Arrays.asList("{vPrefix}"));
        yml.addDefault(Messages.FORMATTING_SB_TAB_WAITING_SUFFIX_SPEC, java.util.Arrays.asList(" {level}"));
        // player starting lobby
        yml.addDefault(Messages.FORMATTING_SB_TAB_STARTING_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                "&7{date}",
                "&7Map: &f{map} &7Mode: &f{group}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_STARTING_FOOTER, java.util.Arrays.asList(
                "",
                "&fStarting in &a{time} &fseconds,&fStarting in &a{time} &fseconds.,&fStarting in &a{time} &fseconds..,&fStarting in &a{time} &fseconds..",
                "&f{on}&a/&f{max}",
                "",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_STARTING_PREFIX, java.util.Arrays.asList("{vPrefix} "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_STARTING_SUFFIX, java.util.Arrays.asList(" {level}"));
        // spectator starting lobby
        yml.addDefault(Messages.FORMATTING_SB_TAB_STARTING_HEADER_SPEC, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                "&7{date}",
                "&7Map: &f{map} &7Mode: &f{group}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_STARTING_FOOTER_SPEC, java.util.Arrays.asList(
                "",
                "&fStarting in &a{time} &fseconds,&fStarting in &a{time} &fseconds.,&fStarting in &a{time} &fseconds..,&fStarting in &a{time} &fseconds..",
                "&f{on}&a/&f{max}",
                "",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_STARTING_PREFIX_SPEC, java.util.Arrays.asList("{vPrefix} "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_STARTING_SUFFIX_SPEC, java.util.Arrays.asList(" {level}"));
        // player playing
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                "&7{date}",
                "&7Map: &f{map} &7Mode: &f{group}",
                "",
                "{nextEvent} in {time}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_FOOTER, java.util.Arrays.asList(
                "",
                "&fYou are playing on the {teamColor}{teamName} Team",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_PREFIX, java.util.Arrays.asList("{teamColor}{teamName} "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_SUFFIX, java.util.Arrays.asList(" {vPrefix}", " {level}"));
        // player eliminated - playing state
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_ELM_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                "&7{date}",
                "&7Map: &f{map} &7Mode: &f{group}",
                "",
                "{nextEvent} in {time}",
                "",
                "&7&oAYou'*'ve been eliminated"
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_ELM_FOOTER, java.util.Arrays.asList(
                "",
                "&fYou have played in the {teamColor}{teamName} Team",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_ELM_PREFIX, java.util.Arrays.asList("&f&oSpectator "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_ELM_SUFFIX, java.util.Arrays.asList(" &c&oEliminated {teamColor}&o{teamName}", " {teamColor}&oEliminated {vPrefix}", "{teamColor}&oEliminated {level}"));
        // spectator - playing state
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_SPEC_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                "&7{date}",
                "&7Map: &f{map} &7Mode: &f{group}",
                "",
                "{nextEvent} in {time}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_SPEC_FOOTER, java.util.Arrays.asList(
                "",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_SPEC_PREFIX, java.util.Arrays.asList("&f&oSpectator "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_PLAYING_SPEC_SUFFIX, java.util.Arrays.asList(" {vPrefix}", " {level}"));
        // winner alive - restarting state
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_WIN1_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&6Ã¢Â­Â {winnerTeamColor}&lYour team won the game! &6Ã¢Â­Â",
                "&7{date}", "&7Map: &f{map} &7Mode: &f{group}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_WIN1_FOOTER, java.util.Arrays.asList(
                "",
                "&6&lYou won in the {teamColor}&l{teamName} Team&6&l!,&6&lYou won in the {teamColor}&l{teamName} Team&6&l!,&f&lYou won in the {teamColor}&l{teamName} Team&f&l!",
                "&7Statistics from this match",
                "&eKills: &f{kills} &8| &eFinal Kills: &f{finalKills} &8| &eBeds Destroyed: &f{beds} &8| &eDeaths: &f{deaths},&eKills: &7{kills} &8| &eFinal Kills: &7{finalKills} &8| &eBeds Destroyed: &7{beds} &8| &eDeaths: &7{deaths}",
                "",
                "&fThanks for playing {player}!",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_WIN1_PREFIX, java.util.Arrays.asList("&6&lÃ¢Â­Â {teamColor}{teamName} "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_WIN1_SUFFIX, java.util.Arrays.asList(" {vPrefix}", " {level}"));
        // winner dead - restarting state
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_WIN2_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&6Ã¢Â­Â {winnerTeamColor}&l{winnerTeamName} Team won the game! &6Ã¢Â­Â",
                "&7{date}",
                "&7Map: &f{map} &7Mode: &f{group}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_WIN2_FOOTER, java.util.Arrays.asList(
                "",
                "&6&lYou won in the {teamColor}&l{teamName} Team&6&l!,&6&lYou won in the {teamColor}&l{teamName} Team&6&l!,&f&lYou won in the {teamColor}&l{teamName} Team&f&l!",
                "&7Statistics from this match",
                "&eKills: &f{kills} &8| &eFinal Kills: &f{finalKills} &8| &eBeds Destroyed: &f{beds} &8| &eDeaths: &f{deaths},&eKills: &7{kills} &8| &eFinal Kills: &7{finalKills} &8| &eBeds Destroyed: &7{beds} &8| &eDeaths: &7{deaths}",

                "&fThanks for playing {player}!",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_WIN2_PREFIX, java.util.Arrays.asList("&6&lÃ¢Â­Â {teamColor}{teamName} "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_WIN2_SUFFIX, java.util.Arrays.asList(" {vPrefix}", " &c&oEliminated", " {level}", " &c&oEliminated"));
        // loser - restarting state
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_ELM_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&6Ã¢Â­Â {winnerTeamColor}&l{winnerTeamName} Team won the game! &6Ã¢Â­Â",
                "&7{date}",
                "&7Map: &f{map} &7Mode: &f{group}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_ELM_FOOTER, java.util.Arrays.asList(
                "",
                "&fYou have lost in the {teamColor}{teamName} Team",
                "&7Statistics from this match",
                "&eKills: &f{kills} &8| &eFinal Kills: &f{finalKills} &8| &eBeds Destroyed: &f{beds} &8| &eDeaths: &f{deaths},&eKills: &7{kills} &8| &eFinal Kills: &7{finalKills} &8| &eBeds Destroyed: &7{beds} &8| &eDeaths: &7{deaths}",
                "&fThanks for playing {player}!",
                "&a{serverIp}",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_ELM_PREFIX, java.util.Arrays.asList("{teamColor}{teamName} "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_ELM_SUFFIX, java.util.Arrays.asList(" {vPrefix}", " &c&oEliminated", " {level}", " &c&oEliminated"));
        // spectator - restarting state
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_SPEC_HEADER, java.util.Arrays.asList(
                "                                                                                                        ",
                "&a{serverIp}",
                "&6Ã¢Â­Â {winnerTeamColor}&l{winnerTeamName} Team won the game! &6Ã¢Â­Â",
                "&7{date}",
                "&7Map: &f{map} &7Mode: &f{group}",
                "",
                "&fThanks for playing {player}!",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_SPEC_FOOTER, java.util.Arrays.asList(
                "",
                "&fPowered by {poweredBy}",
                ""
        ));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_SPEC_PREFIX, java.util.Arrays.asList("&f&oSpectator "));
        yml.addDefault(Messages.FORMATTING_SB_TAB_RESTARTING_SPEC_SUFFIX, java.util.Arrays.asList(" {vPrefix}", " {level}"));
        // end of tab

        yml.addDefault(Messages.FORMATTING_SCOREBOARD_HEALTH, Arrays.asList("&cÃ¢ÂÂ¤", "&aÃâ€”ÃÂ´ÃÂ¾Ã‘â‚¬ÃÂ¾ÃÂ²Ã‘Å’ÃÂµ"));
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_DATE, "dd/MM/yy");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_GENERIC, "{TeamColor}{TeamLetter}&f {TeamName}: {TeamStatus}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_ELIMINATED, "&c&lÃ¢Å“Ëœ");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_BED_DESTROYED, "&a{remainingPlayers}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_ALIVE, "&a&lÃ¢Å“â€œ");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_NEXEVENT_TIMER, "mm:ss");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_YOUR_TEAM, "&7 Ãâ€™Ã‘â€¹");
        yml.addDefault(Messages.FORMATTING_ACTION_BAR_TRACKING, "&fÃÅ¾Ã‘â€šÃ‘ÂÃÂ»ÃÂµÃÂ¶ÃÂ¸ÃÂ²ÃÂ°ÃÂ½ÃÂ¸ÃÂµ: {team} &f- Ãâ€ÃÂ¸Ã‘ÂÃ‘â€šÃÂ°ÃÂ½Ã‘â€ ÃÂ¸Ã‘Â: {distance}m");
        yml.addDefault(Messages.TEAM_ELIMINATED_CHAT, "\n&f&lÃÅ¡ÃÅ¾ÃÅ“ÃÂÃÂÃâ€ÃÂÃÂÃÂ¯ Ãâ€ºÃËœÃÅ¡Ãâ€™ÃËœÃâ€ÃÂÃÂ¦ÃËœÃÂ¯ > {TeamColor}{TeamName} ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° &cÃÂ±Ã‘â€¹ÃÂ»ÃÂ° Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ°!\n");
        yml.addDefault(Messages.BED_HOLOGRAM_DEFEND, "&c&lÃâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€°ÃÂ°ÃÂ¹Ã‘â€šÃÂµ Ã‘ÂÃÂ²ÃÂ¾Ã‘Å½ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’!");
        yml.addDefault(Messages.INTERACT_CHEST_CANT_OPEN_TEAM_ELIMINATED, "&cÃÂ¢Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘Ë†Ã‘Å’ ÃÂ¾Ã‘â€šÃÂºÃ‘â‚¬Ã‘â€¹Ã‘â€šÃ‘Å’ Ã‘ÂÃ‘â€šÃÂ¾Ã‘â€š Ã‘ÂÃ‘Æ’ÃÂ½ÃÂ´Ã‘Æ’ÃÂº, Ã‘â€šÃÂ°ÃÂº ÃÂºÃÂ°ÃÂº ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ°!");
        yml.addDefault(Messages.INTERACT_CANNOT_PLACE_BLOCK, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ Ã‘ÂÃ‘â€šÃÂ°ÃÂ²ÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ±ÃÂ»ÃÂ¾ÃÂºÃÂ¸ ÃÂ·ÃÂ´ÃÂµÃ‘ÂÃ‘Å’!");
        yml.addDefault(Messages.INTERACT_CANNOT_BREAK_BLOCK, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ ÃÂ»ÃÂ¾ÃÂ¼ÃÂ°Ã‘â€šÃ‘Å’ ÃÂ±ÃÂ»ÃÂ¾ÃÂºÃÂ¸ Ã‘â€šÃÂ¾ÃÂ»Ã‘Å’ÃÂºÃÂ¾ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ²!");
        yml.addDefault(Messages.INTERACT_CANNOT_BREAK_OWN_BED, "&cÃâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ Ã‘â‚¬ÃÂ°ÃÂ·Ã‘â‚¬Ã‘Æ’Ã‘Ë†ÃÂ¸Ã‘â€šÃ‘Å’ Ã‘ÂÃÂ²ÃÂ¾Ã‘Å½ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’!");
        yml.addDefault(Messages.TEAM_ELIMINATED_CHAT, "\n&f&lÃÂ£ÃÂÃËœÃÂ§ÃÂ¢ÃÅ¾Ãâ€“Ãâ€¢ÃÂÃËœÃâ€¢ ÃÅ¡ÃÅ¾ÃÅ“ÃÅ“ÃÂÃÂÃâ€ÃÂ« > {TeamColor}{TeamName} ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° &cÃÂ±Ã‘â€¹ÃÂ»ÃÂ° Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ°!\n");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_CHAT_ANNOUNCEMENT, "\n&f&lÃÂ£ÃÂÃËœÃÂ§ÃÂ¢ÃÅ¾Ãâ€“Ãâ€¢ÃÂÃËœÃâ€¢ ÃÅ¡ÃÂ ÃÅ¾Ãâ€™ÃÂÃÂ¢ÃËœ > {TeamColor}{TeamName} ÃÅ¡Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’ &7Ã‘â‚¬ÃÂ°ÃÂ·Ã‘Æ’Ã‘Ë†ÃÂµÃÂ½ÃÂ° ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ¼ {PlayerColor}{PlayerName}&7!\n");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_TITLE_ANNOUNCEMENT, "&cÃâ€™ÃÂÃÂ¨ÃÂ ÃÅ¡ÃÂ ÃÅ¾Ãâ€™ÃÂÃÂ¢ÃÂ¬ ÃÂ£ÃÂÃËœÃÂ§ÃÂ¢ÃÅ¾Ãâ€“Ãâ€¢ÃÂÃÂ!");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_SUBTITLE_ANNOUNCEMENT, "&fÃâ€™Ã‘â€¹ ÃÂ±ÃÂ¾ÃÂ»Ã‘Å’Ã‘Ë†ÃÂµ ÃÂ½ÃÂµ Ã‘ÂÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ ÃÂ²ÃÂ¾ÃÂ·Ã‘â‚¬ÃÂ¾ÃÂ´ÃÂ¸Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â!");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_CHAT_ANNOUNCEMENT_TO_VICTIM, "&f&lÃÂ£ÃÂÃËœÃÂ§ÃÂ¢ÃÅ¾Ãâ€“Ãâ€¢ÃÂÃËœÃâ€¢ ÃÅ¡ÃÂ ÃÅ¾Ãâ€™ÃÂÃÂ¢ÃËœ > &7Ãâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’ Ã‘â‚¬ÃÂ°ÃÂ·Ã‘â‚¬Ã‘Æ’Ã‘Ë†ÃÂµÃÂ½ÃÂ° ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ¼ {PlayerColor}{PlayerName}&7!");
        yml.addDefault(Messages.INTERACT_INVISIBILITY_REMOVED_DAMGE_TAKEN, "&cYou are no longer invisible because you have taken damage!");
        yml.addDefault(Messages.PLAYER_DIE_VOID_FALL_REGULAR_KILL, "{PlayerColor}{PlayerName} &7Ã‘Æ’ÃÂ¿ÃÂ°ÃÂ».");
        yml.addDefault(Messages.PLAYER_DIE_VOID_FALL_FINAL_KILL, "{PlayerColor}{PlayerName} &7Ã‘Æ’ÃÂ¿ÃÂ°ÃÂ». &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_IN_VOID_REGULAR_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘ÂÃÂºÃÂ¸ÃÂ½Ã‘Æ’Ã‘â€š ÃÂ² ÃÂ±ÃÂµÃÂ·ÃÂ´ÃÂ½Ã‘Æ’ {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_IN_VOID_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘ÂÃÂºÃÂ¸ÃÂ½Ã‘Æ’Ã‘â€š ÃÂ² ÃÂ±ÃÂµÃÂ·ÃÂ´ÃÂ½Ã‘Æ’ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ¼ {KillerColor}{KillerName}&7. &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_BY_REGULAR_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘ÂÃÂ±ÃÂ¸Ã‘â€š ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ¼ {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_BY_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘ÂÃÂ±ÃÂ¸Ã‘â€š ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ¼ {KillerColor}{KillerName}&7. &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITH_SOURCE_REGULAR_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» ÃÂ¿ÃÂ¾Ã‘â‚¬ÃÂ°ÃÂ¶ÃÂµÃÂ½ ÃÂ»Ã‘Å½ÃÂ±ÃÂ¸ÃÂ¼ÃÂ¾ÃÂ¹ ÃÂ±ÃÂ¾ÃÂ¼ÃÂ±ÃÂ¾ÃÂ¹ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITH_SOURCE_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» ÃÂ¿ÃÂ¾Ã‘â‚¬ÃÂ°ÃÂ¶ÃÂµÃÂ½ ÃÂ»Ã‘Å½ÃÂ±ÃÂ¸ÃÂ¼ÃÂ¾ÃÂ¹ ÃÂ±ÃÂ¾ÃÂ¼ÃÂ±ÃÂ¾ÃÂ¹ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {KillerColor}{KillerName}&7. &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_PVP_REGULAR_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ±ÃÂ¸Ã‘â€š ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ¼ {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_PVP_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ±ÃÂ¸Ã‘â€š ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ¼ {KillerColor}{KillerName}&7. &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_PVP_LOG_OUT_REGULAR, "{PlayerColor}{PlayerName} &7ÃÂ¾Ã‘â€šÃÂºÃ‘Å½Ã‘â€¡ÃÂ¸ÃÂ»Ã‘ÂÃ‘Â ÃÂ¿ÃÂ¾ÃÂºÃÂ° Ã‘ÂÃ‘â‚¬ÃÂ°ÃÂ¶ÃÂ°ÃÂ»Ã‘ÂÃ‘Â Ã‘Â {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_PVP_LOG_OUT_FINAL, "{PlayerColor}{PlayerName} &7ÃÂ¾Ã‘â€šÃÂºÃ‘Å½Ã‘â€¡ÃÂ¸ÃÂ»Ã‘ÂÃ‘Â ÃÂ¿ÃÂ¾ÃÂºÃÂ° Ã‘ÂÃ‘â‚¬ÃÂ°ÃÂ¶ÃÂ°ÃÂ»Ã‘ÂÃ‘Â Ã‘Â {KillerColor}{KillerName}&7. &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.BED_HOLOGRAM_DESTROYED, "&c&lÃâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’ Ã‘ÂÃÂ»ÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ°!");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_TITLE, "&cÃâ€™ÃÂ« ÃÅ¸ÃÅ¾Ãâ€œÃËœÃâ€˜Ãâ€ºÃËœ!");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_SUBTITLE, "&eÃâ€™Ã‘â€¹ ÃÂ²ÃÂ¾ÃÂ·Ã‘â‚¬ÃÂ¾ÃÂ´ÃÂ¸Ã‘â€šÃÂµÃ‘ÂÃ‘Å’ Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ· &c{time} &eÃ‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´!");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_CHAT, "{prefix}&eÃâ€™Ã‘â€¹ ÃÂ²ÃÂ¾ÃÂ·Ã‘â‚¬ÃÂ¾ÃÂ´ÃÂ¸Ã‘â€šÃÂµÃ‘ÂÃ‘Å’ Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ· &c{time} &eÃ‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´!");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWNED_TITLE, "&aÃâ€™ÃÅ¾Ãâ€”ÃÂ ÃÅ¾Ãâ€“Ãâ€Ãâ€¢ÃÂ!");
        yml.addDefault(Messages.PLAYER_DIE_ELIMINATED_CHAT, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ±Ã‘â€¹ÃÂ»ÃÂ¸ Ã‘Æ’Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂ°ÃÂ½ÃÂµÃÂ½Ã‘â€¹!");
        yml.addDefault(Messages.PLAYER_HIT_BOW, "&7ÃÂ£ {prefix}{TeamColor}{PlayerName} &7Ã‘â€šÃÂµÃÂ¿ÃÂµÃ‘â‚¬Ã‘Å’ &c{amount} &7HP!");
        yml.addDefault(Messages.GAME_END_GAME_OVER_PLAYER_TITLE, "&c&lÃËœÃâ€œÃÂ ÃÂ ÃÅ¾ÃÅ¡ÃÅ¾ÃÂÃÂ§Ãâ€¢ÃÂÃÂ!");
        yml.addDefault(Messages.GAME_END_VICTORY_PLAYER_TITLE, "&6&lÃÅ¸ÃÅ¾Ãâ€˜Ãâ€¢Ãâ€ÃÂ!");
        yml.addDefault(Messages.GAME_END_TOP_PLAYER_CHAT, Arrays.asList("&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&f                                   &lBedWars", "", "{winnerFormat}", "", "",
                "&6                      &6Ã¢Â­Â &l1-1 ÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘â€ ÃÂ° &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}",
                "&e                        &l2-ÃÂ¹ ÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘â€ ÃÂ° &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}",
                "&c                        &l3-ÃÂ¹ ÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘â€ ÃÂ° &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}", "",
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        //yml.addDefault(gameOverReward, Arrays.asList("&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
        //        "&f                                   &lReward Summary", "", "",
        //        "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        yml.addDefault(Messages.GAME_END_TEAM_WON_CHAT, "{prefix}{TeamColor}{TeamName} &aÃÂ²Ã‘â€¹ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ°ÃÂ» ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘Æ’!");
        yml.addDefault(Messages.FORMATTING_TEAM_WINNER_FORMAT, "      {TeamColor}{TeamName} &7- {members}");
        yml.addDefault(Messages.FORMATTING_SOLO_WINNER_FORMAT, "                 {TeamColor}{TeamName} &7- {members}");
        //yml.addDefault(tablistFormat, "{TeamColor}&l{TeamLetter}&r {TeamColor}{PlayerName} &e{PlayerHealth}");//{TeamColor}{TeamName}{TeamHealth}{PlayerName}{PlayerHealth}
        yml.addDefault(Messages.MEANING_NOBODY, "ÃÂÃÂ¸ÃÂºÃ‘â€šÃÂ¾");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER1, "I");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER2, "II");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER3, "III");
        yml.addDefault(Messages.GENERATOR_UPGRADE_CHAT_ANNOUNCEMENT, "{prefix}{generatorType} Ãâ€œÃÂµÃÂ½ÃÂµÃ‘â‚¬ÃÂ°Ã‘â€šÃÂ¾Ã‘â‚¬ &eÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ»Ã‘Æ’Ã‘â€¡Ã‘Ë†ÃÂµÃÂ½ ÃÂ´ÃÂ¾ Ã‘Æ’Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ½Ã‘Â &c{tier}");
        yml.addDefault(Messages.NPC_NAME_TEAM_UPGRADES, "&bÃÅ¡ÃÅ¾ÃÅ“ÃÂÃÂÃâ€ÃÂÃÂ«Ãâ€¢ ÃÂ£Ãâ€ºÃÂ£ÃÂ§ÃÂ¨Ãâ€¢ÃÂÃËœÃÂ¯, &e&lÃÅ¸ÃÅ¡ÃÅ“");
        yml.addDefault(Messages.NPC_NAME_SOLO_UPGRADES, "&bÃÂ¡ÃÅ¾Ãâ€ºÃÅ¾ ÃÂ£Ãâ€ºÃÂ£ÃÂ§ÃÂ¨Ãâ€¢ÃÂÃËœÃÂ¯, &e&lÃÅ¸ÃÅ¡ÃÅ“");
        yml.addDefault(Messages.NPC_NAME_TEAM_SHOP, "&bÃÅ“ÃÂÃâ€œÃÂÃâ€”ÃËœÃÂ, &e&lÃÅ¸ÃÅ¡ÃÅ“");
        yml.addDefault(Messages.NPC_NAME_SOLO_SHOP, "&bÃÅ“ÃÂÃâ€œÃÂÃâ€”ÃËœÃÂ, &e&lÃÅ¸ÃÅ¡ÃÅ“");
        yml.addDefault(Messages.XP_REWARD_PER_MINUTE, "{prefix}&6+{xp} BukkitBedPlugin ÃÅ¾ÃÂ¿Ã‘â€¹Ã‘â€šÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂµÃÂ½ÃÂ¾ (ÃËœÃÂ³Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ¾ÃÂµ ÃÂ²Ã‘â‚¬ÃÂµÃÂ¼Ã‘Â).");
        yml.addDefault(Messages.XP_REWARD_WIN, "{prefix}&6+{xp} BukkitBedPlugin ÃÅ¾ÃÂ¿Ã‘â€¹Ã‘â€šÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂµÃÂ½ÃÂ¾ (ÃÅ¸ÃÂ¾ÃÂ±ÃÂµÃÂ´ÃÂ° ÃÂ² ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂµ).");
        yml.addDefault(Messages.XP_REWARD_PER_TEAMMATE, "{prefix}&6+{xp} BukkitBedPlugin ÃÅ¾ÃÂ¿Ã‘â€¹Ã‘â€šÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂµÃÂ½ÃÂ¾ (ÃÅ¸ÃÂ¾ÃÂ´ÃÂ´ÃÂµÃ‘â‚¬ÃÂ¶ÃÂºÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘â€¹).");
        yml.addDefault(Messages.XP_REWARD_BED_DESTROY, "{prefix}&6+{xp} BukkitBedPlugin ÃÅ¾ÃÂ¿Ã‘â€¹Ã‘â€šÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂµÃÂ½ÃÂ¾ (ÃÂ ÃÂ°ÃÂ·Ã‘â‚¬Ã‘Æ’Ã‘Ë†ÃÂµÃÂ½ÃÂ¸ÃÂµ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸).");
        yml.addDefault(Messages.XP_REWARD_REGULAR_KILL, "{prefix}&6+{xp} BukkitBedPlugin ÃÅ¾ÃÂ¿Ã‘â€¹Ã‘â€šÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂµÃÂ½ÃÂ¾ (ÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²ÃÂ¾).");
        yml.addDefault(Messages.XP_REWARD_FINAL_KILL, "{prefix}&6+{xp} BukkitBedPlugin ÃÅ¾ÃÂ¿Ã‘â€¹Ã‘â€šÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂµÃÂ½ÃÂ¾ (ÃÂ¤ÃÂ¸ÃÂ½ÃÂ°ÃÂ»Ã‘Å’ÃÂ½ÃÂ¾ÃÂµ Ã‘Æ’ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²ÃÂ¾).");

        yml.addDefault(Messages.MONEY_REWARD_PER_MINUTE, "{prefix}&6+{money} ÃÅ“ÃÂ¾ÃÂ½ÃÂµÃ‘â€š (ÃËœÃÂ³Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ¾ÃÂµ ÃÂ²Ã‘â‚¬ÃÂµÃÂ¼Ã‘Â).");
        yml.addDefault(Messages.MONEY_REWARD_WIN, "{prefix}&6+{money} ÃÅ“ÃÂ¾ÃÂ½ÃÂµÃ‘â€š (ÃÅ¸ÃÂ¾ÃÂ±ÃÂµÃÂ´ÃÂ° ÃÂ² ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂµ).");
        yml.addDefault(Messages.MONEY_REWARD_PER_TEAMMATE, "{prefix}&6+{money} ÃÅ“ÃÂ¾ÃÂ½ÃÂµÃ‘â€š (ÃÅ¸ÃÂ¾ÃÂ´ÃÂ´ÃÂµÃ‘â‚¬ÃÂ¶ÃÂºÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘â€¹).");
        yml.addDefault(Messages.MONEY_REWARD_BED_DESTROYED, "{prefix}&6+{money} ÃÅ“ÃÂ¾ÃÂ½ÃÂµÃ‘â€š (ÃÂ ÃÂ°ÃÂ·Ã‘â‚¬Ã‘Æ’Ã‘Ë†ÃÂµÃÂ½ÃÂ¸ÃÂµ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸).");
        yml.addDefault(Messages.MONEY_REWARD_FINAL_KILL, "{prefix}&6+{money} ÃÅ“ÃÂ¾ÃÂ½ÃÂµÃ‘â€š (ÃÂ¤ÃÂ¸ÃÂ½ÃÂ°ÃÂ»Ã‘Å’ÃÂ½ÃÂ¾ÃÂµ Ã‘Æ’ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²ÃÂ¾).");
        yml.addDefault(Messages.MONEY_REWARD_REGULAR_KILL, "{prefix}&6+{money} ÃÅ“ÃÂ¾ÃÂ½ÃÂµÃ‘â€š (ÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²ÃÂ¾).");

        //SHOP
        yml.addDefault(Messages.SHOP_INDEX_NAME, "&8Ãâ€˜Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂ°Ã‘Â ÃÂ¿ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ°");
        yml.addDefault(Messages.SHOP_INSUFFICIENT_MONEY, "{prefix}&cÃÂ¢ÃÂµÃÂ±ÃÂµ ÃÂ½ÃÂµÃ‘â€¦ÃÂ²ÃÂ°Ã‘â€šÃÂ°ÃÂµÃ‘â€š {currency}! ÃÂÃ‘Æ’ÃÂ¶ÃÂ½ÃÂ¾ ÃÂµÃ‘â€°ÃÂµ {amount}!");
        yml.addDefault(Messages.SHOP_NEW_PURCHASE, "{prefix}&aÃÂ¢Ã‘â€¹ ÃÂºÃ‘Æ’ÃÂ¿ÃÂ¸ÃÂ» &6{item}");
        yml.addDefault(Messages.SHOP_ALREADY_BOUGHT, "{prefix}&cÃÂ¢Ã‘â€¹ Ã‘Æ’ÃÂ¶ÃÂµ ÃÂºÃ‘Æ’ÃÂ¿ÃÂ¸ÃÂ» Ã‘ÂÃ‘â€šÃÂ¾!");
        yml.addDefault(Messages.SHOP_QUICK_ADD_NAME, "&8Ãâ€ÃÂ¾ÃÂ±ÃÂ°ÃÂ²ÃÂ»ÃÂµÃÂ½ÃÂ¸ÃÂµ ÃÂ² ÃÂ±Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘Æ’Ã‘Å½ ÃÂ¿ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃ‘Æ’...");
        yml.addDefault(Messages.SHOP_UTILITY_NPC_SILVERFISH_NAME, "{TeamColor}&l{TeamName} &r{TeamColor}Silverfish");
        yml.addDefault(Messages.SHOP_UTILITY_NPC_IRON_GOLEM_NAME, "{TeamColor}{despawn}s &8[ {TeamColor}{health}&8]");
        yml.addDefault(Messages.SHOP_SEPARATOR_NAME, "&8Ã¢â€¡Â§ ÃÅ¡ÃÂ°Ã‘â€šÃÂµÃÂ³ÃÂ¾Ã‘â‚¬ÃÂ¸ÃÂ¸");
        yml.addDefault(Messages.SHOP_SEPARATOR_LORE, Collections.singletonList("&8Ã¢â€¡Â© ÃÅ¸Ã‘â‚¬ÃÂµÃÂ´ÃÂ¼ÃÂµÃ‘â€šÃ‘â€¹"));
        yml.addDefault(Messages.SHOP_QUICK_BUY_NAME, "&bÃâ€˜Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂ°Ã‘Â ÃÂ¿ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ°");
        yml.addDefault(Messages.SHOP_QUICK_BUY_LORE, new ArrayList<>());
        yml.addDefault(Messages.SHOP_QUICK_EMPTY_NAME, "&cÃÅ¸Ã‘Æ’Ã‘ÂÃ‘â€šÃÂ¾ÃÂ¹ Ã‘ÂÃÂ»ÃÂ¾Ã‘â€š!");
        yml.addDefault(Messages.SHOP_QUICK_EMPTY_LORE, Arrays.asList("&7ÃÂ­Ã‘â€šÃÂ¾ Ã‘ÂÃÂ»ÃÂ¾Ã‘â€š ÃÂ±Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂ¾ÃÂ¹ ÃÂ¿ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ¸!", "&bÃÂ¨ÃÂ¸Ã‘â€žÃ‘â€š-ÃÂºÃÂ»ÃÂ¸ÃÂº &7ÃÂ½ÃÂ° ÃÂ»Ã‘Å½ÃÂ±ÃÂ¾ÃÂ¹ ÃÂ¿Ã‘â‚¬ÃÂµÃÂ´ÃÂ¼ÃÂµÃ‘â€š", "&7ÃÂ´ÃÂ»Ã‘Â ÃÂ´ÃÂ¾ÃÂ±ÃÂ°ÃÂ²ÃÂ»ÃÂµÃÂ½ÃÂ¸Ã‘Â ÃÂµÃÂ³ÃÂ¾ Ã‘ÂÃ‘Å½ÃÂ´ÃÂ°."));
        yml.addDefault(Messages.SHOP_CAN_BUY_COLOR, "&a");
        yml.addDefault(Messages.SHOP_CANT_BUY_COLOR, "&c");
        yml.addDefault(Messages.SHOP_LORE_STATUS_CAN_BUY, "&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ¸!");
        yml.addDefault(Messages.SHOP_LORE_STATUS_CANT_AFFORD, "&cÃÂ¢ÃÂµÃÂ±ÃÂµ ÃÂ½ÃÂµÃ‘â€¦ÃÂ²ÃÂ°Ã‘â€šÃÂ°ÃÂµÃ‘â€š {currency}!");
        yml.addDefault(Messages.SHOP_LORE_STATUS_MAXED, "&aÃÅ“ÃÂÃÅ¡ÃÂ¡ÃËœÃÅ“ÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾!");
        yml.addDefault(Messages.SHOP_LORE_QUICK_ADD, "&bÃÂ¨ÃÂ¸Ã‘â€žÃ‘â€š-ÃÂºÃÂ»ÃÂ¸ÃÂº ÃÂ´ÃÂ»Ã‘Â ÃÂ´ÃÂ¾ÃÂ±ÃÂ°ÃÂ²ÃÂ»ÃÂµÃÂ½ÃÂ¸Ã‘Â ÃÂ² ÃÂ±Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘Æ’Ã‘Å½ ÃÂ¿ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃ‘Æ’");
        yml.addDefault(Messages.SHOP_LORE_QUICK_REMOVE, "&bÃÂ¨ÃÂ¸Ã‘â€žÃ‘â€š-ÃÂºÃÂ»ÃÂ¸ÃÂº ÃÂ´ÃÂ»Ã‘Â Ã‘Æ’ÃÂ´ÃÂ°ÃÂ»ÃÂµÃÂ½ÃÂ¸Ã‘Â ÃÂ¸ÃÂ· ÃÂ±Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂ¾ÃÂ¹ ÃÂ¿ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ¸!");


        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "&8Ãâ€˜ÃÂ»ÃÂ¾ÃÂºÃÂ¸", "&aÃâ€˜ÃÂ»ÃÂ¾ÃÂºÃÂ¸", Collections.singletonList("&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘â€šÃ‘â‚¬ÃÂ°!"));

        addContentMessages(yml, "wool", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}ÃÂ¨ÃÂµÃ‘â‚¬Ã‘ÂÃ‘â€šÃ‘Å’", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: &f{cost} {currency}", "", "&7Great for bridging across", "&7islands. Turns into your team's",
                "&7color.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "clay", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ãâ€œÃÂ»ÃÂ¸ÃÂ½ÃÂ°", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂ¡Ã‘â€šÃÂ°ÃÂ½ÃÂ´ÃÂ°Ã‘â‚¬Ã‘â€šÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ±ÃÂ»ÃÂ¾ÃÂº ÃÂ´ÃÂ»Ã‘Â ÃÂ·ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃ‘â€¹ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "glass", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ãâ€™ÃÂ·Ã‘â‚¬Ã‘â€¹ÃÂ²ÃÂ¾Ã‘Æ’Ã‘ÂÃ‘â€šÃÂ¾ÃÂ¹Ã‘â€¡ÃÂ¸ÃÂ²ÃÂ¾ÃÂµ Ã‘ÂÃ‘â€šÃÂµÃÂºÃÂ»ÃÂ¾", Arrays.asList("&7Cost: {cost} {currency}", "", "&7ÃËœÃÂ¼ÃÂµÃÂµÃ‘â€š ÃÂ¸ÃÂ¼Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€šÃÂµÃ‘â€š ÃÂº ÃÂ²ÃÂ·Ã‘â‚¬Ã‘â€¹ÃÂ²ÃÂ°ÃÂ¼.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "stone", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}ÃÂ­ÃÂ½ÃÂ´ÃÂµÃ‘â‚¬ÃÂ½Ã‘ÂÃÂº", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂ¡ÃÂ¾ÃÂ»ÃÂ¸ÃÂ´ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ±ÃÂ»ÃÂ¾ÃÂº ÃÂ´ÃÂ»Ã‘Â ÃÂ·ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃ‘â€¹ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "ladder", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ãâ€ºÃÂµÃ‘ÂÃ‘â€šÃÂ½ÃÂ¸Ã‘â€ Ã‘â€¹", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÅ¸ÃÂ¾ÃÂ»ÃÂµÃÂ·ÃÂ½ÃÂ¾ ÃÂºÃÂ¾ÃÂ³ÃÂ´ÃÂ° ÃÂºÃÂ¾Ã‘Ë†ÃÂºÃÂ¸ ÃÂ·ÃÂ°Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂµÃÂ²ÃÂ°Ã‘Å½Ã‘â€š", "&7ÃÂ½ÃÂ° ÃÂ´ÃÂµÃ‘â‚¬ÃÂµÃÂ²Ã‘Å’Ã‘ÂÃ‘â€¦.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "obsidian", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}ÃÅ¾ÃÂ±Ã‘ÂÃÂ¸ÃÂ´ÃÂ¸ÃÂ°ÃÂ½", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7Ãâ€ºÃ‘Æ’Ã‘â€¡Ã‘Ë†ÃÂ¸ÃÂ¹ ÃÂ±ÃÂ»ÃÂ¾ÃÂº ÃÂ´ÃÂ»Ã‘Â ÃÂ·ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃ‘â€¹ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "wood", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ãâ€ÃÂµÃ‘â‚¬ÃÂµÃÂ²ÃÂ¾", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂ¥ÃÂ¾Ã‘â‚¬ÃÂ¾Ã‘Ë†ÃÂ¸ÃÂ¹ ÃÂ±ÃÂ»ÃÂ¾ÃÂº ÃÂ´ÃÂ»Ã‘Â ÃÂ·ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃ‘â€¹ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸.", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_MELEE, "&8ÃÅ¾Ã‘â‚¬Ã‘Æ’ÃÂ¶ÃÂ¸ÃÂµ", "&aÃÅ¾Ã‘â‚¬Ã‘Æ’ÃÂ¶ÃÂ¸ÃÂµ", Collections.singletonList("&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘â€šÃ‘â‚¬ÃÂ°!"));

        addContentMessages(yml, "stone-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}ÃÅ¡ÃÂ°ÃÂ¼ÃÂµÃÂ½ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ¼ÃÂµÃ‘â€¡", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "iron-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ¼ÃÂµÃ‘â€¡", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "diamond-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}ÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ¼ÃÂµÃ‘â€¡", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "stick", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}ÃÅ¸ÃÂ°ÃÂ»ÃÂºÃÂ° (ÃÅ¾Ã‘â€šÃÂ´ÃÂ°Ã‘â€¡ÃÂ° I)", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "&8Ãâ€˜Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â", "&aÃâ€˜Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â", Collections.singletonList("&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘â€šÃ‘â‚¬ÃÂ°!"));

        addContentMessages(yml, "chainmail", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}ÃÅ¡ÃÂ¾ÃÂ»Ã‘Å’Ã‘â€¡Ã‘Æ’ÃÂ¶ÃÂ½ÃÂ°Ã‘Â ÃÂ±Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}",
                "", "&7ÃÅ¡ÃÂ¾ÃÂ»Ã‘Å’Ã‘â€¡Ã‘Æ’ÃÂ¶ÃÂ½Ã‘â€¹ÃÂµ Ã‘Ë†Ã‘â€šÃÂ°ÃÂ½Ã‘â€¹ ÃÂ¸ Ã‘ÂÃÂ°ÃÂ¿ÃÂ¾ÃÂ³ÃÂ¸", "&7Ãâ€™Ã‘â€¹ ÃÂ²Ã‘ÂÃÂµÃÂ³ÃÂ´ÃÂ° ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€šÃÂµ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ²ÃÂ»Ã‘ÂÃ‘â€šÃ‘Å’Ã‘ÂÃ‘Â", "&7Ã‘Â ÃÂ½ÃÂ¸ÃÂ¼ÃÂ¸ ÃÂ¿Ã‘â‚¬ÃÂ¸ Ã‘ÂÃÂ¼ÃÂµÃ‘â‚¬Ã‘â€šÃÂ¸.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "iron-armor", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½ÃÂ°Ã‘Â ÃÂ±Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}",
                "", "&Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½Ã‘â€¹ÃÂµ Ã‘Ë†Ã‘â€šÃÂ°ÃÂ½Ã‘â€¹ ÃÂ¸ Ã‘ÂÃÂ°ÃÂ¿ÃÂ¾ÃÂ³ÃÂ¸", "&7Ãâ€™Ã‘â€¹ ÃÂ²Ã‘ÂÃÂµÃÂ³ÃÂ´ÃÂ° ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€šÃÂµ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ²ÃÂ»Ã‘ÂÃ‘â€šÃ‘Å’Ã‘ÂÃ‘Â", "&7Ã‘Â ÃÂ½ÃÂ¸ÃÂ¼ÃÂ¸ ÃÂ¿Ã‘â‚¬ÃÂ¸ Ã‘ÂÃÂ¼ÃÂµÃ‘â‚¬Ã‘â€šÃÂ¸.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "diamond-armor", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Permanent Diamond Armor", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}",
                "", "&7ÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·ÃÂ½Ã‘â€¹ÃÂµ Ã‘Ë†Ã‘â€šÃÂ°ÃÂ½Ã‘â€¹ ÃÂ¸ Ã‘ÂÃÂ°ÃÂ¿ÃÂ¾ÃÂ³ÃÂ¸", "&7Ãâ€™Ã‘â€¹ ÃÂ²Ã‘ÂÃÂµÃÂ³ÃÂ´ÃÂ° ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€šÃÂµ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ²ÃÂ»Ã‘ÂÃ‘â€šÃ‘Å’Ã‘ÂÃ‘Â", "&7Ã‘Â ÃÂ½ÃÂ¸ÃÂ¼ÃÂ¸ ÃÂ¿Ã‘â‚¬ÃÂ¸ Ã‘ÂÃÂ¼ÃÂµÃ‘â‚¬Ã‘â€šÃÂ¸.", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "&8ÃËœÃÂ½Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘Æ’ÃÂ¼ÃÂµÃÂ½Ã‘â€šÃ‘â€¹", "&aÃËœÃÂ½Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘Æ’ÃÂ¼ÃÂµÃÂ½Ã‘â€šÃ‘â€¹", Collections.singletonList("&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘â€šÃ‘â‚¬ÃÂ°!"));

        addContentMessages(yml, "shears", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}ÃÂÃÂ¾ÃÂ¶ÃÂ½ÃÂ¸Ã‘â€ Ã‘â€¹", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}",
                "", "&7ÃÅ¾Ã‘â€šÃÂ»ÃÂ¸Ã‘â€¡ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ¸ÃÂ½Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘Æ’ÃÂ¼ÃÂµÃÂ½Ã‘â€š ÃÂ´ÃÂ»Ã‘Â ÃÂ»ÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ¸Ã‘Â Ã‘Ë†ÃÂµÃ‘â‚¬Ã‘ÂÃ‘â€šÃÂ¸.", "&7Ãâ€™Ã‘â€¹ ÃÂ²Ã‘ÂÃÂµÃÂ³ÃÂ´ÃÂ° ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€šÃÂµ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ²ÃÂ»Ã‘ÂÃ‘â€šÃ‘Å’Ã‘ÂÃ‘Â Ã‘Â ÃÂ½ÃÂ¾ÃÂ¶ÃÂ½ÃÂ¸Ã‘â€ ÃÂ°ÃÂ¼ÃÂ¸.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "pickaxe", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}ÃÅ¡ÃÂ¸Ã‘â‚¬ÃÂºÃÂ° {tier}", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "&7ÃÂ¤ÃÂ°ÃÂ·ÃÂ°: &e{tier}",
                "", "&7ÃÂ­Ã‘â€šÃÂ¾ Ã‘Æ’ÃÂ»Ã‘Æ’Ã‘â€¡Ã‘Ë†ÃÂ°ÃÂµÃÂ¼Ã‘â€¹ÃÂ¹ ÃÂ¿Ã‘â‚¬ÃÂµÃÂ´ÃÂ¼ÃÂµÃ‘â€š.", "&7Ãâ€¢Ã‘ÂÃÂ»ÃÂ¸ ÃÂ²Ã‘â€¹ Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘â€˜Ã‘â€šÃÂµ, Ã‘â€šÃÂ¾ ÃÂ¾ÃÂ½.", "&7ÃÂ¿ÃÂ¾Ã‘â€šÃÂµÃ‘â‚¬Ã‘ÂÃÂµÃ‘â€š ÃÂ¾ÃÂ´ÃÂ½Ã‘Æ’ Ã‘â€žÃÂ°ÃÂ·Ã‘Æ’!", "", "&7Ãâ€¢Ã‘ÂÃÂ»ÃÂ¸ ÃÂ²Ã‘â€¹ Ã‘Æ’Ã‘â€¦Ã‘Æ’ÃÂ´Ã‘Ë†ÃÂ¸Ã‘â€šÃÂµ Ã‘ÂÃÂ²ÃÂ¾ÃÂ¹", "&7ÃÂ¿Ã‘â‚¬ÃÂµÃÂ´ÃÂ¼ÃÂµÃ‘â€šÃ‘â€¹ ÃÂ´ÃÂ¾ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ»ÃÂµÃÂ´ÃÂ½ÃÂµÃÂ¹ Ã‘â€žÃÂ°ÃÂ·Ã‘â€¹", "&7Ã‘â€šÃÂ¾ ÃÂ²Ã‘â€¹ ÃÂ²Ã‘ÂÃÂµÃÂ³ÃÂ´ÃÂ° ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€šÃÂµ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ²ÃÂ»Ã‘ÂÃ‘â€šÃ‘Å’Ã‘ÂÃ‘Â Ã‘Â Ã‘ÂÃÂ°ÃÂ¼ÃÂ¾ÃÂ¹ ÃÂ½ÃÂ¸ÃÂ¶ÃÂ½ÃÂµÃÂ¹ Ã‘â€žÃÂ°ÃÂ·ÃÂ¾ÃÂ¹.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "axe", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}ÃÂ¢ÃÂ¾ÃÂ¿ÃÂ¾Ã‘â‚¬ {tier}", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "&7ÃÂ¤ÃÂ°ÃÂ·ÃÂ°: &e{tier}",
                "", "&7ÃÂ­Ã‘â€šÃÂ¾ Ã‘Æ’ÃÂ»Ã‘Æ’Ã‘â€¡Ã‘Ë†ÃÂ°ÃÂµÃÂ¼Ã‘â€¹ÃÂ¹ ÃÂ¿Ã‘â‚¬ÃÂµÃÂ´ÃÂ¼ÃÂµÃ‘â€š.", "&7Ãâ€¢Ã‘ÂÃÂ»ÃÂ¸ ÃÂ²Ã‘â€¹ Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘â€˜Ã‘â€šÃÂµ, Ã‘â€šÃÂ¾ ÃÂ¾ÃÂ½.", "&7ÃÂ¿ÃÂ¾Ã‘â€šÃÂµÃ‘â‚¬Ã‘ÂÃÂµÃ‘â€š ÃÂ¾ÃÂ´ÃÂ½Ã‘Æ’ Ã‘â€žÃÂ°ÃÂ·Ã‘Æ’!", "", "&7Ãâ€¢Ã‘ÂÃÂ»ÃÂ¸ ÃÂ²Ã‘â€¹ Ã‘Æ’Ã‘â€¦Ã‘Æ’ÃÂ´Ã‘Ë†ÃÂ¸Ã‘â€šÃÂµ Ã‘ÂÃÂ²ÃÂ¾ÃÂ¹", "&7ÃÂ¿Ã‘â‚¬ÃÂµÃÂ´ÃÂ¼ÃÂµÃ‘â€šÃ‘â€¹ ÃÂ´ÃÂ¾ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ»ÃÂµÃÂ´ÃÂ½ÃÂµÃÂ¹ Ã‘â€žÃÂ°ÃÂ·Ã‘â€¹", "&7Ã‘â€šÃÂ¾ ÃÂ²Ã‘â€¹ ÃÂ²Ã‘ÂÃÂµÃÂ³ÃÂ´ÃÂ° ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€šÃÂµ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ²ÃÂ»Ã‘ÂÃ‘â€šÃ‘Å’Ã‘ÂÃ‘Â Ã‘Â Ã‘ÂÃÂ°ÃÂ¼ÃÂ¾ÃÂ¹ ÃÂ½ÃÂ¸ÃÂ¶ÃÂ½ÃÂµÃÂ¹ Ã‘â€žÃÂ°ÃÂ·ÃÂ¾ÃÂ¹.", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_RANGED, "&8Ãâ€ºÃ‘Æ’ÃÂºÃÂ¸", "&aÃâ€ºÃ‘Æ’ÃÂºÃÂ¸", Collections.singletonList("&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘â€šÃ‘â‚¬ÃÂ°!"));

        addContentMessages(yml, "arrow", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}ÃÂ¡Ã‘â€šÃ‘â‚¬ÃÂµÃÂ»ÃÂ°", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow1", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Ãâ€ºÃ‘Æ’ÃÂº", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow2", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Ãâ€ºÃ‘Æ’ÃÂº (ÃÂ¡ÃÂ¸ÃÂ»ÃÂ° I)", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow3", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Ãâ€ºÃ‘Æ’ÃÂº (ÃÂ¡ÃÂ¸ÃÂ»ÃÂ°  I, ÃÅ¾Ã‘â€šÃÂ´ÃÂ°Ã‘â€¡ÃÂ° I)", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "&8Ãâ€”ÃÂµÃÂ»Ã‘Å’Ã‘Â", "&aÃâ€”ÃÂµÃÂ»Ã‘Å’Ã‘Â", Collections.singletonList("&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘â€šÃ‘â‚¬ÃÂ°!"));

        addContentMessages(yml, "speed-potion", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}Ãâ€”ÃÂµÃÂ»Ã‘Å’ÃÂµ ÃÂ½ÃÂ° ÃÂ¡ÃÂºÃÂ¾Ã‘â‚¬ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’ II (45 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´)", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "jump-potion", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}Ãâ€”ÃÂµÃÂ»Ã‘Å’ÃÂµ ÃÂ½ÃÂ° ÃÅ¸Ã‘â‚¬Ã‘â€¹ÃÂ¶ÃÂ¾ÃÂº V (45 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´)", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "invisibility", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}Ãâ€”ÃÂµÃÂ»Ã‘Å’ÃÂµ ÃÂ½ÃÂµÃÂ²ÃÂ¸ÃÂ´ÃÂ¸ÃÂ¼ÃÂ¾Ã‘ÂÃ‘â€šÃÂ¸ (30 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´)", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "&8ÃÂ ÃÂ°ÃÂ·ÃÂ½ÃÂ¾ÃÂµ", "&aÃÂ ÃÂ°ÃÂ·ÃÂ½ÃÂ¾ÃÂµ", Collections.singletonList("&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘â€šÃ‘â‚¬ÃÂ°!"));

        addContentMessages(yml, "golden-apple", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ãâ€”ÃÂ¾ÃÂ»ÃÂ¾Ã‘â€šÃÂ¾ÃÂµ ÃÂ¯ÃÂ±ÃÂ»ÃÂ¾ÃÂºÃÂ¾", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂ¥ÃÂ¾Ã‘â‚¬ÃÂ¾Ã‘Ë†ÃÂ¾ ÃÂ²ÃÂ¾Ã‘ÂÃ‘ÂÃ‘â€šÃÂ°ÃÂ½ÃÂ°ÃÂ²ÃÂ»ÃÂ¸ÃÂ²ÃÂ°ÃÂµÃ‘â€š ÃÂ·ÃÂ´ÃÂ¾Ã‘â‚¬ÃÂ¾ÃÂ²Ã‘Å’ÃÂµ.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bedbug", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}ÃÂ§ÃÂµÃ‘Ë†Ã‘Æ’ÃÂ¹ÃÂ½ÃÂ¸Ã‘â€ ÃÂ°", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂ¡ÃÂ¿ÃÂ°ÃÂ²ÃÂ½ÃÂ¸Ã‘â€š Ã‘â€¡ÃÂµÃ‘Ë†Ã‘Æ’ÃÂ¹ÃÂ½ÃÂ¸Ã‘â€  ÃÂ¿Ã‘â‚¬ÃÂ¸",
                "&7ÃÂ±Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂ°ÃÂ½ÃÂ¸Ã‘Â Ã‘ÂÃÂ½ÃÂµÃÂ¶ÃÂºÃÂ°.", "&7ÃÅ“ÃÂ¾ÃÂ¶ÃÂµÃ‘â€š Ã‘ÂÃÂºÃÂ¸ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’ ÃÂ²Ã‘â‚¬ÃÂ°ÃÂ³ÃÂ¾ÃÂ², ÃÂ´ÃÂµÃÂ¹Ã‘ÂÃ‘â€šÃÂ²Ã‘Æ’ÃÂµÃ‘â€š 15 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "dream-defender", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½Ã‘â€¹ÃÂ¹ Ãâ€œÃÂ¾ÃÂ»ÃÂµÃÂ¼", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ³ÃÂ¾ÃÂ»ÃÂµÃÂ¼ ÃÂ´ÃÂ»Ã‘Â ÃÂ·ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃ‘â€¹ ÃÂ²ÃÂ°Ã‘Ë†ÃÂµÃÂ¹",
                "&7ÃÂ±ÃÂ°ÃÂ·Ã‘â€¹. Ãâ€ÃÂµÃÂ¹Ã‘ÂÃ‘â€šÃÂ²Ã‘Æ’ÃÂµÃ‘â€š 4 ÃÂ¼ÃÂ¸ÃÂ½Ã‘Æ’Ã‘â€šÃ‘â€¹.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "fireball", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}ÃÂ¤ÃÂ°ÃÂµÃ‘â‚¬ÃÂ±ÃÂ¾ÃÂ»", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸ ÃÅ¸ÃÅ¡ÃÅ“ Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ·ÃÂ°ÃÂ¿Ã‘Æ’Ã‘ÂÃ‘â€šÃÂ¸Ã‘â€šÃ‘Å’!",
                "&7ÃÅ¾ÃÂ³ÃÂ½ÃÂµÃÂ½ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ·ÃÂ°Ã‘â‚¬Ã‘ÂÃÂ´ Ã‘â€¦ÃÂ¾Ã‘â‚¬ÃÂ¾Ã‘Ë†ÃÂµÃÂ½Ã‘Å’ÃÂºÃÂ¾ ÃÂ¿ÃÂ¾ÃÂ´ÃÂ¶ÃÂ°Ã‘â‚¬ÃÂ¸Ã‘â€š", "&7ÃÂ¼ÃÂ¾Ã‘ÂÃ‘â€šÃ‘â€¹ ÃÂ²ÃÂ°Ã‘Ë†ÃÂ¸Ã‘â€¦ ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘â€šÃÂ¸ÃÂ²ÃÂ½ÃÂ¸ÃÂºÃÂ¾ÃÂ²!", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "tnt", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ãâ€ÃÂ¸ÃÂ½ÃÂ°ÃÂ¼ÃÂ¸Ã‘â€š", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂÃÂ²Ã‘â€šÃÂ¾ÃÂ¼ÃÂ°Ã‘â€šÃÂ¸Ã‘â€¡ÃÂµÃ‘ÂÃÂºÃÂ¸ ÃÂ¿ÃÂ¾ÃÂ´ÃÂ¶ÃÂ¸ÃÂ³ÃÂ°ÃÂµÃ‘â€šÃ‘Å’Ã‘ÂÃ‘Â, ÃÂ¿Ã‘â‚¬ÃÂ¸",
                "&7Ã‘â‚¬ÃÂ°ÃÂ·ÃÂ¼ÃÂµÃ‘â€°ÃÂµÃÂ½ÃÂ¸ÃÂ¸!", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "ender-pearl", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}ÃÂ­ÃÂ½ÃÂ´ÃÂµÃ‘â‚¬-ÃÂ¿Ã‘â€˜Ã‘â‚¬ÃÂ»", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂ¡ÃÂ°ÃÂ¼Ã‘â€¹ÃÂ¹ ÃÂ±Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘â€¹ÃÂ¹ Ã‘ÂÃÂ¿ÃÂ¾Ã‘ÂÃÂ¾ÃÂ± ÃÂ´ÃÂ¾ÃÂ±Ã‘â‚¬ÃÂ°Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â",
                "&7ÃÂ´ÃÂ¾ ÃÂ±ÃÂ°ÃÂ·Ã‘â€¹ ÃÂ²ÃÂ°Ã‘Ë†ÃÂµÃÂ³ÃÂ¾ ÃÂ²Ã‘â‚¬ÃÂ°ÃÂ³ÃÂ°.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "water-bucket", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ãâ€™ÃÂµÃÂ´Ã‘â‚¬ÃÂ¾ Ãâ€™ÃÂ¾ÃÂ´Ã‘â€¹", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÅ¾Ã‘â€šÃÂ»ÃÂ¸Ã‘â€¡ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ¼ÃÂµÃ‘â€šÃÂ¾ÃÂ´ ÃÂ·ÃÂ°ÃÂ¼ÃÂµÃÂ´ÃÂ»ÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ²ÃÂ°Ã‘Ë†ÃÂ¸Ã‘â€¦",
                "&7ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘â€šÃÂ¸ÃÂ²ÃÂ½ÃÂ¸ÃÂºÃÂ¾ÃÂ². ÃÂ¢ÃÂ°ÃÂºÃÂ¶ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€š", "&7ÃÂ·ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ¾Ã‘â€š ÃÂ²ÃÂ·Ã‘â‚¬Ã‘â€¹ÃÂ²ÃÂ° ÃÂ´ÃÂ¸ÃÂ½ÃÂ°ÃÂ¼ÃÂ¸Ã‘â€šÃÂ°.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bridge-egg", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}ÃÂ¯ÃÂ¹Ã‘â€ ÃÂ¾", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂ¡ÃÂ¾ÃÂ·ÃÂ´ÃÂ°Ã‘â€˜Ã‘â€š ÃÂ¼ÃÂ¾Ã‘ÂÃ‘â€š, ÃÂ¿ÃÂ¾ ÃÂ·ÃÂ°ÃÂ´ÃÂ°ÃÂ½ÃÂ½ÃÂ¾ÃÂ¹",
                "&7Ã‘â€šÃ‘â‚¬ÃÂ°ÃÂµÃÂºÃ‘â€šÃÂ¾Ã‘â‚¬ÃÂ¸ÃÂ¸ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ»ÃÂµ ÃÂ±Ã‘â‚¬ÃÂ¾Ã‘ÂÃÂºÃÂ°.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "magic-milk", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}ÃÅ“ÃÂ°ÃÂ³ÃÂ¸Ã‘â€¡ÃÂµÃ‘ÂÃÂºÃÂ¾ÃÂµ ÃÅ“ÃÂ¾ÃÂ»ÃÂ¾ÃÂºÃÂ¾", Arrays.asList("&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {cost} {currency}", "", "&7ÃÂ¡ÃÂ½ÃÂ¸ÃÂ¼ÃÂ°ÃÂµÃ‘â€š Ã‘ÂÃ‘â€žÃ‘â€žÃÂµÃÂºÃ‘â€šÃ‘â€¹ ÃÂ²Ã‘ÂÃÂµÃ‘â€¦ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂµÃÂº,",
                "&7ÃÂ¿ÃÂ¾Ã‘ÂÃ‘â€šÃÂ°ÃÂ²ÃÂ»ÃÂµÃÂ½ÃÂ½Ã‘â€¹Ã‘â€¦ ÃÂ½ÃÂ° ÃÂ±ÃÂ°ÃÂ·Ã‘Æ’ ÃÂ¿Ã‘â‚¬ÃÂ¾Ã‘â€šÃÂ¸ÃÂ²ÃÂ½ÃÂ¸ÃÂºÃÂ°, ÃÂ² Ã‘â€šÃÂµÃ‘â€¡ÃÂµÃÂ½ÃÂ¸ÃÂ¸ 60 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "sponge", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ãâ€œÃ‘Æ’ÃÂ±ÃÂºÃÂ°", Arrays.asList("&7Cost: {cost} {currency}", "", "&7Ãâ€™ÃÂ¶ÃÂ¸ÃÂ¼ÃÂ°ÃÂµÃ‘â€š ÃÂ² Ã‘ÂÃÂµÃÂ±Ã‘Â ÃÂ²ÃÂ¾ÃÂ´Ã‘Æ’.",
                "", "{quick_buy}", "{buy_status}"));


        yml.addDefault(Messages.MEANING_FULL, "ÃÅ¸ÃÂ¾ÃÂ»ÃÂ½Ã‘â€¹ÃÂ¹");
        yml.addDefault(Messages.MEANING_IRON_SINGULAR, "Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ¾");
        yml.addDefault(Messages.MEANING_IRON_PLURAL, "Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ°");
        yml.addDefault(Messages.MEANING_GOLD_SINGULAR, "Ãâ€”ÃÂ¾ÃÂ»ÃÂ¾Ã‘â€šÃÂ¾");
        yml.addDefault(Messages.MEANING_GOLD_PLURAL, "Ãâ€”ÃÂ¾ÃÂ»ÃÂ¾Ã‘â€šÃÂ°");
        yml.addDefault(Messages.MEANING_EMERALD_SINGULAR, "ÃËœÃÂ·Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘Æ’ÃÂ´");
        yml.addDefault(Messages.MEANING_EMERALD_PLURAL, "ÃËœÃÂ·Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘Æ’ÃÂ´ÃÂ¾ÃÂ²");
        yml.addDefault(Messages.MEANING_DIAMOND_SINGULAR, "ÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·");
        yml.addDefault(Messages.MEANING_DIAMOND_PLURAL, "ÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·ÃÂ¾ÃÂ²");
        yml.addDefault(Messages.MEANING_VAULT_SINGULAR, "$");
        yml.addDefault(Messages.MEANING_VAULT_PLURAL, "$");

        yml.addDefault(Messages.COMMAND_JOIN_USAGE, "Ã‚Â§aÃ¢â€“Âª Ã‚Â§7ÃËœÃ‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’ÃÂ¹Ã‘â€šÃÂµ: /" + mainCmd + " join Ã‚Â§o<ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂ°/Ã‘â€šÃÂ¸ÃÂ¿>");
        yml.addDefault(Messages.COMMAND_NOT_ALLOWED_IN_GAME, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ Ã‘ÂÃ‘â€šÃÂ¾ÃÂ³ÃÂ¾ Ã‘ÂÃÂ´ÃÂµÃÂ»ÃÂ°Ã‘â€šÃ‘Å’.");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_CLICK_TO_BUY, "&aÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂºÃ‘Æ’ÃÂ¿ÃÂ¸Ã‘â€šÃ‘Å’!");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_INSUFFICIENT_MONEY, "&cÃÂ£ ÃÂ²ÃÂ°Ã‘Â ÃÂ½ÃÂµÃÂ´ÃÂ¾Ã‘ÂÃ‘â€šÃÂ°Ã‘â€šÃÂ¾Ã‘â€¡ÃÂ½ÃÂ¾ {currency}!");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_LOCKED, "&cÃâ€”ÃÂÃâ€˜Ãâ€ºÃÅ¾ÃÅ¡ÃËœÃÂ ÃÅ¾Ãâ€™ÃÂÃÂÃÅ¾");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_UNLOCKED, "&aÃÂ ÃÂÃâ€”Ãâ€˜Ãâ€ºÃÅ¾ÃÅ¡ÃËœÃÂ ÃÅ¾Ãâ€™ÃÂÃÂÃÅ¾");
        yml.addDefault("upgrades.Default.generators.tier1.name", "&eÃâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½ÃÂ°Ã‘Â ÃÂºÃ‘Æ’ÃÂ·ÃÂ½ÃÂ¸Ã‘â€ ÃÂ°");
        yml.addDefault("upgrades.Default.generators.tier1.lore", Arrays.asList("&7ÃÂ£ÃÂ²ÃÂµÃÂ»ÃÂ¸Ã‘â€¡ÃÂ¸ÃÂ²ÃÂ°ÃÂµÃ‘â€š Ã‘ÂÃÂºÃÂ¾Ã‘â‚¬ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’ Ã‘ÂÃÂ¿ÃÂ°ÃÂ²ÃÂ½ÃÂ°", "&7Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ° ÃÂ¸ ÃÂ·ÃÂ¾ÃÂ»ÃÂ¾Ã‘â€šÃÂ° ÃÂ½ÃÂ° 50%..", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault("upgrades.Default.generators.tier2.name", "&eÃâ€”ÃÂ¾ÃÂ»ÃÂ¾Ã‘â€šÃÂ°Ã‘Â ÃÂºÃ‘Æ’ÃÂ·ÃÂ½ÃÂ¸Ã‘â€ ÃÂ°");
        yml.addDefault("upgrades.Default.generators.tier2.lore", Arrays.asList("&7ÃÂ£ÃÂ²ÃÂµÃÂ»ÃÂ¸Ã‘â€¡ÃÂ¸ÃÂ²ÃÂ°ÃÂµÃ‘â€š Ã‘ÂÃÂºÃÂ¾Ã‘â‚¬ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’ Ã‘ÂÃÂ¿ÃÂ°ÃÂ²ÃÂ½ÃÂ°", "&7ÃÂ¶ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ° ÃÂ¸ ÃÂ·ÃÂ¾ÃÂ»ÃÂ¾Ã‘â€šÃÂ° ÃÂ½ÃÂ° 100%..", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault("upgrades.Default.generators.tier3.name", "&eÃËœÃÂ·Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘Æ’ÃÂ´ÃÂ½ÃÂ°Ã‘Â ÃÂºÃ‘Æ’ÃÂ·ÃÂ½ÃÂ¸Ã‘â€ ÃÂ°");
        yml.addDefault("upgrades.Default.generators.tier3.lore", Arrays.asList("&7ÃÂÃÂºÃ‘â€šÃÂ¸ÃÂ²ÃÂ¸Ã‘â‚¬Ã‘Æ’ÃÂµÃ‘â€š ÃÂ·ÃÂ°ÃÂºÃÂ»ÃÂ¸ÃÂ½ÃÂ°Ã‘â€šÃÂµÃÂ»Ã‘Â Ã‚Â«ÃËœÃÂ·Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘Æ’ÃÂ´Ã‚Â»", "&7Ãâ€™ ÃÂºÃ‘Æ’ÃÂ·ÃÂ½ÃÂ¸Ã‘â€ ÃÂµ ÃÂ²ÃÂ°Ã‘Ë†ÃÂµÃÂ¹ ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘â€¹.", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault("upgrades.Default.maniacMiner.tier1.name", "&eÃÅ“ÃÂ°ÃÂ½Ã‘Å’Ã‘ÂÃÂº-ÃÂ¼ÃÂ°ÃÂ¹ÃÂ½ÃÂµÃ‘â‚¬");
        yml.addDefault("upgrades.Default.maniacMiner.tier1.lore", Arrays.asList("&7Ãâ€™Ã‘ÂÃÂµ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¸ ÃÂ²ÃÂ°Ã‘Ë†ÃÂµÃÂ¹ ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘â€¹", "&7ÃÂÃÂ°ÃÂ²Ã‘ÂÃÂµÃÂ³ÃÂ´ÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ°Ã‘â€š Ã‘Æ’Ã‘ÂÃÂºÃÂ¾Ã‘â‚¬ÃÂµÃÂ½ÃÂ¸ÃÂµ I", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault("upgrades.Default.sharpSword.tier1.name", "&eÃâ€”ÃÂ°ÃÂ¾Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂµÃÂ½ÃÂ½Ã‘â€¹ÃÂµ ÃÂ¼ÃÂµÃ‘â€¡ÃÂ¸");
        yml.addDefault("upgrades.Default.sharpSword.tier1.lore", Arrays.asList("&7Ãâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ¸Ã‘â€š ÃÂ ÃÂµÃÂ·ÃÂºÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’ I", "&7ÃÂÃÂ° ÃÂ²Ã‘ÂÃÂµÃ‘â€¦ ÃÂ¼ÃÂµÃ‘â€¡ÃÂ°Ã‘â€¦!", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault("upgrades.Default.reinforced.tier1.name", "&eÃÂ£ÃÂºÃ‘â‚¬ÃÂµÃÂ¿ÃÂ»ÃÂµÃÂ½ÃÂ½ÃÂ°Ã‘Â ÃÂ±Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â");
        yml.addDefault("upgrades.Default.reinforced.tier1.lore", Arrays.asList("&7Ãâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° ÃÂ¿ÃÂ¾ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ¸Ã‘â€š Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃ‘Æ’ I", "&7ÃÂÃÂ° ÃÂ²Ã‘ÂÃÂµÃÂ¹ ÃÂ±Ã‘â‚¬ÃÂ¾ÃÂ½ÃÂµ!", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault("upgrades.Default.trap.tier1.name", "&eÃÂ­Ã‘â€šÃÂ¾ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ°!");
        yml.addDefault("upgrades.Default.trap.tier1.lore", Arrays.asList("&7Ãâ€™Ã‘â‚¬ÃÂ°ÃÂ³, ÃÂ¿Ã‘â€¹Ã‘â€šÃÂ°Ã‘Å½Ã‘â€°ÃÂ¸ÃÂ¹Ã‘ÂÃ‘Â ÃÂ·ÃÂ°ÃÂ¹Ã‘â€šÃÂ¸ ÃÂ½ÃÂ° ÃÂ²ÃÂ°Ã‘Ë†Ã‘Æ’ ÃÂ±ÃÂ°ÃÂ·Ã‘Æ’", "&7ÃÅ¸ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ¸Ã‘â€š Ã‘ÂÃÂ»ÃÂµÃÂ¿ÃÂ¾Ã‘â€šÃ‘Æ’", "&7ÃÂ¸ ÃÂ¼ÃÂµÃÂ´ÃÂ»ÃÂ¸Ã‘â€šÃÂµÃÂ»Ã‘Å’ÃÂ½ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’!", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault("upgrades.Default.miningFatigue.tier1.name", "&eÃÂ¨ÃÂ°Ã‘â€¦Ã‘â€šÃÂµÃ‘â‚¬Ã‘ÂÃÂºÃÂ°Ã‘Â Ã‘Æ’Ã‘ÂÃ‘â€šÃÂ°ÃÂ»ÃÂ¾Ã‘ÂÃ‘â€šÃÂ½ÃÂ°Ã‘Â ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ°");
        yml.addDefault("upgrades.Default.miningFatigue.tier1.lore", Arrays.asList("&7Ãâ€™Ã‘â‚¬ÃÂ°ÃÂ³, ÃÂ¿Ã‘â€¹Ã‘â€šÃÂ°Ã‘Å½Ã‘â€°ÃÂ¸ÃÂ¹Ã‘ÂÃ‘Â ÃÂ·ÃÂ°ÃÂ¹Ã‘â€šÃÂ¸ ÃÂ½ÃÂ° ÃÂ²ÃÂ°Ã‘Ë†Ã‘Æ’ ÃÂ±ÃÂ°ÃÂ·Ã‘Æ’", "&7Ãâ€™ Ã‘â€šÃÂµÃ‘â€¡ÃÂµÃÂ½ÃÂ¸ÃÂ¸ 10 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´ ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ¸Ã‘â€š", "&7Ã‘Æ’Ã‘ÂÃ‘â€šÃÂ°ÃÂ»ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’!", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault("upgrades.Default.healPool.tier1.name", "&eÃËœÃ‘ÂÃ‘â€ ÃÂµÃÂ»Ã‘ÂÃ‘Å½Ã‘â€°ÃÂµÃÂµ ÃÂ¿ÃÂ¾ÃÂ»ÃÂµ");
        yml.addDefault("upgrades.Default.healPool.tier1.lore", Arrays.asList("&7ÃÂ¡ÃÂ¾ÃÂ·ÃÂ´ÃÂ°ÃÂµÃ‘â€š ÃÂ¿ÃÂ¾ÃÂ»ÃÂµ Ã‘â‚¬ÃÂµÃÂ³ÃÂµÃÂ½ÃÂ¸Ã‘â‚¬ÃÂ°Ã‘â€ ÃÂ¸ÃÂ¸", "&7ÃÂ²ÃÂ¾ÃÂºÃ‘â‚¬Ã‘Æ’ÃÂ³ ÃÂ²ÃÂ°Ã‘Ë†ÃÂµÃÂ¹ ÃÂ±ÃÂ°ÃÂ·Ã‘â€¹!", "", "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°:&b {cost} {currency}", "", "{loreFooter}"));
        yml.addDefault(Messages.UPGRADES_UPGRADE_BOUGHT_CHAT, "&a{player} ÃÂºÃ‘Æ’ÃÂ¿ÃÂ¸ÃÂ» Ã‘Æ’ÃÂ»Ã‘Æ’Ã‘â€¡Ã‘Ë†ÃÂµÃÂ½ÃÂ¸ÃÂµ &6{upgradeName}");
        yml.addDefault(Messages.FORMATTING_DESPAWNABLE_UTILITY_NPC_HEALTH, "Ã¢â€“Â® ");
        yml.addDefault(Messages.PLAYER_DIE_UNKNOWN_REASON_REGULAR, "{PlayerColor}{PlayerName} &7Ã‘Æ’ÃÂ¼ÃÂµÃ‘â‚¬.");
        yml.addDefault(Messages.PLAYER_DIE_UNKNOWN_REASON_FINAL_KILL, "{PlayerColor}{PlayerName} &7Ã‘Æ’ÃÂ¼ÃÂµÃ‘â‚¬. &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_SHOOT_REGULAR, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ±ÃÂ¸Ã‘â€š ÃÂ²Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂµÃÂ»ÃÂ¾ÃÂ¼ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {KillerColor}{KillerName}&7!");
        yml.addDefault(Messages.PLAYER_DIE_SHOOT_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ±ÃÂ¸Ã‘â€š ÃÂ²Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂµÃÂ»ÃÂ¾ÃÂ¼ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {KillerColor}{KillerName}&7! &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_DEBUG_REGULAR, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ±ÃÂ¸Ã‘â€š Ã‘â€¡ÃÂµÃ‘Ë†Ã‘Æ’ÃÂ¹ÃÂ½ÃÂ¸Ã‘â€ ÃÂµÃÂ¹ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {KillerColor}{KillerTeamName}!");
        yml.addDefault(Messages.PLAYER_DIE_DEBUG_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ±ÃÂ¸Ã‘â€š ÃÂ§ÃÂµÃ‘Ë†Ã‘Æ’ÃÂ¹ÃÂ½ÃÂ¸Ã‘â€ ÃÂµÃÂ¹ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {KillerColor}{KillerTeamName}! &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_IRON_GOLEM_REGULAR, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ±ÃÂ¸Ã‘â€š Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½Ã‘â€¹ÃÂ¼ Ãâ€œÃÂ¾ÃÂ»ÃÂµÃÂ¼ÃÂ¾ÃÂ¼ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {KillerColor}{KillerTeamName}!");
        yml.addDefault(Messages.PLAYER_DIE_IRON_GOLEM_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ±ÃÂ¸Ã‘â€š Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½Ã‘â€¹ÃÂ¼ Ãâ€œÃÂ¾ÃÂ»ÃÂµÃÂ¼ÃÂ¾ÃÂ¼ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {KillerColor}{KillerTeamName}! &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_DIAMOND, "{prefix}&b+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_EMERALD, "{prefix}&a+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_IRON, "{prefix}&f+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_GOLD, "{prefix}&6+{amount} {meaning}");

        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITHOUT_SOURCE_REGULAR, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» ÃÂ²ÃÂ·ÃÂ¾Ã‘â‚¬ÃÂ²ÃÂ°ÃÂ½ ÃÂ±ÃÂ¾ÃÂ¼ÃÂ±ÃÂ¾ÃÂ¹.");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITHOUT_SOURCE_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃÂ±Ã‘â€¹ÃÂ» ÃÂ²ÃÂ·ÃÂ¾Ã‘â‚¬ÃÂ²ÃÂ°ÃÂ½ ÃÂ±ÃÂ¾ÃÂ¼ÃÂ±ÃÂ¾ÃÂ¹. &b&lÃÂ¤ÃËœÃÂÃÂÃâ€ºÃÂ¬ÃÂÃÅ¾Ãâ€¢ ÃÂ£Ãâ€˜ÃËœÃâ„¢ÃÂ¡ÃÂ¢Ãâ€™ÃÅ¾!");
        yml.addDefault(Messages.PLAYER_STATS_GUI_INV_NAME, "&8ÃÂ¡Ã‘â€šÃÂ°Ã‘â€šÃÂ¸Ã‘ÂÃ‘â€šÃÂ¸ÃÂºÃÂ° ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° {player}");

        /* save default items messages for stats gui */
        addDefaultStatsMsg(yml, "wins", "&6ÃÅ¸ÃÂ¾ÃÂ±ÃÂµÃÂ´", "&f{wins}");
        addDefaultStatsMsg(yml, "losses", "&6ÃÅ¸Ã‘â‚¬ÃÂ¾ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘â€¹Ã‘Ë†ÃÂµÃÂ¹", "&f{losses}");
        addDefaultStatsMsg(yml, "kills", "&6ÃÂ£ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²", "&f{kills}");
        addDefaultStatsMsg(yml, "deaths", "&6ÃÂ¡ÃÂ¼ÃÂµÃ‘â‚¬Ã‘â€šÃÂµÃÂ¹", "&f{deaths}");
        addDefaultStatsMsg(yml, "final-kills", "&6ÃÂ¤ÃÂ¸ÃÂ½ÃÂ°ÃÂ»Ã‘Å’ÃÂ½Ã‘â€¹Ã‘â€¦ Ã‘Æ’ÃÂ±ÃÂ¸ÃÂ¹Ã‘ÂÃ‘â€šÃÂ²", "&f{finalKills}");
        addDefaultStatsMsg(yml, "final-deaths", "&6ÃÂ¤ÃÂ¸ÃÂ½ÃÂ°ÃÂ»Ã‘Å’ÃÂ½Ã‘â€¹Ã‘â€¦ Ã‘ÂÃÂ¼ÃÂµÃ‘â‚¬Ã‘â€šÃÂµÃÂ¹", "&f{finalDeaths}");
        addDefaultStatsMsg(yml, "beds-destroyed", "&6ÃÅ¡Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂµÃÂ¹ Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ¾", "&f{bedsDestroyed}");
        addDefaultStatsMsg(yml, "first-play", "&6ÃÅ¸ÃÂµÃ‘â‚¬ÃÂ²ÃÂ°Ã‘Â ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ°", "&f{firstPlay}");
        addDefaultStatsMsg(yml, "last-play", "&6ÃÅ¸ÃÂ¾Ã‘ÂÃÂ»ÃÂµÃÂ´ÃÂ½Ã‘ÂÃ‘Â ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ°", "&f{lastPlay}");
        addDefaultStatsMsg(yml, "games-played", "&6ÃËœÃÂ³Ã‘â‚¬ Ã‘ÂÃ‘â€¹ÃÂ³Ã‘â‚¬ÃÂ°ÃÂ½ÃÂ¾", "&f{gamesPlayed}");
        yml.addDefault(Messages.FORMATTING_STATS_DATE_FORMAT, "yyyy/MM/dd HH:mm");

        yml.addDefault(Messages.MEANING_NEVER, "ÃÂÃÂ¸ÃÂºÃÂ¾ÃÂ³ÃÂ´ÃÂ°");
        yml.addDefault(Messages.SCOREBOARD_LOBBY, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&fÃâ€™ÃÂ°Ã‘Ë† Ã‘Æ’Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂµÃÂ½Ã‘Å’: {level}",
                "",
                "&fÃÅ¸Ã‘â‚¬ÃÂ¾ÃÂ³Ã‘â‚¬ÃÂµÃ‘ÂÃ‘Â: &a{currentXp}&7/&b{requiredXp}",
                "{progress}",
                "",
                "&7{player}",
                "",
                "&fÃÅ“ÃÂ¾ÃÂ½ÃÂµÃ‘â€š: &a{money}",
                "",
                "&fÃâ€™Ã‘ÂÃÂµÃÂ³ÃÂ¾ ÃÂ¿ÃÂ¾ÃÂ±ÃÂµÃÂ´: &a{wins}",
                "&fÃâ€™Ã‘ÂÃÂµÃÂ³ÃÂ¾ Ã‘Æ’ÃÂ±ÃÂ¹ÃÂ¸Ã‘ÂÃ‘â€šÃÂ²: &a{kills}",
                "",
                "&e{serverIp}")
        );

        /* party commands */
        yml.addDefault(Messages.COMMAND_PARTY_HELP, Arrays.asList("&6Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&aÃÅ¡ÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘â€¹ ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸:",
                "&e/party help &7- &bÃÅ¸ÃÂ¾ÃÂºÃÂ°ÃÂ·Ã‘â€¹ÃÂ²ÃÂ°ÃÂµÃ‘â€š ÃÂ²Ã‘ÂÃÂµ ÃÂ´ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Æ’ÃÂ¿ÃÂ½Ã‘â€¹ÃÂµ ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘â€¹",
                "&e/party invite <ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº> &7- &bÃÅ¸Ã‘â‚¬ÃÂ¸ÃÂ³ÃÂ»ÃÂ°Ã‘ÂÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° ÃÂ² ÃÂ²ÃÂ°Ã‘Ë†ÃÂµ ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸",
                "&e/party leave &7- &bÃâ€™Ã‘â€¹ÃÂ¹Ã‘â€šÃÂ¸ ÃÂ¸ÃÂ· ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸",
                "&e/party info &7- &bShow party members and owner",
                "&e/party promote <player> &7- &bTransfer party ownership",
                "&e/party remove <ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº> &7- &bÃâ€™Ã‘â€¹ÃÂ³ÃÂ½ÃÂ°Ã‘â€šÃ‘Å’ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ° ÃÂ¸ÃÂ· ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸",
                "&e/party accept <ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº> &7- &bÃÅ¸Ã‘â‚¬ÃÂ¸ÃÂ½Ã‘ÂÃ‘â€šÃ‘Å’ ÃÂ¿Ã‘â‚¬ÃÂ¸ÃÂ³ÃÂ»ÃÂ°Ã‘Ë†ÃÂµÃÂ½ÃÂ¸ÃÂµ ÃÂ² ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸",
                "&e/party disband &7- &bÃÂ ÃÂ°Ã‘ÂÃ‘â€žÃÂ¸Ã‘â‚¬ÃÂ¼ÃÂ¸Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’ Ã‘â€šÃÂµÃÂºÃ‘Æ’Ã‘Å½Ã‘â€°Ã‘Æ’Ã‘Å½ ÃÂ³Ã‘â‚¬Ã‘Æ’ÃÂ¿ÃÂ¿Ã‘Æ’")
        );
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_USAGE, "{prefix}&eÃËœÃ‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’ÃÂ¹Ã‘â€šÃÂµ: &7/party invite <ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº>");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_PLAYER_OFFLINE, "{prefix}&7{player} &eÃÂ½ÃÂµ ÃÂ¾ÃÂ½ÃÂ»ÃÂ°ÃÂ¹ÃÂ½!");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_SENT, "{prefix}&eÃÅ¸Ã‘â‚¬ÃÂ¸ÃÂ³ÃÂ»ÃÂ°Ã‘Ë†ÃÂµÃÂ½ÃÂ¸ÃÂµ ÃÂ¾Ã‘â€šÃÂ¿Ã‘â‚¬ÃÂ°ÃÂ²ÃÂ»ÃÂµÃÂ½ÃÂ¾ &7{player}&6.");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_SENT_TARGET_RECEIVE_MSG, "{prefix}&b{player} &eÃÂ¿Ã‘â‚¬ÃÂ¸ÃÂ³ÃÂ»ÃÂ°Ã‘ÂÃÂ¸ÃÂ» ÃÂ²ÃÂ°Ã‘Â ÃÂ² ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸! &o&7(ÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ¿Ã‘â‚¬ÃÂ¸ÃÂ½Ã‘ÂÃ‘â€šÃ‘Å’)");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_CANNOT_INVITE_YOURSELF, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ ÃÂ¿Ã‘â‚¬ÃÂ¸ÃÂ³ÃÂ»ÃÂ°Ã‘ÂÃÂ¸Ã‘â€šÃ‘Å’ Ã‘ÂÃÂ°ÃÂ¼ÃÂ¾ÃÂ³ÃÂ¾ Ã‘ÂÃÂµÃÂ±Ã‘Â!");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_DENIED_NO_INVITE, "{prefix}&cÃÂÃÂµÃ‘â€š ÃÂ¿Ã‘â‚¬ÃÂ¸ÃÂ³ÃÂ»ÃÂ°Ã‘Ë†ÃÂµÃÂ½ÃÂ¸ÃÂ¹ ÃÂ² ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸.");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_DENIED_ALREADY_IN_PARTY, "{prefix}&eÃâ€™Ã‘â€¹ Ã‘Æ’ÃÂ¶ÃÂµ ÃÂ² ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸!");
        yml.addDefault(Messages.COMMAND_PARTY_INSUFFICIENT_PERMISSIONS, "{prefix}&cÃÂ¢ÃÂ¾ÃÂ»Ã‘Å’ÃÂºÃÂ¾ ÃÂ²ÃÂ»ÃÂ°ÃÂ´ÃÂµÃÂ»ÃÂµÃ‘â€  ÃÂ¿ÃÂ°Ã‘â‚¬Ã‘â€šÃÂ¸ÃÂ¸ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€š Ã‘ÂÃ‘â€šÃÂ¾ Ã‘ÂÃÂ´ÃÂµÃÂ»ÃÂ°Ã‘â€šÃ‘Å’!");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_USAGE, "{prefix}&eÃËœÃ‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’ÃÂ¹Ã‘â€šÃÂµ: &7/party accept <ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº>");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_SUCCESS, "{prefix}&7{player} &eÃÂ¿Ã‘â‚¬ÃÂ¸Ã‘ÂÃÂ¾ÃÂµÃÂ´ÃÂ¸ÃÂ½ÃÂ¸ÃÂ»Ã‘ÂÃ‘Â ÃÂº ÃÂ³Ã‘â‚¬Ã‘Æ’ÃÂ¿ÃÂ¿ÃÂµ!");
        yml.addDefault(Messages.COMMAND_PARTY_GENERAL_DENIED_NOT_IN_PARTY, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ² ÃÂ³Ã‘â‚¬Ã‘Æ’ÃÂ¿ÃÂ¿ÃÂµ!");
        yml.addDefault(Messages.COMMAND_PARTY_LEAVE_DENIED_IS_OWNER_NEEDS_DISBAND, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ ÃÂ¿ÃÂ¾ÃÂºÃÂ¸ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’ Ã‘ÂÃÂ²ÃÂ¾Ã‘Å½ Ã‘ÂÃÂ¾ÃÂ±Ã‘ÂÃ‘â€šÃÂ²ÃÂµÃÂ½ÃÂ½ÃÂ¾ÃÂµ ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸!\n&eÃÅ¸ÃÂ¾ÃÂ¿Ã‘â‚¬ÃÂ¾ÃÂ±Ã‘Æ’ÃÂ¹Ã‘â€šÃÂµ: &b/party disband");
        yml.addDefault(Messages.COMMAND_PARTY_LEAVE_SUCCESS, "{prefix}&7{player} &eÃÂ²Ã‘â€¹Ã‘Ë†ÃÂµÃÂ» ÃÂ¸ÃÂ· ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸!");
        yml.addDefault(Messages.COMMAND_PARTY_DISBAND_SUCCESS, "{prefix}&eÃÅ¸ÃÂ°Ã‘â€šÃÂ¸ Ã‘â‚¬ÃÂ°Ã‘ÂÃ‘â€žÃÂ°Ã‘â‚¬ÃÂ¼ÃÂ¸Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°ÃÂ½ÃÂ½ÃÂ¾!");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_USAGE, "{prefix}&7ÃËœÃ‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’ÃÂ¹Ã‘â€šÃÂµ: &e/party remove <ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂº>");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_SUCCESS, "{prefix}&7{player} &eÃÂ±Ã‘â€¹ÃÂ» Ã‘Æ’ÃÂ´ÃÂ°ÃÂ»ÃÂµÃÂ½ ÃÂ¸ÃÂ· ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸.");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_DENIED_TARGET_NOT_PARTY_MEMBER, "{prefix}&7{player} &eÃÂ½ÃÂµ Ã‘ÂÃÂ¾Ã‘ÂÃ‘â€šÃÂ¾ÃÂ¸Ã‘â€š ÃÂ² ÃÂ²ÃÂ°Ã‘Ë†ÃÂµÃÂ¼ ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸!");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_SUCCESS, "{prefix}&eÃâ€™Ã‘â€¹ Ã‘Æ’Ã‘ÂÃÂ¿ÃÂµÃ‘Ë†ÃÂ½ÃÂ¾ ÃÂ¿ÃÂ¾ÃÂ²Ã‘â€¹Ã‘ÂÃÂ¸ÃÂ»ÃÂ¸ {player} ÃÂ´ÃÂ¾ ÃÂ²ÃÂ»ÃÂ°ÃÂ´ÃÂµÃÂ»Ã‘Å’Ã‘â€ ÃÂ°");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_OWNER, "{prefix}&eÃâ€™Ã‘â€¹ ÃÂ±Ã‘â€¹ÃÂ»ÃÂ¸ ÃÂ¿ÃÂ¾ÃÂ²Ã‘â€¹Ã‘Ë†ÃÂµÃÂ½Ã‘â€¹ ÃÂ´ÃÂ¾ ÃÂ²ÃÂ»ÃÂ°ÃÂ´ÃÂµÃÂ»Ã‘Å’Ã‘â€ ÃÂ° ÃÂ³Ã‘â‚¬Ã‘Æ’ÃÂ¿ÃÂ¿Ã‘â€¹");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_NEW_OWNER, "{prefix}&7 &e{player} ÃÂ±Ã‘â€¹ÃÂ» ÃÂ¿ÃÂ¾ÃÂ²Ã‘â€¹Ã‘Ë†ÃÂµÃÂ½ ÃÂ´ÃÂ¾ ÃÂ²ÃÂ»ÃÂ°ÃÂ´ÃÂµÃÂ»Ã‘Å’Ã‘â€ ÃÂ° ÃÂ³Ã‘â‚¬Ã‘Æ’ÃÂ¿ÃÂ¿Ã‘â€¹");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_OWNER, "\n{prefix}&eÃâ€™ÃÂ»ÃÂ°ÃÂ´ÃÂµÃÂ»ÃÂµÃ‘â€  ÃÂ³Ã‘â‚¬Ã‘Æ’ÃÂ¿ÃÂ¿Ã‘â€¹: &7{owner}");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_PLAYERS,"{prefix}&eÃÂ£Ã‘â€¡ÃÂ°Ã‘ÂÃ‘â€šÃÂ½ÃÂ¸ÃÂºÃÂ¸ ÃÂ³Ã‘â‚¬Ã‘Æ’ÃÂ¿ÃÂ¿Ã‘â€¹:");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_PLAYER, "&7{player}");
        yml.addDefault(Messages.NEXT_EVENT_BEDS_DESTROY, "&cÃÂ£ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½ÃÂ¸ÃÂµ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂµÃÂ¹");
        yml.addDefault(Messages.NEXT_EVENT_DIAMOND_UPGRADE_II, "&fÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·Ã‘â€¹ II");
        yml.addDefault(Messages.NEXT_EVENT_DIAMOND_UPGRADE_III, "&fÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·Ã‘â€¹ III");
        yml.addDefault(Messages.NEXT_EVENT_DRAGON_SPAWN, "&fÃâ€™ÃÂ½ÃÂµÃÂ·ÃÂ°ÃÂ¿ÃÂ½ÃÂ°Ã‘Â Ã‘ÂÃÂ¼ÃÂµÃ‘â‚¬Ã‘â€šÃ‘Å’");
        yml.addDefault(Messages.NEXT_EVENT_EMERALD_UPGRADE_II, "&fÃËœÃÂ·Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘Æ’ÃÂ´Ã‘â€¹ II");
        yml.addDefault(Messages.NEXT_EVENT_EMERALD_UPGRADE_III, "&fÃËœÃÂ·Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘Æ’ÃÂ´Ã‘â€¹ III");
        yml.addDefault(Messages.NEXT_EVENT_GAME_END, "&4ÃËœÃÂ³Ã‘â‚¬ÃÂ° ÃÂ·ÃÂ°ÃÂºÃÂ¾ÃÂ½Ã‘â€¡ÃÂ¸Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â");
        yml.addDefault(Messages.NEXT_EVENT_TITLE_ANNOUNCE_BEDS_DESTROYED, "&cÃâ€™ÃÂÃÂ¨ÃÂ ÃÅ¡ÃÂ ÃÅ¾Ãâ€™ÃÂÃÂ¢ÃÂ¬ ÃÂ£ÃÂÃËœÃÂ§ÃÂ¢ÃÅ¾Ãâ€“Ãâ€¢ÃÂÃÂ!");
        yml.addDefault(Messages.NEXT_EVENT_SUBTITLE_ANNOUNCE_BEDS_DESTROYED, "&fÃâ€™Ã‘ÂÃÂµ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸ ÃÂ±Ã‘â€¹ÃÂ»ÃÂ¸ Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½Ã‘â€¹!");
        yml.addDefault(Messages.NEXT_EVENT_CHAT_ANNOUNCE_BEDS_DESTROYED, "&c&lÃâ€™Ã‘ÂÃÂµ ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃÂ¸ ÃÂ±Ã‘â€¹ÃÂ»ÃÂ¸ Ã‘Æ’ÃÂ½ÃÂ¸Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ¶ÃÂµÃÂ½Ã‘â€¹!");
        yml.addDefault(Messages.NEXT_EVENT_TITLE_ANNOUNCE_SUDDEN_DEATH, "&cÃÂ¡ÃÂ¼ÃÂµÃ‘â‚¬Ã‘â€šÃ‘Å’");
        yml.addDefault(Messages.NEXT_EVENT_SUBTITLE_ANNOUNCE_SUDDEN_DEATH, "");
        yml.addDefault(Messages.NEXT_EVENT_CHAT_ANNOUNCE_SUDDEN_DEATH, "&cÃÂ¡ÃÅ“Ãâ€¢ÃÂ ÃÂ¢ÃÂ¬: &6&b{TeamDragons} {TeamColor}{TeamName} Dragon!");
        yml.addDefault(Messages.COMMAND_NOT_FOUND_OR_INSUFF_PERMS, "{prefix}&cÃÅ¡ÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° ÃÂ½ÃÂµ ÃÂ½ÃÂ°ÃÂ¹ÃÂ´ÃÂµÃÂ½ÃÂ° ÃÂ¸ÃÂ»ÃÂ¸ Ã‘Æ’ ÃÂ²ÃÂ°Ã‘Â ÃÂ½ÃÂµÃ‘â€š ÃÂ¿Ã‘â‚¬ÃÂ°ÃÂ²!");
        yml.addDefault(Messages.COMMAND_FORCESTART_NOT_IN_GAME, "Ã‚Â§cÃ¢â€“Âª Ã‚Â§7Ãâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ°ÃÂµÃ‘â€šÃÂµ!");
        yml.addDefault(Messages.COMMAND_FORCESTART_SUCCESS, "Ã‚Â§cÃ¢â€“Âª Ã‚Â§7ÃÅ¾ÃÂ±Ã‘â‚¬ÃÂ°Ã‘â€šÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ¾Ã‘â€šÃ‘ÂÃ‘â€¡ÃÂµÃ‘â€š Ã‘ÂÃÂ¾ÃÂºÃ‘â‚¬ÃÂ°Ã‘â€°ÃÂµÃÂ½!");
        yml.addDefault(Messages.COMMAND_FORCESTART_NO_PERM, "{prefix}&7Ãâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ Ã‘ÂÃÂ¾ÃÂºÃ‘â‚¬ÃÂ°Ã‘â€šÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ²Ã‘â‚¬ÃÂµÃÂ¼Ã‘Â Ã‘ÂÃ‘â€šÃÂ°Ã‘â‚¬Ã‘â€šÃÂ°.\nÃ‚Â§7ÃÅ¸ÃÂ¾ÃÂ´Ã‘Æ’ÃÂ¼ÃÂ°ÃÂ¹Ã‘â€šÃÂµ ÃÂ¾ Ã‘â€šÃÂ¾ÃÂ¼, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂºÃ‘Æ’ÃÂ¿ÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ´ÃÂ¾ÃÂ½ÃÂ°Ã‘â€š.");
        yml.addDefault(Messages.COMMAND_JOIN_SPECTATOR_MSG, "{prefix}Ã‚Â§6ÃÂ¢Ã‘â€¹ Ã‘â€šÃÂµÃÂ¿ÃÂµÃ‘â‚¬Ã‘Å’ ÃÂ½ÃÂ°ÃÂ±ÃÂ»Ã‘Å½ÃÂ´ÃÂ°ÃÂµÃ‘Ë†Ã‘Å’ ÃÂ·ÃÂ° Ã‚Â§9{arena}Ã‚Â§6.\n{prefix}Ã‚Â§eÃâ€ÃÂ»Ã‘Â ÃÂ²Ã‘â€¹Ã‘â€¦ÃÂ¾ÃÂ´ÃÂ° Ã‘Â ÃÂ°Ã‘â‚¬ÃÂµÃÂ½Ã‘â€¹ ÃÂ¸Ã‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’ÃÂ¹ Ã‚Â§c/leaveÃ‚Â§e.");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_NAME, "&8ÃÂ¢ÃÂµÃÂ»ÃÂµÃÂ¿ÃÂ¾Ã‘â‚¬Ã‘â€šÃÂµÃ‘â‚¬"); // Ãâ€ÃÂ°-ÃÂ´ÃÂ° :D
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_HEAD_NAME, "{vPrefix}{player}");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_HEAD_LORE, Arrays.asList("&7Ãâ€”ÃÂ´ÃÂ¾Ã‘â‚¬ÃÂ¾ÃÂ²Ã‘Å’ÃÂµ: &f{health}%", "&7ÃÂÃÂ°Ã‘ÂÃ‘â€¹Ã‘â€°ÃÂµÃÂ½ÃÂ½ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’: &f{food}", "", "&7Ãâ€ºÃÅ¡ÃÅ“ ÃÂ´ÃÂ»Ã‘Â Ã‘ÂÃÂ»ÃÂµÃÂ¶ÃÂºÃÂ¸"));
        yml.addDefault(Messages.ARENA_SPECTATOR_LEAVE_ITEM_NAME, "&c&lÃâ€™ÃÂµÃ‘â‚¬ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’Ã‘Â ÃÂ² ÃÂ»ÃÂ¾ÃÂ±ÃÂ±ÃÂ¸");
        yml.addDefault(Messages.ARENA_SPECTATOR_LEAVE_ITEM_LORE, Collections.singletonList("&7ÃÂ©ÃÂµÃÂ»ÃÂºÃÂ½ÃÂ¸Ã‘â€šÃÂµ ÃÂ¿Ã‘â‚¬ÃÂ°ÃÂ²ÃÂ¾ÃÂ¹ ÃÂºÃÂ½ÃÂ¾ÃÂ¿ÃÂºÃÂ¾ÃÂ¹ ÃÂ¼Ã‘â€¹Ã‘Ë†ÃÂ¸, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ²ÃÂµÃ‘â‚¬ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂ² ÃÂ»ÃÂ¾ÃÂ±ÃÂ±ÃÂ¸!"));
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_ENTER_TITLE, "&aÃÂ¡ÃÂ»ÃÂµÃÂ¶ÃÂºÃÂ° ÃÂ·ÃÂ° &7{player}");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_ENTER_SUBTITLE, "&cÃÂ¨ÃËœÃÂ¤ÃÂ¢ ÃÂ´ÃÂ»Ã‘Â ÃÂ²Ã‘â€¹Ã‘â€¦ÃÂ¾ÃÂ´ÃÂ°");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_LEAVE_TITLE, "&eÃÅ¸ÃÂ¾ÃÂºÃÂ¸ÃÂ´ÃÂ°ÃÂ½ÃÂ¸ÃÂµ Ã‘â‚¬ÃÂµÃÂ¶ÃÂ¸ÃÂ¼ÃÂ° Ã‘ÂÃÂ»ÃÂµÃÂ¶ÃÂºÃÂ¸");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_LEAVE_SUBTITLE, "");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_PLAYER_OFFLINE, "{prefix}&7{player} &eÃÂ¾Ã‘â€žÃ‘â€žÃÂ»ÃÂ°ÃÂ¹ÃÂ½!");
        yml.addDefault(Messages.COMMAND_JOIN_SPECTATOR_DENIED_MSG, "&cÃÂÃÂ° Ã‘ÂÃ‘â€šÃÂ¾ÃÂ¹ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂµ ÃÂ¾Ã‘â€šÃÂºÃÂ»Ã‘Å½Ã‘â€¡ÃÂµÃÂ½ÃÂ° Ã‘ÂÃÂ»ÃÂµÃÂ¶ÃÂºÃÂ°!");
        yml.addDefault(Messages.ARENA_LEAVE_PARTY_DISBANDED, "{prefix}Ã‚Â§cÃâ€™ÃÂ»ÃÂ°ÃÂ´ÃÂµÃÂ»ÃÂµÃ‘â€  ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸ ÃÂ¿ÃÂ¾ÃÂºÃÂ¸ÃÂ½Ã‘Æ’Ã‘â€š Ã‘ÂÃÂµÃ‘â‚¬ÃÂ²ÃÂµÃ‘â‚¬, ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸ Ã‘â‚¬ÃÂ°Ã‘ÂÃÂ¿Ã‘Æ’Ã‘â€°ÃÂµÃÂ½ÃÂ°!"); // ÃÅ“ÃÂ¾ÃÂ¶ÃÂ½ÃÂ¾ Ã‘ÂÃÂ¼ÃÂµÃÂ½ÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ½ÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘Æ’ ÃÂ² Ã‘â€ ÃÂµÃÂ»ÃÂ¾ÃÂ¼, Ã‘ÂÃÂ»ÃÂµÃÂ½ÃÂ³ÃÂ¾ÃÂ²ÃÂ¾ÃÂµ Ã‘ÂÃÂ»ÃÂ¾ÃÂ²ÃÂ¾ ÃÂ¿ÃÂ°Ã‘â€šÃÂ¸ Ã‘â€šÃÂ¾ÃÂ¶ÃÂµ ÃÂ½ÃÂ¾Ã‘â‚¬ÃÂ¼.
                                                                                                                         // Ãâ€ÃÂ¾ÃÂ±ÃÂ°ÃÂ²ÃÂ»ÃÂµÃÂ½ÃÂ¾ Matveev_: Ã‘ÂÃÂ¾ÃÂ³ÃÂ», Ã‘ÂÃÂ»ÃÂµÃÂ½ÃÂ³ÃÂ¾ÃÂ²ÃÂ¾ÃÂµ ÃÂ»Ã‘Æ’Ã‘â€¡Ã‘Ë†ÃÂµ, Ã‘â€¦ÃÂ°Ã‘â‚¬ÃÂ¾Ã‘Ë†

        /* Lobby Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "stats"), "&eÃÂ¡Ã‘â€šÃÂ°Ã‘â€šÃÂ¸Ã‘ÂÃ‘â€šÃÂ¸ÃÂºÃÂ°");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "stats"), Collections.singletonList("&fÃÅ¸ÃÅ¡ÃÅ“, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ Ã‘Æ’ÃÂ²ÃÂ¸ÃÂ´ÃÂµÃ‘â€šÃ‘Å’ Ã‘ÂÃÂ²ÃÂ¾Ã‘Å½ Ã‘ÂÃ‘â€šÃÂ°Ã‘â€šÃÂ¸Ã‘ÂÃ‘â€šÃÂ¸ÃÂºÃ‘Æ’!"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "arena-selector"), "&eÃÂÃ‘â‚¬ÃÂµÃÂ½Ã‘â€¹");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "arena-selector"), Collections.singletonList("&fÃâ€™Ã‘â€¹ÃÂ±ÃÂµÃ‘â‚¬ÃÂ¸Ã‘â€šÃÂµ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½Ã‘Æ’!"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "leave"), "&eÃâ€™ÃÂµÃ‘â‚¬ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’Ã‘Â ÃÂ² ÃÂ»ÃÂ¾ÃÂ±ÃÂ±ÃÂ¸");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fÃÂ©ÃÂµÃÂ»ÃÂºÃÂ½ÃÂ¸Ã‘â€šÃÂµ ÃÂ¿Ã‘â‚¬ÃÂ°ÃÂ²ÃÂ¾ÃÂ¹ ÃÂºÃÂ½ÃÂ¾ÃÂ¿ÃÂºÃÂ¾ÃÂ¹ ÃÂ¼Ã‘â€¹Ã‘Ë†ÃÂ¸, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ²ÃÂµÃ‘â‚¬ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂ² ÃÂ»ÃÂ¾ÃÂ±ÃÂ±ÃÂ¸!"));
        /* Pre Game Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_NAME.replace("%path%", "stats"), "&eÃÂ¡Ã‘â€šÃÂ°Ã‘â€šÃÂ¸Ã‘ÂÃ‘â€šÃÂ¸ÃÂºÃÂ°");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_LORE.replace("%path%", "stats"), Collections.singletonList("&fÃÅ¸ÃÅ¡ÃÅ“, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ Ã‘Æ’ÃÂ²ÃÂ¸ÃÂ´ÃÂµÃ‘â€šÃ‘Å’ Ã‘ÂÃÂ²ÃÂ¾Ã‘Å½ Ã‘ÂÃ‘â€šÃÂ°Ã‘â€šÃÂ¸Ã‘ÂÃ‘â€šÃÂ¸ÃÂºÃ‘Æ’!"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_NAME.replace("%path%", "leave"), "&eÃâ€™ÃÂµÃ‘â‚¬ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’Ã‘Â ÃÂ² ÃÂ»ÃÂ¾ÃÂ±ÃÂ±ÃÂ¸");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fÃÂ©ÃÂµÃÂ»ÃÂºÃÂ½ÃÂ¸Ã‘â€šÃÂµ ÃÂ¿Ã‘â‚¬ÃÂ°ÃÂ²ÃÂ¾ÃÂ¹ ÃÂºÃÂ½ÃÂ¾ÃÂ¿ÃÂºÃÂ¾ÃÂ¹ ÃÂ¼Ã‘â€¹Ã‘Ë†ÃÂ¸, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ²ÃÂµÃ‘â‚¬ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂ² ÃÂ»ÃÂ¾ÃÂ±ÃÂ±ÃÂ¸!"));
        /* Spectator Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_NAME.replace("%path%", "teleporter"), "&eÃÂ¢ÃÂµÃÂ»ÃÂµÃÂ¿ÃÂ¾Ã‘â‚¬Ã‘â€šÃÂµÃ‘â‚¬");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_LORE.replace("%path%", "teleporter"), Collections.singletonList("&fÃÅ¸ÃÅ¡ÃÅ“, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ½ÃÂ°ÃÂ±ÃÂ»Ã‘Å½ÃÂ´ÃÂ°Ã‘â€šÃ‘Å’ ÃÂ·ÃÂ° ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ°ÃÂ¼ÃÂ¸!"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_NAME.replace("%path%", "leave"), "&eÃâ€™ÃÂµÃ‘â‚¬ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’Ã‘Â ÃÂ² ÃÂ»ÃÂ¾ÃÂ±ÃÂ±ÃÂ¸");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fÃÂ©ÃÂµÃÂ»ÃÂºÃÂ½ÃÂ¸Ã‘â€šÃÂµ ÃÂ¿Ã‘â‚¬ÃÂ°ÃÂ²ÃÂ¾ÃÂ¹ ÃÂºÃÂ½ÃÂ¾ÃÂ¿ÃÂºÃÂ¾ÃÂ¹ ÃÂ¼Ã‘â€¹Ã‘Ë†ÃÂ¸, Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ²ÃÂµÃ‘â‚¬ÃÂ½Ã‘Æ’Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂ² ÃÂ»ÃÂ¾ÃÂ±ÃÂ±ÃÂ¸!"));

        yml.addDefault(Messages.COMMAND_COOLDOWN, "&cÃâ€™Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ Ã‘ÂÃÂ´ÃÂµÃÂ»ÃÂ°Ã‘â€šÃ‘Å’ Ã‘ÂÃ‘â€šÃÂ¾ÃÂ³ÃÂ¾! ÃÅ¸ÃÂ¾ÃÂ´ÃÂ¾ÃÂ¶ÃÂ´ÃÂ¸Ã‘â€šÃÂµ ÃÂµÃ‘â€°ÃÂµ {seconds} Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´!");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_TEAM, "{TeamColor}[{TeamName}]");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_SHOUT, "&6[Ãâ€™ÃÂ¡Ãâ€¢ÃÅ“]");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_SPECTATOR, "&7[ÃÂÃÂÃâ€˜Ãâ€ºÃÂ®Ãâ€ÃÂÃÂ¢Ãâ€¢Ãâ€ºÃÂ¬]");
        yml.addDefault(Messages.ARENA_JOIN_DENIED_SELECTOR, "{prefix}&cÃËœÃÂ·ÃÂ²ÃÂ¸ÃÂ½ÃÂ¸Ã‘â€šÃÂµ, ÃÂ½ÃÂ¾ ÃÂ²Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ ÃÂ¿Ã‘â‚¬ÃÂµÃ‘ÂÃÂ¾ÃÂµÃÂ´ÃÂµÃÂ½ÃÂ¸Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂº Ã‘ÂÃ‘â€šÃÂ¾ÃÂ¹ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂµ ÃÂ¿Ã‘â‚¬Ã‘ÂÃÂ¼ÃÂ¾ Ã‘ÂÃÂµÃÂ¹Ã‘â€¡ÃÂ°Ã‘Â. ÃËœÃ‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’ÃÂ¹Ã‘â€šÃÂµ ÃÅ¸ÃÅ¡ÃÅ“ ÃÂ´ÃÂ»Ã‘Â Ã‘â‚¬ÃÂµÃÂ¶ÃÂ¸ÃÂ¼ÃÂ° ÃÂ½ÃÂ°ÃÂ±ÃÂ»Ã‘Å½ÃÂ´ÃÂ°Ã‘â€šÃÂµÃÂ»ÃÂµÃÂ¹!");
        yml.addDefault(Messages.ARENA_SPECTATE_DENIED_SELECTOR, "{prefix}&cÃËœÃÂ·ÃÂ²ÃÂ¸ÃÂ½ÃÂ¸Ã‘â€šÃÂµ, ÃÂ½ÃÂ¾ ÃÂ²Ã‘â€¹ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ ÃÂ½ÃÂ°ÃÂ±ÃÂ»Ã‘Å½ÃÂ´ÃÂ°Ã‘â€šÃ‘Å’ ÃÂ·ÃÂ° Ã‘ÂÃ‘â€šÃÂ¾ÃÂ¹ ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂ¾ÃÂ¹ ÃÂ¿Ã‘â‚¬Ã‘ÂÃÂ¼ÃÂ¾ Ã‘ÂÃÂµÃÂ¹Ã‘â€¡ÃÂ°Ã‘Â. ÃËœÃ‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’ÃÂ¹Ã‘â€šÃÂµ Ãâ€ºÃÅ¡ÃÅ“ ÃÂ´ÃÂ»Ã‘Â ÃÂ²Ã‘â€¦ÃÂ¾ÃÂ´ÃÂ° ÃÂ² ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘Æ’!");
        yml.addDefault(Messages.ARENA_JOIN_DENIED_NO_PROXY, "&cÃËœÃÂ·ÃÂ²ÃÂ¸ÃÂ½ÃÂ¸Ã‘â€šÃÂµ, ÃÂ½ÃÂ¾ ÃÂ²Ã‘â€¹ ÃÂ´ÃÂ¾ÃÂ»ÃÂ¶ÃÂ½Ã‘â€¹ ÃÂ¿ÃÂ¾ÃÂ´ÃÂºÃÂ»Ã‘Å½Ã‘â€¡ÃÂ¸Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂº ÃÂ°Ã‘â‚¬ÃÂµÃÂ½ÃÂµ, ÃÂ¸Ã‘ÂÃÂ¿ÃÂ¾ÃÂ»Ã‘Å’ÃÂ·Ã‘Æ’Ã‘Â BedWarsProxy!");

        yml.addDefault(Messages.REJOIN_NO_ARENA, "{prefix}&cÃÂÃ‘â‚¬ÃÂµÃÂ½ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿ÃÂµÃ‘â‚¬ÃÂµÃÂ·ÃÂ°Ã‘â€¦ÃÂ¾ÃÂ´ÃÂ° ÃÂ½ÃÂµ ÃÂ½ÃÂ°ÃÂ¹ÃÂ´ÃÂµÃÂ½ÃÂ¾!");
        yml.addDefault(Messages.REJOIN_DENIED, "{prefix}&cÃâ€™Ã‘â€¹ ÃÂ±ÃÂ¾ÃÂ»Ã‘Å’Ã‘Ë†ÃÂµ ÃÂ½ÃÂµ ÃÂ¼ÃÂ¾ÃÂ¶ÃÂµÃ‘â€šÃÂµ ÃÂ¿ÃÂµÃ‘â‚¬ÃÂµÃÂ·ÃÂ°ÃÂ¹Ã‘â€šÃÂ¸. ÃËœÃÂ³Ã‘â‚¬ÃÂ° ÃÂ¾ÃÂºÃÂ¾ÃÂ½Ã‘â€¡ÃÂµÃÂ½ÃÂ° ÃÂ¸ÃÂ»ÃÂ¸ ÃÂ²ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’ ÃÂ±Ã‘â€¹ÃÂ»ÃÂ° Ã‘â‚¬ÃÂ°ÃÂ·Ã‘â‚¬Ã‘Æ’Ã‘Ë†ÃÂµÃÂ½ÃÂ°.");
        yml.addDefault(Messages.REJOIN_ALLOWED, "{prefix}&eÃÅ¸ÃÂµÃ‘â‚¬ÃÂµÃÂ½ÃÂ¾Ã‘ÂÃÂ¸ÃÂ¼ ÃÂ²ÃÂ°Ã‘Â ÃÂ² ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘Æ’, ÃÂ½ÃÂ° ÃÂºÃÂ°Ã‘â‚¬Ã‘â€šÃ‘Æ’ &a{arena}&e!");


        yml.addDefault(Messages.MEANING_NO_TRAP, "Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ¸ ÃÂ¾Ã‘â€šÃ‘ÂÃ‘Æ’Ã‘â€šÃ‘ÂÃ‘â€šÃÂ²Ã‘Æ’Ã‘Å½Ã‘â€š!");
        yml.addDefault(Messages.FORMAT_SPECTATOR_TARGET, "{targetTeamColor}{targetDisplayName}");
        yml.addDefault(Messages.FORMAT_UPGRADE_TRAP_COST, "&7ÃÂ¦ÃÂµÃÂ½ÃÂ°: {currencyColor}{cost} {currency}");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_CAN_AFFORD, "&e");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_CANT_AFFORD, "&c");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_UNLOCKED, "&a");
        yml.addDefault(Messages.FORMAT_UPGRADE_TIER_LOCKED, "&7");
        yml.addDefault(Messages.FORMAT_UPGRADE_TIER_UNLOCKED, "&a");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_CLICK_TO_BUY, "{color}ÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸ ÃÂ´ÃÂ»Ã‘Â ÃÂ¿ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ¸!");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_INSUFFICIENT_MONEY, "{color}ÃÂ¢ÃÂµÃÂ±ÃÂµ ÃÂ½ÃÂµ Ã‘â€¦ÃÂ²ÃÂ°Ã‘â€šÃÂ°ÃÂµÃ‘â€š {currency}");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_LOCKED, "&cÃâ€”ÃÂÃâ€˜Ãâ€ºÃÅ¾ÃÅ¡ÃËœÃÂ ÃÅ¾Ãâ€™ÃÂÃÂÃÅ¾");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_UNLOCKED, "{color}ÃÂ ÃÂÃâ€”Ãâ€˜Ãâ€ºÃÅ¾ÃÅ¡ÃËœÃÂ ÃÅ¾Ãâ€™ÃÂÃÂÃÅ¾");
        yml.addDefault(Messages.UPGRADES_UPGRADE_BOUGHT_CHAT, "&a{player} ÃÂºÃ‘Æ’ÃÂ¿ÃÂ¸ÃÂ» &6{upgradeName}");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-1"), "{color}Ãâ€“ÃÂµÃÂ»ÃÂµÃÂ·ÃÂ½ÃÂ°Ã‘Â ÃÅ¸ÃÂµÃ‘â€¡Ã‘Å’");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "forge"),
                Arrays.asList("&7Ãâ€ÃÂµÃÂ»ÃÂ°ÃÂµÃ‘â€š ÃÂ±Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂµÃÂµ Ã‘ÂÃÂ¿ÃÂ°ÃÂ²ÃÂ½ÃÂµÃ‘â‚¬", "&7Ã‘â‚¬ÃÂµÃ‘ÂÃ‘Æ’Ã‘â‚¬Ã‘ÂÃÂ¾ÃÂ² ÃÂ²ÃÂ°Ã‘Ë†ÃÂµÃÂ³ÃÂ¾ ÃÂ¾Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂ¾ÃÂ²ÃÂ°.", "", "{tier_1_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 1: +50% ÃÅ¡ Ã‘â‚¬ÃÂµÃ‘ÂÃ‘Æ’Ã‘â‚¬Ã‘ÂÃÂ°ÃÂ¼, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 2: +100% ÃÅ¡ Ã‘â‚¬ÃÂµÃ‘ÂÃ‘Æ’Ã‘â‚¬Ã‘ÂÃÂ°ÃÂ¼, &b{tier_2_cost} {tier_2_currency}",
                        "{tier_3_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 3: ÃÂ¡ÃÂ¿ÃÂ°ÃÂ²ÃÂ½ÃÂ¸Ã‘â€š ÃÂ¸ÃÂ·Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘Æ’ÃÂ´Ã‘â€¹, &b{tier_3_cost} {tier_3_currency}",
                        "{tier_4_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 4: +200% ÃÅ¡ Ã‘â‚¬ÃÂµÃ‘ÂÃ‘Æ’Ã‘â‚¬Ã‘ÂÃÂ°ÃÂ¼, &b{tier_4_cost} {tier_4_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-2"), "{color}Ãâ€”ÃÂ¾ÃÂ»ÃÂ¾Ã‘â€šÃÂ°Ã‘Â ÃÅ¸ÃÂµÃ‘â€¡Ã‘Å’");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-3"), "{color}ÃËœÃÂ·Ã‘Æ’ÃÂ¼Ã‘â‚¬Ã‘Æ’ÃÂ´ÃÂ½ÃÂ°Ã‘Â ÃÅ¸ÃÂµÃ‘â€¡Ã‘Å’");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-4"), "{color}ÃÂÃÂ»ÃÂ¼ÃÂ°ÃÂ·ÃÂ½ÃÂ°Ã‘Â ÃÅ¸ÃÂµÃ‘â€¡Ã‘Å’");
        yml.addDefault(Messages.UPGRADES_CATEGORY_ITEM_NAME_PATH + "traps", "&eÃÅ¡Ã‘Æ’ÃÂ¿ÃÂ¸Ã‘â€šÃ‘Å’ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃ‘Æ’");
        yml.addDefault(Messages.UPGRADES_CATEGORY_ITEM_LORE_PATH + "traps", Arrays.asList("&7ÃÅ¡Ã‘Æ’ÃÂ¿ÃÂ»ÃÂµÃÂ½ÃÂ½Ã‘â€¹ÃÂµ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ¸ ÃÂ±Ã‘Æ’ÃÂ´Ã‘Æ’Ã‘â€š", "&7Ã‘â‚¬ÃÂ°ÃÂ·ÃÂ¼ÃÂµÃ‘â€°ÃÂµÃÂ½ÃÂ½Ã‘â€¹ ÃÂ² ÃÂ¾Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ´ÃÂ¸.", "", "&eÃÂÃÂ°ÃÂ¶ÃÂ¼ÃÂ¸Ã‘â€šÃÂµ Ã‘â€¡Ã‘â€šÃÂ¾ÃÂ±Ã‘â€¹ ÃÂ¿ÃÂ¾Ã‘ÂÃÂ¼ÃÂ¾Ã‘â€šÃ‘â‚¬ÃÂµÃ‘â€šÃ‘Å’!"));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "swords").replace("{tier}", "tier-1"), "{color}Ãâ€”ÃÂ°ÃÂ¾Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘â€˜ÃÂ½ÃÂ½Ã‘â€¹ÃÂµ ÃÅ“ÃÂµÃ‘â€¡ÃÂ¸");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "swords"),
                Arrays.asList("&7Ãâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ¸Ã‘â€š", "&7ÃÅ¾Ã‘ÂÃ‘â€šÃ‘â‚¬ÃÂ¾Ã‘â€šÃ‘Æ’ I ÃÂ½ÃÂ° ÃÂ²Ã‘ÂÃÂµ ÃÂ¼ÃÂµÃ‘â€¡ÃÂ¸,", "&7ÃÂ° Ã‘â€šÃÂ°ÃÂºÃÂ¶ÃÂµ Ã‘â€šÃÂ¾ÃÂ¿ÃÂ¾Ã‘â‚¬Ã‘â€¹!", "", "{tier_1_color}ÃÂ¦ÃÂµÃÂ½ÃÂ°: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-1"), "{color}Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€°Ã‘â€˜ÃÂ½ÃÂ°Ã‘Â Ãâ€˜Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â I");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "armor"),
                Arrays.asList("&7Ãâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ¸Ã‘â€š", "&7Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃ‘Æ’ I ÃÂ½ÃÂ° ÃÂ²Ã‘ÂÃ‘Å½ ÃÂ±Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Å½!", "", "{tier_1_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 1: Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃÂ° I, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 2: Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃÂ° II, &b{tier_2_cost} {tier_2_currency}",
                        "{tier_3_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 3: Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃÂ° III, &b{tier_3_cost} {tier_3_currency}",
                        "{tier_4_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 4: Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€šÃÂ° IV, &b{tier_4_cost} {tier_4_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-2"), "{color}Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€°Ã‘â€˜ÃÂ½ÃÂ°Ã‘Â Ãâ€˜Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â II");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-3"), "{color}Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€°Ã‘â€˜ÃÂ½ÃÂ°Ã‘Â Ãâ€˜Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â III");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-4"), "{color}Ãâ€”ÃÂ°Ã‘â€°ÃÂ¸Ã‘â€°Ã‘â€˜ÃÂ½ÃÂ°Ã‘Â Ãâ€˜Ã‘â‚¬ÃÂ¾ÃÂ½Ã‘Â IV");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "miner").replace("{tier}", "tier-1"), "{color}Ãâ€˜Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘â€¹ÃÂ¹ ÃÂ¨ÃÂ°Ã‘â€¦Ã‘â€šÃ‘â€˜Ã‘â‚¬ I");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "miner"),
                Arrays.asList("&7Ãâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° ÃÂ¿ÃÂ¾ÃÂ»Ã‘Æ’Ã‘â€¡ÃÂ¸Ã‘â€š", "&7ÃÂ¡ÃÂ¿ÃÂµÃ‘Ë†ÃÂºÃ‘Æ’ I.", "", "{tier_1_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 1: ÃÂ¡ÃÂ¿ÃÂµÃ‘Ë†ÃÂºÃÂ° I, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}ÃÂ¤ÃÂ°ÃÂ·ÃÂ° 2: ÃÂ¡ÃÂ¿ÃÂµÃ‘Ë†ÃÂºÃÂ° II, &b{tier_2_cost} {tier_2_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "miner").replace("{tier}", "tier-2"), "{color}Ãâ€˜Ã‘â€¹Ã‘ÂÃ‘â€šÃ‘â‚¬Ã‘â€¹ÃÂ¹ ÃÂ¨ÃÂ°Ã‘â€¦Ã‘â€šÃ‘â€˜Ã‘â‚¬ II");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "heal-pool").replace("{tier}", "tier-1"), "{color}ÃËœÃ‘ÂÃ‘â€ ÃÂµÃÂ»Ã‘ÂÃ‘Å½Ã‘â€°ÃÂµÃÂµ ÃÅ¸ÃÂ¾ÃÂ»ÃÂµ");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "heal-pool"),
                Arrays.asList("&7ÃÂ¡ÃÂ¾ÃÂ·ÃÂ´ÃÂ°Ã‘â€˜Ã‘â€š ÃÂ¸Ã‘ÂÃ‘â€ ÃÂµÃÂ»Ã‘ÂÃ‘Å½Ã‘â€°ÃÂµÃÂµ ÃÂ¿ÃÂ¾ÃÂ»ÃÂµ", "&7ÃÂ²ÃÂ¾ÃÂºÃ‘â‚¬Ã‘Æ’ÃÂ³ ÃÂ²ÃÂ°Ã‘Ë†ÃÂµÃÂ¹ ÃÂ±ÃÂ°ÃÂ·Ã‘â€¹!", "", "{tier_1_color}ÃÂ¦ÃÂµÃÂ½ÃÂ°: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "dragon").replace("{tier}", "tier-1"), "{color}Ãâ€Ã‘â‚¬ÃÂ°ÃÂºÃÂ¾ÃÂ½Ã‘â€¹");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "dragon"),
                Arrays.asList("&7Ãâ€™ÃÂ°Ã‘Ë†ÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ° ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€š ÃÂ¸ÃÂ¼ÃÂµÃ‘â€šÃ‘Å’ 2 ÃÂ´Ã‘â‚¬ÃÂ°ÃÂºÃÂ¾ÃÂ½ÃÂ¾ÃÂ²,", "&7ÃÂ²ÃÂ¼ÃÂµÃ‘ÂÃ‘â€šÃÂ¾ 1 ÃÂ²ÃÂ¾ ÃÂ²Ã‘â‚¬ÃÂµÃÂ¼Ã‘Â ÃÂºÃÂ¾ÃÂ½Ã‘â€ ÃÂ° ÃÂ¸ÃÂ³Ã‘â‚¬Ã‘â€¹!", "", "{tier_1_color}ÃÂ¦ÃÂµÃÂ½ÃÂ°: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + "glass", "&8Ã¢Â¬â€ &7ÃÅ¸ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂ°ÃÂµÃÂ¼ÃÂ¾ÃÂµ");
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + "glass", Collections.singletonList("&8Ã¢Â¬â€¡&7ÃÅ¾Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ´Ã‘Å’ Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂµÃÂº"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "first", "{color}Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ° #1: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "first", Arrays.asList("&7ÃÅ¸ÃÂµÃ‘â‚¬ÃÂ²Ã‘â€¹ÃÂ¹ Ã‘â€¡ÃÂµÃÂ»ÃÂ¾ÃÂ²ÃÂµÃÂº ÃÂºÃÂ¾Ã‘â€šÃÂ¾Ã‘â‚¬Ã‘â€¹ÃÂ¹ ÃÂ·ÃÂ°ÃÂ¹ÃÂ´Ã‘â€˜Ã‘â€š", "&7ÃÂ½ÃÂ° ÃÂ±ÃÂ°ÃÂ·Ã‘Æ’, ÃÂ°ÃÂºÃ‘â€šÃÂ¸ÃÂ²ÃÂ¸Ã‘â‚¬Ã‘Æ’ÃÂµÃ‘â€š", "&7Ã‘ÂÃ‘â€šÃ‘Æ’ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃ‘Æ’!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "first",
                Arrays.asList("", "&7ÃÅ¸ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ° ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ¸,", "&7ÃÂ´ÃÂ¾ÃÂ±ÃÂ°ÃÂ²ÃÂ¸Ã‘â€š ÃÂµÃ‘â€˜ ÃÂ² ÃÂ¾Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ´Ã‘Å’. Ãâ€¢Ã‘â€˜ Ã‘â€ ÃÂµÃÂ½ÃÂ°", "&7ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€š Ã‘Æ’ÃÂ²ÃÂµÃÂ»ÃÂ¸Ã‘â€¡ÃÂ¸ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂ¿ÃÂ¾ ÃÂ¼ÃÂµÃ‘â‚¬ÃÂµ", "&7Ã‘â€¡ÃÂ¸Ã‘ÂÃÂ»ÃÂ° ÃÂºÃ‘Æ’ÃÂ¿ÃÂ»ÃÂµÃÂ½ÃÂ½Ã‘â€¹Ã‘â€¦ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂµÃÂº.", "", "&7ÃÂ¡ÃÂ»ÃÂµÃÂ´Ã‘Æ’Ã‘â€°Ã‘ÂÃ‘Â ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ°: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "second", "{color}Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ° #2: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "second", Arrays.asList("&7Ãâ€™Ã‘â€šÃÂ¾Ã‘â‚¬ÃÂ¾ÃÂ¹ Ã‘â€¡ÃÂµÃÂ»ÃÂ¾ÃÂ²ÃÂµÃÂº ÃÂºÃÂ¾Ã‘â€šÃÂ¾Ã‘â‚¬Ã‘â€¹ÃÂ¹ ÃÂ·ÃÂ°ÃÂ¹ÃÂ´Ã‘â€˜Ã‘â€š", "&7ÃÂ½ÃÂ° ÃÂ±ÃÂ°ÃÂ·Ã‘Æ’, ÃÂ°ÃÂºÃ‘â€šÃÂ¸ÃÂ²ÃÂ¸Ã‘â‚¬Ã‘Æ’ÃÂµÃ‘â€š", "&7Ã‘ÂÃ‘â€šÃ‘Æ’ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃ‘Æ’!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "second",
                Arrays.asList("", "&7ÃÅ¸ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ° ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ¸,", "&7ÃÂ´ÃÂ¾ÃÂ±ÃÂ°ÃÂ²ÃÂ¸Ã‘â€š ÃÂµÃ‘â€˜ ÃÂ² ÃÂ¾Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ´Ã‘Å’. Ãâ€¢Ã‘â€˜ Ã‘â€ ÃÂµÃÂ½ÃÂ°", "&7ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€š Ã‘Æ’ÃÂ²ÃÂµÃÂ»ÃÂ¸Ã‘â€¡ÃÂ¸ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂ¿ÃÂ¾ ÃÂ¼ÃÂµÃ‘â‚¬ÃÂµ", "&7Ã‘â€¡ÃÂ¸Ã‘ÂÃÂ»ÃÂ° ÃÂºÃ‘Æ’ÃÂ¿ÃÂ»ÃÂµÃÂ½ÃÂ½Ã‘â€¹Ã‘â€¦ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂµÃÂº.", "", "&7ÃÂ¡ÃÂ»ÃÂµÃÂ´Ã‘Æ’Ã‘â€°Ã‘ÂÃ‘Â ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ°: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "third", "{color}Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ° #3: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "third", Arrays.asList("&7ÃÂ¢Ã‘â‚¬ÃÂµÃ‘â€šÃÂ¸ÃÂ¹ Ã‘â€¡ÃÂµÃÂ»ÃÂ¾ÃÂ²ÃÂµÃÂº ÃÂºÃÂ¾Ã‘â€šÃÂ¾Ã‘â‚¬Ã‘â€¹ÃÂ¹ ÃÂ·ÃÂ°ÃÂ¹ÃÂ´Ã‘â€˜Ã‘â€š", "&7ÃÂ½ÃÂ° ÃÂ±ÃÂ°ÃÂ·Ã‘Æ’, ÃÂ°ÃÂºÃ‘â€šÃÂ¸ÃÂ²ÃÂ¸Ã‘â‚¬Ã‘Æ’ÃÂµÃ‘â€š", "&7Ã‘ÂÃ‘â€šÃ‘Æ’ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃ‘Æ’!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "third",
                Arrays.asList("", "&7ÃÅ¸ÃÂ¾ÃÂºÃ‘Æ’ÃÂ¿ÃÂºÃÂ° ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ¸,", "&7ÃÂ´ÃÂ¾ÃÂ±ÃÂ°ÃÂ²ÃÂ¸Ã‘â€š ÃÂµÃ‘â€˜ ÃÂ² ÃÂ¾Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ´Ã‘Å’. Ãâ€¢Ã‘â€˜ Ã‘â€ ÃÂµÃÂ½ÃÂ°", "&7ÃÂ±Ã‘Æ’ÃÂ´ÃÂµÃ‘â€š Ã‘Æ’ÃÂ²ÃÂµÃÂ»ÃÂ¸Ã‘â€¡ÃÂ¸ÃÂ²ÃÂ°Ã‘â€šÃ‘Å’Ã‘ÂÃ‘Â ÃÂ¿ÃÂ¾ ÃÂ¼ÃÂµÃ‘â‚¬ÃÂµ", "&7Ã‘â€¡ÃÂ¸Ã‘ÂÃÂ»ÃÂ° ÃÂºÃ‘Æ’ÃÂ¿ÃÂ»ÃÂµÃÂ½ÃÂ½Ã‘â€¹Ã‘â€¦ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂµÃÂº.", "", "&7ÃÂ¡ÃÂ»ÃÂµÃÂ´Ã‘Æ’Ã‘â€°Ã‘ÂÃ‘Â ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ°: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "1", "{color}ÃÂ­Ã‘â€šÃÂ¾ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ°!");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "1", Arrays.asList("&7ÃÂÃÂ°ÃÂºÃÂ»ÃÂ°ÃÂ´Ã‘â€¹ÃÂ²ÃÂ°ÃÂµÃ‘â€š ÃÂ¡ÃÂ»ÃÂµÃÂ¿ÃÂ¾Ã‘â€šÃ‘Æ’ ÃÂ¸ ÃÅ“ÃÂµÃÂ´ÃÂ»ÃÂ¸Ã‘â€šÃÂµÃÂ»Ã‘Å’ÃÂ½ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’", "&7ÃÂ½ÃÂ° 5 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "2", "{color}Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ°-ÃÅ¸ÃÂ¾ÃÂ¼ÃÂ¾Ã‘â€°ÃÂ½ÃÂ¸ÃÂº");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "2", Arrays.asList("&7Ãâ€ÃÂ°Ã‘â€˜Ã‘â€š ÃÂ²ÃÂ°ÃÂ¼ ÃÂ¸ ÃÂ²ÃÂ°Ã‘Ë†ÃÂ¸ÃÂ¼ Ã‘ÂÃÂ¾Ã‘Å½ÃÂ·ÃÂ½ÃÂ¸ÃÂºÃÂ°ÃÂ¼", "&7Ã‘ÂÃÂºÃÂ¾Ã‘â‚¬ÃÂ¾Ã‘ÂÃ‘â€šÃ‘Å’ I ÃÂ½ÃÂ° 15 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "3", "{color}Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ° Ã‘Â ÃÂ¢Ã‘â‚¬ÃÂµÃÂ²ÃÂ¾ÃÂ³ÃÂ¾ÃÂ¹");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "3", Arrays.asList("&7ÃÅ¸ÃÂ¾ÃÂºÃÂ°ÃÂ·Ã‘â€¹ÃÂ²ÃÂ°ÃÂµÃ‘â€š ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ², ÃÂºÃÂ¾Ã‘â€šÃÂ¾Ã‘â‚¬Ã‘â€¹ÃÂµ ÃÂ±Ã‘â€¹ÃÂ»ÃÂ¸", "&7Ã‘Â ÃÂ·ÃÂµÃÂ»Ã‘Å’ÃÂµÃÂ¼ ÃÂ½ÃÂµÃÂ²ÃÂ¸ÃÂ´ÃÂ¸ÃÂ¼ÃÂ¾Ã‘ÂÃ‘â€šÃÂ¸.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "4", "{color}Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ° ÃÅ“ÃÂµÃÂ´ÃÂ»ÃÂµÃÂ½ÃÂ½Ã‘â€¹ÃÂ¹ ÃÂ¨ÃÂ°Ã‘â€¦Ã‘â€šÃ‘â€˜Ã‘â‚¬");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "4", Arrays.asList("&7Ãâ€”ÃÂ°ÃÂ¼ÃÂµÃÂ´ÃÂ»Ã‘ÂÃÂµÃ‘â€š ÃÂºÃÂ¾ÃÂ¿ÃÂ°ÃÂ½ÃÂ¸ÃÂµ ÃÂ½ÃÂ°", "&710 Ã‘ÂÃÂµÃÂºÃ‘Æ’ÃÂ½ÃÂ´.", ""));
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + "back", "&aÃÂÃÂ°ÃÂ·ÃÂ°ÃÂ´");
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + "back", Collections.singletonList("&7ÃÅ¡ ÃÂ£ÃÂ»Ã‘Æ’Ã‘â€¡Ã‘Ë†ÃÂµÃÂ½ÃÂ¸Ã‘ÂÃÂ¼ ÃÂ¸ Ãâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ°ÃÂ¼"));
        yml.addDefault(Messages.UPGRADES_CATEGORY_GUI_NAME_PATH + "traps", "&8ÃÅ¾Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ´Ã‘Å’ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂµÃÂº");
        yml.addDefault(Messages.UPGRADES_TRAP_QUEUE_LIMIT, "&cÃÅ¾Ã‘â€¡ÃÂµÃ‘â‚¬ÃÂµÃÂ´Ã‘Å’ ÃÂ»ÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂµÃÂº ÃÂ¿ÃÂµÃ‘â‚¬ÃÂµÃÂ¿ÃÂ¾ÃÂ»ÃÂ½ÃÂµÃÂ½ÃÂ°!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_MSG, "&c&lÃâ€™ÃÂ°Ã‘Ë†ÃÂ° {trap} ÃÂ±Ã‘â€¹ÃÂ»(ÃÂ°) ÃÂ¾Ã‘â€šÃÂºÃÂ»Ã‘Å½Ã‘â€¡ÃÂµÃÂ½ÃÂ°!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_TITLE, "&cÃâ€ºÃÅ¾Ãâ€™ÃÂ£ÃÂ¨ÃÅ¡ÃÂ Ãâ€˜ÃÂ«Ãâ€ºÃÂ ÃÂÃÅ¡ÃÂ¢ÃËœÃâ€™ÃËœÃÂ ÃÅ¾Ãâ€™ÃÂÃÂÃÂ!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_SUBTITLE, "&fÃâ€™ÃÂ°Ã‘Ë†ÃÂ° {trap} ÃÂ±Ã‘â€¹ÃÂ»(ÃÂ°) ÃÂ°ÃÂºÃ‘â€šÃÂ¸ÃÂ²ÃÂ¸Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°ÃÂ½(ÃÂ°)!");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_MSG + "3", "&c&lÃâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ° ÃÂ±Ã‘â€¹ÃÂ»ÃÂ° ÃÂ°ÃÂºÃ‘â€šÃÂ¸ÃÂ²ÃÂ¸Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°ÃÂ½ÃÂ° ÃÂ¸ÃÂ³Ã‘â‚¬ÃÂ¾ÃÂºÃÂ¾ÃÂ¼ &7&l{player} &c&lÃÂ¸ÃÂ· {color}&l{team} &c&lÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´Ã‘â€¹!"); // set off = ÃÂ°ÃÂºÃ‘â€šÃÂ¸ÃÂ²ÃÂ¸Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°ÃÂ½ÃÂ°?
                                                                                                                                                           // Ãâ€ÃÂ¾ÃÂ±ÃÂ°ÃÂ²ÃÂ»ÃÂµÃÂ½ÃÂ¾ Matveev_: ÃÂ½ÃÂµ ÃÂµÃÂ±Ã‘Æ’
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_TITLE + "3", "&c&lÃâ€™ÃÂÃËœÃÅ“ÃÂÃÂÃËœÃâ€¢!!!");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_SUBTITLE + "3", "&fÃâ€ºÃÂ¾ÃÂ²Ã‘Æ’Ã‘Ë†ÃÂºÃÂ° ÃÂ±Ã‘â€¹ÃÂ»ÃÂ° ÃÂ°ÃÂºÃ‘â€šÃÂ¸ÃÂ²ÃÂ¸Ã‘â‚¬ÃÂ¾ÃÂ²ÃÂ°ÃÂ½ÃÂ° ÃÂºÃÂ¾ÃÂ¼ÃÂ°ÃÂ½ÃÂ´ÃÂ¾ÃÂ¹ {color}{team} &f!");
        save();
        setPrefix(m(Messages.PREFIX));
        setPrefixStatic(m(Messages.PREFIX));
    }
}

