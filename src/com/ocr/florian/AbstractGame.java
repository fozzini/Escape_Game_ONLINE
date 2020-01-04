package com.ocr.florian;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class AbstractGame{

    private static Scanner sc = new Scanner(System.in);


    // variable de class.
    private static byte[] proposition;


    // getters.
    public static int getCombinationLength() {
        int combinationLength = 4;
        return combinationLength;
    }

    public static int getMaxTries() {
        int maxTries = 5;
        return maxTries;
    }

    public static boolean isDeveloperMode() {
        boolean developerMode = false;
        return developerMode;
    }

    // methode abstraite start.
    static void start() {
    }

    // tableau pour la combinaison.
    public static void combinationTableFiller(byte[] combination, int min, int max) {

        for (int i = 0; i < getCombinationLength(); i++) {
            combination[i] = randomNumber(min, max);
        }
        if (isDeveloperMode()) {
            System.out.println(Arrays.toString(combination));
        }
    }

    // Création d'une proposition.
    public static byte[] proposition(boolean isHuman){

        for (int i = 0; i < getCombinationLength(); i++) {
            if (isHuman) {
                proposition[i] = sc.nextByte();

            } else {
                proposition[i] = randomNumber(1, 9);
            }
        }
        return proposition;
    }

    // Comparaison de la proposition avec la combinaison.
    public static String compare(byte[] combination) {
        String compareResult = null;
        for (int i = 0; i < combination.length; i++) {

            if (combination[i] > proposition[i]) {
               compareResult = "+";

            } else if (combination[i] < proposition[i]) {
                compareResult = "-";

            } else {
                compareResult = "=";
            }
        }
        return compareResult;
    }

    // Chiffre aléatoire.
    public static byte randomNumber(int min, int max) {

        Random rand = new Random();
        byte randomNumber = (byte) (rand.nextInt(max - min + 1) + min);

        return randomNumber;
    }
}
