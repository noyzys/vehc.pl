package pl.kodicrew.developers.vehctools.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.ToolsPlugin;
import pl.kodicrew.developers.vehctools.apies.CommandExecutor;
import pl.kodicrew.developers.vehctools.builders.ItemStackBuilder;
import pl.kodicrew.developers.vehctools.utils.ChatColorUtil;

public class ItemShopCommand extends CommandExecutor {

    private final ToolsPlugin plugin;

    public ItemShopCommand(ToolsPlugin plugin) {
        super("itemshop", "vehc.itemshop", "/itemshop nick <usluga/list>", "is", "twojastara");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        final Player player = (Player) sender;

        final Player player2 = Bukkit.getPlayer(args[0]);

        if (player2 == null) return ChatColorUtil.sendMessage(player, "&cBlad: Podany gracz jest offline");

        switch (args[1].toLowerCase()) {
            case "svip": {

                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Gracz &f" + player2.getName() + " &7zakupil range &8[&e&lS&6&lVIP&8]");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &7Nasz ItemShop: &6vehc.pl/");
                    ChatColorUtil.sendMessage(players, "  &8>> &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&l&oDZIEKUJEMY ZA DOKONANIE ZAKUPU &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");

                });
                break;
            }

            case "sponsor": {
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Gracz &f" + player2.getName() + " &7zakupil range &8[&9&lSPONSOR&8]");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &7Nasz ItemShop: &6vehc.pl/");
                    ChatColorUtil.sendMessage(players, "  &8>> &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&l&oDZIEKUJEMY ZA DOKONANIE ZAKUPU &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                });
                break;

            }

            case "kozak": {
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Gracz &f" + player2.getName() + " &7zakupil range &8[&9&lK&b&lO&3&lZ&c&LA&a&lK&8]");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &7Nasz ItemShop: &6vehc.pl/");
                    ChatColorUtil.sendMessage(players, "  &8>> &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&l&oDZIEKUJEMY ZA DOKONANIE ZAKUPU &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                });
                break;
            }

            case "unban": {
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Gracz &f" + player2.getName() + " &7zakupil &8[&e&lUNBANA&8]");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &7Nasz ItemShop: &6vehc.pl/");
                    ChatColorUtil.sendMessage(players, "  &8>> &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&l&oDZIEKUJEMY ZA DOKONANIE ZAKUPU &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                });
                break;
            }

            case "list": {
                ChatColorUtil.sendMessage(player, "&7Dostepne uslugi: &aSVIP, SPONSOR, KOZAK, UNBAN, CASE32, CASE64");
                break;
            }

            case "case32": {
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Gracz &f" + player2.getName() + " &7zakupil usluge &9&lPremiumCase &8(&cx32&8)");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &7Nasz ItemShop: &6vehc.pl/");
                    ChatColorUtil.sendMessage(players, "  &8>> &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&l&oDZIEKUJEMY ZA DOKONANIE ZAKUPU &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                    player2.getInventory().addItem(new ItemStackBuilder(Material.CHEST, 32).withTitle(ChatColorUtil.colored("&8>> &9&lPremiumCase &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Ilosc case: &8(&cx32&8)")).withLore(ChatColorUtil.colored("&8>> &7Nasz itemshop: &6vehc.pl/")).withLore(ChatColorUtil.colored("")).build());
                });
                break;
            }

            case "case64": {
                Bukkit.getOnlinePlayers().forEach(players -> {
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, " &8>> &7Gracz &f" + player2.getName() + " &7zakupil usluge &9&lPremiumCase &8(&cx64&8)");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &7Nasz ItemShop: &6vehc.pl/");
                    ChatColorUtil.sendMessage(players, "  &8>> &7TS3: &64ope.pl");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "  &8>> &a&l&oDZIEKUJEMY ZA DOKONANIE ZAKUPU &8<<");
                    ChatColorUtil.sendMessage(players, "");
                    ChatColorUtil.sendMessage(players, "&8&m------------&8[ &6&lVE&f&LHC&7&l.PL &8]&8&m------------");
                    player2.getInventory().addItem(new ItemStackBuilder(Material.CHEST, 64).withTitle(ChatColorUtil.colored("&8>> &9&lPremiumCase &8<<")).withLore(ChatColorUtil.colored("")).withLore(ChatColorUtil.colored("&8>> &7Ilosc case: &8(&cx64&8)")).withLore(ChatColorUtil.colored("&8>> &7Nasz itemshop: &6vehc.pl/")).withLore(ChatColorUtil.colored("")).build());
                });
                break;

            }
            default:
                return ChatColorUtil.sendMessage(player, "&cBlad: Podana usluga nie istnieje!");
        }
        return true;
    }
}
