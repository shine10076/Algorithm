package com.leetcode.greedy.algorithm;

/**
 * @author shine10076
 * @date 2019/10/22 14:29
 */
public class 跳跃游戏 {
    public static void main(String[] args){
        System.out.print(getNumber(0));
        System.out.print(getNumber(1));
        System.out.print(getNumber(2));
        System.out.print(getNumber(4));
    }

    public static int getNumber(int num){
        try{
            int result = 2 / num;
            return result;
        }catch (Exception exception){
            return 0;
        }finally{
            if(num == 0){
                return -1;
            }
            if(num == 1){
                return 1;
            }
        }
    }
}
