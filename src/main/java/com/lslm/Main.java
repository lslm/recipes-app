package com.lslm;

import com.lslm.repositories.Configuration;
import com.lslm.ui.MainMenu;
import com.lslm.ui.MainScreen;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) throws SQLException {
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.show();
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
