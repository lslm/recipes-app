package com.lslm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox(new Text("Olá"));

        Scene scene = new Scene(hBox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
