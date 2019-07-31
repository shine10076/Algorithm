package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/7/31 11:14
 */
public class 平方数 {


    public boolean isPerfectSquare(int num) {
        //有效的完全平方数满足1+3+5+7+...
        int i=1;
        while(num>0){
            num-=i;
            i+=2;
        }
        return num==0;
    }

}
