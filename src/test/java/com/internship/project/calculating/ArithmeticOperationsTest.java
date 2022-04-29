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
        Expression expression = new ExpressionBuilder("3+2").build();
        String expectedResult = "5";

        String actualResult = calculator.evaluate(expression);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done subtraction!")
    void givenExpressionWithSubtraction_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        Expression expression = new ExpressionBuilder("3-2").build();
        String expectedResult = "1";

        String actualResult = calculator.evaluate(expression);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done multiplication!")
    void givenExpressionWithMultiplication_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        Expression expression = new ExpressionBuilder("3*2").build();
        String expectedResult = "6";

        String actualResult = calculator.evaluate(expression);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Checking for correctly done division!")
    void givenExpressionWithDivision_whenCallCalculatorApplyMethod_thenSuccess() {

        ArithmeticOperations calculator = new ArithmeticOperations();
        Expression expression = new ExpressionBuilder("6/2").build();
        String expectedResult = "3.0";

        String actualResult = calculator.evaluate(expression);

        assertEquals(expectedResult, actualResult);

    }
}