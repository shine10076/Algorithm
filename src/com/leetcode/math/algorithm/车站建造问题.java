package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2020/7/29 15:34
 */
//题目描述
//        有10^8个村庄排在一条公路上，依次编号为0~10^8-1，相邻村庄距离为1，其中有n个村庄居住着牛牛，居住着牛牛的村庄从小到大依次为a0~an-1，其中保证a0=0.
//        现在需要建设车站，有两个要求必须被满足：
//        1、每个有牛牛居住的村庄必须修建车站。
//        2、相邻车站的距离必须为1或为某个质数。
//        现给出n和a数组，求需要建设车站的最小数量。
public class 车站建造问题 {

    public int work (int n, int[] a) {
        // write code here
        int res = n;
        for(int i = 0; i < a.length-1;i++){
            int distance = a[i+1]-a[i];
            if(distance == 1 || isPrime(distance)){
                continue;
            }else{
                if(distance % 2 == 0){
                    res += 1;
                }else{
                    if(isPrime(distance-2)){
                        res += 1;
                    }else{
                        res += 2;
                    }
                }
            }
        }
        return res;
    }

    private boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        车站建造问题 a = new 车站建造问题();
        System.out.println(a.work(7,new int[]{0,3,10,15,16,24,28}));
    }
}
