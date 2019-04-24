package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/23 22:06
 */
public class 修剪二叉搜索树 {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        /*二叉搜索树，left < root < right*/
        if(root == null ) return null;
        if(root.val < L) return trimBST(root.right,L,R);
        if(root.val > R) return trimBST(root.left,L,R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right,L,R);
        return root;
    }
}
