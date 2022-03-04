package pl.kodicrew.developers.vehctools.impl.managers;

import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.impl.objects.User;

public interface UserManager {

    User getUser(String name);

    User getUser(Player player);
}
