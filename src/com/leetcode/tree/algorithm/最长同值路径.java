package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/15 21:59
 */
public class 最长同值路径 {
    int path;
    public int longestUnivaluePath(TreeNode root) {
        path = 0;
        dfs(root);
        return path;
    }

    public int dfs(TreeNode root)
    {
        if(root == null)  return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftArrow = 0, rightArrow = 0;
        if(root.left != null && root.left.val == root.val)
            leftArrow +=left + 1;
        if(root.right != null && root.right.val == root.val)
            rightArrow += right + 1;
        path = Math.max(path, leftArrow + rightArrow);
        return Math.max(leftArrow,rightArrow);
    }
}
