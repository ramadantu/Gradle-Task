package com.internship.project.calculating;

import net.objecthunter.exp4j.Expression;

public class ArithmeticOperations {

    public String evaluate(Expression expression) {

        double result = expression.evaluate();
        return result + "";

    }
}
