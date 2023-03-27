package com.lslm.controllers;

import com.lslm.models.Recipe;
import com.lslm.models.Step;
import com.lslm.repositories.RecipesRepository;
import com.lslm.repositories.StepsRepository;
import com.lslm.ui.MainScreen;
import javafx.stage.Stage;

import java.util.List;
import java.util.UUID;

public class MainScreenController {
    private Stage mainStage;

    private RecipesRepository recipesRepository = new RecipesRepository();
    private StepsRepository stepsRepository = new StepsRepository();

    public MainScreenController(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void open() {
        new MainScreen(this).build();
    }

    public List<Recipe> findRecipes() {
        return recipesRepository.findRecipes();
    }

    public List<Step> findStepsByRecipeId(UUID recipeId) {
        return stepsRepository.findStepsByRecipeId(recipeId);
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
