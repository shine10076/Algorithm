package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/10/23 19:49
 */
public class 乘积最大子序列 {

    /**
     * 时间复杂度 ： O(n)
     * 额外空间复杂度 ： O(n)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        if(nums == null || nums.length <1)
        {
            return 0;
        }
        /**
         * 以i结尾的数组中
         * max : 最大值
         * min ：最小值
         */
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int a = max[i-1]*nums[i];
            int b = min[i-1]*nums[i];
            int c = nums[i];

            max[i] = Math.max(a,Math.max(b,c));
            min[i] = Math.min(a,Math.min(b,c));
        }

        int res = Integer.MIN_VALUE;
        for(int i : max)
        {
            res = Math.max(i,res);
        }
        return res;
    }

}
