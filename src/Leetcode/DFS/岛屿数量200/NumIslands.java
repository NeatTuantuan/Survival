package Leetcode.DFS.岛屿数量200;

/**
 * @ClassName NumIslands
 * @Description TODO 思路：遍历每一个格子，当是陆地时，把当前格子置0，然后dfs邻居，把是陆地的也置0。不需要回溯，递归前改了状态递归后不需要再变回去。
 * @Author tuantuan
 * @Date 2020/8/25 下午3:00
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class NumIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        //岛屿数量
        int nums = 0;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j] == '1'){
                    markDFS(grid,i,j,m,n);
                    nums++;
                }
            }
        }
        return nums;
    }

    private void markDFS(char[][] grid, int i, int j, int m, int n) {
        //边界条件，超出边界或当前格子是水，则返回
        if (i<0 || j<0 || i>=m || j>=n ||grid[i][j]=='0') return;
        grid[i][j] = '0';
        markDFS(grid,i+1,j,m,n);
        markDFS(grid,i-1,j,m,n);
        markDFS(grid,i,j+1,m,n);
        markDFS(grid,i,j-1,m,n);
    }
}
