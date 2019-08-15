package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/15 11:00
 */
public class 数组中的逆序对 {

    public int InversePairs(int [] array) {

        if(array == null || array.length == 0)
        {
            return 0;
        }

        return Inverse(array,0,array.length-1)%1000000007;
    }

    public int Inverse(int[] array, int L, int R)
    {
        if(L<R)
        {
            int mid = L + ((R-L)>>1);
            int a = Inverse(array,L,mid)%1000000007;
            int b = Inverse(array,mid+1,R)%1000000007;
            int c = merge(array,L,mid,R)%1000000007;
            return a+b+c;
        }
        return 0;
    }

    public int merge(int[] array, int L, int mid,int R)
    {
        int res = 0;
        int[] tmp = new int[R-L+1];
        int p1 = mid;
        int p2 = R;
        int p = tmp.length-1;
        while (p1>=L && p2>=mid+1)
        {
            if(array[p1]>array[p2])
            {
                res += p2-mid;
                if(res>1000000007) res = res%1000000007;
                tmp[p--] = array[p1--];
            }
            else
            {
                tmp[p--] = array[p2--];
            }
        }

        while(p1>=L) tmp[p--] = array[p1--];
        while (p2>=mid+1) tmp[p--] = array[p2--];

        for(int i=0;i<tmp.length;i++)
        {
            array[L+i] = tmp[i];
        }
        return res;
    }
}
