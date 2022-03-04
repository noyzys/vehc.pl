package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class InvseeCommand extends CommandExecutor {

    public InvseeCommand() {
        super("invsee", "vehc.invsee", "/invsee nick", "ekwipunek", "kurwy");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany gracz jest offline!");

        player.openInventory(player2.getInventory());
        return ChatColorUtil.sendMessage(player, "&8>> &7Otworzyles &6Ekwipunek &7gracza: &6" + player2.getName());
    }
}
