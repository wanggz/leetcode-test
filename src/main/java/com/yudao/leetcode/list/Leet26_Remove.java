package com.yudao.leetcode.list;

import java.util.Arrays;

/**
 * 26. 删除有序数组中的重复项
 */
public class Leet26_Remove {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for(int j = 1; j<nums.length; j++) {
            if(nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {

        int [] nums = new int[]{0,0,1,1,1,2,3,4,4,5};

        System.out.println(Arrays.toString(nums));
        Leet26_Remove r = new Leet26_Remove();
        int l = r.removeDuplicates(nums);
        for(int i=0;i<l;i++)
        {
            System.out.println(nums[i]);
        }
        // System.out.println(Arrays.toString(nums));

    }
}
