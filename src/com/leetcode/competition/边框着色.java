package com.leetcode.competition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/4/28 11:19
 */
public class 边框着色 {
    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length, n =grid[0].length;
        int[][] mark = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                mark[i][j] = 0;
            }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r0, c0));
        while(!queue.isEmpty())
        {
            Point point = queue.poll();
            mark[point.x][point.y] = 1;
            if(point.x +1 >= 0 && point.x+1 < m && mark[point.x+1][point.y] ==0 && grid[point.x+1][point.y]==grid[r0][c0])
            {
                queue.offer(new Point(point.x+1, point.y));
                mark[point.x+1][point.y] = 1;
            }
            if(point.x -1 >= 0 && point.x-1 < m && mark[point.x-1][point.y] ==0 && grid[point.x-1][point.y]==grid[r0][c0])
            {
                queue.offer(new Point(point.x-1, point.y));
                mark[point.x-1][point.y] = 1;
            }
            if(point.y +1 >= 0 && point.y+1 < n && mark[point.x][point.y+1] ==0 && grid[point.x][point.y+1]==grid[r0][c0])
            {
                queue.offer(new Point(point.x, point.y+1));
                mark[point.x][point.y+1] = 1;
            }
            if(point.y -1 >= 0 && point.y-1 < n && mark[point.x][point.y-1] ==0 && grid[point.x][point.y-1]==grid[r0][c0])
            {
                queue.offer(new Point(point.x, point.y-1));
                mark[point.x][point.y-1]=1;
            }
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                System.out.print(mark[i][j] + " ");
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(mark[i][j] == 1)
                {
                    if(i == 0 || i == m-1 || j == 0 || j == n-1)
                    {
                        mark[i][j] = 2;
                    }
                    else
                    {
                        if(grid[i+1][j] != grid[i][j] || grid[i-1][j] != grid[i][j] || grid[i][j+1] != grid[i][j] ||grid[i][j-1] != grid[i][j])
                            mark[i][j] = 2;
                    }
                }
            }

       for(int i=0;i<m;i++)
           for(int j=0;j<n;j++)
               if(mark[i][j] == 2) grid[i][j] = color;

       return grid;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,2}, {2,3,2}};
        int m = grid.length, n =grid[0].length;
        int[][] res = colorBorder(grid,0,1,3);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                System.out.print(res[i][j] + " ");
    }
}
class Point
{
    int x;
    int y;
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

