package com.internship.project.calculating;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RpnCalculator {
    public Queue<String> calculate(Queue<String> rpnQueue) {
        Queue<String> results = new LinkedList<>();

        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        Stack<String> stack = new Stack<>();
        int firstOperand, secondOperand;
        String operator;
        while (rpnQueue.peek() != null) {
            String token = rpnQueue.remove();
            if ("=".equals(token)) {
                results.add(stack.pop());
                continue;
            } else if (!"+-*/".contains(token)) {
                stack.push(token);
                continue;
            } else {
                operator = token;
            }

            firstOperand = Integer.parseInt(stack.pop());
            secondOperand = Integer.parseInt(stack.pop());
            String result = arithmeticOperations.apply(secondOperand, firstOperand, operator);
            stack.push(result);
        }

        return results;
    }
}
