package com.ar50645.dataStructure.stack;

import java.util.Stack;

public class Traverse {

    /**
     * Find if a given number N exists in a stack S.
     */
    public static boolean find(int target, Stack<Integer> s) {

        if(s == null)
            return false;

        Stack<Integer> tempStack = new Stack<>();
        boolean found = false;
        while (!s.isEmpty()) {
            if(s.peek() == target) {
                found = true;
                break;
            }
            tempStack.push(s.pop());
        }

        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }

        return found;
    }
}
