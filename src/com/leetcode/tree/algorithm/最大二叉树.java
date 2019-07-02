package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/7 21:17
 */

/**
 * 题号： 654
 */
public class 最大二叉树 {

    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode res = constructTreeNode(nums, 0, nums.length - 1);
        return res;
    }

    /*递归构造二叉子树*/
    private static TreeNode constructTreeNode(int[] nums, int i, int j) {
        if (i > j) return null;
        else {
            int maxIndex = maxIndex(nums, i, j);
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = constructTreeNode(nums, i, maxIndex - 1);
            root.right = constructTreeNode(nums, maxIndex + 1, j);
            return root;
        }
    }

    private static int maxIndex(int[] nums, int i, int j) {
        int maxIndex = i;
        for (int k = i; k <= j; k++) {
            if (nums[maxIndex] < nums[k]) {
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
    }
}
