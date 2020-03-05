package com.leetcode.array.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/10/16 18:52
 */
public class 任务调度器 {

    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] letter = new int[26];

        for(char c : tasks){
            letter[c-'A']++;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i=0;i<26;i++){
            if(letter[i]>0){
                priorityQueue.offer(letter[i]);
            }
        }

        while (!priorityQueue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<=n;i++){
                if((!priorityQueue.isEmpty())){
                    if(priorityQueue.peek() > 1){
                        list.add(priorityQueue.poll()-1);
                    }else {
                        priorityQueue.poll();
                    }
                }
                time++;
                if(list.size() == 0 && priorityQueue.isEmpty()) break;

            }
            for(Integer i : list){
                priorityQueue.offer(i);
            }
        }

        return time;

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        integers.offer(3);
        integers.offer(2);
        System.out.println(integers.poll());
        System.out.println(integers.poll());
    }
}
