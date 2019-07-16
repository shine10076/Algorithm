package com.leetcode.Search.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/7/16 18:58
 */
public class 岛屿的最大面积 {

    public static int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] isVisit = new boolean[row][col];
        int res = 0;
        for(int i=0;i<row;i++)
            for (int j=0;j<col;j++)
            {
                if(grid[i][j]==1&&isVisit[i][j]==false)
                {
                    res = Math.max(res, dfs(grid,i,j,row,col,isVisit));
                }
            }

        return res;
    }


    public static int dfs(int[][] grid, int i, int j, int row, int col,boolean[][] isVisit)
    {
        int res = 0;
        Point root = new Point(i,j);
        Queue<Point> queue = new LinkedList<>();
        isVisit[i][j] = true;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Point point = queue.poll();
            res++;
            if(point.x+1<row && grid[point.x+1][point.y]==1&&isVisit[point.x+1][point.y]==false)
            {
                queue.offer(new Point(point.x+1, point.y));
                isVisit[point.x+1][point.y] = true;
            }
            if(point.y+1<col && grid[point.x][point.y+1]==1&&isVisit[point.x][point.y+1]==false)
            {
                queue.offer(new Point(point.x, point.y+1));
                isVisit[point.x][point.y+1] = true;
            }
            if(point.y-1>=0 && grid[point.x][point.y-1]==1&&isVisit[point.x][point.y-1]==false)
            {
                queue.offer(new Point(point.x, point.y-1));
                isVisit[point.x][point.y-1] = true;
            }
            if(point.x-1>=0 && grid[point.x-1][point.y]==1&&isVisit[point.x-1][point.y]==false)
            {
                queue.offer(new Point(point.x-1, point.y));
                isVisit[point.x-1][point.y] = true;
            }

        }

        return res;
    }

     static class Point {
        int x;
        int y;
        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public String toString()
        {
            return x+":"+y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,1},
                {1,1}
        };
        System.out.println(maxAreaOfIsland(grid));

    }
}
