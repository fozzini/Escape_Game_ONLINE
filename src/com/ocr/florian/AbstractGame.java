package com.ocr.florian;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public abstract class AbstractGame{

    private static Scanner sc = new Scanner(System.in);

    private byte[] secretComputer = new byte[getCombinationLength()];
    private byte[] secretHuman = new byte[getCombinationLength()];
    private static byte[] proposition = new byte[getCombinationLength()];
    private byte min = 1;
    private byte max = 9;

    // getters properties.
    protected static int getCombinationLength() {
        return 4;
    }

    protected int getMaxTries() {
        return 5;
    }

    protected boolean isDeveloperMode() {
        return true;
    }

    // Getters and Setters.
    protected byte[] getSecretComputer() {
        return secretComputer;
    }

    protected void setSecretComputer(byte[] secretComputer) {
        this.secretComputer = secretComputer;
    }

    protected byte[] getSecretHuman() {
        return secretHuman;
    }

    protected void setSecretHuman(byte[] secretHuman) {
        this.secretHuman = secretHuman;
    }

    protected byte[] getProposition() {
        return proposition;
    }

    protected void setProposition(byte[] proposition) {
        this.proposition = proposition;
    }

    protected byte getMin() {
        return min;
    }

    protected byte getMax() {
        return max;
    }

    // Méthode abstraite start.
    abstract void start() throws InterruptedException, UnsupportedEncodingException;

    // Tableau pour la combinaison.
    protected byte[] generateComputerArray(boolean isProposition) {
        byte[] computerArray = new byte[getCombinationLength()];

        for (int i = 0; i < getCombinationLength(); i++) {
            if (isProposition){
                minMaxValue(i,secretHuman);
            }
            computerArray[i] = Utils.randomNumber(getMin(), getMax());
        }
        return computerArray;
    }

    // Création d'une proposition.
    protected static void inputHumanArray(){
        int gapAsciiValueToFirstDigit = 48;
        String input = Utils.catchException(sc.nextLine());

        for (int i = 0; i < getCombinationLength(); i++) {
            char a = input.charAt(i);
            byte b = (byte) a;
            byte c = (byte) (b - gapAsciiValueToFirstDigit);
            proposition[i] = c;
        }
    }

    // Comparaison de la proposition avec la combinaison.
    protected static String[] compareArrays(byte[] combination,byte[] proposition) {
        String[] compareResult = new String[getCombinationLength()];

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

    // tableau pour borner les propositions valide suivant la comparaison.
    protected void minMaxValue(int i, byte[] combination) {

            if (proposition[i] < combination[i]) {
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

    protected static void introductionString(String mod) throws InterruptedException {
        System.out.println("Mode sélectionné : "+ mod +"\n");
        Thread.sleep(1000);
        System.out.println("Définissez une combinaison de " + getCombinationLength() + " chiffres aléatoirement\n");
        Thread.sleep(1000);
        System.out.println("Jouez!");
    }

    protected void GameString(byte[] secret, String character){
        if (isDeveloperMode()) {
            System.out.println("(Combinaison secrète : " + Utils.byteArrayToStringBuilder(secret) + ")");
        }
        System.out.print("Proposition : " + Utils.byteArrayToStringBuilder(getProposition()));
        System.out.println(" -> Réponse : "+ Utils.stringArrayToStringBuilder(compareArrays(secret,proposition)));

        if (Arrays.equals(secret, getProposition())) {
            System.out.println("\n\n"+character + " gagné!\n\n");
            Escape_Game_App.menu();
        }
    }

    protected void EndGameString(String character){
        System.out.println("\n\n"+ character + " perdu!\n\n");
        Escape_Game_App.menu();
    }
}
