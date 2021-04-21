package com.yudao.leetcode.list;

/**
 * leetcode 42 接水滴
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 */
public class Leet42_Trap {

    /**
     * 方法1 按行求
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     */
    public int trap1(int [] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        for(int i = 0; i < height.length; i++){
            max = Math.max(height[i],max);
        }
        int sum = 0;
        for(int i = 1; i <= max; i++){
            boolean isStart = false;
            int temp = 0;
            for(int j = 0; j < height.length; j++){
                if(isStart && height[j] < i){
                    temp++;
                }
                if(height[j]>=i){
                    sum = sum + temp;
                    temp = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    /**
     * 方法2 按列求
     * 时间复杂度：
     * 空间复杂度：
     */
    public int trap2(int [] height){

        return 0;
    }


    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int [] result = new int[height.length];
        int sum = 0;
        int i = 0;
        for(int j = 1; j < height.length; j++) {
            if(height[j] >= height[i]){
                // i 和 j 中间的元素
                int min = Math.min(height[i],height[j]);
                for(int h = i+1;h < j; h++) {
                    sum += min - height[h];
                }
                i = j;
            } else {


            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int [] height = new int[] {0,1,0,2,3,0,2,3};

        Leet42_Trap l = new Leet42_Trap();

        System.out.println(l.trap1(height));

    }
}
