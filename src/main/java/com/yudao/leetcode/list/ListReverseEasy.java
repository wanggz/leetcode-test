package com.yudao.leetcode.list;

import com.yudao.leetcode.list.entry.ListNode;

/**
 * LeetCode 206-反转链表
 * 题目：
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ListReverseEasy {

    public static void main(String[] args) {

        ListNode list = ListNode.buildListNode(new int[]{1,2,3});

        ListNode.printListNode(reverseList(list));
    }

    /**
     * 迭代法
     *
     * 思路：
     * tmp缓存oldhead后面的链表，将新链表追加到就旧链表的当前节点后面，并将追加后的值赋值给新链表，最后将oldhead指向tmp。
     */
    public static ListNode solution(ListNode head){
        ListNode oldHead = head, newHead = null, tmp;
        while (oldHead !=null) {
            tmp = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = tmp;
        }
        return newHead;
    }

    /**
     * 递归完成单链表翻转
     *
     * 思路：
     * 递归终止条件：head本身为null 或者 head是最后一个节点
     * 若head为最后一个节点，则head的
     *
     * 以 1 -> 2 -> 3 为例子：
     *
     * p = 3 (head.next)，当前的 head = 2 -> 3
     * head.next.next = head -> 2 -> 3 -> 2 -> 3 -> ... ; p -> 3 -> 2 -> 3 -> 2 -> 3 -> ...
     *      p
     *      |
     * 2 -> 3 -> 2 -> 3 -> 2 ->3 ...
     * |         |         |
     * head      head      head
     *
     * head.next = null head -> 2 , p -> 3 -> 2
     * 2
     * |
     * head
     *
     * p
     * |
     * 3 -> 2
     *      |
     *      head
     * 上一层递归 head -> 1 -> 2 , 执行 head.next.next = head; head -> 1 -> 2 -> 1 -> 2 -> ... ; p -> 3 -> 2 -> 1 -> 2 -> 1 -> 2 -> ...
     *      p
     *      |
     *      3
     *      |
     * 1 -> 2 -> 1 -> 2 ...
     * |         |
     * head      head
     * head.next =null; head -> 1 ; p -> 3 -> 2 -> 1; 结束循环return
     * p
     * |
     * 3
     * |
     * 2 -> 1
     *      |
     *      head
     */
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
