package com.yudao.one;

import com.yudao.one.entry.ListNode;

/**
 * 给定单链表的头结点 head，
 * 实现一个调整链表的函数，从链表尾部开始，
 * 以 K 个结点为一组进行逆序翻转，头部剩余结点不足一组时，不需要翻转。
 * （不能使用队列或者栈作为辅助）
 */
public class ListReverse {

    public static void main(String[] args) {


    }


    public ListNode reverseKGroupPlus(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        // 计算原始链表长度
/*        int length = linkedLength(head);
        if (length < k)  return head;  // 计算 offset
        int offsetIndex = length % k;  // 原始链表正好可以由 K 分位 N 组，可直接处理
        if (offsetIndex == 0) {
            return reverseKGroup(head, k);
        }   // 定义并找到 prev 和 offset
        ListNode prev = head, offset = head;
        while (offsetIndex > 0) {
            prev = offset;
            offset = offset.next;
            offsetIndex--;
        }   // 将 offset 结点子链表进行翻转，再拼接回主链表
        prev.next = reverseKGroup(offset, k);
        return head;*/
        return null;
    }
}
