package com.ocr.florian;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static int combinationLength = 4;
    private static int maxTries = 5;
    private static boolean developerMode = false;

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
            String devMode = propConfig.getProperty("developerMode");
            boolean correctString = devMode.contains("true") || devMode.contains("false");

            if (Integer.parseInt(combiLength) > 0) {
                combinationLength = Integer.parseInt(combiLength);
            }
            if (Integer.parseInt(mxTries) > 0) {
                maxTries = Integer.parseInt(mxTries);
            }
            if (correctString) {
                developerMode = Boolean.parseBoolean(devMode);
            }

        } catch (NumberFormatException e) {
            
        }
    }
}
