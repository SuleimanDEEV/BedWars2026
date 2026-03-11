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

public class SimplifiedChinese extends Language {

    public SimplifiedChinese() {
        super(BukkitBedPlugin.plugin, "zh_cn");

        YamlConfiguration yml = getYml();
        yml.options().copyDefaults(true);
        yml.addDefault(Messages.PREFIX, "");
        yml.addDefault("name", "Ã§Â®â‚¬Ã¤Â½â€œÃ¤Â¸Â­Ã¦â€“â€¡");

        // this must stay here
        // move message to new path
        if (yml.get("player-die-knocked-regular") != null && yml.get(Messages.PLAYER_DIE_KNOCKED_IN_VOID_REGULAR_KILL) == null) {
            yml.set(Messages.PLAYER_DIE_KNOCKED_IN_VOID_REGULAR_KILL, yml.getString("player-die-knocked-regular"));
            yml.set("player-die-knocked-regular", null);
        }
        if (yml.get("player-die-knocked-final") != null && yml.get(Messages.PLAYER_DIE_KNOCKED_IN_VOID_FINAL_KILL) == null) {
            yml.set(Messages.PLAYER_DIE_KNOCKED_IN_VOID_FINAL_KILL, yml.getString("player-die-knocked-final"));
            yml.set("player-die-knocked-final", null);
        }

        yml.addDefault(Messages.COMMAND_MAIN, Arrays.asList("", "&2Ã¢â€“Âª &7/" + mainCmd + " stats", "&2Ã¢â€“Âª &7/" + mainCmd + " join &o<Ã¦Â¸Â¸Ã¦Ë†Â/Ã¦Â¨Â¡Ã¥Â¼Â>", "&2Ã¢â€“Âª &7/" + mainCmd + " leave", "&2Ã¢â€“Âª &7/" + mainCmd + " lang", "&2Ã¢â€“Âª &7/" + mainCmd + " gui", "&2Ã¢â€“Âª &7/" + mainCmd + " start &3Ã¯Â¼Ë†Ã¨ÂµÅ¾Ã¥Å Â©Ã¨â‚¬â€¦Ã¯Â¼â€°"));
        yml.addDefault(Messages.COMMAND_LANG_LIST_HEADER, "{prefix} &2Ã¥ÂÂ¯Ã§â€Â¨Ã§Å¡â€žÃ¨Â¯Â­Ã¨Â¨â‚¬Ã¯Â¼Å¡");
        yml.addDefault(Messages.COMMAND_LANG_LIST_FORMAT, "&aÃ¢â€“Âª  &7{iso} - &f{name}");
        yml.addDefault(Messages.COMMAND_LANG_USAGE, "{prefix}&Ã§â€Â¨Ã¦Â³â€¢Ã¯Â¼Å¡/lang &f&o<iso>");
        yml.addDefault(Messages.COMMAND_LANG_SELECTED_NOT_EXIST, "{prefix}&cÃ¨Â¯Â¥Ã¨Â¯Â­Ã¨Â¨â‚¬Ã¤Â¸ÂÃ¥Â­ËœÃ¥Å“Â¨Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_LANG_SELECTED_SUCCESSFULLY, "{prefix}&aÃ¨Â¯Â­Ã¨Â¨â‚¬Ã¥Â·Â²Ã¨Â®Â¾Ã§Â½Â®Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_LANG_USAGE_DENIED, "{prefix}&cÃ¤Â½Â Ã¤Â¸ÂÃ¨Æ’Â½Ã¥Å“Â¨Ã¦Â¸Â¸Ã¦Ë†ÂÃ¨Â¿â€ºÃ¨Â¡Å’Ã¦â€”Â¶Ã¤Â¿Â®Ã¦â€Â¹Ã¨Â¯Â­Ã¨Â¨â‚¬Ã£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_JOIN_USAGE, "&aÃ¢â€“Âª &7Ã§â€Â¨Ã¦Â³â€¢Ã¯Â¼Å¡/" + BukkitBedPlugin.mainCmd + " join &o<Ã¦Â¸Â¸Ã¦Ë†Â/Ã¦Â¨Â¡Ã¥Â¼Â>");
        yml.addDefault(Messages.COMMAND_JOIN_GROUP_OR_ARENA_NOT_FOUND, "{prefix}&cÃ¦Â¸Â¸Ã¦Ë†Â{name}Ã¤Â¸ÂÃ¥Â­ËœÃ¥Å“Â¨Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_IS_FULL, "{prefix}&cÃ¦Â¸Â¸Ã¦Ë†ÂÃ¥Â·Â²Ã¦Â»Â¡Ã¯Â¼Â\n&aÃ¨Â¯Â·Ã¨â‚¬Æ’Ã¨â„¢â€˜Ã¨ÂµÅ¾Ã¥Å Â©Ã¤Â»Â¥Ã¦â€Â¯Ã¦Å’ÂÃ¦Ë†â€˜Ã¤Â»Â¬Ã¯Â¼Â &7&o(Ã§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹)");
        yml.addDefault(Messages.COMMAND_JOIN_NO_EMPTY_FOUND, "{prefix}&cÃ§Å½Â°Ã¥Å“Â¨Ã¦Â²Â¡Ã¦Å“â€°Ã¥ÂÂ¯Ã§â€Â¨Ã§Å¡â€žÃ¦Â¸Â¸Ã¦Ë†Â:(");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_IS_FULL_OF_VIPS, "{prefix}&cÃ¥Â¾Ë†Ã¦Å Â±Ã¦Â­â€°Ã¯Â¼Å’Ã¨â„¢Â½Ã§â€žÂ¶Ã¦Ë†â€˜Ã¤Â»Â¬Ã¥Â·Â²Ã§Å¸Â¥Ã©Ââ€œÃ¤Â½Â Ã¥Â·Â²Ã¨ÂµÅ¾Ã¥Å Â©Ã¯Â¼Å’Ã¤Â½â€ Ã¨Â¯Â¥Ã¦Â¸Â¸Ã¦Ë†ÂÃ¥Â·Â²Ã¦Â»Â¡Ã£â‚¬â€š\n&cÃ¦Â­Â¤Ã¦Â¸Â¸Ã¦Ë†ÂÃ¤Â¸Â­Ã¥â€¦Â¨Ã¦ËœÂ¯Ã¨ÂµÅ¾Ã¥Å Â©Ã¨â‚¬â€¦Ã¦Ë†â€“Ã§Â®Â¡Ã§Ââ€ Ã¥â€˜ËœÃ£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_PARTY_TOO_BIG, "{prefix}&cÃ¤Â½Â Ã§Å¡â€žÃ©ËœÅ¸Ã¤Â¼ÂÃ¤ÂºÂºÃ¦â€¢Â°Ã¥Â¤ÂªÃ¥Â¤Å¡Ã¤Âºâ€ Ã¯Â¼Å’Ã¤Â¸ÂÃ¨Æ’Â½Ã¤Â½Å“Ã¤Â¸ÂºÃ¤Â¸â‚¬Ã¤Â¸ÂªÃ©ËœÅ¸Ã¤Â¼ÂÃ¥Å Â Ã¥â€¦Â¥Ã¨Â¯Â¥Ã¦Â¸Â¸Ã¦Ë†Â:(");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_NOT_PARTY_LEADER, "{prefix}&cÃ¥ÂÂªÃ¦Å“â€°Ã©ËœÅ¸Ã©â€¢Â¿Ã¦â€°ÂÃ¨Æ’Â½Ã©â‚¬â€°Ã¦â€¹Â©Ã¦Â¸Â¸Ã¦Ë†ÂÃ£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_JOIN_PLAYER_JOIN_MSG, "{prefix}&7{player}&eÃ¥Å Â Ã¥â€¦Â¥Ã¤Âºâ€ Ã¦Â¸Â¸Ã¦Ë†Â(&b{on}&e/&b{max}&e)Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_JOIN_SPECTATOR_MSG, "{prefix}&6Ã¤Â½Â Ã¦Â­Â£Ã¥Å“Â¨Ã¨Â§â€šÃ¦Ë†Ëœ&9{arena}&6Ã£â‚¬â€š\n{prefix}&eÃ¨Â¾â€œÃ¥â€¦Â¥ &c/leave &eÃ§Â¦Â»Ã¥Â¼â‚¬Ã£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_JOIN_SPECTATOR_DENIED_MSG, "&cÃ¨Â¯Â¥Ã¦Â¸Â¸Ã¦Ë†ÂÃ¤Â¸ÂÃ¥â€¦ÂÃ¨Â®Â¸Ã¦â€”ÂÃ¨Â§â€šÃ¯Â¼Â");
        yml.addDefault(Messages.COMMAND_TP_PLAYER_NOT_FOUND, "{prefix}&cÃ¦â€”Â Ã¦Â³â€¢Ã¦â€°Â¾Ã¥Ë†Â°Ã¨Â¿â„¢Ã¤Â½ÂÃ§Å½Â©Ã¥Â®Â¶Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_TP_NOT_IN_ARENA, "{prefix}&cÃ¨Â¯Â¥Ã§Å½Â©Ã¥Â®Â¶Ã¤Â¸ÂÃ¥Å“Â¨Ã¤Â»Â»Ã¤Â½â€¢Ã¤Â¸â‚¬Ã¥Å“ÂºÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã¦Â¸Â¸Ã¦Ë†ÂÃ¤Â¸Â­Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_TP_NOT_STARTED, "{prefix}&cÃ¨Â¯Â¥Ã§Å½Â©Ã¥Â®Â¶Ã¦â€°â‚¬Ã¥Å“Â¨Ã§Å¡â€žÃ¦Â¸Â¸Ã¦Ë†ÂÃ¨Â¿ËœÃ¦Â²Â¡Ã¥Â¼â‚¬Ã¥Â§â€¹Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_TP_USAGE, "{prefix}&cÃ§â€Â¨Ã¦Â³â€¢Ã¯Â¼Å¡/bw tp <Ã§Å½Â©Ã¥Â®Â¶Ã¥ÂÂ>");
        yml.addDefault(Messages.REJOIN_NO_ARENA, "{prefix}&cÃ¦Â²Â¡Ã¦Å“â€°Ã¥ÂÂ¯Ã¤Â»Â¥Ã©â€¡ÂÃ¦â€“Â°Ã¥Å Â Ã¥â€¦Â¥Ã§Å¡â€žÃ¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Â");
        yml.addDefault(Messages.REJOIN_DENIED, "{prefix}&cÃ§â€Â±Ã¤ÂºÅ½Ã¤Â½Â Ã¦â€°â‚¬Ã¥Â±Å¾Ã©ËœÅ¸Ã¤Â¼ÂÃ§Å¡â€žÃ¥ÂºÅ Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂÃ¦Ë†â€“Ã¦Â¸Â¸Ã¦Ë†ÂÃ¥Â·Â²Ã§Â»ÂÃ§Â»â€œÃ¦ÂÅ¸Ã¯Â¼Å’Ã¤Â½Â Ã¤Â¸ÂÃ¨Æ’Â½Ã©â€¡ÂÃ¦â€“Â°Ã¥Å Â Ã¥â€¦Â¥Ã£â‚¬â€š");
        yml.addDefault(Messages.REJOIN_ALLOWED, "{prefix}&eÃ¦Â­Â£Ã¥Å“Â¨Ã©â€¡ÂÃ¦â€“Â°Ã¥Å Â Ã¥â€¦Â¥&a{arena}&eÃ¯Â¼Â");
        yml.addDefault(Messages.COMMAND_REJOIN_PLAYER_RECONNECTED, "{prefix}&7{player}&eÃ©â€¡ÂÃ¦â€“Â°Ã¨Â¿Å¾Ã¦Å½Â¥Ã£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_LEAVE_DENIED_NOT_IN_ARENA, "{prefix}&cÃ¤Â½Â Ã¤Â¸ÂÃ¥Å“Â¨Ã¤Â¸â‚¬Ã¥Å“ÂºÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã¦Â¸Â¸Ã¦Ë†ÂÃ¤Â¸Â­Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_LEAVE_MSG, "{prefix}&7{player}&eÃ§Â¦Â»Ã¥Â¼â‚¬Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_NOT_ALLOWED_IN_GAME, "{prefix}&cÃ¤Â½Â Ã¥Å“Â¨Ã¦Â¸Â¸Ã¦Ë†ÂÃ¤Â¸Â­Ã¤Â¸ÂÃ¥ÂÂ¯Ã¤Â»Â¥Ã¨Â¿â„¢Ã¤Â¹Ë†Ã¥ÂÅ¡Ã£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_NOT_FOUND_OR_INSUFF_PERMS, "{prefix}&cÃ¦Å’â€¡Ã¤Â»Â¤Ã¦â€”Â Ã¦â€¢Ë†Ã¦Ë†â€“Ã¤Â½Â Ã¦Â²Â¡Ã¦Å“â€°Ã¦ÂÆ’Ã©â„¢ÂÃ¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_HELP, Arrays.asList("&6Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&aÃ©ËœÅ¸Ã¤Â¼ÂÃ¦Å’â€¡Ã¤Â»Â¤Ã¯Â¼Å¡",
                "&e/party help &7- &bÃ¦Å¸Â¥Ã§Å“â€¹Ã¨Â¯Â¥Ã¦ÂÂÃ§Â¤Âº",
                "&e/party invite <Ã§Å½Â©Ã¥Â®Â¶> &7- &bÃ©â€šâ‚¬Ã¨Â¯Â·Ã¤Â¸â‚¬Ã¤Â½ÂÃ§Å½Â©Ã¥Â®Â¶Ã¥Ë†Â°Ã¤Â½Â Ã§Å¡â€žÃ©ËœÅ¸Ã¤Â¼Â",
                "&e/party leave &7- &bÃ§Â¦Â»Ã¥Â¼â‚¬Ã¥Â½â€œÃ¥â€°ÂÃ©ËœÅ¸Ã¤Â¼Â",
                "&e/party info &7- &bShow party members and owner",
                "&e/party promote <player> &7- &bTransfer party ownership",
                "&e/party remove <Ã§Å½Â©Ã¥Â®Â¶> &7- &bÃ¥Â°â€ Ã§Å½Â©Ã¥Â®Â¶Ã§Â§Â»Ã¥â€¡ÂºÃ©ËœÅ¸Ã¤Â¼Â",
                "&e/party accept <Ã§Å½Â©Ã¥Â®Â¶> &7- &bÃ¦Å½Â¥Ã¥Ââ€”Ã©ËœÅ¸Ã¤Â¼ÂÃ©â€šâ‚¬Ã¨Â¯Â·",
                "&e/party disband &7- &bDÃ¨Â§Â£Ã¦â€¢Â£Ã©ËœÅ¸Ã¤Â¼Â")
        );
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_USAGE, "{prefix}&eÃ§â€Â¨Ã¦Â³â€¢Ã¯Â¼Å¡&7/party invite <Ã§Å½Â©Ã¥Â®Â¶>");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_PLAYER_OFFLINE, "{prefix}&7{player}&eÃ¤Â¸ÂÃ¥Å“Â¨Ã§ÂºÂ¿Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_SENT, "{prefix}&eÃ¥Â·Â²Ã¥Ââ€˜&7{player}&eÃ¥Ââ€˜Ã©â‚¬ÂÃ©â€šâ‚¬Ã¨Â¯Â·&6Ã£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_SENT_TARGET_RECEIVE_MSG, "{prefix}&b{player}&eÃ©â€šâ‚¬Ã¨Â¯Â·Ã¤Â½Â Ã¥Å Â Ã¥â€¦Â¥Ã©ËœÅ¸Ã¤Â¼ÂÃ¯Â¼Â &o&7(Ã§â€šÂ¹Ã¥â€¡Â»Ã¦Å½Â¥Ã¥Ââ€”)");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_CANNOT_INVITE_YOURSELF, "{prefix}&cÃ¤Â½Â Ã¤Â¸ÂÃ¥ÂÂ¯Ã¤Â»Â¥Ã©â€šâ‚¬Ã¨Â¯Â·Ã¤Â½Â Ã¨â€¡ÂªÃ¥Â·Â±Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_PLAYER_OFFLINE, "{prefix}&7{player}&eÃ¤Â¸ÂÃ¥Å“Â¨Ã§ÂºÂ¿Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_DENIED_NO_INVITE, "{prefix}&cÃ¦Â²Â¡Ã¦Å“â€°Ã¥ÂÂ¯Ã¤Â»Â¥Ã¦Å½Â¥Ã¥Ââ€”Ã§Å¡â€žÃ©ËœÅ¸Ã¤Â¼ÂÃ©â€šâ‚¬Ã¨Â¯Â·Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_DENIED_ALREADY_IN_PARTY, "{prefix}&eÃ¤Â½Â Ã¥Â·Â²Ã§Â»ÂÃ¥Å“Â¨Ã©ËœÅ¸Ã¤Â¼ÂÃ¤Â¸Â­Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_INSUFFICIENT_PERMISSIONS, "{prefix}&cÃ¥ÂÂªÃ¦Å“â€°Ã©ËœÅ¸Ã©â€¢Â¿Ã¦â€°ÂÃ¥ÂÂ¯Ã¤Â»Â¥Ã¨Â¿â„¢Ã¤Â¹Ë†Ã¥ÂÅ¡Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_USAGE, "{prefix}&eÃ§â€Â¨Ã¦Â³â€¢Ã¯Â¼Å¡&7/party accept <Ã§Å½Â©Ã¥Â®Â¶>");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_SUCCESS, "{prefix}&7{player}&eÃ¥Å Â Ã¥â€¦Â¥Ã¤Âºâ€ Ã©ËœÅ¸Ã¤Â¼ÂÃ¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_GENERAL_DENIED_NOT_IN_PARTY, "{prefix}&cÃ¤Â½Â Ã¤Â¸ÂÃ¥Å“Â¨Ã©ËœÅ¸Ã¤Â¼ÂÃ¤Â¸Â­Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_LEAVE_DENIED_IS_OWNER_NEEDS_DISBAND, "{prefix}&cÃ¤Â½Â Ã¤Â¸ÂÃ¥ÂÂ¯Ã¤Â»Â¥Ã§Â¦Â»Ã¥Â¼â‚¬Ã§â€Â±Ã¤Â½Â Ã¥Â¸Â¦Ã©Â¢â€ Ã§Å¡â€žÃ©ËœÅ¸Ã¤Â¼ÂÃ¯Â¼Â\n&eÃ¤Â½Â¿Ã§â€Â¨Ã¯Â¼Å¡&b/party disband &eÃ¦ÂÂ¥Ã¨Â§Â£Ã¦â€¢Â£Ã©ËœÅ¸Ã¤Â¼ÂÃ£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_PARTY_LEAVE_SUCCESS, "{prefix}&7{player}&eÃ§Â¦Â»Ã¥Â¼â‚¬Ã¤Âºâ€ Ã©ËœÅ¸Ã¤Â¼ÂÃ¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_DISBAND_SUCCESS, "{prefix}&eÃ©ËœÅ¸Ã¤Â¼ÂÃ¥Â·Â²Ã¨Â§Â£Ã¦â€¢Â£Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_USAGE, "{prefix}&7Ã§â€Â¨Ã¦Â³â€¢Ã¯Â¼Å¡&e/party remove <Ã§Å½Â©Ã¥Â®Â¶>");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_SUCCESS, "{prefix}&7{player}&eÃ¨Â¢Â«Ã§Â§Â»Ã¥â€¡ÂºÃ¤Âºâ€ Ã©ËœÅ¸Ã¤Â¼ÂÃ£â‚¬â€š");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_DENIED_TARGET_NOT_PARTY_MEMBER, "{prefix}&7{player}&eÃ¤Â¸ÂÃ¥Å“Â¨Ã¤Â½Â Ã§Å¡â€žÃ©ËœÅ¸Ã¤Â¼ÂÃ¤Â¸Â­Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_SUCCESS, "{prefix}&eÃ¤Â½Â Ã¦Ë†ÂÃ¥Å Å¸Ã¥Â°â€  {player} Ã¦ÂÂÃ¥Ââ€¡Ã¤Â¸ÂºÃ§Â¾Â¤Ã¤Â¸Â»");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_OWNER, "{prefix}&eÃ¤Â½Â Ã¥Â·Â²Ã¨Â¢Â«Ã¦ÂÂÃ¥Ââ€¡Ã¤Â¸ÂºÃ§Â¾Â¤Ã¤Â¸Â»");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_NEW_OWNER, "{prefix}&7 &e{player} Ã¥Â·Â²Ã¨Â¢Â«Ã¦ÂÂÃ¥Ââ€¡Ã¤Â¸ÂºÃ§Â¾Â¤Ã¤Â¸Â»");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_OWNER, "\n{prefix}&eÃ§Â¾Â¤Ã¤Â¸Â»Ã¤Â¸Âº: &7{owner}");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_PLAYERS,"{prefix}&eÃ§Â¾Â¤Ã¦Ë†ÂÃ¥â€˜ËœÃ¦Å“â€°Ã¯Â¼Å¡");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_PLAYER, "&7{player}");
        yml.addDefault(Messages.COMMAND_FORCESTART_NOT_IN_GAME, "&cÃ¢â€“Âª &7Ã¤Â½Â Ã¤Â¸ÂÃ¥Å“Â¨Ã¦Â¸Â¸Ã¦Ë†ÂÃ¤Â¸Â­Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_FORCESTART_SUCCESS, "&cÃ¢â€“Âª &7Ã¦Â¸Â¸Ã¦Ë†ÂÃ¥Â¼â‚¬Ã¥Â§â€¹Ã¥â‚¬â€™Ã¨Â®Â¡Ã¦â€”Â¶Ã§Â¼Â©Ã§Å¸Â­Ã¯Â¼Â");
        yml.addDefault(Messages.COMMAND_FORCESTART_NO_PERM, "{prefix}&7Ã¤Â½Â Ã¤Â¸ÂÃ¥ÂÂ¯Ã¤Â»Â¥Ã¥Â¼ÂºÃ¥Ë†Â¶Ã¥Â¼â‚¬Ã¥Â§â€¹Ã¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Â\n&7Ã¨Â¯Â·Ã¨â‚¬Æ’Ã¨â„¢â€˜Ã¨ÂµÅ¾Ã¥Å Â©Ã¤Â»Â¥Ã¥Â¾â€”Ã¥Ë†Â°Ã¥Â¯Â¹Ã¥Âºâ€Ã¦ÂÆ’Ã©â„¢ÂÃ¯Â¼Â");
        yml.addDefault(Messages.COMMAND_COOLDOWN, "&cÃ¤Â½Â Ã¤Â¸ÂÃ¨Æ’Â½Ã¨Â¿â„¢Ã¤Â¹Ë†Ã¥ÂÅ¡Ã¯Â¼Â Ã¨Â¯Â·Ã§Â­â€°Ã¥Â¾â€¦ {seconds} Ã§Â§â€™Ã¯Â¼Â");
        yml.addDefault(Messages.ARENA_JOIN_VIP_KICK, "{prefix}&cÃ¦Å Â±Ã¦Â­â€°Ã¯Â¼Å’Ã§â€Â±Ã¤ÂºÅ½Ã¦Å“â€°Ã¤Â¸â‚¬Ã¤Â½ÂÃ¨ÂµÅ¾Ã¥Å Â©Ã¨â‚¬â€¦Ã¥Å Â Ã¥â€¦Â¥Ã¨Â¯Â¥Ã¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Å’Ã¥â€ºÂ Ã¦Â­Â¤Ã¤Â½Â Ã¨Â¢Â«Ã§Â§Â»Ã¥â€¡ÂºÃ¤Âºâ€ Ã¨Â¯Â¥Ã¦Â¸Â¸Ã¦Ë†ÂÃ£â‚¬â€š\n&aÃ¨Â¯Â·Ã¨â‚¬Æ’Ã¨â„¢â€˜Ã¨ÂµÅ¾Ã¥Å Â©Ã¤Â»Â¥Ã¦â€Â¯Ã¦Å’ÂÃ¦Ë†â€˜Ã¤Â»Â¬Ã¯Â¼Â &7&o(Ã§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹)");
        yml.addDefault(Messages.ARENA_START_COUNTDOWN_STOPPED_INSUFF_PLAYERS_CHAT, "{prefix}&cÃ§Å½Â©Ã¥Â®Â¶Ã¤Â¸ÂÃ¨Â¶Â³Ã¯Â¼Â Ã¥â‚¬â€™Ã¨Â®Â¡Ã¦â€”Â¶Ã¥Ââ€“Ã¦Â¶Ë†Ã¯Â¼Â");
        yml.addDefault(Messages.ARENA_RESTART_PLAYER_KICK, "{prefix}&eÃ¥Â½â€œÃ¥â€°ÂÃ¦Â¸Â¸Ã¦Ë†ÂÃ¦Â­Â£Ã¥Å“Â¨Ã©â€¡ÂÃ¥ÂÂ¯Ã£â‚¬â€š");
        yml.addDefault(Messages.ARENA_STATUS_PLAYING_NAME, "&cÃ¦Â¸Â¸Ã¦Ë†ÂÃ¤Â¸Â­");
        yml.addDefault(Messages.ARENA_STATUS_RESTARTING_NAME, "&4Ã©â€¡ÂÃ¥ÂÂ¯Ã¤Â¸Â­");
        yml.addDefault(Messages.ARENA_STATUS_WAITING_NAME, "&3Ã§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­ &c{full}");
        yml.addDefault(Messages.ARENA_STATUS_STARTING_NAME, "&6Ã¥ÂÂ³Ã¥Â°â€ Ã¥Â¼â‚¬Ã¥Â§â€¹ &c{full}");
        yml.addDefault(Messages.ARENA_GUI_INV_NAME, "&8Ã§â€šÂ¹Ã¥â€¡Â»Ã¥Å Â Ã¥â€¦Â¥");
        yml.addDefault(Messages.ARENA_GUI_ARENA_CONTENT_NAME, "&a&l{name}");
        yml.addDefault(Messages.ARENA_GUI_ARENA_CONTENT_LORE, Arrays.asList("", "&7Ã§Å Â¶Ã¦â‚¬ÂÃ¯Â¼Å¡{status}", "&7Ã§Å½Â©Ã¥Â®Â¶Ã¦â€¢Â°Ã¯Â¼Å¡&f{on}&7/&f{max}", "&7Ã¦Â¨Â¡Ã¥Â¼ÂÃ¯Â¼Å¡&a{group}", "", "&aÃ§â€šÂ¹Ã¥â€¡Â»Ã¨Â¿â€ºÃ¥â€¦Â¥", "&eÃ¥ÂÂ³Ã¥â€¡Â»Ã¨Â§â€šÃ¨Âµâ€º"));
        yml.addDefault(Messages.ARENA_GUI_SKIPPED_ITEM_NAME, "&r{serverIp}");
        yml.addDefault(Messages.ARENA_GUI_SKIPPED_ITEM_LORE, Collections.emptyList());
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CHAT, "{prefix}&eÃ¦Â¸Â¸Ã¦Ë†ÂÃ¥Â°â€ Ã¥Å“Â¨ &6{time}&e Ã§Â§â€™Ã¥ÂÅ½Ã¥Â¼â‚¬Ã¥Â§â€¹Ã¯Â¼Â");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_TITLE, " ");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE, "&a{second}");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-5", "&eÃ¢ÂÂº");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-4", "&eÃ¢ÂÂ¹");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-3", "&cÃ¢ÂÂ¸");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-2", "&cÃ¢ÂÂ·");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-1", "&cÃ¢ÂÂ¶");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CANCELLED_TITLE, " ");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CANCELLED_SUB_TITLE, "&cÃ§Â­â€°Ã¥Â¾â€¦Ã¦â€ºÂ´Ã¥Â¤Å¡Ã§Å½Â©Ã¥Â®Â¶Ã¢â‚¬Â¦Ã¢â‚¬Â¦");
        yml.addDefault(Messages.ARENA_STATUS_START_PLAYER_TITLE, "&aÃ¦Â¸Â¸Ã¦Ë†ÂÃ¥Â¼â‚¬Ã¥Â§â€¹");
        yml.addDefault(Messages.ARENA_STATUS_START_PLAYER_TUTORIAL, Arrays.asList(
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&f                                  &lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°", "",
                "&e&l                            Ã¤Â¿ÂÃ¦Å Â¤Ã¤Â½Â Ã§Å¡â€žÃ¥ÂºÅ Ã¥Â¹Â¶Ã§Â Â´Ã¥ÂÂÃ¦â€¢Å’Ã¤ÂºÂºÃ§Å¡â€žÃ¥ÂºÅ Ã¯Â¼Å’",
                "&e&l                        Ã¤Â»Å½Ã¨Âµâ€žÃ¦ÂºÂÃ§â€šÂ¹Ã¦â€Â¶Ã©â€ºâ€ Ã©â€œÂÃ©â€Â­Ã£â‚¬ÂÃ©â€¡â€˜Ã©â€Â­Ã£â‚¬ÂÃ§Â»Â¿Ã¥Â®ÂÃ§Å¸Â³Ã¥â€™Å’Ã©â€™Â»Ã§Å¸Â³Ã¯Â¼Å’",
                "&e&l                        Ã¦ÂÂ¥Ã¨Â´Â­Ã¤Â¹Â°Ã¥Â¼ÂºÃ¥Å â€ºÃ¨Â£â€¦Ã¥Â¤â€¡Ã¥â€™Å’Ã¨Â¿â€ºÃ¨Â¡Å’Ã¥Ââ€¡Ã§ÂºÂ§Ã¦ÂÂ¥Ã¤Â½Â¿Ã¨â€¡ÂªÃ¥Â·Â±Ã¥ÂËœÃ¥Â¼ÂºÃ¯Â¼Â",
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        yml.addDefault(Messages.ARENA_JOIN_DENIED_SELECTOR, "{prefix}&cÃ¦Å Â±Ã¦Â­â€°Ã¯Â¼Å’Ã¤Â½Â Ã§Å½Â°Ã¥Å“Â¨Ã¤Â¸ÂÃ¨Æ’Â½Ã¥Å Â Ã¥â€¦Â¥Ã¨Â¯Â¥Ã¦Â¸Â¸Ã¦Ë†ÂÃ£â‚¬â€šÃ¥ÂÂ³Ã©â€Â®Ã¦ÂÂ¥Ã¨Â§â€šÃ¨Âµâ€ºÃ¯Â¼Â");
        yml.addDefault(Messages.ARENA_SPECTATE_DENIED_SELECTOR, "{prefix}&cÃ¦Å Â±Ã¦Â­â€°Ã¯Â¼Å’Ã¤Â½Â Ã§Å½Â°Ã¥Å“Â¨Ã¤Â¸ÂÃ¨Æ’Â½Ã¨Â§â€šÃ¨Âµâ€ºÃ£â‚¬â€šÃ¥ÂÂ³Ã©â€Â®Ã¦ÂÂ¥Ã¥Å Â Ã¥â€¦Â¥Ã¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Â");
        yml.addDefault(Messages.ARENA_JOIN_DENIED_NO_PROXY, "&cÃ¦Å Â±Ã¦Â­â€°Ã¯Â¼Å’Ã¤Â½Â Ã¥Â¿â€¦Ã©Â¡Â»Ã©â‚¬Å¡Ã¨Â¿â€¡ BedWarsProxy Ã¦ÂÂ¥Ã¥Å Â Ã¥â€¦Â¥Ã¦Â¸Â¸Ã¦Ë†ÂÃ£â‚¬â€š \n&eÃ¥Â¦â€šÃ¦Å¾Å“Ã¤Â½Â Ã¦Æ’Â³Ã¨Â®Â¾Ã§Â½Â®Ã¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Å’Ã¤Â½Â Ã¥ÂÂ¯Ã¤Â»Â¥Ã§Â»â„¢Ã¤ÂºË†Ã¤Â½Â Ã¨â€¡ÂªÃ¥Â·Â± bw.setup Ã¦ÂÆ’Ã©â„¢ÂÃ¦ÂÂ¥Ã§â€ºÂ´Ã¦Å½Â¥Ã¨Â¿â€ºÃ¥â€¦Â¥Ã¦Å“ÂÃ¥Å Â¡Ã¥â„¢Â¨Ã¯Â¼Â");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_NAME, "&8Ã¤Â¼Â Ã©â‚¬Â");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_HEAD_NAME, "{vPrefix}{player}");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_HEAD_LORE, Arrays.asList("&7Ã§â€Å¸Ã¥â€˜Â½Ã¥â‚¬Â¼Ã¯Â¼Å¡&f{health}%", "&7Ã©Â¥Â±Ã©Â£Å¸Ã¥ÂºÂ¦Ã¯Â¼Å¡&f{food}", "", "&7Ã¥Â·Â¦Ã©â€Â®Ã¤Â¼Â Ã©â‚¬Â"));
        yml.addDefault(Messages.ARENA_SPECTATOR_LEAVE_ITEM_NAME, "&c&lÃ¥â€ºÅ¾Ã¥Ë†Â°Ã¥Â¤Â§Ã¥Å½â€¦");
        yml.addDefault(Messages.ARENA_SPECTATOR_LEAVE_ITEM_LORE, Collections.singletonList("&7Ã¥ÂÂ³Ã©â€Â®Ã§Â¦Â»Ã¥Â¼â‚¬Ã¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã¥Â¤Â§Ã¥Å½â€¦Ã¯Â¼Â"));
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_ENTER_TITLE, "&aÃ¦Â­Â£Ã¥Å“Â¨Ã¦â€”ÂÃ¨Â§â€š&7{player}");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_ENTER_SUBTITLE, "&cÃ¦Â½Å“Ã¨Â¡Å’Ã¤Â»Â¥Ã©â‚¬â‚¬Ã¥â€¡ÂºÃ¯Â¼Â");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_LEAVE_TITLE, "&eÃ©â‚¬â‚¬Ã¥â€¡ÂºÃ¦â€”ÂÃ¨Â§â€šÃ¨â‚¬â€¦Ã¦Â¨Â¡Ã¥Â¼Â");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_LEAVE_SUBTITLE, "");
        yml.addDefault(Messages.ARENA_LEAVE_PARTY_DISBANDED, "{prefix}&cÃ§â€Â±Ã¤ÂºÅ½Ã©ËœÅ¸Ã©â€¢Â¿Ã§Â¦Â»Ã¥Â¼â‚¬Ã¤Âºâ€ Ã¯Â¼Å’Ã©ËœÅ¸Ã¤Â¼ÂÃ¨Â§Â£Ã¦â€¢Â£Ã¯Â¼Â");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TIER, "&eÃ§Â­â€°Ã§ÂºÂ§&c{tier}");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TYPE_DIAMOND, "&b&lÃ©â€™Â»Ã§Å¸Â³");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TYPE_EMERALD, "&a&lÃ§Â»Â¿Ã¥Â®ÂÃ§Å¸Â³");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TIMER, "&c{seconds}&e Ã§Â§â€™Ã¥ÂÅ½Ã§â€Å¸Ã¦Ë†Â");
        yml.addDefault(Messages.GENERATOR_UPGRADE_CHAT_ANNOUNCEMENT, "{prefix}{generatorType}Ã¨Âµâ€žÃ¦ÂºÂÃ§â€šÂ¹&eÃ¥Ââ€¡Ã§ÂºÂ§Ã¥Ë†Â°&c{tier}Ã§ÂºÂ§Ã£â‚¬â€š");
        yml.addDefault(Messages.FORMATTING_CHAT_LOBBY, "{level}{vPrefix}&7{player}{vSuffix}Ã¯Â¼Å¡{message}");
        yml.addDefault(Messages.FORMATTING_CHAT_WAITING, "{level}{vPrefix}&7{player}{vSuffix}Ã¯Â¼Å¡{message}");
        yml.addDefault(Messages.FORMATTING_CHAT_SHOUT, "{level}{vPrefix}&6[Ã¥â€¦Â¬Ã¥Â±Â] {team} &7{player}&f{vSuffix}Ã¯Â¼Å¡{message}");
        yml.addDefault(Messages.FORMATTING_CHAT_TEAM, "{level}{vPrefix}&f{team}&7 {player}{vSuffix} {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_SPECTATOR, "{level}{vPrefix}&7[Ã¦â€”ÂÃ¨Â§â€šÃ¨â‚¬â€¦] {player}{vSuffix}Ã¯Â¼Å¡{message}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_HEALTH, Arrays.asList("&cÃ¢ÂÂ¤", "&aÃ§â€Å¸Ã¥â€˜Â½Ã¥â‚¬Â¼"));

        yml.addDefault(Messages.FORMATTING_SCOREBOARD_DATE, "yy/MM/dd");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_GENERIC, "{TeamColor}{TeamLetter}&f {TeamName}Ã¯Â¼Å¡{TeamStatus}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_ELIMINATED, "&c&lÃ¢Å“Ëœ");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_BED_DESTROYED, "&a{remainingPlayers}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_ALIVE, "&a&lÃ¢Å“â€œ");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_NEXEVENT_TIMER, "mm:ss");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_YOUR_TEAM, "&7 Ã¤Â½Â ");
        yml.addDefault(Messages.FORMATTING_ACTION_BAR_TRACKING, "&fÃ¦Â­Â£Ã¥Å“Â¨Ã¨Â¿Â½Ã¨Â¸ÂªÃ¯Â¼Å¡{team} &f- Ã¨Â·ÂÃ§Â¦Â»Ã¯Â¼Å¡{distance}m");
        yml.addDefault(Messages.FORMATTING_TEAM_WINNER_FORMAT, "      {TeamColor}{TeamName} &7- {members}");
        yml.addDefault(Messages.FORMATTING_SOLO_WINNER_FORMAT, "                 {TeamColor}{TeamName} &7- {members}");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER1, "I");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER2, "II");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER3, "III");
        yml.addDefault(Messages.FORMATTING_DESPAWNABLE_UTILITY_NPC_HEALTH, "Ã¢â€“Â® ");
        yml.addDefault(Messages.FORMATTING_STATS_DATE_FORMAT, "yyyy/MM/dd HH:mm");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_TEAM, "{TeamColor}[{TeamName}]");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_SHOUT, "&6[Ã¥â€¦Â¬Ã¥Â±Â]");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_SPECTATOR, "&7[Ã¦â€”ÂÃ¨Â§â€šÃ¨â‚¬â€¦]");
        yml.addDefault(Messages.MEANING_FULL, "Ã¥Â·Â²Ã¦Â»Â¡");
        yml.addDefault(Messages.MEANING_SHOUT, "Ã¥â€¦Â¬Ã¥Â±Â");
        yml.addDefault(Messages.MEANING_NOBODY, "Ã¦â€”Â Ã§Å½Â©Ã¥Â®Â¶");
        yml.addDefault(Messages.MEANING_NEVER, "Ã¤Â»Å½Ã¤Â¸Â");
        yml.addDefault(Messages.MEANING_IRON_SINGULAR, "Ã©â€œÂÃ©â€Â­");
        yml.addDefault(Messages.MEANING_IRON_PLURAL, "Ã©â€œÂÃ©â€Â­");
        yml.addDefault(Messages.MEANING_GOLD_SINGULAR, "Ã©â€¡â€˜Ã©â€Â­");
        yml.addDefault(Messages.MEANING_GOLD_PLURAL, "Ã©â€¡â€˜Ã©â€Â­");
        yml.addDefault(Messages.MEANING_EMERALD_SINGULAR, "Ã§Â»Â¿Ã¥Â®ÂÃ§Å¸Â³");
        yml.addDefault(Messages.MEANING_EMERALD_PLURAL, "Ã§Â»Â¿Ã¥Â®ÂÃ§Å¸Â³");
        yml.addDefault(Messages.MEANING_DIAMOND_SINGULAR, "Ã©â€™Â»Ã§Å¸Â³");
        yml.addDefault(Messages.MEANING_DIAMOND_PLURAL, "Ã©â€™Â»Ã§Å¸Â³");
        yml.addDefault(Messages.MEANING_VAULT_SINGULAR, "$");
        yml.addDefault(Messages.MEANING_VAULT_PLURAL, "$");
        yml.addDefault(Messages.INTERACT_CANNOT_PLACE_BLOCK, "{prefix}&cÃ¤Â½Â Ã¤Â¸ÂÃ¨Æ’Â½Ã¥Å“Â¨Ã¨Â¿â„¢Ã©â€¡Å’Ã¦â€Â¾Ã§Â½Â®Ã¦â€“Â¹Ã¥Ââ€”Ã¯Â¼Â");
        yml.addDefault(Messages.INTERACT_CANNOT_BREAK_BLOCK, "{prefix}&cÃ¤Â½Â Ã¥ÂÂªÃ¨Æ’Â½Ã§Â Â´Ã¥ÂÂÃ§â€Â±Ã§Å½Â©Ã¥Â®Â¶Ã¦â€Â¾Ã§Â½Â®Ã§Å¡â€žÃ¦â€“Â¹Ã¥Ââ€”Ã¯Â¼Â");
        yml.addDefault(Messages.INTERACT_CANNOT_BREAK_OWN_BED, "&cÃ¤Â½Â Ã¤Â¸ÂÃ¨Æ’Â½Ã§Â Â´Ã¥ÂÂÃ¨â€¡ÂªÃ¥Â·Â±Ã§Å¡â€žÃ¥ÂºÅ Ã¯Â¼Â");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_CHAT_ANNOUNCEMENT, "\n&f&lÃ¥ÂºÅ Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂ > {TeamColor}{TeamName}Ã§Å¡â€žÃ¥ÂºÅ &7Ã¨Â¢Â«{PlayerColor}{PlayerName}&7Ã§Â Â´Ã¥ÂÂÃ¤Âºâ€ Ã¯Â¼Â\n");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_TITLE_ANNOUNCEMENT, "&cÃ¥ÂºÅ Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂÃ¯Â¼Â");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_SUBTITLE_ANNOUNCEMENT, "&fÃ¤Â½Â Ã¤Â¸ÂÃ¨Æ’Â½Ã¥â€ ÂÃ©â€¡ÂÃ§â€Å¸Ã¯Â¼Â");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_CHAT_ANNOUNCEMENT_TO_VICTIM, "&f&lÃ¥ÂºÅ Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂ > &7Ã¤Â½Â Ã§Å¡â€žÃ¥ÂºÅ Ã¨Â¢Â«{PlayerColor}{PlayerName}&7Ã§Â Â´Ã¥ÂÂÃ¤Âºâ€ Ã¯Â¼Â\n");
        yml.addDefault(Messages.INTERACT_CHEST_CANT_OPEN_TEAM_ELIMINATED, "&cÃ¦Â­Â¤Ã©ËœÅ¸Ã¤Â¼ÂÃ¨Â¿ËœÃ¦Å“ÂªÃ¨Â¢Â«Ã¥â€ºÂ¢Ã§ÂÂ­Ã¯Â¼Å’Ã¥â€ºÂ Ã¦Â­Â¤Ã¤Â½Â Ã¤Â¸ÂÃ¨Æ’Â½Ã¦â€°â€œÃ¥Â¼â‚¬Ã¨Â¯Â¥Ã¥â€ºÂ¢Ã©ËœÅ¸Ã§Â®Â±Ã¥Â­ÂÃ¯Â¼Â");
        yml.addDefault(Messages.INTERACT_INVISIBILITY_REMOVED_DAMGE_TAKEN, "&cÃ¤Â½Â Ã¥â€ºÂ Ã¥Ââ€”Ã¥Ë†Â°Ã¤Â¼Â¤Ã¥Â®Â³Ã¨â‚¬Å’Ã¨Â¢Â«Ã¨Â¿Â«Ã©â‚¬â‚¬Ã¥â€¡ÂºÃ©Å¡ÂÃ¨ÂºÂ«Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_VOID_FALL_REGULAR_KILL, "{PlayerColor}{PlayerName}&7Ã¦Å½â€°Ã¨Â¿â€ºÃ¤Âºâ€ Ã¨â„¢Å¡Ã§Â©ÂºÃ£â‚¬â€š");
        yml.addDefault(Messages.PLAYER_DIE_VOID_FALL_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¦Å½â€°Ã¨Â¿â€ºÃ¤Âºâ€ Ã¨â„¢Å¡Ã§Â©ÂºÃ£â‚¬â€š &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_IN_VOID_REGULAR_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã¤Â¸Â¢Ã¨Â¿â€ºÃ¤Âºâ€ Ã¨â„¢Å¡Ã§Â©ÂºÃ£â‚¬â€š");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_IN_VOID_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã¤Â¸Â¢Ã¨Â¿â€ºÃ¤Âºâ€ Ã¨â„¢Å¡Ã§Â©ÂºÃ£â‚¬â€š &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_PVP_LOG_OUT_REGULAR, "{PlayerColor}{PlayerName}&7Ã¥Å“Â¨Ã¤Â¸Å½{KillerColor}{KillerName}&7Ã¦Ë†ËœÃ¦â€“â€”Ã¦â€”Â¶Ã¦â€“Â­Ã¥Â¼â‚¬Ã¨Â¿Å¾Ã¦Å½Â¥Ã£â‚¬â€š");
        yml.addDefault(Messages.PLAYER_DIE_PVP_LOG_OUT_FINAL, "{PlayerColor}{PlayerName}&7Ã¥Å“Â¨Ã¤Â¸Å½{KillerColor}{KillerName}&7Ã¦Ë†ËœÃ¦â€“â€”Ã¦â€”Â¶Ã¦â€“Â­Ã¥Â¼â‚¬Ã¨Â¿Å¾Ã¦Å½Â¥Ã£â‚¬â€š &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_BY_REGULAR_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã¦Å½Â¨Ã¤Â¸â€¹Ã¤Âºâ€ Ã¦â€šÂ¬Ã¥Â´â€“Ã£â‚¬â€š");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_BY_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã¦Å½Â¨Ã¤Â¸â€¹Ã¤Âºâ€ Ã¦â€šÂ¬Ã¥Â´â€“Ã£â‚¬â€š &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITH_SOURCE_REGULAR_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã§â€šÂ¸Ã¦Â­Â»Ã¤Âºâ€ Ã£â‚¬â€š");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITH_SOURCE_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã§â€šÂ¸Ã¦Â­Â»Ã¤Âºâ€ Ã£â‚¬â€š &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITHOUT_SOURCE_REGULAR, "{PlayerColor}{PlayerName}&7Ã§Ë†â€ Ã§â€šÂ¸Ã¤Âºâ€ Ã£â‚¬â€š");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITHOUT_SOURCE_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã§Ë†â€ Ã§â€šÂ¸Ã¤Âºâ€ Ã£â‚¬â€š &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_PVP_REGULAR_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã¥â€¡Â»Ã¦Ââ‚¬Ã£â‚¬â€š");
        yml.addDefault(Messages.PLAYER_DIE_PVP_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã¥â€¡Â»Ã¦Ââ‚¬Ã£â‚¬â€š &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_UNKNOWN_REASON_REGULAR, "{PlayerColor}{PlayerName}&7Ã¦Â­Â»Ã¤Âºâ€ Ã£â‚¬â€š");
        yml.addDefault(Messages.PLAYER_DIE_UNKNOWN_REASON_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¦Â­Â»Ã¤Âºâ€ Ã£â‚¬â€š &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_SHOOT_REGULAR, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã¥Â°â€žÃ¦Â­Â»Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_SHOOT_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerName}&7Ã¥Â°â€žÃ¦Â­Â»Ã¤Âºâ€ Ã¯Â¼Â &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_DEBUG_REGULAR, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerTeamName}&7Ã§Å¡â€žÃ¨Â Â¹Ã¨â„¢Â«Ã¦Ââ‚¬Ã¦Â­Â»Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_DEBUG_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerTeamName}&7Ã§Å¡â€žÃ¨Â Â¹Ã¨â„¢Â«Ã¦Ââ‚¬Ã¦Â­Â»Ã¤Âºâ€ Ã¯Â¼Â &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_IRON_GOLEM_REGULAR, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerTeamName}&7Ã§Å¡â€žÃ©â€œÂÃ¥â€šâ‚¬Ã¥â€žÂ¡Ã¦Ââ‚¬Ã¦Â­Â»Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_IRON_GOLEM_FINAL_KILL, "{PlayerColor}{PlayerName}&7Ã¨Â¢Â«{KillerColor}{KillerTeamName}&7Ã§Å¡â€žÃ©â€œÂÃ¥â€šâ‚¬Ã¥â€žÂ¡Ã¦Ââ‚¬Ã¦Â­Â»Ã¤Âºâ€ Ã¯Â¼Â &b&lÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_DIAMOND, "{prefix}&b+{amount}{meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_EMERALD, "{prefix}&a+{amount}{meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_IRON, "{prefix}&f+{amount}{meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_GOLD, "{prefix}&6+{amount}{meaning}");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_TITLE, "&cÃ¤Â½Â Ã¦Â­Â»Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_SUBTITLE, "&eÃ¤Â½Â Ã¥Â°â€ Ã¥Å“Â¨ &a{time} &eÃ§Â§â€™Ã¥ÂÅ½Ã©â€¡ÂÃ§â€Å¸Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_CHAT, "{prefix}&eÃ¤Â½Â Ã¥Â°â€ Ã¥Å“Â¨ &a{time} &eÃ§Â§â€™Ã¥ÂÅ½Ã©â€¡ÂÃ§â€Å¸Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWNED_TITLE, "&aÃ¥Â·Â²Ã©â€¡ÂÃ§â€Å¸Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_DIE_ELIMINATED_CHAT, "{prefix}&cÃ¤Â½Â Ã¥Â·Â²Ã¨Â¢Â«Ã¦Â·ËœÃ¦Â±Â°Ã¯Â¼Â");
        yml.addDefault(Messages.PLAYER_HIT_BOW, "{prefix}{TeamColor}{PlayerName}&7Ã¨Â¿ËœÃ¦Å“â€° &e{amount} &cÃ§â€Å¸Ã¥â€˜Â½Ã¥â‚¬Â¼Ã¯Â¼Â");
        yml.addDefault(Messages.GAME_END_GAME_OVER_PLAYER_TITLE, "&c&lÃ¦Â¸Â¸Ã¦Ë†ÂÃ§Â»â€œÃ¦ÂÅ¸Ã¯Â¼Â");
        yml.addDefault(Messages.GAME_END_VICTORY_PLAYER_TITLE, "&6&lÃ¨Æ’Å“Ã¥Ë†Â©Ã¯Â¼Â");
        yml.addDefault(Messages.GAME_END_TEAM_WON_CHAT, "{prefix}{TeamColor}{TeamName}&aÃ¨ÂµÂ¢Ã¥Â¾â€”Ã¤Âºâ€ Ã¨Â¿â„¢Ã¥Å“ÂºÃ¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Â");
        yml.addDefault(Messages.GAME_END_TOP_PLAYER_CHAT, Arrays.asList("&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&f                                   &lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°", "", "{winnerFormat}", "", "",
                "&6                      &6Ã¢Â­Â &lÃ¥â€¡Â»Ã¦Ââ‚¬Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¥ÂÂ &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}",
                "&e                        &lÃ¥â€¡Â»Ã¦Ââ‚¬Ã§Â¬Â¬Ã¤ÂºÅ’Ã¥ÂÂ &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}",
                "&c                        &lÃ¥â€¡Â»Ã¦Ââ‚¬Ã§Â¬Â¬Ã¤Â¸â€°Ã¥ÂÂ &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}", "",
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        yml.addDefault(Messages.BED_HOLOGRAM_DEFEND, "&c&lÃ¤Â¿ÂÃ¦Å Â¤Ã¤Â½Â Ã§Å¡â€žÃ¥ÂºÅ Ã¯Â¼Â");
        yml.addDefault(Messages.BED_HOLOGRAM_DESTROYED, "&c&lÃ¤Â½Â Ã§Å¡â€žÃ¥ÂºÅ Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂÃ¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.NPC_NAME_TEAM_UPGRADES, "&bÃ©ËœÅ¸Ã¤Â¼ÂÃ¥Ââ€¡Ã§ÂºÂ§,&e&lÃ¥ÂÂ³Ã©â€Â®Ã§â€šÂ¹Ã¥â€¡Â»");
        yml.addDefault(Messages.NPC_NAME_SOLO_UPGRADES, "&bÃ¥Ââ€¢Ã¦Å’â€˜Ã¥Ââ€¡Ã§ÂºÂ§,&e&lÃ¥ÂÂ³Ã©â€Â®Ã§â€šÂ¹Ã¥â€¡Â»");
        yml.addDefault(Messages.NPC_NAME_TEAM_SHOP, "&bÃ©ËœÅ¸Ã¤Â¼ÂÃ¥â€¢â€ Ã¥Âºâ€”,&e&lÃ¥ÂÂ³Ã©â€Â®Ã§â€šÂ¹Ã¥â€¡Â»");
        yml.addDefault(Messages.NPC_NAME_SOLO_SHOP, "&bÃ¥Ââ€¢Ã¦Å’â€˜Ã¥â€¢â€ Ã¥Âºâ€”,&e&lÃ¥ÂÂ³Ã©â€Â®Ã§â€šÂ¹Ã¥â€¡Â»");
        yml.addDefault(Messages.TEAM_ELIMINATED_CHAT, "\n&f&lÃ©ËœÅ¸Ã¤Â¼ÂÃ¥â€ºÂ¢Ã§ÂÂ­ > {TeamColor}{TeamName}&cÃ¥Â·Â²Ã¨Â¢Â«Ã¥â€ºÂ¢Ã§ÂÂ­Ã¯Â¼Â\n");
        yml.addDefault(Messages.NEXT_EVENT_BEDS_DESTROY, "&cÃ¥ÂºÅ Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂ");
        yml.addDefault(Messages.NEXT_EVENT_DIAMOND_UPGRADE_II, "&fÃ©â€™Â»Ã§Å¸Â³IIÃ§ÂºÂ§");
        yml.addDefault(Messages.NEXT_EVENT_DIAMOND_UPGRADE_III, "&fÃ©â€™Â»Ã§Å¸Â³IIIÃ§ÂºÂ§");
        yml.addDefault(Messages.NEXT_EVENT_DRAGON_SPAWN, "&fÃ§Â»ÂÃ¦Ââ‚¬Ã¦Â¨Â¡Ã¥Â¼Â");
        yml.addDefault(Messages.NEXT_EVENT_EMERALD_UPGRADE_II, "&fÃ§Â»Â¿Ã¥Â®ÂÃ§Å¸Â³IIÃ§ÂºÂ§");
        yml.addDefault(Messages.NEXT_EVENT_EMERALD_UPGRADE_III, "&fÃ§Â»Â¿Ã¥Â®ÂÃ§Å¸Â³IIIÃ§ÂºÂ§");
        yml.addDefault(Messages.NEXT_EVENT_GAME_END, "&4Ã¦Â¸Â¸Ã¦Ë†ÂÃ§Â»â€œÃ¦ÂÅ¸Ã¯Â¼Â");
        yml.addDefault(Messages.NEXT_EVENT_TITLE_ANNOUNCE_BEDS_DESTROYED, "&cÃ¥ÂºÅ Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂÃ¯Â¼Â");
        yml.addDefault(Messages.NEXT_EVENT_SUBTITLE_ANNOUNCE_BEDS_DESTROYED, "&fÃ¦â€°â‚¬Ã¦Å“â€°Ã¥ÂºÅ Ã¥Â·Â²Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂÃ¯Â¼Â");
        yml.addDefault(Messages.NEXT_EVENT_CHAT_ANNOUNCE_BEDS_DESTROYED, "&c&lÃ¦â€°â‚¬Ã¦Å“â€°Ã¥ÂºÅ Ã¥Â·Â²Ã¨Â¢Â«Ã§Â Â´Ã¥ÂÂÃ¯Â¼Â");
        yml.addDefault(Messages.NEXT_EVENT_TITLE_ANNOUNCE_SUDDEN_DEATH, "&cÃ§Â»ÂÃ¦Ââ‚¬Ã¦Â¨Â¡Ã¥Â¼Â");
        yml.addDefault(Messages.NEXT_EVENT_SUBTITLE_ANNOUNCE_SUDDEN_DEATH, "");
        yml.addDefault(Messages.NEXT_EVENT_CHAT_ANNOUNCE_SUDDEN_DEATH, "&cÃ§Â»ÂÃ¦Ââ‚¬Ã¦Â¨Â¡Ã¥Â¼ÂÃ¯Â¼Å¡&6&b{TeamDragons} {TeamColor}{TeamName}Ã§Å¡â€žÃ©Â¾â„¢Ã¯Â¼Â");
        yml.addDefault(Messages.XP_REWARD_PER_MINUTE, "{prefix}&6+{xp}Ã¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã§Â»ÂÃ©ÂªÅ’(Ã¦Â¸Â¸Ã¦Ë†ÂÃ¦â€”Â¶Ã©â€”Â´)");
        yml.addDefault(Messages.XP_REWARD_WIN, "{prefix}&6+{xp}Ã¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã§Â»ÂÃ©ÂªÅ’(Ã¦Â¸Â¸Ã¦Ë†ÂÃ¨Æ’Å“Ã¥Ë†Â©)");
        yml.addDefault(Messages.XP_REWARD_PER_TEAMMATE, "{prefix}&6+{xp}Ã¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã§Â»ÂÃ©ÂªÅ’(Ã¥â€ºÂ¢Ã©ËœÅ¸Ã¥ÂÂÃ¤Â½Å“)");
        yml.addDefault(Messages.XP_REWARD_BED_DESTROY, "{prefix}&6+{xp}Ã¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã§Â»ÂÃ©ÂªÅ’(Ã§Â Â´Ã¥ÂÂÃ¥ÂºÅ )");
        yml.addDefault(Messages.XP_REWARD_REGULAR_KILL, "{prefix}&6+{xp}Ã¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã§Â»ÂÃ©ÂªÅ’(Ã¥â€¡Â»Ã¦Ââ‚¬)");
        yml.addDefault(Messages.XP_REWARD_FINAL_KILL, "{prefix}&6+{xp}Ã¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã§Â»ÂÃ©ÂªÅ’(Ã¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬)");

        yml.addDefault(Messages.MONEY_REWARD_PER_MINUTE, "{prefix}&6+{money}Ã©â€¡â€˜Ã¥Â¸Â(Ã¦Â¸Â¸Ã¦Ë†ÂÃ¦â€”Â¶Ã©â€”Â´)");
        yml.addDefault(Messages.MONEY_REWARD_WIN, "{prefix}&6+{money}Ã©â€¡â€˜Ã¥Â¸Â(Ã¦Â¸Â¸Ã¦Ë†ÂÃ¨Æ’Å“Ã¥Ë†Â©)");
        yml.addDefault(Messages.MONEY_REWARD_PER_TEAMMATE, "{prefix}&6+{money}Ã©â€¡â€˜Ã¥Â¸Â(Ã¥â€ºÂ¢Ã©ËœÅ¸Ã¥ÂÂÃ¤Â½Å“)");
        yml.addDefault(Messages.MONEY_REWARD_BED_DESTROYED, "{prefix}&6+{money}Ã©â€¡â€˜Ã¥Â¸Â(Ã§Â Â´Ã¥ÂÂÃ¥ÂºÅ )");
        yml.addDefault(Messages.MONEY_REWARD_FINAL_KILL, "{prefix}&6+{money}Ã©â€¡â€˜Ã¥Â¸Â(Ã¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬)");
        yml.addDefault(Messages.MONEY_REWARD_REGULAR_KILL, "{prefix}&6+{money}Ã©â€¡â€˜Ã¥Â¸Â(Ã¥â€¡Â»Ã¦Ââ‚¬)");

        /* Lobby Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "stats"), "&eÃ¦Ë†ËœÃ§Â»Â©");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "stats"), Collections.singletonList("&fÃ¥ÂÂ³Ã©â€Â®Ã¦ËœÂ¾Ã§Â¤ÂºÃ¤Â½Â Ã§Å¡â€žÃ¦Ë†ËœÃ§Â»Â©Ã¯Â¼Â"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "arena-selector"), "&eÃ©â‚¬â€°Ã¦â€¹Â©Ã¦Â¸Â¸Ã¦Ë†Â");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "arena-selector"), Collections.singletonList("&fÃ¥ÂÂ³Ã©â€Â®Ã©â‚¬â€°Ã¦â€¹Â©Ã¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Â"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "leave"), "&eÃ¥â€ºÅ¾Ã¥Ë†Â°Ã¤Â¸Â»Ã¥Â¤Â§Ã¥Å½â€¦");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fÃ¥ÂÂ³Ã©â€Â®Ã§Â¦Â»Ã¥Â¼â‚¬Ã¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°Ã¯Â¼Â"));
        /* Pre Game Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_NAME.replace("%path%", "stats"), "&eÃ¦Ë†ËœÃ§Â»Â©");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_LORE.replace("%path%", "stats"), Collections.singletonList("&fÃ¥ÂÂ³Ã©â€Â®Ã¦ËœÂ¾Ã§Â¤ÂºÃ¤Â½Â Ã§Å¡â€žÃ¦Ë†ËœÃ§Â»Â©Ã¯Â¼Â"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_NAME.replace("%path%", "leave"), "&eÃ¨Â¿â€Ã¥â€ºÅ¾Ã¥Â¤Â§Ã¥Å½â€¦");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fÃ¥ÂÂ³Ã©â€Â®Ã§Â¦Â»Ã¥Â¼â‚¬Ã¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Â"));
        /* Spectator Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_NAME.replace("%path%", "teleporter"), "&eÃ¤Â¼Â Ã©â‚¬Â");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_NAME.replace("%path%", "leave"), "&eÃ¥â€ºÅ¾Ã¥Ë†Â°Ã¥Â¤Â§Ã¥Å½â€¦");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fÃ¥ÂÂ³Ã©â€Â®Ã§Â¦Â»Ã¥Â¼â‚¬Ã¦Â¸Â¸Ã¦Ë†ÂÃ¯Â¼Â"));

        /* save default items messages for stats gui */
        yml.addDefault(Messages.PLAYER_STATS_GUI_INV_NAME, "&8{player}Ã§Å¡â€žÃ¦Ë†ËœÃ§Â»Â©");
        addDefaultStatsMsg(yml, "wins", "&6Ã¨Æ’Å“Ã¥Å“ÂºÃ¦â€¢Â°", "&f{wins}");
        addDefaultStatsMsg(yml, "losses", "&6Ã¥Â¤Â±Ã¨Â´Â¥Ã¥Å“ÂºÃ¦â€¢Â°", "&f{losses}");
        addDefaultStatsMsg(yml, "kills", "&6Ã¥â€¡Â»Ã¦Ââ‚¬Ã¦â€¢Â°", "&f{kills}");
        addDefaultStatsMsg(yml, "deaths", "&6Ã¦Â­Â»Ã¤ÂºÂ¡Ã¦â€¢Â°", "&f{deaths}");
        addDefaultStatsMsg(yml, "final-kills", "&6Ã¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¦â€¢Â°", "&f{finalKills}");
        addDefaultStatsMsg(yml, "final-deaths", "&6Ã¦Å“â‚¬Ã§Â»Ë†Ã¦Â­Â»Ã¤ÂºÂ¡Ã¦â€¢Â°", "&f{finalDeaths}");
        addDefaultStatsMsg(yml, "beds-destroyed", "&6Ã§Â Â´Ã¥ÂÂÃ¥ÂºÅ Ã¦â€¢Â°", "&f{bedsDestroyed}");
        addDefaultStatsMsg(yml, "first-play", "&6Ã©Â¦â€“Ã¦Â¬Â¡Ã¦Â¸Â¸Ã§Å½Â©", "&f{firstPlay}");
        addDefaultStatsMsg(yml, "last-play", "&6Ã¤Â¸Å Ã¦Â¬Â¡Ã¦Â¸Â¸Ã§Å½Â©", "&f{lastPlay}");
        addDefaultStatsMsg(yml, "games-played", "&6Ã¦â‚¬Â»Ã¦Â¸Â¸Ã§Å½Â©Ã¥Å“ÂºÃ¦â€¢Â°", "&f{gamesPlayed}");

        // Start of Sidebar
        yml.addDefault(Messages.SCOREBOARD_LOBBY, Arrays.asList(
                "&6&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°,&4&lÃ¨ÂµÂ·&6&lÃ¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°,&6&lÃ¨ÂµÂ·&4&lÃ¥ÂºÅ &6&lÃ¦Ë†ËœÃ¤Âºâ€°,&6&lÃ¨ÂµÂ·Ã¥ÂºÅ &4&lÃ¦Ë†Ëœ&6&lÃ¤Âºâ€°,&6&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†Ëœ&4&lÃ¤Âºâ€°,&6&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&fÃ§Â­â€°Ã§ÂºÂ§Ã¯Â¼Å¡{level}",
                "",
                "&fÃ¨Â¿â€ºÃ¥ÂºÂ¦Ã¯Â¼Å¡&a{currentXp}&7/&b{requiredXp}",
                "{progress}",
                "",
                "&7{player}",
                "",
                "&fÃ©â€¡â€˜Ã¥Â¸ÂÃ¯Â¼Å¡&a{money}",
                "",
                "&fÃ¦â‚¬Â»Ã¨Æ’Å“Ã¥Å“ÂºÃ¯Â¼Å¡&a{wins}",
                "&fÃ¦â‚¬Â»Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{kills}",
                "", "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_WAITING, Arrays.asList(
                "&f&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date} &8{server}",
                "",
                "&fÃ¥Å“Â°Ã¥â€ºÂ¾Ã¯Â¼Å¡&a{map}",
                "",
                "&fÃ§Å½Â©Ã¥Â®Â¶Ã¦â€¢Â°Ã¯Â¼Å¡&a{on}/{max}",
                "",
                "&fÃ§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­,&fÃ§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­.,&fÃ§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­..,&fÃ§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­...",
                "",
                "&fÃ¦Â¨Â¡Ã¥Â¼ÂÃ¯Â¼Å¡&a{group}",
                "&fÃ§â€°Ë†Ã¦Å“Â¬Ã¯Â¼Å¡&7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_WAITING_SPEC, Arrays.asList(
                "&f&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date} &8{server}",
                "&o&7Spectating",
                "&fÃ¥Å“Â°Ã¥â€ºÂ¾Ã¯Â¼Å¡&a{map}",
                "",
                "&fÃ§Å½Â©Ã¥Â®Â¶Ã¦â€¢Â°Ã¯Â¼Å¡&a{on}/{max}",
                "",
                "&fÃ§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­,&fÃ§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­.,&fÃ§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­..,&fÃ§Â­â€°Ã¥Â¾â€¦Ã¤Â¸Â­...",
                "",
                "&fÃ¦Â¨Â¡Ã¥Â¼ÂÃ¯Â¼Å¡&a{group}",
                "&fÃ§â€°Ë†Ã¦Å“Â¬Ã¯Â¼Å¡&7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_STARTING, Arrays.asList(
                "&f&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date} &8{server}",
                "",
                "&fÃ¥Å“Â°Ã¥â€ºÂ¾Ã¯Â¼Å¡&a{map}",
                "",
                "&fÃ§Å½Â©Ã¥Â®Â¶Ã¦â€¢Â°Ã¯Â¼Å¡&a{on}/{max}",
                "",
                "&f &a{time} &fÃ§Â§â€™Ã¥ÂÅ½Ã¥Â¼â‚¬Ã¥Â§â€¹",
                "",
                "&fÃ¦Â¨Â¡Ã¥Â¼ÂÃ¯Â¼Å¡&a{group}",
                "&fÃ¦Â¨Â¡Ã¥Â¼ÂÃ¯Â¼Å¡&7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_STARTING_SPEC, Arrays.asList(
                "&f&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date} &8{server}",
                "&o&7Spectating",
                "&fÃ¥Å“Â°Ã¥â€ºÂ¾Ã¯Â¼Å¡&a{map}",
                "",
                "&fÃ§Å½Â©Ã¥Â®Â¶Ã¦â€¢Â°Ã¯Â¼Å¡&a{on}/{max}",
                "",
                "&f &a{time} &fÃ§Â§â€™Ã¥ÂÅ½Ã¥Â¼â‚¬Ã¥Â§â€¹",
                "",
                "&fÃ¦Â¨Â¡Ã¥Â¼ÂÃ¯Â¼Å¡&a{group}",
                "&fÃ¦Â¨Â¡Ã¥Â¼ÂÃ¯Â¼Å¡&7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING, Arrays.asList(
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "",
                "&f{nextEvent} - &a{time}",
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
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} - &a{time}",
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
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} - &a{time}",
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
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "",
                "&f{nextEvent} - &a{time}",
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
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} - &a{time}",
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
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} - &a{time}",
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
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "",
                "&f{nextEvent} - &a{time}",
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
                "&fÃ¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{kills}",
                "&fÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{finalKills}",
                "&fÃ§Â Â´Ã¥ÂÂÃ¥ÂºÅ Ã¯Â¼Å¡&a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC.replaceFirst("Default", "3v3v3v3"), Arrays.asList(
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} - &a{time}",
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
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} - &a{time}",
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
                "&fÃ¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{kills}",
                "&fÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{finalKills}",
                "&fÃ§Â Â´Ã¥ÂÂÃ¥ÂºÅ Ã¯Â¼Å¡&a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING.replaceFirst("Default", "4v4v4v4"), Arrays.asList(
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "",
                "&f{nextEvent} - &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&fÃ¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{kills}",
                "&fÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{finalKills}",
                "&fÃ§Â Â´Ã¥ÂÂÃ¥ÂºÅ Ã¯Â¼Å¡&a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC.replaceFirst("Default", "4v4v4v4"), Arrays.asList(
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} - &a{time}",
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
                "&e&lÃ¨ÂµÂ·Ã¥ÂºÅ Ã¦Ë†ËœÃ¤Âºâ€°",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&f{nextEvent} - &a{time}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&fÃ¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{kills}",
                "&fÃ¦Å“â‚¬Ã§Â»Ë†Ã¥â€¡Â»Ã¦Ââ‚¬Ã¯Â¼Å¡&a{finalKills}",
                "&fÃ§Â Â´Ã¥ÂÂÃ¥ÂºÅ Ã¯Â¼Å¡&a{beds}",
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

        yml.addDefault(Messages.SHOP_INDEX_NAME, "&8Ã¥Â¿Â«Ã©â‚¬Å¸Ã¨Â´Â­Ã¤Â¹Â°");
        yml.addDefault(Messages.SHOP_QUICK_ADD_NAME, "&8Ã¦Â·Â»Ã¥Å Â Ã¥Ë†Â°Ã¥Â¿Â«Ã©â‚¬Å¸Ã¨Â´Â­Ã¤Â¹Â°...");
        yml.addDefault(Messages.SHOP_INSUFFICIENT_MONEY, "{prefix}&cÃ¤Â½Â Ã¦Â²Â¡Ã¦Å“â€°Ã¨Â¶Â³Ã¥Â¤Å¸Ã§Å¡â€ž{currency}Ã¯Â¼Â Ã¨Â¿ËœÃ©Å“â‚¬Ã¨Â¦Â {amount} Ã¤Â¸Âª{currency}Ã¯Â¼Â");
        yml.addDefault(Messages.SHOP_NEW_PURCHASE, "{prefix}&aÃ¨Â´Â­Ã¤Â¹Â°&6{item}");
        yml.addDefault(Messages.SHOP_ALREADY_BOUGHT, "{prefix}&cÃ¤Â½Â Ã¥Â·Â²Ã§Â»ÂÃ¨Â´Â­Ã¤Â¹Â°Ã¨Â¿â€¡Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.SHOP_UTILITY_NPC_SILVERFISH_NAME, "{TeamColor}&l{TeamName} &r{TeamColor}Ã¨Â Â¹Ã¨â„¢Â«");
        yml.addDefault(Messages.SHOP_UTILITY_NPC_IRON_GOLEM_NAME, "{TeamColor}{despawn}Ã§Â§â€™ &8[ {TeamColor}{health}&8]");
        yml.addDefault(Messages.SHOP_SEPARATOR_NAME, "&8Ã¢â€¡Â§ Ã¥Ë†â€ Ã§Â±Â»");
        yml.addDefault(Messages.SHOP_SEPARATOR_LORE, Collections.singletonList("&8Ã¢â€¡Â© Ã§â€°Â©Ã¥â€œÂ"));
        yml.addDefault(Messages.SHOP_QUICK_BUY_NAME, "&bÃ¥Â¿Â«Ã©â‚¬Å¸Ã¨Â´Â­Ã¤Â¹Â°");
        yml.addDefault(Messages.SHOP_QUICK_BUY_LORE, new ArrayList<>());
        yml.addDefault(Messages.SHOP_QUICK_EMPTY_NAME, "&cÃ§Â©ÂºÃ¦Â§Â½Ã¤Â½ÂÃ¯Â¼Â");
        yml.addDefault(Messages.SHOP_QUICK_EMPTY_LORE, Arrays.asList("&7Ã¨Â¿â„¢Ã¦ËœÂ¯Ã¥Â¿Â«Ã©â‚¬Å¸Ã¨Â´Â­Ã¤Â¹Â°Ã¦Â§Â½Ã¤Â½ÂÃ¯Â¼Â", "&bShift+Ã§â€šÂ¹Ã¥â€¡Â» &7Ã¥â€¢â€ Ã¥Âºâ€”Ã¤Â¸Â­Ã§Å¡â€žÃ§â€°Â©Ã¥â€œÂ", "&7Ã¦ÂÂ¥Ã¥Å Â Ã¥Ë†Â°Ã¨Â¿â„¢Ã©â€¡Å’Ã£â‚¬â€š"));
        yml.addDefault(Messages.SHOP_CAN_BUY_COLOR, "&a");
        yml.addDefault(Messages.SHOP_CANT_BUY_COLOR, "&c");
        yml.addDefault(Messages.SHOP_LORE_STATUS_CAN_BUY, "&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¨Â´Â­Ã¤Â¹Â°Ã¯Â¼Â");
        yml.addDefault(Messages.SHOP_LORE_STATUS_CANT_AFFORD, "&cÃ¤Â½Â Ã¦Â²Â¡Ã¦Å“â€°Ã¨Â¶Â³Ã¥Â¤Å¸Ã§Å¡â€ž{currency}Ã¯Â¼Â");
        yml.addDefault(Messages.SHOP_LORE_STATUS_MAXED, "&aÃ¦Â»Â¡Ã§ÂºÂ§Ã¯Â¼Â");
        yml.addDefault(Messages.SHOP_LORE_STATUS_ARMOR, "&aÃ¥Â·Â²Ã¨Â£â€¦Ã¥Â¤â€¡Ã¯Â¼Â");
        yml.addDefault(Messages.SHOP_LORE_QUICK_ADD, "&bShift+Ã§â€šÂ¹Ã¥â€¡Â» Ã¦ÂÂ¥Ã¦Â·Â»Ã¥Å Â Ã¥Â¿Â«Ã©â‚¬Å¸Ã¨Â´Â­Ã¤Â¹Â°");
        yml.addDefault(Messages.SHOP_LORE_QUICK_REMOVE, "&bShift+Ã§â€šÂ¹Ã¥â€¡Â» Ã¦ÂÂ¥Ã¤Â»Å½Ã¥Â¿Â«Ã©â‚¬Å¸Ã¨Â´Â­Ã¤Â¹Â°Ã¤Â¸Â­Ã§Â§Â»Ã©â„¢Â¤Ã¯Â¼Â");


        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "&8Ã¦â€“Â¹Ã¥Ââ€”", "&aÃ¦â€“Â¹Ã¥Ââ€”", Collections.singletonList("&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹Ã¯Â¼Â"));

        addContentMessages(yml, "wool", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ã§Â¾Å Ã¦Â¯â€º", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡&f{cost} {currency}", "", "&7Ã¥Â¾Ë†Ã¥Â¥Â½Ã§Å¡â€žÃ¦ÂÂ­Ã¨Â·Â¯Ã¥Â·Â¥Ã¥â€¦Â·",
                "&7Ã¨Â´Â­Ã¤Â¹Â°Ã¥ÂÅ½Ã¥Â°â€ Ã¥ÂËœÃ¤Â¸ÂºÃ¤Â½Â Ã©ËœÅ¸Ã¤Â¼ÂÃ§Å¡â€žÃ©Â¢Å“Ã¨â€°Â²", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "clay", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ã§Â¡Â¬Ã¥Å’â€“Ã§Â²ËœÃ¥Å“Å¸", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "&7Ã¤Â¿ÂÃ¦Å Â¤Ã¥ÂºÅ Ã§Å¡â€žÃ¥Å¸ÂºÃ¦Å“Â¬Ã¦â€“Â¹Ã¥Ââ€”Ã£â‚¬â€š", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "glass", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ã©ËœÂ²Ã§Ë†â€ Ã§Å½Â»Ã§â€™Æ’", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "&7Ã¥â€¦ÂÃ§â€“Â«Ã§Ë†â€ Ã§â€šÂ¸Ã£â‚¬â€š", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "stone", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ã¦Å“Â«Ã¥Å“Â°Ã§Å¸Â³", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "&7Ã¤Â¿ÂÃ¦Å Â¤Ã¥ÂºÅ Ã§Å¡â€žÃ¥ÂÅ¡Ã¥Â®Å¾Ã¦â€“Â¹Ã¥Ââ€”Ã£â‚¬â€š", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "ladder", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ã¦Â¢Â¯Ã¥Â­Â", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "&7Ã§Ë†Â¬Ã¦Â â€˜Ã¦â€”Â¶Ã¥Â¾Ë†Ã¦Å“â€°Ã§â€Â¨Ã£â‚¬â€š", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "obsidian", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ã©Â»â€˜Ã¦â€ºÅ“Ã§Å¸Â³", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "&7Ã¥Â¯Â¹Ã¥ÂºÅ Ã§Å¡â€žÃ§Â»Ë†Ã¦Å¾ÂÃ¤Â¿ÂÃ¦Å Â¤Ã£â‚¬â€š", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "wood", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Ã¥Å½Å¸Ã¦Å“Â¨", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "&7Ã¤Â¿ÂÃ¦Å Â¤Ã¥ÂºÅ Ã§Å¡â€žÃ¥ÂÅ¡Ã¥Â®Å¾Ã¦â€“Â¹Ã¥Ââ€”Ã£â‚¬â€š", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_MELEE, "&8Ã¦Ë†ËœÃ¦â€“â€”", "&aÃ¦Ë†ËœÃ¦â€“â€”", Collections.singletonList("&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹Ã¯Â¼Â"));

        addContentMessages(yml, "stone-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Ã§Å¸Â³Ã¥â€°â€˜", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "iron-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Ã©â€œÂÃ¥â€°â€˜", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "diamond-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Ã©â€™Â»Ã§Å¸Â³Ã¥â€°â€˜", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "stick", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Ã¦Å“Â¨Ã¦Â£Â(Ã¥â€¡Â»Ã©â‚¬â‚¬ I)", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "&8Ã§â€ºâ€Ã§â€Â²", "&aÃ§â€ºâ€Ã§â€Â²", Collections.singletonList("&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹Ã¯Â¼Â"));

        addContentMessages(yml, "chainmail", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Ã©â€ÂÃ©â€œÂ¾Ã¦Å Â¤Ã§â€Â²", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}",
                "", "&7Ã©â€ÂÃ©â€œÂ¾Ã©ÂÂ´Ã¥Â­ÂÃ¥â€™Å’Ã¦Å Â¤Ã¨â€¦Â¿", "&7Ã¦Â­Â»Ã¤ÂºÂ¡Ã¤Â¸ÂÃ¦Å½â€°Ã¨ÂÂ½", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "iron-armor", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Ã©â€œÂÃ¦Å Â¤Ã§â€Â²", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}",
                "", "&7Ã©â€œÂÃ©ÂÂ´Ã¥Â­ÂÃ¥â€™Å’Ã¦Å Â¤Ã¨â€¦Â¿", "&7Ã¦Â­Â»Ã¤ÂºÂ¡Ã¤Â¸ÂÃ¦Å½â€°Ã¨ÂÂ½", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "diamond-armor", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Ã©â€™Â»Ã§Å¸Â³Ã¦Å Â¤Ã§â€Â²", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}",
                "", "&7Ã©â€™Â»Ã§Å¸Â³Ã©ÂÂ´Ã¥Â­ÂÃ¥â€™Å’Ã¦Å Â¤Ã¨â€¦Â¿", "&7Ã¦Â­Â»Ã¤ÂºÂ¡Ã¤Â¸ÂÃ¦Å½â€°Ã¨ÂÂ½", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "&8Ã¥Â·Â¥Ã¥â€¦Â·", "&aÃ¥Â·Â¥Ã¥â€¦Â·", Collections.singletonList("&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹Ã¯Â¼Â"));

        addContentMessages(yml, "shears", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Ã¥â€°ÂªÃ¥Ë†â‚¬", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}",
                "", "&7Ã¦â€¹â€ Ã§Â¾Å Ã¦Â¯â€ºÃ§Å¡â€žÃ¥Ë†Â©Ã¥â„¢Â¨", "&7Ã¦Â­Â»Ã¤ÂºÂ¡Ã¤Â¸ÂÃ¦Å½â€°Ã¨ÂÂ½Ã£â‚¬â€š", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "pickaxe", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Ã©â€¢Â{tier}", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "&7Ã§Â­â€°Ã§ÂºÂ§Ã¯Â¼Å¡&e{tier}",
                "", "&7Ã¨Â¯Â¥Ã¥Â·Â¥Ã¥â€¦Â·Ã¥ÂÂ¯Ã¥Ââ€¡Ã§ÂºÂ§Ã£â‚¬â€š", "&7Ã¦Â¯ÂÃ¦Â¬Â¡Ã¦Â­Â»Ã¤ÂºÂ¡Ã©Æ’Â½Ã¤Â¼Å¡Ã©â„¢ÂÃ¤Â¸â‚¬Ã§ÂºÂ§Ã£â‚¬â€š", "", "&7Ã©â„¢ÂÃ¥Ë†Â°Ã¦Å“â‚¬Ã¤Â½Å½Ã§ÂºÂ§Ã¤Â¸ÂºÃ¦Â­Â¢", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "axe", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Ã¦â€“Â§{tier}", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "&7Ã§Â­â€°Ã§ÂºÂ§Ã¯Â¼Å¡&e{tier}",
                "", "&7Ã¨Â¯Â¥Ã¥Â·Â¥Ã¥â€¦Â·Ã¥ÂÂ¯Ã¥Ââ€¡Ã§ÂºÂ§Ã£â‚¬â€š", "&7Ã¦Â¯ÂÃ¦Â¬Â¡Ã¦Â­Â»Ã¤ÂºÂ¡Ã©Æ’Â½Ã¤Â¼Å¡Ã©â„¢ÂÃ¤Â¸â‚¬Ã§ÂºÂ§Ã£â‚¬â€š", "", "&7Ã©â„¢ÂÃ¥Ë†Â°Ã¦Å“â‚¬Ã¤Â½Å½Ã§ÂºÂ§Ã¤Â¸ÂºÃ¦Â­Â¢", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_RANGED, "&8Ã¨Â¿Å“Ã§Â¨â€¹Ã¦Â­Â¦Ã¥â„¢Â¨", "&aÃ¨Â¿Å“Ã§Â¨â€¹Ã¦Â­Â¦Ã¥â„¢Â¨", Collections.singletonList("&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹Ã¯Â¼Â"));

        addContentMessages(yml, "arrow", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Ã§Â®Â­", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow1", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Ã¥Â¼â€œ", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow2", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Ã¥Â¼â€œÃ¯Â¼Ë†Ã¥Å â€ºÃ©â€¡Â IÃ¯Â¼â€°", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow3", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Ã¥Â¼â€œÃ¯Â¼Ë†Ã¥Å â€ºÃ©â€¡Â I, Ã¥â€ Â²Ã¥â€¡Â» IÃ¯Â¼â€°", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "&8Ã¨ÂÂ¯Ã¦Â°Â´", "&aÃ¨ÂÂ¯Ã¦Â°Â´", Collections.singletonList("&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹Ã¯Â¼Â"));

        addContentMessages(yml, "speed-potion", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}Ã©â‚¬Å¸Ã¥ÂºÂ¦ II Ã¨ÂÂ¯Ã¦Â°Â´Ã¯Â¼Ë†45 Ã§Â§â€™Ã¯Â¼â€°", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "jump-potion", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}Ã¨Â·Â³Ã¨Â·Æ’Ã¦ÂÂÃ¥Ââ€¡ V Ã¨ÂÂ¯Ã¦Â°Â´Ã¯Â¼Ë†45 Ã§Â§â€™Ã¯Â¼â€°", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "invisibility", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}Ã©Å¡ÂÃ¨ÂºÂ«Ã¨ÂÂ¯Ã¦Â°Â´Ã¯Â¼Ë†30 Ã§Â§â€™Ã¯Â¼â€°", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "&8Ã¥Â®Å¾Ã§â€Â¨Ã¥Â·Â¥Ã¥â€¦Â·", "&aÃ¥Â®Å¾Ã§â€Â¨Ã¥Â·Â¥Ã¥â€¦Â·", Collections.singletonList("&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹Ã¯Â¼Â"));

        addContentMessages(yml, "golden-apple", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã©â€¡â€˜Ã¨â€¹Â¹Ã¦Å¾Å“", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "&7Ã¥Ââ€¡Ã¨Â¡Â¡Ã¦Â²Â»Ã§â€“â€”", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bedbug", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã¨Â Â¹Ã¨â„¢Â«", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "",
                "&7Ã¥Å“Â¨Ã©â€ºÂªÃ§ÂÆ’Ã¨ÂÂ½Ã¤Â¸â€¹Ã§Å¡â€žÃ¥Å“Â°Ã¦â€“Â¹Ã¥ÂÂ¬Ã¥â€Â¤Ã¨Â Â¹Ã¨â„¢Â«", "&7Ã¦ÂÂ¥Ã¥Â¹Â²Ã¦â€°Â°Ã¦â€¢Å’Ã¤ÂºÂº", "&7Ã¦Å’ÂÃ§Â»Â­15Ã§Â§â€™Ã£â‚¬â€š", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "dream-defender", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã¦Â¢Â¦Ã¥Â¢Æ’Ã¥Â®Ë†Ã¥ÂÂ«Ã¨â‚¬â€¦", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "",
                "&7Ã¥ÂÂ¬Ã¥â€Â¤Ã©â€œÂÃ¥â€šâ‚¬Ã¥â€žÂ¡Ã¦ÂÂ¥Ã¤Â¿ÂÃ¦Å Â¤Ã¥Å¸ÂºÃ¥Å“Â°", "&7Ã¦Å’ÂÃ§Â»Â­ 4 Ã¥Ë†â€ Ã©â€™Å¸", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "fireball", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã§ÂÂ«Ã§ÂÆ’", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "", "&7Ã¥ÂÂ³Ã©â€Â®Ã¥Ââ€˜Ã¥Â°â€žÃ¯Â¼Â",
                "&7Ã¦Å Å Ã¥Å“Â¨Ã§Âªâ€žÃ¦Â¡Â¥Ã¤Â¸Å Ã§Å¡â€žÃ¦â€¢Å’Ã¤ÂºÂºÃ¦â€°â€œÃ¤Â¸â€¹Ã¥Å½Â»Ã¯Â¼Â", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "tnt", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}TNT", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "",
                "&7Ã§Â«â€¹Ã¥ÂÂ³Ã§â€šÂ¹Ã§â€¡Æ’, Ã©â‚¬â€šÃ¥ÂË†Ã§â€šÂ¸Ã§â€šÂ¹Ã¤Â¸Å“Ã¨Â¥Â¿", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "ender-pearl", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã¦Å“Â«Ã¥Â½Â±Ã§ÂÂÃ§ÂÂ ", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "",
                "&7Ã¥ÂÂ·Ã¥Â®Â¶Ã¦Å“â‚¬Ã¥Â¿Â«Ã§Å¡â€žÃ¦â€“Â¹Ã¥Â¼Â", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "water-bucket", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã¦Â°Â´Ã¦Â¡Â¶", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "",
                "&7Ã¥â€¡ÂÃ§Â¼â€œÃ¦â€¢Å’Ã¤ÂºÂºÃ§Å¡â€žÃ©â‚¬Å¸Ã¥ÂºÂ¦", "&7Ã¤Â¹Å¸Ã¥ÂÂ¯Ã¤Â»Â¥Ã©ËœÂ²Ã¦Â­Â¢ TNT Ã§Â Â´Ã¥ÂÂÃ¦â€“Â¹Ã¥Ââ€”", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bridge-egg", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã¦ÂÂ­Ã¦Â¡Â¥Ã¨â€ºâ€¹", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "",
                "&7Ã¤Â¸Â¢Ã¥â€¡ÂºÃ¥ÂÅ½Ã¥Å“Â¨Ã¥â€¦Â¶Ã¨Â½Â¨Ã¨Â¿Â¹Ã¥Â½Â¢Ã¦Ë†ÂÃ¤Â¸â‚¬Ã¥ÂºÂ§Ã¦Â¡Â¥", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "magic-milk", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã©Â­â€Ã¦Â³â€¢Ã§â€°â€ºÃ¥Â¥Â¶", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "",
                "&7Ã¥â€“ÂÃ¤Â¸â€¹Ã¥ÂÅ½ 60 Ã§Â§â€™Ã¥â€ â€¦Ã¤Â¸ÂÃ¤Â¼Å¡Ã¨Â§Â¦Ã¥Ââ€˜Ã©â„¢Â·Ã©ËœÂ±", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "sponge", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã¦ÂµÂ·Ã§Â»Âµ", Arrays.asList("&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{cost} {currency}", "",
                "&7Ã§â€Â¨Ã¦ÂÂ¥Ã¥ÂÂ¸Ã¦Â°Â´Ã¤Â¸ÂÃ©â€â„¢", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "Compact Pop-up Tower", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ã¨Â¢â€“Ã§ÂÂÃ¥Â¼Â¹Ã¥â€¡ÂºÃ¥Â¡â€", Arrays.asList("&Ã¨Å Â±Ã¨Â´Â¹: {cost} {currency}", "",
                "&7Ã¦â€Â¾Ã§Â½Â®Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¨Â¢â€“Ã§ÂÂÃ¥Â¼Â¹Ã¥â€¡ÂºÃ¥Â¡â€", "&7Ã¥Â¡â€Ã©ËœÂ²Ã¯Â¼Â", "", "{quick_buy}", "{buy_status}"));

        yml.addDefault(Messages.MEANING_NO_TRAP, "Ã¦â€”Â Ã©â„¢Â·Ã©ËœÂ±Ã¯Â¼Â");
        yml.addDefault(Messages.FORMAT_SPECTATOR_TARGET, "{targetTeamColor}{targetDisplayName}");
        yml.addDefault(Messages.FORMAT_UPGRADE_TRAP_COST, "&7Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡{currencyColor}{cost} {currency}");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_CAN_AFFORD, "&e");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_CANT_AFFORD, "&c");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_UNLOCKED, "&a");
        yml.addDefault(Messages.FORMAT_UPGRADE_TIER_LOCKED, "&7");
        yml.addDefault(Messages.FORMAT_UPGRADE_TIER_UNLOCKED, "&a");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_CLICK_TO_BUY, "{color}Ã§â€šÂ¹Ã¥â€¡Â»Ã¨Â´Â­Ã¤Â¹Â°Ã¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_INSUFFICIENT_MONEY, "{color}Ã¤Â½Â Ã¦Â²Â¡Ã¦Å“â€°Ã¨Â¶Â³Ã¥Â¤Å¸Ã§Å¡â€ž{currency}Ã¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_LOCKED, "&cÃ¥Â·Â²Ã©â€ÂÃ¥Â®Å¡");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_UNLOCKED, "{color}Ã¥Â·Â²Ã¨Â§Â£Ã©â€Â");
        yml.addDefault(Messages.UPGRADES_UPGRADE_BOUGHT_CHAT, "&a{player}Ã¨Â´Â­Ã¤Â¹Â°Ã¤Âºâ€ &6{upgradeName}");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-1"), "{color}Ã©â€œÂÃ©â€Â­Ã§â€ â€Ã§â€šâ€°");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "forge"),
                Arrays.asList("&7Ã¥Â¢Å¾Ã¥Å Â Ã¥Â²â€ºÃ¤Â¸Å Ã¨Âµâ€žÃ¦ÂºÂÃ§Å¡â€žÃ§â€Å¸Ã¦Ë†ÂÃ©â‚¬Å¸Ã¥ÂºÂ¦", "", "{tier_1_color}Ã§Â­â€°Ã§ÂºÂ§ 1Ã¯Â¼Å¡+50% Ã§â€Å¸Ã¦Ë†ÂÃ©â‚¬Å¸Ã§Å½â€¡, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}Ã§Â­â€°Ã§ÂºÂ§ 2Ã¯Â¼Å¡+100% Ã§â€Å¸Ã¦Ë†ÂÃ©â‚¬Å¸Ã§Å½â€¡Ã¯Â¼Å’&b{tier_2_cost} {tier_2_currency}",
                        "{tier_3_color}Ã§Â­â€°Ã§ÂºÂ§ 3Ã¯Â¼Å¡Ã§â€Å¸Ã¦Ë†ÂÃ§Â»Â¿Ã¥Â®ÂÃ§Å¸Â³Ã¯Â¼Å’&b{tier_3_cost} {tier_3_currency}",
                        "{tier_4_color}Ã§Â­â€°Ã§ÂºÂ§ 4Ã¯Â¼Å¡+200% Ã§â€Å¸Ã¦Ë†ÂÃ©â‚¬Å¸Ã§Å½â€¡Ã¯Â¼Å’&b{tier_4_cost} {tier_4_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-2"), "{color}Ã©â€¡â€˜Ã©â€Â­Ã§â€ â€Ã§â€šâ€°");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-3"), "{color}Ã§Â»Â¿Ã¥Â®ÂÃ§Å¸Â³Ã§â€ â€Ã§â€šâ€°");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-4"), "{color}Ã¦â€”Â Ã¥Â°Â½Ã§â€ â€Ã§â€šâ€°");
        yml.addDefault(Messages.UPGRADES_CATEGORY_ITEM_NAME_PATH + "traps", "&eÃ¨Â´Â­Ã¤Â¹Â°Ã©â„¢Â·Ã©ËœÂ±");
        yml.addDefault(Messages.UPGRADES_CATEGORY_ITEM_LORE_PATH + "traps", Arrays.asList("&7Ã¥Â·Â²Ã¨Â´Â­Ã¤Â¹Â°Ã§Å¡â€žÃ©â„¢Â·Ã©ËœÂ±Ã¥Â°â€ Ã¤Â»Å½Ã¥ÂÂ³Ã¨Â¾Â¹Ã¨Â¿â€ºÃ¥â€¦Â¥Ã©ËœÅ¸Ã¥Ë†â€”", "", "&eÃ§â€šÂ¹Ã¥â€¡Â»Ã¦Å¸Â¥Ã§Å“â€¹Ã¯Â¼Â"));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "swords").replace("{tier}", "tier-1"), "{color}Ã©â€â€¹Ã¥Ë†Â©Ã©â„¢â€žÃ©Â­â€");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "swords"),
                Arrays.asList("&7Ã©ËœÅ¸Ã¤Â¼ÂÃ§Å¡â€žÃ¦â€°â‚¬Ã¦Å“â€°Ã¥â€°â€˜Ã¥â€™Å’Ã¦â€“Â§Ã¨Å½Â·Ã¥Â¾â€”Ã©â€â€¹Ã¥Ë†Â© IÃ¯Â¼Â", "", "{tier_1_color}Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡&b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-1"), "{color}Ã¦Å Â¤Ã§â€Â²Ã¥Â¼ÂºÃ¥Å’â€“ I");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "armor"),
                Arrays.asList("&7Ã©ËœÅ¸Ã¤Â¼ÂÃ§Å¡â€žÃ¦â€°â‚¬Ã¦Å“â€°Ã¦Å Â¤Ã§â€Â²Ã¨Å½Â·Ã¥Â¾â€”Ã¤Â¿ÂÃ¦Å Â¤Ã©â„¢â€žÃ©Â­â€Ã¯Â¼Â", "", "{tier_1_color}Ã§Â­â€°Ã§ÂºÂ§ 1Ã¯Â¼Å¡Ã¤Â¿ÂÃ¦Å Â¤ IÃ¯Â¼Å’ &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}Ã§Â­â€°Ã§ÂºÂ§ 2Ã¯Â¼Å¡Ã¤Â¿ÂÃ¦Å Â¤ IIÃ¯Â¼Å’&b{tier_2_cost} {tier_2_currency}",
                        "{tier_3_color}Ã§Â­â€°Ã§ÂºÂ§ 3Ã¯Â¼Å¡Ã¤Â¿ÂÃ¦Å Â¤ IIIÃ¯Â¼Å’&b{tier_3_cost} {tier_3_currency}",
                        "{tier_4_color}Ã§Â­â€°Ã§ÂºÂ§ 4Ã¯Â¼Å¡Ã¤Â¿ÂÃ¦Å Â¤ IVÃ¯Â¼Å’&b{tier_4_cost} {tier_4_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-2"), "{color}Ã¦Å Â¤Ã§â€Â²Ã¥Â¼ÂºÃ¥Å’â€“ II");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-3"), "{color}Ã¦Å Â¤Ã§â€Â²Ã¥Â¼ÂºÃ¥Å’â€“ III");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-4"), "{color}Ã¦Å Â¤Ã§â€Â²Ã¥Â¼ÂºÃ¥Å’â€“ IV");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "miner").replace("{tier}", "tier-1"), "{color}Ã§â€“Â¯Ã§â€¹â€šÃ§Å¸Â¿Ã¥Â·Â¥ I");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "miner"),
                Arrays.asList("&7Ã©ËœÅ¸Ã¤Â¼ÂÃ¨Å½Â·Ã¥Â¾â€”Ã¦â‚¬Â¥Ã¨Â¿Â«Ã¦â€¢Ë†Ã¦Å¾Å“Ã£â‚¬â€š", "", "{tier_1_color}Ã§Â­â€°Ã§ÂºÂ§ 1Ã¯Â¼Å¡Ã¦â‚¬Â¥Ã¨Â¿Â« I, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}Ã§Â­â€°Ã§ÂºÂ§ 2Ã¯Â¼Å¡Ã¦â‚¬Â¥Ã¨Â¿Â« II, &b{tier_2_cost} {tier_2_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "miner").replace("{tier}", "tier-2"), "{color}Ã§â€“Â¯Ã§â€¹â€šÃ§Å¸Â¿Ã¥Â·Â¥ II");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "heal-pool").replace("{tier}", "tier-1"), "{color}Ã¦Â²Â»Ã¦â€žË†Ã¦Â±Â ");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "heal-pool"),
                Arrays.asList("&7Ã¥Å“Â¨Ã¥Å¸ÂºÃ¥Å“Â°Ã©â„¢â€žÃ¨Â¿â€˜Ã§â€Å¸Ã¦Ë†ÂÃ¦Â²Â»Ã¦â€žË†Ã¦Â±Â Ã¯Â¼Â", "", "{tier_1_color}Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡&b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "dragon").replace("{tier}", "tier-1"), "{color}Ã¦Å“Â«Ã¥Â½Â±Ã©Â¾â„¢Ã¥Ââ€¡Ã§ÂºÂ§");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "dragon").replace("{tier}", "tier-1"),
                Arrays.asList("&7Ã¥Å“Â¨Ã¦Â­Â»Ã¦â€“â€”Ã¦â€”Â¶Ã¤Â½Â Ã§Å¡â€žÃ©ËœÅ¸Ã¤Â¼ÂÃ¤Â¼Å¡Ã¦Å“â€° 2 Ã¦ÂÂ¡Ã¨â‚¬Å’Ã¤Â¸ÂÃ¦ËœÂ¯ 1 Ã¦ÂÂ¡Ã©Â¾â„¢Ã¯Â¼Â", "", "{tier_1_color}Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡&b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + "glass", "&8Ã¢Â¬â€ &7Ã¥ÂÂ¯Ã¨Â´Â­Ã¤Â¹Â°");
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + "glass", Collections.singletonList("&8Ã¢Â¬â€¡&7Ã©â„¢Â·Ã©ËœÂ±Ã©ËœÅ¸Ã¥Ë†â€”"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "first", "{color}Ã©â„¢Â·Ã©ËœÂ± #1Ã¯Â¼Å¡{name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "first", Collections.singletonList("&7Ã§Â¬Â¬Ã¤Â¸â‚¬Ã¤Â¸ÂªÃ¨Â¿â€ºÃ¥â€¦Â¥Ã¤Â½Â Ã¥Å¸ÂºÃ¥Å“Â°Ã§Å¡â€žÃ¦â€¢Å’Ã¤ÂºÂºÃ¥Â°â€ Ã¨Â§Â¦Ã¥Ââ€˜Ã¨Â¯Â¥Ã©â„¢Â·Ã©ËœÂ±Ã¯Â¼Â"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "first",
                Arrays.asList("", "&7Ã¤Â¸â€¹Ã¤Â¸ÂªÃ¨Â´Â­Ã¤Â¹Â°Ã§Å¡â€žÃ©â„¢Â·Ã©ËœÂ±Ã¥Â°â€ Ã¥Å“Â¨Ã¦Â­Â¤Ã¨Â¿â€ºÃ¥â€¦Â¥Ã©ËœÅ¸Ã¥Ë†â€”", "&7Ã©â„¢Â·Ã©ËœÂ±Ã§Å¡â€žÃ¨Å Â±Ã¨Â´Â¹Ã¥Â°â€ Ã¤Â¼Å¡Ã©Å¡ÂÃ§Ââ‚¬Ã©ËœÅ¸Ã¥Ë†â€”Ã©â€¢Â¿Ã¥ÂºÂ¦Ã¥Â¢Å¾Ã¥Å Â ", "", "&7Ã¤Â¸â€¹Ã¤Â¸ÂªÃ©â„¢Â·Ã©ËœÂ±Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡&b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "second", "{color}Ã©â„¢Â·Ã©ËœÂ± #2Ã¯Â¼Å¡{name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "second", Collections.singletonList("&7Ã§Â¬Â¬Ã¤ÂºÅ’Ã¤Â¸ÂªÃ¨Â¿â€ºÃ¥â€¦Â¥Ã¤Â½Â Ã¥Å¸ÂºÃ¥Å“Â°Ã§Å¡â€žÃ¦â€¢Å’Ã¤ÂºÂºÃ¥Â°â€ Ã¨Â§Â¦Ã¥Ââ€˜Ã¨Â¯Â¥Ã©â„¢Â·Ã©ËœÂ±Ã¯Â¼Â"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "second",
                Arrays.asList("", "&7Ã¤Â¸â€¹Ã¤Â¸ÂªÃ¨Â´Â­Ã¤Â¹Â°Ã§Å¡â€žÃ©â„¢Â·Ã©ËœÂ±Ã¥Â°â€ Ã¥Å“Â¨Ã¦Â­Â¤Ã¨Â¿â€ºÃ¥â€¦Â¥Ã©ËœÅ¸Ã¥Ë†â€”", "&7Ã©â„¢Â·Ã©ËœÂ±Ã§Å¡â€žÃ¨Å Â±Ã¨Â´Â¹Ã¥Â°â€ Ã¤Â¼Å¡Ã©Å¡ÂÃ§Ââ‚¬Ã©ËœÅ¸Ã¥Ë†â€”Ã©â€¢Â¿Ã¥ÂºÂ¦Ã¥Â¢Å¾Ã¥Å Â ", "", "&7Ã¤Â¸â€¹Ã¤Â¸ÂªÃ©â„¢Â·Ã©ËœÂ±Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡&b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "third", "{color}Ã©â„¢Â·Ã©ËœÂ± #3Ã¯Â¼Å¡{name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "third", Collections.singletonList("&7Ã§Â¬Â¬Ã¤Â¸â€°Ã¤Â¸ÂªÃ¨Â¿â€ºÃ¥â€¦Â¥Ã¤Â½Â Ã¥Å¸ÂºÃ¥Å“Â°Ã§Å¡â€žÃ¦â€¢Å’Ã¤ÂºÂºÃ¥Â°â€ Ã¨Â§Â¦Ã¥Ââ€˜Ã¨Â¯Â¥Ã©â„¢Â·Ã©ËœÂ±Ã¯Â¼Â"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "third",
                Arrays.asList("", "&7Ã¤Â¸â€¹Ã¤Â¸ÂªÃ¨Â´Â­Ã¤Â¹Â°Ã§Å¡â€žÃ©â„¢Â·Ã©ËœÂ±Ã¥Â°â€ Ã¥Å“Â¨Ã¦Â­Â¤Ã¨Â¿â€ºÃ¥â€¦Â¥Ã©ËœÅ¸Ã¥Ë†â€”", "&7Ã©â„¢Â·Ã©ËœÂ±Ã§Å¡â€žÃ¨Å Â±Ã¨Â´Â¹Ã¥Â°â€ Ã¤Â¼Å¡Ã©Å¡ÂÃ§Ââ‚¬Ã©ËœÅ¸Ã¥Ë†â€”Ã©â€¢Â¿Ã¥ÂºÂ¦Ã¥Â¢Å¾Ã¥Å Â ", "", "&7Ã¤Â¸â€¹Ã¤Â¸ÂªÃ©â„¢Â·Ã©ËœÂ±Ã¨Å Â±Ã¨Â´Â¹Ã¯Â¼Å¡&b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "1", "{color}Ã¨Â¿â„¢Ã¦ËœÂ¯Ã¤Â¸ÂªÃ©â„¢Â·Ã©ËœÂ±Ã¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "1", Arrays.asList("&7Ã©â‚¬Â Ã¦Ë†Â5Ã§Â§â€™Ã¥Â¤Â±Ã¦ËœÅ½Ã¥â€™Å’Ã§Â¼â€œÃ¦â€¦Â¢", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "2", "{color}Ã¥ÂÂÃ¥â€¡Â»Ã©â„¢Â·Ã©ËœÂ±");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "2", Arrays.asList("&7Ã§Â»â„¢Ã¤ÂºË†Ã¥Å¸ÂºÃ¥Å“Â°Ã©â„¢â€žÃ¨Â¿â€˜Ã§Å¡â€žÃ©ËœÅ¸Ã¥Ââ€¹ 15 Ã§Â§â€™Ã©â‚¬Å¸Ã¥ÂºÂ¦ IÃ£â‚¬â€š", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "3", "{color}Ã¦Å Â¥Ã¨Â­Â¦Ã©â„¢Â·Ã©ËœÂ±");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "3", Arrays.asList("&7Ã¦ËœÂ¾Ã§Â¤ÂºÃ©Å¡ÂÃ¨ÂºÂ«Ã§Å¡â€žÃ¦â€¢Å’Ã¤ÂºÂºÃ¥ÂÅ Ã¥â€¦Â¶Ã¥ÂÂÃ¥Â­â€”Ã¥â€™Å’Ã©ËœÅ¸Ã¤Â¼ÂÃ£â‚¬â€š", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "4", "{color}Ã¦Å’â€“Ã¦Å½ËœÃ§â€“Â²Ã¥Å Â³Ã©â„¢Â·Ã©ËœÂ±");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "4", Arrays.asList("&7Ã©â‚¬Â Ã¦Ë†Â 10 Ã§Â§â€™Ã¦Å’â€“Ã¦Å½ËœÃ§â€“Â²Ã¥Å Â³Ã£â‚¬â€š", ""));
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + "back", "&aÃ¨Â¿â€Ã¥â€ºÅ¾");
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + "back", Collections.singletonList("&7Ã¥â€ºÅ¾Ã¥Ë†Â°Ã¥Ââ€¡Ã§ÂºÂ§Ã¥â€™Å’Ã©â„¢Â·Ã©ËœÂ±Ã¨ÂÅ“Ã¥Ââ€¢"));
        yml.addDefault(Messages.UPGRADES_CATEGORY_GUI_NAME_PATH + "traps", "&8Ã¥Â°â€ Ã©â„¢Â·Ã©ËœÂ±Ã¥Å Â Ã¥â€¦Â¥Ã©ËœÅ¸Ã¥Ë†â€”");
        yml.addDefault(Messages.UPGRADES_TRAP_QUEUE_LIMIT, "&cÃ©â„¢Â·Ã©ËœÂ±Ã©ËœÅ¸Ã¥Ë†â€”Ã¥Â·Â²Ã¦Â»Â¡Ã¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_MSG, "&c&l{trap}Ã¨Â¢Â«Ã¨Â§Â¦Ã¥Ââ€˜Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_TITLE, "&cÃ©â„¢Â·Ã©ËœÂ±Ã¨Â§Â¦Ã¥Ââ€˜Ã¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_SUBTITLE, "&fÃ¤Â½Â Ã©ËœÅ¸Ã¤Â¼ÂÃ§Å¡â€ž{trap}Ã¨Â¢Â«Ã¨Â§Â¦Ã¥Ââ€˜Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_MSG + "3", "&c&lÃ¦Å Â¥Ã¨Â­Â¦Ã©â„¢Â·Ã©ËœÂ±Ã¨Â¢Â«{color}&l{team}Ã§Å¡â€ž&7&l{player}&c&lÃ¨Â§Â¦Ã¥Ââ€˜Ã¤Âºâ€ Ã¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_TITLE + "3", "&c&lÃ¨Â­Â¦Ã¦Å Â¥Ã¯Â¼ÂÃ¯Â¼ÂÃ¯Â¼Â");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_SUBTITLE + "3", "{color}{team}&fÃ¨Â§Â¦Ã¥Ââ€˜Ã¤Âºâ€ Ã©â„¢Â·Ã©ËœÂ±Ã¯Â¼Â");
        save();
        setPrefix(m(Messages.PREFIX));
        setPrefixStatic(m(Messages.PREFIX));
    }
}

