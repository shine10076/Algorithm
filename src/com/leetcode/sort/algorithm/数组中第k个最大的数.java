package com.leetcode.sort.algorithm;

/**
 * @author shine10076
 * @date 2019/9/19 19:22
 */
public class 数组中第k个最大的数 {

    public static int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0)
        {
            return 0;
        }

        return  kthLargest(nums,0,nums.length-1,nums.length-k+1);

    }

    private static int kthLargest(int[] nums, int L, int R,int k)
    {
        if(L<R)
        {
            int p = partition(nums,L, R);
            if(p==k-1) return nums[p];
            else if (p>k-1)
            {
                return kthLargest(nums,L,p-1,k);
            }else
            {
                return kthLargest(nums,p+1,R,k);
            }
        }
        return nums[L];
    }


    private static void quickSort(int[] nums)
    {

        if(nums == null || nums.length == 0)
        {
            return;
        }

        quickSort(nums,0,nums.length-1);

    }


    public static void quickSort(int[] nums, int L, int R)
    {
        if(L<R)
        {

            int p =partition(nums,L, R);
            partition(nums,L,p-1);
            partition(nums,p+1,R);

        }
    }

    private static int partition(int[] nums, int L, int R) {
        int i = L, j = R;
        int start = nums[L];

        while (i < j) {

            while (nums[j] >= start && i < j) j--;
            swap(nums,i,j);

            while (nums[i] <= start && i < j) i++;

            swap(nums,i,j);
        }

        return i;
    }

    private static void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,9,10,13,2,11,15};

        System.out.println(findKthLargest(nums,5));
//        quickSort(nums);
//
//        for(int i : nums)
//        {
//            System.out.println(i + " ");
//        }
    }
}
