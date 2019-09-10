package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/9/7 13:47
 */
public class 摆动序列 {

    /**
     * 贪心算法
     * @param nums 数组
     * @return
     */
    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int count = 0;
        int diff = 0;
        for(int i=1;i<nums.length;i++)
        {
            if(count==0 && (nums[i]-nums[i-1])!=0)
            {
                diff = nums[i]-nums[i-1];
                count++;
            }
            else if((diff*(nums[i]-nums[i-1]))<0)
            {
                count++;
                diff = nums[i]-nums[i-1];
            }
        }
        count++;
        return count;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0,0,0};
        System.out.println(wiggleMaxLength(nums));
    }
}
