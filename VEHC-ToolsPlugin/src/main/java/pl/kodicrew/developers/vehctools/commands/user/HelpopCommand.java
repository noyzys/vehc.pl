package pl.kodicrew.developers.vehctools.commands.user;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.enums.TimeCooldown;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class HelpopCommand extends CommandExecutor {

    private final ToolsPlugin plugin;

    public HelpopCommand(ToolsPlugin plugin) {
        super("helpop", "vehc.helpop", "/helpop", "pomocy");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        final Long cooldown = this.plugin.getCooldownManager().cooldown.get(player.getUniqueId());
        if (cooldown != null && System.currentTimeMillis() - cooldown < TimeCooldown.SECOND.getTime(10)) return ChatColorUtil.sendMessage(player, "&cBlad: Na helpopie mozna piasac co 10sekund...");

        final String message = StringUtils.join(args, " ", 1, args.length);
        ChatColorUtil.sendMessage(player, "&8>> &7Wyslano wiadomosc do &6administracji &7o tresci: &6" + message);

        Bukkit.getOnlinePlayers().forEach(admin -> {
            admin.hasPermission("vehc.helpop.admin");
            plugin.getCooldownManager().cooldown.put(player.getUniqueId(), System.currentTimeMillis());
            ChatColorUtil.sendMessage(admin, "&8[&6CENTRUM POMOCY&8] &8>> &7Gracz: &6" + player.getName() + " &7tresc: &6" + message);
        });
        return true;
    }
}

