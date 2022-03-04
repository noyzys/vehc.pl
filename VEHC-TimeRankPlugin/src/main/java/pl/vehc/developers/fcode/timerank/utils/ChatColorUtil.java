package pl.vehc.developers.fcode.timerank.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatColorUtil {

    private ChatColorUtil() {
    }

    public static String colored(String message) {
        return ChatColor.translateAlternateColorCodes('&', message.replace(">>", "»").replace("<<", "«"));
    }

    public static boolean sendMessage(Player player, String message) {
        player.sendMessage(colored(message));
        return true;
    }


    public static void sendBroadcast(Player player, String message){
        Bukkit.getOnlinePlayers().forEach(players -> ChatColorUtil.sendBroadcast(players, message));
    }
}
