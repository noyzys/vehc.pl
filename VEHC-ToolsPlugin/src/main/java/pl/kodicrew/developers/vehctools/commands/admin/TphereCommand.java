package pl.kodicrew.developers.vehctools.commands.admin;

import net.minecraft.server.v1_8_R3.ChatClickable;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class TphereCommand extends CommandExecutor {

    public TphereCommand() {
        super("tphere", "vehc.tphere", "/tphere nick", "s", "jebac");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player , "&cBlad: Podany gracz jest offline");

        player2.teleport(player.getLocation());
        ChatColorUtil.sendMessage(player, "&8>> &7Przeteleprotowales do &6siebie &7gracza: &6" + player2.getName());
        return ChatColorUtil.sendMessage(player2 ,"&8>> &7Zostales przeteleportowany przez admina: &6" + player.getName());
    }
}

