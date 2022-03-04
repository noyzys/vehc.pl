package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class FlyCommand extends CommandExecutor {

    public FlyCommand() {
        super("fly", "vehc.fly", "/fly", "latanie", "dupa");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        if (args.length == 0) {
            player.setAllowFlight(!player.getAllowFlight());
            return ChatColorUtil.sendMessage(player, "&8>> &7Tryb &6latania &7zostal: " + (player.getAllowFlight() ? "&aWlaczony" : "&cWylaczony"));
        }

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player, "&4Blad: &8>> &cPodany gracz jest offline!");

        player2.setAllowFlight(!player2.getAllowFlight());
        return ChatColorUtil.sendMessage(player2, "&8>> &7Tryb &6latania &7zostal: " + (player.getAllowFlight() ? "&aWlaczony" : "&cWylaczony" + " &7przez: &6" + player.getName()));
    }
}


