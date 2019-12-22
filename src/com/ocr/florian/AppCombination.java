package com.ocr.florian;

import java.util.Scanner;

public class AppCombination {

	private static Scanner sc = new Scanner(System.in);

	//main.

	public static void main(String[] args) throws InterruptedException {

		selectMode(menu());

	}


	//Sélection du mode à partir du menu.

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
				System.out.println("Mode sélectionné : Challenger");
				System.out.println("Trouvez la combinaison à " + Game.getCombinationLength() + " chiffres");

				ChallengerMode.challenger();
				break;
			case 2:
				System.out.println("Mode sélectionné : Defenseur");
				System.out.println("Définissez une combinaison de " + Game.getCombinationLength() + " chiffres aléatoirement");

				DefenserMode.defenser();
				break;
			case 3:
				System.out.println("Mode sélectionné : Duel");
				System.out.println("Défiez l'ordinateur");

				DuelMode.duel();
				break;
			case 4:
				System.out.println("Vous quittez le jeu");
				break;
		}

	}

}
