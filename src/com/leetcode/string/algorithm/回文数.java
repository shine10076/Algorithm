package com.leetcode.string.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/7/4 19:06
 */
public class 回文数 {

    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        Stack<Integer> stack = new Stack<>();
        int temp = x;
        while(temp>0)
        {
            int val = temp%10;
            stack.push(val);
            temp = temp/10;
        }
        int y=0;
        int flag = 1;
        while(!stack.isEmpty())
        {
            y += stack.pop()*flag;
            flag *= 10;
        }

        return x == y;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}
