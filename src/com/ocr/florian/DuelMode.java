package com.ocr.florian;

import java.util.Arrays;

public class DuelMode extends AbstractGame {

    private boolean isHuman;

    // mode duel.
    public static void start()  {

        System.out.println("Mode sélectionné : Duel");
        System.out.println("Défiez l'ordinateur");

        //getCombinationP1(1, 9);
        //getCombinationP2(1, 9);

        //for (int i = 0; i < Game.getMaxTries(); i++) {

            System.out.println("Proposition du joueur 1");

            //player1.proposition(true, getCombinationP2(), getPropositionP1());
            //player1.compare(player2.getCombination());

            //if (Arrays.equals(player2.getCombination(), player1.getProposition())) {
                System.out.println("player1 à gagné !");
                return;
            }

            //Thread.sleep(1000);

            //System.out.println("Proposition du joueur 2");

            //Thread.sleep(1000);

            //player2.proposition(false, getCombinationP1(), getPropositionP2());
            //player2.compare(player1.getCombination());

            //Thread.sleep(1000);

            //if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
               // System.out.println("player2 à gagné !");
                //return;
            }



