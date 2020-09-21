package com.yudao.leetcode.find;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int low = 0, high = nums.length - 1;
        int index = -1;
        while (index == -1) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                index = mid;
            } else if (nums[mid] > target) {
                if (mid == 0 || target > nums[mid - 1]) {
                    index = mid;
                }
                high = mid - 1;
            } else {
                if (mid == nums.length - 1 ||  target < nums[mid + 1]) {
                    index = mid + 1;
                }
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        System.out.println(SearchInsert.searchInsert(new int [] {1,3,5,7,8,10},0));
    }

}
