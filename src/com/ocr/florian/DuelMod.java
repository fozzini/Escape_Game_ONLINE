package com.ocr.florian;

import java.util.Arrays;
import java.util.Scanner;

public class DuelMod extends AbstractGame {

    private static Scanner sc = new Scanner(System.in);

    // Mod duel.
    @Override
    public void start() throws InterruptedException {
        System.out.println("Mode sélectionné : Duel");
        System.out.println("L'ordinateur définit une combinaison de " + getCombinationLength() + " chiffres aléatoirement");
        System.out.println("Définissez une combinaison de " + getCombinationLength() + " chiffres aléatoirement");
        setSecretComputer(combinationArrayFiller(1, 9));
        setSecretHuman(combinationArrayFiller(1, 9));

        for (int i = 0; i < getMaxTries(); i++){
            computerTurn();
            if (i == getMaxTries()){
                System.out.println("L'ordinateur à perdu");
            }
            humanTurn();
            if (i == getMaxTries()){
                System.out.println("Vous avez perdu");
            }
        }
        Escape_Game_App.menu();
    }

    public void computerTurn() throws InterruptedException {
        System.out.println("Proposition de l'ordinateur");
        Thread.sleep(2000);
        propositionArrayFiller(false);
        compareArrays(getSecretHuman());

        if (Arrays.equals(getSecretHuman(), getProposition())) {
            System.out.println("L'ordinateur gagne!");
        }
    }

    public void humanTurn() {
        System.out.println("Veuillez entrer votre proposition à " + getCombinationLength() + " chiffres.");
        System.out.print("Proposition : ");
        sc.nextInt();
        System.out.print(" -> Réponse : "+ compareArrays(getSecretComputer()));

        if (Arrays.equals(getSecretComputer(), propositionArrayFiller(true))) {
            System.out.println("Vous avez gagné !");
            Escape_Game_App.menu();
        }
    }
}



