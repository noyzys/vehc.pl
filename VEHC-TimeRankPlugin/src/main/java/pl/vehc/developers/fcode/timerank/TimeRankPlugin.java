package pl.vehc.developers.fcode.timerank;

import org.bukkit.plugin.java.JavaPlugin;

public class TimeRankPlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        this.getLogger().info("zaladowano");
    }

    @Override
    public void onEnable() {
        this.onLoad();
        this.registerCommands();
        this.registerEvents();
        this.registerTask();
        this.getLogger().info("wlaczono");
    }

    public void registerCommands() {

    }

    public void registerEvents() {

    }

    public void registerTask() {

    }

}
