package com.yudao.leetcode.list.entry;

public class ListNode {
    public int val;
    public ListNode next;   // 下一个链表对象
    public ListNode(int x) { val = x; }  //赋值链表的值


    public static ListNode buildListNode(int[] input){
        ListNode first = null,last = null,newNode;
        int num;
        if(input.length>0){
            for(int i=0;i<input.length;i++){
                newNode=new ListNode(input[i]);
                newNode.next=null;
                if(first==null){
                    first=newNode;
                    last=newNode;
                }
                else{
                    last.next=newNode;
                    last=newNode;
                }

            }
        }
        return first;
    }

    public static void printListNode(ListNode listNode){
        ListNode tagrget = listNode;
        StringBuffer sb = new StringBuffer();
        while (tagrget != null){
            sb.append(tagrget.val).append(" -> ");

            tagrget = tagrget.next;

        }

        System.out.println(sb.toString().substring(0,sb.toString().length()-4));
    }

}
