package com.leetcode.string.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/10/3 16:43
 */
public class 报数 {

    public static String countAndSay(int n) {

        Stack<Character> stack = new Stack<>();
        String pre = "1";
        for(int i=1;i<n;i++)
        {
             pre = oneCount(pre);
        }
        return pre;
    }

    public static String oneCount(String pre)
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<pre.length();i++)
        {
            if(stack.isEmpty())
            {
                stack.push(pre.charAt(i));
            }
            else
            {
                if(stack.peek() == pre.charAt(i))
                {
                    stack.push(pre.charAt(i));
                }
                else
                {
                    String size = Integer.toString(stack.size());
                    char c = stack.peek();
                    sb.append(size);
                    sb.append(c);
                    while (!stack.isEmpty())
                    {
                        stack.pop();
                    }
                    stack.push(pre.charAt(i));
                }
            }
        }

        if(!stack.isEmpty())
        {
            char c = stack.peek();
            String size = Integer.toString(stack.size());
            sb.append(size);
            sb.append(c);
        }

        return sb.toString();

    }


    public static void main(String[] args) {

        System.out.println(countAndSay(4));
    }
}
