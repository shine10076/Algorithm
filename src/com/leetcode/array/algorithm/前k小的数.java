package com.leetcode.array.algorithm;

import java.util.Arrays;

/**
 * @author shine10076
 * @date 2020/3/20 21:59
 */
public class 前k小的数 {

    public int[] getLeastNumbers(int[] arr, int k) {
        quickselect(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private void quickselect(int[] nums, int start, int end, int k) {
        while (start < end) {
            // 这边做了了小优化，三数取中～前两步先确定最后一个一定是最大的，然后只要把中间那个数放第一个位置即可
            // 如果你嫌麻烦可以直接 int pivot = nums[start];
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[end]) swap(nums, start, end);
            if (nums[mid] > nums[end]) swap(nums, mid, end);
            if (nums[mid] > nums[start]) swap(nums, mid, start);
            int pivot = nums[start];

            int i = start, j = end;
            while (i <= j) {
                //升序～
                while (i <= j && nums[i] < pivot) i++;
                while (i <= j && nums[j] > pivot) j--;
                if (i <= j) {
                    swap(nums,i,j);
                    i++;
                    j--;
                }
            }
            if (i >= k) {
                end = i - 1;
            } else {
                start = i;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
