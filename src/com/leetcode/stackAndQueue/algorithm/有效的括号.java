package com.leetcode.stackAndQueue.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/5/13 11:16
 */
public class 有效的括号 {

    public boolean isValid(String s) {
        if (s == null) return true;
        Stack<Character> stack = new Stack<>();
        char[] sb = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sb[i] == '(' || sb[i] == '{' || sb[i] == '[') {
                stack.push(sb[i]);
            } else if (sb[i] == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            } else if (sb[i] == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            } else if (sb[i] == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
