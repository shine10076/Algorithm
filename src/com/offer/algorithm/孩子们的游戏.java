package com.offer.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/8/16 15:11
 */
public class 孩子们的游戏 {

    public static int LastRemaining_Solution(int n, int m) {

        if(n<0) return -1;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            queue.offer(i);
        }
        int res = 0;
        while (!queue.isEmpty())
        {
            for(int i=1;i<m;i++)
            {
                res = queue.poll();
                queue.offer(res);
            }
            res=queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(LastRemaining_Solution(5,3));
    }
}
