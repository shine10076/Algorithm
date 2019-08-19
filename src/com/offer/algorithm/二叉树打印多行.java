package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/8/19 15:53
 */
public class 二叉树打印多行 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(pRoot == null) return res;
        queue.offer(pRoot);
        while (!queue.isEmpty())
        {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> tmp = new LinkedList<>();
            while(!queue.isEmpty())
            {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) tmp.offer(cur.left);
                if(cur.right != null) tmp.offer(cur.right);

            }
            res.add(list);
            while (!tmp.isEmpty())
            {
                queue.offer(tmp.poll());
            }
        }

        return res;

    }
}
