package com.leetcode.array.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/10/15 20:48
 */
public class 找到所有数组中消失的数字 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while (index < nums.length)
        {

            /**
             * index ： 下标
             * nums[index] : 实际的值
             * 采用归位的方法，
             */
            if(nums[index] != index+1)
            {

                if(nums[nums[index]-1] == (nums[index]))
                {
                    index++;
                }
                else
                {
                    swap(nums,index,nums[index]-1);
                }
            }
            else
            {
                index++;
            }
        }


        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] != (i+1))
            {
                list.add(i+1);
            }
        }

        return list;
    }

    public void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
