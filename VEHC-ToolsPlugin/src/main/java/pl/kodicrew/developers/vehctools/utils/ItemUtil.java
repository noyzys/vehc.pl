package pl.kodicrew.developers.vehctools.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.*;
import java.util.stream.Collectors;

public class ItemUtil {

    private ItemUtil(){
    }

    public static void giveItems(Player player, ItemStack... itemStack){

        final Inventory inventory = player.getInventory();
        final HashMap<Integer, ItemStack> stored = inventory.addItem(itemStack);
        stored.forEach((key, value) -> player.getWorld().dropItemNaturally(player.getLocation(), value));
    }

    public static void removeItems(Player player, ItemStack... itemStacks){

        final Inventory inv = player.getInventory();
        final HashMap<Integer, ItemStack> stored = inv.removeItem(itemStacks);
        stored.forEach((key, value) -> player.getWorld().dropItemNaturally(player.getLocation(), value));
    }

    public static void removeItems(List<ItemStack> items, Player player) {
        final Inventory inv = player.getInventory();

        final List<ItemStack> removes = items
                .stream()
                .filter(item -> inv.containsAtLeast(item, item.getAmount()))
                .collect(Collectors.toList());

        if (removes.size() == items.size()) {
            items.forEach(item -> removes
                    .stream()
                    .filter(remove -> item.getType().equals(remove.getType()) && item.getData().equals(remove.getData()))
                    .map(remove -> new ItemStack[]{item})
                    .forEach(inv::removeItem));
        }
        removes.clear();
    }

    public static boolean checkItems(List<ItemStack> items, Player player) {
        return items
                .stream()
                .allMatch(item -> player.getInventory().containsAtLeast(item, item.getAmount()));
    }

    public static int getAmount(Player player, Material material){
        return Arrays
                .stream(player.getInventory().getContents())
                .filter(itemStack -> itemStack != null && itemStack.getType() == material)
                .mapToInt(ItemStack::getAmount)
                .sum();
    }
}
