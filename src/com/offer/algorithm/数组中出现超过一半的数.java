package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/14 15:40
 */
public class 数组中出现超过一半的数 {

    public  int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) return 0;

        int count = 1, res = array[0];
        for(int i=1;i<array.length;i++)
        {
            if(res != array[i])
            {
                count--;
            }
            if(res == array[i]) count++;
            if(count == 0)
            {
                res = array[i];
                count = 1;
            }

        }
            count = 0;
            for(int i : array)
            {
                if(res == i) count++;
            }

            return count>=(array.length/2)?res:0;
    }

}
