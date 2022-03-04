package pl.kodicrew.developers.vehctools.events.interacts;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Button;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;
import pl.kodicrew.developers.vehctools.utils.ItemUtil;
import pl.kodicrew.developers.vehctools.utils.RandomUtil;

import java.util.Random;

public class PlayerInteractListener implements Listener {

    private final ToolsPlugin plugin;

    public PlayerInteractListener(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler public void onInteractRzucaneTNT(PlayerInteractEvent event) {
        final Player player = event.getPlayer();

        if (!event.getAction().equals(Action.RIGHT_CLICK_AIR) && !event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && !event.getAction().equals(Action.LEFT_CLICK_BLOCK)) return;

        if (ChatColorUtil.colored("&8>> &cRuzcaneTNT &8<<").equals(event.getItem().getItemMeta().getDisplayName())) {
            final Location loc = player.getLocation();

            final Entity tnt = player.getWorld().spawn(loc, TNTPrimed.class);
            tnt.setVelocity(loc.getDirection().multiply(0.7));
            tnt.getLocation().setY(loc.getY() + 1.0D);

            ItemUtil.removeItems(player, "");
        }
    }

    @EventHandler
    public void onInteractRTP(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Block bloc = event.getClickedBlock();

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        final Location block = bloc.getLocation().add(1.0, 0.0, 0.0);
        final Location block2 = bloc.getLocation().add(-1.0, 0.0, 0.0);
        final Location block3 = bloc.getLocation().add(0.0, 0.0, 1.0);
        final Location block4 = bloc.getLocation().add(0.0, 0.0, -1.0);

        if (bloc.getType() != Material.STONE_BUTTON) return;

        if (block.getBlock().getType() == Material.JUKEBOX || block2.getBlock().getType() == Material.JUKEBOX || block3.getBlock().getType() == Material.JUKEBOX || block4.getBlock().getType() == Material.JUKEBOX) {
            this.plugin.getRandomTeleportManager().teleportRandomPlayer(player);

            final Location loc = player.getLocation();
            ChatColorUtil.sendMessage(player, " &8>> &7Zostales teleportowany na &6Losowe Kordy &6 X: " + loc.getBlockX() + " Y: " + loc.getBlockY() + " Z: " + loc.getBlockZ());
        }

        if (block.getBlock().getType() == Material.JUKEBOX || block2.getBlock().getType() == Material.JUKEBOX || block3.getBlock().getType() == Material.JUKEBOX || block4.getBlock().getType() == Material.JUKEBOX) {
            final Location randomloc = this.plugin.getRandomTeleportManager().randomLocation(player);

            this.plugin.getRandomTeleportManager().findPlayers(bloc.getLocation(), 5)
                    .stream()
                    .map(Bukkit::getPlayer).filter(player2 -> player != null)
                    .forEach(player2 -> {

                player.teleport(randomloc);
                final Location loc2 = player.getLocation();
                ChatColorUtil.sendMessage(player, " &8>> &7Zostales teleportowany na &6Losowe Kordy &6 X: " + loc2.getBlockX() + " Y: " + loc2.getBlockY() + " Z: " + loc2.getBlockZ());
            });
        }
    }

    public void onInteractGRTP(final PlayerInteractEvent event) {

        if (!event.hasBlock()) return;

        final Block block = event.getClickedBlock();

        if (block.getType() == Material.STONE_BUTTON) {
            final Button btn = (Button)block.getState().getData();
            final Block base = block.getRelative(btn.getAttachedFace());

            if (base.getType() != Material.JUKEBOX) return;
            this.plugin.getRandomTeleportManager().randomTeleport(event.getPlayer());
        }
    }

    @EventHandler
    public void onInteractRandomTP(PlayerInteractEvent event) {
        final Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType() == Material.STONE_BUTTON) {
            final Location location = event.getClickedBlock().getLocation().add(0.0, -0.1, 0.0);

            if (location.getBlock().getType() == Material.JUKEBOX) {
                new Random();

                final int x = RandomUtil.getRandInt(-2000, 2000);
                final int z = RandomUtil.getRandInt(-2000, 2000);
                final double y = player.getWorld().getHighestBlockYAt(x, z) + 1.5f;
                for (Player players : this.plugin.getRandomTeleportManager().getPlayersInRadious(event.getClickedBlock().getLocation(), 2)) {
                    final Location loc = new Location(event.getPlayer().getWorld(), x, event.getPlayer().getWorld().getHighestBlockYAt(x, z), z);

                    final Biome biome = loc.getBlock().getBiome();
                    if (biome == Biome.OCEAN || biome == Biome.DEEP_OCEAN) {
                        ChatColorUtil.sendMessage(player, "&cBlad: Trafiles na Biom: OCEAN");
                        return;
                    }
                    event.getPlayer().teleport(loc);
                    final Location ploc = new Location(event.getPlayer().getWorld(), event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockY(), event.getPlayer().getLocation().getBlockZ());
                    ploc.setX(event.getPlayer().getLocation().getY() + 5.0);
                    event.getPlayer().teleport(ploc);

                    players.teleport(event.getPlayer().getLocation());
                    ChatColorUtil.sendMessage(player, "&8>> &7Przeteleportowano na: &6Losowe kordy!: X: " + x + " Y: " + y + " Z: " + z);
                    ItemUtil.giveItems(player, new ItemStack(Material.COOKED_BEEF, 64));
                    players.updateInventory();
                }
            }
        }

//    @EventHandler
//    public void onInteractRandomTP(PlayerInteractEvent event) {
//        final Player player = event.getPlayer();
//
//        if (!event.hasBlock()) return;
//
//        final Block block = event.getClickedBlock();
//        if (block.getType() != Material.STONE_BUTTON) return;
//
//        final Button button = (Button) block.getState().getData();
//        final Block base = block.getRelative(button.getAttachedFace());
//
//        if (base.getType() != Material.JUKEBOX) return;
//
//        final int x = RandomUtil.getRandInt(-2000, 2000);
//        final int z = RandomUtil.getRandInt(-2000, 2000);
//        final double y = player.getWorld().getHighestBlockYAt(x, z) + 1.5f;
//        ChatColorUtil.sendMessage(player, "&8>> &7Przeteleportowano na: &6Losowe kordy!: X: " + x + " Y: " + y + " Z: " + z);
//    }
    }
}

