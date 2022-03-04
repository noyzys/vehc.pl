package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class GiveYouTuberCommand extends CommandExecutor {

    public GiveYouTuberCommand() {
        super("giveyt", "vehc.giveyt", "/giveyt nick <yt/yt+>", "dajyt", "dajjutubera");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        final Player player = (Player) sender;

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany Player jest offline");

        switch (args[1].toLowerCase()) {

            case "yt": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + args[0] + " remove " + args[1]);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + args[0] + " group set youtuber");

                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "   &8>> &7Gracz &6" + player2.getName());
                    ChatColorUtil.sendMessage(players, "    &8>> &7Otrzymal range: &8[&f&lYou&4&lTuber&8]");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "    &8>> &7Wymagania rangi &fYouTuber &7pod &6/yt");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&L&oMILEJ GRY NA SERWERZE &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64OPE.PL &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                });
                break;
            }

            case "yt+": {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + args[0] + " remove " + args[1]);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user" + args[0] + " group set youtuber+");

                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "   &8>> &7Gracz &6" + player2.getName());
                    ChatColorUtil.sendMessage(players, "    &8>> &7Otrzymal range: &8[&f&lYou&4&lTuber&6&l+&8]");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "    &8>> &7Wymagania rangi &fYouTuber &7pod &6/yt+");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&L&oMILEJ GRY NA SERWERZE &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64OPE.PL &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                });
                break;
            }
        }
        return true;
    }
}
