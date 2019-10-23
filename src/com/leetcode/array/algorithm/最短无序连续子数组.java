package com.leetcode.array.algorithm;

import java.util.Arrays;

/**
 * @author shine10076
 * @date 2019/10/23 20:14
 */
public class 最短无序连续子数组 {

    public int findUnsortedSubarray(int[] nums) {

        int[] copy = Arrays.copyOf(nums,nums.length);
        int start = -1;
        int end = -1;

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++)
        {

            if(nums[i] != copy[i])
            {
                start = i;
                break;
            }
        }

        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i] != copy[i])
            {
                end = i;
                break;
            }
        }

        if(start==-1&&end==-1)
        {
            return 0;
        }
        else
        {
            return end-start+1;
        }
    }

    /**
     * 不使用额外空间
     * @param nums ： 数组
     * @return 子数组长度
     */
    public int findUnsortedSubarray2(int[] nums) {
        return 0;
    }
}
