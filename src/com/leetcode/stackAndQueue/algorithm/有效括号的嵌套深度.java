package com.leetcode.stackAndQueue.algorithm;

/**
 * @author shine10076
 * @date 2020/4/1 10:14
 */
public class 有效括号的嵌套深度 {

    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0;
        int index = 0;
        int[] res = new int[seq.length()];
        while (index < seq.length()){
            if(seq.charAt(index) == '('){
                depth++;
                res[index++] = depth%2;

            }else {
                res[index++] = depth%2;
                depth--;
            }
        }
        return res;
    }
}
