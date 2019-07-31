package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/7/31 11:08
 */
public class 求众数 {

    public int majorityElement(int[] nums) {

        if(nums == null || nums.length==0)
        {
            return 0;
        }
        int count = 1;
        int res = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] == res)
            {
                count++;
            }
            else
            {
                count--;
                if(count==0)
                {
                    res = nums[i];
                    count = 1;
                }
            }
        }

        return res;
    }
}
