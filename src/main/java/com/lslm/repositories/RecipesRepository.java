package com.lslm.repositories;

import com.lslm.models.DificultyLevel;
import com.lslm.models.Recipe;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RecipesRepository {
    public void createRecipe(Recipe newRecipe) {
        String query = "INSERT INTO recipes(id, title, number_of_people_served, dificulty_level) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = Configuration.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, newRecipe.getId());
            preparedStatement.setString(2, newRecipe.getTitle());
            preparedStatement.setInt(3, newRecipe.getNumberOfPeopleServed());
            preparedStatement.setString(4, newRecipe.getDificultyLevel().name());

            preparedStatement.executeUpdate();
            Configuration.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Recipe> findRecipes() {
        String query = "SELECT * FROM recipes";

        List<Recipe> recipes = new ArrayList<>();

        try {
            Connection connection = Configuration.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                UUID id = resultSet.getObject("id", UUID.class);
                String title = resultSet.getString("title");
                int numberOfPeopleServed = resultSet.getInt("number_of_people_served");
                DificultyLevel dificultyLevel = DificultyLevel.valueOf(resultSet.getString("dificulty_level"));

                Recipe recipe = new Recipe(id, title, numberOfPeopleServed, dificultyLevel);
                recipes.add(recipe);
            }

            Configuration.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recipes;
    }
}
