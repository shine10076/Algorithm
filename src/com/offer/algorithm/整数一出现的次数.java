package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/14 16:51
 */
public class 整数一出现的次数 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i=1;i<=n;i++)
        {
            int tmp = i;
            while (tmp>0)
            {
                if(tmp%10 == 1) count++;
                tmp = tmp/10;
            }
        }
        return count;
    }
}
