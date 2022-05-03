package com.internship.project;

import com.internship.project.calculating.ArithmeticOperations;

import java.io.*;
import java.util.Objects;


public class ProjectApplication {
    public static void main(String[] args) throws IOException {

        File outputFile = new File("/src/main/resources/output.txt");
        FileWriter fileWriter = new FileWriter(outputFile);

        try (InputStream input = ProjectApplication.class.getResourceAsStream("/input.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(input)));
             fileWriter; BufferedWriter writer = new BufferedWriter(fileWriter)) {

            ArithmeticOperations calculator = new ArithmeticOperations();
            String currentLine;
            String mathExpression;
            String result;

            while ((currentLine = reader.readLine()) != null) {

                mathExpression = currentLine.substring(0, currentLine.indexOf("="));
                result = calculator.apply(mathExpression);
                writer.append(currentLine.replace("?", result + "\n"));

            }

        }

    }
}