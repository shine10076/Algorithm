package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/10 20:03
 */
public class 二叉树的直径 {
    private static int max = 0;
    private static int diameterOfBinaryTree(TreeNode root){
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root)
    {
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        max = Math.max(max, l + r );
        return Math.max(l, r)+1;
    }

}
