package pl.kodicrew.developers.vehctools.commands.user;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class NewsCommand extends CommandExecutor {

    public NewsCommand() {
        super("nowosci", "vehc.nowosci", "", "");
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
        ChatColorUtil.sendMessage(player, " &8>> &7Co zmieniono &8| &adodano &8| &cusunieto &7na serwerze?");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "  &e1. &8>> &7Zostaly &6Postawione Autorskie Toolsy");
        ChatColorUtil.sendMessage(player, "  &e2. &8>> &7Zmienilismy wyglad &6tablisty");
        ChatColorUtil.sendMessage(player, "  &e3. &8>> &7Posiadamy nowy system &6zabezpieczen");
        ChatColorUtil.sendMessage(player, "  &e4. &8>> &7Nowy &6antycheat &7na serwerze");
        ChatColorUtil.sendMessage(player, "  &e5. &8>> &7Nowy wyglad &6komend");
        ChatColorUtil.sendMessage(player, "  &e6. &8>> &7Napisano i zoptymalizowano pliki na &6lobby");
        ChatColorUtil.sendMessage(player, "  &e7. &8>> &7Posiadamy nowy wyglad &6plikow");
        ChatColorUtil.sendMessage(player, "  &e8. &8>> &7Nowa administracja &6serwera");
        ChatColorUtil.sendMessage(player, "  &e9. &8>> &7Serwer jest teraz &6100% stabilny i bezpieczny");
        ChatColorUtil.sendMessage(player, "  &e10. &8>> &7Nowe Inventory w: &6/schowek");
        ChatColorUtil.sendMessage(player, "  &e11. &8>> &7Dodalismy &6Bossy na losowych kordach");
        ChatColorUtil.sendMessage(player, "  &e12. &8>> &7Dodalismy &6Drop z bossow /bossdrop");
        ChatColorUtil.sendMessage(player, "  &e13. &8>> &7Nowy calkowicie wyglad &6estetyczny");
        ChatColorUtil.sendMessage(player, "  &e14. &8>> &7Nowa ranga &6KOZAK /kozak");
        ChatColorUtil.sendMessage(player, "  &e15. &8>> &7Dodalismy &6YT+ /yt+");
        ChatColorUtil.sendMessage(player, "  &e16. &8>> &7Nowy system &6Farmerow /craftingi");
        ChatColorUtil.sendMessage(player, "  &e17. &8>> &7Nowe Efekt dla &6Gracza /efekty");
        ChatColorUtil.sendMessage(player, "  &e18. &8>> &7Nowe i estetyczniejsze &6/kit (wyciagane)");
        ChatColorUtil.sendMessage(player, "  &e19. &8>> &7Dodalismy system &6Anty-Nog /antynogi");
        ChatColorUtil.sendMessage(player, "  &e20. &8>> &7Dodalismy Tymczasowe &6rangi dla graczy");
        ChatColorUtil.sendMessage(player, "  &e21. &8>> &7Nowy drop z &6PremiumCase pod /casedrop");
        ChatColorUtil.sendMessage(player, "  &e22. &8>> &710x lepszy system &6AntyLogout 25s");
        ChatColorUtil.sendMessage(player, "  &e23. &8>> &7Dodalismy &6Wybierany Enchant");
        ChatColorUtil.sendMessage(player, "   ");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, " &8>> &7Masz propozycje co mamy &6Dodac?");
        ChatColorUtil.sendMessage(player, " &8>> &7Odwiedz: &6Discorda: https://discord.gg/NTcrH8c");
        ChatColorUtil.sendMessage(player, " ");
        ChatColorUtil.sendMessage(player, "&8&m----------&8[ &6&lVE&f&lHC&7&l.PL &8]&8&m----------");
        return true;
    }
}

