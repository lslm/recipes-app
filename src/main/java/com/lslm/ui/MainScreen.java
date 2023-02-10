package com.lslm.ui;

import com.lslm.models.Recipe;
import com.lslm.models.Step;
import com.lslm.repositories.RecipesRepository;
import com.lslm.repositories.StepsRepository;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class MainScreen {

    private RecipesRepository recipesRepository = new RecipesRepository();
    private StepsRepository stepsRepository = new StepsRepository();

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



        HBox hBox = new HBox(recipesListView, stepsListView);

        MenuBar menuBar = buildMenuBar();

        return new VBox(menuBar, hBox);
    }

    private MenuBar buildMenuBar() {
        Menu recipesMenu = new Menu("Receitas");
        MenuItem addRecipeMenuItem = new MenuItem("Adicionar receita");

        addRecipeMenuItem.setOnAction(e -> {
            NewRecipeWindow newRecipeWindow = new NewRecipeWindow();
            newRecipeWindow.open();
        });

        recipesMenu.getItems().add(addRecipeMenuItem);

        MenuBar menuBar = new MenuBar(recipesMenu);
        return menuBar;
    }

}
