package com.ocr.florian;

import java.io.IOException;


public class Escape_Game_App {

	public static void main(String[] args) throws IOException, InterruptedException {
		while (true) {
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
				startGame(new ChallengerMode());
				break;
			case 2:
				startGame(new DefenderMode());
				break;
			case 3:
				startGame(new DuelMode());
				break;
			case 4:
				System.out.println("Vous quittez le jeu");
				System.exit(0);
				break;
		}
	}

	private static void startGame(AbstractGame game) throws InterruptedException, IOException {
		game.start();
	}
}
