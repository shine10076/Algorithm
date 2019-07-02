package com.leetcode.competition;

/**
 * @author shine10076
 * @date 2019/4/28 20:24
 */
public class 两个非重叠子数组的最大和 {

    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int max = 0;
        int maxL = 0; // L数组的最大值
        int maxM = 0; // M数组的最大值
        /*分类讨论L在M前面和L在M后面的情况*/
        /*L在M前面*/
        for (int i = L; i < A.length - M + 1; i++) {
            maxL = Math.max(maxL, sumOfSub(A, i - L, i - 1));
            max = Math.max(max, sumOfSub(A, i, i + M - 1) + maxL);
        }
        for (int i = M; i < A.length - L + 1; i++) {
            maxM = Math.max(maxM, sumOfSub(A, i - M, i - 1));
            max = Math.max(max, sumOfSub(A, i, i + L - 1) + maxM);
        }
        return max;
    }

    private static int sumOfSub(int[] A, int L, int R) {
        int sum = 0;
        for (int i = L; i <= R; ++i) {
            sum += A[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        System.out.println(maxSumTwoNoOverlap(A, 4, 3));
    }
}
