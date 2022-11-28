package ui;

import models.DificultyLevel;
import models.Recipe;

import java.sql.SQLOutput;
import java.util.Scanner;

public class RecipesMenu {
    public static void show() {
        System.out.println("------- CADASTRANDO NOVA RECEITA -------");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual o título da receita: ");
        String title = scanner.nextLine();

        System.out.print("Qual o nível de dificuldade da receita (EASY, INTERMEDIATE, HARD): ");
        String dificultyLevelChoice = scanner.next();

        DificultyLevel dificultyLevel;

        try {
            dificultyLevel = DificultyLevel.valueOf(dificultyLevelChoice.toUpperCase());
        } catch (IllegalArgumentException exception) {
            System.out.println("-------------- OCORREU UM ERRO --------------");
            System.out.println("O nível de dificuldade está incorreto");
            System.out.println("---------------------------------------------");

            return;
        }

        System.out.print("Quantas pessoas essa receita serve: ");
        int numberOfPeopleServed = scanner.nextInt();

        Recipe newRecipe = new Recipe(title, numberOfPeopleServed, dificultyLevel);
        System.out.println(newRecipe);
    }
}
