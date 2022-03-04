package pl.kodicrew.developers.vehctools.utils;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionUtil {

    public static void applyPotion(Player player, PotionEffectType type, int amplifier, int length) {
        player.getActivePotionEffects()

                .stream()
                .filter(effect -> effect.getType().equals(type) && effect.getAmplifier() <= amplifier)
                .map(effect -> type).forEach(player::removePotionEffect);

        player.addPotionEffect(new PotionEffect(type, 15 * length, amplifier, false, false));

    }

    public static void applyPotion(LivingEntity entity, PotionEffectType type, int amplifier, int length) {

        entity.getActivePotionEffects()

                .stream()
                .filter(effect -> effect.getType().equals(type) && effect.getAmplifier() <= amplifier)
                .map(effect -> type)
                .forEach(entity::removePotionEffect);

        entity.addPotionEffect(new PotionEffect(type, 15 * length, amplifier, false, false));

    }

    public static void removePotion(Player player, PotionEffectType type) {
        player.getActivePotionEffects()

                .stream()
                .filter(effect -> effect.getType().equals(type))
                .map(effect -> type)
                .forEach(player::removePotionEffect);

    }

    public static void removePotion(LivingEntity entity, PotionEffectType type) {
        entity.getActivePotionEffects()

                .stream()
                .filter(effect -> effect.getType().equals(type))
                .map(effect -> type)
                .forEach(entity::removePotionEffect);

    }

    public static void removePotions(Player player) {
        player.getActivePotionEffects()

                .stream()
                .map(PotionEffect::getType)
                .forEach(player::removePotionEffect);

    }

    public static void removePotions(LivingEntity entity) {
        entity.getActivePotionEffects()

                .stream()
                .map(PotionEffect::getType)
                .forEach(entity::removePotionEffect);
    }
}
