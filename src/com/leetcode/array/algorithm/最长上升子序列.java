package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2020/3/14 21:07
 */
public class 最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
        //动态规划，dp[i]:以nums[i]结尾的数组的最长上升子序列长度
        int[] dp = new int[nums.length+1];
        for(int i = 0; i < nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for(int i : dp){
            res = Math.max(i,res);
        }
        return res;
    }

    //贪心算法+二分查找
    public int lengthOfLIS2(int[] nums){
        if(nums == null || nums.length < 1){
            return 0;
        }
        //dp[i] : 长度为i的最长上升子序列中结尾最小值
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++) dp[i] = 0x7fffffff;
        int len = 1;
        dp[len] = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] > dp[len]){
                dp[++len] = nums[i];
            }
            else if(nums[i] < dp[len]){
                binarySearch(dp,len,nums[i]);
            }
        }


        return len;
    }

    private void binarySearch(int[] dp, int len, int num){
        int L = 0, R = len-1;
        int pos = 0;
        while (L <= R){
            int mid = L + ((R-L)>>1);
            if(dp[mid] < num){
                pos = mid;
                L = mid + 1;
            }else
                R = mid - 1;
        }

        dp[pos+1] = num;
    }

}
