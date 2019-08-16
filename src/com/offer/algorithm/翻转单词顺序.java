package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/15 16:50
 */
public class 翻转单词顺序 {

    public String ReverseSentence(String str) {
        if(str == null ) return null;
        if(str.trim().equals(""))
        {
            return str;
        }

        String[] letter = str.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i=letter.length-1;i>=0;i--)
        {
            if(i == 0)
            {
                res.append(letter[i]);
            }
            else
            {
                res.append(letter[i]+" ");
            }
        }
        return res.toString();
    }
}
