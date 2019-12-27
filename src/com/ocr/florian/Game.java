package com.ocr.florian;

import java.util.Arrays;
import java.util.Random;


public abstract class Game {

    // variables de configuration du jeu.
    private static int maxTries = 5;
    private static boolean developerMode = false;
    private static int combinationLength = 4;


    // variable de class.
    private static byte[] combinationP1 = new byte[combinationLength];
    private static byte[] combinationP2 = new byte[combinationLength];


    // getters.
    public static int getCombinationLength() {
        return combinationLength;
    }

    public static int getMaxTries() {
        return maxTries;
    }

    public static boolean isDeveloperMode() {
        return developerMode;
    }

    public static byte[] getCombinationP1() {
        return combinationP1;
    }

    public static byte[] getCombinationP2() {
        return combinationP2;
    }

    // tableau pour la combinaison.
    public byte[] combination(int min, int max) {

        for (int i = 0; i < getCombination().length; i++) {
            getCombination()[i] = randomNumber(min, max);
        }
        if (isDeveloperMode()) {
            System.out.println(Arrays.toString(getCombination()));
        }
        return this.getCombination();

    // Création d'une proposition.
    public int proposition(boolean isHuman);
        if (isHuman){
            int proposition = askForIntValue("Veuillez entrer votre proposition à "+ getCombinationLength() + " chiffres.", int minValue, int maxValue)
        }
        else if (isHuman = false){
            for (int i = 0; i < getCombination().length; i++)
                int proposition = randomNumber(1, 9)
        }
        return proposition;
    }

    // Comparaison des tableaux.
    public String compare(byte[] combination) {


        for (int i = 0; i < combination.length; i++) {

            if (combination[i] > proposition) {
                compareResult[i] = "+";

            } else if (combination[i] < proposition) {
                compareResult[i] = "-";

            } else if (combination[i] == proposition) {
                compareResult[i] = "=";

            }
        }
        System.out.println(Arrays.toString(compareResult));
        return compareResult;
    }

    // Chiffre aléatoire.
    public static byte randomNumber(int min, int max) {

        Random rand = new Random();
        byte randomNumber = (byte) (rand.nextInt(max - min + 1) + min);

        return randomNumber;
    }
}
