package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/9/7 11:03
 */
public class 最长数对列 {

    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0) return 0;

        int n = pairs.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(pairs[i][1]>pairs[j][1])
                {
                    swap(pairs,i,j);
                }
            }
        }

        int res = 1;
        int pre = pairs[0][1];
        for(int i=1;i<n;i++)
        {
            if(pairs[i][0]>pre)
            {
                res++;
                pre = pairs[i][1];
            }else
                continue;

        }
        return res;
    }

    private void swap(int[][] pairs, int i, int j)
    {
        int temp = pairs[i][0];
        pairs[i][0] = pairs[j][0];
        pairs[j][0] = temp;
        temp = pairs[i][1];
        pairs[i][1] = pairs[j][1];
        pairs[j][1] = temp;
    }
}
