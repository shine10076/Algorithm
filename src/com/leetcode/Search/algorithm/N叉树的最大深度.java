package com.leetcode.Search.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/7/15 20:48
 */
public class N叉树的最大深度 {

    /**
     * BFS 广度优先遍历解决，但是最好用递归法解决
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty())
        {
            /**
             * 每次加入一层的节点
             */
            List<Node> nodeList = new ArrayList<>();
            while(!queue.isEmpty()) {
                nodeList.add(queue.poll());
            }
            for(Node node : nodeList)
            {
                for(Node child:node.children)
                {
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};