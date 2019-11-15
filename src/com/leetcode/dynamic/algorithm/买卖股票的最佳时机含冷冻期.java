package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * 2019/11/15 9:40
 */
public class 买卖股票的最佳时机含冷冻期 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        /**
         * dp[i][0|1] : i代表第几天，0代表不持有股票，1代表持有股票
         */
        int[][] dp = new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            if(i-2>=0){
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
            }else
            {
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            }
        }

        return dp[prices.length-1][0];
    }
}
