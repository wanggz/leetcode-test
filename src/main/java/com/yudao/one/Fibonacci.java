package com.yudao.one;

/**
 * 打印斐波那契数列
 *
 */
public class Fibonacci {

    public static void main(String[] args) {

        for(int i = 1; i <= 10; i++){
            System.out.print(fib(i) + "\t");
        }
        System.out.println();
        for(int i = 1; i <= 10; i++){
            System.out.print(fib2(i) + "\t");
        }
    }

    // 递归
    public static int fib(int num) {
        if(num == 1 || num == 2) {
            return 1;
        } else {
            return fib(num-1) + fib(num-2);
        }
    }

    //非递归
    public static int fib2(int num){
        if(num ==1 || num == 2){
            return 1;
        }
        int [] arr = new int[num];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i< num; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[num-1];
    }

}
