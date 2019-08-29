package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/24 14:04
 */
public class 正则表达式匹配 {

    public boolean match(char[] s, char[] p)
    {
        /**
         * 这里isMatch[i][j]代表着str[i]和pattern[j]是否匹配
         */
        int m = s.length, n = p.length;
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;
        for(int j=1;j<=n;j++)
        {
            if(p[j-1]=='*')
            {
                /**
                 * 星号不会第一个出现
                 */
                dp[0][j]=dp[0][j-2];
            }
        }


        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(p[j-1]=='.' || p[j-1]==s[i-1])
                {
                    dp[i][j] = dp[i-1][j-1];
                }else if(p[j-1]=='*')
                {
                    if(p[j-2]=='.' || p[j-2]==s[i-1])
                    {
                        dp[i][j] = dp[i-1][j] | dp[i][j-1] |dp[i][j-2];
                    }
                    else
                    {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }


            return dp[m][n];

    }
}
