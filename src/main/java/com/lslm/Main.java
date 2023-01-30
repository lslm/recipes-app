package com.lslm;

import com.lslm.repositories.Configuration;
import com.lslm.ui.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) throws SQLException {
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
