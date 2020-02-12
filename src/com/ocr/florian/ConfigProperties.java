package com.ocr.florian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static int combinationLength;
    private static int maxTries;
    private static boolean developerMode;

    public static int getCombinationLength() {
        return combinationLength;
    }

    public static int getMaxTries() {
        return maxTries;
    }

    public static boolean isDeveloperMode() {
        return developerMode;
    }

    public static void loadProperties() throws IOException {
        FileInputStream fis = null;
        File configFile = null;

        configFile = new File("config.properties");
        fis = new FileInputStream(configFile);
        Properties propConfig = new Properties();

        try {
            propConfig.load(fis);

            String combiLength = propConfig.getProperty("combinationLength");
            String mxTries = propConfig.getProperty("maxTries");

            combinationLength = Integer.parseInt(combiLength);
            maxTries = Integer.parseInt(mxTries);

            if (combinationLength <= 0 || maxTries <= 0) {
                defaultConfig(5, 4, true);
            }

        } catch (FileNotFoundException | NumberFormatException e) {
            defaultConfig(5, 4, true);
        }
        String devMode = propConfig.getProperty("developerMode");
        developerMode = Boolean.parseBoolean(devMode);

        boolean correctString = devMode.contains("true") || devMode.contains("false");
        if (!correctString) {
            defaultConfig(maxTries, combinationLength, true);
        }
    }

    public static void defaultConfig(int tries, int combilength, boolean devMode) {
        maxTries = tries;
        developerMode = devMode;
        combinationLength = combilength;
    }
}
