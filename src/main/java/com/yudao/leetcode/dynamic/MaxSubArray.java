package com.yudao.leetcode.dynamic;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        MaxSubArray m = new MaxSubArray();
        System.out.println(m.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int [] dq = new int[nums.length+1];
        dq[1] = nums[0];
        int max = nums[0];
        for(int i = 2; i<= nums.length; i++){
            dq[i] = Math.max(dq[i-1]+nums[i-1], nums[i-1]);
            max = Math.max(dq[i],max);
        }
        return max;
    }
}
