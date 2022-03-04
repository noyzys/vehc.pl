package pl.kodicrew.developers.vehctools.apies.managers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;
import pl.kodicrew.developers.vehctools.ToolsPlugin;

import java.lang.reflect.Field;
import java.util.Arrays;

public class RegisterManager {

    private final ToolsPlugin plugin;
    private CommandMap commandMap;

    public RegisterManager(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerEvents(Listener... listeners) {
        final PluginManager pluginManager = Bukkit.getPluginManager();
        Arrays.stream(listeners)
                .forEach(listener -> pluginManager.registerEvents(listener, this.plugin));
    }

    public void registerCommands(Command command) {
        if (commandMap == null) try {
            final Field field = SimplePluginManager.class.getDeclaredField("commandMap");
            field.setAccessible(true);
            commandMap = (CommandMap) field.get(Bukkit.getServer().getPluginManager());
        } catch (Exception e) {
            e.printStackTrace();
        }
        commandMap.register("", command);
    }
}

