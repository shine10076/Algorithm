package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * 2019/11/25 19:03
 */
public class 检查好数组 {

    /**
     * 裴蜀定理：if a, b 的最大公约数为1， 则存在正整数x, y,使得 xa + yb = 1;
     */
    public boolean isGoodArray(int[] nums) {
        if(nums == null || nums.length < 1){
            return false;
        }
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            res = gcd(res,nums[i]);
        }

        return res == 1;

    }

    private int gcd(int a, int b){
        return (b==0)?a : gcd(b, a%b);
    }
}
