package com.leetcode.string.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shine10076
 * @date 2020/2/28 16:46
 */
public class 最长特殊序列II {

    public static int findLUSlength(String[] strs) {

        boolean[] isDelete = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(strs[i].equals(strs[j])){
                    isDelete[i] = true;
                    isDelete[j] = true;
                }else if(strs[i].length() < strs[j].length()){

                    if(isSubSeq(strs[j],strs[i])){
                        isDelete[i] = true;
                    }
                }else {
                    if(isSubSeq(strs[i],strs[j])){
                        isDelete[j] = true;
                    }
                }
            }
        }
        int res = -1;
        for(int i=0;i<strs.length;i++){
            if(!isDelete[i]){
                res = Math.max(res, strs[i].length());
            }
        }

        return res;
    }

    private static boolean isSubSeq(String s1, String s2){
        //默认S1长度大于S2
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int index = 0;
        for(int i=0;i<a.length;i++){
            if(a[i] == b[index]){
                index++;
                if(index >= b.length){
                    return true;
                }
            }
        }

        return index>= b.length;
    }


    public static void main(String[] args) {

        String[] strs = new String[]{
                "aaa","aaa","aa"
        };
        System.out.println(findLUSlength(strs));

    }
}
