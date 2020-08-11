package com.yudao.one;

/**
 * 根号N求解
 *
 * 牛顿法
 * 二分法
 *
 */
public class SquareN {

    public static void main(String[] args) {

        System.out.println(sqrt_dichotomy(0.04));

        //System.out.println(Math.sqrt(0.5));

    }

    //二分法
    public static double sqrt_dichotomy(double n) {
        double min = Math.min(1,n);
        double max = Math.max(1,n);

        double result = (min + max) / 2;
        while(true){
            if(result * result == n){
                break;
            }
            if(result * result > n){
                result = (result + min) / 2;
            } else {
                result = (result + max) / 2;
            }
        }
        return result;
    }

    // 牛顿法
    public static double sqrt_nerton(double n){


        return 0;
    }

}
