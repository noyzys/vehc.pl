package pl.kodicrew.developers.vehctools.commands.user;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class LiveCommand extends CommandExecutor {

    public LiveCommand() {
        super("live", "vehc.yt.live", "/live link", "stream");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;
        final String message = StringUtils.join((args));

        if (args[0].startsWith("www") || args[0].startsWith("youtube") || args[0].startsWith("https")) {

            Bukkit.getOnlinePlayers().forEach(players -> {
                ChatColorUtil.sendMessage(players, "&8&m---------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m---------");
                ChatColorUtil.sendMessage(players, " ");
                ChatColorUtil.sendMessage(players, " &8>> &8[&fY&4T&8] &f" + player.getName() + " &7prowadzi live!");
                ChatColorUtil.sendMessage(players, "    &8>> &7Link: &f" + message);
                ChatColorUtil.sendMessage(players, " ");
                ChatColorUtil.sendMessage(players, "&8&m---------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m---------");
            });
            return true;

        } else {
            return ChatColorUtil.sendMessage(player, "&cBlad: Podany link nie jest formatem linku do live/streamu");
        }
    }
}

