package com.ocr.florian;

public class DuelMode extends AbstractGame {

    // Mod duel.
    @Override
    protected void start() throws InterruptedException{
        String mode = "Duel";
        String computer = "L'ordinateur à";
        String human = "Vous avez";
        String common = "Vous et l'ordinateur avez";
        displayIntroMessage(mode);
        setSecretComputer(generateComputer());
        setSecretHuman(generateComputer());

        for (int i = 0; i < getMaxTries(); i++){
            System.out.println("L'ordinateur");
            Thread.sleep(2000);
            checkProposition(getSecretHuman(), generateComputer(),false, computer);
            System.out.println("vous");
            checkProposition(getSecretComputer(), inputHuman(),true, human);
        }
        endGame(common);
    }
}



