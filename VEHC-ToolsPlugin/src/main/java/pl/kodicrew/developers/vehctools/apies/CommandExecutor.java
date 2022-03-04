package pl.kodicrew.developers.vehctools.apies;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;
import java.util.Arrays;

public abstract class CommandExecutor extends BukkitCommand {

    public CommandExecutor(String name, String permission, String usage, String... aliases) {
        super(name, "desc", usage, Arrays.asList(aliases));
        this.setPermission(permission);
    }

    public abstract boolean execute(CommandSender sender, String[] args);

    @Override
    public boolean execute(CommandSender sender, String arg, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            ChatColorUtil.sendMessage((Player) sender, "&cBlad: Nie posiadasz permisji &8(&c" + this.getPermission() + "&8)");
            return false;
        }
        try {
            return execute(sender, args);
        } catch (IndexOutOfBoundsException exception) {
            ChatColorUtil.sendMessage((Player) sender, "&cUzycie: &6" + getUsage());
            return true;
        }
    }
}
