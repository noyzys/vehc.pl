package pl.kodicrew.developers.vehctools.events.actions;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class PlayerJoinQuitListener implements Listener {

    private final ToolsPlugin plugin;

    public PlayerJoinQuitListener(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler public void onJoinMessageBeforedPlayer(PlayerJoinEvent event){
        final Player player = event.getPlayer();

        if (!player.hasPlayedBefore()){
            player.setGameMode(GameMode.SURVIVAL);
            if (!event.getPlayer().getWorld().getName().contains("world")) player.teleport(Bukkit.getWorld("world").getSpawnLocation());
            ChatColorUtil.sendBroadcast(player, "&8>> &7Gracz &f" + player.getName() + " &7dolaczyl poraz pierwszy");
        }
    }

    @EventHandler public void onJoinMessageToServer(PlayerJoinEvent event){
        final Player player = event.getPlayer();

        player.setGameMode(GameMode.SURVIVAL);
        event.setJoinMessage(ChatColorUtil.colored("&8>> &7Gracz &f" + player.getName() + " &7dolaczyl na &fserwer"));
        ChatColorUtil.clear(player);

        player.sendTitle(ChatColorUtil.colored("&8>> &6&lVE&f&LHC&7&l.PL &8<<"), ChatColorUtil.colored("&8>> &7Witaj &f" + player.getName()) + ChatColorUtil.colored(" &7na &6serwerze &8<<"));

        ChatColorUtil.sendMessage(player, "&8&m-------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m-------------");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "  &8>> &7Twoj nick: &6" + player.getName());
        ChatColorUtil.sendMessage(player, "  &8>> &7Aktualnie online: &6" + Bukkit.getOnlinePlayers().size());
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "  &8>> &7WWW: &6vehc.pl/");
        ChatColorUtil.sendMessage(player, "  &8>> &7TS3: &64ope.pl");
        ChatColorUtil.sendMessage(player, "  &8>> &7FaceBook: &6fb.com/vehcpl");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "&8&m-------------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m-------------");
    }

    @EventHandler public void onQuitMessageToServer(PlayerQuitEvent event){
        final Player player = event.getPlayer();
        event.setQuitMessage(ChatColorUtil.colored("&8>> &7Gracz &f" + player.getName() + " &7opuscil &fserwer"));
    }
}
