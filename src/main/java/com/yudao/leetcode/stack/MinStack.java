package com.yudao.leetcode.stack;

import java.util.Stack;

/**
 * leetcode 155. 最小栈
 */
public class MinStack {

    Stack<Integer> data_stack;
    Stack<Integer> min_stack;

    public MinStack() {
        data_stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        if(min_stack.empty()){
            min_stack.push(x);
        } else {
            int min_val = min_stack.peek();
            if(x < min_val){
                min_stack.push(x);
            } else {
                min_stack.push(min_val);
            }
        }
        data_stack.push(x);
    }

    public void pop() {
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {
        return data_stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      // 返回 0.
        System.out.println(minStack.getMin());   // 返回 -2.


    }

}
