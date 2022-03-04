package pl.kodicrew.developers.vehctools.impl;

import pl.kodicrew.developers.vehctools.ToolsPlugin;
import java.util.HashMap;

public class GodModeManagerImpl {

    public final ToolsPlugin plugin;
    public HashMap<String, String> godmode = new HashMap<>();

    public GodModeManagerImpl(ToolsPlugin plugin) {
        this.plugin = plugin;
    }
}
