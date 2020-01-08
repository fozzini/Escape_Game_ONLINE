package com.ocr.florian;

import java.util.Scanner;

public class Escape_Game_App {

	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) throws InterruptedException {

		gameModSelector(menu());
	}

	public static int menu() {
		int playerChoice = Utils.askForIntValue("\t\tEscape Game ONLINE\r\n\n\t" +
				"Choisissez le mode de jeu :\r\t\t" +
				"1- Challenger\r\n\t\t" +
				"2- Défenseur\r\n\t\t" +
				"3- Duel\r\n\t\t" +
				"4- Quitter", 1, 4);
		return playerChoice;
	}

	public static void gameModSelector(int playerChoice) throws InterruptedException {

		switch (playerChoice) {

			case 1:
				startGame(new ChallengerMod());
				break;
			case 2:
				startGame(new DefenderMod());
				break;
			case 3:
				startGame(new DuelMod());
				break;
			case 4:
				System.out.println("Vous quittez le jeu");
				break;
		}
	}

	public static void startGame(AbstractGame game) throws InterruptedException {
		game.start();
	}
}
