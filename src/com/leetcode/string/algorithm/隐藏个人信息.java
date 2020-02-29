package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2020/2/29 19:43
 */
public class 隐藏个人信息 {

    public static String maskPII(String S) {
        if(S.contains("@")){

            String[] info = S.split("@");
            StringBuilder res = new StringBuilder();
            //隐藏name1
            res.append(info[0].charAt(0));
            res.append("*****");
            res.append(info[0].charAt(info[0].length()-1));
            res.append("@");
            //添加name2，name3
            res.append(info[1]);
            return res.toString().toLowerCase();
        }else {
            char[] numbers = S.toCharArray();
            StringBuilder res = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for(int i= 0;i<numbers.length;i++){
                if(Character.isDigit(numbers[i])){
                    sb.append(numbers[i]);
                }
            }
            if(sb.length() == 10){
                res.append("***-***-");
                res.append(sb.subSequence(sb.length()-4,sb.length()));
            }else {
                int count = sb.length()-10;
                res.append("+");
                for(int i=0;i<count;i++){
                    res.append("*");
                }
                res.append("-***-***-");
                res.append(sb.subSequence(sb.length()-4,sb.length()));
            }

            return res.toString();
        }
    }

    public static void main(String[] args) {
        String S = "86-(10)12345678";
        System.out.println(maskPII(S));

    }

}
