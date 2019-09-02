package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/8/30 21:44
 */
public class 整数拆分 {

    public int integerBreak(int n) {

        if(n==2) return 1;
        if(n==3) return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=n;i++)
        {
            for(int j=1;j<i;j++)
            {
                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
            }
            dp[i] = Math.max(dp[i],i);
        }

        return dp[n];

    }
}
