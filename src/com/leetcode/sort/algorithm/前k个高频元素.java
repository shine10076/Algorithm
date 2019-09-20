package com.leetcode.sort.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/9/19 20:49
 */
public class 前k个高频元素 {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length*2);

        for(int i : nums)
        {
            if(!map.containsKey(i))
            {
                map.put(i,1);
            }else
            {
                map.put(i,map.get(i)+1);
            }
        }
        PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o2.times-o1.times;
            }
        });

        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer,Integer> entry = iterator.next();
            queue.offer(new pair(entry.getKey(),entry.getValue()));
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (k>0)
        {
            res.add(queue.poll().num);
            k--;
        }
        return res;
    }

    static class pair
    {
        int num;
        int times;

        public pair(int num, int times)
        {
            this.num = num;
            this.times = times;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        for(int i : topKFrequent(nums,2))
        {
            System.out.print(i+"   ");
        }
    }
}
