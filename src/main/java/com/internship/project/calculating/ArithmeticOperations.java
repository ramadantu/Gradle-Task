package com.internship.project.calculating;

import net.objecthunter.exp4j.*;

public class ArithmeticOperations {

    public String apply(String mathExpression, String variableName, String variableValue) {

        Expression expression;

        if (variableName != null && variableValue != null) {
            expression = new ExpressionBuilder(mathExpression)
                    .variable(variableName)
                    .build()
                    .setVariable(variableName, Integer.parseInt(variableValue));
        } else {
            expression = new ExpressionBuilder(mathExpression).build();
        }
        double result = expression.evaluate();
        return result + "";

    }
}
