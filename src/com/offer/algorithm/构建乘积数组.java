package com.offer.algorithm;

import java.util.Iterator;

/**
 * @author shine10076
 * @date 2019/8/16 16:08
 */
public class 构建乘积数组 {

    public int[] multiply(int[] A) {

        if(A == null) return null;

        int[] B = new int[A.length];
        for(int i=0;i<B.length;i++) B[i] = 1;

        //先存左边的乘积
        int res = 1;
        for(int i=0;i<A.length;i++)
        {
            res *= A[i];
            if(i<A.length-1) B[i+1] *= res;
        }

        //再存右边的乘积
        res = 1;
        for(int i=A.length-1;i>=0;i--)
        {
            res *= A[i];
            if(i>0) B[i-1] *= res;
        }

        return B;
    }

    public static void main(String[] args) {

    String str = "";
        System.out.println(str.split(",").length);
    }
}
