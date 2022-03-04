package pl.kodicrew.developers.vehctools.impl;

import org.apache.commons.lang3.Validate;
import pl.kodicrew.developers.vehctools.impl.managers.PremiumCaseManager;
import java.util.Random;

public class PremiumCaseManagerImpl implements PremiumCaseManager {

    private final Random random = new Random();

    @Override
    public int getRandInt(int min, int max) {
        Validate.isTrue(max > min, "MAX");
        return this.random.nextInt(max - min + 1) + min;
    }

    @Override
    public Double getRandDouble(double min, double max) {
        Validate.isTrue(max > min, "MAX");
        return this.random.nextDouble() * (max - min) + min;
    }

    @Override
    public Float getRandFloat(float min, float max) {
        Validate.isTrue(max > min, "MAX");
        return this.random.nextFloat() * (max - min) + min;
    }

    @Override
    public boolean getChance(double chance) {
        return chance >= 100.0 || chance >= getRandDouble(0.0, 100.0);
    }
}
