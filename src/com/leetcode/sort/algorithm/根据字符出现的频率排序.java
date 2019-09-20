package com.leetcode.sort.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author shine10076
 * @date 2019/9/20 14:19
 */
public class 根据字符出现的频率排序 {

    public String frequencySort(String s) {

        HashMap<Character,Integer> map = new HashMap<>(s.length());
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o2.time-o1.time;
            }
        });


        for(Character c : map.keySet())
        {
            queue.offer(new pair(c,map.get(c)));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty())
        {
            pair p = queue.poll();
            Character ch = p.ch;
            for(int i=0;i<p.time;i++)
            {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    class pair
    {
        public Character ch;
        public Integer time;

        public pair(Character ch, Integer time)
        {
            this.ch = ch;
            this.time = time;
        }
    }
}
