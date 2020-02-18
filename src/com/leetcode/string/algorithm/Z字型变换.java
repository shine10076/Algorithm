package com.leetcode.string.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2020/2/18 11:39
 */
public class Z字型变换 {

    public static String convert(String s, int numRows) {
        if(numRows <= 0){
            return null;
        }
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i< Math.min(s.length(), numRows);i++){
            list.add(new StringBuilder());
        }
        int flag = 1;
        int index = 0;
        for(char c : s.toCharArray()){
            if(index == numRows-1){
                flag = -1;
            }else if(index == 0){
                flag = 1;
            }
            list.get(index).append(c);
            index = index + flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list){
            for(char c :sb.toString().toCharArray()){
                res.append(c);
            }
        }
        return res.toString();
    }


}
