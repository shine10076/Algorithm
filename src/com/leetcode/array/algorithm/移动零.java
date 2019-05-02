package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/5/1 21:33
 */
public class 移动零 {
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int fast = 0, slow = 0;
        while(fast < length && slow < length)
        {
            if(nums[fast] != 0)
            {
                nums[slow++] = nums[fast++];
            }
            else
            {
                fast++;
            }
        }

        while(slow < length)
        {
            nums[slow++] = 0;
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,3,5,0};
        moveZeroes(nums);
        for(int i: nums)
        {
            System.out.print(i+" ");
        }
    }
}
