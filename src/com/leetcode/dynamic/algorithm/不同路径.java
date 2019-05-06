package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/5/6 11:27
 */
public class 不同路径 {

    public static int uniquePaths(int m, int n) {
        if(n<=1&&m<=1) return 1;
        int[][] matrix = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i==1&&j==1) matrix[i][j] = 1;
                else
                {
                    matrix[i][j] = matrix[i-1][j]+matrix[i][j-1];
                }
            }
        }
        return matrix[m][n];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
