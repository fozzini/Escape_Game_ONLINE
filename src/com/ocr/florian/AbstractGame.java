package com.ocr.florian;

import java.util.Arrays;
import java.util.Scanner;

public abstract class AbstractGame{

    private static Scanner sc = new Scanner(System.in);

    private byte[] secretComputer = new byte[getCombinationLength()];
    private byte[] secretHuman = new byte[getCombinationLength()];
    private byte[] proposition = new byte[getCombinationLength()];

    // getters properties.

    public static int getCombinationLength() {
        return 4;
    }

    public int getMaxTries() {
        return 5;
    }

    public boolean isDeveloperMode() {
        boolean developerMode = true;
        return true;
    }

    // Getters and Setters.


    public byte[] getSecretComputer() {
        return secretComputer;
    }

    public void setSecretComputer(byte[] secretComputer) {
        this.secretComputer = secretComputer;
    }

    public byte[] getSecretHuman() {
        return secretHuman;
    }

    public void setSecretHuman(byte[] secretHuman) {
        this.secretHuman = secretHuman;
    }

    public byte[] getProposition() {
        return proposition;
    }


    // Méthode abstraite start.
    public void start() throws InterruptedException {
    }

    // Tableau pour la combinaison.
    byte [] combinationArrayFiller(int min, int max) {

       byte [] combination = new byte[getCombinationLength()];

        for (int i = 0; i < getCombinationLength(); i++) {
            combination[i] = Utils.randomNumber(min, max);
        }
        if (isDeveloperMode()) {
            System.out.println("(Combinaison secrète : " + Utils.byteArrayToStringBuilder(combination) + ")");
        }
        return combination;
    }

    // Création d'une proposition.
    byte[] propositionArrayFiller(boolean isHuman){
        if (isHuman) {
            String input = sc.nextLine();
            char[] ch = new char[getCombinationLength()];
            for (int i = 0; i < getCombinationLength(); i++) {
                ch[i] = input.charAt(i);
                proposition = ch
            }
            System.out.println(Arrays.toString(ch));
        }
        else
            for (int i = 0; i < getCombinationLength(); i++) {
                Utils.minMaxValue(i, getSecretHuman(), getProposition());
                proposition[i] = Utils.randomNumber(Utils.getMin(), Utils.getMax());
            }
        return proposition;
    }

    // Comparaison de la proposition avec la combinaison.
    protected String[] compareArrays(byte[] combination) {
        String [] compareResult = new String[getCombinationLength()];
        for (int i = 0; i < getCombinationLength(); i++) {

            if (combination[i] > proposition[i]) {
               compareResult[i] = "+";

            } else if (combination[i] < proposition[i]) {
                compareResult[i] = "-";

            } else {
                compareResult[i] = "=";
            }
        }
        return compareResult;
    }

}
