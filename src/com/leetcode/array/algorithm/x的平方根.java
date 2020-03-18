package com.leetcode.array.algorithm;

import java.util.concurrent.TimeUnit;

/**
 * @author shine10076
 * @date 2020/3/16 11:14
 */
public class x的平方根 {

    public static int mySqrt(int x) throws InterruptedException {
        if(x <= 1) return x;
        int left = 0, right = x;
        //采用left < right ，退出循环时left == right
        //这里取右中位数
        while(left < right){
            int mid = (left+right)>>>1;
            //最后left=right时满足left*left>x
            if(mid > x/mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left-1;
    }

    public static void main(String[] args) {
        try{
            System.out.println(mySqrt(66));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
