package pl.kodicrew.developers.vehctools.events.blocks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.builders.ItemStackBuilder;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;
import pl.kodicrew.developers.vehctools.utils.ItemUtil;

import java.util.stream.IntStream;

public class BlockPlaceListener implements Listener {

    private final ToolsPlugin plugin;

    public BlockPlaceListener(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler public void onPlaceFarmers(BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final ItemStack item = event.getItemInHand();

        if (ChatColorUtil.colored("&8>> &6BOYFARMER &8<<").equals(item.getItemMeta().getDisplayName())) {
            event.getBlockPlaced().setType(Material.OBSIDIAN);

            IntStream.range(event.getBlockPlaced().getY() - 1, 0).forEach(i -> {
                final Block block = event.getBlock().getWorld().getBlockAt(event.getBlockPlaced().getX(), i, event.getBlockPlaced().getZ());

                if (block.getType() == Material.BEDROCK) return;

                block.setType(Material.OBSIDIAN);
            });
        }

        if (MessageHelper.colored("&8>> &6SANDFARMER &8<<").equals(itemHand.getItemMeta().getDisplayName())) {
            event.getBlockPlaced().setType(Material.SANDSTONE);

            IntStream.range(event.getBlockPlaced().getY() - 1, 0).forEach(i -> {
                final Block block = event.getBlock().getWorld().getBlockAt(event.getBlockPlaced().getX(), i, event.getBlockPlaced().getZ());

                if (block.getType() == Material.BEDROCK) return;

                block.setType(Material.SAND);
            });
        }

        if (MessageHelper.colored("&8>> &6KOPACZFOS &8<<").equals(itemHand.getItemMeta().getDisplayName())) {
            event.getBlockPlaced().setType(Material.AIR);

            for (int hight = event.getBlockPlaced().getY() - 1; hight > 0; --hight) {
                final Block block = event.getBlock().getWorld().getBlockAt(event.getBlockPlaced().getX(), hight, event.getBlockPlaced().getZ());

                if (block.getType() == Material.BEDROCK) return;

                block.setType(Material.AIR);
            }
        }
    }

    @EventHandler
    public void onPlacePremiumCase(BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();

        if (block.getType() == Material.CHEST && event.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColorUtil.colored("&8>> &9&lPremiumCase &8<<"))) {
            block.setType(Material.AIR);
            final int random = this.plugin.getPremiumCaseManager().getRandInt(1, 100);

            if (random <= 1) {

                ItemUtil.giveItems(player, new ItemStack(Material.BEACON, 1));
            }

            if (random > 5 && random <= 15) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(15, 12);
                ItemUtil.giveItems(player, new ItemStack(Material.TNT, amount));
            }

            if (random > 15 && random <= 30) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(2, 5);
                ItemUtil.giveItems(player, new ItemStack(Material.GOLDEN_APPLE, amount));
            }

            if (random > 30 && random <= 55) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(10, 31);
                ItemUtil.giveItems(player, new ItemStack(Material.EMERALD_BLOCK, amount));
            }

            if (random > 55 && random <= 65) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(4, 2);
                ItemUtil.giveItems(player, new ItemStack(Material.GOLDEN_APPLE, amount, (short) 1));
            }

            if (random > 12 && random <= 20) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(4, 16);
                ItemUtil.giveItems(player, new ItemStack(Material.ENDER_PEARL, amount));
            }

            if (random > 75 && random <= 85) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(4, 16);
                ItemUtil.giveItems(player, new ItemStack(Material.GOLD_BLOCK, amount));

            }

            if (random > 85 && random <= 90) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(4, 16);
                ItemUtil.giveItems(player, new ItemStack(Material.DIAMOND_BLOCK, amount));

            }
            if (random > 90 && random <= 100) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(3, 6);
                ItemUtil.giveItems(player, new ItemStackBuilder(Material.OBSIDIAN, amount).withTitle(ChatColorUtil.colored("&8>> &6BOYFARMER &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby wygenerowac &6sciane z obsidianu")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());

            }

            if (random > 70 && random <= 101) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(2, 5);
                ItemUtil.giveItems(player, new ItemStackBuilder(Material.ENDER_STONE).withTitle(ChatColorUtil.colored("&8>> &6STONIARKA &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby wygenerowac &6stone")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());
            }

            if (random > 60 && random <= 103) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(2, 5);
                ItemUtil.giveItems(player, new ItemStackBuilder(Material.SAND).withTitle(ChatColorUtil.colored("&8>> &6SANDFARMER &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby wygenerowac &6sciane z piasku")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());

            }

            if (random > 40 && random <= 90) {

                final int amount = this.plugin.getPremiumCaseManager().getRandInt(2, 5);
                ItemUtil.giveItems(player, new ItemStackBuilder(Material.STONE).withTitle(ChatColorUtil.colored("&8>> &6KOPACZFOS &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby zrobic: &6dziure w ziemi")).withLore(ChatColorUtil.colored("&8>> &a&l&oMILEJ GRY NA SERWERZE &8<<")).withLore(ChatColorUtil.colored("")).build());
            }

            block.setType(Material.AIR);
        }
    }
}
