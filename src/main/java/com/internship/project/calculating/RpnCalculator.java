package com.internship.project.calculating;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

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
            Expression expression = new ExpressionBuilder(firstOperand + operator + secondOperand).build();
            String result = arithmeticOperations.evaluate(expression);
            stack.push(result);
        }

        return results;
    }
}
