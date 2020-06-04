package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2020/5/4 11:25
 */
public class 跳跃游戏II {

    public static int jump(int[] nums) {
        int index = 0;
        int maxPosition = 0;
        int step = 0;
        int end = 0;
        for(int i=0;i<nums.length;i++){
            maxPosition = Math.max(maxPosition,nums[i]+i);
            if(i == end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
