package com.leetcode.tree.algorithm;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/4/10 19:31
 */
public class 平衡二叉树 {

    private static boolean result = true;

    private static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) result = false;
        return Math.max(l, r) + 1;
    }
}
