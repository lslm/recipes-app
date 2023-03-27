package com.lslm.ui;

import com.lslm.controllers.NewRecipeController;
import com.lslm.models.DificultyLevel;
import com.lslm.models.Recipe;
import com.lslm.repositories.RecipesRepository;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.UUID;

public class NewRecipeWindow {

    private RecipesRepository recipesRepository = new RecipesRepository();

    private NewRecipeController newRecipeController;

    public NewRecipeWindow(NewRecipeController controller) {
        newRecipeController = controller;
    }

    private Parent buildForm() {
        TextField titleTextField = new TextField();
        TextField numberOfPeopleServerTextField = new TextField();
        ChoiceBox dificultyLevelChoiceBox = new ChoiceBox();

        dificultyLevelChoiceBox.getItems().add(new DificultyLevelChoice(DificultyLevel.EASY, "Fácil"));
        dificultyLevelChoiceBox.getItems().add(new DificultyLevelChoice(DificultyLevel.INTERMEDIATE, "Médio"));
        dificultyLevelChoiceBox.getItems().add(new DificultyLevelChoice(DificultyLevel.HARD, "Difícil"));

        Button createRecipeButton = new Button("Cadastrar receita");

        createRecipeButton.setOnAction(e -> {
            String title = titleTextField.getText();
            int numberOfPeopleServed = Integer.valueOf(numberOfPeopleServerTextField.getText());

            DificultyLevelChoice selectedDificultyLevel = (DificultyLevelChoice) dificultyLevelChoiceBox.getValue();
            DificultyLevel dificultyLevel = selectedDificultyLevel.getDificultyLevel();

            Recipe newRecipe = new Recipe(UUID.randomUUID(), title, numberOfPeopleServed, dificultyLevel);
            recipesRepository.createRecipe(newRecipe);

            Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION, "Receita cadastrada com sucesso!");
            successAlert.show();
        });

        return new VBox(new Label("Título da receita"), titleTextField,
                new Label("Número de pessoas servidas"), numberOfPeopleServerTextField,
                new Label("Nível de dificuldade"), dificultyLevelChoiceBox,
                createRecipeButton);
    }

    public void open(ScreenCallback callback) {
        Stage stage = new Stage();
        stage.setOnCloseRequest(e -> {
            callback.call();
        });
        Scene scene = new Scene(buildForm(), 500, 400);
        stage.setScene(scene);
        stage.show();
    }


    private class DificultyLevelChoice {
        private DificultyLevel dificultyLevel;
        private String description;

        public DificultyLevelChoice(DificultyLevel dificultyLevel, String description) {
            this.dificultyLevel = dificultyLevel;
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }

        public DificultyLevel getDificultyLevel() {
            return dificultyLevel;
        }
    }
}
