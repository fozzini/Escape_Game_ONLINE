package com.ocr.florian;

import java.util.Arrays;

public class ChallengerMode extends Game {
    public ChallengerMode(int[] combination, int[] proposition) {
        super(combination, proposition);
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
            this.minMaxValue(i, cmpt, combination);
            getProposition()[i] = askForIntValue("Veuillez saisir le chiffre n°" + (i + 1), min, max);

        }
        System.out.println(Arrays.toString(getProposition()));

        return getProposition();
    }
}
