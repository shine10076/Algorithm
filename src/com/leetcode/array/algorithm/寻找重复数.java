package com.leetcode.array.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author shine10076
 * @date 2019/5/16 17:09
 */
public class 寻找重复数 {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;

    }

}
