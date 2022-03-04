package pl.kodicrew.developers.vehctools.impl.managers;

import com.google.common.collect.ImmutableList;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.UUID;

public interface RandomTeleportManager {

    boolean randomTeleport(Player player);

    List<Player> getPlayersInRadious(Location location, int size);

    void teleportRandomPlayer(Player player);

    Location randomLocation(Player player);

    ImmutableList<UUID> findPlayers(final Location location, final int size);
}
