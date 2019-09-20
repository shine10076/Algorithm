package com.leetcode.sort.algorithm;

/**
 * 75 ：颜色分类
 * @author shine10076
 * @date 2019/9/20 14:32
 */
public class 荷兰国旗问题 {

    public static void sortColors(int[] nums) {

        int less = -1;
        int more = nums.length;
        int l = 0;
        while (l<more)
        {
            if(nums[l]<1) swap(nums,++less,l++);
            else if(nums[l]>1) swap(nums,--more,l);
            else
            {
                l++;
            }
        }
        return ;
    }

    private static void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



}
