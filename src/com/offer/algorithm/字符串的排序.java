package com.offer.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

/**
 * @author shine10076
 * @date 2019/8/14 15:04
 */
public class 字符串的排序 {

    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0) return res;
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        Queue<Character> queue = new LinkedList<>();

        for(char c : ch)
        {
            queue.offer(c);
        }

        dfs(queue,0,new StringBuilder(),res,str.length());

        Collections.sort(res);
        return res;
    }


    public static void dfs(Queue<Character> queue, int index,StringBuilder sb, ArrayList<String> res,int n)
    {
        if(sb.length() == n)
        {
            res.add(sb.toString());
            return;
        }

        char tmp = '*';
        for(int i=index;i<n;i++)
        {
            if(tmp == queue.peek()) {
                tmp = queue.poll();
                queue.offer(tmp);
                continue;
            }
            tmp = queue.poll();
            sb.append(tmp);
            dfs(queue,index+1,sb,res,n);
            sb.deleteCharAt(sb.length()-1);
            queue.offer(tmp);
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        ArrayList<String> res = Permutation(str);

        for(String s : res)
        {
            System.out.println(s);
        }
    }
}
