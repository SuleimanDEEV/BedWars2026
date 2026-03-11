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

public class Turkish extends Language {

    public Turkish() {
        super(BukkitBedPlugin.plugin, "tr");

        YamlConfiguration yml = getYml();
        yml.options().copyDefaults(true);
        yml.options().header("Turkish translation by https://kuzeeeyk.me [kuzeeeyk#7268 or @kuzeeeyk]");
        yml.addDefault(Messages.PREFIX, "");
        yml.addDefault("name", "TÃƒÂ¼rkÃƒÂ§e");

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

        yml.addDefault(Messages.COMMAND_MAIN, Arrays.asList("", "&2Ã¢â€“Âª &7/" + mainCmd + " stats", "&2Ã¢â€“Âª &7/" + mainCmd + " join &o<harita/grup>", "&2Ã¢â€“Âª &7/" + mainCmd + " leave", "&2Ã¢â€“Âª &7/" + mainCmd + " lang", "&2Ã¢â€“Âª &7/" + mainCmd + " gui", "&2Ã¢â€“Âª &7/" + mainCmd + " start &3(vip)"));
        yml.addDefault(Messages.COMMAND_LANG_LIST_HEADER, "{prefix} &2Mevcut diller:");
        yml.addDefault(Messages.COMMAND_LANG_LIST_FORMAT, "&aÃ¢â€“Âª  &7{iso} - &f{name}");
        yml.addDefault(Messages.COMMAND_LANG_USAGE, "{prefix}&7KullanÃ„Â±m: /lang &f&o<iso>");
        yml.addDefault(Messages.COMMAND_LANG_SELECTED_NOT_EXIST, "{prefix}&cBu dil bulunmuyor!");
        yml.addDefault(Messages.COMMAND_LANG_SELECTED_SUCCESSFULLY, "{prefix}&aDil deÃ„Å¸iÃ…Å¸tirildi!");
        yml.addDefault(Messages.COMMAND_LANG_USAGE_DENIED, "{prefix}&cOyun sÃ„Â±rasÃ„Â±nda dili deÃ„Å¸iÃ…Å¸tiremezsin.");
        yml.addDefault(Messages.COMMAND_JOIN_USAGE, "Ã‚Â§aÃ¢â€“Âª Ã‚Â§7KullanÃ„Â±m: /" + mainCmd + " join Ã‚Â§o<arena/group>");
        yml.addDefault(Messages.COMMAND_JOIN_GROUP_OR_ARENA_NOT_FOUND, "{prefix}&c{name} adÃ„Â±nda bir grup veya harita bulunamadÃ„Â±!");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_IS_FULL, "{prefix}&cBu harita dolu!");
        yml.addDefault(Messages.COMMAND_JOIN_NO_EMPTY_FOUND, "{prefix}&cÃ…Å¾u anda hiÃƒÂ§ boÃ…Å¸ harita bulunamadÃ„Â± ;(");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_IS_FULL_OF_VIPS, "{prefix}&cÃƒÅ“zgÃƒÂ¼nÃƒÂ¼z fakat bu harita dolu.\n&cBaÃ„Å¸Ã„Â±Ã…Å¸ÃƒÂ§Ã„Â± olduÃ„Å¸unu biliyoruz ama bu harita diÃ„Å¸er baÃ„Å¸Ã„Â±Ã…Å¸ÃƒÂ§Ã„Â± ya da yetkililer ile dolu.");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_PARTY_TOO_BIG, "{prefix}&cPartin bu harita bir takÃ„Â±m olarak katÃ„Â±labilmek iÃƒÂ§in ÃƒÂ§ok bÃƒÂ¼yÃƒÂ¼k!");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_NOT_PARTY_LEADER, "{prefix}&cSadece parti lideri harita seÃƒÂ§ebilir.");
        yml.addDefault(Messages.COMMAND_JOIN_PLAYER_JOIN_MSG, "{prefix}&7{player} &ekatÃ„Â±ldÃ„Â± (&b{on}&e/&b{max}&e)!");
        yml.addDefault(Messages.COMMAND_JOIN_SPECTATOR_MSG, "{prefix}Ã‚Â§6Ã…Å¾u anda Ã‚Â§9{arena}Ã‚Â§6 haritasÃ„Â±nÃ„Â± seyrediyorsun.\n{prefix}Ã‚Â§eHaritadan ayrÃ„Â±lmak iÃƒÂ§in Ã‚Â§c/leaveÃ‚Â§e komudunu kullanabilirsin.");
        yml.addDefault(Messages.COMMAND_JOIN_SPECTATOR_DENIED_MSG, "&cBu harita seyircilere kapalÃ„Â±!");
        yml.addDefault(Messages.COMMAND_TP_PLAYER_NOT_FOUND, "{prefix}&cOyuncu bulunamadÃ„Â±!");
        yml.addDefault(Messages.COMMAND_TP_NOT_IN_ARENA, "{prefix}&cBu oyuncu bir haritada deÃ„Å¸il!");
        yml.addDefault(Messages.COMMAND_TP_NOT_STARTED, "{prefix}&cOyuncunun bulunduÃ„Å¸u haritada oyun henÃƒÂ¼z baÃ…Å¸lamadÃ„Â±!");
        yml.addDefault(Messages.COMMAND_TP_USAGE, "{prefix}&cKullanÃ„Â±m: /bw tp <username>");
        yml.addDefault(Messages.REJOIN_NO_ARENA, "{prefix}&cYeniden katÃ„Â±labilmen iÃƒÂ§in bir harita bulunmuyor.");
        yml.addDefault(Messages.REJOIN_DENIED, "{prefix}&cYeniden katÃ„Â±lÃ„Â±mazsÃ„Â±n ÃƒÂ§ÃƒÂ¼nkÃƒÂ¼ yataklar kÃ„Â±rÃ„Â±lmÃ„Â±Ã…Å¸ ya da oyun bitmiÃ…Å¸.");
        yml.addDefault(Messages.REJOIN_ALLOWED, "{prefix}&a{arena}&e haritasÃ„Â±na yeniden katÃ„Â±lÃ„Â±yorsun!");
        yml.addDefault(Messages.COMMAND_REJOIN_PLAYER_RECONNECTED, "{prefix}&7{player} &eyeniden katÃ„Â±ldÃ„Â±!");
        yml.addDefault(Messages.COMMAND_LEAVE_DENIED_NOT_IN_ARENA, "{prefix}&cHaritada deÃ„Å¸ilsin!");
        yml.addDefault(Messages.COMMAND_LEAVE_MSG, "{prefix}&7{player} &eayrÃ„Â±ldÃ„Â±!");
        yml.addDefault(Messages.COMMAND_NOT_ALLOWED_IN_GAME, "{prefix}&cBu komutu oyun sÃ„Â±rasÃ„Â±nda kullanamazsÃ„Â±n!");
        yml.addDefault(Messages.COMMAND_NOT_FOUND_OR_INSUFF_PERMS, "{prefix}&cBu komut bulunamadÃ„Â± veya yetkin yok!");
        yml.addDefault(Messages.COMMAND_PARTY_HELP, Arrays.asList("&6Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&aParti KomutlarÃ„Â±:",
                "&e/party help &7- &bBu mesajÃ„Â± yazdÃ„Â±rÃ„Â±r",
                "&e/party invite <player> &7- &bOyuncuyu partine davet eder",
                "&e/party leave &7- &bPartiden ayrÃ„Â±lÃ„Â±r",
                "&e/party info &7- &bShow party members and owner",
                "&e/party promote <player> &7- &bTransfer party ownership",
                "&e/party remove <player> &7- &bOyuncuyu partiden kovar",
                "&e/party accept <player> &7- &bParti davetini kabul eder",
                "&e/party disband &7- &bPartiyi daÃ„Å¸Ã„Â±tÃ„Â±r")
        );
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_USAGE, "{prefix}&eKullanÃ„Â±m: &7/party invite <player>");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_PLAYER_OFFLINE, "{prefix}&7{player} &eoyunda deÃ„Å¸il!");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_SENT, "{prefix}&7{player}&6 adlÃ„Â± oyuncuya parti daveti gÃƒÂ¶nderildi.");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_SENT_TARGET_RECEIVE_MSG, "{prefix}&b{player} &eadlÃ„Â± oyuncu seni bir partiye davet etti! &o&7(Kabul Et)");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_CANNOT_INVITE_YOURSELF, "{prefix}&cKendini davet edemezsin!");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_PLAYER_OFFLINE, "{prefix}&7{player} &eadlÃ„Â± oyuncu ÃƒÂ§evrimdÃ„Â±Ã…Å¸Ã„Â±!");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_DENIED_NO_INVITE, "{prefix}&cKabul etmek iÃƒÂ§in bir davet bulunmuyor!");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_DENIED_ALREADY_IN_PARTY, "{prefix}&eZaten bir partidesin!");
        yml.addDefault(Messages.COMMAND_PARTY_INSUFFICIENT_PERMISSIONS, "{prefix}&cSadece parti lideri bu komutu kullanabilir.");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_USAGE, "{prefix}&eKullanÃ„Â±m: &7/party accept <player>");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_SUCCESS, "{prefix}&7{player} &eadlÃ„Â± oyuncu partiye katÃ„Â±ldÃ„Â±!");
        yml.addDefault(Messages.COMMAND_PARTY_GENERAL_DENIED_NOT_IN_PARTY, "{prefix}&cHerhangi bir partide deÃ„Å¸ilsin!");
        yml.addDefault(Messages.COMMAND_PARTY_LEAVE_DENIED_IS_OWNER_NEEDS_DISBAND, "{prefix}&cKendi partinden ayrÃ„Â±lamazsÃ„Â±n!\n&ePartiyi daÃ„Å¸Ã„Â±tmayÃ„Â± dene: &b/party disband");
        yml.addDefault(Messages.COMMAND_PARTY_LEAVE_SUCCESS, "{prefix}&7{player} &eadlÃ„Â± oyuncu partiden ayrÃ„Â±ldÃ„Â±!");
        yml.addDefault(Messages.COMMAND_PARTY_DISBAND_SUCCESS, "{prefix}&eParti daÃ„Å¸Ã„Â±tÃ„Â±ldÃ„Â±!");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_USAGE, "{prefix}&7KullanÃ„Â±m: &e/party remove <player>");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_SUCCESS, "{prefix}&7{player} &eadlÃ„Â± oyuncu partiden kovuldu!");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_DENIED_TARGET_NOT_PARTY_MEMBER, "{prefix}&7{player} &eadlÃ„Â± oyuncu parti ÃƒÂ¼yesi deÃ„Å¸il!");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_SUCCESS, "{prefix}&e{player}'i sahibi yaptÃ„Â±n!");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_OWNER, "{prefix}&eGrup sahibi sen oldun!");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_NEW_OWNER, "{prefix}&7 &e{player} artÃ„Â±k grup sahibi!");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_OWNER, "\n{prefix}&eGrup sahibi: &7{owner}");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_PLAYERS,"{prefix}&eGrup ÃƒÂ¼yeleri:");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_PLAYER, "&7{player}");
        yml.addDefault(Messages.COMMAND_FORCESTART_NOT_IN_GAME, "Ã‚Â§cÃ¢â€“Âª Ã‚Â§7Oyunda deÃ„Å¸ilsin!");
        yml.addDefault(Messages.COMMAND_FORCESTART_SUCCESS, "Ã‚Â§cÃ¢â€“Âª Ã‚Â§7Geris sayÃ„Â±m kÃ„Â±saltÃ„Â±ldÃ„Â±!");
        yml.addDefault(Messages.COMMAND_FORCESTART_NO_PERM, "{prefix}&7Bu iÃ…Å¸lemi uygulamak iÃƒÂ§in baÃ„Å¸Ã„Â±Ã…Å¸ÃƒÂ§Ã„Â± olman lazÃ„Â±m!");
        yml.addDefault(Messages.COMMAND_COOLDOWN, "&cÃ…Å¾u anda bunu yapamazsÃ„Â±n! {seconds} saniye sonra tekrar dene.");
        yml.addDefault(Messages.ARENA_JOIN_VIP_KICK, "{prefix}&cÃƒÅ“zgÃƒÂ¼nÃƒÂ¼m, bir baÃ„Å¸Ã„Â±Ã…Å¸ÃƒÂ§Ã„Â± haritaya katÃ„Â±lmaya ÃƒÂ§alÃ„Â±Ã…Å¸tÃ„Â±Ã„Å¸Ã„Â± iÃƒÂ§in haritadan atÃ„Â±ldÃ„Â±n!");
        yml.addDefault(Messages.ARENA_START_COUNTDOWN_STOPPED_INSUFF_PLAYERS_CHAT, "{prefix}Ã‚Â§cOyun baÃ…Å¸lamÃ„Â±yor! Ã‚Â§7Yeterli oyuncu yok!");
        yml.addDefault(Messages.ARENA_RESTART_PLAYER_KICK, "{prefix}&eBulunduÃ„Å¸un harita yeniden baÃ…Å¸latÃ„Â±lÃ„Â±yor");
        yml.addDefault(Messages.ARENA_STATUS_PLAYING_NAME, "&cOynanÃ„Â±yor");
        yml.addDefault(Messages.ARENA_STATUS_RESTARTING_NAME, "&4Yeniden BaÃ…Å¸latÃ„Â±lÃ„Â±yor");
        yml.addDefault(Messages.ARENA_STATUS_WAITING_NAME, "&2Bekleniyor Ã‚Â§c{full}");
        yml.addDefault(Messages.ARENA_STATUS_STARTING_NAME, "&6BaÃ…Å¸latÃ„Â±lÃ„Â±yor Ã‚Â§c{full}");
        yml.addDefault(Messages.ARENA_GUI_INV_NAME, "&8KatÃ„Â±lm");
        yml.addDefault(Messages.ARENA_GUI_ARENA_CONTENT_NAME, "&a&l{name}");
        yml.addDefault(Messages.ARENA_GUI_ARENA_CONTENT_LORE, Arrays.asList("", "&7Durum: {status}", "&7Oyuncular: &f{on}&7/&f{max}", "&7TÃƒÂ¼r: &a{group}", "", "&aKatÃ„Â±lmak iÃƒÂ§in sol tÃ„Â±kla.", "&eÃ„Â°zlemek iÃƒÂ§in saÃ„Å¸ tÃ„Â±kla."));
        yml.addDefault(Messages.ARENA_GUI_SKIPPED_ITEM_NAME, "&r{serverIp}");
        yml.addDefault(Messages.ARENA_GUI_SKIPPED_ITEM_LORE, Collections.emptyList());
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CHAT, "{prefix}&eOyun, &6{time} &esaniye iÃƒÂ§inde baÃ…Å¸lÃ„Â±yor!");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_TITLE, " ");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE, "&a{second}");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-5", "&eÃ¢ÂÂº");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-4", "&eÃ¢ÂÂ¹");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-3", "&cÃ¢ÂÂ¸");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-2", "&cÃ¢ÂÂ·");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-1", "&cÃ¢ÂÂ¶");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CANCELLED_TITLE, " ");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CANCELLED_SUB_TITLE, "&cDaha fazla oyuncu bekleniyor...");
        yml.addDefault(Messages.ARENA_STATUS_START_PLAYER_TITLE, "&aGO");
        yml.addDefault(Messages.ARENA_STATUS_START_PLAYER_TUTORIAL, Arrays.asList("&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&f                                   &l&cBed&r&lWars", "",
                "&e&l    YataÃ„Å¸Ã„Â±nÃ„Â± savun ve dÃƒÂ¼Ã…Å¸man yataklarÃ„Â±nÃ„Â± parÃƒÂ§ala!",
                "&e&l      ÃƒÅ“reticilerden Demir, AltÃ„Â±n, ZÃƒÂ¼mrÃƒÂ¼t ve Elmas",
                "&e&l   kazanarak yÃƒÂ¼kseltmelere eriÃ…Å¸im saÃ„Å¸la ve takÃ„Â±mÃ„Â±nÃ„Â±",
                "&e&l             gÃƒÂ¼ÃƒÂ§lendir. Bol Ã…Å¸ans!", "",
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        yml.addDefault(Messages.ARENA_JOIN_DENIED_SELECTOR, "{prefix}&cÃƒÅ“zgÃƒÂ¼nÃƒÂ¼m ama bu haritaya Ã…Å¸u anda katÃ„Â±lamazsÃ„Â±n. Seyirci olmak iÃƒÂ§in saÃ„Å¸ tÃ„Â±kla.");
        yml.addDefault(Messages.ARENA_SPECTATE_DENIED_SELECTOR, "{prefix}&cÃƒÅ“zgÃƒÂ¼nÃƒÂ¼m ama bu haritayÃ„Â± Ã…Å¸u anda seyredemezsin. KatÃ„Â±lmak iÃƒÂ§in sol tÃ„Â±kla.");
        yml.addDefault(Messages.ARENA_JOIN_DENIED_NO_PROXY, "&cÃƒÅ“zgÃƒÂ¼nÃƒÂ¼m ama BedWarsProxy kullanmalÃ„Â±sÃ„Â±n. \n&eEÃ„Å¸er haritayÃ„Â± dÃƒÂ¼zenlemek istiyorsan kendine bw.setup yetkisini vermeyi unutma!");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_NAME, "&8IÃ…Å¸Ã„Â±nlayÃ„Â±cÃ„Â±");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_HEAD_NAME, "{prefix}{player}");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_HEAD_LORE, Arrays.asList("&7Can: &f{health}%", "&7AÃƒÂ§lÃ„Â±k: &f{food}", "", "&7Seyretmek iÃƒÂ§in sol tÃ„Â±kla"));
        yml.addDefault(Messages.ARENA_SPECTATOR_LEAVE_ITEM_NAME, "&c&lLobiye dÃƒÂ¶n");
        yml.addDefault(Messages.ARENA_SPECTATOR_LEAVE_ITEM_LORE, Collections.singletonList("&7Lobiye dÃƒÂ¶nmek iÃƒÂ§in sol tÃ„Â±kla."));
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_ENTER_TITLE, "&7{player} &aseyrediliyor");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_ENTER_SUBTITLE, "&cAyrÃ„Â±lmak iÃƒÂ§in eÃ„Å¸ilme tuÃ…Å¸una bas.");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_LEAVE_TITLE, "&eSeyirci modundan ayrÃ„Â±lÃ„Â±nÃ„Â±yor...");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_LEAVE_SUBTITLE, "");
        yml.addDefault(Messages.ARENA_LEAVE_PARTY_DISBANDED, "{prefix}Ã‚Â§cParti sahibi oyundan ayrÃ„Â±ldÃ„Â± ve parti kapatÃ„Â±ldÃ„Â±.");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TIER, "&eSeviye &c{tier}");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TYPE_DIAMOND, "&b&lElmas");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TYPE_EMERALD, "&a&lZÃƒÂ¼mrÃƒÂ¼t");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TIMER, "&c{seconds} &esaniye sonra ÃƒÂ¼retiliyor");
        yml.addDefault(Messages.GENERATOR_UPGRADE_CHAT_ANNOUNCEMENT, "{prefix}{generatorType} ÃƒÅ“reticileri &eSeviye &c{tier} &eoldu!");
        yml.addDefault(Messages.FORMATTING_CHAT_LOBBY, "{level}{vPrefix}&7{player}{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_WAITING, "{level}{vPrefix}&7{player}{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_SHOUT, "{level}{vPrefix}&6[SHOUT] {team} &7{player}&f{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_TEAM, "{level}{vPrefix}&f{team}&7 {player}{vSuffix} {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_SPECTATOR, "{level}{vPrefix}&7[SPECTATOR] {player}{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_HEALTH, Arrays.asList("&cÃ¢ÂÂ¤", "&aCan"));

        yml.addDefault(Messages.FORMATTING_SCOREBOARD_DATE, "dd/MM/yyyy");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_GENERIC, "{TeamColor}{TeamLetter}&f {TeamName}: {TeamStatus}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_ELIMINATED, "&c&lÃ¢Å“Ëœ");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_BED_DESTROYED, "&a{remainingPlayers}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_ALIVE, "&a&lÃ¢Å“â€œ");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_NEXEVENT_TIMER, "mm:ss");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_YOUR_TEAM, "&7 SEN");
        yml.addDefault(Messages.FORMATTING_ACTION_BAR_TRACKING, "&fHedef: {team} &f- Mesafe: {distance}m");
        yml.addDefault(Messages.FORMATTING_TEAM_WINNER_FORMAT, "      {TeamColor}{TeamName} &7- {members}");
        yml.addDefault(Messages.FORMATTING_SOLO_WINNER_FORMAT, "                 {TeamColor}{TeamName} &7- {members}");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER1, "I");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER2, "II");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER3, "III");
        yml.addDefault(Messages.FORMATTING_DESPAWNABLE_UTILITY_NPC_HEALTH, "Ã¢â€“Â® ");
        yml.addDefault(Messages.FORMATTING_STATS_DATE_FORMAT, "dd/MM/yyyy HH:mm");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_TEAM, "{TeamColor}[{TeamName}]");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_SHOUT, "&6[HERKES]");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_SPECTATOR, "&7[SEYIRCI]");
        yml.addDefault(Messages.MEANING_FULL, "Tam");
        yml.addDefault(Messages.MEANING_SHOUT, "Herkes");
        yml.addDefault(Messages.MEANING_NOBODY, "Kimse");
        yml.addDefault(Messages.MEANING_NEVER, "Asla");
        yml.addDefault(Messages.MEANING_IRON_SINGULAR, "Demir");
        yml.addDefault(Messages.MEANING_IRON_PLURAL, "Demir");
        yml.addDefault(Messages.MEANING_GOLD_SINGULAR, "AltÃ„Â±n");
        yml.addDefault(Messages.MEANING_GOLD_PLURAL, "AltÃ„Â±n");
        yml.addDefault(Messages.MEANING_EMERALD_SINGULAR, "ZÃƒÂ¼mrÃƒÂ¼t");
        yml.addDefault(Messages.MEANING_EMERALD_PLURAL, "ZÃƒÂ¼mrÃƒÂ¼t");
        yml.addDefault(Messages.MEANING_DIAMOND_SINGULAR, "Elmas");
        yml.addDefault(Messages.MEANING_DIAMOND_PLURAL, "Elmas");
        yml.addDefault(Messages.MEANING_VAULT_SINGULAR, "Ã¢â€šÂº");
        yml.addDefault(Messages.MEANING_VAULT_PLURAL, "Ã¢â€šÂº");
        yml.addDefault(Messages.INTERACT_CANNOT_PLACE_BLOCK, "{prefix}&cBuraya blok koyamazsÃ„Â±n!");
        yml.addDefault(Messages.INTERACT_CANNOT_BREAK_BLOCK, "{prefix}&cSadece oyuncular tarafÃ„Â±ndan yerleÃ…Å¸tirilen bloklarÃ„Â± kÃ„Â±rabilirsin!");
        yml.addDefault(Messages.INTERACT_CANNOT_BREAK_OWN_BED, "&cKendi yataÃ„Å¸Ã„Â±nÃ„Â± kÃ„Â±ramazsÃ„Â±n!");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_CHAT_ANNOUNCEMENT, "\n&f&lYATAK KIRMA > {TeamColor}{TeamName} Yatak&7, {PlayerColor}{PlayerName}&7 tarafÃ„Â±ndan parÃƒÂ§alandÃ„Â±!\n");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_TITLE_ANNOUNCEMENT, "&cYATAK KIRILDI");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_SUBTITLE_ANNOUNCEMENT, "&fArtÃ„Â±k yeniden doÃ„Å¸amayacaksÃ„Â±n!");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_CHAT_ANNOUNCEMENT_TO_VICTIM, "&f&lBED DESTRUCTION > &7YataÃ„Å¸Ã„Â±n {PlayerColor}{PlayerName}&7 tarafÃ„Â±ndan yok edildi!");
        yml.addDefault(Messages.INTERACT_CHEST_CANT_OPEN_TEAM_ELIMINATED, "&cElenmemiÃ…Å¸ bir takÃ„Â±mÃ„Â±n sandÃ„Â±Ã„Å¸Ã„Â±nÃ„Â± aÃƒÂ§amazsÃ„Â±n!");
        yml.addDefault(Messages.INTERACT_INVISIBILITY_REMOVED_DAMGE_TAKEN, "&cYou are no longer invisible because you have taken damage!");
        yml.addDefault(Messages.PLAYER_DIE_VOID_FALL_REGULAR_KILL, "{PlayerColor}{PlayerName} &7boÃ…Å¸luÃ„Å¸a dÃƒÂ¼Ã…Å¸tÃƒÂ¼.");
        yml.addDefault(Messages.PLAYER_DIE_VOID_FALL_FINAL_KILL, "{PlayerColor}{PlayerName} &7boÃ…Å¸luÃ„Å¸a dÃƒÂ¼Ã…Å¸tÃƒÂ¼. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_IN_VOID_REGULAR_KILL, "{PlayerColor}{PlayerName} &7 adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan boÃ…Å¸luÃ„Å¸a atÃ„Â±ldÃ„Â±.");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_IN_VOID_FINAL_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan boÃ…Å¸luÃ„Å¸a atÃ„Â±ldÃ„Â±. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_PVP_LOG_OUT_REGULAR, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 ile savaÃ…Å¸Ã„Â±rken oyundan ayrÃ„Â±ldÃ„Â±.");
        yml.addDefault(Messages.PLAYER_DIE_PVP_LOG_OUT_FINAL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 ile savaÃ…Å¸Ã„Â±rken oyundan ayrÃ„Â±ldÃ„Â±. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_BY_REGULAR_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan uÃƒÂ§uruldu.");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_BY_FINAL_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan uÃƒÂ§uruldu. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITH_SOURCE_REGULAR_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan bombalandÃ„Â±.");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITH_SOURCE_FINAL_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan bombalandÃ„Â±. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITHOUT_SOURCE_REGULAR, "{PlayerColor}{PlayerName} &7bombalandÃ„Â±.");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITHOUT_SOURCE_FINAL_KILL, "{PlayerColor}{PlayerName} &7bombalandÃ„Â±. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_PVP_REGULAR_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan ÃƒÂ¶ldÃƒÂ¼rÃƒÂ¼ldÃƒÂ¼.");
        yml.addDefault(Messages.PLAYER_DIE_PVP_FINAL_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan ÃƒÂ¶ldÃƒÂ¼rÃƒÂ¼ldÃƒÂ¼. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_UNKNOWN_REASON_REGULAR, "{PlayerColor}{PlayerName} &7ÃƒÂ¶ldÃƒÂ¼.");
        yml.addDefault(Messages.PLAYER_DIE_UNKNOWN_REASON_FINAL_KILL, "{PlayerColor}{PlayerName} &7ÃƒÂ¶ldÃƒÂ¼. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_SHOOT_REGULAR, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan ok ile vuruldu.");
        yml.addDefault(Messages.PLAYER_DIE_SHOOT_FINAL_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerName}&7 tarafÃ„Â±ndan ok ile vuruldu. &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_DEBUG_REGULAR, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerTeamName} TakÃ„Â±m&7'Ã„Â±n Yatak BÃƒÂ¶ceÃ„Å¸i tarafÃ„Â±ndan katledildi!");
        yml.addDefault(Messages.PLAYER_DIE_DEBUG_FINAL_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerTeamName} TakÃ„Â±m&7'Ã„Â±n Yatak BÃƒÂ¶ceÃ„Å¸i tarafÃ„Â±ndan katledildi! &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_IRON_GOLEM_REGULAR, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerTeamName} TakÃ„Â±m&7'Ã„Â±n Demir Golemi tarafÃ„Â±ndan katledildi!");
        yml.addDefault(Messages.PLAYER_DIE_IRON_GOLEM_FINAL_KILL, "{PlayerColor}{PlayerName} &7adlÃ„Â± oyuncu {KillerColor}{KillerTeamName} TakÃ„Â±m&7'Ã„Â±n Demir Golemi tarafÃ„Â±ndan katledildi! &b&lFINAL KILL!");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_DIAMOND, "{prefix}&b+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_EMERALD, "{prefix}&a+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_IRON, "{prefix}&f+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_GOLD, "{prefix}&6+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_TITLE, "&cÃƒâ€“LDÃƒÅ“N!");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_SUBTITLE, "&c{time} &esaniye sonra yeniden doÃ„Å¸acaksÃ„Â±n!");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_CHAT, "{prefix}&e{time} &esaniye sonra yeniden doÃ„Å¸acaksÃ„Â±n!");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWNED_TITLE, "&aYENÃ„Â°DEN DOÃ„Å¾DUN!");
        yml.addDefault(Messages.PLAYER_DIE_ELIMINATED_CHAT, "{prefix}&cOyundan elendin!");
        yml.addDefault(Messages.PLAYER_HIT_BOW, "{prefix}{TeamColor}{PlayerName} &7 adlÃ„Â± oyuncu &c{amount} &7cana sahip!");
        yml.addDefault(Messages.GAME_END_GAME_OVER_PLAYER_TITLE, "&c&lOYUN BÃ„Â°TTÃ„Â°");
        yml.addDefault(Messages.GAME_END_VICTORY_PLAYER_TITLE, "&6&lGALÃ„Â°BÃ„Â°YET!");
        yml.addDefault(Messages.GAME_END_TEAM_WON_CHAT, "{prefix}{TeamColor}{TeamName} &aoyunu kazandÃ„Â±!");
        yml.addDefault(Messages.GAME_END_TOP_PLAYER_CHAT, Arrays.asList("&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&f                                   &l&cBed&r&lWars", "", "{winnerFormat}", "", "",
                "&6                      &6Ã¢Â­Â &l1. Oyuncu &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue} &7ÃƒÂ¶ldÃƒÂ¼rme",
                "&e                        &l2. Oyuncu &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue} &7ÃƒÂ¶ldÃƒÂ¼rme",
                "&c                        &l3. Oyuncu &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue} &7ÃƒÂ¶ldÃƒÂ¼rme", "",
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        yml.addDefault(Messages.BED_HOLOGRAM_DEFEND, "&c&lYataÃ„Å¸Ã„Â±nÃ„Â± savun!");
        yml.addDefault(Messages.BED_HOLOGRAM_DESTROYED, "&c&lYataÃ„Å¸Ã„Â±n kÃ„Â±rÃ„Â±ldÃ„Â±!");
        yml.addDefault(Messages.NPC_NAME_TEAM_UPGRADES, "&bTAKIM YÃƒÅ“KSELTMELERÃ„Â°,&e&lSAÃ„Å¾ TIKLA");
        yml.addDefault(Messages.NPC_NAME_SOLO_UPGRADES, "&bOYUNCU YÃƒÅ“KSELTMELERÃ„Â°,&e&lSAÃ„Å¾ TIKLA");
        yml.addDefault(Messages.NPC_NAME_TEAM_SHOP, "&bTAKIM MARKETÃ„Â°,&e&lSAÃ„Å¾ TIKLA");
        yml.addDefault(Messages.NPC_NAME_SOLO_SHOP, "&bEÃ…Å¾YA MARKETÃ„Â°,&e&lSAÃ„Å¾ TIKLA");
        yml.addDefault(Messages.TEAM_ELIMINATED_CHAT, "\n&f&lTAKIM ELENDÃ„Â° > {TeamColor}{TeamName} TakÃ„Â±m &celendi!\n");
        yml.addDefault(Messages.NEXT_EVENT_BEDS_DESTROY, "&cYatak KÃ„Â±rma");
        yml.addDefault(Messages.NEXT_EVENT_DIAMOND_UPGRADE_II, "&fElmas II");
        yml.addDefault(Messages.NEXT_EVENT_DIAMOND_UPGRADE_III, "&fElmas III");
        yml.addDefault(Messages.NEXT_EVENT_DRAGON_SPAWN, "&fEjderha SaldÃ„Â±rÃ„Â±sÃ„Â±");
        yml.addDefault(Messages.NEXT_EVENT_EMERALD_UPGRADE_II, "&fZÃƒÂ¼mrÃƒÂ¼t II");
        yml.addDefault(Messages.NEXT_EVENT_EMERALD_UPGRADE_III, "&fZÃƒÂ¼mrÃƒÂ¼t III");
        yml.addDefault(Messages.NEXT_EVENT_GAME_END, "&4Oyun Sonu");
        yml.addDefault(Messages.NEXT_EVENT_TITLE_ANNOUNCE_BEDS_DESTROYED, "&cYATAK KIRMA!");
        yml.addDefault(Messages.NEXT_EVENT_SUBTITLE_ANNOUNCE_BEDS_DESTROYED, "&fTÃƒÂ¼m yataklar parÃƒÂ§alandÃ„Â±!");
        yml.addDefault(Messages.NEXT_EVENT_CHAT_ANNOUNCE_BEDS_DESTROYED, "&c&lTÃƒÂ¼m yataklar parÃƒÂ§alandÃ„Â±!");
        yml.addDefault(Messages.NEXT_EVENT_TITLE_ANNOUNCE_SUDDEN_DEATH, "&cEjderha SaldÃ„Â±rÃ„Â±sÃ„Â±");
        yml.addDefault(Messages.NEXT_EVENT_SUBTITLE_ANNOUNCE_SUDDEN_DEATH, "");
        yml.addDefault(Messages.NEXT_EVENT_CHAT_ANNOUNCE_SUDDEN_DEATH, "&cEJDERHA SALDIRISI: &6&b{TeamDragons} {TeamColor}{TeamName} Ejderha!");
        yml.addDefault(Messages.XP_REWARD_PER_MINUTE, "{prefix}&6+{xp} BukkitBedPlugin puanÃ„Â± kazanÃ„Â±ldÃ„Â± (Oynama SÃƒÂ¼resi)");
        yml.addDefault(Messages.XP_REWARD_WIN, "{prefix}&6+{xp} BBedWars puanÃ„Â± kazanÃ„Â±ldÃ„Â± (Galibiyet)");
        yml.addDefault(Messages.XP_REWARD_PER_TEAMMATE, "{prefix}&6+{xp} BukkitBedPlugin puanÃ„Â± kazanÃ„Â±ldÃ„Â± (TakÃ„Â±m YardÃ„Â±mÃ„Â±)");
        yml.addDefault(Messages.XP_REWARD_BED_DESTROY, "{prefix}&6+{xp} BukkitBedPlugin puanÃ„Â± kazanÃ„Â±ldÃ„Â± (Yatak KÃ„Â±rma)");
        yml.addDefault(Messages.XP_REWARD_REGULAR_KILL, "{prefix}&6+{xp} BukkitBedPlugin puanÃ„Â± kazanÃ„Â±ldÃ„Â± (Ãƒâ€“ldÃƒÂ¼rme)");
        yml.addDefault(Messages.XP_REWARD_FINAL_KILL, "{prefix}&6+{xp} BukkitBedPlugin puanÃ„Â± kazanÃ„Â±ldÃ„Â± (Final Kill)");

        yml.addDefault(Messages.MONEY_REWARD_PER_MINUTE, "{prefix}&6+{money} Para (Oynama SÃƒÂ¼resi)");
        yml.addDefault(Messages.MONEY_REWARD_WIN, "{prefix}&6+{money} Para (Galibiyet)");
        yml.addDefault(Messages.MONEY_REWARD_PER_TEAMMATE, "{prefix}&6+{money} Para (TakÃ„Â±m YardÃ„Â±mÃ„Â±)");
        yml.addDefault(Messages.MONEY_REWARD_BED_DESTROYED, "{prefix}&6+{money} Para (Yatak KÃ„Â±rma)");
        yml.addDefault(Messages.MONEY_REWARD_FINAL_KILL, "{prefix}&6+{money} Para (Final Kill)");
        yml.addDefault(Messages.MONEY_REWARD_REGULAR_KILL, "{prefix}&6+{money} Para (Ãƒâ€“ldÃƒÂ¼rme)");

        /* Lobby Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "stats"), "&eÃ„Â°statistikler");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "stats"), Collections.singletonList("&fÃ„Â°statistiklerini gÃƒÂ¶rmek iÃƒÂ§in saÃ„Å¸ tÃ„Â±kla!"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "arena-selector"), "&eHarita SeÃƒÂ§ici");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "arena-selector"), Collections.singletonList("&fHarita seÃƒÂ§mek iÃƒÂ§in saÃ„Å¸ tÃ„Â±kla!"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "leave"), "&eLobiye DÃƒÂ¶n");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fBedWars'tan ayrÃ„Â±lmak iÃƒÂ§in saÃ„Å¸ tÃ„Â±kla!"));
        /* Pre Game Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_NAME.replace("%path%", "stats"), "&eÃ„Â°statistikler");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_LORE.replace("%path%", "stats"), Collections.singletonList("&fÃ„Â°statistiklerini gÃƒÂ¶rmek iÃƒÂ§in saÃ„Å¸ tÃ„Â±kla!"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_NAME.replace("%path%", "leave"), "&eLobiye DÃƒÂ¶n");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&Lobiye dÃƒÂ¶nmek iÃƒÂ§in saÃ„Å¸ tÃ„Â±kla!"));
        /* Spectator Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_NAME.replace("%path%", "teleporter"), "&eIÃ…Å¸Ã„Â±nlayÃ„Â±cÃ„Â±");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_NAME.replace("%path%", "leave"), "&eLobiye DÃƒÂ¶n");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fHaritadan ayrÃ„Â±lmak iÃƒÂ§in saÃ„Å¸ tÃ„Â±kla!"));

        /* save default items messages for stats gui */
        yml.addDefault(Messages.PLAYER_STATS_GUI_INV_NAME, "&8{player} Ã„Â°statistikleri");
        addDefaultStatsMsg(yml, "wins", "&6Galibiyet", "&f{wins}");
        addDefaultStatsMsg(yml, "losses", "&6Malubiyet", "&f{losses}");
        addDefaultStatsMsg(yml, "kills", "&6Ãƒâ€“ldÃƒÂ¼rme", "&f{kills}");
        addDefaultStatsMsg(yml, "deaths", "&6Ãƒâ€“lÃƒÂ¼m", "&f{deaths}");
        addDefaultStatsMsg(yml, "final-kills", "&6Final Ãƒâ€“ldÃƒÂ¼rme", "&f{finalKills}");
        addDefaultStatsMsg(yml, "final-deaths", "&6Final Ãƒâ€“lÃƒÂ¼m", "&f{finalDeaths}");
        addDefaultStatsMsg(yml, "beds-destroyed", "&6Yatak KÃ„Â±rma", "&f{bedsDestroyed}");
        addDefaultStatsMsg(yml, "first-play", "&6Ã„Â°lk Oyun", "&f{firstPlay}");
        addDefaultStatsMsg(yml, "last-play", "&6Son Oyun", "&f{lastPlay}");
        addDefaultStatsMsg(yml, "games-played", "&6Oynanan Oyun", "&f{gamesPlayed}");

        // Start of Sidebar
        yml.addDefault(Messages.SCOREBOARD_LOBBY, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&fSeviyen: {level}",
                "",
                "&fÃ„Â°lerleme: &a{currentXp}&7/&b{requiredXp}",
                "{progress}",
                "",
                "&7{player}",
                "",
                "&fPara: &a{money}",
                "",
                "&fGalibiyet: &a{wins}",
                "&fToplam Ãƒâ€“ldÃƒÂ¼rme: &a{kills}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_WAITING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "",
                "&fHarita: &a{map}",
                "",
                "&fOyuncular: &a{on}/{max}",
                "",
                "&fBekleniyor,&fBekleniyor.,&fBekleniyor..,&fBekleniyor...",
                "",
                "&fTÃƒÂ¼r: &a{group}",
                "&fSÃƒÂ¼rÃƒÂ¼m: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_WAITING_SPEC, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "&o&7Spectating",
                "&fHarita: &a{map}",
                "",
                "&fOyuncular: &a{on}/{max}",
                "",
                "&fBekleniyor,&fBekleniyor.,&fBekleniyor..,&fBekleniyor...",
                "",
                "&fTÃƒÂ¼r: &a{group}",
                "&fSÃƒÂ¼rÃƒÂ¼m: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_STARTING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "",
                "&fHarita: &a{map}",
                "",
                "&fOyuncular: &a{on}/{max}",
                "",
                "&f&a{time}s sonra baÃ…Å¸latÃ„Â±lÃ„Â±yor",
                "",
                "&fTÃƒÂ¼r: &a{group}",
                "&fSÃƒÂ¼rÃƒÂ¼m: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_STARTING_SPEC, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "&o&7Spectating",
                "&fHarita: &a{map}",
                "",
                "&fOyuncular: &a{on}/{max}",
                "",
                "&f&a{time}s sonra baÃ…Å¸latÃ„Â±lÃ„Â±yor",
                "",
                "&fTÃƒÂ¼r: &a{group}",
                "&fSÃƒÂ¼rÃƒÂ¼m: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&a{time} sonra &f{nextEvent}",
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
                "&a{time} sonra &f{nextEvent}",
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
                "&a{time} sonra &f{nextEvent}",
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
                "&a{time} sonra &f{nextEvent}",
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
                "&a{time} sonra &f{nextEvent}",
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
                "&a{time} sonra &f{nextEvent}",
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
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&a{time} sonra &f{nextEvent}",
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
                "&fÃƒâ€“ldÃƒÂ¼rme: &a{kills}",
                "&fFinal Ãƒâ€“ldÃƒÂ¼rme: &a{finalKills}",
                "&fYatak KÃ„Â±rma: &a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC.replaceFirst("Default", "3v3v3v3"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&a{time} sonra &f{nextEvent}",
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
                "&fÃƒâ€“ldÃƒÂ¼rme: &a{kills}",
                "&fFinal Ãƒâ€“ldÃƒÂ¼rme: &a{finalKills}",
                "&fYatak KÃ„Â±rma: &a{beds}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC_ELIMINATED.replaceFirst("Default", "3v3v3v3"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&a{time} sonra &f{nextEvent}",
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

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING.replaceFirst("Default", "4v4v4v4"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&a{time} sonra &f{nextEvent}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&fÃƒâ€“ldÃƒÂ¼rme: &a{kills}",
                "&fFinal Ãƒâ€“ldÃƒÂ¼rme: &a{finalKills}",
                "&fYatak KÃ„Â±rma: &a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC.replaceFirst("Default", "4v4v4v4"), Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "&o&7Spectating {spectatorTarget}",
                "&a{time} sonra &f{nextEvent}",
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
                "&a{time} sonra &f{nextEvent}",
                "",
                "{team}",
                "{team}",
                "{team}",
                "{team}",
                "",
                "&fÃƒâ€“ldÃƒÂ¼rme: &a{kills}",
                "&fFinal Ãƒâ€“ldÃƒÂ¼rme: &a{finalKills}",
                "&fYatak KÃ„Â±rma: &a{beds}",
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

        //
        yml.addDefault(Messages.SHOP_INDEX_NAME, "&8HÃ„Â±zlÃ„Â± AlÃ„Â±m");
        yml.addDefault(Messages.SHOP_QUICK_ADD_NAME, "&8HÃ„Â±zlÃ„Â± AlÃ„Â±ma ekleniyor...");
        yml.addDefault(Messages.SHOP_INSUFFICIENT_MONEY, "{prefix}&cYeteri kadar {currency} sahibi deÃ„Å¸ilsin! {amount} tane daha bulmalÃ„Â±sÃ„Â±n!");
        yml.addDefault(Messages.SHOP_NEW_PURCHASE, "{prefix}&6{item} &asatÃ„Â±n aldÃ„Â±n");
        yml.addDefault(Messages.SHOP_ALREADY_BOUGHT, "{prefix}&cBunu zaten satÃ„Â±n aldÃ„Â±n!");
        yml.addDefault(Messages.SHOP_UTILITY_NPC_SILVERFISH_NAME, "{TeamColor}&l{TeamName} &r{TeamColor}BÃƒÂ¶cek");
        yml.addDefault(Messages.SHOP_UTILITY_NPC_IRON_GOLEM_NAME, "{TeamColor}{despawn}s &8[ {TeamColor}{health}&8]");
        yml.addDefault(Messages.SHOP_SEPARATOR_NAME, "&8Ã¢â€¡Â§ Kategoriler");
        yml.addDefault(Messages.SHOP_SEPARATOR_LORE, Collections.singletonList("&8Ã¢â€¡Â© EÃ…Å¸yalar"));
        yml.addDefault(Messages.SHOP_QUICK_BUY_NAME, "&bHÃ„Â±zlÃ„Â± AlÃ„Â±m");
        yml.addDefault(Messages.SHOP_QUICK_BUY_LORE, new ArrayList<>());
        yml.addDefault(Messages.SHOP_QUICK_EMPTY_NAME, "&cBoÃ…Å¸ slot!");
        yml.addDefault(Messages.SHOP_QUICK_EMPTY_LORE, Arrays.asList("&7Bu bir HÃ„Â±zlÃ„Â± AlÃ„Â±m slotu!", "&7Buraya eÃ…Å¸ya eklemek iÃƒÂ§in marketteki", "&7bir eÃ…Å¸yaya eÃ„Å¸ilme tuÃ…Å¸u ile tÃ„Â±kla!"));
        yml.addDefault(Messages.SHOP_CAN_BUY_COLOR, "&a");
        yml.addDefault(Messages.SHOP_CANT_BUY_COLOR, "&c");
        yml.addDefault(Messages.SHOP_LORE_STATUS_CAN_BUY, "&eSatÃ„Â±n almak iÃƒÂ§in tÃ„Â±kla!");
        yml.addDefault(Messages.SHOP_LORE_STATUS_CANT_AFFORD, "&cYeteri kadar {currency} sahibi deÃ„Å¸ilsin!");
        yml.addDefault(Messages.SHOP_LORE_STATUS_MAXED, "&aEN YÃƒÅ“KSEK SEVÃ„Â°YEDE!");
        yml.addDefault(Messages.SHOP_LORE_QUICK_ADD, "&bHÃ„Â±zlÃ„Â± AlÃ„Â±ma eklemek iÃƒÂ§in eÃ„Å¸ilerek tÃ„Â±kla");
        yml.addDefault(Messages.SHOP_LORE_QUICK_REMOVE, "&bHÃ„Â±zlÃ„Â± AlÃ„Â±mdan kaldÃ„Â±rmak iÃƒÂ§in eÃ„Å¸ilerek tÃ„Â±kla");


        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "&8Bloklar", "&aBloklar", Collections.singletonList("&eGÃƒÂ¶rmek iÃƒÂ§in tÃ„Â±kla!"));

        addContentMessages(yml, "wool", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}YÃƒÂ¼n", Arrays.asList("&7ÃƒÅ“cret: &f{cost} {currency}", "", "&7DÃƒÂ¼Ã…Å¸man adalara yol yapmak", "&7iÃƒÂ§in ideal. TakÃ„Â±mÃ„Â±nÃ„Â±n",
                "&7rengine bÃƒÂ¼rÃƒÂ¼nÃƒÂ¼r.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "clay", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Kil", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7YataÃ„Å¸Ã„Â±nÃ„Â± savunmak iÃƒÂ§in harika.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "glass", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Cam", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7PatlamalarÃ„Â± etkisiz kÃ„Â±lar.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "stone", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}End TaÃ…Å¸Ã„Â±", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7Sert bir savunma.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "ladder", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Merdiven", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7AÃ„Å¸aÃƒÂ§larda mahsur kalan", "&7kedileri kurtarmak iÃƒÂ§in sÃƒÂ¼per", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "obsidian", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Obsidyen", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7Rakiplerin senden nefret edecek!", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "wood", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Tahta", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7Yatak savunmasÃ„Â± iÃƒÂ§in ucuz bir ÃƒÂ§ÃƒÂ¶zÃƒÂ¼m.", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_MELEE, "&8YakÃ„Â±n SaldÃ„Â±rÃ„Â±", "&aYakÃ„Â±n SaldÃ„Â±rÃ„Â±", Collections.singletonList("&eGÃƒÂ¶rmek iÃƒÂ§in tÃ„Â±kla!"));

        addContentMessages(yml, "stone-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}TaÃ…Å¸ KÃ„Â±lÃ„Â±ÃƒÂ§", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "iron-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Demir KÃ„Â±lÃ„Â±ÃƒÂ§", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "diamond-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Elmas KÃ„Â±lÃ„Â±ÃƒÂ§", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "stick", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Ãƒâ€¡ubuk (Savurma I)", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "&8ZÃ„Â±rh", "&8ZÃ„Â±rh", Collections.singletonList("&eGÃƒÂ¶rmek iÃƒÂ§in tÃ„Â±kla!"));

        addContentMessages(yml, "chainmail", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Zincir ZÃ„Â±rh", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}",
                "", "&7Ãƒâ€“lÃƒÂ¼nce kaybolmayan", "&7zincir pantolon ve ayakkabÃ„Â±", "", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "iron-armor", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Demir ZÃ„Â±rh", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}",
                "", "&7Ãƒâ€“lÃƒÂ¼nce kaybolmayan", "&7demir pantolon ve ayakkabÃ„Â±", "", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "diamond-armor", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Elmas ZÃ„Â±rh", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}",
                "", "&7Ãƒâ€“lÃƒÂ¼nce kaybolmayan", "&7elmas pantolon ve ayakkabÃ„Â±", "", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "&8Alet", "&8Alet", Collections.singletonList("&eGÃƒÂ¶rmek iÃƒÂ§in tÃ„Â±kla!"));

        addContentMessages(yml, "shears", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Makas", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}",
                "", "&7Ãƒâ€“lÃƒÂ¼nce kaybolmayan bir makas. YÃƒÂ¼nlerden", "&7kurtulmak iÃƒÂ§in dÃƒÂ¶rt dÃƒÂ¶rtlÃƒÂ¼k.", "", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "pickaxe", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Kazma {tier}", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "&7Seviye: &e{tier}",
                "", "&7Bu bir yÃƒÂ¼kseltilebilir eÃ…Å¸ya.", "&7Her ÃƒÂ¶ldÃƒÂ¼Ã„Å¸ÃƒÂ¼nde", "1 seviye dÃƒÂ¼Ã…Å¸er", "", "&7Bu eÃ…Å¸ya, ÃƒÂ¶lsen bile", "&7en dÃƒÂ¼Ã…Å¸ÃƒÂ¼k seviyesi ile", "&7ÃƒÂ¼stÃƒÂ¼nde kalÃ„Â±r.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "axe", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Balta {tier}", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "&7Seviye: &e{tier}",
                "", "&7Bu bir yÃƒÂ¼kseltilebilir eÃ…Å¸ya.", "&7Her ÃƒÂ¶ldÃƒÂ¼Ã„Å¸ÃƒÂ¼nde", "1 seviye dÃƒÂ¼Ã…Å¸er", "", "&7Bu eÃ…Å¸ya, ÃƒÂ¶lsen bile", "&7en dÃƒÂ¼Ã…Å¸ÃƒÂ¼k seviyesi ile", "&7ÃƒÂ¼stÃƒÂ¼nde kalÃ„Â±r.", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_RANGED, "&8Uzun Mesafe", "&aUzun Mesafe", Collections.singletonList("&eGÃƒÂ¶rmek iÃƒÂ§in tÃ„Â±kla!"));

        addContentMessages(yml, "arrow", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Ok", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow1", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Yay", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow2", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Yay (GÃƒÂ¼ÃƒÂ§ I)", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow3", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Yay (GÃƒÂ¼ÃƒÂ§ I, Yumruk I)", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "&8Ã„Â°ksirler", "&8Ã„Â°ksirler", Collections.singletonList("&eGÃƒÂ¶rmek iÃƒÂ§in tÃ„Â±kla!"));

        addContentMessages(yml, "speed-potion", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}HÃ„Â±z II Ã„Â°ksiri (45 saniye)", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "jump-potion", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}ZÃ„Â±plama DesteÃ„Å¸i V Ã„Â°ksiri (45 saniye)", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "invisibility", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}GÃƒÂ¶rÃƒÂ¼nmezlik Ã„Â°ksiri (30 saniye)", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "&8DiÃ„Å¸er", "&8DiÃ„Å¸er", Collections.singletonList("&eGÃƒÂ¶rmek iÃƒÂ§in tÃ„Â±kla!"));

        addContentMessages(yml, "golden-apple", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}AltÃ„Â±n Elma", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7Well-rounded healing.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bedbug", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}BedBug", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7Kartopunu attÃ„Â±Ã„Å¸Ã„Â±n yerde",
                "&7rakiplerin dikkatini daÃ„Å¸Ã„Â±tmak iÃƒÂ§in", "&7bÃƒÂ¶cekler doÃ„Å¸urur. 15 saniye sonra kaybolur.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "dream-defender", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Demir Golem", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7TakÃ„Â±mÃ„Â±nÃ„Â± savunmana yardÃ„Â±m",
                "&7eder. 4 dakika sonra kaybolur.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "fireball", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}AteÃ…Å¸ Topu", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7SaÃ„Å¸ tÃ„Â±klayarak ateÃ…Å¸le! Rakiplerinin",
                "&7yÃƒÂ¼rÃƒÂ¼dÃƒÂ¼kleri kÃƒÂ¶prÃƒÂ¼leri patlatmak", "&7iÃƒÂ§in harika bir ÃƒÂ¼rÃƒÂ¼n!", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "tnt", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}TNT", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7Direkt ateÃ…Å¸lenir, diÃ„Å¸er takÃ„Â±mlarÃ„Â±n",
                "&7korumalarÃ„Â± iÃƒÂ§in iyi bir ÃƒÂ§ÃƒÂ¶zÃƒÂ¼m", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "ender-pearl", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ender Ã„Â°ncisi", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7DiÃ„Å¸er takÃ„Â±mlarÃ„Â±n adalarÃ„Â±na",
                "&7gitmenin en hÃ„Â±zlÃ„Â± yolu.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "water-bucket", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Su KovasÃ„Â±", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7PatlamalarÃ„Â± etkisiz",
                "&7bÃ„Â±rakÃ„Â±r.", "", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bridge-egg", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}KÃƒÂ¶prÃƒÂ¼ YumurtasÃ„Â±", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7AtÃ„Â±lan doÃ„Å¸rultuda",
                "&7bir kÃƒÂ¶prÃƒÂ¼ yapar.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "magic-milk", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Sihirli SÃƒÂ¼t", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7Ã„Â°ÃƒÂ§ildikten sonra 60 saniye",
                "&7boyunca dÃƒÂ¼Ã…Å¸man tuzaklarÃ„Â±ndan korur.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "sponge", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}SÃƒÂ¼nger", Arrays.asList("&7ÃƒÅ“cret: {cost} {currency}", "", "&7Suyu yok etmenin basit bir yolu.",
                "", "{quick_buy}", "{buy_status}"));

        //
        yml.addDefault(Messages.MEANING_NO_TRAP, "Tuzak yok!");
        yml.addDefault(Messages.FORMAT_SPECTATOR_TARGET, "{targetTeamColor}{targetDisplayName}");
        yml.addDefault(Messages.FORMAT_UPGRADE_TRAP_COST, "&7ÃƒÅ“cret: {currencyColor}{cost} {currency}");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_CAN_AFFORD, "&e");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_CANT_AFFORD, "&c");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_UNLOCKED, "&a");
        yml.addDefault(Messages.FORMAT_UPGRADE_TIER_LOCKED, "&7");
        yml.addDefault(Messages.FORMAT_UPGRADE_TIER_UNLOCKED, "&a");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_CLICK_TO_BUY, "{color}SatÃ„Â±n almak iÃƒÂ§in tÃ„Â±kla!");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_INSUFFICIENT_MONEY, "{color}Yeteri kadar {currency} yok!");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_LOCKED, "&cKÃ„Â°LÃ„Â°TLENDÃ„Â°");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_UNLOCKED, "{color}KÃ„Â°LÃ„Â°T KALDIRILDI");
        yml.addDefault(Messages.UPGRADES_UPGRADE_BOUGHT_CHAT, "&a{player} adlÃ„Â± oyuncu &6{upgradeName} satÃ„Â±n aldÃ„Â±");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-1"), "{color}Demir OcaÃ„Å¸Ã„Â±");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "forge"),
                Arrays.asList("&7Adanda ÃƒÂ¼retilen kaynak", "&7sayÃ„Â±sÃ„Â±nÃ„Â± arttÃ„Â±rÃ„Â±r.", "", "{tier_1_color}Seviye 1: +50% Kaynak ArtÃ„Â±Ã…Å¸Ã„Â±, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}Seviye 2: +100% Kaynak ArtÃ„Â±Ã…Å¸Ã„Â±, &b{tier_2_cost} {tier_2_currency}",
                        "{tier_3_color}Seviye 3: ZÃƒÂ¼mrÃƒÂ¼t ÃƒÂ¼retir, &b{tier_3_cost} {tier_3_currency}",
                        "{tier_4_color}Seviye 4: +200% Kaynak ArtÃ„Â±Ã…Å¸Ã„Â±, &b{tier_4_cost} {tier_4_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-2"), "{color}AltÃ„Â±n OcaÃ„Å¸Ã„Â±");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-3"), "{color}ZÃƒÂ¼mrÃƒÂ¼t OcaÃ„Å¸Ã„Â±");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-4"), "{color}Mistik Ocak");
        yml.addDefault(Messages.UPGRADES_CATEGORY_ITEM_NAME_PATH + "traps", "&eTÃ„Â±zak satÃ„Â±n al");
        yml.addDefault(Messages.UPGRADES_CATEGORY_ITEM_LORE_PATH + "traps", Arrays.asList("&7AlÃ„Â±nan tuzaklar", "&7saÃ„Å¸da sÃ„Â±ralanacak.", "", "&eGÃƒÂ¶z atmak iÃƒÂ§in tÃ„Â±kla!"));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "swords").replace("{tier}", "tier-1"), "{color}Keskin KÃ„Â±lÃ„Â±ÃƒÂ§lar");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "swords"),
                Arrays.asList("&7TakÃ„Â±mÃ„Â±nÃ„Â±n kÃ„Â±lÃ„Â±ÃƒÂ§ ve", "&7baltalarÃ„Â±nda kalÃ„Â±cÃ„Â± olarak", "&7Keskinlik I olacak!", "", "{tier_1_color}ÃƒÅ“cret: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-1"), "{color}KorumalÃ„Â± ZÃ„Â±rh I");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "armor"),
                Arrays.asList("&7TakÃ„Â±mÃ„Â±nÃ„Â±n zÃ„Â±rhlarÃ„Â±nda kalÃ„Â±cÃ„Â±", "&7koruma olur!", "", "{tier_1_color}Seviye 1: Koruma I, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}Seviye 2: Koruma II, &b{tier_2_cost} {tier_2_currency}",
                        "{tier_3_color}Seviye 3: Koruma III, &b{tier_3_cost} {tier_3_currency}",
                        "{tier_4_color}Seviye 4: Koruma IV, &b{tier_4_cost} {tier_4_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-2"), "{color}KorumalÃ„Â± ZÃ„Â±rh II");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-3"), "{color}KorumalÃ„Â± ZÃ„Â±rh III");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-4"), "{color}KorumalÃ„Â± ZÃ„Â±rh IV");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "miner").replace("{tier}", "tier-1"), "{color}Manyak Madenci I");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "miner"),
                Arrays.asList("&7TakÃ„Â±mÃ„Â±ndaki oyuncular, kalÃ„Â±cÃ„Â±", "&7Acele efektine sahip olurlar.", "", "{tier_1_color}Seviye 1: Acele I, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}Seviye 2: Acele II, &b{tier_2_cost} {tier_2_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "miner").replace("{tier}", "tier-2"), "{color}Manyak Madenci II");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "miner"),
                Arrays.asList("&7TakÃ„Â±mÃ„Â±ndaki oyuncular, kalÃ„Â±cÃ„Â±", "&7Acele efektine sahip olurlar.", "", "{tier_1_color}Seviye 1: Acele I, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}Seviye 2: Acele II, &b{tier_2_cost} {tier_2_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "heal-pool").replace("{tier}", "tier-1"), "{color}Can Havuzu");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "heal-pool"),
                Arrays.asList("&7Adanda durduÃ„Å¸un sÃƒÂ¼rece", "&7canÃ„Â±n yenilenir!", "", "{tier_1_color}ÃƒÅ“cret: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "dragon").replace("{tier}", "tier-1"), "{color}Dragon Buff");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "dragon"),
                Arrays.asList("&7Ejderha SaldÃ„Â±rÃ„Â±sÃ„Â± sÃ„Â±rasÃ„Â±nda", "&7takÃ„Â±mÃ„Â±n 2 Ejderhaya sahip olur", "", "{tier_1_color}ÃƒÅ“cret: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + "glass", "&8Ã¢Â¬â€ &7SatÃ„Â±n AlÃ„Â±nabilir");
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + "glass", Collections.singletonList("&8Ã¢Â¬â€¡&7Tuzak Listesi"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "first", "{color}Tuzak #1: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "first", Arrays.asList("&7Adana giren ilk", "&7kiÃ…Å¸i bu tuzaÃ„Å¸Ã„Â±", "&7aktifleÃ…Å¸tirir!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "first",
                Arrays.asList("", "&7Bu tuzaÃ„Å¸Ã„Â± satÃ„Â±n almak,", "&7tuzaÃ„Å¸Ã„Â± sÃ„Â±raya ekler. Fiyat,", "&7adandaki tuzak sayÃ„Â±sÃ„Â±na", "&7gÃƒÂ¶re belirlenir.", "", "&7SÃ„Â±radaki tuzak: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "second", "{color}Tuzak #2: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "second", Arrays.asList("&7Adana giren ikinci", "&7kiÃ…Å¸i bu tuzaÃ„Å¸Ã„Â±", "&7aktifleÃ…Å¸tirir!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "second",
                Arrays.asList("", "&7Bu tuzaÃ„Å¸Ã„Â± satÃ„Â±n almak,", "&7tuzaÃ„Å¸Ã„Â± sÃ„Â±raya ekler. Fiyat,", "&7adandaki tuzak sayÃ„Â±sÃ„Â±na", "&7gÃƒÂ¶re belirlenir.", "", "&7SÃ„Â±radaki tuzak: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "third", "{color}Tuzak #3: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "third", Arrays.asList("&7Adana giren ÃƒÂ¼ÃƒÂ§ÃƒÂ¼ncÃƒÂ¼", "&7kiÃ…Å¸i bu tuzaÃ„Å¸Ã„Â±", "&7aktifleÃ…Å¸tirir!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "third",
                Arrays.asList("", "&7Bu tuzaÃ„Å¸Ã„Â± satÃ„Â±n almak,", "&7tuzaÃ„Å¸Ã„Â± sÃ„Â±raya ekler. Fiyat,", "&7adandaki tuzak sayÃ„Â±sÃ„Â±na", "&7gÃƒÂ¶re belirlenir.", "", "&7SÃ„Â±radaki tuzak: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "1", "{color}Bu bir tuzak!");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "1", Arrays.asList("&75 saniye boyunca KÃƒÂ¶rlÃƒÂ¼k ve", "&7YavaÃ…Å¸lÃ„Â±k verir.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "2", "{color}KarÃ…Å¸Ã„Â± SaldÃ„Â±rÃ„Â± TuzaÃ„Å¸Ã„Â±");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "2", Arrays.asList("&7TetiklendiÃ„Å¸inde, adandaki takÃ„Â±m arkadaÃ…Å¸larÃ„Â±na", "&7HÃ„Â±z efekti verir.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "3", "{color}Alaram TuzaÃ„Å¸Ã„Â±");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "3", Arrays.asList("&7GÃƒÂ¶rÃƒÂ¼nmez oyuncularÃ„Â±", "&7gÃƒÂ¶rÃƒÂ¼nÃƒÂ¼r kÃ„Â±lar.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "4", "{color}Madenci YorgunluÃ„Å¸u TuzaÃ„Å¸Ã„Â±");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "4", Arrays.asList("&710 saniye boyunca", "&7Madenci YorgunluÃ„Å¸u verir.", ""));
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + "back", "&aGeri");
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + "back", Collections.singletonList("&7YÃƒÂ¼kseltmeler & Tuzaklar"));
        yml.addDefault(Messages.UPGRADES_CATEGORY_GUI_NAME_PATH + "traps", "&8Tuzak Ekle");
        yml.addDefault(Messages.UPGRADES_TRAP_QUEUE_LIMIT, "&cTrap sÃ„Â±rasÃ„Â± dolu!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_MSG, "&c&l{trap} tetiklendi!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_TITLE, "&cTUZAK TETÃ„Â°KLENDÃ„Â°!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_SUBTITLE, "&f{trap} &ftuzaÃ„Å¸Ã„Â±n tetiklendi!");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_MSG + "3", "&c&lAlarm, {color}&l{team} &c&ltakÃ„Â±mdaki &7&l{player} &c&ltarafÃ„Â±ndan tetiklendi!");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_TITLE + "3", "&c&lALARM!!!");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_SUBTITLE + "3", "&fAlarm, {color}{team} &fTakÃ„Â±m tarafÃ„Â±ndan tetiklendi!");
        save();
        setPrefix(m(Messages.PREFIX));
        setPrefixStatic(m(Messages.PREFIX));
    }
}

