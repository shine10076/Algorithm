package com.leetcode.UnionFind.algorithm;

/**
 * @author shine10076
 * @date 2019/9/27 9:44
 */
public class 岛问题 {

    public int numIslands(char[][] grid) {

       if(grid == null || grid.length == 0)
       {
           return 0;
       }
       int res = 0;
       for(int i=0;i<grid.length;i++)
           for (int j=0;j<grid[0].length;j++)
           {
               if(grid[i][j] == '1')
               {
                   res++;
                   infect(grid,i,j,grid.length,grid[0].length);
               }
           }

        return res;

    }

    private void infect(char[][] grid, int i, int j, int N, int M)
    {
        if(i<0 || j<0 || i>=N || j>=M || grid[i][j] != '1')
        {
            return ;
        }
        grid[i][j] = '2';
        infect(grid,i+1,j,N,M);
        infect(grid,i-1,j,N,M);
        infect(grid,i,j+1,N,M);
        infect(grid,i,j-1,N,M);
    }

}
