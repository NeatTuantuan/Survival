package Leetcode.DFS.岛屿的最大面积695;

/**
 * @ClassName MaxAreaOfIsland
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/8/25 下午4:31
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class MaxAreaOfIsland {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (grid[i][j] == 1){
                    int result = funDFS(grid,i,j,m,n);
                    max = Math.max(max,result);
                }
            }
        }
        return max;
    }

    private int funDFS(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >=m || j>=n || grid[i][j] == 0){
            return 0;
        }else {
            grid[i][j] = 0;
            return funDFS(grid,i+1,j,m,n)+
                    funDFS(grid,i-1,j,m,n)+
                    funDFS(grid,i,j+1,m,n)+
                    funDFS(grid,i,j-1,m,n)+1;
        }

    }
}
