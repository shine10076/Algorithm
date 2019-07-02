package com.leetcode.thought.greedy.algorithm;

/**
 * @author shine10076
 * @date 2019/5/27 16:54
 */
public class 种花问题 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0)
            return false;
        if (flowerbed.length == 1) {
            if ((flowerbed[0] == 0 && (n == 1 || n == 0)) || (flowerbed[0] == 1 && n == 0)) return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (isPlant(flowerbed, i)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }

    private boolean isPlant(int[] flowerbed, int i) {
        if (i == 0) {
            return flowerbed[i] == 0 && flowerbed[i + 1] == 0;
        } else if (i == flowerbed.length - 1) {
            return flowerbed[i] == 0 && flowerbed[i - 1] == 0;
        } else {
            return flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0;
        }
    }
}
