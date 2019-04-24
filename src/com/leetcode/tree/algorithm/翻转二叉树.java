package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/10 20:52
 */
public class 翻转二叉树 {

    private static TreeNode invertTree(TreeNode root)
    {
        if(root == null) return null;
        else
        {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }
    }
    
}
