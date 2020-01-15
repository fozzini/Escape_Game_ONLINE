package com.ocr.florian;

public class DuelMod extends AbstractGame {

    // Mod duel.
    @Override
    protected void start() throws InterruptedException{
        String mod = "Duel";
        String computer = "L'ordinateur à";
        String human = "Vous avez";
        String common = "Vous et l'ordinateur avez";
        introductionString(mod);
        setSecretComputer(generateComputerArray(false));
        setSecretHuman(generateComputerArray(false));

        for (int i = 0; i < getMaxTries(); i++){
            System.out.println("L'ordinateur");
            Thread.sleep(2000);
            setProposition(generateComputerArray(true));
            GameString(getSecretHuman(),computer);
            System.out.println("vous");
            inputHumanArray();
            GameString(getSecretComputer(),human);
        }
        EndGameString(common);
    }
}



