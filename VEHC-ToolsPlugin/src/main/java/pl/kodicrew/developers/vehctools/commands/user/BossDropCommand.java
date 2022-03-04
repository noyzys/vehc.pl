package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;

public class BossDropCommand extends CommandExecutor {

    private final ToolsPlugin plugin;

    public BossDropCommand(ToolsPlugin plugin) {
        super("bossdrop", "vehc.bossdrop", "/bossdrop", "dropboss", "bosiki");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }

        final Player player = (Player) sender;
        player.openInventory(this.plugin.getBossDropInventory().main(player));
        return true;
    }
}
