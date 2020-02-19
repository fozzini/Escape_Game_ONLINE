package com.ocr.florian;

import org.apache.log4j.Logger;
import java.io.IOException;

public class Escape_Game_App {

    private static Logger logger = Logger.getLogger(Escape_Game_App.class);

    public static void main(String[] args) throws IOException, InterruptedException {
		logger.info("Démarrage de l'application");
		while (true) {
            logger.info("Menu");
			ConfigProperties.loadProperties();
			gameModSelector(menu());
		}
	}

	public static int menu() {
		return Utils.askForIntValue("\t\tEscape Game ONLINE\r\n\n\t" +
				"Choisissez le mode de jeu :\r\t\t" +
				"1- Challenger\r\n\t\t" +
				"2- Défenseur\r\n\t\t" +
				"3- Duel\r\n\t\t" +
				"4- Quitter", 1, 4);
	}

	public static void gameModSelector(int playerChoice) throws InterruptedException, IOException {
		switch (playerChoice) {

			case 1:
				logger.info("ChallengerMode");
				startGame(new ChallengerMode());
				break;
			case 2:
				logger.info("DefenderMode");
				startGame(new DefenderMode());
				break;
			case 3:
				logger.info("DuelMode");
				startGame(new DuelMode());
				break;
			case 4:
				System.out.println("Vous quittez le jeu");
				logger.info("Fermeture de l'application");
				System.exit(0);
				break;
		}
	}

	private static void startGame(AbstractGame game) throws InterruptedException, IOException {
		game.start();
	}
}
