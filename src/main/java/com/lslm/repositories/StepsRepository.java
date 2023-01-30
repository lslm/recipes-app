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
    public List<Step> findStepsById(UUID recipeId) {
        List<Step> steps = new ArrayList<>();
        String query = "SELECT * FROM steps WHERE recipe_id = ?";

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
}
