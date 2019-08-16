package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/15 17:02
 */
public class 扑克牌顺子 {

    public static boolean isContinuous(int [] numbers) {

        if(numbers == null || numbers.length == 0) return false;

        int[] poker =new int[14];
        for(int i : numbers)
        {
            poker[i]++;
        }
        //大小王张数
        int special = poker[0];
        int L = 0, R = 0;
        for(int i=1;i<=13;i++)
        {
            if(poker[i] == 1)
            {
                L = i;
                break;
            }
            if(poker[i]>1) return false;
        }

        for(int i=1;i<=13;i++)
        {
            if(poker[i]==1) R = i;
        }
        int zero = 0;
        for(int i = L; i< R;i++ )
        {
            if(poker[i]==0) zero++;
        }

        return zero<=special;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{
            1,3,2,6,4
        };
        isContinuous(numbers);

    }
}
