package com.ocr.florian;

import java.util.Arrays;

public class DuelMode extends Game {
    private boolean isHuman;

    public DuelMode(int[] combination, int[] proposition) {
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
