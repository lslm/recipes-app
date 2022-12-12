package models;

public class Recipe {
    private String title;
    private int numberOfPeopleServed;
    private DificultyLevel dificultyLevel;

    public Recipe(String title, int numberOfPeopleServed, DificultyLevel dificultyLevel) {
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
