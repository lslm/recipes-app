package com.lslm.ui;

import com.lslm.models.Recipe;
import com.lslm.models.Step;
import com.lslm.repositories.RecipesRepository;
import com.lslm.repositories.StepsRepository;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class MainScreen {

    private RecipesRepository recipesRepository = new RecipesRepository();
    private StepsRepository stepsRepository = new StepsRepository();

    private void updateRecipeListView(ListView recipeListView) {
        List<Recipe> updatedRecipes = recipesRepository.findRecipes();
        recipeListView.getItems().setAll(updatedRecipes);
    }

    public Parent build() {
        ListView recipesListView = new ListView();
        ListView stepsListView = new ListView();
        stepsListView.setMinWidth(500);

        List<Recipe> recipes = recipesRepository.findRecipes();

        recipes.forEach(recipe -> recipesListView.getItems().add(recipe));

        recipesListView.setOnMouseClicked(event -> {
            Recipe selectedRecipe = (Recipe) recipesListView.getSelectionModel().getSelectedItem();
            List<Step> steps = stepsRepository.findStepsByRecipeId(selectedRecipe.getId());
            stepsListView.getItems().setAll(steps);
        });

        Button openNewStepWindowButton = new Button("Adicionar passo à receita");

        openNewStepWindowButton.setOnAction(event -> {
            // Pegar a receita que está selecionada
            // abrir uma janela com os passos da receita selecionada
            Recipe selectedRecipe = (Recipe) recipesListView.getSelectionModel().getSelectedItem();
            AddStepWindow addStepWindow = new AddStepWindow(selectedRecipe);
            addStepWindow.open();
        });

        VBox stepsBox = new VBox(stepsListView, openNewStepWindowButton);
        HBox hBox = new HBox(recipesListView, stepsBox);

        MenuBar menuBar = buildMenuBar(recipesListView);

        return new VBox(menuBar, hBox);
    }

    private MenuBar buildMenuBar(ListView recipesListView) {
        Menu recipesMenu = new Menu("Receitas");
        MenuItem addRecipeMenuItem = new MenuItem("Adicionar receita");

        addRecipeMenuItem.setOnAction(e -> {
            NewRecipeWindow newRecipeWindow = new NewRecipeWindow();

            newRecipeWindow.open(() -> {
                updateRecipeListView(recipesListView);
            });
        });

        recipesMenu.getItems().add(addRecipeMenuItem);

        MenuBar menuBar = new MenuBar(recipesMenu);
        return menuBar;
    }

}
