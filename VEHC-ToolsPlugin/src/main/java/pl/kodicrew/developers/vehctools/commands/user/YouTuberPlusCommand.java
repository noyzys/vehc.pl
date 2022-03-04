package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class YouTuberPlusCommand extends CommandExecutor {

    public YouTuberPlusCommand() {
        super("yt+", "vehc.yt+", "", "youtuber+");
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
        ChatColorUtil.sendMessage(player, "   &8>> &6/kit kozak &8- &7Darmowy zestaw kozak");
        ChatColorUtil.sendMessage(player, "   &8>> &6/kit sponsor &8- &7Darmowy zestaw sponsor");
        ChatColorUtil.sendMessage(player, "   &8>> &6/kit svip &8- &7Darmowy zestaw SVIP");
        ChatColorUtil.sendMessage(player, "   &8>> &6/kit vip &8- &7Darmowy zestaw VIP");
        ChatColorUtil.sendMessage(player, "   &8>> &6/live &8- &7Moze zareklamowac live");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "   &8>> &6Miej itemow na gildie");
        ChatColorUtil.sendMessage(player, "   &8>> &6Mniej EXPA na gildie");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, " &8>> &7Co zrobic aby otrzymac range?");
        ChatColorUtil.sendMessage(player, "   &8>> &7Wrzuc reklame: &6https://www.mediafire.com/file/d8u9crqs99rgpym/Trailer+VEHC+by+PT.mp4");
        ChatColorUtil.sendMessage(player, "   &8>> &7Posiadac &f300 widzow");
        ChatColorUtil.sendMessage(player, " &8>> &7Aby otrzymac range &fYouTuber+ &7zglos sie na &64OPE.PL");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
        return true;
    }
}