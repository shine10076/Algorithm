package com.leetcode.random.algorithm;

/**
 * @author shine10076
 * @date 2019/6/4 20:38
 */
public class 用Rand7实现Rand10 {
    public static int rand10() {
        /*(rand7()-1)*7 = {0,7,14,21,28,35,42}*/
        /*(rand7()-1)*7 + rand7()覆盖到{1~49}*/
        int res = 0;
        do {
            res = (rand7() - 1) * 7 + rand7() - 1;//0~48
        } while (res >= 40);
        return res % 10 + 1;
    }


    public static int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

}
