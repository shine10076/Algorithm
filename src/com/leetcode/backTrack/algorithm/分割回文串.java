package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/26 19:25
 */
public class 分割回文串 {

    public static List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        if(s == null || s.length() == 0)
        {
            return res;
        }


        dfs(s,0,new ArrayList<String>(),res);

        return res;


    }


    public static void dfs(String s,int start, List<String> list, List<List<String>> res)
    {
        if(start == s.length())
        {
            res.add(new ArrayList<>(list));
            return ;
        }

        for(int i = start; i<s.length();i++)
        {
            if(isWhisper(s,start,i))
            {
                list.add(whisperString(s,start,i));
                dfs(s,i+1,list,res);
                list.remove(list.size()-1);
            }
        }
    }

    public static boolean isWhisper(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static String whisperString(String s, int start, int end)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<=end;i++)
        {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


}
