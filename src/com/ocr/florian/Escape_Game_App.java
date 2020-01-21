package com.ocr.florian;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Escape_Game_App {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
		gameModSelector(menu());
	}

	public static int menu() {
		return Utils.askForIntValue("\t\tEscape Game ONLINE\r\n\n\t" +
				"Choisissez le mode de jeu :\r\t\t" +
				"1- Challenger\r\n\t\t" +
				"2- Défenseur\r\n\t\t" +
				"3- Duel\r\n\t\t" +
				"4- Quitter", 1, 4);
	}

	private static void gameModSelector(int playerChoice) throws InterruptedException, UnsupportedEncodingException {
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
				break;
		}
	}

	private static void startGame(AbstractGame game) throws InterruptedException, UnsupportedEncodingException {
		game.start();
	}
}
