package pl.kodicrew.developers.vehctools.task;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
import org.bukkit.scheduler.BukkitRunnable;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;
import pl.kodicrew.developers.vehctools.utils.RandomUtil;

public class BossRespawnTask extends BukkitRunnable {

    private final ToolsPlugin plugin;

    public BossRespawnTask(ToolsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if (this.plugin.getBossManager().getSpawn()) return;

        final int x = RandomUtil.getRandInt(-1500, 1500);
        final int z = RandomUtil.getRandInt(-1500, 1500);
        final Location loc = new Location(Bukkit.getWorld("world"), (double)x, 90.0, (double)z);

        final Chunk chunk = loc.getChunk();
        Bukkit.getWorld("world").loadChunk(chunk);
        final Giant boss = (Giant)Bukkit.getWorld("world").spawnEntity(loc, EntityType.GIANT);
//        Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), x, 120, z), EntityType.GIANT);

        Bukkit.getOnlinePlayers().forEach(players -> {
            ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
            ChatColorUtil.sendMessage(players, "");
            ChatColorUtil.sendMessage(players, "  &8>> &7Boss Zostal &6Zrespiony! biegnij do niego po kozak ity ;)");
            ChatColorUtil.sendMessage(players, "  &8>> &7Kordy Bossa: &6X: " + x + " Y:" + Bukkit.getWorld("world").getHighestBlockYAt(x, z) + " Z: " + z);
            ChatColorUtil.sendMessage(players, "");
            ChatColorUtil.sendMessage(players, "&8&m-----------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m-----------");
        });
    }
}

