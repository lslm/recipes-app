package com.lslm.ui;

import com.lslm.controllers.AddStepController;
import com.lslm.models.Recipe;
import com.lslm.models.Step;
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

public class AddStepWindow {
    private Stage stage;
    private Scene scene;

    private ListView stepsListView;
    private AddStepController stepsController;

    public AddStepWindow(AddStepController controller) {
        this.stepsController = controller;
        this.stepsListView = new ListView();

        this.stage = new Stage();
        this.scene = new Scene(buildScreen(), 500, 400);
        stage.setScene(scene);
    }

    private void updateStepsList() {
        stepsListView.getItems().setAll(stepsController.findAllSteps());
    }

    private Parent buildScreen() {
        List<Step> steps = stepsController.findAllSteps();
        stepsListView.getItems().setAll(steps);

        Label newStepLabel = new Label("Novo passo");
        TextField newStepTextField = new TextField();
        HBox newStepHBox = new HBox(newStepLabel, newStepTextField);
        newStepHBox.setAlignment(Pos.CENTER);
        newStepHBox.setHgrow(newStepTextField, Priority.ALWAYS);
        newStepHBox.setSpacing(8);
        newStepHBox.setPadding(new Insets(8, 0, 8, 0));

        Button createStepButton = new Button("Adicionar passo");
        Button removeStepButton = new Button("Remover passo");

        createStepButton.setOnAction(event -> {
            String newStepText = newStepTextField.getText();
            stepsController.createStep(newStepText);
            updateStepsList();
        });

        removeStepButton.setOnAction(event -> {
            Step selectedStep = (Step) stepsListView.getSelectionModel().getSelectedItem();
            stepsController.removeStep(selectedStep);
            updateStepsList();
        });

        HBox actionButtons = new HBox(createStepButton, removeStepButton);
        actionButtons.setSpacing(8);

        VBox vBox = new VBox(stepsListView, newStepHBox, actionButtons);

        vBox.setPadding(new Insets(8, 8, 8, 8));

        return vBox;
    }

    public void open() {
        stage.show();
    }
}
