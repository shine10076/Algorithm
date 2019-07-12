package com.leetcode.Search.algorithm;

/**
 * @author shine10076
 * @date 2019/7/12 15:36
 */
public class 完全平方数 {

    /**
     * 给定了正整数,动态规划方法
     */
    public static int numSquares(int n) {

        int[] res = new int[n+1];
        res[1] = 1;
        for(int i=1;i<=n;i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++)
            {
                min = Math.min(min,res[i-(j*j)]+1);
            }
            res[i] = min;
        }
        for(int i=1;i<=n;i++)
        {
            System.out.println(i+":"+res[i]);
        }
        return res[n];
    }


    /**
     *
     * @param n
     * @return
     */

    public static void main(String[] args) {
        int n = 12;
        numSquares(12);
    }
}
