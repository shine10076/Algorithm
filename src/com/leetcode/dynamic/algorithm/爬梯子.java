package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/6/24 11:06
 */
public class 爬梯子 {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i <= n; i++)
            steps[i] = steps[i - 1] + steps[i - 2];
        return steps[n];
    }
}
