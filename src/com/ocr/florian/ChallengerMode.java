package com.ocr.florian;

import java.util.Arrays;

public class ChallengerMode extends AbstractGame {

    // mode challenger.
    public static void start() {

        System.out.println("Mode sélectionné : Challenger");;


        for (int i = 0; i < AbstractGame.getMaxTries(); i++) {
            System.out.println("Veuillez entrer votre proposition à " + getCombinationLength() + " chiffres.");
            System.out.print("Proposition : " + Arrays.toString(AbstractGame.proposition(true)));
            System.out.print(" -> Réponse : "+ AbstractGame.compare(Escape_Game_App.getSecretComputer()));

            if (Arrays.equals(Escape_Game_App.getSecretComputer(), AbstractGame.proposition(true))) {
                return;
            }
        }
        System.out.println("player2 à perdu");
    }
}
