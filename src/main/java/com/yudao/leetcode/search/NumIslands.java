package com.yudao.leetcode.search;

/**
 * 200. 岛屿数量
 *
 */
public class NumIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','0'},{'1','1','0','0'},{'1','0','0','0','0'},{'0','0','0','0'},{'0','0','0','1'}};

        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int row = grid.length, columns = grid[0].length, count = 0;
        boolean[][] visited = new boolean[row][columns];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < columns; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid,visited,i,j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, boolean[][] visited,int i, int j){
        // 检查合理性
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {

            if (!visited[i][j] && grid[i][j] == '1') {
                visited[i][j] = true;
                // 上 下 左 右 遍历
                dfs(grid, visited,i - 1, j);
                dfs(grid, visited,i + 1, j);
                dfs(grid, visited,i, j - 1);
                dfs(grid, visited,i, j + 1);
            }
        }
    }

}
