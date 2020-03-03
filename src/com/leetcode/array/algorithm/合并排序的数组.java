package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2020/3/3 9:14
 */
public class 合并排序的数组 {

    public static void merge(int[] A, int m, int[] B, int n) {

        if(n <= 0) return;
        int ta = m-1, tb = n-1;
        int index = m+n-1;
        while(ta >=0 && tb >= 0){
            if(A[ta] >= B[tb]){
                A[index--] = A[ta--];
            }else{
                A[index--] = B[tb--];
            }
        }
        while(ta >= 0) A[index--] = A[ta--];
        while(tb >= 0) A[index--] = B[tb--];

    }

    public static void main(String[] args) {
        int[] A = new int[]{0};
        int m = 0;
        int[] B = new int[]{1};
        int n = 1;
        merge(A,0,B,1);
        for(int a : A){
            System.out.printf(a+" ");
        }
    }
}
