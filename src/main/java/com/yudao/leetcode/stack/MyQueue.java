package com.yudao.leetcode.stack;

import java.util.Stack;

/**
 *  leetcode 232. 用栈实现队列
 */
public class MyQueue {

    Stack<Integer> data_stack;

    public MyQueue() {
        data_stack = new Stack<>();
    }


    public void push(int x) {
        Stack<Integer> tmp_stack = new Stack<>();
        tmp_stack.push(x);
        while (!data_stack.empty()){
            tmp_stack.push(data_stack.pop());
        }
        while (!tmp_stack.empty()){
            data_stack.push(tmp_stack.pop());
        }

    }
    public int pop() {
        return data_stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return data_stack.peek();
    }

    public boolean empty() {
        return data_stack.empty();
    }


    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        for(Integer i : queue.data_stack){
            System.out.println(i);
        }

    }
}
