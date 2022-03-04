package pl.kodicrew.developers.vehctools.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.builders.ItemStackBuilder;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

import java.util.stream.IntStream;

public class CraftingInventory {

    public final ToolsPlugin plugin;

    private ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);

    private ItemStackBuilder boyfarmer = new ItemStackBuilder(Material.OBSIDIAN).withTitle(ChatColorUtil.colored("&8>> &7Crafting #1 &8| &6BoyFarmer &8<<"));

    private ItemStackBuilder sandfarmer = new ItemStackBuilder(Material.SAND).withTitle(ChatColorUtil.colored("&8>> &7Crafting #2 &8| &6SandFarmer &8<<"));

    private ItemStackBuilder kopaczfos = new ItemStackBuilder(Material.STONE).withTitle(ChatColorUtil.colored("&8>> &7Crafting #3 &8| &6KopaczFos &8<<"));

    private ItemStackBuilder stoniarka = new ItemStackBuilder(Material.ENDER_STONE).withTitle(ChatColorUtil.colored("&8>> &7Crafting #4 &8| &6Generator Stone &8<<"));

    private ItemStackBuilder rzucanetnt = new ItemStackBuilder(Material.TNT).withTitle(ChatColorUtil.colored("&8>> &7Crafting #5 &8| &6RzucaneTNT &8<<"));

    private ItemStackBuilder byfarmer_obsidian = new ItemStackBuilder(Material.OBSIDIAN).withTitle(" ");

    private ItemStackBuilder sandfarmer_sand = new ItemStackBuilder(Material.SAND).withTitle(" ");

    private ItemStackBuilder kopaczfos_stone = new ItemStackBuilder(Material.STONE).withTitle(" ");


    private ItemStackBuilder rzucanetnt_tnt = new ItemStackBuilder(Material.TNT).withTitle(" ");

    private ItemStackBuilder back = new ItemStackBuilder(Material.STAINED_GLASS_PANE, (short)14).withTitle(ChatColorUtil.colored("&8>> &cPowrot &8<<"));


    private ItemStackBuilder stoniarka_redstone = new ItemStackBuilder(Material.REDSTONE).withTitle(" ");

    private ItemStackBuilder stoniarka_iron = new ItemStackBuilder(Material.IRON_INGOT).withTitle(" ");

    private ItemStackBuilder stoniarka_stone = new ItemStackBuilder(Material.STONE).withTitle(" ");

    private ItemStackBuilder stoniarka_piston = new ItemStackBuilder(Material.PISTON_BASE).withTitle(" ");




    public CraftingInventory(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    public Inventory main(Player player){
        final Inventory inventory = Bukkit.createInventory(null, 27, ChatColorUtil.colored("&8>> &7Wybor &8| &6Craftingow"));

        IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, this.glass));

        inventory.setItem(12, this.sandfarmer.build());
        inventory.setItem(13, this.kopaczfos.build());
        inventory.setItem(14, this.stoniarka.build());
        inventory.setItem(15, this.rzucanetnt.build());
        inventory.setItem(11, this.boyfarmer.build());
        return inventory;
    }

    public Inventory boyfarmer(Player player){
        final Inventory inventory = Bukkit.createInventory(null, 27, ChatColorUtil.colored("&8>> &7Crafting &8| &6BoyFarmer"));

        IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, this.glass));

        inventory.setItem(1, byfarmer_obsidian.build());
        inventory.setItem(2, byfarmer_obsidian.build());
        inventory.setItem(3, byfarmer_obsidian.build());
        inventory.setItem(10, byfarmer_obsidian.build());
        inventory.setItem(11, byfarmer_obsidian.build());
        inventory.setItem(12, byfarmer_obsidian.build());
        inventory.setItem(14, new ItemStackBuilder(Material.OBSIDIAN).withTitle(ChatColorUtil.colored("&8>> &6BOYFARMER &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby wygenerowac &6sciane z obsidianu")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());
        inventory.setItem(19, byfarmer_obsidian.build());
        inventory.setItem(20, byfarmer_obsidian.build());
        inventory.setItem(21, byfarmer_obsidian.build());
        inventory.setItem(26, back.build());
        return inventory;
    }

    public Inventory sandfarmer(Player player){
        final Inventory inventory = Bukkit.createInventory(null, 27, ChatColorUtil.colored("&8>> &7Crafting &8| &6SandFarmer"));

        IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, this.glass));

        inventory.setItem(1, sandfarmer_sand.build());
        inventory.setItem(2, sandfarmer_sand.build());
        inventory.setItem(3, sandfarmer_sand.build());
        inventory.setItem(10, sandfarmer_sand.build());
        inventory.setItem(11, sandfarmer_sand.build());
        inventory.setItem(12, sandfarmer_sand.build());
        inventory.setItem(14, new ItemStackBuilder(Material.SAND).withTitle(ChatColorUtil.colored("&8>> &6SANDFARMER &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby wygenerowac &6sciane z piasku")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());
        inventory.setItem(19, sandfarmer_sand.build());
        inventory.setItem(20, sandfarmer_sand.build());
        inventory.setItem(21, sandfarmer_sand.build());
        inventory.setItem(26, back.build());

        return inventory;
    }

    public Inventory kopaczFos(Player player){
        final Inventory inventory = Bukkit.createInventory(null, 27, ChatColorUtil.colored("&8>> &7Crafting &8| &6KopaczFos"));

        IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, this.glass));

        inventory.setItem(1, kopaczfos_stone.build());
        inventory.setItem(2, kopaczfos_stone.build());
        inventory.setItem(3, kopaczfos_stone.build());
        inventory.setItem(10, kopaczfos_stone.build());
        inventory.setItem(11, kopaczfos_stone.build());
        inventory.setItem(12, kopaczfos_stone.build());
        inventory.setItem(14, new ItemStackBuilder(Material.STONE).withTitle(ChatColorUtil.colored("&8>> &6KOPACZ FOS &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby zrobic: &6dziure w ziemi")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());
        inventory.setItem(19, kopaczfos_stone.build());
        inventory.setItem(20, kopaczfos_stone.build());
        inventory.setItem(21, kopaczfos_stone.build());
        inventory.setItem(26, back.build());

        return inventory;
    }

    public Inventory rzucaneTnt(Player player){
        final Inventory inventory = Bukkit.createInventory(null, 27, ChatColorUtil.colored("&8>> &7Crafting &8| &6RzucaneTNT"));

        IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, this.glass));

        inventory.setItem(1, rzucanetnt_tnt.build());
        inventory.setItem(2, rzucanetnt_tnt.build());
        inventory.setItem(3, rzucanetnt_tnt.build());
        inventory.setItem(10, rzucanetnt_tnt.build());
        inventory.setItem(11, rzucanetnt_tnt.build());
        inventory.setItem(12, rzucanetnt_tnt.build());
        inventory.setItem(14, new ItemStackBuilder(Material.TNT).withTitle(ChatColorUtil.colored("&8>> &6RZUCANETNT &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby &6wybuchlo rzucanetnt")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());
        inventory.setItem(19, rzucanetnt_tnt.build());
        inventory.setItem(20, rzucanetnt_tnt.build());
        inventory.setItem(21, rzucanetnt_tnt.build());
        inventory.setItem(26, back.build());

        return inventory;
    }

    public Inventory stoniarka(Player player){
        final Inventory inventory = Bukkit.createInventory(null, 27, ChatColorUtil.colored("&8>> &7Crafting &8| &6Generator Stone"));

        IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, this.glass));

        inventory.setItem(1, stoniarka_redstone.build());
        inventory.setItem(2, stoniarka_iron.build());
        inventory.setItem(3, stoniarka_redstone.build());
        inventory.setItem(10, stoniarka_iron.build());
        inventory.setItem(11, stoniarka_stone.build());
        inventory.setItem(12, stoniarka_iron.build());
        inventory.setItem(14, new ItemStackBuilder(Material.ENDER_STONE).withTitle(ChatColorUtil.colored("&8>> &6STONIARKA &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby wygenerowac &6stone")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());
        inventory.setItem(19, stoniarka_redstone.build());
        inventory.setItem(20, stoniarka_piston.build());
        inventory.setItem(21, stoniarka_redstone.build());
        inventory.setItem(26, back.build());

        return inventory;
    }

}
