package com.internship.project.database;

import java.sql.*;

public class DatabaseH2 {
    public final String JDBC_DRIVER = "org.h2.Driver";
    public final String DB_URL = "jdbc:h2:~/test";
    public final String USER = "ramadan";
    public final String PASS = "123456";
    public Integer ID = 0;

    public void databaseUpdate(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            if (sql.startsWith("SELECT")) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    double M = rs.getDouble("M");

                    System.out.print("ID: " + id);
                    System.out.println(" | M: " + M);
                }
                rs.close();
            } else {
                stmt.executeUpdate(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqlE) {
                sqlE.printStackTrace();
            }
        }
    }

    public void createTable() {
        databaseUpdate("CREATE TABLE   Calculator_Memory " +
                "(id INTEGER not NULL, " +
                " M DOUBLE, " +
                " PRIMARY KEY ( id ))");
    }

    public void insertRecord(String value) {
        databaseUpdate("INSERT INTO Calculator_Memory " +
                "VALUES(" + ID++ + ", " + value + ")");
    }

    public void printTable() {
        databaseUpdate("SELECT *" +
                "FROM Calculator_Memory");
    }

    public void deleteTableIfExists() {
        databaseUpdate("DROP TABLE IF EXISTS Calculator_Memory");
    }

}
