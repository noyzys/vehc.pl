package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class RepairCommand extends CommandExecutor {

    public RepairCommand() {
        super("repair", "vehc.repair", "", "napraw");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        final ItemStack itemStack = player.getItemInHand();
        if (itemStack == null || itemStack.getType() == Material.AIR) return ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz nic w rece aby naprawic");

        itemStack.setDurability((short)0);
        return ChatColorUtil.sendMessage(player, "&8>> &7Pomyslnie &6Naprawiono &7przedmiot");
    }
}
