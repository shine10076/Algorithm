package com.leetcode.tree.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * 2019/11/19 20:48
 */
public class 填充每个节点的下一个右侧节点 {

    public Node connect(Node root) {

        if(root == null ) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Queue<Node> tmp = new LinkedList<>();
            while (queue.size() > 1)
            {
                Node cur = queue.poll();
                cur.next = queue.peek();
                tmp.offer(cur);
            }
            if(!queue.isEmpty()) tmp.offer(queue.poll());

            while (!tmp.isEmpty()){
                Node cur = tmp.poll();
                if(cur.left != null ){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }

        }

        return root;
    }
}
