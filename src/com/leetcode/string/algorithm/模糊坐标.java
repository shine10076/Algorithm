package com.leetcode.string.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2020/2/20 22:19
 */
public class 模糊坐标 {

    public List<String> ambiguousCoordinates(String S){

        String nums = S.substring(1,S.length()-1);

        return generateArray(nums);
    }

    public List<String> generateArray(String s){

        List<String> res = new ArrayList<>();

        for(int i=1;i<s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i);
            List<String> l = generateParts(left);
            List<String> r = generateParts(right);

            for(String m : l){
                for(String n : r)
                {
                    res.add("("+m+", "+n+")");
                }
            }



        }

        return res;
    }

    public List<String> generateParts(String s){
        List<String> res = new ArrayList<>();
        if(s.length() == 1){
            res.add(s);
            return res;
        }
        for(int i=1;i<s.length();i++){
            String l = s.substring(0,i);
            String r = s.substring(i);
            if(isLeft(l)&&isRight(r) &&!(l.equals("0")&&r.equals("0"))){
                res.add(l+"."+r);
            }
        }

        if(isLeft(s)){
            res.add(s);
        }

        return res;
    }

    public boolean isLeft(String l){
        if(l.startsWith("0") && l.length() > 1){
            return false;
        }
        return true;
    }

    public boolean isRight(String r){
        if(r.endsWith("0")){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        String s = "(00011)";
        String sub = "012";
        模糊坐标 ab = new 模糊坐标();
        for(String i : ab.ambiguousCoordinates(s)){
            System.out.println(i);
        }
    }

}
