package com.leetcode.tree.algorithm;

import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/4/10 19:17
 */
public class 二叉树的最大深度 {

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
