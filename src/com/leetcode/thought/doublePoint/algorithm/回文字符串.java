package com.leetcode.thought.doublePoint.algorithm;

/**
 * @author shine10076
 * @date 2019/5/21 15:47
 */
public class 回文字符串 {

    public boolean validPalindrome(String s) {
        int L = 0, R = s.length() -1;
        char[] c = s.toCharArray();
        int flag = 1;
        while(L<R)
        {
            if(c[L]!=c[R])
            {
                /**
                 * TODO: 可以改成判断L到delete之前是否为回文字符
                 */
                return isVaildByDelete(c,L) || isVaildByDelete(c,R);
            }
            L++;
            R--;
        }
        return true;
    }

    private boolean isVaildByDelete(char[] c, int delete)
    {
        int L = 0, R = c.length-1;
        while(L<R)
        {
            if(L==delete) L++;
            else if(R == delete) R--;
            if(L < R)
            {
               if(c[L] != c[R])
               {return false;}
            }
            L++;
            R--;
        }
        return true;
    }
}
