package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/10/15 13:58
 */
public class 戳气球 {

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        /**
         * 初始化区间 ：
         */
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {

                dp[i][j] = -1;

            }
        }

        int res = dfs(nums,dp,0,nums.length-1);
        return res;
    }

    public static int dfs(int[] nums, int[][] dp, int start, int end)
    {
        if(start<0||start>=nums.length||end<0 || end >=nums.length||start>end) return 0;
        if(dp[start][end] > -1) return dp[start][end];
        int res = -1;
        for(int i=start;i<=end;i++)
        {
            int left = start-1>=0?nums[start-1]:1;
            int right = end+1<nums.length?nums[end+1]:1;

            res = Math.max(res, left*right*nums[i]+dfs(nums,dp,start,i-1)+dfs(nums,dp,i+1,end));
        }

        dp[start][end]=res;
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,1,5,8};

        maxCoins(nums);

    }

}
