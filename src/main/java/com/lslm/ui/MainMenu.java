package com.lslm.ui;

import java.util.Scanner;

public class MainMenu {
    public void show() {
        System.out.println("-------- App de Receitas --------");

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1 - Cadastrar receitas");

            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            process(option);
        } while (option != 0);
    }

    public void process(int option) {
        switch (option) {
            case 1: {
                RecipesMenu.show();
            }
        }
    }
}
