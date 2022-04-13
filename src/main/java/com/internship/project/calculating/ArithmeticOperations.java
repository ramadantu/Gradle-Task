package com.internship.project.calculating;

public class ArithmeticOperations {

    public enum Operation {
        ADDITION {
            @Override
            public String calculate(int firstOperand, int secondOperand) {
                return (firstOperand + secondOperand) + "";
            }
        },
        SUBTRACTION {
            @Override
            public String calculate(int firstOperand, int secondOperand) {
                return (firstOperand - secondOperand) + "";
            }
        },
        MULTIPLICATION {
            @Override
            public String calculate(int firstOperand, int secondOperand) {
                return (firstOperand * secondOperand) + "";
            }
        },
        DIVISION {
            @Override
            public String calculate(int firstOperand, int secondOperand) {
                return ((double) firstOperand / (double) secondOperand) + "";
            }
        };

        public String calculate(int firstOperand, int secondOperand) {
            return "";
        }
    }

    public String apply(int firstOperand, int secondOperand, String operator) {

        switch (operator) {
            case "+" -> {
                return Operation.ADDITION.calculate(firstOperand, secondOperand);
            }
            case "-" -> {
                return Operation.SUBTRACTION.calculate(firstOperand, secondOperand);
            }
            case "*" -> {
                return Operation.MULTIPLICATION.calculate(firstOperand, secondOperand);
            }
            case "/" -> {
                return Operation.DIVISION.calculate(firstOperand, secondOperand);
            }
            default -> {
                return "Choose a valid operator! \n";
            }
        }

    }
}
