package com.practice.algorith;

import java.util.Stack;

public class MaxStack {

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println(String.format("min: %s, max: %s", stack.getMin(), stack.getMax()));
        stack.pop();
        System.out.println(String.format("min: %s, max: %s", stack.getMin(), stack.getMax()));
        stack.pop();
        System.out.println(String.format("min: %s, max: %s", stack.getMin(), stack.getMax()));
        stack.pop();
        System.out.println(String.format("min: %s, max: %s", stack.getMin(), stack.getMax()));
        stack.pop();
        System.out.println(String.format("min: %s, max: %s", stack.getMin(), stack.getMax()));
    }

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> maxStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(Integer i) {
        stack.push(i);
        if (maxStack.empty() || maxStack.peek() < i) {
            maxStack.push(i);
        }
        if (minStack.empty() || minStack.peek() > i) {
            minStack.push(i);
        }
    }

    public int pop() {
        if (stack.empty()) {
            System.out.println("stack is null");
        }
        int popValue = stack.pop();
        if (popValue == minStack.peek()) {
            minStack.pop();
        }
        if (popValue == maxStack.peek()) {
            maxStack.pop();
        }
        return popValue;
    }

    public int getMin() {
        if (minStack.empty())
            System.out.println("minStack is empty");
        return minStack.peek();
    }

    public int getMax() {
        if (maxStack.empty())
            System.out.println("maxStack is empty");
        return maxStack.peek();
    }
}
