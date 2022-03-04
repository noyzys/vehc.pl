package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class TpallCommand extends CommandExecutor {

    public TpallCommand() {
        super("tpall", "vehc.tpall", "/tpall", "tepajall", "cipka");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        final Player player = (Player) sender;


        Bukkit.getOnlinePlayers().forEach(players -> players.teleport(player.getLocation()));
        return ChatColorUtil.sendMessage(player, "&8>> &7Przeniesiono &6wszystkich &7do &6ciebie");
    }
}
