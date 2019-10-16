package com.leetcode.tree.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/10/7 10:19
 */
public class 二叉树的层次遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty())
        {
            Queue<TreeNode> cur = new LinkedList<>();
            while (!queue.isEmpty())
            {
                cur.offer(queue.poll());
            }

            ArrayList<Integer> list = new ArrayList<>();

            while (!cur.isEmpty())
            {
                TreeNode tmp = cur.poll();
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
                list.add(tmp.val);
            }

            res.add(list);
        }
        return res;
    }
}
