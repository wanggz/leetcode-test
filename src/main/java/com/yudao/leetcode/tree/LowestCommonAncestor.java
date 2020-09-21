package com.yudao.leetcode.tree;

import com.yudao.leetcode.tree.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left !=null && right!=null) {
            return root;
        }
        return left != null ? left : right;
    }

    /**
     * 前序遍历
     */
    private static void preorder(
            TreeNode node,
            TreeNode search,
            Stack<TreeNode> path,
            List<TreeNode> result,
            boolean finish){
        if(node == null || finish){
            return;
        }
        path.push(node);
        if(node == search){
            finish = true;
            result = path;
        }
        preorder(node.left,search,path,result,finish);
        preorder(node.right,search,path,result,finish);
        path.pop();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode node_2_1 = new TreeNode(4);
        TreeNode node_2_2 = new TreeNode(8);
        root.left = node_2_1;
        root.right = node_2_2;

        TreeNode node_3_1 = new TreeNode(11);
        node_2_1.left = node_3_1;

        TreeNode node_3_2 = new TreeNode(13);
        TreeNode node_3_3 = new TreeNode(4);
        node_2_2.left = node_3_2;
        node_2_2.right = node_3_3;

        TreeNode node_4_1 = new TreeNode(7);
        TreeNode node_4_2 = new TreeNode(2);
        node_3_1.left = node_4_1;
        node_3_1.right = node_4_2;

        TreeNode node_4_3 = new TreeNode(5);
        TreeNode node_4_4 = new TreeNode(1);
        node_3_2.left = node_4_3;
        node_3_3.right = node_4_4;


        System.out.println(lowestCommonAncestor(root,node_4_3,node_3_2).val);


        TreeNode.recursivePreOrder(root);
        System.out.println();
        TreeNode.recursiveInOrder(root);
        System.out.println();
        TreeNode.recursivePostOrder(root);
        System.out.println();

    }
}
