package com.ocr.florian;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public abstract class AbstractGame{

    private static Scanner sc = new Scanner(System.in);

    private byte[] secretComputer = new byte[getCombinationLength()];
    private byte[] secretHuman = new byte[getCombinationLength()];
    private byte[] min = new byte[getCombinationLength()];
    private byte[] max = new byte[getCombinationLength()];
    private boolean isWon = false;

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

    // Création d'une proposition.
    protected static byte[] userEntry() {
        byte[] proposition = new byte[getCombinationLength()];
        String input = sc.next();
        boolean valueIsGood;

        do{
            try {
                Integer.parseInt(input);
                valueIsGood = true;
            }
            catch (NumberFormatException e) {
                System.err.println("Saisir une valeur valide");
                input = sc.next();
                valueIsGood = false;
            }
            if (input.length() != AbstractGame.getCombinationLength()) {
                System.err.println("Saisir un nombre de " + AbstractGame.getCombinationLength() + " chiffres. ");
                input = sc.next();
                valueIsGood = false;
            }
        }while(!valueIsGood);

        for (byte i = 0; i < getCombinationLength(); i++) {
            char a = input.charAt(i);
            byte b = (byte) (a - '0');
            proposition[i] = b;
        }
        return proposition;
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

    protected boolean getIsWon() {
        return isWon;
    }

    // Comparaison de la proposition avec la combinaison.
    protected String combinationComparison(byte[] combination, byte[] proposition, boolean isComputer) {
        String resultsComparison = "";
        int count = 0;

        for (int i = 0; i < getCombinationLength(); i++) {
            if (combination[i] > proposition[i]) {
               resultsComparison = resultsComparison + "+";
               if (isComputer){
                   min[i] = (byte) (proposition[i] + 1);
                   max[i] = 9;}
            } else if (combination[i] < proposition[i]) {
                resultsComparison = resultsComparison + "-";
                if (isComputer){
                    min[i] = 1;
                    max[i] = (byte) (proposition[i] - 1);}
            } else {
                resultsComparison = resultsComparison + "=";
                count++;
                if (isComputer){
                    min[i] = proposition[i];
                    max[i] = proposition[i];
                }
            }
        }
        if (getCombinationLength() == count ){
            isWon = true;
        }
        return resultsComparison;
    }

    protected void displayIntroMessage(String mode) throws InterruptedException {
        for (int i = 0; i < getCombinationLength(); i++) {
            min[i] = 0;
            max[i] = 9;
        }
        System.out.println("Mode sélectionné : "+ mode +"\n");
        Thread.sleep(1000);
        System.out.println("Définissez une combinaison de " + getCombinationLength() + " chiffres\n");
    }

    protected void checkProposition(byte[] secret, byte[] proposition, boolean isComputer){
        System.out.print("Proposition : " + Utils.byteArrayToString(proposition));
        System.out.println(" -> Réponse : "+ combinationComparison(secret, proposition, isComputer));
    }

    protected void endGame(String character){
        String loseOrWin = "";
        if (getIsWon()){
            loseOrWin = " gagné";
        }
        else if (!getIsWon()){
            loseOrWin = " perdu!";
        }
        System.out.println("\n\n" + character + loseOrWin + "\n\n");
    }
    protected void isDeveloper(byte[] secret){
        if (isDeveloperMode()) {
            System.out.println("(Combinaison secrète : " + Utils.byteArrayToString(secret) + ")");
        }
    }

}
