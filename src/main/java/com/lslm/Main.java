package com.lslm;

import com.lslm.ui.MainScreen;
import javafx.application.Application;
import javafx.scene.Parent;
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
        Parent mainScreen = new MainScreen().build();

        Scene scene = new Scene(mainScreen, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
