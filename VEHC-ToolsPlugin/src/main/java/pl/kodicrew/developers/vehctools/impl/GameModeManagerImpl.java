package pl.kodicrew.developers.vehctools.impl;

import org.bukkit.GameMode;
import pl.kodicrew.developers.vehctools.impl.managers.GameModeManager;

public class GameModeManagerImpl implements GameModeManager {

    @Override
    public GameMode getGameMode(String gm) {
        switch (gm.toLowerCase()){
            case "0":
                return GameMode.SURVIVAL;
            case "1":
                return GameMode.CREATIVE;
            case "2":
                return GameMode.ADVENTURE;
            case "3":
                return GameMode.SPECTATOR;
        }
        return null;
    }
}
