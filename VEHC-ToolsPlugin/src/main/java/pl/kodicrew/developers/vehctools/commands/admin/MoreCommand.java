package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class MoreCommand extends CommandExecutor {

    public MoreCommand() {
        super("more", "vehc.more", "/more przedmiot", "stakuj", "stara");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        final ItemStack itemStack = player.getItemInHand();
        if (itemStack == null || itemStack.getType() == Material.AIR) return ChatColorUtil.sendMessage(player, "&cBlad: Nie masz nic w rece aby stakowac przedmiot");

        itemStack.setAmount(itemStack.getMaxStackSize());
        return ChatColorUtil.sendMessage(player, "&8>> &7Pomyslnie zestakowales &6x" + itemStack.getMaxStackSize());
    }
}
