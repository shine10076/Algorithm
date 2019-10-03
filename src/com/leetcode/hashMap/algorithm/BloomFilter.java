package com.leetcode.hashMap.algorithm;

/**
 * @author shine10076
 * @date 2019/9/21 20:36
 */
public class BloomFilter {

    public static void main(String[] args) {

        int[] arr = new int[1000]; //32000

        int index = 30000;

        int intIndex = index/32;

        int bitIndex = index%32;

        /**
         * 涂黑对应位置的bit
         */
        arr[intIndex] = (arr[intIndex])|(1<<bitIndex);

    }
}
