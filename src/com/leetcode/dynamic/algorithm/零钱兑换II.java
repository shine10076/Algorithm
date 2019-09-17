package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/9/16 20:58
 */
public class 零钱兑换II {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];

        dp[0] = 1;

        for(int coin : coins)
            for(int i=coin;i<=amount;i++)
            {
                dp[i] += dp[i-coin];
            }

         return dp[amount];
    }


    public static int change2(int amount, int[] coins) {
        if(coins == null || coins.length == 0)
        {
            return amount == 0?1:0;
        }

        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        /**
         * 第一列初始化
         */
        for(int i=0;i<n;i++)
        {
            dp[i][0] = 1;
        }

        /**
         * 第一行初始化
         */
            for(int j=0;j<=amount;j++)
            {
                if(j-coins[0]>=0)
                {
                    dp[0][j] = dp[0][j-coins[0]];
                }
            }

        for(int i=1;i<n;i++)
          for(int j=0;j<=amount;j++)
          {
              if(j-coins[i]>=0)
              {
                  dp[i][j] = dp[i-1][j]+dp[i][j-coins[i]];
              }else
              {
                  dp[i][j] = dp[i-1][j];
              }
          }


        return dp[n-1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {};
        int amount = 3;
        System.out.println(change2(amount,coins));
    }
}
