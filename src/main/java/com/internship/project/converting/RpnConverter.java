package com.internship.project.converting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RpnConverter {
    public Queue<String> convert(Queue<String> inputQueue) {
        Queue<String> reversePolishNotationQueue = new LinkedList<>();
        Stack<String> operators = new Stack<>();

        while (inputQueue.peek() != null) {
            String token = inputQueue.remove();
            if ("*/+-".contains(token)) {
                if (!operators.empty()) {
                    if ("*/".contains(operators.peek())) {
                        while (!operators.empty()) {
                            reversePolishNotationQueue.add(operators.pop());
                        }
                        operators.push(token);
                    } else {
                        reversePolishNotationQueue.add(operators.pop());
                        operators.push(token);
                    }
                } else {
                    operators.push(token);
                }
            } else if (token.equals("=")) {
                while (!operators.empty()) {
                    reversePolishNotationQueue.add(operators.pop());
                }
                reversePolishNotationQueue.add(token);
            } else {
                reversePolishNotationQueue.add(token);
            }
        }

        return reversePolishNotationQueue;
    }
}
