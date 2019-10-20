package com.leetcode.deque.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/10/20 14:51
 */
public class 滑动窗口最大值 {

    /**
     * 主要难点在于实现一个单调队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length ==0 ) return new int[0];
        int[] res =new int[nums.length-k+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<k;i++)
        {
            removeElement(deque,i,nums,k);
            addElement(deque,i);
        }

        res[0] = nums[deque.peekFirst()];

        for(int i=k;i<nums.length;i++)
        {
            removeElement(deque,i,nums,k);
            addElement(deque,i);
            res[i-k+1] = nums[deque.peekFirst()];
        }


        return res;
    }


    public void removeElement(ArrayDeque<Integer> deque, int i, int[] nums,int k)
    {
        if(!deque.isEmpty()&&(deque.peekFirst() == (i-k)))
        {
            deque.removeFirst();
        }


        while ((!deque.isEmpty())&&(nums[deque.peekLast()] < nums[i]))
        {
            deque.removeLast();
        }

    }

    public void addElement(ArrayDeque<Integer> deque, int i)
    {
        deque.addLast(i);
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,-1};

        滑动窗口最大值 instance = new 滑动窗口最大值();
        for(int i : instance.maxSlidingWindow(nums,1))
        {
            System.out.println(i);
        }
    }

}
