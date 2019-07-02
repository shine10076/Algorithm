package com.leetcode.tree.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/30 13:19
 */
public class 二叉搜索树的最小绝对差值 {

    public int getMinimumDifference(TreeNode root) {
        /*中序遍历是有序的*/
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int num = Math.abs(list.get(i) - list.get(i - 1));
            if (num < min) min = num;
        }
        return min;
    }
}
