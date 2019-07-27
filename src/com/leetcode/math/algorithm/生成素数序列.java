package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/7/27 20:24
 */
public class 生成素数序列 {

    public int countPrimes(int n) {

        boolean[] prime = new boolean[n];
        int res = 0;
        for(int i = 2; i < n; i++)
        {
            if(!prime[i])
            {
                res++;
                for(int j=2;i*j<n;j++)
                {
                    prime[i*j]=true;
                }
            }
        }
        return res;
    }

}
