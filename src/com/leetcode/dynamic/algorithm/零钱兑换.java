package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/9/11 19:04
 */
public class 零钱兑换 {

    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] money = new int[n][amount+1];

        for(int i=0;i<money.length;i++)
            for(int j=1;j<amount+1;j++)
            {
                money[i][j] = Integer.MAX_VALUE;
            }

        for(int i=0;i<n;i++)
        {
            for(int j=1;j*coins[i]<=amount;j++)
            {
                money[i][j*coins[i]] = 1;
            }
        }



        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if((j-coins[i])<=0) continue;
                for(int k=0;j-coins[i]*k>0;k++)
                {

                    money[i][j] = Math.min(money[i-1][j-coins[i]*k]+k,money[i][j]);
                }
            }
        }

        int res=0;
        for(int i=0;i<n;i++)
        {
            res = Math.min(money[i][amount],res);
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                System.out.print(money[i][j]+" ");
            }
            System.out.println();
        }

        return res;

    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        coinChange(coins,amount);
    }
}
