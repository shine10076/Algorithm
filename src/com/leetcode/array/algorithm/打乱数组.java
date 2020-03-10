package com.leetcode.array.algorithm;

import java.util.Random;

/**
 * @author shine10076
 * @date 2020/3/10 20:22
 */
public class 打乱数组 {

    private int[] origin;
    private Random random = new Random();

    public 打乱数组(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] copy = origin.clone();
        return copy;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffle = origin.clone();
        Random random = new Random();
        for(int i=0;i<shuffle.length;i++){
            swap(shuffle,i,randomRange(i,shuffle.length));
        }
        return shuffle;
    }

    private void swap(int[] nums, int i, int j){
        if(i==j) return;
        nums[i] = nums[i] ^ nums[j];// a^b b
        nums[j] = nums[j] ^ nums[i];// a^b a
        nums[i] = nums[i] ^ nums[j];// b a
    }

    private int randomRange(int min,int max){
        return random.nextInt(max-min)+min;
    }

    public static void printArray(int[] nums){
        for(int i : nums){
            System.out.printf(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        打乱数组 shuffle = new 打乱数组(nums);
        printArray(shuffle.shuffle());


    }
}
