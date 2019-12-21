package com.ocr.florian;

import java.util.Arrays;

public class ChallengerMode extends Game {
    public ChallengerMode(int[] combination, int[] proposition) {
        super(combination, proposition);
    }

    //mode challenger

    public static void challenger() {

        Game player1 = new ChallengerMode(combinationP1, propositionP1);
        Game player2 = new ChallengerMode(combinationP2, propositionP2);

        player1.combination(1, 9);

        for (int i = 0; i < Game.maxTries; i++) {

            player2.proposition(true, combinationP1);

            player2.compare(player1.getCombination());

            if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
                return;
            }
        }
        System.out.println("player2 à perdu");
    }

    @Override
    public int[] combination(int min, int max) {

        for (int i = 0; i < getCombination().length; i++) {
            getCombination()[i] = randomNumber(min, max);
        }
        if (displaySolution) {
            System.out.println(Arrays.toString(getCombination()));
        }
        return getCombination();
    }


    @Override
    public int[] proposition(boolean isHuman, int[] combination) {

        int cmpt = 0;
        cmpt++;

        for (int i = 0; i < getProposition().length; i++) {

            getProposition()[i] = askForIntValue("Veuillez saisir le chiffre n°" + (i + 1), min, max);

        }
        System.out.println(Arrays.toString(getProposition()));

        return getProposition();
    }
}
