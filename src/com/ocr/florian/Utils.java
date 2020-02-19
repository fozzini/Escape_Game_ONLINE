package com.ocr.florian;
import org.apache.log4j.Logger;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    private static Logger logger = Logger.getLogger(Utils.class);
    private static Scanner sc = new Scanner(System.in);

    // Chiffre aléatoire.
    public static byte randomNumber(int min, int max) {
        Random rand = new Random();
        return (byte) (rand.nextInt(max - min + 1) + min);
    }

    // gestion des exceptions min et max.
    public static byte askForIntValue(String question, int minValue, int maxValue) {
        System.out.println(question);
        byte value = 0;
        boolean valueIsGood;
        do {
            try {
                value = sc.nextByte();
                valueIsGood = true;
            }
            catch (InputMismatchException e) {
                System.err.println("Saisir une valeur valide");
                logger.warn("Mauvaise saisie, aucun chiffre inséré");
                sc.next();
                valueIsGood = false;
            }
            if (value < minValue || (value > maxValue)) {
                System.err.println("Saisir un chiffre entre " + minValue + " et " + maxValue);
                logger.warn("Mauvaise saisie, la valeur ne respecte pas les choix proposés");
                valueIsGood = false;
            }
        } while (!valueIsGood);
        return value;
    }

    public static String byteArrayToString(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ConfigProperties.getCombinationLength(); i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}

