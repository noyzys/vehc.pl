package pl.kodicrew.developers.vehctools.commands.admin;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class KickCommand extends CommandExecutor {

    public KickCommand() {
        super("kick", "vehc.kick", "/kick nick", "wyrzuc", "fiutek");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        final Player player = (Player) sender;

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany gracz jest offline");

        final String message = StringUtils.join(args, " ", 1, args.length);

        if (args.length < 2) {
            Bukkit.getOnlinePlayers().forEach(players -> ChatColorUtil.sendMessage(players, " &8>> &7Gracz &f" + player2.getName() + " &7zostal wyrzucony z serwera za: &cBrak powodu" + " &7przez admina: &6" + player.getName()));
            player2.kickPlayer(ChatColorUtil.colored("{N}&8&m---------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m---------{N}{N}&8>> &7Wyrzucil ciebie: &c" + player.getName() + " {N}&8>> &7Powod: &cBrak {N} {N} &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64OPE.PL &8<< {N} {N}&8&m---------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m---------").replace("{N}", "\n"));
            return true;
        }
        Bukkit.getOnlinePlayers().forEach(players -> ChatColorUtil.sendMessage(players, " &8>> &7Gracz &f" + player2.getName() + " &7zostal wyrzucony z serwera za: &c" + message + " &7przez admina: &6" + player.getName()));
        player2.kickPlayer(ChatColorUtil.colored("{N}&8&m---------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m---------{N}{N}&8>> &7Wyrzucil ciebie: &c" + player.getName() + " {N}&8>> &7Powod: &c" + message + "{N} {N} &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64OPE.PL &8<< {N} {N}&8&m---------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m---------").replace("{N}", "\n").replace("{REASON}", message));
        return true;
    }
}

