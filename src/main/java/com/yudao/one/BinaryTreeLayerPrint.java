package com.yudao.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树分层打印
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 *  output:
 *  3
 *  9,20
 *  15,7
 * Created by guangzhi.wang on 2020/1/15/015.
 */
public class BinaryTreeLayerPrint {

    public static void main(String[] args) {

        TreeNode root =  new TreeNode(3);
        TreeNode r_9 =  new TreeNode(9);
        TreeNode r_20 =  new TreeNode(20);
        TreeNode r_15 =  new TreeNode(15);
        TreeNode r_7 =  new TreeNode(7);

        r_20.left = r_15;
        r_20.right = r_7;
        root.left = r_9;
        root.right = r_20;

        List<List<Integer>> res=new ArrayList();

        if(root==null){}                                //边界条件

        Queue<TreeNode> q= new LinkedList<>();             //创建的队列用来存放结点，泛型注意是TreeNode
        q.add(root);
        while(!q.isEmpty()){                        //队列为空说明已经遍历完所有元素，while语句用于循环每一个层次
            int count=q.size();
            List<Integer> list=new ArrayList();
            while(count>0){                             //遍历当前层次的每一个结点，每一层次的Count代表了当前层次的结点数目
                TreeNode temp=q.peek();
                q.poll();                                        //遍历的每一个结点都需要将其弹出
                list.add(temp.val);
                if(temp.left!=null)q.add(temp.left);      //迭代操作，向左探索
                if(temp.right!=null)q.add(temp.right);
                count--;
            }
            res.add(list);
        }


        for(List<Integer> i : res){
            for(Integer ii : i){
                System.out.print(ii + " ");
            }
            System.out.println();
        }

    }

}
