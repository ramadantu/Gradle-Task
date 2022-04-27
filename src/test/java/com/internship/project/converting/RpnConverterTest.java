package com.internship.project.converting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RpnConverterTest {

    @Test
    @DisplayName("Checking for correctly RPN converting!")
    void givenExpressionInInfixNotation_whenCallConvertMethod_thenSuccess() {

        RpnConverter converter = new RpnConverter();
        Queue<String> inputQueue = new LinkedList<>();
        inputQueue.add("45");
        inputQueue.add("-");
        inputQueue.add("34");
        inputQueue.add("*");
        inputQueue.add("2");
        inputQueue.add("+");
        inputQueue.add("6");
        inputQueue.add("/");
        inputQueue.add("7");
        inputQueue.add("=");
        Queue<String> expectedQueue = new LinkedList<>();
        expectedQueue.add("45");
        expectedQueue.add("34");
        expectedQueue.add("-");
        expectedQueue.add("2");
        expectedQueue.add("*");
        expectedQueue.add("6");
        expectedQueue.add("+");
        expectedQueue.add("7");
        expectedQueue.add("/");
        expectedQueue.add("=");

        Queue<String> actualQueue = converter.convert(inputQueue);

        assertEquals(expectedQueue, actualQueue);

    }

}