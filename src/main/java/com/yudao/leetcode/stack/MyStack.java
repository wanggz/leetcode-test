package com.yudao.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 225. 用队列实现栈
 *
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack {

    Queue<Integer> stack_data;


    public MyStack() {
        stack_data = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> stack_tmp = new LinkedList<>();
        stack_tmp.offer(x);
        while (!stack_data.isEmpty()) {
            stack_tmp.offer(stack_data.poll());
        }
        while (!stack_tmp.isEmpty()){
            stack_data.offer(stack_tmp.poll());
        }
    }

    public int pop() {
        return stack_data.poll();
    }

    public int top() {
        return stack_data.peek();
    }

    public boolean empty() {
        return stack_data.isEmpty();
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();

        obj.push(1);
        obj.push(2);
        obj.push(3);

        for(Integer i : obj.stack_data){
            System.out.println(i);
        }




    }

}
