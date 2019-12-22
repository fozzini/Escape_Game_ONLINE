package com.ocr.florian;

import java.util.Arrays;

public class DefenserMode extends Game {
    public DefenserMode(byte[] combination, byte[] proposition) {
        super(combination, proposition);
    }

    //mode defender.

    public static void defenser() {

        Game player1 = new DefenserMode(combinationP1, propositionP1);
        Game player2 = new DefenserMode(combinationP2, propositionP2);

        player1.combination(1, 9);

        for (int i = 0; i < Game.getMaxTries(); i++) {

            player2.proposition(false, combinationP1, propositionP2);

            player2.compare(player1.getCombination());

            if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
                return;
            }
        }
        System.out.println("player2 à perdu");

    }

    @Override
    public byte[] combination(int min, int max) {

        for (int i = 0; i < getCombination().length; i++) {
            getCombination()[i] = randomNumber(min, max);
        }
        if (isDisplaySolution()) {
            System.out.println(Arrays.toString(getCombination()));
        }
        return getCombination();
    }


    @Override

    public byte[] proposition(boolean isHuman, byte[] combination,byte[] proposition) {

        int cmpt = 0;
        cmpt++;

        for (int i = 0; i < getProposition().length; i++) {
            Utils.minMaxValue(i, cmpt, combination, proposition);
            getProposition()[i] = randomNumber(Utils.min, Utils.max);
        }

        System.out.println(Arrays.toString(getProposition()));

        return getProposition();
    }
}
