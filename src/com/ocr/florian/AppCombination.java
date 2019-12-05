package com.ocr.florian;

import java.util.Scanner;

public class AppCombination {

	private static Scanner sc = new Scanner(System.in);

//varible de configuration du jeu.

	protected static int figures = 4;

	public static void setFigures(int figures) {
		AppCombination.figures = figures;
	}

//main.

	public static void main(String[] args) {
        int[] combination = new int[figures];
        int[] proposition = new int[figures];
        Game player1 = new Game(combination, proposition);
        Game player2 = new Game(combination, proposition);
	    Menu(selectMode(),player1,player2);
        System.out.println("player2 à gagné");

    }

//Sélection du mode à partir du menu.

	public static int selectMode() {

    	int selectedMode = Game.askForIntValue("\t\tEscape Game ONLINE\r\n\n\t" +
					"Choisissez le mode de jeu :\r\n\n\t\t" +
					"1- Challenger\r\n\t\t" +
					"2- Défenseur\r\n\t\t" +
				    "3- Duel\r\n\t\t" +
					"4- Quitter", 1, 4);


		return selectedMode;
	}


    public static void Menu(int selectedMode, Game player1, Game player2) {

		switch (selectedMode) {

			case 1:
				System.out.println("Mode sélectionné : Challenger");
				System.out.println("Trouvez la combinaison à "+ figures +" chiffres");
                player1.challenger(player2,player1);
				break;
			case 2:
				System.out.println("Mode sélectionné : Defenseur");
				System.out.println("Définissez une combinaison de " + figures + " chiffres aléatoirement");
                player1.defender(player2,player1);
				break;
			case 3:
				System.out.println("Mode sélectionné : Duel");
				System.out.println("Défiez l'ordinateur");
				break;
			case 4:
				System.out.println("Vous quittez le jeu");
				break;
		}

    }

}
