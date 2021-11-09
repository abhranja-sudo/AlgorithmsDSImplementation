package com.ar50645.dataStructure.stack;

import java.util.Stack;

public class Infix {

    // Given an arithmetic expression with *, /, -, + operators and single digit numbers, evaluate it and return the result.
    // No Parenthesis
    public static int evaluate(char[] expression) {
        if(expression == null || expression.length == 0)
            return 0;

        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for(char ch: expression) {

            if(isOperand(ch))
                operandStack.push(ch - '0');

            else if(isOperator(ch)) {
                while (!operatorStack.isEmpty() && precedence(ch) <= operatorStack.peek()) {
                    process(operatorStack, operandStack);
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            process(operatorStack, operandStack);
        }

        return operandStack.pop();
    }

    // With Parenthesis allowed
    public static int evaluateWithBrackets(char[] expression) {
        if(expression == null || expression.length == 0)
            return 0;

        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for(char ch: expression) {
            if(isOperand(ch))
                operandStack.push(ch - '0');
            else if(isOperator(ch)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(ch)) {
                    process(operatorStack, operandStack);
                }
                operatorStack.push(ch);
            }
            else if(ch == '(')
                operatorStack.push(ch);

            else if(ch == ')') {
                while (operatorStack.peek() != '(') {
                    process(operatorStack,operandStack);
                }
                operandStack.pop();
            }
        }

        while (!operandStack.isEmpty()) {
            process(operatorStack, operandStack);
        }

        return operandStack.pop();
    }

    private static void process(Stack<Character> operator, Stack<Integer> operand) {

        int num2 = operand.pop();
        int num1 = operand.pop();

        char op = operator.pop();

        int result = 0;

        switch (op) {
            case '/': result = num1 / num2;
            break;
            case '*': result = num1 * num2;
            break;
            case '+': result = num1 + num2;
            break;
            case '-': result = num1 - num2;
            break;
        }
        operand.push(result);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c =='*' || c=='/';
    }

    private static boolean isOperand(char c) {
        return c >= '0' && c <= '9';
    }

    private static int precedence(char c) {

        if(c == '+' || c == '-')
            return 1;
        else if(c == '*' || c == '/')
            return 2;
        else if(c == '(' || c == ')')
            return 0;

        throw new IllegalArgumentException("Invalid Operator ");
    }
}
