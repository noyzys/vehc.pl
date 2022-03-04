package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

import java.util.HashMap;

public class GodModeCommand extends CommandExecutor {

    private final ToolsPlugin plugin;
    private HashMap<String, String> godmode = new HashMap<>();

    public GodModeCommand(ToolsPlugin plugin) {
        super("godmode", "vehc.godmode", "/godmode nick", "god");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany gracz jest offline");

        if (this.godmode.containsKey(player.getName())) {
            this.godmode.remove(player.getName());
            return ChatColorUtil.sendMessage(player, "&8>> &7Tryb &6niesmiertelnosci *8zostal: &cWylaczony");
        }

        if (args.length == 2){
        this.godmode.put(player.getName(), "");
        return ChatColorUtil.sendMessage(player, "&8>> &7Tryb &6niesmiertelnosci &7zostal: &aWlaczony");

    }
        if(this.godmode.containsKey(player2.getName())){
            this.godmode.remove(player2.getName());
            return ChatColorUtil.sendMessage(player2, "&8>> &7Tryb &6niesmiertelnosci &7zostal: &cWylaczony " + " &7przez admina: &6" + player.getName());

        }
        this.godmode.put(player2.getName(), "");
        return ChatColorUtil.sendMessage(player2, "&8>> &7Tryb &6niesmiertelnosci &7zostal: &aWlaczony " + " &7przez admina: &6" + player.getName());
    }
}
