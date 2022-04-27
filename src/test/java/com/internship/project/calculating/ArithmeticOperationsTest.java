package com.internship.project.calculating;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    @DisplayName("Checking for correctly done addition!")
    void givenExpressionWithAddition_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        int firstOperand = 3;
        int secondOperand = 2;
        String operator = "+";
        String expectedResult = "5";

        String actualResult = calculator.apply(firstOperand, secondOperand, operator);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done subtraction!")
    void givenExpressionWithSubtraction_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        int firstOperand = 3;
        int secondOperand = 2;
        String operator = "-";
        String expectedResult = "1";

        String actualResult = calculator.apply(firstOperand, secondOperand, operator);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done multiplication!")
    void givenExpressionWithMultiplication_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        int firstOperand = 3;
        int secondOperand = 2;
        String operator = "*";
        String expectedResult = "6";

        String actualResult = calculator.apply(firstOperand, secondOperand, operator);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done division!")
    void givenExpressionWithDivision_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        int firstOperand = 6;
        int secondOperand = 2;
        String operator = "/";
        String expectedResult = "3.0";

        String actualResult = calculator.apply(firstOperand, secondOperand, operator);

        assertEquals(expectedResult, actualResult);

    }
}