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

public class Portuguese extends Language {

    public Portuguese() {
        super(BukkitBedPlugin.plugin, "pt");
        YamlConfiguration yml = getYml();
        yml.options().copyDefaults(true);
        yml.addDefault(Messages.PREFIX, "");
        yml.addDefault("name", "PortuguÃƒÂªs");

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

        yml.addDefault(Messages.COMMAND_MAIN, Arrays.asList("", "&2Ã¢â€“Âª &7/" + mainCmd + " stats", "&2Ã¢â€“Âª &7/" + mainCmd + " join &o<arena/group>", "&2Ã¢â€“Âª &7/" + mainCmd + " leave", "&2Ã¢â€“Âª &7/" + mainCmd + " lang", "&2Ã¢â€“Âª &7/" + mainCmd + " gui", "&2Ã¢â€“Âª &7/" + mainCmd + " start &3(vip)"));
        yml.addDefault(Messages.COMMAND_LANG_LIST_HEADER, "{prefix} &2Idiomas disponÃƒÂ­veis:");
        yml.addDefault(Messages.COMMAND_LANG_LIST_FORMAT, "&aÃ¢â€“Âª  &7{iso} - &f{name}");
        yml.addDefault(Messages.COMMAND_LANG_USAGE, "{prefix}&7Use: /lang &f&o<linguagem>");
        yml.addDefault(Messages.COMMAND_LANG_SELECTED_NOT_EXIST, "{prefix}&cEsta linguagem nÃƒÂ£o existe!");
        yml.addDefault(Messages.COMMAND_LANG_SELECTED_SUCCESSFULLY, "{prefix}&aIdioma alterado!");
        yml.addDefault(Messages.COMMAND_LANG_USAGE_DENIED, "{prefix}&cVocÃƒÂª nÃƒÂ£o pode mudar o idioma durante a partida.");
        yml.addDefault(Messages.COMMAND_JOIN_USAGE, "Ã‚Â§aÃ¢â€“Âª Ã‚Â§7Use: /" + mainCmd + " join Ã‚Â§o<arena/grupo>");
        yml.addDefault(Messages.COMMAND_JOIN_GROUP_OR_ARENA_NOT_FOUND, "{prefix}&cNÃƒÂ£o existe nenhuma arena ou grupo de arena chamado: {name}");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_IS_FULL, "{prefix}&cEsta arena estÃƒÂ¡ cheia!\n&aVocÃƒÂª pode adquirir vantagens doando. &7&o(clique)");
        yml.addDefault(Messages.COMMAND_JOIN_NO_EMPTY_FOUND, "{prefix}&cNÃƒÂ£o hÃƒÂ¡ nenhuma arena disponÃƒÂ­vel no momento ;(");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_IS_FULL_OF_VIPS, "{prefix}&cPedimos desculpas, mas esta arena estÃƒÂ¡ cheia.\n&cSabemos que ÃƒÂ© um doador, mas esta arena jÃƒÂ¡ estÃƒÂ¡ cheia de staffs e/ou doadores.");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_PARTY_TOO_BIG, "{prefix}&cA sua party ÃƒÂ© muito grande para poder entrar na arena. :(");
        yml.addDefault(Messages.COMMAND_JOIN_DENIED_NOT_PARTY_LEADER, "{prefix}&cApenas o lÃƒÂ­der da party pode escolher a arena.");
        yml.addDefault(Messages.COMMAND_JOIN_PLAYER_JOIN_MSG, "{prefix}&7{player} &eentrou (&b{on}&e/&b{max}&e)!");
        yml.addDefault(Messages.COMMAND_JOIN_SPECTATOR_MSG, "{prefix}Ã‚Â§6VocÃƒÂª agora estÃƒÂ¡ assistindo Ã‚Â§9{arena}Ã‚Â§6.\n{prefix}Ã‚Â§eVocÃƒÂª pode sair da arena a qualquer momento com Ã‚Â§c/leaveÃ‚Â§e.");
        yml.addDefault(Messages.COMMAND_JOIN_SPECTATOR_DENIED_MSG, "&cEspectadores nÃƒÂ£o sÃƒÂ£o permitidos nesta arena!");
        yml.addDefault(Messages.COMMAND_TP_PLAYER_NOT_FOUND, "{prefix}&cJogador nÃƒÂ£o encontrado!");
        yml.addDefault(Messages.COMMAND_TP_NOT_IN_ARENA, "{prefix}&cEste jogador nÃƒÂ£o estÃƒÂ¡ em uma arena de bedwars!");
        yml.addDefault(Messages.COMMAND_TP_NOT_STARTED, "{prefix}&cA arena onde o jogador estÃƒÂ¡ ainda nÃƒÂ£o comeÃƒÂ§ou!");
        yml.addDefault(Messages.COMMAND_TP_USAGE, "{prefix}&cUse: /bw tp <player>");
        yml.addDefault(Messages.REJOIN_NO_ARENA, "{prefix}&cNÃƒÂ£o tem partidas para vocÃƒÂª se reconectar.");
        yml.addDefault(Messages.REJOIN_DENIED, "{prefix}&cVocÃƒÂª nÃƒÂ£o pode mais se juntar ÃƒÂ  arena. Jogo terminou ou cama destruÃƒÂ­da.");
        yml.addDefault(Messages.REJOIN_ALLOWED, "{prefix}&eEntrando na arena &a{arena}&e!");
        yml.addDefault(Messages.COMMAND_REJOIN_PLAYER_RECONNECTED, "{prefix}&7{player} &ese reconectou!");
        yml.addDefault(Messages.COMMAND_LEAVE_DENIED_NOT_IN_ARENA, "{prefix}&cVocÃƒÂª nÃƒÂ£o estÃƒÂ¡ em uma arena!");
        yml.addDefault(Messages.COMMAND_LEAVE_MSG, "{prefix}&7{player} &esaiu!");
        yml.addDefault(Messages.COMMAND_NOT_ALLOWED_IN_GAME, "{prefix}&cVocÃƒÂª nÃƒÂ£o pode fazer isso durante o jogo.");
        yml.addDefault(Messages.COMMAND_NOT_FOUND_OR_INSUFF_PERMS, "{prefix}&cComando nÃƒÂ£o encontrado ou vocÃƒÂª nÃƒÂ£o tem permissÃƒÂ£o!");
        yml.addDefault(Messages.COMMAND_PARTY_HELP, Arrays.asList("&6Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&aComandos da Party:",
                "&e/party help &7- &bIrÃƒÂ¡ mostrar essa mensagem",
                "&e/party invite <player> &7- &bConvida o jogador para sua party",
                "&e/party leave &7- &bSaia da sua party",
                "&e/party info &7- &bShow party members and owner",
                "&e/party promote <player> &7- &bTransfer party ownership",
                "&e/party remove <player> &7- &bRemova o jogador da party",
                "&e/party accept <player> &7- &bAceite um pedido de party",
                "&e/party disband &7- &bRecuse um pedido de party")
        );
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_USAGE, "{prefix}&eUse: &7/party invite <player>");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_PLAYER_OFFLINE, "{prefix}&7{player} &enÃƒÂ£o estÃƒÂ¡ online.");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_SENT, "{prefix}&ePedido enviado para &7{player}&6.");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_SENT_TARGET_RECEIVE_MSG, "{prefix}&b{player} &econvidou vocÃƒÂª para uma party! &o&7(Clique para aceitar)");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_CANNOT_INVITE_YOURSELF, "{prefix}&cVocÃƒÂª nÃƒÂ£o pode se convidar!");
        yml.addDefault(Messages.COMMAND_PARTY_INVITE_DENIED_PLAYER_OFFLINE, "{prefix}&7{player} &enÃƒÂ£o estÃƒÂ¡ online.");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_DENIED_NO_INVITE, "{prefix}&cVocÃƒÂª nÃƒÂ£o tem solicitaÃƒÂ§ÃƒÂµes de party.");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_DENIED_ALREADY_IN_PARTY, "{prefix}&eVocÃƒÂª jÃƒÂ¡ estÃƒÂ¡ em uma party!");
        yml.addDefault(Messages.COMMAND_PARTY_INSUFFICIENT_PERMISSIONS, "{prefix}&cSomente o dono da party pode fazer isso!");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_USAGE, "{prefix}&eUse: &7/party accept <player>");
        yml.addDefault(Messages.COMMAND_PARTY_ACCEPT_SUCCESS, "{prefix}&7{player} &eentrou na party.");
        yml.addDefault(Messages.COMMAND_PARTY_GENERAL_DENIED_NOT_IN_PARTY, "{prefix}&cVocÃƒÂª nÃƒÂ£o estÃƒÂ¡ em uma party.");
        yml.addDefault(Messages.COMMAND_PARTY_LEAVE_DENIED_IS_OWNER_NEEDS_DISBAND, "{prefix}&cVocÃƒÂª nÃƒÂ£o pode sair da sua party.\n&eTente usar: &b/party disband");
        yml.addDefault(Messages.COMMAND_PARTY_LEAVE_SUCCESS, "{prefix}&7{player} &esaiu da party!");
        yml.addDefault(Messages.COMMAND_PARTY_DISBAND_SUCCESS, "{prefix}&eA party foi desfeita");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_USAGE, "{prefix}&7Use: &e/party remove <player>");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_SUCCESS, "{prefix}&7{player} &efoi removido da party.");
        yml.addDefault(Messages.COMMAND_PARTY_REMOVE_DENIED_TARGET_NOT_PARTY_MEMBER, "{prefix}&7{player} &enÃƒÂ£o estÃƒÂ¡ na sua party!");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_SUCCESS, "{prefix}&eVocÃƒÂª promoveu com sucesso {player} a dono");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_OWNER, "{prefix}&eVocÃƒÂª foi promovido a dono do grupo");
        yml.addDefault(Messages.COMMAND_PARTY_PROMOTE_NEW_OWNER, "{prefix}&7 &e{player} foi promovido a dono");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_OWNER, "\n{prefix}&eO dono do grupo ÃƒÂ©: &7{owner}");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_PLAYERS,"{prefix}&eMembros do grupo sÃƒÂ£o:");
        yml.addDefault(Messages.COMMAND_PARTY_INFO_PLAYER, "&7{player}");
        yml.addDefault(Messages.COMMAND_FORCESTART_NOT_IN_GAME, "Ã‚Â§cÃ¢â€“Âª Ã‚Â§7VocÃƒÂª nÃƒÂ£o estÃƒÂ¡ jogando!");
        yml.addDefault(Messages.COMMAND_FORCESTART_SUCCESS, "Ã‚Â§cÃ¢â€“Âª Ã‚Â§7Contagem regressiva encurtada!");
        yml.addDefault(Messages.COMMAND_FORCESTART_NO_PERM, "{prefix}&7VocÃƒÂª nÃƒÂ£o pode inicializar uma partida.\nÃ‚Â§7Por favor, considere doar para obter vantagens VIP.");
        yml.addDefault(Messages.COMMAND_COOLDOWN, "&cVocÃƒÂª nÃƒÂ£o pode fazer isso ainda! Aguarde mais {seconds} segundos!");
        yml.addDefault(Messages.ARENA_JOIN_VIP_KICK, "{prefix}&cDesculpe, mas vocÃƒÂª foi expulso porque um doador entrou na arena.\n&aPor favor, considere doar para mais vantagens. &7&o(clique)");
        yml.addDefault(Messages.ARENA_START_COUNTDOWN_STOPPED_INSUFF_PLAYERS_CHAT, "{prefix}Ã‚Â§cNÃƒÂ£o hÃƒÂ¡ jogadores suficientes! Contagem regressiva parada!");
        yml.addDefault(Messages.ARENA_RESTART_PLAYER_KICK, "{prefix}&eA arena em que vocÃƒÂª estava estÃƒÂ¡ reiniciando.");
        yml.addDefault(Messages.ARENA_STATUS_PLAYING_NAME, "&cJogando");
        yml.addDefault(Messages.ARENA_STATUS_RESTARTING_NAME, "&4Reiniciando");
        yml.addDefault(Messages.ARENA_STATUS_WAITING_NAME, "&2Esperando Ã‚Â§c{full}");
        yml.addDefault(Messages.ARENA_STATUS_STARTING_NAME, "&6Iniciando Ã‚Â§c{full}");
        yml.addDefault(Messages.ARENA_GUI_INV_NAME, "&8Clique para entrar!");
        yml.addDefault(Messages.ARENA_GUI_ARENA_CONTENT_NAME, "&a&l{name}");
        yml.addDefault(Messages.ARENA_GUI_ARENA_CONTENT_LORE, Arrays.asList("", "&7Status: {status}", "&7Jogadores: &f{on}&7/&f{max}", "&7Tipo: &a{group}", "", "&aBotÃƒÂ£o esquerdo para entrar.", "&eBotÃƒÂ£o direito para assistir."));
        yml.addDefault(Messages.ARENA_GUI_SKIPPED_ITEM_NAME, "&r{serverIp}");
        yml.addDefault(Messages.ARENA_GUI_SKIPPED_ITEM_LORE, Collections.emptyList());
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CHAT, "{prefix}&eO jogo comeÃƒÂ§a em &6{time} &esegundos!");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_TITLE, " ");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE, "&a{second}");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-5", "&eÃ¢ÂÂº");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-4", "&eÃ¢ÂÂ¹");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-3", "&cÃ¢ÂÂ¸");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-2", "&cÃ¢ÂÂ·");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_SUB_TITLE + "-1", "&cÃ¢ÂÂ¶");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CANCELLED_TITLE, " ");
        yml.addDefault(Messages.ARENA_STATUS_START_COUNTDOWN_CANCELLED_SUB_TITLE, "&cAguardando mais jogadores...");
        yml.addDefault(Messages.ARENA_STATUS_START_PLAYER_TITLE, "&aCOMEÃƒâ€¡OU");
        yml.addDefault(Messages.ARENA_STATUS_START_PLAYER_TUTORIAL, Arrays.asList("&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&f                                   &lBedWars", "",
                "&e&l    Proteja sua cama e destrua as camas inimigas.",
                "&e&l      Melhore vocÃƒÂª e sua equipe coletando",
                "&e&l   Ferro, Ouro, Esmeralda e Diamante de geradores",
                "&e&l             para adquirir as melhorias.", "",
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        yml.addDefault(Messages.ARENA_JOIN_DENIED_SELECTOR, "{prefix}&cDesculpe, mas vocÃƒÂª nÃƒÂ£o pode participar desta partida neste momento. Use o botÃƒÂ£o direito do mouse para espectar.");
        yml.addDefault(Messages.ARENA_SPECTATE_DENIED_SELECTOR, "{prefix}&cDesculpe, mas vocÃƒÂª nÃƒÂ£o pode espectar esta partida neste momento. Utilize o botÃƒÂ£o esquerdo para entrar na partida.");
        yml.addDefault(Messages.ARENA_JOIN_DENIED_NO_PROXY, "&cDesculpe, mas precisa entrar em uma arena usando BedWarsProxy. \n&eSe vocÃƒÂª quiser configurar uma arena, certifique-se de dar a si mesmo a permissÃƒÂ£o bw.setup para que vocÃƒÂª possa entrar no servidor diretamente!");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_NAME, "&8Teletransportador");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_HEAD_NAME, "{vPrefix}{player}");
        yml.addDefault(Messages.ARENA_SPECTATOR_TELEPORTER_GUI_HEAD_LORE, Arrays.asList("&7Vida: &f{health}%", "&7Fome: &f{food}", "", "&7Clique para teletransportar."));
        yml.addDefault(Messages.ARENA_SPECTATOR_LEAVE_ITEM_NAME, "&c&lRetornar ao lobby");
        yml.addDefault(Messages.ARENA_SPECTATOR_LEAVE_ITEM_LORE, Collections.singletonList("&7Clique com o botÃƒÂ£o direito para sair."));
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_ENTER_TITLE, "&aEspectando: &7{player}");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_ENTER_SUBTITLE, "&cUtilize o SHIFT para sair.");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_LEAVE_TITLE, "&eSaindo do modo espectador!");
        yml.addDefault(Messages.ARENA_SPECTATOR_FIRST_PERSON_LEAVE_SUBTITLE, "");
        yml.addDefault(Messages.ARENA_LEAVE_PARTY_DISBANDED, "{prefix}Ã‚Â§cO dono da party saiu e a party foi desfeita.");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TIER, "&eNÃƒÂ­vel &c{tier}");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TYPE_DIAMOND, "&b&lDiamante");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TYPE_EMERALD, "&a&lEsmeralda");
        yml.addDefault(Messages.GENERATOR_HOLOGRAM_TIMER, "&eGera em &c{seconds} &esegundos.");
        yml.addDefault(Messages.GENERATOR_UPGRADE_CHAT_ANNOUNCEMENT, "{prefix}Geradores de {generatorType} &emelhorados para nÃƒÂ­vel &c{tier}");
        yml.addDefault(Messages.FORMATTING_CHAT_LOBBY, "{level}{vPrefix}&7{player}{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_WAITING, "{level}{vPrefix}&7{player}{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_SHOUT, "{level}{vPrefix}&6[SHOUT] {team} &7{player}&f{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_TEAM, "{level}{vPrefix}&f{team}&7 {player}{vSuffix} {message}");
        yml.addDefault(Messages.FORMATTING_CHAT_SPECTATOR, "{level}{vPrefix}&7[SPECTATOR] {player}{vSuffix}: {message}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_HEALTH, Arrays.asList("&cÃ¢ÂÂ¤", "&aVida"));

        yml.addDefault(Messages.FORMATTING_SCOREBOARD_DATE, "dd/MM/yy");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_GENERIC, "{TeamColor}{TeamLetter}&f {TeamName}: {TeamStatus}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_ELIMINATED, "&c&lÃ¢Å“Ëœ");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_BED_DESTROYED, "&a{remainingPlayers}");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_TEAM_ALIVE, "&a&lÃ¢Å“â€œ");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_NEXEVENT_TIMER, "mm:ss");
        yml.addDefault(Messages.FORMATTING_SCOREBOARD_YOUR_TEAM, "&7 VOCÃƒÅ ");
        yml.addDefault(Messages.FORMATTING_ACTION_BAR_TRACKING, "&fRastreando: {team} &f- DistÃƒÂ¢ncia: {distance}m");
        yml.addDefault(Messages.FORMATTING_TEAM_WINNER_FORMAT, "      {TeamColor}{TeamName} &7- {members}");
        yml.addDefault(Messages.FORMATTING_SOLO_WINNER_FORMAT, "                 {TeamColor}{TeamName} &7- {members}");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER1, "I");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER2, "II");
        yml.addDefault(Messages.FORMATTING_GENERATOR_TIER3, "III");
        yml.addDefault(Messages.FORMATTING_DESPAWNABLE_UTILITY_NPC_HEALTH, "Ã¢â€“Â® ");
        yml.addDefault(Messages.FORMATTING_STATS_DATE_FORMAT, "yyyy/MM/dd HH:mm");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_TEAM, "{TeamColor}[{TeamName}]");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_SHOUT, "&6[SHOUT]");
        yml.addDefault(Messages.FORMAT_PAPI_PLAYER_TEAM_SPECTATOR, "&7[ESPECTADOR]");
        yml.addDefault(Messages.MEANING_FULL, "Lotado");
        yml.addDefault(Messages.MEANING_SHOUT, "shout");
        yml.addDefault(Messages.MEANING_NOBODY, "NinguÃƒÂ©m");
        yml.addDefault(Messages.MEANING_NEVER, "Nunca");
        yml.addDefault(Messages.MEANING_IRON_SINGULAR, "Ferro");
        yml.addDefault(Messages.MEANING_IRON_PLURAL, "Ferros");
        yml.addDefault(Messages.MEANING_GOLD_SINGULAR, "Ouro");
        yml.addDefault(Messages.MEANING_GOLD_PLURAL, "Ouros");
        yml.addDefault(Messages.MEANING_EMERALD_SINGULAR, "Esmeralda");
        yml.addDefault(Messages.MEANING_EMERALD_PLURAL, "Esmeraldas");
        yml.addDefault(Messages.MEANING_DIAMOND_SINGULAR, "Diamante");
        yml.addDefault(Messages.MEANING_DIAMOND_PLURAL, "Diamantes");
        yml.addDefault(Messages.MEANING_VAULT_SINGULAR, "$");
        yml.addDefault(Messages.MEANING_VAULT_PLURAL, "$");
        yml.addDefault(Messages.INTERACT_CANNOT_PLACE_BLOCK, "{prefix}&cVocÃƒÂª nÃƒÂ£o pode colocar blocos aqui!");
        yml.addDefault(Messages.INTERACT_CANNOT_BREAK_BLOCK, "{prefix}&cVocÃƒÂª sÃƒÂ³ pode quebrar blocos colocados por um jogador!");
        yml.addDefault(Messages.INTERACT_CANNOT_BREAK_OWN_BED, "&cVocÃƒÂª nÃƒÂ£o pode destruir sua prÃƒÂ³pria cama!");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_CHAT_ANNOUNCEMENT, "\n&f&lCAMA DESTRUIDA > {TeamColor}Cama do time {TeamName} &7foi destruida por {PlayerColor}{PlayerName}&7!\n");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_TITLE_ANNOUNCEMENT, "&cCAMA DESTRUIDA !");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_SUBTITLE_ANNOUNCEMENT, "&fVocÃƒÂª nÃƒÂ£o vai mais renascer!");
        yml.addDefault(Messages.INTERACT_BED_DESTROY_CHAT_ANNOUNCEMENT_TO_VICTIM, "&f&lCAMA DESTRUIDA > &7Sua cama foi destruida por {PlayerColor}{PlayerName}&7!");
        yml.addDefault(Messages.INTERACT_CHEST_CANT_OPEN_TEAM_ELIMINATED, "&cVocÃƒÂª nÃƒÂ£o pode abrir este baÃƒÂº porque esse time nÃƒÂ£o foi eliminado!");
        yml.addDefault(Messages.INTERACT_INVISIBILITY_REMOVED_DAMGE_TAKEN, "&cSua invisibilidade foi removida pois vocÃƒÂª tomou dano!");
        yml.addDefault(Messages.PLAYER_DIE_VOID_FALL_REGULAR_KILL, "{PlayerColor}{PlayerName} &7caiu no void.");
        yml.addDefault(Messages.PLAYER_DIE_VOID_FALL_FINAL_KILL, "{PlayerColor}{PlayerName} &7caiu no void. &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_IN_VOID_REGULAR_KILL, "{PlayerColor}{PlayerName} &7foi jogado no void por {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_IN_VOID_FINAL_KILL, "{PlayerColor}{PlayerName} &7foi jogado no void por {KillerColor}{KillerName}&7. &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_PVP_LOG_OUT_REGULAR, "{PlayerColor}{PlayerName} &7desconectou em combate com {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_PVP_LOG_OUT_FINAL, "{PlayerColor}{PlayerName} &7desconectou em combate com {KillerColor}{KillerName}&7. &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_BY_REGULAR_KILL, "{PlayerColor}{PlayerName} &7foi empurrado por {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_KNOCKED_BY_FINAL_KILL, "{PlayerColor}{PlayerName} &7foi empurrado por {KillerColor}{KillerName}&7. &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITH_SOURCE_REGULAR_KILL, "{PlayerColor}{PlayerName} &7foi atingido por uma TNT de {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITH_SOURCE_FINAL_KILL, "{PlayerColor}{PlayerName} &7foi atingido por uma TNT de {KillerColor}{KillerName}&7. &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITHOUT_SOURCE_REGULAR, "{PlayerColor}{PlayerName} &7foi atingido por uma TNT.");
        yml.addDefault(Messages.PLAYER_DIE_EXPLOSION_WITHOUT_SOURCE_FINAL_KILL, "{PlayerColor}{PlayerName} &7foi atingido por uma TNT. &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_PVP_REGULAR_KILL, "{PlayerColor}{PlayerName} &7foi morto por {KillerColor}{KillerName}&7.");
        yml.addDefault(Messages.PLAYER_DIE_PVP_FINAL_KILL, "{PlayerColor}{PlayerName} &7foi morto por {KillerColor}{KillerName}&7. &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_UNKNOWN_REASON_REGULAR, "{PlayerColor}{PlayerName} &7morreu.");
        yml.addDefault(Messages.PLAYER_DIE_UNKNOWN_REASON_FINAL_KILL, "{PlayerColor}{PlayerName} &7morreu. &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_SHOOT_REGULAR, "{PlayerColor}{PlayerName} &7foi flechado por {KillerColor}{KillerName}&7!");
        yml.addDefault(Messages.PLAYER_DIE_SHOOT_FINAL_KILL, "{PlayerColor}{PlayerName} &7foi flechado por {KillerColor}{KillerName}&7! &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_DEBUG_REGULAR, "{PlayerColor}{PlayerName} &7foi morto por pela TraÃƒÂ§a de {KillerColor}{KillerTeamName}&7!");
        yml.addDefault(Messages.PLAYER_DIE_DEBUG_FINAL_KILL, "{PlayerColor}{PlayerName} &7foi morto por pela TraÃƒÂ§a de {KillerColor}{KillerTeamName}&7! &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_IRON_GOLEM_REGULAR, "{PlayerColor}{PlayerName} &7foi morto pelo Golem do {KillerColor}{KillerTeamName}&7!");
        yml.addDefault(Messages.PLAYER_DIE_IRON_GOLEM_FINAL_KILL, "{PlayerColor}{PlayerName} &7foi morto pelo Golem do {KillerColor}{KillerTeamName}&7! &b&lKILL FINAL!");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_DIAMOND, "{prefix}&b+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_EMERALD, "{prefix}&a+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_IRON, "{prefix}&f+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_REWARD_GOLD, "{prefix}&6+{amount} {meaning}");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_TITLE, "&cVOCÃƒÅ  MORREU!");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_SUBTITLE, "&eRenascendo em &c{time} &esegundos.");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWN_CHAT, "{prefix}&eVocÃƒÂª irÃƒÂ¡ renascer em &c{time} &esegundos.");
        yml.addDefault(Messages.PLAYER_DIE_RESPAWNED_TITLE, "&aRENASCIDO!");
        yml.addDefault(Messages.PLAYER_DIE_ELIMINATED_CHAT, "{prefix}&cVocÃƒÂª foi eliminado!");
        yml.addDefault(Messages.PLAYER_HIT_BOW, "{prefix}{TeamColor}{PlayerName} &7estÃƒÂ¡ com &c{amount} &7de vida!");
        yml.addDefault(Messages.GAME_END_GAME_OVER_PLAYER_TITLE, "&c&lFIM DE JOGO!");
        yml.addDefault(Messages.GAME_END_VICTORY_PLAYER_TITLE, "&6&lVITÃƒâ€œRIA!");
        yml.addDefault(Messages.GAME_END_TEAM_WON_CHAT, "{prefix}{TeamColor}{TeamName} &aganhou o jogo!");
        yml.addDefault(Messages.GAME_END_TOP_PLAYER_CHAT, Arrays.asList("&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬",
                "&f                                   &lBedWars", "", "{winnerFormat}", "", "",
                "&6                      &6Ã¢Â­Â &l1Ã‚Âº Assassino &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}",
                "&e                        &l2Ã‚Âº Assassino &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}",
                "&c                        &l3Ã‚Âº Assassino &7- {topTeamColor}{topPlayerDisplayName} &7- &l{topValue}", "",
                "&aÃ¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬Ã¢â€“Â¬"));
        yml.addDefault(Messages.BED_HOLOGRAM_DEFEND, "&c&lDefenda sua cama!");
        yml.addDefault(Messages.BED_HOLOGRAM_DESTROYED, "&c&lSua cama foi destruÃƒÂ­da!");
        yml.addDefault(Messages.NPC_NAME_TEAM_UPGRADES, "&bMELHORIAS DA EQUIPE,&e&lCLIQUE DIREITO");
        yml.addDefault(Messages.NPC_NAME_SOLO_UPGRADES, "&bMELHORIAS,&e&lCLIQUE DIREITO");
        yml.addDefault(Messages.NPC_NAME_TEAM_SHOP, "&bLOJA DA EQUIPE,&e&lCLIQUE DIREITO");
        yml.addDefault(Messages.NPC_NAME_SOLO_SHOP, "&bLOJA,&e&lCLIQUE DIREITO");
        yml.addDefault(Messages.TEAM_ELIMINATED_CHAT, "\n&f&lEQUIPE ELIMINADA > &cO time {TeamColor}{TeamName} &cfoi eliminado!\n");
        yml.addDefault(Messages.NEXT_EVENT_BEDS_DESTROY, "&cDestruiÃƒÂ§ÃƒÂ£o da Cama");
        yml.addDefault(Messages.NEXT_EVENT_DIAMOND_UPGRADE_II, "&fDiamante II");
        yml.addDefault(Messages.NEXT_EVENT_DIAMOND_UPGRADE_III, "&fDiamante III");
        yml.addDefault(Messages.NEXT_EVENT_DRAGON_SPAWN, "&fMorte SÃƒÂºbita");
        yml.addDefault(Messages.NEXT_EVENT_EMERALD_UPGRADE_II, "&fEsmeraldas II");
        yml.addDefault(Messages.NEXT_EVENT_EMERALD_UPGRADE_III, "&fEsmeraldas III");
        yml.addDefault(Messages.NEXT_EVENT_GAME_END, "&4Fim do jogo");
        yml.addDefault(Messages.NEXT_EVENT_TITLE_ANNOUNCE_BEDS_DESTROYED, "&cCAMA DESTRUÃƒÂDA!");
        yml.addDefault(Messages.NEXT_EVENT_SUBTITLE_ANNOUNCE_BEDS_DESTROYED, "&fTodas as camas foram destruÃƒÂ­das!");
        yml.addDefault(Messages.NEXT_EVENT_CHAT_ANNOUNCE_BEDS_DESTROYED, "&c&lTodas as camas foram destruÃƒÂ­das!");
        yml.addDefault(Messages.NEXT_EVENT_TITLE_ANNOUNCE_SUDDEN_DEATH, "&cMorte SÃƒÂºbita");
        yml.addDefault(Messages.NEXT_EVENT_SUBTITLE_ANNOUNCE_SUDDEN_DEATH, "");
        yml.addDefault(Messages.NEXT_EVENT_CHAT_ANNOUNCE_SUDDEN_DEATH, "&cMORTE SÃƒÅ¡BITA: &6&b{TeamDragons} dragÃƒÂµes do {TeamColor}{TeamName}");
        yml.addDefault(Messages.XP_REWARD_PER_MINUTE, "{prefix}&6+{xp} BukkitBedPlugin Experience Received (Tempo de jogo).");
        yml.addDefault(Messages.XP_REWARD_WIN, "{prefix}&6+{xp} BukkitBedPlugin Experience Received (Vencer o jogo).");
        yml.addDefault(Messages.XP_REWARD_PER_TEAMMATE, "{prefix}&6+{xp} BukkitBedPlugin Experience Received (Suporte da equipe).");
        yml.addDefault(Messages.XP_REWARD_BED_DESTROY, "{prefix}&6+{xp} BukkitBedPlugin Experience Received (Bed Destroyed).");
        yml.addDefault(Messages.XP_REWARD_REGULAR_KILL, "{prefix}&6+{xp} BukkitBedPlugin Experience Received (Regular Kill).");
        yml.addDefault(Messages.XP_REWARD_FINAL_KILL, "{prefix}&6+{xp} BukkitBedPlugin Experience Received (Final Kill).");

        yml.addDefault(Messages.MONEY_REWARD_PER_MINUTE, "{prefix}&6+{money} Moedas (Tempo de jogo).");
        yml.addDefault(Messages.MONEY_REWARD_WIN, "{prefix}&6+{money} Moedas (Vencer o jogo).");
        yml.addDefault(Messages.MONEY_REWARD_PER_TEAMMATE, "{prefix}&6+{money} Moedas (Suporte da equipe).");
        yml.addDefault(Messages.MONEY_REWARD_BED_DESTROYED, "{prefix}&6+{money} Moedas (Bed Destroyed).");
        yml.addDefault(Messages.MONEY_REWARD_FINAL_KILL, "{prefix}&6+{money} Moedas (Final Kill).");
        yml.addDefault(Messages.MONEY_REWARD_REGULAR_KILL, "{prefix}&6+{money} Moedas (Regular Kill).");

        /* Lobby Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "stats"), "&eEstatÃƒÂ­sticas");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "stats"), Collections.singletonList("&fBotÃƒÂ£o direito para ver estatÃƒÂ­sticas! "));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "arena-selector"), "&eSeletor de Arena");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "arena-selector"), Collections.singletonList("&fBotÃƒÂ£o direito para escolher arena."));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_NAME.replace("%path%", "leave"), "&eSair do BukkitBedPlugin");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_LOBBY_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fBotÃƒÂ£o direito para sair do BukkitBedPlugin!"));
        /* Pre Game Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_NAME.replace("%path%", "stats"), "&eEstatÃƒÂ­sticas");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_LORE.replace("%path%", "stats"), Collections.singletonList("&fBotÃƒÂ£o direito para ver estatÃƒÂ­sticas!"));
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_NAME.replace("%path%", "leave"), "&eSair da Partida");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_WAITING_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fBotÃƒÂ£o direito para sair da arena!"));
        /* Spectator Command Items */
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_NAME.replace("%path%", "teleporter"), "&eTeletransportador");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_NAME.replace("%path%", "leave"), "&eSair da Partida");
        yml.addDefault(Messages.GENERAL_CONFIGURATION_SPECTATOR_ITEMS_LORE.replace("%path%", "leave"), Collections.singletonList("&fBotÃƒÂ£o direito para sair da arena!"));

        /* save default items messages for stats gui */
        yml.addDefault(Messages.PLAYER_STATS_GUI_INV_NAME, "&8EstatÃƒÂ­sticas de {player}");
        addDefaultStatsMsg(yml, "wins", "&6VitÃƒÂ³rias", "&f{wins}");
        addDefaultStatsMsg(yml, "losses", "&6Perdas", "&f{losses}");
        addDefaultStatsMsg(yml, "kills", "&6Abates", "&f{kills}");
        addDefaultStatsMsg(yml, "deaths", "&6Mortes", "&f{deaths}");
        addDefaultStatsMsg(yml, "final-kills", "&6Abates Finais", "&f{finalKills}");
        addDefaultStatsMsg(yml, "final-deaths", "&6Mortes Finais", "&f{finalDeaths}");
        addDefaultStatsMsg(yml, "beds-destroyed", "&6Camas Destruidas", "&f{bedsDestroyed}");
        addDefaultStatsMsg(yml, "first-play", "&6Primeira Partida", "&f{firstPlay}");
        addDefaultStatsMsg(yml, "last-play", "&6ÃƒÅ¡ltima Partida", "&f{lastPlay}");
        addDefaultStatsMsg(yml, "games-played", "&6Partidas", "&f{gamesPlayed}");

        // Start of Sidebar
        yml.addDefault(Messages.SCOREBOARD_LOBBY, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&fSeu nivel: {level}",
                "",
                "&fProgresso: &a{currentXp}&7/&b{requiredXp}",
                "{progress}",
                "",
                "&7{player}",
                "",
                "&fMoedas: &a{money}",
                "",
                "&fTotal de vitÃƒÂ³rias: &a{wins}",
                "&fTotal de abates: &a{kills}",
                "", "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_WAITING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "",
                "&fMapa: &a{map}",
                "",
                "&fJogadores: &a{on}/{max}",
                "",
                "&fEsperando,&fEsperando.,&fEsperando..,&fEsperando...",
                "",
                "&fModo: &a{group}",
                "&fVersÃƒÂ£o: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_WAITING_SPEC, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "&o&7Spectating",
                "&fMapa: &a{map}",
                "",
                "&fJogadores: &a{on}/{max}",
                "",
                "&fEsperando,&fEsperando.,&fEsperando..,&fEsperando...",
                "",
                "&fModo: &a{group}",
                "&fVersÃƒÂ£o: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_STARTING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "",
                "&fMapa: &a{map}",
                "",
                "&fJogadores: &a{on}/{max}",
                "",
                "&fInicio em &a{time}s",
                "",
                "&fModo: &a{group}",
                "&fVersÃƒÂ£o: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_STARTING_SPEC, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date} &8{server}",
                "&o&7Spectating",
                "&fMapa: &a{map}",
                "",
                "&fJogadores: &a{on}/{max}",
                "",
                "&fInicio em &a{time}s",
                "",
                "&fModo: &a{group}",
                "&fVersÃƒÂ£o: &7{version}",
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING, Arrays.asList(
                "&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&lBED WARS,&f&l{poweredBy},&f&l{poweredBy},&f&l{poweredBy},&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&lBED WARS,&e&l{poweredBy},&e&l{poweredBy},&e&l{poweredBy}",
                "&7{date}",
                "",
                "&f{nextEvent} em &a{time}",
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
                "&f{nextEvent} em &a{time}",
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
                "&f{nextEvent} em &a{time}",
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
                "&fKills: &a{kills}",
                "&fFinal Kills: &a{finalKills}",
                "&fBeds Broken: &a{beds}",
                "",
                "&e{serverIp}")
        );

        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC.replaceFirst("Default", "3v3v3v3"), Arrays.asList(
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
                "",
                "&e{serverIp}")
        );
        yml.addDefault(Messages.SCOREBOARD_DEFAULT_PLAYING_SPEC_ELIMINATED.replaceFirst("Default", "3v3v3v3"), Arrays.asList(
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
                "&fKills: &a{kills}",
                "&fFinal Kills: &a{finalKills}",
                "&fBeds Broken: &a{beds}",
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
                "&fKills: &a{kills}",
                "&fFinal Kills: &a{finalKills}",
                "&fBeds Broken: &a{beds}",
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
                "&fKills: &a{kills}",
                "&fFinal Kills: &a{finalKills}",
                "&fBeds Broken: &a{beds}",
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
        yml.addDefault(Messages.SHOP_INDEX_NAME, "&8Compra rÃƒÂ¡pida");
        yml.addDefault(Messages.SHOP_QUICK_ADD_NAME, "&8Adicionando ÃƒÂ  compra rÃƒÂ¡pida...");
        yml.addDefault(Messages.SHOP_INSUFFICIENT_MONEY, "{prefix}&cVocÃƒÂª nÃƒÂ£o tem {currency} suficiente! Precisa de mais {amount}!");
        yml.addDefault(Messages.SHOP_NEW_PURCHASE, "{prefix}&aVocÃƒÂª comprou &6{item}");
        yml.addDefault(Messages.SHOP_ALREADY_BOUGHT, "{prefix}&cVocÃƒÂª jÃƒÂ¡ comprou isso!");
        yml.addDefault(Messages.SHOP_UTILITY_NPC_SILVERFISH_NAME, "{TeamColor}&l{TeamName} &r{TeamColor}TraÃƒÂ§a");
        yml.addDefault(Messages.SHOP_UTILITY_NPC_IRON_GOLEM_NAME, "{TeamColor}{despawn}s &8[ {TeamColor}{health}&8]");
        yml.addDefault(Messages.SHOP_SEPARATOR_NAME, "&8Ã¢â€¡Â§ Categorias");
        yml.addDefault(Messages.SHOP_SEPARATOR_LORE, Collections.singletonList("&8Ã¢â€¡Â© Itens"));
        yml.addDefault(Messages.SHOP_QUICK_BUY_NAME, "&bCompra rÃƒÂ¡pida");
        yml.addDefault(Messages.SHOP_QUICK_BUY_LORE, new ArrayList<>());
        yml.addDefault(Messages.SHOP_QUICK_EMPTY_NAME, "&cEspaÃƒÂ§o vazio!");
        yml.addDefault(Messages.SHOP_QUICK_EMPTY_LORE, Arrays.asList("&7Este ÃƒÂ© um slot de compra rÃƒÂ¡pida!", "&7Clique em um item segurando o", "&7shift para adicionar neste slot."));
        yml.addDefault(Messages.SHOP_CAN_BUY_COLOR, "&a");
        yml.addDefault(Messages.SHOP_CANT_BUY_COLOR, "&c");
        yml.addDefault(Messages.SHOP_LORE_STATUS_CAN_BUY, "&eClique para comprar!");
        yml.addDefault(Messages.SHOP_LORE_STATUS_CANT_AFFORD, "&cVocÃƒÂª nÃƒÂ£o tem o suficiente de {currency}!");
        yml.addDefault(Messages.SHOP_LORE_STATUS_MAXED, "&aMÃƒÂXIMO!");
        yml.addDefault(Messages.SHOP_LORE_QUICK_ADD, "&bClique + shift para por na Compra RÃƒÂ¡pida");
        yml.addDefault(Messages.SHOP_LORE_QUICK_REMOVE, "&bClique + shift para tirar da Compra RÃƒÂ¡pida");


        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "&8Blocos", "&aBlocos", Collections.singletonList("&eClique para ver!"));

        addContentMessages(yml, "wool", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}LÃƒÂ£", Arrays.asList("&7PreÃƒÂ§o: &f{cost} {currency}", "", "&7Ãƒâ€œtimo para atravessar ilhas.", "&7Transforma-se na cor do seu time.",
                "&7color.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "clay", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Argila Endurecida", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Bloco bÃƒÂ¡sico para defender sua cama.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "glass", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Vidro ÃƒÂ  prova de explosÃƒÂ£o", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Imune a explosÃƒÂµes.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "stone", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Pedra do Fim", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Bloco sÃƒÂ³lido para defender sua cama.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "ladder", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Escada", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7ÃƒÅ¡til para salvar gatos presos", "&7de arvores.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "obsidian", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Obsidiana", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7ProteÃƒÂ§ÃƒÂ£o extrema para sua cama.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "wood", ConfigPath.SHOP_PATH_CATEGORY_BLOCKS, "{color}Madeira", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Bloco sÃƒÂ³lido para defender sua cama.", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_MELEE, "&8Corpo a corpo", "&aCorpo a corpo", Collections.singletonList("&eClique para ver!"));

        addContentMessages(yml, "stone-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Espada de Pedra", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "iron-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Espada de Ferro", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "diamond-sword", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Espada de Diamante", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "stick", ConfigPath.SHOP_PATH_CATEGORY_MELEE, "{color}Graveto (RepulsÃƒÂ£o I)", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "&aArmadura", "&aArmadura", Collections.singletonList("&eClique para ver!"));

        addContentMessages(yml, "chainmail", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Armadura de Malha Permanente", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}",
                "", "&7CalÃƒÂ§as e botas de malha", "&7que vocÃƒÂª sempre irÃƒÂ¡ renascer", "&7com elas.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "iron-armor", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Armadura de Ferro Permanente", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}",
                "", "&7CalÃƒÂ§as e botas de ferro", "&7que vocÃƒÂª sempre irÃƒÂ¡ renascer", "com elas.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "diamond-armor", ConfigPath.SHOP_PATH_CATEGORY_ARMOR, "{color}Armadura de Diamante Permanente", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}",
                "", "&7CalÃƒÂ§as e botas de diamante", "&7que vocÃƒÂª sempre irÃƒÂ¡ renascer", "com elas.", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "&8Ferramentas", "&aFerramentas", Collections.singletonList("&eClique para ver!"));

        addContentMessages(yml, "shears", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Tesouras Permanentes", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}",
                "", "&7Ãƒâ€œtimo para se livrar da lÃƒÂ£. VocÃƒÂª", "&7sempre irÃƒÂ¡ nascer com as tesouras.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "pickaxe", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Picareta {tier}", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "&7NÃƒÂ­vel: &e{tier}",
                "", "&7Este ÃƒÂ© um item melhorÃƒÂ¡vel.", "&7Ele perderÃƒÂ¡ 1 nÃƒÂ­vel apÃƒÂ³s.", "&7vocÃƒÂª morer!", "", "&7VocÃƒÂª vai permanentemente", "&7renascer com pelo menos o", "&7nÃƒÂ­vel mais baixo.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "axe", ConfigPath.SHOP_PATH_CATEGORY_TOOLS, "{color}Machado {tier}", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "&7NÃƒÂ­vel: &e{tier}",
                "", "&7Este ÃƒÂ© um item melhorÃƒÂ¡vel.", "&7Ele perderÃƒÂ¡ 1 nÃƒÂ­vel apÃƒÂ³s.", "&7vocÃƒÂª morer!", "", "&7VocÃƒÂª vai permanentemente", "&7renascer com pelo menos o", "&7nÃƒÂ­vel mais baixo.", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_RANGED, "&8Arcos", "&aArcos", Collections.singletonList("&eClique para ver!"));

        addContentMessages(yml, "arrow", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Flecha", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow1", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Arco", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow2", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Arco (ForÃƒÂ§a I)", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bow3", ConfigPath.SHOP_PATH_CATEGORY_RANGED, "{color}Arco (ForÃƒÂ§a I, Impacto I)", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "&8PoÃƒÂ§ÃƒÂµes", "&aPoÃƒÂ§ÃƒÂµes", Collections.singletonList("&eClique para ver!"));

        addContentMessages(yml, "speed-potion", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}PoÃƒÂ§ÃƒÂ£o de Agilidade II (45 segundos)", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "jump-potion", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}PoÃƒÂ§ÃƒÂ£o de Super Pulo V (45 segundos)", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "invisibility", ConfigPath.SHOP_PATH_CATEGORY_POTIONS, "{color}PoÃƒÂ§ÃƒÂ£o de Invisibilidade (30 segundos)", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "{quick_buy}", "{buy_status}"));

        addCategoryMessages(yml, ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "&8Utilidades", "&aUtilidades", Collections.singletonList("&eClique para ver!"));

        addContentMessages(yml, "golden-apple", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}MaÃƒÂ§a Dourada", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Cura completa.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bedbug", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}TraÃƒÂ§a", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Gera traÃƒÂ§as onde a bola",
                "&7de neve cai para distrair seus", "&7inimigos. Dura 15 segundos.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "dream-defender", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Defesa dos Sonhos", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Golem de Ferro para defender sua",
                "&7base. Dura 4 minutos.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "fireball", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Bola de Fogo", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7BotÃƒÂ£o direito para atirar! Ãƒâ€œtimo para",
                "&7repelir os inimigos andando", "&7por pontes.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "tnt", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}TNT", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Explode instantaneamente, apropriado",
                "&7para explodir coisas!", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "ender-pearl", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}PÃƒÂ©rola do Fim", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7A maneira mais rÃƒÂ¡pida de invadir",
                "&7a base do inimigo.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "water-bucket", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Balde de ÃƒÂgua", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Ãƒâ€œtimo para atrasar inimigos. TambÃƒÂ©m",
                "&7protege contra TNT.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "bridge-egg", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Ovo das Pontes", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Este ovo cria uma ponte na",
                "&7direÃƒÂ§ÃƒÂ£o que for jogada.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "magic-milk", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Leite MÃƒÂ¡gico", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Evite acionar armadilhas por 60",
                "&7segundos apÃƒÂ³s o consumo.", "", "{quick_buy}", "{buy_status}"));
        addContentMessages(yml, "sponge", ConfigPath.SHOP_PATH_CATEGORY_UTILITY, "{color}Esponja", Arrays.asList("&7PreÃƒÂ§o: {cost} {currency}", "", "&7Ãƒâ€œtimo para absorver a ÃƒÂ¡gua.",
                "", "{quick_buy}", "{buy_status}"));

        //
        yml.addDefault(Messages.MEANING_NO_TRAP, "Sem armadilha!");
        yml.addDefault(Messages.FORMAT_SPECTATOR_TARGET, "{targetTeamColor}{targetDisplayName}");
        yml.addDefault(Messages.FORMAT_UPGRADE_TRAP_COST, "&7PreÃƒÂ§o: {currencyColor}{cost} {currency}");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_CAN_AFFORD, "&e");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_CANT_AFFORD, "&c");
        yml.addDefault(Messages.FORMAT_UPGRADE_COLOR_UNLOCKED, "&a");
        yml.addDefault(Messages.FORMAT_UPGRADE_TIER_LOCKED, "&7");
        yml.addDefault(Messages.FORMAT_UPGRADE_TIER_UNLOCKED, "&a");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_CLICK_TO_BUY, "{color}Clique para comprar!");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_INSUFFICIENT_MONEY, "{color}VocÃƒÂª nÃƒÂ£o tem o suficiente de {currency}.");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_LOCKED, "&cBLOQUEADO");
        yml.addDefault(Messages.UPGRADES_LORE_REPLACEMENT_UNLOCKED, "{color}DESBLOQUEADO");
        yml.addDefault(Messages.UPGRADES_UPGRADE_BOUGHT_CHAT, "&a{player} compro &6{upgradeName}");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-1"), "{color}Forja de Ferro");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "forge"),
                Arrays.asList("&Melhore a geraÃƒÂ§ÃƒÂ£o de recursos", "&7na sua base.", "", "{tier_1_color}NÃƒÂ­vel 1: +50% de recursos, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}NÃƒÂ­vel 2: +100% de recursos, &b{tier_2_cost} {tier_2_currency}",
                        "{tier_3_color}NÃƒÂ­vel 3: Gerar esmeraldas, &b{tier_3_cost} {tier_3_currency}",
                        "{tier_4_color}NÃƒÂ­vel 4: +200% de recursos, &b{tier_4_cost} {tier_4_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-2"), "{color}Forja de Ouro");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-3"), "{color}Forja de Esmeralda");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "forge").replace("{tier}", "tier-4"), "{color}Forja Melhorada");
        yml.addDefault(Messages.UPGRADES_CATEGORY_ITEM_NAME_PATH + "traps", "&eCompre uma armadilha");
        yml.addDefault(Messages.UPGRADES_CATEGORY_ITEM_LORE_PATH + "traps", Arrays.asList("&7As armadilhas compradas serÃƒÂ£o", "&7enfileiradas abaixo.", "", "&eClique para navegar!"));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "swords").replace("{tier}", "tier-1"), "{color}Espadas Afiadas");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "swords"),
                Arrays.asList("&7Todas as espadas do seu time irÃƒÂ£o ter o", "&7encantamento AfiaÃƒÂ§ÃƒÂ£o I permanentemente.", "", "{tier_1_color}PreÃƒÂ§o: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-1"), "{color}Armadura ReforÃƒÂ§ada I");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "armor"),
                Arrays.asList("&7Sua equipe ganha permanentemente", "&7proteÃƒÂ§ÃƒÂ£o em toda a armadura!", "", "{tier_1_color}NÃƒÂ­vel 1: ProteÃƒÂ§ÃƒÂ£o I, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}NÃƒÂ­vel 2: ProteÃƒÂ§ÃƒÂ£o II, &b{tier_2_cost} {tier_2_currency}",
                        "{tier_3_color}NÃƒÂ­vel 3: ProteÃƒÂ§ÃƒÂ£o III, &b{tier_3_cost} {tier_3_currency}",
                        "{tier_4_color}NÃƒÂ­vel 4: ProteÃƒÂ§ÃƒÂ£o IV, &b{tier_4_cost} {tier_4_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-2"), "{color}Armadura ReforÃƒÂ§ada II");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-3"), "{color}Armadura ReforÃƒÂ§ada III");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "armor").replace("{tier}", "tier-4"), "{color}Armadura ReforÃƒÂ§ada IV");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "miner").replace("{tier}", "tier-1"), "{color}Minerador ManÃƒÂ­aco I");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "miner"),
                Arrays.asList("&7Todos os jogadores do seu time irÃƒÂ£o", "&7ganhar permanentemente Pressa.", "", "{tier_1_color}NÃƒÂ­vel 1: Pressa I, &b{tier_1_cost} {tier_1_currency}",
                        "{tier_2_color}NÃƒÂ­vel 2: Pressa II, &b{tier_2_cost} {tier_2_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "miner").replace("{tier}", "tier-2"), "{color}Minerador ManÃƒÂ­aco II");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "heal-pool").replace("{tier}", "tier-1"), "{color}RegeneraÃƒÂ§ÃƒÂ£o na Ilha");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "heal-pool"),
                Arrays.asList("&7Cria um campo de regeneraÃƒÂ§ÃƒÂ£o", "&7em torno de sua base!", "", "{tier_1_color}PreÃƒÂ§o: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_NAME.replace("{name}", "dragon").replace("{tier}", "tier-1"), "{color}Buffar DragÃƒÂµes");
        yml.addDefault(Messages.UPGRADES_UPGRADE_TIER_ITEM_LORE.replace("{name}", "dragon"),
                Arrays.asList("&7Sua equipe terÃƒÂ¡ 2 dragÃƒÂµes", "&7em vez de 1 durante o deathmatch!", "", "{tier_1_color}PreÃƒÂ§o: &b{tier_1_cost} {tier_1_currency}", ""));
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + "glass", "&8Ã¢Â¬â€ &7AdquirÃƒÂ­vel");
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + "glass", Collections.singletonList("&8Ã¢Â¬â€¡&7Fila de armadilhas"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "first", "{color}Armadilha #1: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "first", Arrays.asList("&7O primeiro inimigo a andar", "&7em sua base irÃƒÂ¡ acionar", "&7esta armadilha!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "first",
                Arrays.asList("", "&7A compra de uma armadilha", "&7fica nesta fila. Seu custo", "&7serÃƒÂ¡ com base no nÃƒÂºmero", "&7de armadilhas enfileiradas.", "", "&7PrÃƒÂ³xima armadilha: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "second", "{color}Armadilha #2: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "second", Arrays.asList("&7O segundo inimigo a andar", "&7em sua base irÃƒÂ¡ acionar", "&7esta armadilha!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "second",
                Arrays.asList("", "&7A compra de uma armadilha", "&7fica nesta fila. Seu custo", "&7serÃƒÂ¡ com base no nÃƒÂºmero", "&7de armadilhas enfileiradas.", "", "&7PrÃƒÂ³xima armadilha: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_NAME_PATH + "third", "{color}Armadilha #3: {name}");
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE1_PATH + "third", Arrays.asList("&7O terceiro inimigo a andar", "&7em sua base irÃƒÂ¡ acionar", "&7esta armadilha!"));
        yml.addDefault(Messages.UPGRADES_TRAP_SLOT_ITEM_LORE2_PATH + "third",
                Arrays.asList("", "&7A compra de uma armadilha", "&7fica nesta fila. Seu custo", "&7serÃƒÂ¡ com base no nÃƒÂºmero", "&7de armadilhas enfileiradas.", "", "&7PrÃƒÂ³xima armadilha: &b{cost} {currency}"));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "1", "{color}Ãƒâ€° uma armadilha!");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "1", Arrays.asList("&7Isso irÃƒÂ¡ causar cegueira e lentidÃƒÂ£o", "&7durante 5 segundos nos invasores.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "2", "{color}Armadilha Contra-ofensiva");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "2", Arrays.asList("&7Concede Velocidade I por 15 segundos a", "&7jogadores aliados prÃƒÂ³ximos ÃƒÂ  sua base.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "3", "{color}Alarme");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "3", Arrays.asList("&7IrÃƒÂ¡ revelar jogadores invisÃƒÂ­veis,", "&7bem como seu nome e time.", ""));
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_NAME_PATH + "4", "{color}CansaÃƒÂ§o");
        yml.addDefault(Messages.UPGRADES_BASE_TRAP_ITEM_LORE_PATH + "4", Arrays.asList("&7Os inimigos irÃƒÂ£o receber fadiga I ao entrar", "&7na sua base com duraÃƒÂ§ÃƒÂ£o de 10 segundos.", ""));
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_NAME_PATH + "back", "&aVoltar");
        yml.addDefault(Messages.UPGRADES_SEPARATOR_ITEM_LORE_PATH + "back", Collections.singletonList("&7To Upgrades & Traps"));
        yml.addDefault(Messages.UPGRADES_CATEGORY_GUI_NAME_PATH + "traps", "&8Enfileirar uma armadilha");
        yml.addDefault(Messages.UPGRADES_TRAP_QUEUE_LIMIT, "&cFila de armadilhas cheia!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_MSG, "&c&lA armadilha {trap} foi acionada!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_TITLE, "&cARMADILHA ACIONADA!");
        yml.addDefault(Messages.UPGRADES_TRAP_DEFAULT_SUBTITLE, "&fSua {trap} foi acionada!");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_MSG + "3", "&c&lArmadilha de alarme acionada por &7&l{player} &c&ldo time {color}&l{team}&c&l!");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_TITLE + "3", "&c&lALARME!!!");
        yml.addDefault(Messages.UPGRADES_TRAP_CUSTOM_SUBTITLE + "3", "&fAlarme acionado pelo time {color}{team}&f!");
        save();
        setPrefix(m(Messages.PREFIX));
        setPrefixStatic(m(Messages.PREFIX));
    }
}

