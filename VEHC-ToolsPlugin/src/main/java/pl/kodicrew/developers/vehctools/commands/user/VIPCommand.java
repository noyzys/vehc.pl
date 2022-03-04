package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class VIPCommand extends CommandExecutor {

    public VIPCommand() {
        super("vip", "vehc.vip", "", "viper");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        ChatColorUtil.sendMessage(player, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, " &8>> &7Ranga posiada permisije:");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "   &8>> &6/repair &8- &7naprawienia przedmiotow");
        ChatColorUtil.sendMessage(player, "   &8>> &6/kit vip &8- &7Darmowy zestaw VIP");
        ChatColorUtil.sendMessage(player, "   &8>> &6Miej itemow na gildie");
        ChatColorUtil.sendMessage(player, "   &8>> &6Mniej EXPA na gildie");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "    &8>> &7Range zakupisz na:");
        ChatColorUtil.sendMessage(player, "      &8>> &a&l&oRanga jest darmowa");
        ChatColorUtil.sendMessage(player, "   &8>> &7Nasz Facebook:");
        ChatColorUtil.sendMessage(player, "      &8>> &6fb.com/vehcpl");
        ChatColorUtil.sendMessage(player, "   &8>> &7Nasz TeamSpeak3:");
        ChatColorUtil.sendMessage(player, "      &8>> &64OPE.PL");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
        return true;
    }
}
