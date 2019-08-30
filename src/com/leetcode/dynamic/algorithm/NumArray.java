package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/8/30 20:28
 */
public class NumArray {


    private int[] sum;

    public NumArray(int[] nums) {

        int n = nums.length;
        sum = new int[n+1];
        sum[0]=0;
        for (int i=1;i<=n;i++)
        {
            sum[i] =sum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {

        return sum[j+1]-sum[i];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        NumArray a = new NumArray(nums);
        System.out.println(a.sumRange(0,2));

    }
}
