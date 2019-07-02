package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/4/9 21:21
 */
public class 搜索旋转排序数组 {

    private static int search(int[] num, int target) {
        if (num == null) return -1;
        int L = 0, R = num.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (num[mid] == target) return mid;
            /*mid左右两边必然有一个是有序的*/
            if (num[mid] < num[R]) // 右边有序
            {
                if (target >= num[mid] && target <= num[R]) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            } else //num[mid]>num[R] 左边有序
            {
                if (target >= num[L] && num[mid] >= target) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(num, target));
    }
}
