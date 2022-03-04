package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class ListCommand extends CommandExecutor {

    public ListCommand() {
        super("list", "vehc.list", "", "online", "lista");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        return ChatColorUtil.sendMessage(player, "&8>> &7Na serwerze znajduje sie obecnie: &6" + Bukkit.getOnlinePlayers().size() + " osob");
    }
}
