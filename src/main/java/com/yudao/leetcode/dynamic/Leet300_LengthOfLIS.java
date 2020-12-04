package com.yudao.leetcode.dynamic;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Leet300_LengthOfLIS {

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,2,3,1,4};

        Leet300_LengthOfLIS l = new Leet300_LengthOfLIS();
        System.out.println(l.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int [] dq = new int[nums.length];
        for(int i = 0; i < dq.length; i++){
            dq[i] = 1;
        }
        int result = 1;
        for(int i = 0; i< nums.length; i++){
            for(int j = 0; j<= i; j++){
                if(nums[i] > nums[j]) {
                    dq[i] = Math.max(dq[i],dq[j]+1);
                }
                if(dq[i] > result) {
                    result = dq[i];
                }
            }
        }
        return result;
    }
}
