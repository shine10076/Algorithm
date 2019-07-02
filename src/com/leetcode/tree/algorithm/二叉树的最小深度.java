package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/15 11:15
 */
public class 二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) return left + right + 1;
        return Math.min(left, right) + 1;
    }
}
