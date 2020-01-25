package com.ocr.florian;

import java.io.UnsupportedEncodingException;

public abstract class AbstractGame{

    private byte[] secretComputer = new byte[getCombinationLength()];
    private byte[] secretHuman = new byte[getCombinationLength()];
    private byte[] min = new byte[getCombinationLength()];
    private byte[] max = new byte[getCombinationLength()];

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
    protected static byte[] inputHuman(String input) {
        byte[] proposition = new byte[getCombinationLength()];
        char firstDigit = '0';

        for (byte i = 0; i < getCombinationLength(); i++) {
            char a = input.charAt(i);
            byte b = (byte) (a - firstDigit);
            proposition[i] = b;
        }
        return proposition;
    }

    // Comparaison de la proposition avec la combinaison.
    protected StringBuffer compareCombination(byte[] combination, byte[] proposition, boolean isComputer, String character ) {
        StringBuffer compareResult = new StringBuffer();
        boolean isWin= false;
        int cmpt = 0;

        for (int i = 0; i < getCombinationLength(); i++) {
            if (combination[i] > proposition[i]) {
               compareResult.append("+");
               if (isComputer){
                   min[i] = (byte) (proposition[i] + 1);
                   max[i] = 9;}
            } else if (combination[i] < proposition[i]) {
                compareResult.append("-");
                if (isComputer){
                    min[i] = 1;
                    max[i] = (byte) (proposition[i] - 1);}
            } else {
                compareResult.append("=");
                cmpt++;
                if (isComputer){
                    min[i] = proposition[i];
                    max[i] = proposition[i];
                }
            }
        }
        if (getCombinationLength() == cmpt ){
            isWin = true;
        }
        return compareResult;
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

    protected void checkProposition(byte[] secret, byte[] proposition, boolean isComputer, String character){
        System.out.print("Proposition : " + Utils.byteArrayToString(proposition));
        System.out.println(" -> Réponse : "+ compareCombination(secret, proposition, isComputer, character));
    }

    protected void endGame(String character, String loseOrWin){
        System.out.println("\n\n" + character + loseOrWin + "\n\n");
    }
    protected void isDeveloper(byte[] secret){
        if (isDeveloperMode()) {
            System.out.println("(Combinaison secrète : " + Utils.byteArrayToString(secret) + ")");
        }
    }

}
