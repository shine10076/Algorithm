package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/8/1 13:54
 */
public class 从上往下打印二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root== null) return res;

        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            res.add(node.val);
            if(node.left!=null)
            {
                queue.offer(node.left);
            }
            if(node.right != null)
            {
                queue.offer(node.right);
            }
        }

        return res;
    }
}
