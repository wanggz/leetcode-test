package com.yudao.leetcode.search;

import com.yudao.leetcode.sort.tools.QuickSort;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 */
public class Makesquare {



    public static void main(String[] args) {
        int [] nums = {1,1,2,4,3,2,3};
        Makesquare m = new Makesquare();
        System.out.println(m.makesquare(nums));
    }

    public boolean makesquare(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(nums.length<=3 || sum%4!=0){
            return false;
        }
        int average = sum / 4;
        //排序
        Arrays.sort(nums);
        int[] enums = new int[4];
        return dfs(nums,nums.length-1,enums,average);
    }

    private boolean dfs(int[] nums,int pos,int[] enums,int average){
        if(pos<0) {
            return enums[0]==average && enums[1]==average && enums[2]==average;
        }
        for (int i=0;i<4;i++) {
            if(enums[i]+nums[pos]>average) {
                continue;
            }
            enums[i]+=nums[pos];
            if(dfs(nums,pos-1,enums,average)) {
                return true;
            }
            enums[i]-=nums[pos];  //回溯
        }
        return false;
    }

}
