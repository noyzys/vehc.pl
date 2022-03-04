package pl.kodicrew.developers.vehctools.inventories;

import net.minecraft.server.v1_8_R3.ChatBaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.builders.ItemStackBuilder;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

import java.util.stream.IntStream;

public class BossDropInventory {

    private final ToolsPlugin plugin;

    private ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);

    private ItemStackBuilder glassRedProcent = new ItemStackBuilder(Material.STAINED_GLASS_PANE, (short)14).withTitle(ChatColorUtil.colored("&8>> &6&l10% - 1% &8<<"));

    private ItemStackBuilder glassPinkProcent = new ItemStackBuilder(Material.STAINED_GLASS_PANE, (short)6).withTitle(ChatColorUtil.colored("&8>> &6&l30% &8<<"));

    private ItemStackBuilder glassYellowProcent = new ItemStackBuilder(Material.STAINED_GLASS_PANE, (short)4).withTitle(ChatColorUtil.colored("&8>> &6&l50% &8<<"));

    private ItemStackBuilder glassPurpleProcent = new ItemStackBuilder(Material.STAINED_GLASS_PANE, (short)2).withTitle(ChatColorUtil.colored("&8>> &6&l70% &8<<"));

    private ItemStackBuilder glassGreenProcent = new ItemStackBuilder(Material.STAINED_GLASS_PANE, (short)5).withTitle(ChatColorUtil.colored("&8>> &6&l90% &8<<"));

    private ItemStackBuilder boss = new ItemStackBuilder(Material.SKULL_ITEM, (short)2).withTitle(ChatColorUtil.colored("&8>> &c&lBOSS &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8&m----------&8[ &6&lVE&f&lHC&7&l.Pl &8]&8&m----------")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Zawsze respi sie na: &6losowych kordach")).withLore(ChatColorUtil.colored("&8>> &7Dropia z niego: &6Kozackie itemki ;) &8(&cAle sa wyjatki&8)")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8&m----------&8[ &6&lVE&f&lHC&7&l.Pl &8]&8&m----------"));

    private ItemStackBuilder voucher_guild = new ItemStackBuilder(Material.TRIPWIRE_HOOK).withTitle(ChatColorUtil.colored("&8>> &c&lVOUCHER NA ITEMY NA GILDIE &8<<"));

    private ItemStackBuilder sword_god = new ItemStackBuilder(Material.DIAMOND_SWORD).withTitle(ChatColorUtil.colored("&8>> &5&lMIECZ BOGA &8<<")).withEnchantment(Enchantment.DAMAGE_ALL, 6).withEnchantment(Enchantment.FIRE_ASPECT, 2);

    private ItemStackBuilder chestplate_god = new ItemStackBuilder(Material.DIAMOND_CHESTPLATE).withTitle(ChatColorUtil.colored("&8>> &5&lKLATA BOGA &8<<")).withEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).withEnchantment(Enchantment.DURABILITY, 3);

    private ItemStackBuilder premiumcase = new ItemStackBuilder(Material.CHEST, 2).withTitle(ChatColorUtil.colored("&8>> &9&lPremiumCase x2 &8<<"));

    private ItemStackBuilder cobweb = new ItemStackBuilder(Material.WEB, 2).withTitle(ChatColorUtil.colored("&8>> &e&lPAJECZYNA x2 &8<<"));




    public BossDropInventory(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    public Inventory main(Player player){
        final Inventory inventory = Bukkit.createInventory(null, 27, ChatColorUtil.colored("&8>> &7Drop &8| &6BOSS"));

        IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, this.glass));

        inventory.setItem(9, boss.build());
        inventory.setItem(17, boss.build());

        inventory.setItem(20, glassGreenProcent.build());
        inventory.setItem(21, glassPurpleProcent.build());
        inventory.setItem(22, glassYellowProcent.build());
        inventory.setItem(23, glassPinkProcent.build());
        inventory.setItem(24, glassRedProcent.build());

        inventory.setItem(11, cobweb.build());
        inventory.setItem(12, premiumcase.build());
        inventory.setItem(13, chestplate_god.build());
        inventory.setItem(14, sword_god.build());
        inventory.setItem(15, voucher_guild.build());

        return inventory;
    }
}
