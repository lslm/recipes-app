package com.lslm;

import com.lslm.repositories.Configuration;
import com.lslm.ui.MainMenu;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.show();
    }
}
