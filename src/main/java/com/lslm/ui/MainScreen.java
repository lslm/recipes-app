package com.lslm.ui;

import com.lslm.models.Recipe;
import com.lslm.models.Step;
import com.lslm.repositories.RecipesRepository;
import com.lslm.repositories.StepsRepository;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

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

        return new HBox(recipesListView, stepsListView);
    }

}
