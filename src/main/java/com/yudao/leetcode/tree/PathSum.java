package com.yudao.leetcode.tree;

import com.yudao.leetcode.tree.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root.val == sum && root.left == null && root.right == null){
            List<Integer> arr = new ArrayList<>();
            arr.add(root.val);
            ans.add(arr);
            return ans;
        }
        List<List<Integer>> letf = pathSum(root.left,sum-root.val);
        List<List<Integer>> right = pathSum(root.right,sum-root.val);
        for(List<Integer> node : letf){
            node.add(0,root.val);
            ans.add(node);
        }
        for(List<Integer> node : right){
            node.add(0,root.val);
            ans.add(node);
        }
        return ans;
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
        node_3_3.left = node_4_3;
        node_3_3.right = node_4_4;

        System.out.println(PathSum.pathSum(root,22));
    }

}
