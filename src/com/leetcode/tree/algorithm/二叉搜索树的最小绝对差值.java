package com.leetcode.tree.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/30 13:19
 */
public class 二叉搜索树的最小绝对差值 {

    TreeNode preNode = null;
    int minAbsDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {

        preOrder(root);
        return minAbsDiff;
    }

    public void preOrder(TreeNode root){
        if(root == null ) return;
        preOrder(root.left);

        if(preNode != null){
            int diff = Math.abs(preNode.val - root.val);
            minAbsDiff = Math.min(diff,minAbsDiff);
        }

        preNode = root;
        preOrder(root.right);

    }
}
