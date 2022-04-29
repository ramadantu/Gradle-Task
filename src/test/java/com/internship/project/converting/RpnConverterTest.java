package com.internship.project.converting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class RpnConverterTest {

    @Test
    @DisplayName("Checking for correctly RPN converting!")
    void givenExpressionInInfixNotation_whenCallConvertMethod_thenSuccess() {

        RpnConverter converter = new RpnConverter();
        Queue<String> inputQueue = new LinkedList<>();
        Collections.addAll(inputQueue,"45,-,34,*,2,+,6,/,7,=".split(","));
        Queue<String> expectedQueue = new LinkedList<>();
        Collections.addAll(expectedQueue,"45,34,-,2,*,6,+,7,/,=".split(","));

        Queue<String> actualQueue = converter.convert(inputQueue);

        assertEquals(expectedQueue, actualQueue);

    }

}