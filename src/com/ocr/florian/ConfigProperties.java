package com.ocr.florian;

import java.io.*;
import java.util.Properties;

public class ConfigProperties{

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

        try{
            configFile = new File("config.properties");
            fis = new FileInputStream(configFile);
            Properties propConfig = new Properties();
            propConfig.load(fis);

            String combiLength = propConfig.getProperty("combiLength");
            String mxTries = propConfig.getProperty("mxTries");
            String devMode = propConfig.getProperty("devMode");

            combinationLength = Integer.parseInt(combiLength);
            maxTries = Integer.parseInt(mxTries);
            developerMode = Boolean.parseBoolean(devMode);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
