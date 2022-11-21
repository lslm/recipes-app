package models;

public class Recipe {
    private String title;
    private int numberOfPeopleServed;
    private String dificultyLevel;

    public Recipe(String title, int numberOfPeopleServed, String dificultyLevel) {
        this.title = title;
        this.numberOfPeopleServed = numberOfPeopleServed;
        this.dificultyLevel = dificultyLevel;
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

    public String getDificultyLevel() {
        return dificultyLevel;
    }

    public void setDificultyLevel(String dificultyLevel) {
        this.dificultyLevel = dificultyLevel;
    }
}
