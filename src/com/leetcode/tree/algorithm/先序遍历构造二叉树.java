package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/7 21:54
 */
public class 先序遍历构造二叉树 {

    private static int i = 0;
    private static TreeNode bstFromPreorder(int[] preorder)
    {   TreeNode root = constructTreeNode(preorder, Integer.MAX_VALUE);
        return root;
    }

    private static TreeNode constructTreeNode(int[] preorder, int bound)
    {
        if(i == preorder.length || preorder[i] > bound)
        {return null;}
        else
        {
            TreeNode root = new TreeNode(preorder[i++]);
            root.left = constructTreeNode(preorder, root.val);
            root.right = constructTreeNode(preorder, bound);
            return root;
        }
    }
}
