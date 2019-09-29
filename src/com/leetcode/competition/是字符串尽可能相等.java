package com.leetcode.competition;

/**
 * @author shine10076
 * @date 2019/9/29 19:33
 */
public class 是字符串尽可能相等 {

    public static int equalSubstring(String s, String t, int maxCost) {

        int[] diff = new int[s.length()];

        for(int i=0;i<diff.length;i++)
        {
            diff[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }

        int res = 0;
        for(int i=0;i<diff.length;i++)
        {
            int cost = maxCost;
            int len = 0;
            for(int j=i; j<diff.length ;j++)
            {
                if(cost>=diff[j])
                {
                    cost -= diff[j];
                    len++;
                }
                else
                {
                    break;
                }
            }
            res = Math.max(res,len);
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(equalSubstring("krrgw","zjxss",19));
    }
}
