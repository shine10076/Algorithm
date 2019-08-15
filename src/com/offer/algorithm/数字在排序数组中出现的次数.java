package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/15 14:17
 */
public class 数字在排序数组中出现的次数 {

    public static int GetNumberOfK(int [] array , int k) {
        //二分查找
        if(array == null || array.length == 0) return 0;
        if(k<array[0] || k>array[array.length-1]) return 0;

        int r=-1, l=-1;
        int L = 0, R = array.length-1;
        while (L<=R)
        {
            int mid = L + ((R-L)>>1);
            if(array[mid]<k) L = mid+1;
            else if(array[mid]>k) R = mid-1;
            else if((array[mid]==k&&mid-1>=0&&array[mid-1]<k) || mid==0&&array[mid]==k)
            {
                r=mid;
                break;
            }
            else
            {
                R = mid-1;
            }
        }

        L =0;
        R =array.length-1;
        while (L<=R)
        {
            int mid = L + ((R-L)>>1);
            if(array[mid]<k) L = mid+1;
            else if(array[mid]>k) R = mid-1;
            else if((array[mid]==k&&mid+1<array.length&&array[mid+1]>k) || mid==array.length-1&&array[mid]==k)
            {
                l=mid;
                break;
            }
            else
            {
                L = mid+1;
            }
        }

        return (r<0&&l<0)?0:l-r+1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{
                3
        };

        System.out.println(GetNumberOfK(array,3));
    }
}
