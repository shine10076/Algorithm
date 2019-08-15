package com.offer.algorithm;

import java.util.ArrayList;

/**
 * @author shine10076
 * @date 2019/8/15 15:45
 */
public class 和为S的两个数字 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length == 0) return res;
        int L = 0, R = array.length-1;

        while (L<R)
        {
            int tmp = array[L]+array[R];
            if(tmp == sum)
            {
                res.add(array[L]);
                res.add(array[R]);
                break;
            }
            else if(tmp < sum)
            {
                L++;
            }else
            {
                R--;
            }

        }
        return res;
    }
}
