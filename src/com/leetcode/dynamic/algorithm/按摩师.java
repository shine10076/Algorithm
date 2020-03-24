package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2020/3/24 17:39
 */
public class 按摩师 {

    public int massage(int[] nums) {
        if(nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for(int i = 2; i<=nums.length; i++){
            if(dp[i-1] < dp[i-2]+nums[i-1]){
                dp[i] = dp[i-2]+nums[i-1];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length];
    }
}
