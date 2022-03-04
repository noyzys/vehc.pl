package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class GameModeCommand extends CommandExecutor {

    public GameModeCommand() {
        super("gamemode", "vehc.gamemode", "/gamemode nick <0/1/2/3>", "gm", "twojstarypijany");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

//        final Player player2 = Bukkit.getPlayerExact(args[1]);
//        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany gracz jest offline!");

        switch (args[0].toLowerCase()) {

            case "0": {
                player.setGameMode(GameMode.SURVIVAL);
                return ChatColorUtil.sendMessage(player, "&8>> &7Zmieniono tryb gry na: &6SURVIVAL");
            }

            case "1": {
                player.setGameMode(GameMode.CREATIVE);
                return ChatColorUtil.sendMessage(player, "&8>> &7Zmieniono tryb gry na: &6CREATIVE");
            }

            case "2": {
                player.setGameMode(GameMode.ADVENTURE);
                return ChatColorUtil.sendMessage(player, "&8>> &7Zmieniono tryb gry na: &6ADVENTURE");
            }

            case "3": {
                player.setGameMode(GameMode.SPECTATOR);
                return ChatColorUtil.sendMessage(player, "&8>> &7Zmieniono tryb gry na: &6SPECTATOR");
            }
        }
        return true;
    }
}

