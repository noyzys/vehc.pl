package pl.kodicrew.developers.vehctools.events.inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;
import pl.kodicrew.developers.vehctools.utils.ItemUtil;
import pl.kodicrew.developers.vehctools.utils.PotionUtil;

public class InventoryListener implements Listener {

    private final ToolsPlugin plugin;

    public InventoryListener(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryCraftingClick(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equals(ChatColorUtil.colored("&8>> &7Wybor &8| &6Craftingow"))) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {

                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Crafting #1 &8| &6BoyFarmer &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().boyfarmer(player));
                }

                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Crafting #2 &8| &6SandFarmer &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().sandfarmer(player));
                }

                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Crafting #3 &8| &6KopaczFos &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().kopaczFos(player));
                }

                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Crafting #4 &8| &6Generator Stone &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().stoniarka(player));
                }

                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Crafting #5 &8| &6RzucaneTNT &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().rzucaneTnt(player));
                }

            }

        } else if (event.getInventory().getName().equals(ChatColorUtil.colored("&8>> &7Crafting &8| &6BoyFarmer"))) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &cPowrot &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().main(player));
                }
            }

        } else if (event.getInventory().getName().equals(ChatColorUtil.colored("&8>> &7Crafting &8| &6SandFarmer"))) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &cPowrot &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().main(player));
                }
            }

        } else if (event.getInventory().getName().equals(ChatColorUtil.colored("&8>> &7Crafting &8| &6KopaczFos"))) {
            event.setCancelled(true);

            if (event.getInventory() != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &cPowrot &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().main(player));
                }
            }

        } else if (event.getInventory().getName().equals(ChatColorUtil.colored("&8>> &7Crafting &8| &6Generator Stone"))) {
            event.setCancelled(true);

            if (event.getInventory() != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &cPowrot &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().main(player));
                }
            }
        } else if (event.getInventory().getName().equals(ChatColorUtil.colored("&8>> &7Crafting &8| &6RzucaneTNT"))) {
            event.setCancelled(true);

            if (event.getInventory() != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasDisplayName()) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &cPowrot &8<<"))) {
                    player.openInventory(this.plugin.getCraftingInventory().main(player));
                }
            }
        }
    }

    @EventHandler
    public void onClickInventoryDropBoss(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();

        if (event.getInventory() != null && event.getInventory().getName().equalsIgnoreCase(ChatColorUtil.colored("&8>> &7Drop &8| &6BOSS"))) {
            event.setCancelled(true);
            player.openInventory(this.plugin.getBossDropInventory().main(player));

        }
    }

    @EventHandler
    public void onClickInventoryEffects(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();

        if (event.getInventory().getName().equals(ChatColorUtil.colored("&8>> &7Wybierz &8| &6Efekt"))) {
            event.setCancelled(true);
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6SPEED I &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 32)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 32));
                PotionUtil.applyPotion(player, PotionEffectType.SPEED, 4000, 1);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: SPEED I! &7za: &6x32 Emerald blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");

        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6SPEED II &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 64)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 64));
                PotionUtil.applyPotion(player, PotionEffectType.SPEED, 8000, 2);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: SPEED II! &7za: &6x64 Emerald blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6STRENGTH I &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 32)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 32));
                PotionUtil.applyPotion(player, PotionEffectType.INCREASE_DAMAGE, 3000, 1);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: STRENGTH I! &7za: &6x32 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6STRENGTH II &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 64)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 64));
                PotionUtil.applyPotion(player, PotionEffectType.INCREASE_DAMAGE, 5000, 2);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: STRENGTH II! &7za: &6x64 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");

        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6JUMP BOOST I &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 32)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 32));
                PotionUtil.applyPotion(player, PotionEffectType.JUMP, 5000, 1);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: JUMP BOOST I! &7za: &6x32 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6JUMP BOOST II &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 64)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 64));
                PotionUtil.applyPotion(player, PotionEffectType.JUMP, 8000, 2);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: JUMP BOOST II! &7za: &6x64 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6HASTE I &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 32)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 32));
                PotionUtil.applyPotion(player, PotionEffectType.JUMP, 4000, 2);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: HASTE I! &7za: &6x32 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6HASTE I &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 32)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 32));
                PotionUtil.applyPotion(player, PotionEffectType.JUMP, 4000, 1);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: HASTE I! &77za: &6x32 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Efekt: &6HASTE II &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 64)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 64));
                PotionUtil.applyPotion(player, PotionEffectType.FAST_DIGGING, 8000, 2);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Efekt: HASTE II! &7za: &6x64 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");

        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Pakiet: &6Ucieczki &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 42)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 42));
                PotionUtil.applyPotion(player, PotionEffectType.JUMP, 7000, 2);
                PotionUtil.applyPotion(player, PotionEffectType.SPEED, 7000, 2);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Pakiet: UCIECZKA! &7za: &6x42 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Pakiet: &6Kopacza &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 46)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 46));
                PotionUtil.applyPotion(player, PotionEffectType.FAST_DIGGING, 7000, 2);
                PotionUtil.applyPotion(player, PotionEffectType.SPEED, 7000, 2);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Pakiet: KOPACZA! &7za: &6x46 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColorUtil.colored("&8>> &7Pakiet: &6Walki &8<<"))) {
            if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD_BLOCK), 34)) {

                ItemUtil.removeItems(player, new ItemStack(Material.EMERALD_BLOCK, 34));
                PotionUtil.applyPotion(player, PotionEffectType.FAST_DIGGING, 7000, 2);
                PotionUtil.applyPotion(player, PotionEffectType.SPEED, 7000, 2);
                PotionUtil.applyPotion(player, PotionEffectType.INCREASE_DAMAGE, 7000, 1);
                PotionUtil.applyPotion(player, PotionEffectType.REGENERATION, 1200, 1);
                PotionUtil.applyPotion(player, PotionEffectType.FIRE_RESISTANCE, 7000, 2);

                ChatColorUtil.sendMessage(player, "&8>> &7Zakupiles &6Pakiet: WALKI! &7za: &6x34 Emerald Blokow");

            } else ChatColorUtil.sendMessage(player, "&cBlad: Nie posiadasz odpowiedniej ilosci blokow emeraldow");
        }
    }
}

