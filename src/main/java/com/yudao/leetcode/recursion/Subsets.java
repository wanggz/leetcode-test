package com.yudao.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return results;
        }
        process(nums,0,results,result);
        return results;
    }

    public static void process(int[]nums, int j,List<List<Integer>> results,List<Integer> result){
        results.add(new ArrayList<>(result));
        for(int i=j;i<nums.length;i++){
            result.add(nums[i]);
            System.out.println(result);
            process(nums,i+1,results,result);
            result.remove(result.size()-1);
        }
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int size = 1<<nums.length;
        for(int i = 0; i < size; i++){
            List<Integer> result = new ArrayList<>();
            for(int j = 0; j < nums.length; j++){
                if((i & (1<<j)) > 0){
                    result.add(nums[j]);
                }
            }
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(Subsets.subsets2(new int [] {1,2,3}));
    }

}
