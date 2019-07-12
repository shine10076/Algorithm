package com.graph.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/7/12 14:07
 */
public class BFS {

    public static void bfs(Node node)
    {
        if(node == null)
        {
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> map = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty())
        {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts)
            {
                if(!map.contains(next))
                {
                    map.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
