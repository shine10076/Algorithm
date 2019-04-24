package com.leetcode.tree.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/4/17 16:55
 * @leetcode 513
 */
public class 找树左下角的值 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i < size;i++)
            {
                TreeNode node = queue.poll();
                if(i == 0) left = node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return left;
    }

    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            root = queue.poll();
            /*先右后左*/
            if(root.right != null ) queue.offer(root.right);
            if(root.left != null ) queue.offer(root.left);
        }
        return root.val;
    }
}
