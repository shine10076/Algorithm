package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

/**
 * @author shine10076
 * @date 2019/8/15 14:43
 */
public class 二叉树的深度 {

    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
