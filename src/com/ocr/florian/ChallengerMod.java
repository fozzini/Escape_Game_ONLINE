package com.ocr.florian;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengerMod extends AbstractGame {

    private static Scanner sc = new Scanner(System.in);

    // Mod challenger.
    @Override
    public void start() {
        System.out.println("Mode sélectionné : Challenger");
        System.out.println("L'ordinateur définit une combinaison de " + getCombinationLength() + " chiffres aléatoirement");
        setSecretComputer(combinationArrayFiller(1,9));

        for (int i = 0; i < getMaxTries(); i++) {
            String input = null;
            System.out.println("Veuillez entrer votre proposition à " + getCombinationLength() + " chiffres.");
            System.out.print("Proposition : " + propositionArrayFiller(true));
            System.out.println(" -> Réponse : "+ Utils.stringArrayToStringBuilder(compareArrays(getSecretComputer())));

            if (Arrays.equals(getSecretComputer(), propositionArrayFiller(true))) {
                System.out.println("Vous avez gagné !");
                Escape_Game_App.menu();
            }
        }
        System.out.println("Vous avez perdu");
        Escape_Game_App.menu();
    }
}
