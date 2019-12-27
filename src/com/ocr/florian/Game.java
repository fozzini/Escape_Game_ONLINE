package com.ocr.florian;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {

    private static Scanner sc = new Scanner(System.in);

    // variables de configuration du jeu.
    private static int maxTries = 5;
    private static boolean developerMode = false;
    private static int combinationLength = 4;


    // variable de class.
    private static byte[] combinationP1 = new byte[combinationLength];
    private static byte[] combinationP2 = new byte[combinationLength];
    private static int proposition;


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

    //methode abstraite start.

    static void start() {
    }

    // tableau pour la combinaison.
    public static byte[] combination(byte[] combination, int min, int max) {

        for (int i = 0; i < getCombinationLength(); i++) {
            combination[i] = randomNumber(min, max);
        }
        if (isDeveloperMode()) {
            System.out.println(Arrays.toString(combination));
        }
        return combination;
    }

    // Création d'une proposition.
    public int proposition(boolean isHuman){

        if (isHuman){
            Utils.askForIntValue("Veuillez entrer votre proposition à "+ getCombinationLength() + " chiffres.", int minValue, int maxValue)
            proposition = sc.nextInt();
        }
        else if (isHuman = false){
            proposition = randomNumber(getCombinationLength(), 9);
        }
        return proposition;
    }

    // Comparaison de la proposition avec la combinaison.
    public void compare(byte[] combination) {
        for (int i = 0; i < combination.length; i++) {

            if (combination[i] > proposition) {
               String compareResult = "+";

            } else if (combination[i] < proposition) {
                String compareResult = "-";

            } else if (combination[i] == proposition) {
                String compareResult = "=";
            }
        }
    }

    // Chiffre aléatoire.
    public static byte randomNumber(int min, int max) {

        Random rand = new Random();
        byte randomNumber = (byte) (rand.nextInt(max - min + 1) + min);

        return randomNumber;
    }
}
