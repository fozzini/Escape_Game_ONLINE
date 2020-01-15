package com.ocr.florian;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Utils {

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
            } catch (InputMismatchException e) {
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

    public static String byteArrayToStringBuilder(byte[] monTableau) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < AbstractGame.getCombinationLength(); i++) {
            sb.append(monTableau[i]);
        }
        return sb.toString();
    }

    public static String stringArrayToStringBuilder(String[] monTableau) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < AbstractGame.getCombinationLength(); i++) {
            sb.append(monTableau[i]);
        }
        return sb.toString();
    }

    public static String catchException(String input){
        try {
            parseInt(input);
        }
        catch (NumberFormatException e) {
            System.err.println("Saisir une valeur valide");
            AbstractGame.inputHumanArray();
        }
        if (input.length() < AbstractGame.getCombinationLength() || input.length() > AbstractGame.getCombinationLength()) {
            System.err.println("Saisir un nombre de " + AbstractGame.getCombinationLength() + " chiffres. ");
            AbstractGame.inputHumanArray();
        }
        return input;
    }
}

