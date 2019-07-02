package com.leetcode.thought.greedy.algorithm;

/**
 * @author shine10076
 * @date 2019/6/1 10:31
 */
public class 非递减数列 {

    public static boolean checkPossibility(int[] nums) {
        /**
         * 优先考虑让nums[i-1]=nums[i]这样不会影响后面操作
         * 但是如果nums[i-2]>nums[i]时这样修改无效，这时候需要将nums[i]= nums[i-1]
         */
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 2, 4};
        System.out.println(checkPossibility(nums));
    }
}
