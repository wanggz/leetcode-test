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

        ListNode list = ListNode.buildListNode(new int[]{1,2,3,4,5});

        ListNode.printListNode(solution2(list));
    }

    /**
     * 迭代
     */
    public static ListNode solution2(ListNode head){
        ListNode oldHead = head, newHead = null, tmp;
        while (oldHead !=null) {
            tmp = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = tmp;
        }
        return newHead;
    }

}
