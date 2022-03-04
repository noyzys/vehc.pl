package pl.kodicrew.developers.vehctools.utils;

import java.util.regex.Pattern;

public class IntegerUtil {

    public static boolean isInteger(String string) {
        return Pattern.matches("-?[0-9]+", string.subSequence(0, string.length()));
    }
}
