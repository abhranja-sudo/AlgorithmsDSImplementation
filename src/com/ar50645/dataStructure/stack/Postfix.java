package com.ar50645.dataStructure.stack;

import java.util.Stack;

/**
 * LeetCode problem:  https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Steps to solve the postfix expression:
 *      1. Iterate through the expression,
 *
 *      2.  If it's an operand, put it in the stack, and
 *
 *      3.  if it's  an operator, pop two top elements from stack and push the result of operand operator operand to the stack
 *
 *      4.  return the last remaining element in stack.
 */
public class Postfix {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String i: tokens) {
            if(isOperator(i)) {

                int a = stack.pop();
                int b = stack.pop();

                stack.push(process(b, a, i));

            } else {
                stack.push(Integer.parseInt(i));

            }
        }

        return stack.pop();
    }

    private boolean isOperator(String s) {

        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));

    }

    private int process(int a, int b, String operator) {

        if(operator.equals("+")) {
            return a + b;
        }

        if(operator.equals("-")) {
            return a - b;
        }

        if(operator.equals("*")) {
            return a * b;
        }

        if(operator.equals("/")) {
            return a / b;
        }

        return 0;
    }
}
