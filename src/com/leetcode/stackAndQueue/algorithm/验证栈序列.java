package com.leetcode.stackAndQueue.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * 2019/12/3 20:33
 */
public class 验证栈序列 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        if(pushed.length < 1) return true;

        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;

        while (i < pushed.length && j < popped.length){
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && j < popped.length&& stack.peek() == popped[j]){
                stack.pop();
                j++;
            }

        }

        while (!stack.isEmpty() && j < popped.length&& stack.peek() == popped[j]){
            stack.pop();
            j++;
        }

        return i==j;

    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] poped = new int[]{4,5,3,2,1};

        System.out.println(validateStackSequences(pushed,poped));

    }
}
