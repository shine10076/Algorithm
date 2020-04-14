package com.leetcode.greedy.algorithm;

/**
 * @author shine10076
 * @date 2020/4/14 11:35
 */
public class 坏了的计算器 {

    public static int brokenCalc(int X, int Y) {
        int res = 0;
        while(X < Y ){
            if(Y%2==0){
                Y = Y>>>1;
            }else {
                Y += 1;
            }
        }
        return res+X-Y;
    }

    public static void main(String[] args) {
        System.out.println(brokenCalc(1,1000000000));
    }
}
