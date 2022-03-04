package pl.kodicrew.developers.vehctools.configuration.managers;

import pl.kodicrew.developers.vehctools.configuration.impl.ConfigurationImpl;

import java.io.File;

public class ConfigurationManager {

    public static ConfigurationImpl create(File file, Class clazz) {
        return new ConfigurationImpl(file, clazz);
    }
}
