package com.leetcode.thought.greedy.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shine10076
 * @date 2019/5/27 15:12
 */
public class 根据身高重建队列 {

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
            return people;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int m = people.length;
        boolean[] isFill = new boolean[m];
        int[][] res = new int[m][2];
        for (int i = 0; i < m; i++) {
            push(res, isFill, i, people);
        }
        return res;
    }

    private static void push(int[][] res, boolean[] isFill, int p, int[][] people) {
        int count = people[p][1];
        for (int i = 0; i < res.length; i++) {
            if (!isFill[i] && count == 0) {
                res[i][0] = people[p][0];
                res[i][1] = people[p][1];
                isFill[i] = true;
                break;
            } else if (!isFill[i] || res[i][0] >= people[p][0]) {
                count--;
            } else {
                continue;
            }
        }
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = reconstructQueue(people);
        printArray(res);
    }
}
