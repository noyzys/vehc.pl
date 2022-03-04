package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;

public class EffectsCommand extends CommandExecutor {

    private final ToolsPlugin plugin;

    public EffectsCommand(ToolsPlugin plugin) {
        super("effects", "vehc.effekty", "/efekty", "efekty", "efekt");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        player.openInventory(this.plugin.getEffectsInventory().main(player));
        return true;
    }
}
