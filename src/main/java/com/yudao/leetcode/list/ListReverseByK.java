package com.yudao.leetcode.list;

import com.yudao.leetcode.list.entry.ListNode;

/**
 * LeetCode 25-k个一组翻转链表
 * 题目：
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * ???
 */
public class ListReverseByK {

    public static void main(String[] args) {

        ListNode.printListNode(ListReverseByK.reverseKGroup2(ListNode.buildListNode(new int[]{1,2,3,4,5}), 2));

    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        int len=0;
        ListNode tmp=head;
        //计算链表长度
        while(tmp!=null){
            len++;
            tmp=tmp.next;
        }
        len/=k;
        //当没有要反转链表的时候直接返回
        if(len==0)
            return head;
        ListNode cur=head;
        ListNode tail=cur;
        for(int i=0;i<len;i++){
            //newlist表示分离出来的链表
            ListNode newlist=null;
            //newhead表示分离出来链表的头
            ListNode newhead=cur;
            int count=k;
            //反转分离出来的链表
            while(count>0){
                tmp=cur;
                cur=cur.next;
                tmp.next=newlist;
                newlist=tmp;
                count--;
            }
            //只有当第一次反转链表时不用将首尾相连，因为只有头，所以只需要将链表原本的头
            //更新即可，在后面的链表反转中，则需要将分离出来的链表与之前的链表首尾相连
            if(i==0){
                head=newlist;
            }else{
                tail.next=newlist;
                tail=newhead;
            }
        }
        //链接链表剩余的部分
        while(cur!=null){
            tail.next=cur;
            tail=tail.next;
            cur=cur.next;
        }
        //返回头节点
        return head;
    }

    public static ListNode reverseKGroupPlus(ListNode head, int k) {
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

    private static int linkedLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
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
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
