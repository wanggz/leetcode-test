package com.yudao.leetcode.sort.tools;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {

        int [] a =  new int []{-4,-2,-8};

        sort(a,0,a.length-1,false);

        for(int i = 0; i< a.length; i++){
            System.out.print(a[i] + " ");
        }

    }

    /**
     * 逆序
     */
    public static void sort(int [] A, int left, int right, boolean order){
        int i,j,t,temp;
        if (left > right)
            return;

        temp = A[left];
        i=left;
        j=right;
        while(i!=j){
            if(order == true) {
                while (A[j] >= temp && i < j) {
                    j--;
                }
                while (A[i] <= temp && i < j) {
                    i++;
                }
            } else{
                while (A[j] <= temp && i < j) {
                    j--;
                }
                while (A[i] >= temp && i < j) {
                    i++;
                }
            }
            if(i < j){
                t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        A[left] = A[i];
        A[i] = temp;

        sort(A,left,i-1, order);
        sort(A,i+1,right, order);

        return;
    }

}
