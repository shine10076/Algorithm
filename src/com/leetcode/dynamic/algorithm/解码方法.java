package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/8/31 9:24
 */
public class 解码方法 {

    public static int numDecodings(String s) {
            if(s==null || s.length() == 0 ) return 0;
            int len = s.length();
            int[] res = new int[len+1];
            res[0]=1;
            if(s.charAt(0)=='0')
            {
                res[1]=0;
            }else
            {
                res[1]=1;
            }
            for(int i=1;i<len;i++)
            {
                String code = s.substring(i-1,i+1);
                int value = Integer.parseInt(code);
                if(s.charAt(i)!='0')
                {
                    res[i+1] += res[i];
                }
                if(value<=26&&value>0&&s.charAt(i-1)!='0')
                {
                    res[i+1] += res[i-1];
                }
            }
            return res[len];
    }

    public static void main(String[] args) {
        String s = "10101010";
        System.out.println(numDecodings(s));
    }
}
