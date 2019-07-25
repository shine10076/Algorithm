package com.leetcode.tree.algorithm;


import java.util.HashSet;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/29 14:54
 */
public class 两数之和输入BST {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, HashSet set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) | dfs(root.right, set, k);
    }


}
