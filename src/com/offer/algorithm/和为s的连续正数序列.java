package com.offer.algorithm;

import java.util.ArrayList;

/**
 * @author shine10076
 * @date 2019/8/15 15:28
 */
public class 和为s的连续正数序列 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=1;i<sum/2+1;i++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=sum/2+1;j>i;j--)
            {
                if(compute(i,j) == sum)
                {
                    for(int k=i;k<=j;k++)
                    {
                        list.add(k);
                    }
                    res.add(list);
                    break;
                }
            }
        }

        return res;
    }

    public int compute(int L, int R)
    {
        return (L+R)*(R-L+1)/2;
    }
}
