package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/8/30 20:52
 */
public class 等差数列划分 {

    public static int numberOfArithmeticSlices(int[] A) {
        if(A == null ||A.length == 0) return 0;
        int len = A.length;
        int[] dp = new int[len];
        for(int i=0;i<len;i++)
        {
            if(i-0+1<3) dp[i]=0;
            else
            {
                dp[i] = dp[i-1] + numberofPart(A,i);
            }
        }
        return dp[len-1];
    }

    private static int numberofPart(int[] A, int end)
    {
        int count = 0;
        int diff = A[end] -A[end-1];
        for(int i = end;i>=0;i--)
        {
            if(i<end&&A[i+1]-A[i] != diff) break;
            if(end - i + 1 < 3) continue;
            else
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] A = new int[]{1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(A));
    }
}
