package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class GiveRankCommand extends CommandExecutor {

    public GiveRankCommand() {
        super("giverank", "vehc.giverank", "/group nick <ranga>", "group", "ranga", "dajrange", "rankakurwo");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        final Player player = (Player) sender;

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany gracz jest offline");

        if (args.length == 2) {

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " remove " + args[1]);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set " + args[1]);

            Bukkit.getOnlinePlayers().forEach(players -> {
                ChatColorUtil.sendMessage(players, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &7Gracz &f" + player2.getName());
                ChatColorUtil.sendMessage(players, "   &8>> &7Otrzymal range: &6" + args[1]);
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &a&L&oMILEJ GRY NA SERWERZE &8<<");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, " &8>> &7Nasza Strona: &6VEHC.PL/ &8| &7TS3: &64OPE.PL &8<<");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
            });
            return true;
        }
        return true;
    }
}
