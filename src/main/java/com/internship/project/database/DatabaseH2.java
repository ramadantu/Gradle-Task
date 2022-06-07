package com.internship.project.database;

import com.internship.project.ProjectApplication;
import com.internship.project.entities.Memory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseH2 {
    private String JDBC_DRIVER;
    private String DB_URL;
    private String USER;
    private String PASS;

    public void authorizationDB() throws IOException {
        try (InputStream propertiesPath = ProjectApplication.class.getResourceAsStream("/database.properties")) {
            Properties properties = new Properties();
            properties.load(propertiesPath);
            JDBC_DRIVER = properties.getProperty("JDBC_DRIVER");
            DB_URL = properties.getProperty("DB_URL");
            USER = properties.getProperty("USER");
            PASS = properties.getProperty("PASS");
        }
    }

    public void updateCalculatorMemory(Memory memory) throws Exception {
        Class.forName(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "MERGE INTO Calculator_Memory(id, M) VALUES( ?, ?)")) {
            preparedStatement.setInt(1, memory.getId());
            preparedStatement.setDouble(2, memory.getValue());
            preparedStatement.executeUpdate();
        }
    }

    public void fetchCalculatorMemory() throws Exception {
        Class.forName(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Calculator_Memory")) {
            Class.forName(JDBC_DRIVER);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double M = resultSet.getDouble("M");
                System.out.print("ID: " + id);
                System.out.println(" | M: " + M);
            }
        }
    }
}
