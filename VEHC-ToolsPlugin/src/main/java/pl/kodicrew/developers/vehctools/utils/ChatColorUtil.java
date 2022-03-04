package pl.kodicrew.developers.vehctools.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChatColorUtil {

    private ChatColorUtil(){
    }

    public static String colored(String message){
        return ChatColor.translateAlternateColorCodes('&', message.replace(">>", "»").replace("<<", "«"));
    }

    public static boolean sendMessage(Player player, String message){
        player.sendMessage(colored(message));
        return true;
    }

    public static void clear(Player player){
        IntStream.range(0, 100).forEach(players -> ChatColorUtil.sendMessage(player, ""));
    }

    public static void sendBroadcast(Player player, String message){
        Bukkit.getOnlinePlayers().forEach(players -> ChatColorUtil.sendBroadcast(players, message));
    }

    public static List<String> colored(List<String> message){
        return message
                .stream()
                .map(ChatColorUtil::colored)
                .collect(Collectors.toList());
    }
}
