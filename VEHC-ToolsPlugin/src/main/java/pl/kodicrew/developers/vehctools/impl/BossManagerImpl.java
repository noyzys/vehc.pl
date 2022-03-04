package pl.kodicrew.developers.vehctools.impl;

import pl.kodicrew.developers.vehctools.impl.managers.BossManager;

public class BossManagerImpl implements BossManager {

    private boolean boss;

    @Override
    public boolean getSpawn() {
        return this.boss;
    }

    @Override
    public void setBoss(boolean boss) {
        this.boss = boss;
    }
}
