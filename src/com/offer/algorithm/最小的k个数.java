package com.offer.algorithm;

import java.util.ArrayList;

import java.util.PriorityQueue;

/**
 * @author shine10076
 * @date 2019/8/14 15:52
 */
public class 最小的k个数 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {


        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        if(input == null || input.length == 0 || k>input.length) return res;

        for(int i : input)
        {
            queue.offer(i);
        }

        for(int i=0;i<k;i++)
        {
            res.add(queue.poll());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
       ArrayList<Integer> res =  GetLeastNumbers_Solution(input,4);
        for(int i : res) System.out.println(i);
    }
}
