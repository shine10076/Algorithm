package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/8/14 14:40
 */
public class 最小路径和 {

    public static int minPathSum(int[][] grid) {

        if(grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                int left = j-1<0?-1:cost[i][j-1];
                int top = i-1<0?-1:cost[i-1][j];
                if(left<0 && top <0) cost[i][j] = grid[i][j];
                else if(left<0 || top <0) cost[i][j] = Math.max(left,top)+grid[i][j];
                else cost[i][j] = Math.min(left,top)+grid[i][j];
            }

        return cost[m-1][n-1];
    }

}
