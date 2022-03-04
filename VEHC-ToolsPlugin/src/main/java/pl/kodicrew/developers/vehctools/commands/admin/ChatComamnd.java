package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

import java.util.stream.IntStream;

public class ChatComamnd extends CommandExecutor {

    private boolean chat = true;

    public ChatComamnd() {
        super("chat", "vehc.chat", "/chat <on/off/cc>", "czat", "jebacstarekurwy");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        switch (args[0].toLowerCase()){

            case "on": {

                if (this.chat){
                    return ChatColorUtil.sendMessage(player, "&cBlad: Chat jest juz wlaczony po co chcesz go 2x wlaczyc?");
                }

                this.chat = true;
                IntStream.range(0, 100).forEach(players -> Bukkit.broadcastMessage(" "));
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Chat serwera zostal: &a&l&oWlaczony");
                    ChatColorUtil.sendMessage(players, " &8>> &7Przez admina: &6" + player.getName());
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                });
                break;
            }

            case "off": {

                if (!this.chat){
                    return ChatColorUtil.sendMessage(player, "&cBlad: Chat jest juz wylaczony po co chcesz go x2 wylaczyc?");
                }

                this.chat = false;
                IntStream.range(0, 100).forEach(players -> Bukkit.broadcastMessage(" "));
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Chat serwera zostal: &c&l&oWylaczony");
                    ChatColorUtil.sendMessage(players, " &8>> &7Przez admina: &6" + player.getName());
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                });
                break;
            }

            case "cc": {
                IntStream.range(0, 100).forEach(players -> Bukkit.broadcastMessage(" "));
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Chat serwera zostal: &9&l&oWyczyszczony");
                    ChatColorUtil.sendMessage(players, " &8>> &7Przez admina: &6" + player.getName());
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m------------");
                });
                break;

            } default: return ChatColorUtil.sendMessage(player, "&cBlad: Nie ma takiego trybu chatu");
        }
        return true;
    }
}
