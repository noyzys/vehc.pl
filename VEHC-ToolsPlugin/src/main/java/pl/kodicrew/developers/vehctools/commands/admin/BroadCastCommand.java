package pl.kodicrew.developers.vehctools.commands.admin;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.apies.packets.ActionBarPacket;
import pl.kodicrew.developers.vehctools.apies.packets.TitleSubTitlePacket;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class BroadCastCommand extends CommandExecutor {

    public BroadCastCommand() {
        super("broadcast", "vehc.broadcast", "/broadcast tryb <title/subtitle/actionbar/text>", "bc", "twojstary");
}

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;
        final String message = StringUtils.join(args, " ", 1, args.length);

        switch (args[0].toLowerCase()){
            case "title": {
                Bukkit.getOnlinePlayers().forEach(players -> TitleSubTitlePacket.sendTitle(players, message, "",40,70,100));
            break;
            }
            case "subtitle": {
                Bukkit.getOnlinePlayers().forEach(players -> TitleSubTitlePacket.sendTitle(players, "", message,40,70,100));
                break;
            }
            case "actionbar": {
                Bukkit.getOnlinePlayers().forEach(players -> ActionBarPacket.sendActionbar(players, ChatColorUtil.colored(message)));
                break;
            }
            case "text": {
                Bukkit.getOnlinePlayers().forEach(players -> ChatColorUtil.sendMessage(players, "&6&lVE&f&lHC&7&l.PL &8>> &6" + message));
                break;
            } default:
                return ChatColorUtil.sendMessage(player, "&cBlad: Nie ma takiego trybu pakietu broadcast!");
        }
        return true;
    }
}
