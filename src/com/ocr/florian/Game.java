package com.ocr.florian;

import java.util.Arrays;
import java.util.Random;


public abstract class Game {

    //constructeur.

    public Game(byte[] combination, byte[] proposition) {
        this.combination = combination;
        this.proposition = proposition;
    }

    //variables de configuration du jeu

    private static int maxTries = 5;
    private static boolean displaySolution = false;
    private static int combinationLength = 4;

    //variable d'instance

    private byte[] combination ;
    private byte[] proposition ;

    //variable de class

    static byte[] combinationP1 = new byte[combinationLength];
    static byte[] propositionP1 = new byte[combinationLength];
    static byte[] combinationP2 = new byte[combinationLength];
    static byte[] propositionP2 = new byte[combinationLength];

    //getters

    public byte[] getProposition() {
        return proposition;
    }

    public byte[] getCombination() {
        return combination;
    }

    public static int getCombinationLength() {
        return combinationLength;
    }

    public static int getMaxTries() {
        return maxTries;
    }

    public static boolean isDisplaySolution() {
        return displaySolution;
    }

    //tableau pour la combinaison

    abstract public byte[] combination(int min, int max);

    //Création d'un tableau de propositions.

    abstract public byte[] proposition(boolean isHuman, byte[] combination, byte[] proposition);

    //Comparaison des tableaux.

    public String[] compare(byte[] combination) {

        String[] compareResult = new String[combination.length];

        for (int i = 0; i < combination.length; i++) {

            if (this.proposition[i] < combination[i]) {
                compareResult[i] = "+";

            } else if (this.proposition[i] > combination[i]) {
                compareResult[i] = "-";

            } else if (this.proposition[i] == combination[i]) {
                compareResult[i] = "=";

            }
        }
        System.out.println(Arrays.toString(compareResult));
        return compareResult;
    }

    //Chiffre aléatoire

    public static byte randomNumber(int min, int max) {

        Random rand = new Random();
        byte randomNumber = (byte) (rand.nextInt(max - min + 1) + min);

        return randomNumber;
    }

}
