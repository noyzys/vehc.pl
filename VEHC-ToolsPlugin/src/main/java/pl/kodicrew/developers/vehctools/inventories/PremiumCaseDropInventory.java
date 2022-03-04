package pl.kodicrew.developers.vehctools.inventories;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.builders.ItemStackBuilder;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class PremiumCaseDropInventory {

    private final ToolsPlugin plugin;

    private ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);

    private ItemStackBuilder glassRedProcent = new ItemStackBuilder(Material.STAINED_GLASS_PANE, (short)14).withTitle(ChatColorUtil.colored("&8>> &6&l1% &8<<"));

    public PremiumCaseDropInventory(ToolsPlugin plugin) {
        this.plugin = plugin;
    }
}
