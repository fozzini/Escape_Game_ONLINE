package com.ocr.florian;

public class DuelMode extends AbstractGame {

    // Mod duel.
    @Override
    protected void start() throws InterruptedException {
        String mode = "Duel";
        String character = "Vous et l'ordinateur avez";
        displayIntroMessage(mode);
        setSecretComputer(generateComputer());
        setSecretHuman(userEntry());
        isDeveloper(getSecretComputer());
        isDeveloper(getSecretHuman());

        for (int i = 0; i < ConfigProperties.getMaxTries() ; i++){
            System.out.println("L'ordinateur");
            Thread.sleep(2000);
            checkProposition(getSecretHuman(), generateComputer(),true);
            if (getIsWon()) {
                character = "L'ordinateur à";
                break;
            }
            System.out.println("vous");
            checkProposition(getSecretComputer(), userEntry(),false);
            if (getIsWon()) {
                character = " Vous avez";
                break;
            }
        }
        endGame(character);
    }
}



