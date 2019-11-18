package com.leetcode.greedy.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author shine10076
 * 2019/11/18 19:46
 */
public class 最后一块石头的重量 {

    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length < 1){
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i : stones){
            queue.offer(i);
        }

        while (queue.size() >= 2){
            int a = queue.poll();
            int b = queue.poll();
            if(a == b) continue;
            else {
                a = a - b;
                queue.offer(a);
            }
        }

        if(queue.isEmpty()) return 0;
        else
        {
            return queue.poll();
        }

    }
}
