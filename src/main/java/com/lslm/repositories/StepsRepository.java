package com.lslm.repositories;

import com.lslm.models.DificultyLevel;
import com.lslm.models.Recipe;
import com.lslm.models.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StepsRepository {

    public List<Step> findStepsByRecipeId(UUID recipeId) {
        String query = "SELECT * FROM steps WHERE recipe_id = ?";
        List<Step> steps = new ArrayList<>();

        try {
            Connection connection = Configuration.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, recipeId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                UUID id = resultSet.getObject("id", UUID.class);
                String description  = resultSet.getString("description");

                steps.add(new Step(id, recipeId, description));
            }

            statement.close();
            Configuration.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return steps;
    }

    public void createStep(Step newStep) {
        String query = "INSERT INTO steps(id, recipe_id, description) VALUES (?, ?, ?)";

        try {
            Connection connection = Configuration.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setObject(1, newStep.getId());
            preparedStatement.setObject(2, newStep.getRecipeId());
            preparedStatement.setString(3, newStep.getDescription());

            preparedStatement.executeUpdate();
            Configuration.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
