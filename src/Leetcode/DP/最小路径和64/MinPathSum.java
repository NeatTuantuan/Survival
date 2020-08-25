package Leetcode.DP.最小路径和64;

/**
 * @ClassName MinPathSum
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/8/25 下午5:11
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int result[][] = new int[m][n];
        result[0][0] = grid[0][0];
        for (int i = 1 ; i < m ; i++){
            result[i][0] = result[i-1][0] + grid[i][0];
        }
        for (int j = 1 ; j < n ; j++){
            result[0][j] = result[0][j-1]+grid[0][j];
        }

        for (int i = 1 ; i < m ; i++){
            for (int j =  1; j < n ; j++){
                result[i][j] = grid[i][j]+Math.min(result[i-1][j],result[i][j-1]);
            }
        }
        return result[m-1][n-1];
    }
}
