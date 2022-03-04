package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class ClearCommand extends CommandExecutor {

    public ClearCommand() {
        super("clear", "vehc.clear", "/clear nick", "wyczysc", "chuj");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        if (args.length == 0){
            player.getInventory().clear();
            player.getInventory().setArmorContents(null);
            return ChatColorUtil.sendMessage(player, "&8>> &6Wyczysciles sobie ekwipunek!");
        }

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany gracz jest offline");

        player2.getInventory().clear();
        player2.getInventory().setArmorContents(null);
        ChatColorUtil.sendMessage(player, "&8>> &7Wyczysciles graczowi: &6" + player2.getName() + " ekwipunek");
        return ChatColorUtil.sendMessage(player2, "&7Twoj &6Ekwipunek &7zostal wyczyszczony przez admina: " + player.getName());
    }
}
