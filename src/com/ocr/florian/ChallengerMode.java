package com.ocr.florian;

import java.util.Arrays;

public class ChallengerMode extends Game {
    public ChallengerMode(byte[] combination, byte[] proposition) {
        super(combination, proposition);
    }

    //mode challenger

    public static void challenger() {

        Game player1 = new ChallengerMode(getCombinationP1(), getPropositionP1());
        Game player2 = new ChallengerMode(getCombinationP2(), getPropositionP2());

        player1.combination(1, 9);

        for (int i = 0; i < Game.getMaxTries(); i++) {

            player2.proposition(true, getCombinationP1(), getPropositionP2());

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
    public byte[] proposition(boolean isHuman, byte[] combination, byte[] proposition) {

        int cmpt = 0;
        cmpt++;

        System.out.println("Veuillez saisir votre proposition à " + getCombinationLength() + " chiffres");

        for (int i = 0; i < getProposition().length; i++) {

            getProposition()[i] = Utils.askForIntValue("", 1, 9);

        }
        System.out.println(Arrays.toString(getProposition()));

        return getProposition();
    }
}
