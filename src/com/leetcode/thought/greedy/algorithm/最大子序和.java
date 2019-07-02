package com.leetcode.thought.greedy.algorithm;

/**
 * @author shine10076
 * @date 2019/6/1 11:08
 */
public class 最大子序和 {

    public int maxSubArray(int[] nums) {

        int sum = Integer.MIN_VALUE;
        int b = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (b > 0) b += nums[i];
            else
                b = nums[i];
            if (b > sum) sum = b;
        }
        return sum;
    }
}
