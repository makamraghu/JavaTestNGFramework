package com.TestNg.ConfigReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static final Properties properties = new Properties();
    private static final String DEFAULT_ENV = "dev";
    private static String activeEnv;

    static {
        loadEnvironmentConfig();
    }

    private static void loadEnvironmentConfig() {
        try {
            activeEnv = System.getProperty("env", DEFAULT_ENV).toLowerCase();
            String path = "src/test/resources/config/config-" + activeEnv + ".properties";
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
            System.out.println("Loaded config for environment: " + activeEnv);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load environment config.");
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) throw new RuntimeException("Missing key: " + key);
        return value;
    }
}
