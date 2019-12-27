package com.ocr.florian;

import java.util.Scanner;

public class Escape_Game_App {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		selectMode(menu());
	}

	// Sélection du mode à partir du menu.
	public static int menu() {
		int menu = Utils.askForIntValue("\t\tEscape Game ONLINE\r\n\n\t" +
				"Choisissez le mode de jeu :\r\n\n\t\t" +
				"1- Challenger\r\n\t\t" +
				"2- Défenseur\r\n\t\t" +
				"3- Duel\r\n\t\t" +
				"4- Quitter", 1, 4);
		return menu;
	}


	public static void selectMode(int menu) throws InterruptedException {
		switch (menu) {

			case 1:
				ChallengerMode.start();
				break;
			case 2:
				DefenderMode.start();
				break;
			case 3:
				DuelMode.start();
				break;
			case 4:
				System.out.println("Vous quittez le jeu");
				break;
		}

	}

}
