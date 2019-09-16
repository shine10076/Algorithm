package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/9/11 19:04
 */
public class 零钱兑换 {

    public static int coinChange(int[] coins, int amount) {


        if(coins == null || coins.length == 0 || amount < 0)
        {
            return -1;
        }
        int n = coins.length;
        int[][] money = new int[n][amount+1];
        int max = Integer.MAX_VALUE;

        for(int j = 1; j<=amount;j++)
        {
            money[0][j] = max;
            if(j-coins[0]>=0 && money[0][j-coins[0]]!= max)
            {
                money[0][j] = money[0][j-coins[0]]+1;
            }
        }

        int left = 0;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                left = max;
                if(j-coins[i]>=0 && money[i][j-coins[i]] != max )
                {
                    left = money[i][j-coins[i]] + 1;
                }
                money[i][j] = Math.min(left,money[i-1][j]);
            }
        }


        return money[n-1][amount]!=max?money[n-1][amount]:-1;

    }


    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(coins,amount));
    }
}
