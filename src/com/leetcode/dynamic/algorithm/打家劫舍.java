package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/8/14 13:59
 */
public class 打家劫舍 {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] cost = new int[n+1];
        cost[1] = nums[0];
        for(int i=2;i<=n;i++)
        {
            cost[i]=Math.max(cost[i-2]+nums[i-1],cost[i-1]);
        }

        return cost[n];
    }
}
