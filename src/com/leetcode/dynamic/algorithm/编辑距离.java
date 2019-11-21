package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * 2019/11/21 15:12
 */
public class 编辑距离 {

    // TODO : 优化为两行dp;
    public int minDistance(String word1, String word2) {

        if(word1.length()==0&&word2.length()==0) return 0;

        /**
         * dp[i][j] : word1[1..i] 和 word2[1..j] 之间的距离
         * if(word1[i]==word2[j])
         * dp[i][j] = 1 + min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]-1};
         * else
         * dp[i][j] = 1 + min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]};
         */
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        /*当i==0*/
        for(int j=0;j<=word2.length();j++){
            dp[0][j] = j;
        }
        /*当j==0*/
        for(int i=0;i<=word1.length();i++){
            dp[i][0] = i;
        }

        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){

                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]-1));
                }else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }

        return dp[word1.length()][word2.length()];

    }
}
