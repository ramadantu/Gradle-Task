package com.internship.project;

import com.internship.project.calculating.ArithmeticOperations;
import com.internship.project.database.DatabaseH2;

import java.io.*;
import java.util.*;

public class ProjectApplication {
    public static final String VAR_NAME = "CALC_VAR_NAME";
    public static final String VAR_VALUE = "CALC_VAR_VALUE";
    public static final String MEM_VALUE = "CALC_MEM_VALUE";
    public static final String MEM_FILE_FORMAT = "M = %s \n";

    public static void main(String[] args) throws IOException {

        try (InputStream inputStream = ProjectApplication.class.getResourceAsStream("/calculator.properties");
             FileReader fileReader = new FileReader("src/main/resources/input.txt");
             FileWriter fileWriter = new FileWriter("src/main/resources/memory.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            DatabaseH2 databaseH2 = new DatabaseH2();
            databaseH2.deleteTableIfExists();
            databaseH2.createTable();

            ArithmeticOperations calculator = new ArithmeticOperations();
            String inputLine;
            String leftSideOfExpression;
            String rightSideOfExpression;
            String resultOfLeftSide;

            Properties properties = new Properties();
            properties.load(inputStream);

            String envVarName = System.getenv(VAR_NAME);
            String envVarValue = System.getenv(VAR_VALUE);

            while ((inputLine = bufferedReader.readLine()) != null) {

                leftSideOfExpression = inputLine.substring(0, inputLine.indexOf("="));
                rightSideOfExpression = inputLine.substring(inputLine.indexOf("="));

                if (envVarName != null && envVarValue != null) {
                    properties.setProperty(VAR_NAME, envVarName);
                    properties.setProperty(VAR_VALUE, envVarValue);

                    String variableName = properties.getProperty(VAR_NAME);
                    String variableValue = properties.getProperty(VAR_VALUE);

                    leftSideOfExpression = replaceMemWithItsValueIfExist(leftSideOfExpression, properties.getProperty(MEM_VALUE));
                    resultOfLeftSide = calculator.apply(leftSideOfExpression, variableName, variableValue);
                    System.out.println(leftSideOfExpression
                            + resultOfRightSide(rightSideOfExpression, properties, fileWriter, resultOfLeftSide, databaseH2));
                } else {
                    leftSideOfExpression = replaceMemWithItsValueIfExist(leftSideOfExpression, properties.getProperty(MEM_VALUE));
                    resultOfLeftSide = calculator.apply(leftSideOfExpression, null, null);
                    System.out.println(leftSideOfExpression
                            + resultOfRightSide(rightSideOfExpression, properties, fileWriter, resultOfLeftSide, databaseH2));
                }
            }

            databaseH2.printTable();
        }
    }

    public static String replaceMemWithItsValueIfExist(String expression, String value) {
        if (expression.contains("M")) {
            return expression.replace("M", value);
        }
        return expression;
    }

    public static String resultOfRightSide(
            String rightSideOfExpression,
            Properties properties,
            FileWriter fileWriter,
            String resultOfLeftSide,
            DatabaseH2 databaseH2) throws IOException {
        if (rightSideOfExpression.contains("M+")) {
            properties.setProperty(
                    MEM_VALUE,
                    String.valueOf(Double.parseDouble(properties.getProperty(MEM_VALUE)) + Double.parseDouble(resultOfLeftSide)));
            fileWriter.append(String.format(MEM_FILE_FORMAT, properties.getProperty(MEM_VALUE)));
            databaseH2.insertRecord(properties.getProperty(MEM_VALUE));
            return rightSideOfExpression.replace("M+", properties.getProperty(MEM_VALUE));
        } else if (rightSideOfExpression.contains("M-")) {
            properties.setProperty(
                    MEM_VALUE,
                    String.valueOf(Double.parseDouble(properties.getProperty(MEM_VALUE)) - Double.parseDouble(resultOfLeftSide)));
            fileWriter.append(String.format(MEM_FILE_FORMAT, properties.getProperty(MEM_VALUE)));
            databaseH2.insertRecord(properties.getProperty(MEM_VALUE));
            return rightSideOfExpression.replace("M-", properties.getProperty(MEM_VALUE));
        } else if (rightSideOfExpression.contains("M")) {
            properties.setProperty(MEM_VALUE, resultOfLeftSide);
            fileWriter.append(String.format(MEM_FILE_FORMAT, properties.getProperty(MEM_VALUE)));
            databaseH2.insertRecord(properties.getProperty(MEM_VALUE));
            return rightSideOfExpression.replace("M", properties.getProperty(MEM_VALUE));
        } else {
            return rightSideOfExpression.replace("?", resultOfLeftSide);
        }
    }
}