package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;
import pl.kodicrew.developers.vehctools.utils.IntegerUtil;

public class TimeCommand extends CommandExecutor {

    public TimeCommand() {
        super("time", "vehc.time", "/time czas <day, night, rain, sun, thunder>", "czas", "suka");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        final Player player = (Player) sender;
        final World world = player.getWorld();

        if (IntegerUtil.isInteger(args[0])) {
            world.setTime(Integer.parseInt(args[0]));
            return ChatColorUtil.sendMessage(player, "&8>> &7Ustawiles czas na: &6" + args[0]);
        }
        switch (args[0].toLowerCase()){

            case "day": {
                world.setTime(1000L);
                return ChatColorUtil.sendMessage(player, "&8>> &7Ustawiles czas na: &6&l&oDzien");
            }

            case "night": {
                world.setTime(17000L);
                return ChatColorUtil.sendMessage(player, "&8>> &7Ustawiles czas na: &6&l&oNoc");
            }

            case "rain": {
                world.setStorm(true);
                world.setThundering(true);
                return ChatColorUtil.sendMessage(player, "&8>> &7Ustawiles pogode na: &6&l&odeszcz");
            }

            case "sun": {
                world.setThundering(false);
                world.setStorm(false);
                return ChatColorUtil.sendMessage(player ,"&8>> &7Ustawiles pogode na: &6&l&osloneczna");

            }

            case "thunder": {
                world.setThundering(true);
                world.setStorm(true);
                return ChatColorUtil.sendMessage(player, "&8>> &7Ustawiles pogode na: &6&l&oburze");

            } default: return ChatColorUtil.sendMessage(player, "&cBlad: Podana strefa czasowa nie istnieje");
        }
    }
}
