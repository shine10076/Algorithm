package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/15 14:17
 */
public class 左叶子之和 {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val + sumOfLeftLeaves(root.right);
        else
        {
            sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}
