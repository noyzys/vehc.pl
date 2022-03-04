package pl.kodicrew.developers.vehctools.impl;

import com.google.common.collect.ImmutableList;
import io.netty.util.internal.ThreadLocalRandom;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import pl.kodicrew.developers.vehctools.impl.managers.RandomTeleportManager;
import pl.kodicrew.developers.vehctools.utils.ItemUtil;
import pl.kodicrew.developers.vehctools.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RandomTeleportManagerImpl implements RandomTeleportManager {

    private ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean randomTeleport(Player player) {
        final int x = RandomUtil.getRandInt(-2000, 2000);
        final int z = RandomUtil.getRandInt(-2000, 2000);
        final double y = player.getWorld().getHighestBlockYAt(x, z) + 1.5f;
        final Location location = new Location(player.getWorld(), x, y, z);
        final Biome biome = location.getBlock().getBiome();

        if (biome == Biome.OCEAN || biome == Biome.DEEP_OCEAN) return randomTeleport(player);

        player.teleport(location, PlayerTeleportEvent.TeleportCause.PLUGIN);
        ItemUtil.giveItems(player, new ItemStack(Material.COOKED_BEEF, 64));
        player.updateInventory();
        return true;
    }

    @Override
    public List<Player> getPlayersInRadious(Location location, int size) {
        return location.getWorld().getPlayers()
                .stream()
                .filter(player -> location.distance(player.getLocation()) <= size)
                .collect(Collectors.toList());
    }

    @Override
    public void teleportRandomPlayer(Player player) {
        final double d = random.nextInt(5000);
        final Location location = new Location(player.getWorld(), d, 0.0, d);

        location.setY(location.getWorld().getHighestBlockAt(location).getLocation().getY() + 3.5);
        player.teleport(location);
    }

    @Override
    public Location randomLocation(Player player) {
        final double d = random.nextInt(5000);
        final Location location = new Location(player.getWorld(), d, 0.0, d);

        location.setY(location.getWorld().getHighestBlockAt(location).getLocation().getY() + 3.5);
        return location;
    }

    @Override
    public ImmutableList<UUID> findPlayers(Location location, int size) {
        final List<UUID> playersInDistance = location.getWorld().getPlayers()
                .stream()
                .filter(player -> location.distance(player.getLocation()) <= size)
                .map(Entity::getUniqueId)
                .collect(Collectors.toList());

        return ImmutableList.copyOf(playersInDistance);
    }
}
