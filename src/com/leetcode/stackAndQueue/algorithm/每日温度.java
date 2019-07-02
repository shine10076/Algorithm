package com.leetcode.stackAndQueue.algorithm;

/**
 * @author shine10076
 * @date 2019/5/14 20:03
 */
public class 每日温度 {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[T.length];
        int[] stack = new int[T.length];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && T[stack[top]] < T[i]) {
                int preIndex = stack[top--];
                res[preIndex] = i - preIndex;
            }
            stack[++top] = i;
        }
        return res;
    }
}
