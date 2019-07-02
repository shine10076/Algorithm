package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/5/1 21:44
 */
public class 重塑矩阵 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int row = count / c;
                int col = count % c;
                res[row][col] = nums[i][j];
                ++count;
            }
        }
        return res;
    }
}
