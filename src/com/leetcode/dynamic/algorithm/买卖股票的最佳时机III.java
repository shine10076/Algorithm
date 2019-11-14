package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * 2019/11/13 21:33
 */
public class 买卖股票的最佳时机III {

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int[] min = new int[prices.length];
        int m = prices[0];
        min[0] = m;
        for(int i=1;i<prices.length;i++){
            min[i] = Math.min(m,prices[i]);
            if(m > min[i])
            {
                m = min[i];
            }
        }

        int res = 0;
        for(int i=1;i<prices.length;i++)
        {
            int tmp = prices[i]-min[i-1]+intervalProfit(prices,i,prices.length-1);
            res = Math.max(res,tmp);
        }
        res = Math.max(res,intervalProfit(prices,0,prices.length-1));
        return res;

    }

    private static int intervalProfit(int[] prices, int i, int j){
        if(i>=j || j-i+1<2)
        {
            return 0;
        }
        int res = 0;
        int min = prices[i];
        for(int k=i+1;k<=j;k++){
            res = Math.max(res,prices[k]-min);
            if(min > prices[k]){
                min = prices[k];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] prices = new int[]{2,1,4,5,2,9,7};
        System.out.println(maxProfit(prices));

    }
}
