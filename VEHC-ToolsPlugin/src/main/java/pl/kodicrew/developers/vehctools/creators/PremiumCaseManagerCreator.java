package pl.kodicrew.developers.vehctools.creators;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;
import pl.kodicrew.developers.vehctools.utils.ItemUtil;

import java.util.Arrays;

public class PremiumCaseManagerCreator {

    public ItemStack createItem(ItemStack itemStack, String name, String[] lore){
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public void premiumCaseChest(Player player, int amount){
        player.getInventory().addItem(createItem(new ItemStack(Material.CHEST, amount), ChatColorUtil.colored("&8>> &9&lPremiumCase &8<<"), new String[] { ChatColorUtil.colored("&8>> &7Postaw na ziemi aby &6otworzyc!")}));
    }
}
