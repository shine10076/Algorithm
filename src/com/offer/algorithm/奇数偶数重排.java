package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/7/9 19:44
 */
public class 奇数偶数重排 {

    public static void reOrderArray(int [] array) {
        if(array == null || array.length < 2)
        { return ;}
        for(int i=array.length-1;i>0;i--)
            for (int j=0;j<i;j++)
            {
                if(array[j]%2==0 && array[j+1]%2==1)
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1]=temp;
                }
            }

            return;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8};
        reOrderArray(array);
        for (int num : array)
        {
            System.out.print(num+" ");
        }
    }
}
