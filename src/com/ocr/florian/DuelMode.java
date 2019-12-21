package com.ocr.florian;

import java.util.Arrays;


public class DuelMode extends Game {
    private boolean isHuman;

    public DuelMode(int[] combination, int[] proposition) {
        super(combination, proposition);
    }

    //mode duel.

    public static void duel() throws InterruptedException {

        Game player1 = new DuelMode(combinationP1, propositionP1);
        Game player2 = new DuelMode(combinationP2, propositionP2);

        player1.combination(1, 9);
        player2.combination(1, 9);

        for (int i = 0; i < Game.maxTries; i++) {

            System.out.println("Proposition du joueur 1");

            player1.proposition(true, combinationP2);
            player1.compare(player2.getCombination());

            if (Arrays.equals(player2.getCombination(), player1.getProposition())) {
                System.out.println("player1 à gagné !");
                return;
            }

            Thread.sleep(1000);

            System.out.println("Proposition du joueur 2");

            Thread.sleep(1000);

            player2.proposition(false, combinationP1);
            player2.compare(player1.getCombination());

            Thread.sleep(1000);

            if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
                System.out.println("player2 à gagné !");
                return;
            }

        }

    }

    @Override
    public int[] combination(int min, int max) {

        for (int i = 0; i < getCombination().length; i++) {
            getCombination()[i] = randomNumber(min, max);
        }
        if (displaySolution) {
            System.out.println(Arrays.toString(getCombination()));
        }
        return this.getCombination();
    }


    @Override
    public int[] proposition(boolean isHuman, int[] combination) {

        int cmpt = 0;
        cmpt++;

        for (int i = 0; i < getProposition().length; i++) {
            if (isHuman) {
                this.minMaxValue(i, cmpt, combination);
                getProposition()[i] = askForIntValue("Veuillez saisir le chiffre n°" + (i + 1), min, max);

            } else {
                this.minMaxValue(i, cmpt, combination);
                getProposition()[i] = randomNumber(min, max);
            }
        }
        System.out.println(Arrays.toString(getProposition()));

        return this.getProposition();
    }
}
