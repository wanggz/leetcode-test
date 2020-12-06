package com.yudao.leetcode.dynamic;

/**
 * 322. 零钱兑换
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class Leet322_CoinChange {

    public static void main(String[] args) {
        int [] coins = new int[]{1,2,5,10};
        int amount = 14;

        Leet322_CoinChange c = new Leet322_CoinChange();
        System.out.println(c.coinChange(coins,amount));
    }

    public int coinChange(int[] coins, int amount) {
        int [] dq = new int [amount+1];
        dq[0] = 0;
        for(int i = 1; i <= amount; i++){
            dq[i] = -1;
        }
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j< coins.length; j++){
                if(i - coins[j] >= 0 && dq[i - coins[j]] != -1) {
                    if(dq[i] == -1 || dq[i] > dq[i-coins[j]] + 1) {
                        dq[i] = dq[i-coins[j]] + 1;
                    }
                }
            }
        }
        return dq[amount];
    }
}
