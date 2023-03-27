package com.lslm.ui;

import com.lslm.controllers.AddStepController;
import com.lslm.controllers.MainScreenController;
import com.lslm.controllers.NewRecipeController;
import com.lslm.models.Recipe;
import com.lslm.models.Step;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class MainScreen {
    private MainScreenController mainScreenController;

    private final int DEFAULT_WIDTH = 800;
    private final int DEFAULT_HEIGHT = 600;

    public MainScreen(MainScreenController controller) {
        this.mainScreenController = controller;
    }

    private void updateRecipeListView(ListView recipeListView) {
        List<Recipe> updatedRecipes = mainScreenController.findRecipes();
        recipeListView.getItems().setAll(updatedRecipes);
    }

    public void build() {
        ListView recipesListView = new ListView();
        ListView stepsListView = new ListView();
        stepsListView.setMinWidth(500);

        List<Recipe> recipes = mainScreenController.findRecipes();

        recipes.forEach(recipe -> recipesListView.getItems().add(recipe));

        recipesListView.setOnMouseClicked(event -> {
            Recipe selectedRecipe = (Recipe) recipesListView.getSelectionModel().getSelectedItem();
            List<Step> steps = mainScreenController.findStepsByRecipeId(selectedRecipe.getId());
            stepsListView.getItems().setAll(steps);
        });

        Button openNewStepWindowButton = new Button("Adicionar passo à receita");

        openNewStepWindowButton.setOnAction(event -> {
            Recipe selectedRecipe = (Recipe) recipesListView.getSelectionModel().getSelectedItem();

            AddStepController addStepController = new AddStepController(selectedRecipe);
            addStepController.openScreen();
        });

        VBox stepsBox = new VBox(stepsListView, openNewStepWindowButton);
        HBox hBox = new HBox(recipesListView, stepsBox);

        MenuBar menuBar = buildMenuBar(recipesListView);

        VBox mainVBox = new VBox(menuBar, hBox);

        Scene scene = new Scene(mainVBox, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.mainScreenController.getMainStage().setScene(scene);
        this.mainScreenController.getMainStage().show();
    }

    private MenuBar buildMenuBar(ListView recipesListView) {
        Menu recipesMenu = new Menu("Receitas");
        MenuItem addRecipeMenuItem = new MenuItem("Adicionar receita");

        addRecipeMenuItem.setOnAction(e -> {
//            NewRecipeWindow newRecipeWindow = new NewRecipeWindow();
//
//            newRecipeWindow.open(() -> {
//                updateRecipeListView(recipesListView);
//            });

            NewRecipeController newRecipeController = new NewRecipeController(() -> {
                updateRecipeListView(recipesListView);
            });

            newRecipeController.open();
        });

        recipesMenu.getItems().add(addRecipeMenuItem);

        MenuBar menuBar = new MenuBar(recipesMenu);
        return menuBar;
    }

}
