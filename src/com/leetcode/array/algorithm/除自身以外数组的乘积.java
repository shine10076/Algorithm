package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2020/6/4 10:32
 */
public class 除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) res[i] = 1;
        int s = 1;
        for(int i=0;i<nums.length;i++){
            res[i] = s;
            s *= nums[i];
        }
        s = 1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] = res[i]*s;
            s *= nums[i];
        }

        return res;
    }
}
