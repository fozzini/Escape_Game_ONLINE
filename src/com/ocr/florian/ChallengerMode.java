package com.ocr.florian;

public class ChallengerMode extends AbstractGame {

    // Mod challenger.
    @Override
    protected void start() throws InterruptedException {
        String mode = "Challenger";
        String character = "Vous avez";
        displayIntroMessage(mode);
        setSecretComputer(generateComputer());

        for (int i = 0; i < getMaxTries(); i++) {
            checkProposition(getSecretComputer(), inputHuman(), true, character);
        }
        endGame(character);
    }
}
