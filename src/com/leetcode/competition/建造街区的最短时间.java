package com.leetcode.competition;

import java.util.PriorityQueue;

/**
 * @author shine10076
 * @date 2019/9/24 14:13
 */
public class 建造街区的最短时间 {

    public int minBuildTime(int[] blocks, int split) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : blocks)
        {
            queue.offer(i);
        }

        while (queue.size()!=1)
        {
            int a = queue.poll();
            int b = queue.poll();

            int res = Math.max(a,b)+split;
            queue.offer(res);
        }

        return queue.poll();
    }
}
