package com.leetcode.thought.dichotomy.algorithm;

/**
 * @author shine10076
 * @date 2019/6/2 13:44
 */
public class 寻找比目标字母大的最小字母 {

    public static char nextGreatestLetter(char[] letters, char target) {
        int L = 0, R = letters.length - 1;
        char res = 'z';
        boolean flag = false;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (letters[mid] > target) {
                if (letters[mid] <= res) {
                    res = letters[mid];
                    flag = true;
                }
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return flag ? res : letters[0];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'j'));
    }
}
