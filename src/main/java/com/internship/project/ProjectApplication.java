package com.internship.project;

import com.internship.project.calculating.ArithmeticOperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream("./src/main/resources/calculator.properties");
             Scanner scanner = new Scanner(System.in)) {

            ArithmeticOperations calculator = new ArithmeticOperations();
            String inputExpression = scanner.nextLine();
            String mathExpression = inputExpression.substring(0, inputExpression.indexOf("="));

            Properties properties = new Properties();
            properties.load(fileInputStream);

            String variableName = properties.getProperty("CALC_VAR_NAME");
            String varriableValue = properties.getProperty("CALC_VAR_VALUE");

            String result = calculator.apply(mathExpression, variableName, varriableValue);
            System.out.println(inputExpression.replace("?", result));

        }


    }
}