package com.leetcode.greedy.algorithm;

/**
 * @author shine10076
 * 2019/11/13 20:49
 */
public class 买卖股票的最佳时机含手续费 {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        /**
         * cash ： 表示当前不持有股票的最大利润
         * hold ：表示当前持有股票的最大利润
         */
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            /*卖出股票*/
            cash = Math.max(cash, hold + prices[i] - fee);
            /*买入股票*/
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;

    }

    public static void main(String[] args) {

    }
}
