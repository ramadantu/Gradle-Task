package com.internship.project;

import com.internship.project.calculating.ArithmeticOperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        final String VAR_NAME = "CALC_VAR_NAME";
        final String VAR_VALUE = "CALC_VAR_VALUE";

        try (FileInputStream fileInputStream = new FileInputStream("./src/main/resources/calculator.properties");
             Scanner scanner = new Scanner(System.in)) {

            ArithmeticOperations calculator = new ArithmeticOperations();
            String inputExpression = scanner.nextLine();
            String mathExpression = inputExpression.substring(0, inputExpression.indexOf("="));
            String result;

            Properties properties = new Properties();
            properties.load(fileInputStream);

            String envVarName = System.getenv(VAR_NAME);
            String envVarValue = System.getenv(VAR_VALUE);

            if (envVarName != null && envVarValue != null) {
                properties.setProperty(VAR_NAME, envVarName);
                properties.setProperty(VAR_VALUE, envVarValue);

                String variableName = properties.getProperty(VAR_NAME);
                String variableValue = properties.getProperty(VAR_VALUE);

                result = calculator.apply(mathExpression, variableName, variableValue);
            } else {
                result = calculator.apply(mathExpression, null, null);
            }
            
            System.out.println(inputExpression.replace("?", result));

        }


    }
}