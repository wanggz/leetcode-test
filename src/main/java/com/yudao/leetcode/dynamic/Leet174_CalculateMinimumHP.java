package com.yudao.leetcode.dynamic;

/**
 * todo 174. 地下城游戏
 */
public class Leet174_CalculateMinimumHP {

    public static void main(String[] args) {

        int [][] dungeon = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};

        Leet174_CalculateMinimumHP c = new Leet174_CalculateMinimumHP();
        System.out.println(c.calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) {
            return 0;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int [][] dq = new int[row][col];
        dq[0][0] = dungeon[0][0];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < row; j++) {
                if(i==0 && j==0) {
                    continue;
                }
                int max = 0;
                if(i==0 || j==0){
                    if(i==0){
                        max = dq[i][j-1];
                    }
                    if(j==0){
                        max = dq[i-1][j];
                    }

                } else {

                    max = Math.max(dq[i-1][j],dq[i][j-1]);
                }
                dq[i][j] = max + dungeon[i][j];
            }
        }
        return dq[row-1][col-1];
    }

}
