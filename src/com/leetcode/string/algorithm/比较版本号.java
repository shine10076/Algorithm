package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2020/2/27 16:59
 */
public class 比较版本号 {

    public static int compareVersion(String version1, String version2) {

        //正则表达式转义符\\
        String[] V1 = version1.split("\\.");
        String[] V2 = version2.split("\\.");

        int m = V1.length;
        int n = V2.length;

        for(int i = 0;i < Math.min(m,n);i++){

            int a = Integer.parseInt(V1[i]);
            int b = Integer.parseInt(V2[i]);
            if(a > b){
                return 1;
            }else if(a < b){
                return -1;
            }
        }

        if(m > n){

            for(int i=n;i<m;i++){
                int a = Integer.parseInt(V1[i]);
                if(a > 0){
                    return 1;
                }
            }


        }else if(m < n){

            for(int i=m;i<n;i++){
                int b = Integer.parseInt(V2[i]);
                if(b > 0){
                    return -1;
                }
            }

        }else {

        }


        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.0";
        String verison2 = "1";
        System.out.println(compareVersion(version1,verison2));

    }
}
