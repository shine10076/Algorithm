package com.leetcode.string.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/10/16 15:13
 */
public class 字符串解码 {

    public static String decodeString(String s) {

        Stack<Character> stack = new Stack<>();
        char[] letter = s.toCharArray();
        for(char c: letter)
        {
            if(c == ']')
            {
                StringBuilder cur = new StringBuilder();

                /**
                 * 拿出括号里的字符
                 */
                while (!stack.isEmpty())
                {
                    if(stack.peek() == '[')
                    {
                        stack.pop();
                        break;
                    }else
                    {
                        cur.append(stack.pop());
                    }

                }
                StringBuilder time = new StringBuilder();
                while (!stack.isEmpty())
                {
                    if(Character.isDigit(stack.peek()))
                    {
                        time.append(stack.pop());
                    }else
                    {
                        break;
                    }
                }
                StringBuilder tmp = new StringBuilder();
                String curStr = cur.reverse().toString();
                int count = Integer.parseInt(time.reverse().toString());
                for(int i=0;i<count;i++)
                {
                    tmp.append(curStr);
                }
                for(char c1 : tmp.toString().toCharArray())
                {
                    stack.push(c1);
                }
            }
            else
            {
                stack.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
        {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String  s = "100[leetcode]";

        System.out.println(decodeString(s));
    }
}
