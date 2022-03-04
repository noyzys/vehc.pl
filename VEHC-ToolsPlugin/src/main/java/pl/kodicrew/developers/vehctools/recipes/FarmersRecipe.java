package pl.kodicrew.developers.vehctools.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.builders.ItemStackBuilder;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class FarmersRecipe {

    private final ToolsPlugin plugin;

    private ItemStackBuilder boyfarmer = new ItemStackBuilder(Material.OBSIDIAN).withTitle(ChatColorUtil.colored("&8>> &6BOYFARMER &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemie aby: &6Stworzyc sciane z obsidianu"));

    private ItemStackBuilder sandfarmer = new ItemStackBuilder(Material.SANDSTONE).withTitle(ChatColorUtil.colored("&8>> &6SANDFARMER &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemie aby: &6Stworzyc sciane z piasku"));

    private ItemStackBuilder kopaczfos = new ItemStackBuilder(Material.STONE).withTitle(ChatColorUtil.colored("&8>> &6KOPACZFOS &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemie aby: &6Zrobic dziure do bedrocka"));

    private ItemStackBuilder stoniarka = new ItemStackBuilder(Material.ENDER_STONE).withTitle(ChatColorUtil.colored("&8>> &6STONIARKA &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemie aby: &6Wygenerowac generator stone"));

    private ItemStackBuilder rzucanetnt = new ItemStackBuilder(Material.TNT).withTitle(ChatColorUtil.colored("&8>> &cRuzcaneTNT &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Kliknij: &6PPM aby wyrzucic rzucaka zeby wybuchl"));

    public FarmersRecipe(ToolsPlugin plugin) {
        this.plugin = plugin;
    }


    public void createRecipe() {
        ShapedRecipe recipeBoy = new ShapedRecipe(this.boyfarmer.build());
        recipeBoy.shape("abc", "abc", "abc");

        recipeBoy.setIngredient('a', Material.OBSIDIAN).setIngredient('b', Material.OBSIDIAN).setIngredient('c', Material.OBSIDIAN).setIngredient('a', Material.OBSIDIAN).setIngredient('b', Material.OBSIDIAN).setIngredient('c', Material.OBSIDIAN).setIngredient('a', Material.OBSIDIAN).setIngredient('b', Material.OBSIDIAN).setIngredient('c', Material.OBSIDIAN);
        Bukkit.addRecipe(recipeBoy);


        ShapedRecipe recipeSand = new ShapedRecipe(this.sandfarmer.build());
        recipeSand.shape("abc", "abc", "abc");

        recipeSand.setIngredient('a', Material.SAND).setIngredient('b', Material.SAND).setIngredient('c', Material.SAND).setIngredient('a', Material.SAND).setIngredient('b', Material.SAND).setIngredient('c', Material.SAND).setIngredient('a', Material.SAND).setIngredient('b', Material.SAND).setIngredient('c', Material.SAND);
        Bukkit.addRecipe(recipeSand);


        ShapedRecipe recipeKopacz = new ShapedRecipe(this.kopaczfos.build());
        recipeKopacz.shape("abc", "abc", "abc");

        recipeKopacz.setIngredient('a', Material.STONE).setIngredient('b', Material.STONE).setIngredient('c', Material.STONE).setIngredient('a', Material.STONE).setIngredient('b', Material.STONE).setIngredient('c', Material.STONE).setIngredient('a', Material.STONE).setIngredient('b', Material.STONE).setIngredient('c', Material.STONE);
        Bukkit.addRecipe(recipeKopacz);


        ShapedRecipe recipeRzucane = new ShapedRecipe(this.rzucanetnt.build());
        recipeRzucane.shape("abc", "abc", "abc");

        recipeRzucane.setIngredient('a', Material.TNT).setIngredient('b', Material.TNT).setIngredient('c', Material.TNT).setIngredient('a', Material.TNT).setIngredient('b', Material.TNT).setIngredient('c', Material.TNT).setIngredient('a', Material.TNT).setIngredient('b', Material.TNT).setIngredient('c', Material.TNT);
        Bukkit.addRecipe(recipeRzucane);

    }


    public ItemStackBuilder getBoyfarmer() {
        return boyfarmer;
    }

    public ItemStackBuilder getSandfarmer() {
        return sandfarmer;
    }

    public ItemStackBuilder getKopaczfos() {
        return kopaczfos;
    }

    public ItemStackBuilder getStoniarka() {
        return stoniarka;
    }

    public ItemStackBuilder getRzucanetnt() {
        return rzucanetnt;
    }
}
