package com.leetcode.Search.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/7/16 18:58
 */
public class 岛屿的最大面积 {

    public int[][] direction = new int[][]{
            {1,0},{0,1},{-1,0},{0,-1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length < 1){
            return 0;
        }
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }

        return res;
    }

    public int dfs(int[][] grid, int i, int j){
        int res = 1;
        grid[i][j] = 2;
        for(int[] d : direction){
            if((i+d[0]>=0)&&(i+d[0]<grid.length)&&(j+d[1]>=0)&&(j+d[1]<grid[0].length)){
                if(grid[i+d[0]][j+d[1]] == 1){
                    res += dfs(grid,i+d[0],j+d[1]);
                }
            }
        }
        return res;
    }

}
