package com.leetcode.math.algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author shine10076
 * @date 2019/7/31 11:24
 */
public class 除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] res = new int[size];
        Arrays.fill(res,1);
        int left = 1;
        for(int i=0;i<nums.length;i++)
        {
            left *= nums[i];
            if(i+1<size)
            {
                res[i+1] *= left;
            }
        }
        int right = 1;
        for(int i=size-1;i>=0;i--)
        {
            right *= nums[i];
            if(i-1>=0)
            {
                res[i-1] *= right;
            }
        }

        return res;
    }
}
