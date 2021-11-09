package com.ar50645.dataStructure.stack;

import java.util.Stack;

public class StackWithMax {
    Stack<Integer> main;
    Stack<Integer> max;

    public StackWithMax() {
        main = new Stack<>();
        max = new Stack<>();
    }

    public void push(int num) {
        main.push(num);
        if(max.isEmpty() || max.peek() <= num) {
            max.push(num);
        }
    }

    public int pop() {
        if(main.isEmpty()) {
            throw new RuntimeException("underflow");
        }
        if(max.peek() == main.peek()) {
            max.pop();
        }
        return main.pop();
    }

    public int getMax() {
        if(max.isEmpty())
            throw new RuntimeException("underflow");
        return max.peek();
    }
}
