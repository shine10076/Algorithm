package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/4/7 20:45
 */
public class 替换空格 {

    private static String solution(StringBuffer str) {
        StringBuilder res = new StringBuilder();
        char[] strArray = str.toString().toCharArray();
        for (char i : strArray) {
            if (i != ' ') {
                res.append(i);
            } else {
                res.append("%20");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("We Are Happy");
        System.out.println(solution(str));


    }
}
