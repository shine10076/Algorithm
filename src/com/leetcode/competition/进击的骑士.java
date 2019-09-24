package com.leetcode.competition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/9/23 21:18
 */
public class 进击的骑士 {


    int[][] direction = new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};


    public int minKnightMoves(int x, int y) {
        /**
         * 标记访问过的点，不在访问第二次
         */
        boolean[][] isVisited  = new boolean[611][611];
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> curQueue = new LinkedList<>();
        isVisited[306][306] = true;
        queue.offer(new Point(0,0));
        int move = 0;
        while (!queue.isEmpty())
        {
            while (!queue.isEmpty())
            {
                curQueue.offer(queue.poll());
            }

            while (!curQueue.isEmpty())
            {

                Point cur = curQueue.poll();
                if(cur.x == x && cur.y == y) {
                    return move;
                }
                for(int[] position : direction)
                {
                    if(!isVisited[position[0]+306+cur.x][position[1]+306+cur.y])
                    {
                        queue.offer(new Point(position[0]+cur.x,position[1]+cur.y));
                        isVisited[position[0]+306+cur.x][position[1]+306+cur.y]=true;
                    }
                }

            }

            move++;

        }

        return 0;


    }

    class Point
    {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {

        进击的骑士 knight = new 进击的骑士();
        System.out.println(knight.minKnightMoves(300,0));
    }
}
