package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/5/16 11:03
 */
public class 错误的集合 {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        int[] Nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            Nums[nums[i]] += 1;
        }
        for (int i = 1; i <= n; i++) {
            if (Nums[i] == 2) {
                res[0] = i;
            }
            if (Nums[i] == 0) {
                res[1] = i;
            }

        }
        return res;
    }
}
