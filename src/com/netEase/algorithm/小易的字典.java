package com.netEase.algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/9/25 10:34
 */
public class 小易的字典 {

    public static void dictionaryRank(int n, int m, int k)
    {
        int base = m+1;
        Stack<Integer> stack = new Stack<>();
        k = k-1;
        while (k>0)
        {
            int bit = k%base;
            stack.push(bit);
            k = k/base;
        }

        if(stack.size()>n+1)
        {
            System.out.println(-1);
            return;
        }
        while (stack.size()<=n) stack.push(0);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!stack.isEmpty())
        {
            int time = stack.pop();
            count += time;
            while (time>0)
            {
                sb.append('z');
                time--;
            }
            sb.append('a');
        }
        while (count < m)
        {
            sb.append('z');
            count++;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();

            dictionaryRank(n,m,k);
        }
    }
}
