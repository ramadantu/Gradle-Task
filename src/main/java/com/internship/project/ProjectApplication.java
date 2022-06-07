package com.internship.project;

import com.internship.project.calculating.ArithmeticOperations;
import com.internship.project.database.DatabaseH2;
import com.internship.project.entities.Memory;

import java.io.*;

public class ProjectApplication {
    private static Integer ID = 0;

    public static void main(String[] args) throws Exception {
        try (FileReader fileReader = new FileReader("src/main/resources/input.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            ArithmeticOperations calculator = new ArithmeticOperations();
            Memory memory = new Memory();
            DatabaseH2 databaseH2 = new DatabaseH2();
            databaseH2.authorizationDB();

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                String leftSideOfExpression = inputLine.substring(0, inputLine.indexOf("="));
                String rightSideOfExpression = inputLine.substring(inputLine.indexOf("="));
                leftSideOfExpression = leftSideOfExpression.contains("M")
                        ? leftSideOfExpression.replace("M", String.valueOf(memory.getValue()))
                        : leftSideOfExpression;
                String resultOfLeftSide = calculator.apply(leftSideOfExpression);
                if (rightSideOfExpression.contains("?")) {
                    System.out.println(leftSideOfExpression + " = " + resultOfLeftSide);
                } else {
                    memory.setId(ID++);
                    updateMemory(resultOfLeftSide, rightSideOfExpression, memory);
                    databaseH2.updateCalculatorMemory(memory);
                    System.out.println(leftSideOfExpression + " = " + memory.getValue());
                }
            }
            databaseH2.fetchCalculatorMemory();
        }
    }

    private static void updateMemory(String resultOfLeftSide, String rightSideOfExpression, Memory memory) {
        if (rightSideOfExpression.contains("M+")) {
            memory.setValue(memory.getValue() + Double.parseDouble(resultOfLeftSide));
        } else if (rightSideOfExpression.contains("M-")) {
            memory.setValue(memory.getValue() - Double.parseDouble(resultOfLeftSide));
        } else {
            memory.setValue(Double.parseDouble(resultOfLeftSide));
        }
    }
}