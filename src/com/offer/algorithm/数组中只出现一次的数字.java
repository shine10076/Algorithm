package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/15 14:58
 */
public class 数组中只出现一次的数字 {


    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        for(int i : array)
        {
            diff ^= i;
        }

        int mask = diff & (-diff);

        for(int i :array)
        {
            if((i&mask)== 0) num1[0] ^= i;
            else num2[0] ^= i;
        }
        return;
    }



    //数字和相反数与得到一个二进制位最右边一位为1的数字;
    public static void main(String[] args) {

        int diff = 29;
        diff &= -diff;
        System.out.println(diff);
    }
}
