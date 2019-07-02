package com.leetcode.competition;

/**
 * @author shine10076
 * @date 2019/4/28 10:31
 * java对基本类型不能交换函数
 */
public class 移动石子直到连续 {
    public static int[] numMovesStones(int a, int b, int c) {
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (a > c) {
            temp = a;
            a = c;
            c = temp;
        }
        if (b > c) {
            temp = b;
            b = c;
            c = temp;
        }
        if (a < b && b < c) {
            int max = 0, min = 0;
            if (b - a == 2 || c - b == 2) min = 1;
            else {
                if (b - a > 1) min++;
                if (c - b > 1) min++;
            }

            while (b - a > 1) {
                a++;
                max++;
            }
            while (c - b > 1) {
                c--;
                max++;
            }
            return new int[]{min, max};
        } else {
            return new int[]{0, 0};
        }
    }

    public static void main(String[] args) {
        int[] a = numMovesStones(3, 5, 1);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
}
