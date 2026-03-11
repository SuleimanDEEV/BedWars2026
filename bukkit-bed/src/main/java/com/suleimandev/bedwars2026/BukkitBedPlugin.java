package com.suleimandev.bedwars2026;

import com.suleimandev.bedwars2026.api.arena.IArena;
import com.suleimandev.bedwars2026.api.configuration.ConfigManager;
import com.suleimandev.bedwars2026.api.configuration.ConfigPath;
import com.suleimandev.bedwars2026.api.language.Language;
import com.suleimandev.bedwars2026.api.levels.Level;
import com.suleimandev.bedwars2026.api.party.Party;
import com.suleimandev.bedwars2026.api.server.RestoreAdapter;
import com.suleimandev.bedwars2026.api.server.ServerType;
import com.suleimandev.bedwars2026.api.server.VersionSupport;
import com.suleimandev.bedwars2026.arena.Arena;
import com.suleimandev.bedwars2026.arena.MatchIdGenerator;
import com.suleimandev.bedwars2026.arena.VoidChunkGenerator;
import com.suleimandev.bedwars2026.arena.despawnables.TargetListener;
import com.suleimandev.bedwars2026.arena.feature.SpoilPlayerTNTFeature;
import com.suleimandev.bedwars2026.arena.spectator.SpectatorListeners;
import com.suleimandev.bedwars2026.arena.stats.DefaultStatsHandler;
import com.suleimandev.bedwars2026.arena.tasks.OneTick;
import com.suleimandev.bedwars2026.arena.tasks.Refresh;
import com.suleimandev.bedwars2026.arena.upgrades.BaseListener;
import com.suleimandev.bedwars2026.arena.upgrades.HealPoolListner;
import com.suleimandev.bedwars2026.commands.bedwars.MainCommand;
import com.suleimandev.bedwars2026.commands.leave.LeaveCommand;
import com.suleimandev.bedwars2026.commands.party.PartyCommand;
import com.suleimandev.bedwars2026.commands.rejoin.RejoinCommand;
import com.suleimandev.bedwars2026.commands.shout.ShoutCommand;
import com.suleimandev.bedwars2026.configuration.*;
import com.suleimandev.bedwars2026.database.Database;
import com.suleimandev.bedwars2026.database.SQLite;
import com.suleimandev.bedwars2026.database.MySQL;
import com.suleimandev.bedwars2026.halloween.HalloweenSpecial;
import com.suleimandev.bedwars2026.language.*;
import com.suleimandev.bedwars2026.levels.internal.InternalLevel;
import com.suleimandev.bedwars2026.levels.internal.LevelListeners;
import com.suleimandev.bedwars2026.listeners.*;
import com.suleimandev.bedwars2026.listeners.arenaselector.ArenaSelectorListener;
import com.suleimandev.bedwars2026.listeners.blockstatus.BlockStatusListener;
import com.suleimandev.bedwars2026.listeners.chat.ChatAFK;
import com.suleimandev.bedwars2026.listeners.chat.ChatFormatting;
import com.suleimandev.bedwars2026.listeners.joinhandler.*;
import com.suleimandev.bedwars2026.lobbysocket.ArenaSocket;
import com.suleimandev.bedwars2026.lobbysocket.LoadedUsersCleaner;
import com.suleimandev.bedwars2026.lobbysocket.SendTask;
import com.suleimandev.bedwars2026.maprestore.internal.InternalAdapter;
import com.suleimandev.bedwars2026.metrics.MetricsManager;
import com.suleimandev.bedwars2026.money.internal.MoneyListeners;
import com.suleimandev.bedwars2026.shop.ShopManager;
import com.suleimandev.bedwars2026.sidebar.*;
import com.suleimandev.bedwars2026.sidebar.MatchSidebarService;
import com.suleimandev.bedwars2026.stats.StatsManager;
import com.suleimandev.bedwars2026.support.citizens.CitizensListener;
import com.suleimandev.bedwars2026.support.citizens.JoinNPC;
import com.suleimandev.bedwars2026.support.papi.PAPISupport;
import com.suleimandev.bedwars2026.support.papi.SupportPAPI;
import com.suleimandev.bedwars2026.support.party.NoParty;
import com.suleimandev.bedwars2026.support.preloadedparty.PrePartyListener;
import com.suleimandev.bedwars2026.support.vault.*;
import com.suleimandev.bedwars2026.party.config.PartyFeaturesConfig;
import com.suleimandev.bedwars2026.party.listener.PartyChatListener;
import com.suleimandev.bedwars2026.party.service.BedWarsPartyService;
import com.suleimandev.bedwars2026.upgrades.UpgradesManager;
import com.suleimandev.bedwars2026.vip.config.VipFeaturesConfig;
import com.suleimandev.bedwars2026.vip.service.VipFeatureService;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/*
 * BedWars2026
 * Copyright (c) 2026 SuleimanDEV
 *
 * Unauthorized copying of this file, via any medium
 * is strictly prohibited.
 *
 * Proprietary and confidential.
 */

@SuppressWarnings({"WeakerAccess", "CallToPrintStackTrace", "unchecked", "deprecation"})
public class BukkitBedPlugin extends JavaPlugin {

    private static ServerType serverType = ServerType.MULTIARENA;
    public static boolean debug = true, autoscale = false;
    public static String mainCmd = "bw", link = "https://example.com/bedwars2026";
    public static ConfigManager signs, generators;
    public static MainConfig config;
    public static PartyFeaturesConfig partyFeatures;
    public static VipFeaturesConfig vipFeaturesConfig;
    public static VipFeatureService vipFeatures;
    public static ShopManager shop;
    public static StatsManager statsManager;
    public static BukkitBedPlugin plugin;
    public static VersionSupport nms;

    public static boolean isPaper = false;

    private static Party party = new NoParty();
    private static Chat chat = new NoChat();
    protected static Level level;
    private static Economy economy;
    private static final String version = Bukkit.getServer().getClass().getName().split("\\.")[3];
    private static String lobbyWorld = "";
    private static boolean shuttingDown = false;

    public static MatchIdGenerator matchIdGenerator = new MatchIdGenerator();

    //remote database
    private static Database remoteDatabase;

    private boolean serverSoftwareSupport = true;

    private static com.suleimandev.bedwars2026.api.CommonsBedApi api;

    @Override
    public void onLoad() {

        //Spigot support
        try {
            Class.forName("org.spigotmc.SpigotConfig");
        } catch (Exception ignored) {
            this.getLogger().severe("I can't run on your server software. Please check:");
            this.getLogger().severe("BEDWARS 2026 could not find a compatible version support module for this server.");
            serverSoftwareSupport = false;
            return;
        }

        try {
            Class.forName("com.destroystokyo.paper.PaperConfig");
            isPaper = true;
        } catch (ClassNotFoundException e) {
            isPaper = false;
        }

        plugin = this;

        /* Load version support */
        //noinspection rawtypes
        Class supp;

        try {
            supp = Class.forName("com.suleimandev.bedwars2026.support.version." + version + "." + version);
        } catch (ClassNotFoundException e) {
            serverSoftwareSupport = false;
            this.getLogger().severe("I can't run on your version: " + version);
            return;
        }

        api = new BukkitBedApi();
        Bukkit.getServicesManager().register(com.suleimandev.bedwars2026.api.CommonsBedApi.class, api, this, ServicePriority.Highest);

        try {
            //noinspection unchecked
            nms = (VersionSupport) supp.getConstructor(Class.forName("org.bukkit.plugin.Plugin"), String.class).newInstance(this, version);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 ClassNotFoundException e) {
            e.printStackTrace();
            serverSoftwareSupport = false;
            this.getLogger().severe("Could not load support for server version: " + version);
            return;
        }

        this.getLogger().info("Loading support for paper/spigot: " + version);

        // Setup languages
        new English();
        new Romanian();
        new Italian();
        new Polish();
        new Spanish();
        new Russian();
        new Bangla();
        new Persian();
        new Hindi();
        new Indonesia();
        new Portuguese();
        new SimplifiedChinese();
        new Turkish();

        config = new MainConfig(this, "config");
        partyFeatures = new PartyFeaturesConfig(this);
        vipFeaturesConfig = new VipFeaturesConfig(this);

        generators = new GeneratorsConfig(this, "generators", this.getDataFolder().getPath());
        // Initialize signs config after the main config
        if (getServerType() != ServerType.BUNGEE) {
            signs = new SignsConfig(this, "signs", this.getDataFolder().getPath());
        }
    }

    @Override
    @SuppressWarnings("removal")
    public void onEnable() {
        if (!serverSoftwareSupport) {
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        nms.registerVersionListeners();

        if (!this.handleWorldAdapter()) {
            api.setRestoreAdapter(new InternalAdapter(this));
            getLogger().info("Using internal world restore system.");
        }

        /* Register commands */
        nms.registerCommand(mainCmd, new MainCommand(mainCmd));

        // newer versions do not seem to like delayed registration of commands
        if (nms.getVersion() >= 9) {
            this.registerDelayedCommands();
        } else {
            Bukkit.getScheduler().runTaskLater(this, this::registerDelayedCommands, 20L);
        }

        /* Setup plugin messaging channel */
        Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        // define logger
        java.util.logging.Logger out = plugin.getLogger();

        /* Check if lobby location is set. Required for non Bungee servers */
        if (config.getLobbyWorldName().isEmpty() && serverType != ServerType.BUNGEE) {
            out.log(java.util.logging.Level.WARNING, "Lobby location is not set!");
        }

        /* Load lobby world if not main level
         * when the server finishes loading. */
        if (getServerType() == ServerType.MULTIARENA)
            Bukkit.getScheduler().runTaskLater(this, () -> {
                if (!config.getLobbyWorldName().isEmpty()) {
                    if (Bukkit.getWorld(config.getLobbyWorldName()) == null && new File(Bukkit.getWorldContainer(), config.getLobbyWorldName() + "/level.dat").exists()) {
                        if (!config.getLobbyWorldName().equalsIgnoreCase(Bukkit.getServer().getWorlds().get(0).getName())) {
                            Bukkit.getScheduler().runTaskLater(this, () -> {
                                Bukkit.createWorld(new WorldCreator(config.getLobbyWorldName()));

                                if (Bukkit.getWorld(config.getLobbyWorldName()) != null) {
                                    Bukkit.getScheduler().runTaskLater(plugin, () -> Objects.requireNonNull(Bukkit.getWorld(config.getLobbyWorldName()))
                                            .getEntities().stream().filter(e -> e instanceof Monster).forEach(Entity::remove), 20L);
                                }
                            }, 100L);
                        }
                    }
                    Location l = config.getConfigLoc("lobbyLoc");
                    if (l != null) {
                        World w = Bukkit.getWorld(config.getLobbyWorldName());
                        if (w != null) {
                            w.setSpawnLocation(l.getBlockX(), l.getBlockY(), l.getBlockZ());
                        }
                    }
                }
            }, 1L);

        // Register events
        registerEvents(
                new EnderPearlLanded(), new QuitAndTeleportListener(), new BreakPlace(), new DamageDeathMove(),
                new Inventory(), new Interact(), new RefreshGUI(), new HungerWeatherSpawn(), new CmdProcess(),
                new FireballListener(), new EggBridge(), new SpectatorListeners(), new BaseListener(),
                new TargetListener(), new LangListener(), new Warnings(this), new ChatAFK(),
                new GameEndListener(), new DefaultStatsHandler()
        );

        if (config.getBoolean(ConfigPath.GENERAL_CONFIGURATION_HEAL_POOL_ENABLE)) {
            registerEvents(new HealPoolListner());
        }

        if (getServerType() == ServerType.BUNGEE) {
            if (autoscale) {
                //registerEvents(new ArenaListeners());
                ArenaSocket.lobbies.addAll(config.getList(ConfigPath.GENERAL_CONFIGURATION_BUNGEE_OPTION_LOBBY_SERVERS));
                new SendTask();
                registerEvents(new AutoscaleListener(), new PrePartyListener(), new JoinListenerBungee());
                Bukkit.getScheduler().runTaskTimerAsynchronously(this, new LoadedUsersCleaner(), 60L, 60L);
            } else {
                registerEvents(new ServerPingListener(), new JoinListenerBungeeLegacy());
            }
        } else if (getServerType() == ServerType.MULTIARENA || getServerType() == ServerType.SHARED) {
            registerEvents(new ArenaSelectorListener(), new BlockStatusListener());
            if (getServerType() == ServerType.MULTIARENA) {
                registerEvents(new JoinListenerMultiArena());
            } else {
                registerEvents(new JoinListenerShared());
            }
        }

        registerEvents(new WorldLoadListener());

        if (!(getServerType() == ServerType.BUNGEE && autoscale)) {
            registerEvents(new JoinHandlerCommon());
        }

        // Register setup-holograms fix
        registerEvents(new ChunkLoad());

        registerEvents(new InvisibilityPotionListener());

        /* Load join signs. */
        loadArenasAndSigns();

        statsManager = new StatsManager();

        if (config.getYml().getBoolean(ConfigPath.GENERAL_CONFIGURATION_ALLOW_PARTIES)) {
            party = new BedWarsPartyService(partyFeatures);
            registerEvents(new PartyChatListener());
            out.info("Loading internal BEDWARS 2026 party service.");
        } else {
            party = new NoParty();
        }

        vipFeatures = new VipFeatureService(vipFeaturesConfig);
        out.info("Loading internal BEDWARS 2026 VIP feature service.");

        /* Levels support */
        setLevelAdapter(new InternalLevel());

        /* Register tasks */
        Bukkit.getScheduler().runTaskTimer(this, new Refresh(), 20L, 20L);
        //new Refresh().runTaskTimer(this, 20L, 20L);

        if (config.getBoolean(ConfigPath.GENERAL_CONFIGURATION_PERFORMANCE_ROTATE_GEN)) {
            //new OneTick().runTaskTimer(this, 120, 1);
            Bukkit.getScheduler().runTaskTimer(this, new OneTick(), 120, 1);
        }

        /* Register NMS entities */
        nms.registerEntities();

        /* Database support */
        if (config.getBoolean("database.enable")) {
            MySQL mySQL = new MySQL();
            long time = System.currentTimeMillis();
            if (!mySQL.connect()) {
                this.getLogger().severe("Could not connect to database! Please verify your credentials and make sure that the server IP is whitelisted in MySQL.");
                remoteDatabase = new SQLite();
            } else {
                remoteDatabase = mySQL;
            }
            if (System.currentTimeMillis() - time >= 5000) {
                this.getLogger().severe("It took " + ((System.currentTimeMillis() - time) / 1000) + " ms to establish a database connection!\n" +
                        "Using this remote connection is not recommended!");
            }
            remoteDatabase.init();
        } else {
            remoteDatabase = new SQLite();
            remoteDatabase.init();
        }

        /* Citizens support */
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            if (this.getServer().getPluginManager().getPlugin("Citizens") != null) {
                JoinNPC.setCitizensSupport(true);
                out.info("Hook into Citizens support. /bw npc");
                registerEvents(new CitizensListener());
            }

            //spawn NPCs
            try {
                JoinNPC.spawnNPCs();
            } catch (Exception e) {
                this.getLogger().severe("Could not spawn CmdJoin NPCs. Make sure you have right version of Citizens for your server!");
                JoinNPC.setCitizensSupport(false);
            }
        }, 5L);

        /* Save messages for stats gui items if custom items added, for each language */
        Language.setupCustomStatsMessages();

        /* PlaceholderAPI Support */
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            out.info("Hooked into PlaceholderAPI support!");
            new PAPISupport().register();
            SupportPAPI.setSupportPAPI(new SupportPAPI.withPAPI());
        }
        /*
         * Vault support
         * The task is to initialize after all plugins have loaded,
         *  to make sure any economy/chat plugins have been loaded and registered.
         */
        Bukkit.getScheduler().runTask(this, () -> {
            if (this.getServer().getPluginManager().getPlugin("Vault") != null) {
                try {
                    //noinspection rawtypes
                    RegisteredServiceProvider rsp = this.getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
                    if (rsp != null) {
                        WithChat.setChat((net.milkbowl.vault.chat.Chat) rsp.getProvider());
                        plugin.getLogger().info("Hooked into vault chat support!");
                        chat = new WithChat();
                    } else {
                        plugin.getLogger().info("Vault found, but no chat provider!");
                        chat = new NoChat();
                    }
                } catch (Exception var2_2) {
                    chat = new NoChat();
                }
                try {
                    registerEvents(new MoneyListeners());
                    RegisteredServiceProvider<net.milkbowl.vault.economy.Economy> rsp = this.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
                    if (rsp != null) {
                        WithEconomy.setEconomy(rsp.getProvider());
                        plugin.getLogger().info("Hooked into vault economy support!");
                        economy = new WithEconomy();
                    } else {
                        plugin.getLogger().info("Vault found, but no economy provider!");
                        economy = new NoEconomy();
                    }
                } catch (Exception var2_2) {
                    economy = new NoEconomy();
                }
            } else {
                chat = new NoChat();
                economy = new NoEconomy();
            }
        });

        /* Chat support */
        if (config.getBoolean(ConfigPath.GENERAL_CHAT_FORMATTING)) {
            registerEvents(new ChatFormatting());
        }

        /* Protect glass walls from tnt explosion */
        nms.registerTntWhitelist(
                (float) config.getDouble(ConfigPath.GENERAL_TNT_PROTECTION_END_STONE_BLAST),
                (float) config.getDouble(ConfigPath.GENERAL_TNT_PROTECTION_GLASS_BLAST)
        );

        /* Prevent issues on reload */
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.kickPlayer("BEDWARS 2026 was reloaded. Restart the server instead of reloading plugins.");
        }

        /* Load sounds configuration */
        Sounds.init();

        /* Initialize shop */
        shop = new ShopManager();

        //Leave this code at the end of the enable method
        for (Language l : Language.getLanguages()) {
            l.setupUnSetCategories();
            Language.addDefaultMessagesCommandItems(l);
        }

        LevelsConfig.init();

        /* Load Money Configuration */
        MoneyConfig.init();

        // bStats metrics
        MetricsManager.initService(this);

        Bukkit.getScheduler().runTaskLater(this,
                () -> out.info("This server is running in " + getServerType() + " with auto-scale " + autoscale),
                100L
        );

        // Initialize team upgrades
        UpgradesManager.init();

        // Initialize sidebar manager
        if (MatchSidebarService.init(this)) {
            out.info("Initializing BEDWARS 2026 internal sidebar engine.");
        } else {
            this.getLogger().severe("BEDWARS 2026 internal sidebar engine could not be initialized.");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        // Halloween Special
        HalloweenSpecial.init();

        // TNT Spoil Feature
        SpoilPlayerTNTFeature.init();

        // Warn user if current server version support is deprecated
        this.performDeprecationCheck();
    }

    /**
     * Try loading custom adapter support.
     *
     * @return true when custom adapter was registered.
     */
    private boolean handleWorldAdapter() {
        Plugin swmPlugin = Bukkit.getPluginManager().getPlugin("SlimeWorldManager");

        if (null == swmPlugin) {
            return false;
        }
        PluginDescriptionFile pluginDescription = swmPlugin.getDescription();
        if (null == pluginDescription) {
            return false;
        }

        String[] versionString = pluginDescription.getVersion().split("\\.");


        try {
            int major = Integer.parseInt(versionString[0]);
            int minor = Integer.parseInt(versionString[1]);
            int release = versionString.length > 2 ? Integer.parseInt(versionString[2]) : 0;

            String adapterPath;
            if (major == 2 && minor == 2 && release == 1) {
                adapterPath = "com.suleimandev.bedwars2026.arena.mapreset.slime.SlimeAdapter";
            } else if (major == 2 && minor == 8 && release == 0) {
                adapterPath = "com.suleimandev.bedwars2026.arena.mapreset.slime.AdvancedSlimeAdapter";
            } else if (major > 2 || major == 2 && minor >= 10) {
                adapterPath = "com.suleimandev.bedwars2026.arena.mapreset.slime.SlimePaperAdapter";
            } else {
                return false;
            }

            Constructor<?> constructor = Class.forName(adapterPath).getConstructor(Plugin.class);
            getLogger().info("Loading restore adapter: " + adapterPath + " ...");

            RestoreAdapter candidate = (RestoreAdapter) constructor.newInstance(this);
            api.setRestoreAdapter(candidate);
            getLogger().info("Hook into " + candidate.getDisplayName() + " as restore adapter.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.getLogger().info("Something went wrong! Using internal reset adapter...");
        }
        return false;
    }

    private void registerDelayedCommands() {
        if (!nms.isBukkitCommandRegistered("shout")) {
            nms.registerCommand("shout", new ShoutCommand("shout"));
        }
        nms.registerCommand("rejoin", new RejoinCommand("rejoin"));
        if (!(nms.isBukkitCommandRegistered("leave") && getServerType() == ServerType.BUNGEE)) {
            nms.registerCommand("leave", new LeaveCommand("leave"));
        }
        if (getServerType() != ServerType.BUNGEE && config.getBoolean(ConfigPath.GENERAL_ENABLE_PARTY_CMD)) {
            Bukkit.getLogger().info("Registering /party command..");
            nms.registerCommand("party", new PartyCommand("party"));
        }
    }

    public void onDisable() {
        shuttingDown = true;
        if (!serverSoftwareSupport) return;
        if (getServerType() == ServerType.BUNGEE) {
            ArenaSocket.disable();
        }
        for (IArena a : new LinkedList<>(Arena.getArenas())) {
            try {
                a.disable();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private void loadArenasAndSigns() {

        api.getRestoreAdapter().convertWorlds();

        File dir = new File(plugin.getDataFolder(), "/Arenas");
        if (dir.exists()) {
            List<File> files = new ArrayList<>();
            File[] fls = dir.listFiles();
            for (File fl : Objects.requireNonNull(fls)) {
                if (fl.isFile()) {
                    if (fl.getName().endsWith(".yml")) {
                        files.add(fl);
                    }
                }
            }

            if (serverType == ServerType.BUNGEE && !autoscale) {
                if (files.isEmpty()) {
                    this.getLogger().log(java.util.logging.Level.WARNING, "Could not find any arena!");
                    return;
                }
                Random r = new Random();
                int x = r.nextInt(files.size());
                String name = files.get(x).getName().replace(".yml", "");
                new Arena(name, null);
            } else {
                for (File file : files) {
                    new Arena(file.getName().replace(".yml", ""), null);
                }
            }
        }
    }

    public static void registerEvents(Listener... listeners) {
        Arrays.stream(listeners).forEach(l -> plugin.getServer().getPluginManager().registerEvents(l, plugin));
    }

    public static void setDebug(boolean value) {
        debug = value;
    }

    public static void setServerType(ServerType serverType) {
        BukkitBedPlugin.serverType = serverType;
        if (serverType == ServerType.BUNGEE) autoscale = true;
    }

    public static void setAutoscale(boolean autoscale) {
        BukkitBedPlugin.autoscale = autoscale;
    }

    public static void debug(String message) {
        if (debug) {
            plugin.getLogger().info("DEBUG: " + message);
        }
    }

    public static String getForCurrentVersion(String v18, String v12, String v13) {
        switch (getServerVersion()) {
            case "v1_8_R3":
                return v18;
            case "v1_12_R1":
                return v12;
        }
        return v13;
    }

    public static ServerType getServerType() {
        return serverType;
    }

    public static Party getParty() {
        return party;
    }

    public static Chat getChatSupport() {
        return chat;
    }

    /**
     * Get current levels manager.
     */
    public static Level getLevelSupport() {
        return level;
    }

    /**
     * Set the levels manager.
     * You can use this to add your own levels manager just implement
     * the Level interface so the plugin will be able to display
     * the level internally.
     */

    public static void setLevelAdapter(Level levelsManager) {
        if (levelsManager instanceof InternalLevel) {
            if (LevelListeners.instance == null) {
                Bukkit.getPluginManager().registerEvents(new LevelListeners(), BukkitBedPlugin.plugin);
            }
        } else {
            if (LevelListeners.instance != null) {
                PlayerJoinEvent.getHandlerList().unregister(LevelListeners.instance);
                PlayerQuitEvent.getHandlerList().unregister(LevelListeners.instance);
                LevelListeners.instance = null;
            }
        }
        level = levelsManager;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static ConfigManager getGeneratorsCfg() {
        return generators;
    }

    public static void setLobbyWorld(String lobbyWorld) {
        BukkitBedPlugin.lobbyWorld = lobbyWorld;
    }

    /**
     * Get the server version
     * Ex: v1_8_R3
     *
     * @since v0.6.5beta
     */
    public static String getServerVersion() {
        return version;
    }

    public static String getLobbyWorld() {
        return lobbyWorld;
    }

    /**
     * Get remote database.
     */
    public static Database getRemoteDatabase() {
        return remoteDatabase;
    }

    public static StatsManager getStatsManager() {
        return statsManager;
    }

    public static com.suleimandev.bedwars2026.api.CommonsBedApi getAPI() {
        return api;
    }

    public static boolean isShuttingDown() {
        return shuttingDown;
    }

    public static void setParty(Party party) {
        BukkitBedPlugin.party = party;
    }

    public void performDeprecationCheck() {
        Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
            if (Arrays.stream(nms.getClass().getAnnotations()).anyMatch(annotation -> annotation instanceof Deprecated)) {
                this.getLogger().warning("Support for "+getServerVersion()+" is scheduled for removal. " +
                        "Please consider upgrading your server software to a newer Minecraft version.");
            }
        });
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new VoidChunkGenerator();
    }
}

