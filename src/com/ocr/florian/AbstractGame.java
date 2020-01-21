package com.ocr.florian;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public abstract class AbstractGame{

    private static Scanner sc = new Scanner(System.in);

    private byte[] secretComputer = new byte[getCombinationLength()];
    private byte[] secretHuman = new byte[getCombinationLength()];
    private byte [] min = new byte[getCombinationLength()];
    private byte [] max = new byte[getCombinationLength()];

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


    // Méthode abstraite start.
    protected abstract void start() throws InterruptedException, UnsupportedEncodingException;

    // Tableau pour la combinaison.
    protected byte[] generateComputer() {
        byte[] computer = new byte[getCombinationLength()];

        for (int i = 0; i < getCombinationLength(); i++) {
            computer[i] = Utils.randomNumber(min[i], max[i]);
        }
        return computer;
    }

    // Création d'une proposition.
    protected static byte[] inputHuman(){
        byte[] proposition = new byte[getCombinationLength()];
        char firstDigit = '0';
        String input = Utils.catchException(sc.nextLine());

        for (int i = 0; i < getCombinationLength(); i++) {
            char a = input.charAt(i);
            byte b = (byte) a;
            byte c = (byte) (b -firstDigit );
            proposition[i] = c;
        }
        return proposition;
    }

    // Comparaison de la proposition avec la combinaison.
    protected  String[] compareCombination(byte[] combination, byte[] proposition, boolean isHuman) {
        String[] compareResult = new String[getCombinationLength()];

        for (int i = 0; i < getCombinationLength(); i++) {
            if (combination[i] > proposition[i]) {
               compareResult[i] = "+";
               if (!isHuman){
                   min[i] = (byte) (proposition[i] + 1);
                   max[i] = 9;}
            } else if (combination[i] < proposition[i]) {
                compareResult[i] = "-";
                if (!isHuman){
                    min[i] = 1;
                    max[i] = (byte) (proposition[i] - 1);}
            } else {
                compareResult[i] = "=";
                if (!isHuman){
                    min[i] = proposition[i];
                    max[i] = proposition[i];
                }
            }
        }
        return compareResult;
    }

    protected void displayIntroMessage(String mode) throws InterruptedException {
        for (int i = 0; i < getCombinationLength(); i++) {
            max[i] = 9;
        }
        System.out.println("Mode sélectionné : "+ mode +"\n");
        Thread.sleep(1000);
        System.out.println("Définissez une combinaison de " + getCombinationLength() + " chiffres aléatoirement\n");
        Thread.sleep(1000);
        System.out.println("Jouez!");
    }

    protected void checkProposition(byte[] secret, byte[] proposition, boolean isHuman, String character){
        if (isDeveloperMode()) {
            System.out.println("(Combinaison secrète : " + Utils.byteArrayToStringBuilder(secret) + ")");
        }
        System.out.print("Proposition : " + Utils.byteArrayToStringBuilder(proposition));
        System.out.println(" -> Réponse : "+ Utils.stringArrayToStringBuilder(compareCombination(secret, proposition, isHuman)));

        if (Arrays.equals(secret, proposition)) {
            System.out.println("\n\n"+character + " gagné!\n\n");
            Escape_Game_App.menu();
        }
    }

    protected void endGame(String character){
        System.out.println("\n\n"+ character + " perdu!\n\n");
        Escape_Game_App.menu();
    }
}
