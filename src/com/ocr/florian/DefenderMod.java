package com.ocr.florian;

public class DefenderMod extends AbstractGame {

    // Mod defender.
    @Override
    protected void start() throws InterruptedException {
        String mod = "Defenseur";
        String character = "L'ordinateur à";
        introductionString(mod);
        setSecretHuman(generateComputerArray(false));

        for (int i = 0; i < getMaxTries(); i++) {
            Thread.sleep(2000);
            setProposition(generateComputerArray(true));
            GameString(getSecretHuman(),character);
        }
        EndGameString(character);
    }
}



