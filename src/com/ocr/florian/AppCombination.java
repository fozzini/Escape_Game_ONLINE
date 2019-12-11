package com.ocr.florian;

import java.util.Arrays;
import java.util.Scanner;

public class AppCombination {

	private static Scanner sc = new Scanner(System.in);

	//variables de configuration du jeu.

	protected static int figures = 4;

	public static void setFigures(int figures) {
		AppCombination.figures = figures;
	}

	static int[] combinationP1 = new int[figures];
	static int[] propositionP1 = new int[figures];
	static int[] combinationP2 = new int[figures];
	static int[] propositionP2 = new int[figures];


	//main.

	public static void main(String[] args) throws InterruptedException {

		selectMode(menu());

	}


	//Sélection du mode à partir du menu.

	public static int menu() {

		int menu = Game.askForIntValue("\t\tEscape Game ONLINE\r\n\n\t" +
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
				System.out.println("Mode sélectionné : Challenger");
				System.out.println("Trouvez la combinaison à " + figures + " chiffres");

				challenger();
				break;
			case 2:
				System.out.println("Mode sélectionné : Defenseur");
				System.out.println("Définissez une combinaison de " + figures + " chiffres aléatoirement");

				defender();
				break;
			case 3:
				System.out.println("Mode sélectionné : Duel");
				System.out.println("Défiez l'ordinateur");

				duel();
				break;
			case 4:
				System.out.println("Vous quittez le jeu");
				break;
		}

	}
	//mode challenger

	public static void challenger() {

		Game player1 = new ChallengerMode(combinationP1, propositionP1);
		Game player2 = new ChallengerMode(combinationP2, propositionP2);

		player1.combination(1, 9);

		for (int i = 0; i < Game.maxTries; i++) {

			player2.proposition(true, combinationP1);

			player2.compare(player1.getCombination());

			if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
				return;
			}
		}
		System.out.println("player2 à perdu");
	}

	//mode defender.

	public static void defender() {

		Game player1 = new DefenserMode(combinationP1, propositionP1);
		Game player2 = new DefenserMode(combinationP2, propositionP2);

		player1.combination(1, 9);

		for (int i = 0; i < Game.maxTries; i++) {

			player2.proposition(false, combinationP1);

			player2.compare(player1.getCombination());

			if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
				return;
			}
		}
		System.out.println("player2 à perdu");

	}
	//mode duel.

	public static void duel() throws InterruptedException {


		Game player1 = new DuelMode(combinationP1, propositionP1);
		Game player2 = new DuelMode(combinationP2, propositionP2);

		player1.combination(1, 9);
		player2.combination(1, 9);

		for (int i = 0; i < Game.maxTries; i++) {

			System.out.println("Proposition du joueur 1");

			player1.proposition(true, combinationP2);
			player1.compare(player2.getCombination());

			if (Arrays.equals(player2.getCombination(), player1.getProposition())) {
				System.out.println("player1 à gagné !");
				return;
			}

			Thread.sleep(1000);

			System.out.println("Proposition du joueur 2");

			Thread.sleep(1000);

			player2.proposition(false, combinationP1);
			player2.compare(player1.getCombination());

			Thread.sleep(1000);

			if (Arrays.equals(player1.getCombination(), player2.getProposition())) {
				System.out.println("player2 à gagné !");
				return;
			}

		}

	}

}
