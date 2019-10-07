package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/10/7 10:36
 */
public class 不同二叉搜索树 {

    public int numTrees(int n) {
        if(n<1) return 0;
        if(n==1) return 1;

        int[] nums = new int[n+1];

        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 2;

        for(int i=3;i<=n;i++)
        {
            nums[i] = rootCount(nums, i);
        }

        return nums[n];
    }

    public int rootCount(int[] nums, int i)
    {

        int res = 0;
        for(int j=1;j<=i;j++)
        {

            res += nums[j-1]*nums[i-j];

        }

        return res;
    }
}
