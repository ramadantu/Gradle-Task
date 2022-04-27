package com.internship.project.calculating;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RpnCalculatorTest {

    @Test
    @DisplayName("Checking for correctly done RPN calculation!")
    void givenExpressionInRPN_whenCallCalculateMethod_thenSuccess() {

        RpnCalculator calculator = new RpnCalculator();
        Queue<String> rpnQueue = new LinkedList<>();
        rpnQueue.add("45");
        rpnQueue.add("34");
        rpnQueue.add("-");
        rpnQueue.add("2");
        rpnQueue.add("*");
        rpnQueue.add("6");
        rpnQueue.add("+");
        rpnQueue.add("7");
        rpnQueue.add("/");
        rpnQueue.add("=");
        Queue<String> expectedResult = new LinkedList<>();
        expectedResult.add("4.0");

        Queue<String> actualResult = calculator.calculate(rpnQueue);

        assertEquals(expectedResult, actualResult);

    }

}