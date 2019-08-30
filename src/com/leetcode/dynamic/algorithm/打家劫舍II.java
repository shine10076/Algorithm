package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/8/14 14:12
 */
public class 打家劫舍II {

    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];


        return Math.max(compute(nums,0,nums.length-2),compute(nums,1,nums.length-1));
    }


    public int compute(int[] nums, int start, int end)
    {
        int pre1 = 0, pre2 = 0;
        int cur = 0;
        for(int i=start;i<=end;i++)
        {
            cur = Math.max(pre2+nums[i],pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
