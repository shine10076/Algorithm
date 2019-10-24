package com.array.algorithm;

import java.util.LinkedList;

/**
 * @author shine10076
 * @date 2019/10/24 15:50
 */
public class AllLessNumSubArray {

    public static int getNum(int[] arr, int num)
    {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }

        LinkedList<Integer> minQueue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        while (L < arr.length)
        {
            while (R < arr.length)
            {
                 while (!minQueue.isEmpty() && arr[minQueue.peekLast()]>=arr[R])
                 {
                     minQueue.pollLast();
                 }
                 minQueue.addLast(R);
                 while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()]<=arr[R])
                 {
                     maxQueue.pollLast();
                 }
                 maxQueue.addLast(R);
                 if(arr[maxQueue.getFirst()]-arr[minQueue.getFirst()] > num)
                 {
                     break;
                 }
                 R++;
            }
            if(minQueue.peekFirst() == L)
            {
                minQueue.pollFirst();
            }
            if(maxQueue.peekFirst() == L)
            {
                maxQueue.pollFirst();
            }
            res += R-L;
            L++;
        }

        return res;
    }
}
