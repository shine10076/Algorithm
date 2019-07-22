package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/20 11:24
 */
public class 复原IP地址 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if(s == null || s.length() == 0)
        {
            return res;
        }

        char[] ch = s.toCharArray();
        dfs(ch,0,new ArrayList<String>(),res);

        return res;
    }


    public static void dfs(char[] ch, int index, List<String> sb, List<String> res)
    {
        if(index > ch.length || sb.size() >4 ) return;
        if(sb.size() == 4 && index == ch.length)
        {
            res.add(sb.get(0)+'.'+sb.get(1)+'.'+sb.get(2)+'.'+sb.get(3));
            return ;
        }
        StringBuilder temp = new StringBuilder();
        for(int j=0;j<3;j++)
        {
            if(index+j<ch.length && charToInt(ch,index,index+j))
            {
            temp.append(ch[index+j]);
            sb.add(temp.toString());
            dfs(ch,index+j+1,sb,res);
            sb.remove(sb.size()-1);
            }
        }

    }



    public static boolean charToInt(char[] ch, int start, int end)
    {
        if(ch[start] == '0' && end-start > 0) return false;
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<=end;i++)
        {
            sb.append(ch[i]);
        }
        return Integer.parseInt(sb.toString()) <= 255;
    }


    public static void main(String[] args) {
        String s = "0000";
        List<String> res = restoreIpAddresses(s);
        for(String s1 : res)
        {
            System.out.println(s1);
        }
    }
}
