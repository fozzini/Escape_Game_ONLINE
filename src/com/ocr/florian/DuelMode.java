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

        for (int i = 0; !isWon() ; i++) {
            System.out.println("L'ordinateur");
            Thread.sleep(2000);
            checkProposition(getSecretHuman(), generateComputer(),true);
            if (isWon()) {
                character = "L'ordinateur à";
                break;
            }
            System.out.println("vous");
            checkProposition(getSecretComputer(), userEntry(),false);
            if (isWon()) {
                character = " Vous avez";
                break;
            }
        }
        endGame(character);
    }
}



