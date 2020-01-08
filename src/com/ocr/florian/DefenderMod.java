package com.ocr.florian;

import java.util.Arrays;

public class DefenderMod extends AbstractGame {

    // Mod defender.
    @Override
    public void start() throws InterruptedException {
        System.out.println("Mode sélectionné : Défenseur\n");
        Thread.sleep(1000);
        System.out.println("Définissez une combinaison de " + getCombinationLength() + " chiffres aléatoirement\n");
        Thread.sleep(1000);
        setSecretHuman(combinationArrayFiller(1,9));

        for (int i = 0; i < getMaxTries(); i++) {
            Thread.sleep(2000);
            System.out.print("Proposition : " + Utils.byteArrayToStringBuilder(propositionArrayFiller(false)));
            System.out.println(" -> Réponse : "+ Utils.stringArrayToStringBuilder(compareArrays(getSecretHuman())));


            if (Arrays.equals(getSecretHuman(), getProposition())) {
                System.out.println("L'ordinateur gagne!");
                Escape_Game_App.menu();
            }
        }
        System.out.println("\n\nL'ordinateur à perdu\n\n");

        Escape_Game_App.menu();
    }
}



