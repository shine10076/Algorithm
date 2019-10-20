package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/10/17 19:52
 */
public class 和为K的子数组 {

    public int subarraySum(int[] nums, int k) {

        int[] sums = new int[nums.length];
        int sum = 0;

        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            sums[i] = sum;
        }

        int res = 0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                if((sums[j]-sums[i]+nums[i])==k)
                {
                    res++;
                }
            }
        }

        return res;
    }

}
