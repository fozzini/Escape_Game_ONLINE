package com.ocr.florian;

import java.util.Scanner;

public class AppCombination {

	private static Scanner sc = new Scanner(System.in);

	private static int figures = 4;
	private int maxTries = 5;

	public static void setFigures(int figures) {
		AppCombination.figures = figures;
	}

	public void setMaxTries(int maxTries) {
		this.maxTries = maxTries;
	}

	public static void main(String[] args) {

		int[] combination = new int[figures];
		int[] proposition = new int[figures];

    	Game player1 = new Game(combination, proposition);
		Game player2 = new Game(combination, proposition);

		Menu(selectMode());
		player1.combination(1,9);
		player2.proposition(true,1,9);
		player1.compare(player2);
    }
	public static int selectMode() {

    	int selectedMode = Game.askForIntValue("\t\tEscape Game ONLINE\r\n\n\t" +
					"Choisissez le mode de jeu :\r\n\n\t\t" +
					"1- Challenger\r\n\t\t" +
					"2- Défenseur\r\n\t\t" +
				    "3- Duel\r\n\t\t" +
					"4- Quitter", 1, 4);


		return selectedMode;
	}


    public static void Menu(int selectedMode) {

		switch (selectedMode) {

			case 1:
				System.out.println("Mode sélectionné : Challenger");
				System.out.println("Trouvez la combinaison à "+ figures +" chiffres");
				//ChallengerMode.challenger();
				break;
			case 2:
				System.out.println("Mode sélectionné : Defenseur");
				System.out.println("Définissez une combinaison de " + figures + " chiffres aléatoirement");
				//DefenderMode.defender();
				break;
			case 3:
				System.out.println("Mode sélectionné : Duel");
				System.out.println("Défiez l'ordinateur");
				//DuelMode.duel();
				break;
			case 4:
				System.out.println("Vous quittez le jeu");
				break;
		}
	}

}
