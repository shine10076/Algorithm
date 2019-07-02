package com.leetcode.thought.doublePoint.algorithm;

/**
 * @author shine10076
 * @date 2019/5/20 16:54
 */
public class 反转字符串中元音字母 {

    public static String reverseVowels(String s) {
        char[] res = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (!isVowel(res[i]) && i < s.length() - 1) i++;
            while (!isVowel(res[j]) && j > 0) j--;
            if (i < j) {
                char tmp = res[i];
                res[i] = res[j];
                res[j] = tmp;
                i++;
                j--;
            }

        }
        return new String(res);
    }

    private static boolean isVowel(char i) {
        if (i == 'a' || i == 'A'
                || i == 'e' || i == 'E'
                || i == 'i' || i == 'I'
                || i == 'o' || i == 'O'
                || i == 'u' || i == 'U')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = ".,";
        System.out.println(reverseVowels(s));
    }
}
