package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/11/12 21:44
 */
public class 买卖股票的最佳时机 {

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int res = 0;
        int min = prices[0];
        for(int i : prices){
            res = Math.max(res,i-min);
            if(min > i){
                min = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1});
    }
}
