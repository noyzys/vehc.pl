package pl.kodicrew.developers.vehctools.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.builders.ItemStackBuilder;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

import java.util.stream.IntStream;

public class EffectsInventory {

    private final ToolsPlugin plugin;

    private ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);

    private ItemStackBuilder glass2 = new ItemStackBuilder(Material.STAINED_GLASS_PANE, 1, (short)15).withTitle(" ");

    private ItemStackBuilder speed1 = new ItemStackBuilder(Material.POTION, 1, (short)8194).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6SPEED I &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Efekt: &6SPEED I")).withLore(ChatColorUtil.colored("&7Czas Trwania: &63m")).withLore(ChatColorUtil.colored("&7Koszt: &632x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder speed2 = new ItemStackBuilder(Material.POTION, 2, (short)8194).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6SPEED II &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Efekt: &6SPEED II")).withLore(ChatColorUtil.colored("&7Czas Trwania: &66m")).withLore(ChatColorUtil.colored("&7Koszt: &664x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder strength1 = new ItemStackBuilder(Material.POTION, 1, (short)8201).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6STRENGTH I &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Efekt: &6STRENGTH I")).withLore(ChatColorUtil.colored("&7Czas Trwania: &62m")).withLore(ChatColorUtil.colored("&7Koszt: &632x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder strength2 = new ItemStackBuilder(Material.POTION, 2, (short)8201).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6STRENGTH II &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Efekt: &6STRENGTH II")).withLore(ChatColorUtil.colored("&7Czas Trwania: &64m")).withLore(ChatColorUtil.colored("&7Koszt: &664x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder jump1 = new ItemStackBuilder(Material.POTION, 1, (short)8203).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6JUMP BOOST I &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Efekt: &6JUMP BOOST I")).withLore(ChatColorUtil.colored("&7Czas Trwania: &64m")).withLore(ChatColorUtil.colored("&7Koszt: &632x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder jump2 = new ItemStackBuilder(Material.POTION, 2, (short)8203).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6JUMP BOOST II &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Efekt: &6JUMP BOOST II")).withLore(ChatColorUtil.colored("&7Czas Trwania: &66m")).withLore(ChatColorUtil.colored("&7Koszt: &664x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder haste1 = new ItemStackBuilder(Material.POTION, 1, (short)0).withEnchantment(Enchantment.DIG_SPEED, 1).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6HASTE I &8<<")).withLore(ChatColorUtil.colored("")).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6HASTE I &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Efekt: &6HASTE I")).withLore(ChatColorUtil.colored("&7Czas Trwania: &63m")).withLore(ChatColorUtil.colored("&7Koszt: &632x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder haste2 = new ItemStackBuilder(Material.POTION, 2, (short)0).withEnchantment(Enchantment.DIG_SPEED, 1).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6HASTE II &8<<")).withLore(ChatColorUtil.colored("")).withTitle(ChatColorUtil.colored("&8>> &7Efekt: &6HASTE II &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Efekt: &6HASTE II")).withLore(ChatColorUtil.colored("&7Czas Trwania: &66m")).withLore(ChatColorUtil.colored("&7Koszt: &664x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder pucieczka = new ItemStackBuilder(Material.GOLD_BOOTS, 1).withTitle(ChatColorUtil.colored("&8>> &7Pakiet: &6Ucieczki &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Pakiet: &6UCIECZKA")).withLore(ChatColorUtil.colored("&7Posiada: &6SPEED II, JUMP BOOST II")).withLore(ChatColorUtil.colored("&7Czas Trwania: &65m")).withLore(ChatColorUtil.colored("&7Koszt: &642x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder pkopacz = new ItemStackBuilder(Material.DIAMOND_PICKAXE, 1).withTitle(ChatColorUtil.colored("&8>> &7Pakiet: &6Kopacza &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Pakiet: &6KOPACZ")).withLore(ChatColorUtil.colored("&7Posiada: &6HASTE II, SPEED II")).withLore(ChatColorUtil.colored("&7Czas Trwania: &65m")).withLore(ChatColorUtil.colored("&7Koszt: &646x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));

    private ItemStackBuilder pwalka = new ItemStackBuilder(Material.DIAMOND_SWORD, 1).withTitle(ChatColorUtil.colored("&8>> &7Pakiet: &6Walki &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&7Pakiet: &6WALKA")).withLore(ChatColorUtil.colored("&7Posiada: &6STRENGTH II, FIRE_RESISTANCE III, REGENERATION II")).withLore(ChatColorUtil.colored("&7Czas Trwania: &65m")).withLore(ChatColorUtil.colored("&7Koszt: &635x EMERALD_BLOCK")).withLore(ChatColorUtil.colored("&7Chcesz zakupic? Kliknij: &6PPM")).withLore(ChatColorUtil.colored(""));


    public EffectsInventory(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    public Inventory main(Player player){
        final Inventory inventory = Bukkit.createInventory(null, 54, ChatColorUtil.colored("&8>> &7Wybierz &8| &6Efekt"));

        IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, this.glass));

        inventory.setItem(10, speed1.build());
        inventory.setItem(12, strength1.build());
        inventory.setItem(14, jump1.build());
        inventory.setItem(16, haste1.build());
        inventory.setItem(19, speed2.build());
        inventory.setItem(21, strength2.build());
        inventory.setItem(23, jump2.build());
        inventory.setItem(25, haste2.build());
        inventory.setItem(47, pucieczka.build());
        inventory.setItem(49, pkopacz.build());
        inventory.setItem(51, pwalka.build());

        return inventory;
    }
}
