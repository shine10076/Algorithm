package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/9/9 21:37
 */
public class 分割等和子集 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i: nums)
        {
            sum += i;
        }
        if(sum%2 == 1) return false;

        int volume = sum>>>1;
        /**
         * dp[j] ： 表示数组中的数字是否可以组合成j
         */
        boolean[] dp = new boolean[volume+1];
        dp[0] = true;

        for(int i=0;i<nums.length;i++)
            for(int j=volume;j>=nums[i];j--)
            {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        return dp[volume];
    }
}
