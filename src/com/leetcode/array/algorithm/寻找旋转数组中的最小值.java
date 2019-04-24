package com.leetcode.array.algorithm;

import sun.misc.LRUCache;

/**
 * @author shine10076
 * @date 2019/4/9 22:32
 */
public class 寻找旋转数组中的最小值 {

    private static int findMin(int[] nums)
    {
        if(nums == null) return -1;
        int L = 0, R = nums.length-1;
        int last = nums[R];
        while(L <= R)
        {
            int mid = L + ((R-L)>>1);
            if(L == R) return nums[L];
            if(nums[mid] < last) //右侧有序
            {
                R=mid+1;
            }
            else //左侧有序
            {
                L=mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {4,5,6,0,1,2,3};
        System.out.println(findMin(nums));
    }
}
