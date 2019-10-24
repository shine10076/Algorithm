package com.leetcode.string.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/10/17 14:29
 */
public class 单词拆分 {

    public static boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();
        for(String word : wordDict)
        {
            set.add(word);
        }

        boolean[] isContain = new boolean[s.length()];

        for(int i=0;i<s.length();i++)
        {
            isContain[i] = set.contains(s.substring(0,i+1));
            for(int j=1;j<= i;j++)
            {
                isContain[i] |= (isContain[j-1]&set.contains(s.substring(j,i+1)));
                if(isContain[i]) break;
            }
        }

        return isContain[s.length()-1];
    }

    public static void main(String[] args) {
        String  s = "leetcode";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }
}
