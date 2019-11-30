package com.leetcode.array.algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author shine10076
 * 2019/11/30 17:31
 */
public class 连续的子数组和 {

    /**
     * 暴力法
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {

        if(nums == null || nums.length < 1 )
        {
            return false;
        }

        for(int i=0;i<nums.length;i++){
            int sum = nums[i];
            for(int j=i+1;j<nums.length;++j){
                sum += nums[j];
                if(k == 0 ){
                    if(sum==0)
                    return true;
                }
                else {
                    if(sum % k == 0 ){
                        return true;
                    }
                 }

            }
        }

        return false;

    }

    /**
     * 使用hashSet
     * 我们要判断的是 (sum[j] - sum[i])\%k 是否等于 0。
     * 根据 modmod 运算的性质，我们知道 (sum[j] - sum[i])\%k = sum[j]\%k - sum[i]\%k
     * 故若想 (sum[j] - sum[i])\%k = 0，则必有 sum[j]\%k = sum[i]\%k
     * @param nums
     * @param k
     * @return
     */
    public static boolean checkSubarraySum2(int[] nums, int k) {

        if(nums == null || nums.length < 1 )
        {
            return false;
        }
        int N = nums.length, cache = 0;
        int[] sum = new int[N+1];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + nums[i];
            int res = k == 0 ? sum[i+1] : sum[i+1] % k;
            if (set.contains(res)) return true;
            set.add(cache);
            cache = res;
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
