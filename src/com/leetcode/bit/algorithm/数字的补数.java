package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/3 20:12
 */
public class 数字的补数 {

    public int findComplement(int num) {
        if(num == 0) return 1;
        int mask = 1<<30;
        while((num&mask) == 0){
            mask=mask>>1;
        }
        mask =(mask<<1) - 1;
        //这里出现了一个小错误，上面赋值时候忘记加括号了，Java中
        //-的优先级高于<<.
        return num^mask;
    }

    public static void main(String[] args) {
        int  n = 9;
        String res1 = Integer.toBinaryString(n);
        String res2 = Integer.toBinaryString(n&(-n));
        System.out.println(res1);
        System.out.println(res2);
    }
}
