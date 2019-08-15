package com.offer.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shine10076
 * @date 2019/8/15 9:59
 */
public class 把数组排序成最小的数 {

    public static String PrintMinNumber(int [] numbers) {

        Integer[] duplicate = new Integer[numbers.length];
        for(int i = 0; i < numbers.length;i++)
        {
            duplicate[i] = numbers[i];
        }
        Arrays.sort(duplicate, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                String ab = Integer.toString(o1)+Integer.toString(o2);
                String ba = Integer.toString(o2)+Integer.toString(o1);

                Integer AB = Integer.parseInt(ab);
                Integer BA = Integer.parseInt(ba);

                return AB-BA;
            }
        });

        StringBuilder sb = new StringBuilder();

        for(Integer i : duplicate)
        {
            sb.append(i);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{
                3,32,321
        };

        System.out.println(PrintMinNumber(numbers));
    }
}
