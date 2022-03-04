package pl.kodicrew.developers.vehctools.events.entites;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.builders.ItemStackBuilder;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;
import pl.kodicrew.developers.vehctools.utils.ItemUtil;
import pl.kodicrew.developers.vehctools.utils.RandomUtil;

public class EntityDeathListener implements Listener {

    private final ToolsPlugin plugin;

    public EntityDeathListener(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeathBoss(EntityDeathEvent event) {

        if (event.getEntity() instanceof Player) return;

        if (event.getEntity().getKiller() == null) return;

        final Entity entity = event.getEntity();
        final Player player = event.getEntity().getKiller();

        if (entity.getType() != EntityType.GIANT) return;

        this.plugin.getBossManager().setBoss(false);
        final int random = RandomUtil.getRandInt(0, 100);

        if (random > 1 && random <= 10) {
            ItemUtil.giveItems(player, new ItemStackBuilder(Material.TRIPWIRE_HOOK, 1).withTitle(ChatColorUtil.colored("&8>> &c&lVOUCHER NA GILDIE &8<<")).build());
            player.sendTitle(ChatColorUtil.colored(""), ChatColorUtil.colored("&8>> &cZabiles bossa! GRATULACJE &8<<"));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 2));

            Bukkit.getOnlinePlayers().forEach(players -> {
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &7Gracz: &f" + player.getName() + " &czabil BOSSA!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Wydropil z niego item: &6VOUCHER NA ITEMY NA GILDIE x1!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Drop z bossa pod: &6/bossdrop");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &a&l&oGRATULACJE WOJOWNIKU! &8<<");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
            });
        }

        if (random > 30 && random <= 35) {
            ItemUtil.giveItems(player, new ItemStackBuilder(Material.DIAMOND_SWORD).withTitle(ChatColorUtil.colored("&8>> &5&lMIECZ BOGA &8<<")).withEnchantment(Enchantment.DAMAGE_ALL, 6).withEnchantment(Enchantment.FIRE_ASPECT, 2).build());
            player.sendTitle(ChatColorUtil.colored(""), ChatColorUtil.colored("&8>> &cZabiles bossa! GRATULACJE &8<<"));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 2));

            Bukkit.getOnlinePlayers().forEach(players -> {
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &7Gracz: &f" + player.getName() + " &czabil BOSSA!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Wydropil z niego item: &6Miecz Boga x1!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Drop z bossa pod: &6/bossdrop");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &a&l&oGRATULACJE WOJOWNIKU! &8<<");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
            });
        }

        if (random > 50 && random <= 55) {
            ItemUtil.giveItems(player, new ItemStackBuilder(Material.DIAMOND_CHESTPLATE).withTitle(ChatColorUtil.colored("&8>> &5&lKLATA BOGA &8<<")).withEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5).withEnchantment(Enchantment.DURABILITY, 3).build());
            player.sendTitle(ChatColorUtil.colored(""), ChatColorUtil.colored("&8>> &cZabiles bossa! GRATULACJE &8<<"));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 2));


            Bukkit.getOnlinePlayers().forEach(players -> {
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &7Gracz: &f" + player.getName() + " &czabil BOSSA!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Wydropil z niego item: &6Klata Boga x1!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Drop z bossa pod: &6/bossdrop");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &a&l&oGRATULACJE WOJOWNIKU! &8<<");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
            });
        }

        if (random > 70  && random <= 80) {
            ItemUtil.giveItems(player, new ItemStackBuilder(Material.CHEST, 2).withTitle(ChatColorUtil.colored("&8>> &9&lPremiumCase &8<<")).withLore(ChatColorUtil.colored("&8>> &7Postaw na ziemi aby &6otworzyc!")).build());
            player.sendTitle(ChatColorUtil.colored(""), ChatColorUtil.colored("&8>> &cZabiles bossa! GRATULACJE &8<<"));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 2));


            Bukkit.getOnlinePlayers().forEach(players -> {
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &7Gracz: &f" + player.getName() + " &czabil BOSSA!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Wydropil z niego item: &6PremiumCase x2!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Drop z bossa pod: &6/bossdrop");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &a&l&oGRATULACJE WOJOWNIKU! &8<<");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
            });
        }

        if (random > 90 && random <= 95) {

            ItemUtil.giveItems(player, new ItemStack(Material.WEB, 2));
            player.sendTitle(ChatColorUtil.colored(""), ChatColorUtil.colored("&8>> &cZabiles bossa! GRATULACJE &8<<"));
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 120, 2));


            Bukkit.getOnlinePlayers().forEach(players -> {
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &7Gracz: &f" + player.getName() + " &czabil BOSSA!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Wydropil z niego item: &6Pajeczyna x2!");
                ChatColorUtil.sendMessage(players, "  &8>> &7Drop z bossa pod: &6/bossdrop");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "  &8>> &a&l&oGRATULACJE WOJOWNIKU! &8<<");
                ChatColorUtil.sendMessage(players, "");
                ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
            });
        }
    }
}
