package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2020/6/3 18:53
 */
public class 新21点 {


    public static double new21Game(int N, int K, int W) {
        if(K+W < 1) return 1d;
        //dp[i] 表示从i分开始游戏获胜的概率
        double[] dp = new double[K+W];
        for(int i=K;i<=N&&i<K+W;i++){
            dp[i] = 1d;
        }
        double sum = 0;
        for(int i=K;i<K+W;i++) sum += dp[i];// K,K+1,...,K+W-1
        for(int i=K-1;i>=0;i--){
            dp[i] = sum/W;
            sum = sum-dp[i+W]+dp[i];
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new21Game(21,17,10));
    }
}
