package com.ocr.florian;

import java.io.UnsupportedEncodingException;

public class ChallengerMode extends AbstractGame {

    // Mod challenger.
    @Override
    protected void start() throws InterruptedException, UnsupportedEncodingException {
        String mode = "Challenger";
        String character = "Vous avez";
        displayIntroMessage(mode);
        setSecretComputer(generateComputer());

        for (int i = 0; i < getMaxTries(); i++) {
            checkProposition(getSecretComputer(), inputHuman(), true, character);
        }
        endGame(character," perdu!");
    }
}
