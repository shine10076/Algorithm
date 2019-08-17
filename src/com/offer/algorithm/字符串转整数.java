package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/16 15:57
 */
public class 字符串转整数 {

    public static int StrToInt(String str) {
        if(str.length() == 0) return 0;
        char[] nums = str.toCharArray();

        int i = 0, flag=1;
        double sum = 0;

        while(i<nums.length && nums[i] == ' ')//清除空格
        {
            i++;
        }
        if(i<nums.length && nums[i] == '+')
        { flag = 1; i++;}
        else if(i<nums.length && nums[i] == '-')
        { flag = -1; i++;}
        else {}

        while(i < nums.length && (nums[i]>='0'&&nums[i]<='9')) {
            sum = sum*10 + nums[i]-'0';
            i++;
        }

        if(i<nums.length ) return 0;

        sum*= flag;

        if(sum>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sum<Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int)sum;
    }

    public static void main(String[] args) {
        String str = "1a33";

        System.out.println(StrToInt(str));
    }
}
