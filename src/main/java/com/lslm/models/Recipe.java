package com.lslm.models;

import java.util.List;
import java.util.UUID;

public class Recipe {
    private UUID id;
    private String title;
    private int numberOfPeopleServed;
    private DificultyLevel dificultyLevel;
    private List<Step> steps;

    public Recipe(UUID id, String title, int numberOfPeopleServed, DificultyLevel dificultyLevel) {
        this.id = id;
        this.title = title;
        this.numberOfPeopleServed = numberOfPeopleServed;
        this.dificultyLevel = dificultyLevel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPeopleServed() {
        return numberOfPeopleServed;
    }

    public void setNumberOfPeopleServed(int numberOfPeopleServed) {
        this.numberOfPeopleServed = numberOfPeopleServed;
    }

    public DificultyLevel getDificultyLevel() {
        return dificultyLevel;
    }

    public void setDificultyLevel(DificultyLevel dificultyLevel) {
        this.dificultyLevel = dificultyLevel;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", numberOfPeopleServed=" + numberOfPeopleServed +
                ", dificultyLevel='" + dificultyLevel + '\'' +
                '}';
    }
}
