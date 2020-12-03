package com.yudao.leetcode.dynamic;

/**
 * 70. 爬楼梯
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 思路
 * 到达第i阶的方式数量 = 到达第i-1阶的方式数量 + 到达第i-2阶的方式数量
 */
public class ClimbStairs {

    public static void main(String[] args) {

        ClimbStairs c = new ClimbStairs();
        System.out.println(c.climbStairs(1));

    }

    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int [] step = new int[n+1];
        step[1] = 1;
        step[2] = 2;
        for(int i = 3; i<= n; i++){
            step[i] = step[i-2] + step[i-1];
        }
        return step[n];
    }

}
