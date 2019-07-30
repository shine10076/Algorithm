package com.leetcode.math.algorithm;

import java.util.Arrays;

/**
 * @author shine10076
 * @date 2019/7/30 20:15
 */
public class 最少移动次数使数组元素相等II {

    public int minMoves2(int[] nums) {

        int l = 0, r = 0;
        int res = 0;
        while (l<r)
        {
            res += nums[r]-nums[l];
            r--;
            l++;
        }
        return res;
    }
}
