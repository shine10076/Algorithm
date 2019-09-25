package com.array.algorithm;

/**
 * @author shine10076
 * @date 2019/9/25 21:01
 */
public class 爱生气的书店老板 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int sum = 0;

        for(int i=0;i<X;i++)
        {
            if(grumpy[i]==1)
            {
                sum += customers[i];
            }
        }

        int max = sum;

        for (int i = X; i < customers.length; i++) {

            if(grumpy[i-X] == 1)
            {
                sum -= customers[i-X];
            }
            if(grumpy[i] == 1)
            {
                sum += customers[i];
            }
            max = Math.max(sum,max);
        }

        for(int i=0;i<customers.length;i++)
        {
            if(grumpy[i]==0)
            {
                max += customers[i];
            }
        }

        return max;
    }
}