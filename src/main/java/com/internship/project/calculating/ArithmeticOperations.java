package com.internship.project.calculating;

import net.objecthunter.exp4j.*;

public class ArithmeticOperations {

    public String apply(String mathExpression) {

        Expression expression = new ExpressionBuilder(mathExpression).build();
        double result = expression.evaluate();
        return result + "";

    }
}
