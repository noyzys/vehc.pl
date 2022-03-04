package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.apies.packets.TitleSubTitlePacket;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class PremiumCaseCommand extends CommandExecutor {

    private final ToolsPlugin plugin;

    public PremiumCaseCommand(ToolsPlugin plugin) {
        super("premiumcase", "vehc.premiumcase", "/premiumcase <all/ilosc>", "pc", "case", "keroxlkurwa");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;
//
//        switch (args[0].toLowerCase()) {
//
//            case "daj":
//                final Player player2 = Bukkit.getPlayerExact(args[0]);
//                 if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany player jest offline");
//                this.plugin.getPremiumCaseManagerCreator().premiumCaseChest(player2, Integer.parseInt(args[1]));
//                ChatColorUtil.sendMessage(player, "&8>> &7Dales graczowi: &6" + player2.getName() + " &7premiucase o ilosci: &6x" + args[1]);
//                ChatColorUtil.sendMessage(player2, "&8>> &7Otrzymales premiumcase o ilosci: &6x" + args[1] + " &7od admina: &6" + player.getName());

        switch (args[0].toLowerCase()){

            case "all":
                final int amount = Integer.parseInt(args[1]);

                Bukkit.getOnlinePlayers().forEach(players -> {
                    this.plugin.getPremiumCaseManagerCreator().premiumCaseChest(players, amount);
                    TitleSubTitlePacket.sendTitle(players, "", "&8>> &7Kazdy otrzymal: &6x" + amount + " premiumcase! &8<<", 40, 70, 100);
                    ChatColorUtil.sendMessage(players, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Kazdy dostal &9&lPremiumCase &7w ilosci: &8(&6" + amount + "&8)");
                    ChatColorUtil.sendMessage(players, "     &8>> &7Od Admina: &f" + player.getName());
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &7WWW: &6VEHC.PL/ &8| &7TS3: &64OPE.PL &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
                });
                break;
        }
        return true;
    }
}
