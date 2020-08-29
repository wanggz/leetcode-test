package com.yudao.leetcode.list;

import com.yudao.leetcode.list.entry.ListNode;

/**
 * 给定单链表的头结点 head，
 * 实现一个调整链表的函数，从链表尾部开始，
 * 以 K 个结点为一组进行逆序翻转，头部剩余结点不足一组时，不需要翻转。
 * （不能使用队列或者栈作为辅助）  leetcode 25
 */
public class ListReverseByK {

    public static void main(String[] args) {

        ListReverseByK listReverse = new ListReverseByK();

        ListNode.printListNode(listReverse.reverseList(ListNode.buildListNode(new int[]{5,6,4})));

    }

    private int linkedLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }


    public ListNode reverseKGroupPlus(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        // 计算原始链表长度
        int length = linkedLength(head);
        if (length < k)
            return head;
        // 计算 offset
        int offsetIndex = length % k;
        // 原始链表正好可以由 K 分位 N 组，可直接处理
        if (offsetIndex == 0) {
            return reverseKGroup(head, k);
        }

        // 定义并找到 prev 和 offset
        ListNode prev = head, offset = head;
        while (offsetIndex > 0) {
            prev = offset;
            offset = offset.next;
            offsetIndex--;
        }

        // 将 offset 结点子链表进行翻转，再拼接回主链表
        prev.next = reverseKGroup(offset, k);
        return head;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        // 增加虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 定义 prev 和 end 结点
        ListNode prev = dummy;
        ListNode end = dummy;
        while(end.next != null) {
            // 以 k 个结点为条件，分组子链表
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            // 不足 K 个时不处理
            if (end == null)
                break;
            // 处理子链表
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            // 翻转子链表
            prev.next = reverseList(start);
            // 将子连表前后串起来
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    // 递归完成单链表翻转
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
