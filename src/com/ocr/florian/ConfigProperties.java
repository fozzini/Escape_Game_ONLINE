package com.ocr.florian;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static Logger logger = Logger.getLogger(ConfigProperties.class);

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
        FileInputStream fis;
        File configFile;
        configFile = new File("config.properties");
        try {
        fis = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
        logger.error("Fichier de configuration manquant, chargement par défaut");
        return;
        }
        Properties propConfig = new Properties();
        try {
            propConfig.load(fis);
            String combiLength = propConfig.getProperty("combinationLength");
            String mxTries = propConfig.getProperty("maxTries");
            String devMode = propConfig.getProperty("developerMode");
            devMode = devMode.toLowerCase();

            logger.error("Fichier de configuration manquant, chargement par défaut");
            if (Integer.parseInt(combiLength) > 0) {
                combinationLength = Integer.parseInt(combiLength);
                if (combinationLength <= 2) {
                    logger.warn("Combinaison inférieur ou égal à 2 chiffres.");
                }
            }
            if (Integer.parseInt(mxTries) > 0) {
                maxTries = Integer.parseInt(mxTries);
                if (maxTries <= 2) {
                    logger.warn("Nombre d'essais inférieur ou égal à 2.");
                }
            }
            if (devMode.contains("true") || devMode.contains("false")) {
                developerMode = Boolean.parseBoolean(devMode);
            }

        } catch (NumberFormatException e) {
            logger.error("Erreur du fichier de configuration, chargement par défaut");

        }
    }
}
