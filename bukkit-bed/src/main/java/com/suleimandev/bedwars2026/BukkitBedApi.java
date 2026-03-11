package com.suleimandev.bedwars2026;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.arena.shop.IContentTier;
import com.suleimandev.bedwars2026.api.command.ParentCommand;
import com.suleimandev.bedwars2026.api.configuration.ConfigManager;
import com.suleimandev.bedwars2026.api.events.player.PlayerAfkEvent;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.party.Party;
import com.suleimandev.bedwars2026.api.server.ISetupSession;
import com.suleimandev.bedwars2026.api.server.RestoreAdapter;
import com.suleimandev.bedwars2026.api.server.ServerType;
import com.suleimandev.bedwars2026.api.server.VersionSupport;
import com.suleimandev.bedwars2026.api.sidebar.ISidebarService;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.SetupSession;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import com.suleimandev.bedwars2026.shop.main.CategoryContent;
import com.suleimandev.bedwars2026.sidebar.MatchSidebarService;
import com.suleimandev.bedwars2026.stats.StatsAPI;
import com.suleimandev.bedwars2026.upgrades.UpgradesManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;
import java.util.logging.Level;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

public class BukkitBedApi implements com.suleimandev.bedwars2026.api.CommonsBedApi {

    private static RestoreAdapter restoreAdapter;
    private final AFKUtil afkSystem = new AFKUtil() {
        private final HashMap<UUID, Integer> afkPlayers = new HashMap<>();

        @Override
        public boolean isPlayerAFK(Player player) {
            return afkPlayers.containsKey(player.getUniqueId());
        }

        @Override
        public void setPlayerAFK(Player player, boolean value) {
            if (value) {
                if (!afkPlayers.containsKey(player.getUniqueId())) {
                    afkPlayers.put(player.getUniqueId(), Arena.afkCheck.get(player.getUniqueId()));
                    Bukkit.getPluginManager().callEvent(new PlayerAfkEvent(player, PlayerAfkEvent.AFKType.START));
                }
            } else {
                if (afkPlayers.containsKey(player.getUniqueId())) {
                    afkPlayers.remove(player.getUniqueId());
                    Bukkit.getPluginManager().callEvent(new PlayerAfkEvent(player, PlayerAfkEvent.AFKType.END));
                }
                Arena.afkCheck.remove(player.getUniqueId());
            }
        }

        @Override
        public int getPlayerTimeAFK(Player player) {
            return afkPlayers.getOrDefault(player.getUniqueId(), 0);
        }
    };

    private final ArenaUtil arenaUtil = new ArenaUtil() {
        @Override
        public boolean canAutoScale(String arenaName) {
            return Arena.canAutoScale(arenaName);
        }

        @Override
        public void addToEnableQueue(IArena a) {
            Arena.addToEnableQueue(a);
        }

        @Override
        public void removeFromEnableQueue(IArena a) {
            Arena.removeFromEnableQueue(a);
        }

        @Override
        public boolean isPlaying(Player p) {
            return Arena.isInArena(p) && Arena.getArenaByPlayer(p).isPlayer(p);
        }

        @Override
        public boolean isSpectating(Player p) {
            return Arena.isInArena(p) && Arena.getArenaByPlayer(p).isSpectator(p);
        }

        @Override
        public void loadArena(String worldName, Player sender) {
            new Arena(worldName, sender);
        }

        @Override
        public void setGamesBeforeRestart(int games) {
            Arena.setGamesBeforeRestart(games);
        }

        @Override
        public int getGamesBeforeRestart() {
            return Arena.getGamesBeforeRestart();
        }

        @Override
        public IArena getArenaByPlayer(Player player) {
            return Arena.getArenaByPlayer(player);
        }

        @Override
        public void setArenaByPlayer(Player p, IArena arena) {
            Arena.setArenaByPlayer(p, arena);
        }

        @Override
        public void removeArenaByPlayer(Player p, IArena a) {
            Arena.removeArenaByPlayer(p, a);
        }

        @Override
        public IArena getArenaByName(String worldName) {
            return Arena.getArenaByName(worldName);
        }

        @Override
        public IArena getArenaByIdentifier(String worldName) {
            return Arena.getArenaByIdentifier(worldName);
        }

        @Override
        public void setArenaByName(IArena arena) {
            Arena.setArenaByName(arena);
        }

        @Override
        public void removeArenaByName(String worldName) {
            Arena.removeArenaByName(worldName);
        }

        @Override
        public LinkedList<IArena> getArenas() {
            return Arena.getArenas();
        }

        @Override
        public boolean vipJoin(Player p) {
            return Arena.isVip(p);
        }

        @Override
        public int getPlayers(String group) {
            return Arena.getPlayers(group);
        }

        @Override
        public boolean joinRandomArena(Player p) {
            return Arena.joinRandomArena(p);
        }

        @Override
        public boolean joinRandomFromGroup(Player p, String group) {
            return Arena.joinRandomFromGroup(p, group);
        }

        @Override
        public LinkedList<IArena> getEnableQueue() {
            return Arena.getEnableQueue();
        }

        @Override
        public void sendLobbyCommandItems(Player p) {
            Arena.sendLobbyCommandItems(p);
        }
    };

    private final Configs configs = new Configs() {
        @Override
        public ConfigManager getMainConfig() {
            return BukkitBedPlugin.config;
        }

        @Override
        public ConfigManager getSignsConfig() {
            return BukkitBedPlugin.signs;
        }

        @Override
        public ConfigManager getGeneratorsConfig() {
            return BukkitBedPlugin.generators;
        }

        @Override
        public ConfigManager getShopConfig() {
            return BukkitBedPlugin.shop;
        }

        @Override
        public ConfigManager getUpgradesConfig() {
            return UpgradesManager.getConfiguration();
        }
    };

    private final ShopUtil shopUtil = new ShopUtil() {
        @Override
        public int calculateMoney(Player player, Material currency) {
            return CategoryContent.calculateMoney(player, currency);
        }

        @Override
        public Material getCurrency(String currency) {
            return CategoryContent.getCurrency(currency);
        }

        @Override
        public ChatColor getCurrencyColor(Material currency) {
            return CategoryContent.getCurrencyColor(currency);
        }

        @Override
        public String getCurrencyMsgPath(IContentTier contentTier) {
            return CategoryContent.getCurrencyMsgPath(contentTier);
        }

        @Override
        public String getRomanNumber(int n) {
            return CategoryContent.getRomanNumber(n);
        }

        @Override
        public void takeMoney(Player player, Material currency, int amount) {
            CategoryContent.takeMoney(player, currency, amount);
        }
    };

    @Override
    public IStats getStatsUtil() {
        return StatsAPI.getInstance();
    }

    @Override
    public AFKUtil getAFKUtil() {
        return afkSystem;
    }

    @Override
    public ArenaUtil getArenaUtil() {
        return arenaUtil;
    }

    @Override
    public Configs getConfigs() {
        return configs;
    }

    @Override
    public ShopUtil getShopUtil() {
        return shopUtil;
    }

    private final TeamUpgradesUtil teamUpgradesUtil = new TeamUpgradesUtil() {
        @Override
        public boolean isWatchingGUI(Player player) {
            return UpgradesManager.isWatchingUpgrades(player.getUniqueId());
        }

        @Override
        public void setWatchingGUI(Player player) {
            UpgradesManager.setWatchingUpgrades(player.getUniqueId());
        }

        @Override
        public void removeWatchingUpgrades(UUID uuid) {
            UpgradesManager.removeWatchingUpgrades(uuid);
        }

        @Override
        public int getTotalUpgradeTiers(IArena arena) {
            return UpgradesManager.getMenuForArena(arena).countTiers();
        }
    };

    @Override
    public TeamUpgradesUtil getTeamUpgradesUtil() {
        return teamUpgradesUtil;
    }

    @Override
    public com.suleimandev.bedwars2026.api.levels.Level getLevelsUtil() {
        return BukkitBedPlugin.getLevelSupport();
    }

    @Override
    public Party getPartyUtil() {
        return BukkitBedPlugin.getParty();
    }

    @Override
    public ISetupSession getSetupSession(UUID player) {
        return SetupSession.getSession(player);
    }

    @Override
    public boolean isInSetupSession(UUID player) {
        return SetupSession.isInSetupSession(player);
    }

    @Override
    public ServerType getServerType() {
        return BukkitBedPlugin.getServerType();
    }

    @Override
    public ParentCommand getBedWarsCommand() {
        return MainCommand.getInstance();
    }

    @Override
    public RestoreAdapter getRestoreAdapter() {
        return restoreAdapter;
    }

    @Override
    public void setRestoreAdapter(RestoreAdapter adapter) throws IllegalAccessError {
        if (!Arena.getArenas().isEmpty()) {
            throw new IllegalAccessError("Arenas must be unloaded when changing the adapter");
        }
        restoreAdapter = adapter;
        if (adapter.getOwner() != null) {
            if (adapter.getOwner() != BukkitBedPlugin.plugin) {
                BukkitBedPlugin.plugin.getLogger().log(Level.WARNING, adapter.getOwner().getName() + " changed the restore system to its own adapter.");
            }
        }
    }

    @Override
    public void setPartyAdapter(Party partyAdapter) throws IllegalAccessError {
        if (partyAdapter == null) return;
        if (partyAdapter.equals(BukkitBedPlugin.getParty())) return;
        BukkitBedPlugin.setParty(partyAdapter);
        BukkitBedPlugin.plugin.getLogger().log(Level.WARNING,  "One of your plugins changed the Party adapter to: " + partyAdapter.getClass().getName());
    }

    @Override
    public VersionSupport getVersionSupport() {
        return BukkitBedPlugin.nms;
    }

    @Override
    public Language getDefaultLang() {
        return Language.getDefaultLanguage();
    }

    @Override
    public String getLobbyWorld() {
        return BukkitBedPlugin.getLobbyWorld();
    }

    @Override
    public String getForCurrentVersion(String v18, String v12, String v13) {
        return BukkitBedPlugin.getForCurrentVersion(v18, v12, v13);
    }

    @Override
    public void setLevelAdapter(com.suleimandev.bedwars2026.api.levels.Level level) {
        BukkitBedPlugin.setLevelAdapter(level);
    }

    @Override
    public boolean isAutoScale() {
        return BukkitBedPlugin.autoscale;
    }

    @Override
    public Language getLanguageByIso(String isoCode) {
        return Language.getLang(isoCode);
    }

    @Override
    public Language getPlayerLanguage(Player player) {
        return Language.getPlayerLanguage(player);
    }

    @Override
    public String getLangIso(Player p) {
        return Language.getPlayerLanguage(p).getIso();
    }

    @Override
    public File getAddonsPath() {
        return new File(BukkitBedPlugin.plugin.getDataFolder(), "Addons");
    }


    private static final ScoreboardUtil scoreboardUtil = new ScoreboardUtil() {

        @Override
        public void removePlayerScoreboard(Player player) {
            MatchSidebarService.getInstance().remove(player);
        }

        @Override
        public void givePlayerScoreboard(@NotNull Player player, boolean delay) {
            MatchSidebarService.getInstance().giveSidebar(player, Arena.getArenaByPlayer(player), delay);
        }
    };

    @Override
    public ScoreboardUtil getScoreboardUtil() {
        return scoreboardUtil;
    }

    @Override
    public boolean isShuttingDown() {
        return BukkitBedPlugin.isShuttingDown();
    }

    @Override
    public ISidebarService getScoreboardManager() {
        return MatchSidebarService.getInstance();
    }
}

