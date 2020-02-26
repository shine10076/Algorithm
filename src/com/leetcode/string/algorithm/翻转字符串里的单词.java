package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2020/2/19 21:42
 */
public class 翻转字符串里的单词 {

    public static String reverserWords(String s){
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(int i = words.length-1;i >= 0; i--){
            if(words[i].length() > 0){
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        if(sb.length() > 0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }



    public static void main(String[] args) {

    }
}
