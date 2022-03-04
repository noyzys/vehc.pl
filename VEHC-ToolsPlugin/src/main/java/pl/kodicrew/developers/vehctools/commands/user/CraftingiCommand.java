package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;

public class CraftingiCommand extends CommandExecutor {

    private final ToolsPlugin plugin;

    public CraftingiCommand(ToolsPlugin plugin) {
        super("craftingi", "vehc.craftingi", "", "craftingsy", "kraftowanie");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER");
            return true;
        }

        final Player player = (Player) sender;
        player.openInventory(this.plugin.getCraftingInventory().main(player));
        return true;
    }
}
