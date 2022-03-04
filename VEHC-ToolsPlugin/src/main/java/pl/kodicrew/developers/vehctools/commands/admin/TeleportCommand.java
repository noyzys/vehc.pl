package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class TeleportCommand extends CommandExecutor {

    public TeleportCommand() {
        super("tp", "vehc.teleport", "/tp nick", "tp", "lysy");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player , "&cBlad: Podany gracz jest offline!");

        player.teleport(player2.getLocation());
        return ChatColorUtil.sendMessage(player ,"&8>> &7Przeteleportowales sie do gracza: &6" + player2.getName());
    }
}
