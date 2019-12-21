package com.ocr.florian;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public abstract class Game {

    private static Scanner sc = new Scanner(System.in);

    //constructeur.

    public Game(int[] combination, int[] proposition) {
        this.combination = combination;
        this.proposition = proposition;
    }

    //variables de configuration du jeu

    protected static int maxTries = 5;
    protected static boolean displaySolution = false;
    protected static int combinationLength = 4;

    //getter nombre de chiffres dans combinaison

    public static int getCombinationLength() {
        return combinationLength;
    }

    //variable d'instance

    private int[] combination ;
    private int[] proposition ;

    //variable de class

    protected static int min;
    protected static int max;

    static int[] combinationP1 = new int[combinationLength];
    static int[] propositionP1 = new int[combinationLength];
    static int[] combinationP2 = new int[combinationLength];
    static int[] propositionP2 = new int[combinationLength];

    //getters

    public int[] getProposition() {
        return proposition;
    }

    public int[] getCombination() {
        return combination;
    }


    //Chiffre aléatoire

    public static int randomNumber(int min, int max) {

        Random rand = new Random();
        int randomNumber = rand.nextInt(max - min + 1) + min;

        return randomNumber;
    }

    //tableau pour la combinaison

    abstract public int[] combination(int min, int max);

    //Création d'un tableau de propositions.

    abstract public int[] proposition(boolean isHuman, int[] combination);

    //Comparaison des tableaux.

    public String[] compare(int[] combination) {

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

    //gestion des exceptions min et max.

    static int askForIntValue(String question, int minValue, int maxValue) {

        System.out.println(question);

        int value = 0;
        boolean valueIsGood;
        do {
            try {
                value = sc.nextInt();
                valueIsGood = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.err.println("Saisir une valeur valide");
                valueIsGood = false;
            }
            if (value < minValue || (value > maxValue)) {
                System.err.println("Saisir un chiffre entre " + minValue + " et " + maxValue);
                valueIsGood = false;
            }

        } while (!valueIsGood);
        return value;
    }

    //tableau pour borner les propositions valide suivant la comparaison.

    public void minMaxValue(int i, int cmpt, int[] combination) {


        if (cmpt == 0) {
            min = 1;
            max = 9;
        } else if (this.proposition[i] < combination[i]) {
            min = proposition[i] + 1;
            max = 9;
        } else if (this.proposition[i] > combination[i]) {
            min = 1;
            max = proposition[i] - 1;
        } else if (this.proposition[i] == combination[i]) {
            min = proposition[i];
            max = proposition[i];
        }

    }

}
