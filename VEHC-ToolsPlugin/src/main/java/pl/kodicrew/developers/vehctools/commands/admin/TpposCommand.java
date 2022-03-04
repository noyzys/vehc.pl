package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class TpposCommand extends CommandExecutor {

    public TpposCommand() {
        super("tppos", "vehc.tppos", "/tppos kordy", "kordy", "pijana");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        final int x = Integer.parseInt(args[0]);
        final int y = Integer.parseInt(args[1]);
        final int z = Integer.parseInt(args[2]);
        final Location location = new Location(player.getWorld(), x + 0.5, y, z + 0.5);

        player.teleport(location);
        return ChatColorUtil.sendMessage(player ,"&8>> &7Przeteleportowales sie na &6Kordy: X: " + x + " Y: " + y + " Z: " + z);
    }
}
