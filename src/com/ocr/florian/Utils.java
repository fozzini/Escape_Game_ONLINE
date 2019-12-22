package com.ocr.florian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    private static Scanner sc = new Scanner(System.in);

    protected static byte min;
    protected static byte max;

    //gestion des exceptions min et max.

    public static byte askForIntValue(String question, int minValue, int maxValue) {

        System.out.println(question);

        byte value = 0;
        boolean valueIsGood;
        do {
            try {
                value = sc.nextByte();
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

    public static void minMaxValue(int i, int cmpt, byte[] combination, byte[] proposition) {


        if (cmpt == 0) {
            min = 1;
            max = 9;
        } else if (proposition[i] < combination[i]) {
            min = (byte) (proposition[i] + 1);
            max = 9;
        } else if (proposition[i] > combination[i]) {
            min = 1;
            max = (byte) (proposition[i] - 1);
        } else if (proposition[i] == combination[i]) {
            min = proposition[i];
            max = proposition[i];
        }

    }

}
