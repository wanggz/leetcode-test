package com.yudao.one;

/**
 * 回型打印
 * input:
 *  1  2  3 4
 * 12 13 14 5
 * 11 16 15 6
 * 10 9  8  7
 * output:
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * Created by guangzhi.wang on 2020/1/15/015.
 */
public class RoundPrint {

    public static void main(String[] args) {
        //初始化数据
        int [][] arr = new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        int row = 4;
        int col = 4;

        int count = row * col;
        int i = 0 , j = 0;
        while (count > 0) {
            for(int k = 1; k < row; k++){
                count--;
                System.out.print(arr[i][j] + " ");
                j++;
            }
            for(int k = 1; k < col; k++){
                count--;
                System.out.print(arr[i][j] + " ");
                i++;
            }
            for(int k = 1; k < row; k++){
                count--;
                System.out.print(arr[i][j] + " ");
                j--;
            }
            for(int k = 1; k < col; k++){
                count--;
                System.out.print(arr[i][j] + " ");
                i--;
            }
            row=row-2;
            col=col-2;
            i++;j++;
            if(row == 1){
                for(int k = 1; k < col; k++) {
                    count--;
                    System.out.print(arr[i][j] + " ");
                    j++;
                }
            }
            if(col == 1){
                for(int k = 1; k < row; k++) {
                    count--;
                    System.out.print(arr[i][j] + " ");
                    i++;
                }
            }

        }



    }

}
