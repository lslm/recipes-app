package com.lslm.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/recipes_app";
    private static final String CONNECTION_USERNAME = "lucassantos";
    private static final String CONNECTION_PASSWORD = "admin";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException exception) {
                System.out.println("Ocorreu um erro ao tentar fechar a conexão");
            }
        }
    }
}
