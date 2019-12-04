package com.ocr.florian;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static Scanner sc = new Scanner(System.in);

    private int[] combination;
    private int[] proposition;

    static boolean displaySolution = false;

    public Game(int[] combination, int[] proposition) {
        this.combination = combination;
        this.proposition = proposition;
    }

    public static void setDisplaySolution(boolean displaySolution) {
        Game.displaySolution = displaySolution;

    }


    //Création tableau de combinaison aléatoire.

    public int[] combination(int min, int max) {

        for (int i = 0; i < combination.length; i++) {
            combination[i] = this.randomNumber(min,max);
        }
        if (displaySolution){
            System.out.println(Arrays.toString(combination));
        }
        return combination;
    }

//Création tableau de proposition aléatoire.

    public int[] proposition(boolean isHuman, int min, int max) {

        for (int i = 0; i < proposition.length; i++) {
            if (isHuman){
                proposition[i] = askForIntValue("Veuillez saisir le chiffre n° "+ i,1,9);

            } else{
                proposition[i] = this.randomNumber(min,max);
            }
        }
        System.out.println(Arrays.toString(proposition));

        return proposition;
    }

//Création de nombre aléatoire.

    public int randomNumber(int min,int max){
        Random rand = new Random();
        int randomNumber = rand.nextInt(max - min + 1) + min;

        return randomNumber;
    }

//Comparaison des tableaux

    public String[] compare(Game player2) {

        String[] compareResult = new String[combination.length];

            for (int i = 0; i < this.combination.length; i++) {
                if (this.combination[i] > player2.proposition[i])
                    compareResult[i] = "+";
                else if (this.combination[i] < player2.proposition[i])
                    compareResult[i] = "-";
                else if (this.combination[i] == player2.proposition[i])
                    compareResult[i] = "=";
            }
            System.out.println(Arrays.toString(compareResult) );
            return compareResult;
    }


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
            if (value < minValue ||(value > maxValue)) {
                System.err.println("Saisir un chiffre entre " + minValue + " et " + maxValue);
                valueIsGood = false;
            }

        } while (!valueIsGood);
        return value;
    }
}
