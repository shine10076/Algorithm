package com.leetcode.greedy.algorithm;

/**
 * @author shine10076
 * 2019/11/12 21:59
 */
public class 买卖股票的最佳时机II {

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int res = 0;
        int cur = prices[0];
        for(int i = 1;i < prices.length; i++){
            if(prices[i]>cur){
                res += prices[i] - cur;
                cur = prices[i];
            }else{
                cur = prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1});
    }
}
