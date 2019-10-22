package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/10/22 13:42
 */
public class 排序数组中的元素的第一个位置和最后一个位置 {

    public static int[] searchRange(int[] nums, int target) {
        int[] res =  new int[2];
        res[0] = getStartIndexOfElement(nums,target,0,nums.length-1);
        res[1] = getEndIndexOfElement(nums,target,0,nums.length-1);

        return res;
    }

    private static int getStartIndexOfElement(int[] nums, int target, int L, int R)
    {

        if(L<=R)
        {
            int mid = L + ((R-L)>>1);
            if(nums[mid] == target &&((mid-1 < 0)|| nums[mid-1]<target))
            {
                return mid;
            }
            else if(nums[mid] < target)
            {
                return getStartIndexOfElement(nums,target,mid+1,R);
            }
            else
            {
                return getStartIndexOfElement(nums,target,L,mid-1);
            }
        }
        else
        {
            return -1;
        }
    }

    private static int getEndIndexOfElement(int[] nums, int target, int L, int R)
    {
        if(L<=R)
        {

            int mid = L + ((R-L)>>1);
            if(nums[mid] == target && ((mid+1>=nums.length)||nums[mid+1]>target))
            {
                return mid;
            }
            else if(nums[mid]>target)
            {
                return getEndIndexOfElement(nums,target,L,mid-1);
            }
            else
            {
                return getEndIndexOfElement(nums,target,mid+1,R);
            }

        }
        else
        {
            return -1;
        }

    }

    public static void main(String[] args) {

        int[] num = new int[]{5,7,7,8,8,10};
        for(int i : searchRange(num,8))
        {
            System.out.println(i);
        }


    }
}
