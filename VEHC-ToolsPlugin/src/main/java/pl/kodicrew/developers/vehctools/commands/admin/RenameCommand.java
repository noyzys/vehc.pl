package pl.kodicrew.developers.vehctools.commands.admin;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class RenameCommand extends CommandExecutor {

    public RenameCommand() {
        super("rename", "vehc.rename", "/rename nazwa", "zmiennazwe", "cipka");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;

        final ItemStack itemStack = player.getItemInHand();
        if (itemStack == null || itemStack.getType() == Material.AIR) return ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz nic w rece aby zmienic nazwe");

        final String message = StringUtils.join(args, " ");
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColorUtil.colored(message));
        itemStack.setItemMeta(itemMeta);

        return ChatColorUtil.sendMessage(player, "&8>> &7Zmieniles nazwe przedmiotu na: &6" + message);
    }
}
