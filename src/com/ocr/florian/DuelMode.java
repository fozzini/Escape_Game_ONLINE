package com.ocr.florian;

import java.util.Arrays;

public class DuelMode extends Game {

    private boolean isHuman;

    public DuelMode(byte[] combination, byte[] proposition) {
        super(combination, proposition);
    }

    //mode duel.

    public static void duel() throws InterruptedException {

        Game player1 = new DuelMode(getCombinationP1(), getPropositionP1());
        Game player2 = new DuelMode(getCombinationP2(), getPropositionP2());

        player1.combination(1, 9);
        player2.combination(1, 9);

        for (int i = 0; i < Game.getMaxTries(); i++) {

            System.out.println("Proposition du joueur 1");

            player1.proposition(true, getCombinationP2(), getPropositionP1());
            player1.compare(player2.getCombination());

            if (Arrays.equals(player2.getCombination(), player1.getProposition())) {
                System.out.println("player1 à gagné !");
                return;
            }

            Thread.sleep(1000);

            System.out.println("Proposition du joueur 2");

            Thread.sleep(1000);

            player2.proposition(false, getCombinationP1(), getPropositionP2());
            player2.compare(player1.getCombination());

            Thread.sleep(1000);

            if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
                System.out.println("player2 à gagné !");
                return;
            }

        }

    }

    @Override
    public byte[] combination(int min, int max) {

        for (int i = 0; i < getCombination().length; i++) {
            getCombination()[i] = randomNumber(min, max);
        }
        if (isDisplaySolution()) {
            System.out.println(Arrays.toString(getCombination()));
        }
        return this.getCombination();
    }


    @Override
    public byte[] proposition(boolean isHuman, byte[] combination, byte[] proposition) {

        int cmpt = 0;
        cmpt++;

        System.out.println("Veuillez saisir votre proposition à " + getCombinationLength() + " chiffres");

        for (int i = 0; i < getProposition().length; i++) {
            if (isHuman) {

                getProposition()[i] = Utils.askForIntValue("", 1, 9);

            } else {

                Utils.minMaxValue(i, cmpt, combination, proposition);
                getProposition()[i] = randomNumber(Utils.min, Utils.max);
            }
        }
        System.out.println(Arrays.toString(getProposition()));

        return this.getProposition();
    }
}
