package com.ocr.florian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


	private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


	Player computer = new Player();
	Player human = new Player();

	Menu(selectMode());

    }
	public static int selectMode() {

    	int selectedMode = askForIntValue("\t\tEscape Game ONLINE\r\n\n\t" +
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
				System.out.println("Trouvez la combinaison à "+ 4 +" chiffres");
				//ChallengerMode.challenger();
				break;
			case 2:
				System.out.println("Mode sélectionné : Defenseur");
				System.out.println("Définissez une combinaison de " + 4 + " chiffres aléatoirement");
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
	static int askForIntValue(String answer, int minValue, int maxValue) {

		System.out.println(answer);

		int value = 0;
		boolean valueIsGood;
		do {
			try {
				value = sc.nextInt();
				valueIsGood = true;
			} catch (InputMismatchException e) {
				sc.next();
				System.err.println("Saisir une valeur valide");
				valueIsGood = false;
			}
			if (value < minValue ||(value > maxValue)) {
				System.err.println("Saisir un chiffre entre " + minValue + " et " + maxValue);
				valueIsGood = false;
			}

		} while (!valueIsGood);
		return value;
	}

}
