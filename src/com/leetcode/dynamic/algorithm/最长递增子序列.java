package com.leetcode.dynamic.algorithm;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/9/2 20:55
 */
public class 最长递增子序列 {

    public static int max = 0;

    public static int lengthOfLIS(int[] nums) {

        int[] cell = new int[nums.length];
        for (int i=0;i<nums.length;i++)
        {
            int max = 1;
            for (int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    max =Math.max(max,cell[j]+1);
                }
            }
            cell[i]=max;
        }

        int max = 0;
        for(int i:cell)
        {
            max = Math.max(i,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};

        System.out.println(lengthOfLIS(nums));
    }

}
