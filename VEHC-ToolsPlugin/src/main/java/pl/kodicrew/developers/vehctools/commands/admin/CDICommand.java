package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class CDICommand extends CommandExecutor {

    private boolean cdi = true;

    public CDICommand() {
        super("cdi", "vehc.edition", "/cdi <enable/disable>", "diamond");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        switch (args[0].toLowerCase()) {

            case "enable": {
                this.cdi = true;
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &6Diamentowe itemy &7zostaly: &aWlaczone");
                    ChatColorUtil.sendMessage(players, " &8>> &7Mozesz juz: &6Crafowac oraz uzywac :)");
                    ChatColorUtil.sendMessage(players, "   &8>> &7Wlaczyl admin: &f" + player.getName());
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&l&oMILEJ GRY NA SERWERZE &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64OPE.PL &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
                });
                break;

            }

            case "disable": {
                this.cdi = false;
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &6Diamentowe itemy &7zostaly: &cWylaczone");
                    ChatColorUtil.sendMessage(players, " &8>> &7Gramy na: &6Only Zelazne sety i itemy :)");
                    ChatColorUtil.sendMessage(players, "   &8>> &7Wlaczyl admin: &f" + player.getName());
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&l&oMILEJ GRY NA SERWERZE &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64OPE.PL &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
                });
                break;
            }
        }
        return true;
    }
}
