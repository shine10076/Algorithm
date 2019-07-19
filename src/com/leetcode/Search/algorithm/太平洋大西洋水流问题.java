package com.leetcode.Search.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/7/18 15:09
 */
public class 太平洋大西洋水流问题 {


    /**
     * 从上左边界出发标记连通图，从下右边界出发标记连通图
     * 同时在两个连通图里面为输出坐标
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
        {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;

        boolean[][] isPac = new boolean[m][n];
        boolean[][] isAltan = new boolean[m][n];

        /**
         * 上左边界
         */
        for(int i=0;i<m;i++)
        {
            isPac[i][0] = true;
            dfs(matrix,i,0,isPac);
        }
        for(int j=0;j<n;j++)
        {
            isPac[0][j] = true;
            dfs(matrix,0,j,isPac);
        }

        /**
         * 下右边界
         */
        for(int i=0;i<m;i++)
        {
            isAltan[i][n-1] = true;
            dfs(matrix,i,n-1,isAltan);
        }
        for(int j=0;j<n;j++)
        {
            isAltan[m-1][j] = true;
            dfs(matrix,m-1,j,isAltan);
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isAltan[i][j]&&isPac[i][j])
                {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    res.add(item);

                }
            }
        }


        return res;
    }

    /**
     * @param matrix
     * @param i
     * @param j
     * @param isVisit
     */
    public void dfs(int[][] matrix, int i, int j, boolean[][] isVisit)
    {
        int m = matrix.length, n = matrix[0].length;
        if(i+1<m && matrix[i][j]<=matrix[i+1][j] && !isVisit[i+1][j])
        {
            isVisit[i+1][j] = true;
            dfs(matrix,i+1,j,isVisit);
        }
        if(i-1>=0 && matrix[i][j]<=matrix[i-1][j] && !isVisit[i-1][j])
        {
            isVisit[i-1][j] = true;
            dfs(matrix,i-1,j,isVisit);
        }
        if(j+1<n && matrix[i][j]<=matrix[i][j+1]&& !isVisit[i][j+1])
        {
            isVisit[i][j+1] = true;
            dfs(matrix,i,j+1,isVisit);
        }

        if(j-1>=0 && matrix[i][j]<=matrix[i][j-1] && !isVisit[i][j-1])
        {
            isVisit[i][j-1] = true;
            dfs(matrix,i,j-1,isVisit);
        }

    }
}
