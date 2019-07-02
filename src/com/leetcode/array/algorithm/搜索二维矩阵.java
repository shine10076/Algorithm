package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/5/3 16:34
 */
public class 搜索二维矩阵 {

    /**
     * 从右上角开始找，
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };
        boolean res = searchMatrix(matrix, 5);
        System.out.println(res);
    }
}
