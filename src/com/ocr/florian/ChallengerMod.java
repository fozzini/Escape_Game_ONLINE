package com.ocr.florian;

public class ChallengerMod extends AbstractGame {

    // Mod challenger.
    @Override
    protected void start() throws InterruptedException {
        String mod = "Challenger";
        String character = "Vous avez";
        introductionString(mod);
        setSecretComputer(generateComputerArray(false));

        for (int i = 0; i < getMaxTries(); i++) {
            inputHumanArray();
            GameString(getSecretComputer(),character);
        }
        EndGameString(character);
    }
}
