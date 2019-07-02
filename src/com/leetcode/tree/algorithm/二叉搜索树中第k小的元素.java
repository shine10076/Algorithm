package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/24 10:03
 * @leetcode 230
 */
public class 二叉搜索树中第k小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        int left = nodeNumber(root.left);
        if (left == k - 1) return root.val;
        else if (left >= k) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - left - 1);
    }

    private int nodeNumber(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        sum = 1 + nodeNumber(root.left) + nodeNumber(root.right);
        return sum;
    }
}
