package com.yudao.leetcode.tree.entry;

/**
 * 二叉树
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }

    //**********递归的先序遍历**********
    public static void recursivePreOrder(TreeNode p) {
        if (p == null) return;
        visit(p);
        recursivePreOrder(p.left);
        recursivePreOrder(p.right);
    }

    //**********递归的中序遍历**********
    public static void recursiveInOrder(TreeNode p) {
        if (p == null) return;
        recursiveInOrder(p.left);
        visit(p);
        recursiveInOrder(p.right);
    }

    //**********递归的后序遍历**********
    public static void recursivePostOrder(TreeNode p) {
        if (p == null) return;
        recursivePostOrder(p.left);
        recursivePostOrder(p.right);
        visit(p);
    }

    public static void visit(TreeNode p) {
        System.out.print(p.val + " ");
    }



}
