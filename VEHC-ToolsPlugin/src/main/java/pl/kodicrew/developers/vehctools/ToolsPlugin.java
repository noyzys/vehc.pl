package pl.kodicrew.developers.vehctools;

import com.sun.scenario.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import pl.kodicrew.developers.vehctools.apies.managers.RegisterManager;
import pl.kodicrew.developers.vehctools.commands.admin.*;
import pl.kodicrew.developers.vehctools.commands.user.*;
import pl.kodicrew.developers.vehctools.configuration.managers.Configuration;
import pl.kodicrew.developers.vehctools.configuration.managers.ConfigurationManager;
import pl.kodicrew.developers.vehctools.creators.PremiumCaseManagerCreator;
import pl.kodicrew.developers.vehctools.events.actions.PlayerJoinQuitListener;
import pl.kodicrew.developers.vehctools.events.blocks.BlockPlaceListener;
import pl.kodicrew.developers.vehctools.events.entites.EntityDeathListener;
import pl.kodicrew.developers.vehctools.events.interacts.PlayerInteractListener;
import pl.kodicrew.developers.vehctools.events.inventories.InventoryListener;
import pl.kodicrew.developers.vehctools.impl.*;
import pl.kodicrew.developers.vehctools.impl.managers.*;
import pl.kodicrew.developers.vehctools.inventories.BossDropInventory;
import pl.kodicrew.developers.vehctools.inventories.CraftingInventory;
import pl.kodicrew.developers.vehctools.inventories.EffectsInventory;
import pl.kodicrew.developers.vehctools.task.BossRespawnTask;

import java.io.File;

public class ToolsPlugin extends JavaPlugin {

    // KONFIGURACJA

    private Configuration settings = ConfigurationManager.create(new File(this.getDataFolder(), "config.yml"), Settings.class);

    //MANAGERY

    private RegisterManager registers = new RegisterManager(this);
    private GameModeManager gameModeManager = new GameModeManagerImpl();
    private CooldownManagerImpl cooldownManager = new CooldownManagerImpl();
    private PremiumCaseManagerCreator premiumCaseManagerCreator = new PremiumCaseManagerCreator();
    private PremiumCaseManager premiumCaseManager = new PremiumCaseManagerImpl();
    private RandomTeleportManager randomTeleportManager = new RandomTeleportManagerImpl();
    private BossManager bossManager = new BossManagerImpl();
    private UserManager userManager = new UserManagerImpl();

    // INVENTORY

    private CraftingInventory craftingInventory;
    private BossDropInventory bossDropInventory;
    private EffectsInventory effectsInventory;

    @Override
    public void onLoad() {
        this.getLogger().info("ladowanie");
    }

    @Override
    public void onEnable() {

        // ENABLES

        this.onLoad();
        this.registerCommands();
        this.registerEvents();
        this.registerTask();
        this.loadManagers();

        // IMPLEMENTS

        this.registers = new RegisterManager(this);
        this.gameModeManager = new GameModeManagerImpl();
        this.cooldownManager = new CooldownManagerImpl();
        this.craftingInventory = new CraftingInventory(this);
        this.premiumCaseManagerCreator = new PremiumCaseManagerCreator();
        this.premiumCaseManager = new PremiumCaseManagerImpl();
        this.randomTeleportManager = new RandomTeleportManagerImpl();
        this.bossManager = new BossManagerImpl();
        this.bossDropInventory = new BossDropInventory(this);
        this.userManager = new UserManagerImpl();
        this.effectsInventory = new EffectsInventory(this);

        // CONFIGURATIONS
        if (!this.getDataFolder().exists()) this.getDataFolder().mkdir();
        this.getLogger().info("zaladowano");
    }

    public void registerCommands() {

        // admin
        this.registers.registerCommands(new BroadCastCommand());
        this.registers.registerCommands(new ItemShopCommand(this));
        this.registers.registerCommands(new ChatComamnd());
        this.registers.registerCommands(new ClearCommand());
        this.registers.registerCommands(new FlyCommand());
        this.registers.registerCommands(new GameModeCommand());
        this.registers.registerCommands(new MoreCommand());
        this.registers.registerCommands(new TphereCommand());
        this.registers.registerCommands(new TimeCommand());
        this.registers.registerCommands(new TpposCommand());
        this.registers.registerCommands(new RenameCommand());
        this.registers.registerCommands(new InvseeCommand());
        this.registers.registerCommands(new TeleportCommand());
        this.registers.registerCommands(new HealCommand());
        this.registers.registerCommands(new GiveRankCommand());
        this.registers.registerCommands(new GiveYouTuberCommand());
        this.registers.registerCommands(new KickCommand());
        this.registers.registerCommands(new TpallCommand());
        this.registers.registerCommands(new CDICommand());
        this.registers.registerCommands(new GodModeCommand(this));
        this.registers.registerCommands(new PremiumCaseCommand(this));

        // user
        this.registers.registerCommands(new ListCommand());
        this.registers.registerCommands(new RepairCommand());
        this.registers.registerCommands(new HelpopCommand(this));
        this.registers.registerCommands(new HelpCommand());
        this.registers.registerCommands(new VIPCommand());
        this.registers.registerCommands(new SVIPCommand());
        this.registers.registerCommands(new SponsorCommand());
        this.registers.registerCommands(new KozakCommand());
        this.registers.registerCommands(new NewsCommand());
        this.registers.registerCommands(new YouTuberCommand());
        this.registers.registerCommands(new YouTuberPlusCommand());
        this.registers.registerCommands(new LiveCommand());
        this.registers.registerCommands(new CraftingiCommand(this));
        this.registers.registerCommands(new BossDropCommand(this));
        this.registers.registerCommands(new EffectsCommand(this));
    }

    public void registerEvents() {
        this.registers.registerEvents(new PlayerJoinQuitListener(this), new BlockPlaceListener(this), new InventoryListener(this), new PlayerInteractListener(this), new EntityDeathListener(this));

    }

    public void registerTask() {
        new BossRespawnTask(this).runTaskTimer(this, 500L, 500L);

    }

    public void loadManagers() {
        this.bossManager.setBoss(false);
        Bukkit.getWorld("world").getEntities().forEach(Entity::remove);

    }

    public Configuration getSettings() {
        return settings;
    }

    public GameModeManager getGameModeManager() {
        return gameModeManager;
    }

    public CooldownManagerImpl getCooldownManager() {
        return cooldownManager;
    }

    public CraftingInventory getCraftingInventory() {
        return craftingInventory;
    }

    public PremiumCaseManagerCreator getPremiumCaseManagerCreator() {
        return premiumCaseManagerCreator;
    }

    public PremiumCaseManager getPremiumCaseManager() {
        return premiumCaseManager;
    }

    public RandomTeleportManager getRandomTeleportManager() {
        return randomTeleportManager;
    }

    public BossManager getBossManager() {
        return bossManager;
    }

    public BossDropInventory getBossDropInventory() {
        return bossDropInventory;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public EffectsInventory getEffectsInventory() {
        return effectsInventory;
    }
}
