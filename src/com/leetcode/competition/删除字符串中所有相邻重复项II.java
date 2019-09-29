package com.leetcode.competition;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/9/29 19:54
 */
public class 删除字符串中所有相邻重复项II {
    public static String removeDuplicates(String s, int k) {


        Stack<Pair> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(stack.isEmpty())
            {
                stack.push(new Pair(1,c));
            }
            else{
                if(stack.peek().c == c )
                {
                    stack.peek().count++;
                    if(stack.peek().count == k)
                        stack.pop();
                }
                else
                {
                    stack.push(new Pair(1,c));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty())
        {
            Pair p =stack.pop();
            for(int i=0;i<p.count;i++)
            {
                sb.append(p.c);
            }
        }

        return sb.reverse().toString();
    }



    public static void main(String[] args) {

        String s = "deeedbbcccbdaa";
        System.out.println(removeDuplicates(s,3));
    }
}


    class Pair
    {
        public int count;
        public char c;

        public Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }