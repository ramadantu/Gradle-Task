package com.internship.project.calculating;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    @DisplayName("Checking for correctly done addition!")
    void givenExpressionWithAddition_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "5.0";

        String actualResult = calculator.apply("3+2", null, null);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done subtraction!")
    void givenExpressionWithSubtraction_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "1.0";

        String actualResult = calculator.apply("3-2", null, null);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done multiplication!")
    void givenExpressionWithMultiplication_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "6.0";

        String actualResult = calculator.apply("3*2", null, null);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done division!")
    void givenExpressionWithDivision_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "3.0";

        String actualResult = calculator.apply("6/2", null, null);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done addition with a variable!")
    void givenExpressionWithAdditionAndVariable_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "5.0";
        String variableName = "x";
        String variableValue = "2";

        String actualResult = calculator.apply("3+x", variableName, variableValue);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done subtraction with a variable!")
    void givenExpressionWithSubtractionAndVariable_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "1.0";
        String variableName = "x";
        String variableValue = "2";

        String actualResult = calculator.apply("3-x", variableName, variableValue);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done multiplication with a variable!")
    void givenExpressionWithMultiplicationAndVariable_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "6.0";
        String variableName = "x";
        String variableValue = "2";

        String actualResult = calculator.apply("3*x", variableName, variableValue);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done division with a variable!")
    void givenExpressionWithDivisionAndVariable_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        String expectedResult = "3.0";
        String variableName = "x";
        String variableValue = "2";

        String actualResult = calculator.apply("6/x", variableName, variableValue);

        assertEquals(expectedResult, actualResult);

    }
}