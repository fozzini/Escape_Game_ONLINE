package com.ocr.florian;

import java.util.Arrays;

public class ChallengerMode extends Game {

    // mode challenger.
    public static void start() {

        System.out.println("Mode sélectionné : Challenger");
        System.out.println("Trouvez la combinaison à " + Game.getCombinationLength() + " chiffres");

        Game.combination(getCombinationP1(),1, 9);

        for (int i = 0; i < Game.getMaxTries(); i++) {

            proposition(true);

            player2.compare(player1.getCombination());

            if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
                return;
            }
        }
        System.out.println("player2 à perdu");
    }
}
