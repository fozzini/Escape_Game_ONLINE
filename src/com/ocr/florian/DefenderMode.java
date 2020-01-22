package com.ocr.florian;

import java.io.UnsupportedEncodingException;

public class DefenderMode extends AbstractGame {

    // Mod defender.
    @Override
    protected void start() throws InterruptedException, UnsupportedEncodingException {
        String mode = "Defenseur";
        String character = "L'ordinateur à";
        displayIntroMessage(mode);
        setSecretHuman(generateComputer());

        for (int i = 0; i < getMaxTries(); i++) {
            Thread.sleep(2000);
            checkProposition(getSecretHuman(), generateComputer(),false, character);
        }
        endGame(character," perdu!");
    }
}



