package com.yudao.one;

import com.yudao.one.entry.ListNode;

/**
 * 链表加法运算   leetcode 2
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)  两个已知链表对象ListNode l1, ListNode l2
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class ListNodeAdd {

    public static void main(String[] args) {

        ListNodeAdd method = new ListNodeAdd();
        ListNode l1 = ListNode.buildListNode(new int[]{2,4,3});
        ListNode l2 = ListNode.buildListNode(new int[]{5,6,4});
        ListNode result = method.addTwoNumbers(l1,l2);

        ListNode.printListNode(result);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p=l1, q=l2, curr = dummyHead;
        int carry = 0;

        while (p != null || q != null){

            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;


            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

}
