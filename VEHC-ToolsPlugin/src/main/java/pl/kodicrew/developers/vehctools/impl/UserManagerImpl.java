package pl.kodicrew.developers.vehctools.impl;

import org.bukkit.entity.Player;
import pl.kodicrew.developers.vehctools.impl.managers.UserManager;
import pl.kodicrew.developers.vehctools.impl.objects.User;

import java.util.concurrent.ConcurrentHashMap;

public class UserManagerImpl implements UserManager {

    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    @Override
    public User getUser(String name) {
        return this.users.values()
                .stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User getUser(Player player) {
        return this.users.values()
                .stream()
                .filter(user -> user.getName().equalsIgnoreCase(player.getName()))
                .findFirst()
                .orElse(null);
    }
}
