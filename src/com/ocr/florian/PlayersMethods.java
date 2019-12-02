package com.ocr.florian;

import java.util.Scanner;

public class PlayersMethods {
    public static final int maxTries = 5;
    public static Scanner sc = new Scanner(System.in);
//Création tableau de combinaison aléatoire.

    public void combinationChartMaker(int figures) {
        int combination[] = new int[figures];

        for (int i = 0; i < combination.length; i++) {
            combination[i] = this.randomNumber();
            System.out.print(combination[i]);
        }
    }

//Création de nombre aléatoire.

    public int randomNumber(){
        int Min = 0;
        int Max = 10;
        int randomNumber = (int) (Min + (Math.random() * (Max - Min)));

        return randomNumber;
    }

//Afficher la combinaison secrète.

    public void displayCombination(){
        System.out.print("(Combinaison secrète : ");
        this.combinationChartMaker(4 );
        System.out.println(")");
    }

    }
