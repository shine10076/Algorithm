package com.leetcode.UnionFind.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/9/28 15:40
 */
public class 由斜杠划分区域 {


    private int[][] space = new int[][]{
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };

    private int [][] right = new int[][]{
            {0,0,1},
            {0,1,0},
            {1,0,0}
    };
    private int [][] left = new int[][]{
            {1,0,0},
            {0,1,0},
            {0,0,1}
    };



    public int regionsBySlashes(String[] grid) {

        int N = grid.length;
        int[][] grids = new int[3*N][3*N];
        Queue<Integer> queue = new LinkedList<>();
        for(String s: grid)
        {
            int i=0;
            while (i<s.length())
            {
                if(s.charAt(i)==' ')
                {
                    queue.offer(0);
                    i++;
                }else if(s.charAt(i)=='/')
                {
                    queue.offer(1);
                    i++;
                }else
                {
                    queue.offer(2);
                    i++;
                }
            }
        }

        //初始化
        for(int i=0;i<3*N;i=i+3)
            for(int j=0;j<3*N;j=j+3)
            {
                int categories = queue.poll();

                copyArrays(grids,i,j,categories);
            }
        int res = 0;
        for(int i=0;i<grids.length;i++)
            for (int j=0;j<grids[0].length;j++)
            {
                if(grids[i][j] == 0)
                {
                    res++;
                    infect(grids,i,j,grids.length,grids[0].length);
                }
            }

        return res;
    }

    private void copyArrays(int[][] grids, int i, int j, int categories)
    {
        int[][] nums;
        if(categories == 0) nums = space;
        else if(categories == 1) nums = right;
        else  nums = left;
        for(int m=0;m<3;m++)
        {
            for(int n=0;n<3;n++)
            {
                grids[i+m][j+n] = nums[m][n];
            }
        }
    }

    private void infect(int[][] grid, int i, int j, int N, int M)
    {
        if(i<0 || j<0 || i>=N || j>=M || grid[i][j] != 0)
        {
            return ;
        }
        grid[i][j] = 2;
        infect(grid,i+1,j,N,M);
        infect(grid,i-1,j,N,M);
        infect(grid,i,j+1,N,M);
        infect(grid,i,j-1,N,M);
    }


    public static void main(String[] args) {
        由斜杠划分区域 item = new 由斜杠划分区域();

        String[] grids = new String[]{
                "/\\",
                "\\/"
        };

        item.regionsBySlashes(grids);
    }
}
