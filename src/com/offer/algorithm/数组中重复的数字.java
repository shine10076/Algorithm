package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/16 16:03
 */
public class 数组中重复的数字 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if(numbers == null || numbers.length == 0)
        {
            return false;
        }

        int[] num = new int[length];
        boolean res = false;

        for(int i:numbers)
        {
            if(num[i] != 0) {
                duplication[0]=i;
                res = true;
                break;
            }
            num[i]++;
        }

        return res;
    }
}
