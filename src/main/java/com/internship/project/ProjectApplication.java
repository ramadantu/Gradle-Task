package com.internship.project;

import com.internship.project.calculating.ArithmeticOperations;

import java.util.Scanner;

public class ProjectApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArithmeticOperations calculator = new ArithmeticOperations();
        String inputExpression = scanner.nextLine();
        String mathExpression = inputExpression.substring(0, inputExpression.indexOf("="));
        String result = calculator.apply(mathExpression);
        System.out.println(inputExpression.replace("?", result));

    }
}