package com.ocr.florian;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static Scanner sc = new Scanner(System.in);

//variables d'instance.

    private int[] combination;
    private int[] proposition;

//variables de class.

    protected static int min;
    protected static int max;

//variables de configuration du jeu

    protected static boolean displaySolution = false;
    protected static int maxTries = 5 ;

//constructeur.

    public Game(int[] combination, int[] proposition) {
        this.combination = combination;
        this.proposition = proposition;
    }

//setters.

    public static  void setDisplaySolution(boolean displaySolution) {
        Game.displaySolution = displaySolution;

    }
    public static void setMaxTries(int maxTries) {
        Game.maxTries = maxTries;
    }

//Création d'un tableau de combinaisons aléatoire avec min et max pour définir la range des chiffres. + gérer lesexceptions

    public int[] combination(int min, int max) {

        for (int i = 0; i < combination.length; i++) {
            combination[i] = this.randomNumber(min,max);
        }
        if (displaySolution){
            System.out.println(Arrays.toString(combination));
        }
        return combination;
    }

//Création d'un tableau de propositions.
//un boolean ishuman pour orienter vers une entrée manuel ou aléatoire.
//un compteur pour définir le premier tour pour le range du min et maxi.

    public int[] proposition(boolean isHuman,Game player1) {
        int cmpt = 0;
        cmpt++;
        for (int i = 0; i < proposition.length; i++) {
            if (isHuman){
                this.minMaxValue(player1,i,cmpt);
                proposition[i] = askForIntValue("Veuillez saisir le chiffre n°"+(i+1),min,max);

            } else{
                this.minMaxValue(player1,i,cmpt);
                proposition[i] = this.randomNumber(min,max);
            }
        }
        System.out.println(Arrays.toString(proposition));

        return proposition;
    }

//Création d'un nombre aléatoire.

    public int randomNumber(int min,int max){
        Random rand = new Random();
        int randomNumber = rand.nextInt(max - min + 1) + min;

        return randomNumber;
    }

//Comparaison des tableaux.

    public String[] compare(Game player2) {

        String[] compareResult = new String[combination.length];

            for (int i = 0; i < this.combination.length; i++)
            {

                if (this.combination[i] > player2.proposition[i])
                {
                    compareResult[i] = "+";
                }
                else if (this.combination[i] < player2.proposition[i])
                {
                    compareResult[i] = "-";
                }
                else if (this.combination[i] == player2.proposition[i])
                {
                    compareResult[i] = "=";
                }

            }
            System.out.println(Arrays.toString(compareResult) );
            return compareResult;
    }
//Ajustement des valeurs min et max pour la proposition d'un nouveau code.

    public void minMaxValue(Game player1,int i,int cmpt){

        if (cmpt == 0){
            min = 1;
            max = 9;

        }
        else if (proposition[i] < player1.combination[i])
        {
            min = proposition[i]+1;
            max = 9;
        }
        else if (proposition[i] > player1.combination[i])
        {
            min = 1;
            max = proposition[i]-1;
        }
        else if (proposition[i] == player1.combination[i])
        {
            min = proposition[i];
            max = proposition[i];
        }

    }

//gestion des exceptions et bornage du min et max.

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

//mode challenger

    public void challenger(Game player1,Game player2) {

        this.combination(1,9);

            for (int i = 0; i < maxTries; i++) {
                player2.proposition(true,player1);
                this.compare(player2);
                    if (Arrays.equals(combination,player2.proposition))
                    {
                        return;
                    }
            }
            System.out.println("player2 à perdu");
    }

//mode defender.

    public void defender(Game player1,Game player2){

        this.combination(1,9);

            for (int i = 0; i < maxTries; i++) {
             player2.proposition(false,player1);
             this.compare(player2);
                if (Arrays.equals(combination,player2.proposition))
                {
                    return;
                }
            }
            System.out.println("player2 à perdu");

    }

//mode duel.

    public void duel(Game player1,Game player2){

    }
}
