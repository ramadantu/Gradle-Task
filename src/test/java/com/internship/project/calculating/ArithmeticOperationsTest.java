package com.internship.project.calculating;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    @DisplayName("Checking for correctly done addition!")
    void givenExpressionWithAddition_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "5.0";

        String actualResult = calculator.apply("3+2");

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done subtraction!")
    void givenExpressionWithSubtraction_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "1.0";

        String actualResult = calculator.apply("3-2");

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done multiplication!")
    void givenExpressionWithMultiplication_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "6.0";

        String actualResult = calculator.apply("3*2");

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done division!")
    void givenExpressionWithDivision_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "3.0";

        String actualResult = calculator.apply("6/2");

        assertEquals(expectedResult, actualResult);

    }
}