package com.yudao.leetcode.dynamic;

/**
 * 64. 最小路径和
 */
public class Leet64_MinPathSum {

    public static void main(String[] args) {
        int [][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        Leet64_MinPathSum m = new Leet64_MinPathSum();
        System.out.println(m.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int [][] dq = new int[row][col];
        dq[0][0] = grid[0][0];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(i==0 && j==0) {
                    continue;
                }
                int min = 0;
                if(i==0 || j==0){
                    if(i==0){
                        min = dq[i][j-1];
                    }
                    if(j==0){
                        min = dq[i-1][j];
                    }

                } else {
                    min = Math.min(dq[i-1][j],dq[i][j-1]);
                }
                dq[i][j] = min + grid[i][j];
            }
        }
        return dq[row-1][col-1];
    }
}
