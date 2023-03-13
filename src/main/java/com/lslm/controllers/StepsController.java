package com.lslm.controllers;

import com.lslm.models.Recipe;
import com.lslm.models.Step;
import com.lslm.repositories.StepsRepository;

import java.util.List;
import java.util.UUID;

public class StepsController {

    private Recipe recipe;
    private StepsRepository stepsRepository;

    public StepsController(Recipe recipe) {
        this.recipe = recipe;
        this.stepsRepository = new StepsRepository();
    }

    public List<Step> findAllSteps() {
        return this.stepsRepository.findStepsByRecipeId(recipe.getId());
    }

    public void createStep(String description) {
        Step newStep = new Step(UUID.randomUUID(), recipe.getId(), description);
        stepsRepository.createStep(newStep);
    }

    public void removeStep(Step stepToRemove) {
        stepsRepository.removeStep(stepToRemove);
    }
}
