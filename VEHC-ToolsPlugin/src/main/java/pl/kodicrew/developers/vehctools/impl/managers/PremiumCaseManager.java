package pl.kodicrew.developers.vehctools.impl.managers;

public interface PremiumCaseManager {

    int getRandInt(int min, int max);

    Double getRandDouble(double min, double max);

    Float getRandFloat(float min, float max);

    boolean getChance(double chance);
}
