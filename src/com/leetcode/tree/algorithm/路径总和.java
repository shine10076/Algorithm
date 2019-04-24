package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/14 17:24
 */
public class 路径总和 {

    private static boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null) return false;
        boolean left = hasPathSum(root.left,sum - root.val);
        boolean right = hasPathSum(root.right,sum-root.val);
        boolean res = (sum==root.val)&(root.right == null)&(root.left == null);
        return left|right|res;
    }



}
