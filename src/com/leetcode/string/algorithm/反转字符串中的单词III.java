package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2019/9/27 16:33
 */
public class 反转字符串中的单词III {

    public String reverseWords(String s) {
        String[] words =  s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words)
        {
            StringBuilder tmp = new StringBuilder();
            tmp.append(word);
            tmp.reverse();
            sb.append(tmp);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
