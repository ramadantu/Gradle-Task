package com.internship.project.calculating;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RpnCalculatorTest {

    @Test
    @DisplayName("Checking for correctly done RPN calculation!")
    void givenExpressionInRPN_whenCallCalculateMethod_thenSuccess() {

        RpnCalculator calculator = new RpnCalculator();
        Queue<String> rpnQueue = new LinkedList<>();
        Collections.addAll(rpnQueue,"45,34,-,2,*,6,+,7,/,=".split(","));
        Queue<String> expectedResult = new LinkedList<>();
        expectedResult.add("4.0");

        Queue<String> actualResult = calculator.apply(rpnQueue);

        assertEquals(expectedResult, actualResult);

    }

}