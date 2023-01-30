package com.lslm.models;

import java.util.UUID;

public class Step {
    private UUID id;
    private UUID recipeId;
    private String description;

    public Step(UUID id, UUID recipeId, String description) {
        this.id = id;
        this.recipeId = recipeId;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(UUID recipeId) {
        this.recipeId = recipeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
