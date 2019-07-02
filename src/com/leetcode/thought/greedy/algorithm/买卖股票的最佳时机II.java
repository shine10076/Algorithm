package com.leetcode.thought.greedy.algorithm;

/**
 * @author shine10076
 * @date 2019/5/27 16:37
 */
public class 买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) res += prices[i + 1] - prices[i];
        }
        return res;
    }
}
