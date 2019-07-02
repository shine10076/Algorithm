package com.sort.algorithm;

/**
 * @author shine10076
 * @date 2019/5/2 14:22
 */
public class SortTest {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int flag = 0;
        for (int e = arr.length - 1; e > 0; e--) {
            flag = 0;
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = 1;
                }

            }
            if (flag == 0) return;
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
