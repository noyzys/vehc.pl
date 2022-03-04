package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class HelpCommand extends CommandExecutor {

    public HelpCommand() {
        super("pomoc", "vehc.pomoc", "/pomoc", "pomocna");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        ChatColorUtil.sendMessage(player, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "   &8>>&8&m--------&8[ &6RANGI &8]&8&m--------&8<<");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, " &8>> &6/vip &8- &7Informacje dotyczace rangi &8[&6VIP&8]");
        ChatColorUtil.sendMessage(player, " &8>> &6/svip &8- &7Informacje dotyczace rangi &8[&eSVIP&8]");
        ChatColorUtil.sendMessage(player, " &8>> &6/sponsor &8- &7Informacje dotyczace rangi &8[&9SPONSOR&8]");
        ChatColorUtil.sendMessage(player, " &8>> &6/kozak &8- &7Informacje dotyczace rangi &8[&4K&cO&6Z&eA&3K&8]");
        ChatColorUtil.sendMessage(player, " &8>> &6/yt &8- &7Informacje dotyczace rangi &8[&fYou&4Tuber&8]");
        ChatColorUtil.sendMessage(player, " &8>> &6/yt+ &8- &7Informacje dotyczace rangi &8[&fYou&4Tuber&6+&8]");
        ChatColorUtil.sendMessage(player, " ");

        ChatColorUtil.sendMessage(player, "   &8>>&8&m--------&8[ &6INFORMACJE &8]&8&m--------&8<<");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, " &8>> &6/drop &8- &7Menu dropu na serwerze ");
        ChatColorUtil.sendMessage(player, " &8>> &6/itemy &8- &7Itemy na gildie");
        ChatColorUtil.sendMessage(player, " &8>> &6/kit &8- &7Darmowe zestawy");
        ChatColorUtil.sendMessage(player, " &8>> &6/g &8| &6/gildie &8- &7Gildie na serwerze");
        ChatColorUtil.sendMessage(player, " &8>> &6/craftingi &8- &7Craftingi na serwerze");
        ChatColorUtil.sendMessage(player, " &8>> &6/spawn &8- &7Przenosi na spawn");
        ChatColorUtil.sendMessage(player, " &8>> &6/tpa &8- &7Teleportuje do gracza &8(&c5sekund&8)");
        ChatColorUtil.sendMessage(player, " &8>> &6/efekty &8- &7Otwiera GUI z przedmiotami");
        ChatColorUtil.sendMessage(player, " &8>> &6/helpop &8- &7Szybki kontakt z adminem");
        ChatColorUtil.sendMessage(player, " &8>> &6/ec &8- &7Przenosny enderchest");
        ChatColorUtil.sendMessage(player, " &8>> &6/rekru &8- &7Informacje dotyczace rekru");
        ChatColorUtil.sendMessage(player, " &8>> &6/sklep &8- &7Sklep z przedmiotami");
        ChatColorUtil.sendMessage(player, " &8>> &6/nowosci &8- &7Nowosci na serwerze");
        ChatColorUtil.sendMessage(player, " &8>> &6/list &8- &7Liczba osob na serwerze");
        ChatColorUtil.sendMessage(player, " &8>> &6/schowek &8- &7Tam znajdziesz wszystkie: &6koxy,refy,perly-");

        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "   &8>> &7WWW: &6VEHC.PL/");
        ChatColorUtil.sendMessage(player, "   &8>> &7TS3: &64OPE.PL");
        ChatColorUtil.sendMessage(player, "   &8>> &7FB: &6FB.COM/VEHCPL");
        ChatColorUtil.sendMessage(player, "");
        ChatColorUtil.sendMessage(player, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
        return true;
    }
}
