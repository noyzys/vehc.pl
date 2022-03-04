package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class HealCommand extends CommandExecutor {

    public HealCommand() {
        super("heal", "vehc.heal", "/heal nick", "ulecz", "chui");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER!");
            return true;
        }
        final Player player = (Player) sender;
        if (args.length == 0) {
            player.setFoodLevel(20);
            player.setHealth(20.0);

            player.getActivePotionEffects()
                    .stream()
                    .map(PotionEffect::getType)
                    .forEach(player::removePotionEffect);

            return ChatColorUtil.sendMessage(player, "&8>> &7Uleczyles &6Siebie");
        }

        final Player player2 = Bukkit.getPlayerExact(args[0]);
        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany gracz jest offline");

        player2.setFoodLevel(20);
        player2.setHealth(20.0);

        player2.getActivePotionEffects()
                .stream()
                .map(PotionEffect::getType)
                .forEach(player2::removePotionEffect);

        ChatColorUtil.sendMessage(player, "&8>> &7Uleczyles gracza: &6" + player2.getName());
        return ChatColorUtil.sendMessage(player2, "&8>> &7Zostales &6uleczony &7przez admina: &6" + player.getName());
    }
}

