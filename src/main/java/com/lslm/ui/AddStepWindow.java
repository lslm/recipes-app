package com.lslm.ui;

import com.lslm.models.Recipe;
import com.lslm.models.Step;
import com.lslm.repositories.StepsRepository;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.UUID;

public class AddStepWindow {
    private Stage stage;
    private Scene scene;

    private Recipe selectedRecipe;
    private StepsRepository stepsRepository;

    public AddStepWindow(Recipe selectedRecipe) {
        this.selectedRecipe = selectedRecipe;
        this.stepsRepository = new StepsRepository();
        this.stage = new Stage();
        this.scene = new Scene(buildScreen(), 500, 400);
        stage.setScene(scene);
    }

    private Parent buildScreen() {
        ListView stepsListView = new ListView();

        List<Step> steps = stepsRepository.findStepsByRecipeId(selectedRecipe.getId());
        stepsListView.getItems().setAll(steps);

        Label newStepLabel = new Label("Novo passo");
        TextField newStepTextField = new TextField();
        HBox newStepHBox = new HBox(newStepLabel, newStepTextField);
        newStepHBox.setAlignment(Pos.CENTER);
        newStepHBox.setHgrow(newStepTextField, Priority.ALWAYS);
        newStepHBox.setSpacing(8);
        newStepHBox.setPadding(new Insets(8, 0, 8, 0));

        Button createStepButton = new Button("Adicionar passo");

        createStepButton.setOnAction(event -> {
            String newStepText = newStepTextField.getText();
            Step newStep = new Step(UUID.randomUUID(), selectedRecipe.getId(), newStepText);
            stepsRepository.createStep(newStep);
            stepsListView.getItems().add(newStep);
        });

        VBox vBox = new VBox(stepsListView, newStepHBox, createStepButton);

        vBox.setPadding(new Insets(8, 8, 8, 8));

        return vBox;
    }

    public void open() {
        stage.show();
    }
}
