package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/14 16:19
 */
public class 连续子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {

        int res = 0, max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]>=0) flag = true;
            res += array[i];
            max= Math.max(max,res);
            if(res < 0)
            {
                res = 0;
            }
        }

        return flag?max:-1;
    }
}
