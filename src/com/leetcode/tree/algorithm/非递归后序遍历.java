package com.leetcode.tree.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/4/22 14:33
 */
public class 非递归后序遍历 {
    /**
     * 前序遍历的顺序是root->left->right,后序遍历的顺序是left->right->root,
     * 只要把前序改成root->right->left，然后再倒转一下就可以得到后序
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        Collections.reverse(list);
        return list;
    }
}
