package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/19 20:02
 */
public class 电话号码的字母组合 {

    public  static String[] dictionary = new String[]{
            "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
        {
            return res;
        }
        char[] num = digits.toCharArray();
        dfs(num,0,new StringBuilder(),res);
        return res;

    }

    public static void dfs(char[] num, int index, StringBuilder sb, List<String> res)
    {
        for(int i=index;i<num.length;i++)
        {
            char[] dic = dictionary[num[i]-'2'].toCharArray();
            for(int j=0;j<dic.length;j++)
            {
                sb.append(dic[j]);
                if(sb.length() == num.length)
                {
                    res.add(sb.toString());
                }
                dfs(num,i+1,sb,res);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }

    public static void main(String[] args) {
        String digits = "234";
        List<String> res = letterCombinations(digits);
        for(String s:res)
        {
            System.out.println(s);
        }
    }


}
