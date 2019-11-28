package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * 2019/11/28 16:19
 */
public class 下一个排列 {


    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 1){
            return;
        }
        /**
         * 先找出一组逆序对nums[k] < nums[k+1]，没有就逆转整个数组并且返回
         * 然后找出最大的l使得nums[l]>nums[k]
         * 交换nums[l]和nums[k]
         * 逆转子数组nums[k+1:..]
         */
        int k=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i] > nums[i-1]){
                k = i-1;
                break;
            }
        }
        if(k == -1) {
            reverse(nums,0,nums.length-1);
            return;
        }

        int l = -1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] > nums[k]){
                l = i;
                break;
            }
        }

        swap(nums,l,k);
        reverse(nums,k+1,nums.length-1);

    }

    public void swap(int[] nums, int L, int R){

        int tmp = nums[L];
        nums[L] = nums[R];
        nums[R] = tmp;

    }

    public void reverse(int[] nums, int L, int R){
        while (L < R){
            swap(nums,L++,R--);
        }
    }
}
