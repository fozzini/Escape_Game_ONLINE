package com.ocr.florian;

public class DefenderMode extends AbstractGame {

    // Mod defender.
    @Override
    protected void start() throws InterruptedException {
        String mode = "Defenseur";
        String character = "L'ordinateur à";
        displayIntroMessage(mode);
        setSecretHuman(inputHuman(Utils.catchException()));
        isDeveloper(getSecretHuman());

        for (int i = 0; i < getMaxTries(); i++) {
            Thread.sleep(2000);
            checkProposition(getSecretHuman(), generateComputer(),true, character);
        }
        endGame(character," perdu!");
    }
}



